package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.ProductDto;
import lombok.Builder;

import java.util.List;

@Builder
public record GetMaterialResponse(List<ProductDto> materials) {
    public static GetMaterialResponse of(List<ProductDto> materials) {
        return GetMaterialResponse.builder()
                .materials(materials)
                .build();
    }
}
