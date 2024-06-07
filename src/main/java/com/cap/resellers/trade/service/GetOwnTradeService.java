package com.cap.resellers.trade.service;

import com.cap.resellers.material.model.Material;
import com.cap.resellers.trade.dto.GetMaterialsTradeDto;
import com.cap.resellers.trade.dto.response.GetOwnTradeResponse;
import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOwnTradeService {
    private final TradeRepository tradeRepository;

    public GetOwnTradeResponse execute(Long memberId) {
        List<Trade> trades = tradeRepository.findByBuyerId(memberId);
        return GetOwnTradeResponse.of(
                trades.stream().sorted(Comparator.comparing(Trade::getId).reversed())
                        .map(trade -> {
                            String filename = trade.getMaterial().getProduct().getImages().stream().findFirst().get().getFileName();
                            return GetMaterialsTradeDto.of(filename, trade.getMaterial(), totalPrice(trade.getMaterial()), trade);
                        })
                        .toList()
        );
    }

    private Integer totalPrice(Material material) {
        return material.getProduct().getPrice();
    }
}
