package com.cap.resellers.material.dto;

import com.cap.resellers.material.model.Material;
import lombok.Builder;

@Builder
public record GetMaterialsProductDto(String preSignedUrl, Long id, String productName, String itemType, Integer totalPrice) {
    public static GetMaterialsProductDto of(String preSignedUrl, Material material, Integer totalPrice) {
        return GetMaterialsProductDto.builder()
                .preSignedUrl(preSignedUrl)
                .id(material.getId())
                .productName(material.getProduct().getName())
                .itemType(material.getItemType().getValue())
                .totalPrice(totalPrice)
                .build();
    }
}
