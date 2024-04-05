package com.cap.resellers.material.dto;

import com.cap.resellers.material.model.Material;
import lombok.Builder;

import java.util.Optional;

@Builder
public record ProductDto(Optional<String> preSignedUrl, Long id, String title, String jobType, Long totalPrice) {
    public static ProductDto of(Optional<String> preSignedUrl, Material material, Long totalPrice) {
        return ProductDto.builder()
                .preSignedUrl(preSignedUrl)
                .id(material.getId())
                .title(material.getTitle())
                .jobType(material.getTitle())
                .totalPrice(totalPrice)
                .build();
    }
}
