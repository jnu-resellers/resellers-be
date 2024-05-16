package com.cap.resellers.trade.dto;

import com.cap.resellers.material.model.Material;
import com.cap.resellers.product.model.Product;
import lombok.Builder;

@Builder
public record BuyProductDto(String productName, String defect, String description) {
    public static BuyProductDto of(Material material, Product product) {
        return BuyProductDto.builder()
                .productName(product.getName())
                .defect(material.getDefect())
                .description(product.getDescription())
                .build();
    }
}
