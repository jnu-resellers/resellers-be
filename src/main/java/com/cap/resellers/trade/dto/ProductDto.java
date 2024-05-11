package com.cap.resellers.trade.dto;

import lombok.Builder;

@Builder
public record ProductDto(Long productId, Integer quantity) {
    public static ProductDto of(Long productId, Integer quantity) {
        return ProductDto.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}
