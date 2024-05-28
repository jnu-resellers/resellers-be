package com.cap.resellers.trade.service;

import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.trade.dto.BuyProductDto;
import com.cap.resellers.trade.dto.SellerDto;
import com.cap.resellers.trade.dto.response.GetTradeResponse;
import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTradeService {
    private final TradeRepository tradeRepository;
    private final MaterialRepository materialRepository;

    public GetTradeResponse execute(Long tradeId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 거래가 존재하지 않습니다."));

        Material material = trade.getMaterial();

        BuyProductDto buyProductDto = BuyProductDto.of(material, trade.getMaterial().getProduct());
        SellerDto sellerDto = SellerDto.from(material);
        int totalPrice = trade.getQuantity() * trade.getMaterial().getProduct().getPrice();
        return GetTradeResponse.of(buyProductDto,sellerDto,totalPrice);
    }
}
