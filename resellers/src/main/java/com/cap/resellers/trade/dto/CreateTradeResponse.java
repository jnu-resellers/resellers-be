package com.cap.resellers.trade.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CreateTradeResponse(List<BuyProductDto> buyProducts, SellerDto seller, Integer totalPrice) {
    public static CreateTradeResponse of(List<BuyProductDto> buyProducts, SellerDto seller, Integer totalPrice) {
        return CreateTradeResponse.builder()
                .buyProducts(buyProducts)
                .seller(seller)
                .totalPrice(totalPrice)
                .build();
    }
}
