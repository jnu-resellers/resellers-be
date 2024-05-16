package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import lombok.Builder;

import java.util.List;
@Builder
public record GetMaterialResponse(String writer, GetMaterialProductDto product) {
    public static GetMaterialResponse of(String writer, GetMaterialProductDto product) {
        return GetMaterialResponse.builder()
                .writer(writer)
                .product(product)
                .build();
    }
}
