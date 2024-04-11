package com.cap.resellers.material.dto;

import com.cap.resellers.material.model.Material;
import lombok.Builder;

import java.util.Optional;

@Builder
public record GetMaterialsProductDto(Optional<String> preSignedUrl, Long id, String title, String itemType, Long totalPrice) {
    public static GetMaterialsProductDto of(Optional<String> preSignedUrl, Material material, Long totalPrice) {
        return GetMaterialsProductDto.builder()
                .preSignedUrl(preSignedUrl)
                .id(material.getId())
                .title(material.getTitle())
                .itemType(material.getTitle())
                .totalPrice(totalPrice)
                .build();
    }
}
