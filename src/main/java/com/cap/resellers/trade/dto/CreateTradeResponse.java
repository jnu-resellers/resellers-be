package com.cap.resellers.trade.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CreateTradeResponse(BuyProductDto buyProducts, SellerDto sellerInfo, Integer totalPrice) {
    public static CreateTradeResponse of(BuyProductDto buyProducts, SellerDto sellerInfo, Integer totalPrice) {
        return CreateTradeResponse.builder()
                .buyProducts(buyProducts)
                .sellerInfo(sellerInfo)
                .totalPrice(totalPrice)
                .build();
    }
}
