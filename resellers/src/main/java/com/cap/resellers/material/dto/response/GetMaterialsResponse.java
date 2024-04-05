package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.GetMaterialsProductDto;
import lombok.Builder;

import java.util.List;

@Builder
public record GetMaterialsResponse(List<GetMaterialsProductDto> materials) {
    public static GetMaterialsResponse of(List<GetMaterialsProductDto> materials) {
        return GetMaterialsResponse.builder()
                .materials(materials)
                .build();
    }
}
