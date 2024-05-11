package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.CreateMaterialProductDTO;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record CreateMaterialResponse(
        List<ProductResponse> products
) {
    @Builder
    public CreateMaterialResponse {
    }

    public static CreateMaterialResponse of(List<CreateMaterialProductDTO> createMaterialProductDTOS, Map<Long, String> imageUrlMap) {
        List<ProductResponse> productResponses = new ArrayList<>();

        for (CreateMaterialProductDTO productDTO : createMaterialProductDTOS) {
            List<String> productPresignedUrls = new ArrayList<>();
            for (Long imageId : productDTO.imageIds()) {
                productPresignedUrls.add(imageUrlMap.get(imageId));
            }
            ProductResponse productResponse = ProductResponse.builder()
                    .name(productDTO.name())
                    .presignedUrls(productPresignedUrls)
                    .build();
            productResponses.add(productResponse);
        }

        return new CreateMaterialResponse(productResponses);
    }

}
