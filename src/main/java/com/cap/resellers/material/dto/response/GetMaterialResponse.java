package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import lombok.Builder;

import java.util.List;
@Builder
public record GetMaterialResponse(String title, String writer, List<GetMaterialProductDto> products) {
    public static GetMaterialResponse of(String title, String writer, List<GetMaterialProductDto> products) {
        return GetMaterialResponse.builder()
                .title(title)
                .writer(writer)
                .products(products)
                .build();
    }
}
