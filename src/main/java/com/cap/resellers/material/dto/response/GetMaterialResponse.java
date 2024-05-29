package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import com.cap.resellers.material.model.ItemType;
import lombok.Builder;
@Builder
public record GetMaterialResponse(String writer, GetMaterialProductDto product, String contact, Long materialId, String itemType) {
    public static GetMaterialResponse of(String writer, GetMaterialProductDto product, String contact, Long materialId, ItemType itemType) {
        return GetMaterialResponse.builder()
                .writer(writer)
                .product(product)
                .contact(contact)
                .materialId(materialId)
                .itemType(itemType.getValue())
                .build();
    }
}
