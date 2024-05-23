package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import lombok.Builder;
@Builder
public record GetMaterialResponse(String writer, GetMaterialProductDto product, String contact) {
    public static GetMaterialResponse of(String writer, GetMaterialProductDto product, String contact) {
        return GetMaterialResponse.builder()
                .writer(writer)
                .product(product)
                .contact(contact)
                .build();
    }
}
