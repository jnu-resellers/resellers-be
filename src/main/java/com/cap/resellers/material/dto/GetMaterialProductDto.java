package com.cap.resellers.material.dto;

import com.cap.resellers.product.model.Product;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
@Builder
public record GetMaterialProductDto(List<String> fileNames, Long productId, String productName, Integer price, String description, String defect, boolean isSold) {
    public static GetMaterialProductDto of(List<String> fileNames, Product product) {
        return GetMaterialProductDto.builder()
                .fileNames(fileNames)
                .productId(product.getId())
                .productName(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .defect(product.getDefect())
                .isSold(product.getIsSold())
                .build();
    }
}
