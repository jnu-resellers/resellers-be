package com.cap.resellers.trade.service;

import com.cap.resellers.material.model.ItemType;
import com.cap.resellers.trade.dto.TradePriceDto;
import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetTradePriceService {
    private final TradeRepository tradeRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<TradePriceDto> execute(String itemType) {
        ItemType type = ItemType.fromValue(itemType);
        LocalDate currentDate = LocalDate.now();
        List<TradePriceDto> results = new ArrayList<>();

        for (int i = 0; i < 12; i++) { // 세달간 주별로 조회
            LocalDate endDate = currentDate.minusWeeks(i);
            LocalDate startDate = endDate.minusWeeks(1);
            List<Trade> trades = tradeRepository.findByItemTypeAndProductCreatedDateBetween(type, startDate, endDate);
            Optional<TradePriceDto> dto = calculatePriceStats(trades,endDate);


            if (dto.isEmpty() && !results.isEmpty()) {
                dto = Optional.of(new TradePriceDto(startDate, results.get(results.size() - 1).lowest(), results.get(results.size() - 1).average()));
            } else if (dto.isEmpty()) {
                // 첫 주에 거래 데이터가 없는 경우, 기본값 0으로 설정
                dto = Optional.of(new TradePriceDto(startDate, 0L, 0L));
            }

            dto.ifPresent(results::add);
        }

        return results;
    }

    private Optional<TradePriceDto> calculatePriceStats(List<Trade> trades, LocalDate endDate) {
        if (trades.isEmpty()) {
            return Optional.empty();
        }

        long lowest = trades.stream()
                .mapToLong(trade -> trade.getProduct().getPrice())
                .min()
                .orElseThrow();

        double average = trades.stream()
                .mapToLong(trade -> trade.getProduct().getPrice())
                .average()
                .orElseThrow();

        return Optional.of(new TradePriceDto(endDate, lowest, (long) average));
    }
}