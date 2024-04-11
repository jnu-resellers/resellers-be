package com.cap.resellers.trade.dto;

import lombok.Builder;

@Builder
public record BuyProductDto(String productName, Integer price, String description) {
    public static BuyProductDto of(String productName, Integer price, String description) {
        return BuyProductDto.builder()
                .productName(productName)
                .price(price)
                .description(description)
                .build();
    }
}
