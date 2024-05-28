package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import lombok.Builder;
@Builder
public record GetMaterialResponse(String writer, GetMaterialProductDto product, String contact, Long materialId) {
    public static GetMaterialResponse of(String writer, GetMaterialProductDto product, String contact, Long materialId) {
        return GetMaterialResponse.builder()
                .writer(writer)
                .product(product)
                .contact(contact)
                .materialId(materialId)
                .build();
    }
}
