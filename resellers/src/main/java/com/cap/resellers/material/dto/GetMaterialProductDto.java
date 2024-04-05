package com.cap.resellers.material.dto;

import com.cap.resellers.product.model.Product;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
@Builder
public record GetMaterialProductDto(List<String> preSignedUrl, Long id, String name, Long price, String description) {
    public static GetMaterialProductDto of(List<String> preSignedUrl, Product product) {
        return GetMaterialProductDto.builder()
                .preSignedUrl(preSignedUrl)
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
