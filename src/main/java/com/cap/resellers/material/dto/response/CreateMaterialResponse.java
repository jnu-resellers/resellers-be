package com.cap.resellers.material.dto.response;

import lombok.Builder;
import java.util.Map;

public record CreateMaterialResponse(
        Map<Long, String> imageUrlMap
) {
    @Builder
    public CreateMaterialResponse {
    }

    public static CreateMaterialResponse of(Map<Long, String> imageUrlMap) {
        return CreateMaterialResponse.builder()
                .imageUrlMap(imageUrlMap)
                .build();
    }

}
