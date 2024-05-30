package com.cap.resellers.trade.service;

import com.cap.resellers.material.model.ItemType;
import com.cap.resellers.trade.dto.TradePriceDto;
import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetTradePriceService {
    private final TradeRepository tradeRepository;

    @Transactional(readOnly = true)
    public List<TradePriceDto> execute(String itemType) {
        ItemType type = ItemType.fromValue(itemType);
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime twelveWeeksAgo = currentDate.minusWeeks(12);

        // 12주 간의 데이터를 한 번에 조회
        List<Trade> trades = tradeRepository.findByItemTypeAndProductCreatedDateBetween(type, twelveWeeksAgo, currentDate)
                .stream().filter(trade -> trade.getConfirm().equals(true)).toList();

        List<TradePriceDto> results = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            LocalDateTime endDateTime = currentDate.minusWeeks(11 - i);
            LocalDateTime startDateTime = endDateTime.minusWeeks(1);

            List<Trade> weeklyTrades = trades.stream()
                    .filter(trade -> !trade.getCreatedDate().isBefore(startDateTime) && !trade.getCreatedDate().isAfter(endDateTime))
                    .toList();

            Optional<TradePriceDto> dto = calculatePriceStats(weeklyTrades, endDateTime);

            if (dto.isEmpty() && !results.isEmpty()) {
                dto = Optional.of(new TradePriceDto(endDateTime, results.get(results.size() - 1).lowest(), results.get(results.size() - 1).average()));
            } else if (dto.isEmpty()) {
                dto = Optional.of(new TradePriceDto(endDateTime, 0L, 0L));
            }

            dto.ifPresent(results::add);
        }

        return results;
    }

    private Optional<TradePriceDto> calculatePriceStats(List<Trade> trades, LocalDateTime endDateTime) {
        if (trades.isEmpty()) {
            return Optional.empty();
        }

        long lowest = trades.stream()
                .mapToLong(trade -> trade.getMaterial().getProduct().getPrice())
                .min()
                .orElse(0);

        double average = trades.stream()
                .mapToLong(trade -> trade.getMaterial().getProduct().getPrice())
                .average()
                .orElse(0);

        return Optional.of(new TradePriceDto(endDateTime, lowest, (long) average));
    }
}