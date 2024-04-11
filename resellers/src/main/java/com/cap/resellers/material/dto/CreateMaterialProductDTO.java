package com.cap.resellers.material.dto;

import com.cap.resellers.material.model.Material;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import lombok.Builder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public record CreateMaterialProductDTO(
        String title,
        String writer,
        Long productId,
        String name,
        Integer price,
        String description,
        List<Long> imageIds
) {
    @Builder
    public CreateMaterialProductDTO {
    }

    public static CreateMaterialProductDTO of(Material material, Product product) {
        List<Long> imageIds = product.getImages().stream().map(Image::getId).toList();
        return CreateMaterialProductDTO.builder()
                .title(material.getTitle())
                .writer(material.getMember().getName())
                .productId(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imageIds(imageIds)
                .build();
    }
}

