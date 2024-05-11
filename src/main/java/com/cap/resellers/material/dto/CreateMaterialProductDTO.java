package com.cap.resellers.material.dto;

import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import lombok.Builder;

import java.util.List;

public record CreateMaterialProductDTO(
        String name,
        List<Long> imageIds
) {
    @Builder
    public CreateMaterialProductDTO {
    }

    public static CreateMaterialProductDTO of(Product product) {
        List<Long> imageIds = product.getImages().stream().map(Image::getId).toList();
        return CreateMaterialProductDTO.builder()
                .name(product.getName())
                .imageIds(imageIds)
                .build();
    }
}

