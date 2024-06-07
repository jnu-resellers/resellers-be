package com.cap.resellers.material.dto;

import com.cap.resellers.material.model.Material;
import lombok.Builder;

@Builder
public record GetMaterialsProductDto(String fileName, Long id, String productName, String itemType, Integer totalPrice, boolean isSold, Long tradeId) {
    public static GetMaterialsProductDto of(String fileName, Material material, Integer totalPrice, Long tradeId) {
        return GetMaterialsProductDto.builder()
                .fileName(fileName)
                .id(material.getId())
                .productName(material.getProduct().getName())
                .itemType(material.getItemType().getValue())
                .totalPrice(totalPrice)
                .isSold(material.getProduct().getIsSold())
                .tradeId(tradeId)
                .build();
    }
}
