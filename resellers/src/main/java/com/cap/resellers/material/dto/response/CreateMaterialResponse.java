package com.cap.resellers.material.dto.response;

import com.cap.resellers.material.dto.CreateMaterialProductDTO;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record CreateMaterialResponse(
        String title,
        String writer,
        List<ProductResponse> products
) {
    @Builder
    public CreateMaterialResponse {
    }

    public static CreateMaterialResponse of(List<CreateMaterialProductDTO> createMaterialProductDTOS, Map<Long, String> imageUrlMap) {
        CreateMaterialProductDTO firstProductDTO = createMaterialProductDTOS.get(0);
        String title = firstProductDTO.title();
        String writer = firstProductDTO.writer();

        List<ProductResponse> productResponses = new ArrayList<>();

        for (CreateMaterialProductDTO productDTO : createMaterialProductDTOS) {
            List<String> productPresignedUrls = new ArrayList<>();
            for (Long imageId : productDTO.imageIds()) {
                String presignedUrl = imageUrlMap.get(imageId);
                if (presignedUrl == null) {
                    throw new IllegalArgumentException("Presigned URL not found for imageId: " + imageId);
                }
                productPresignedUrls.add(presignedUrl);
            }

            ProductResponse productResponse = ProductResponse.builder()
                    .name(productDTO.name())
                    .price(productDTO.price())
                    .description(productDTO.description())
                    .presignedUrls(productPresignedUrls)
                    .build();

            productResponses.add(productResponse);
        }

        return new CreateMaterialResponse(title, writer, productResponses);
    }

}
