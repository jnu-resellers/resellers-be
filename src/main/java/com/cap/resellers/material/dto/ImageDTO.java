package com.cap.resellers.material.dto;

import com.cap.resellers.material.dto.request.CreateMaterialRequest;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record ImageDTO(
        String fileName,
        Long imageId
) {

    @Builder
    public ImageDTO {
    }

    public static List<ImageDTO> of(CreateMaterialRequest request, List<CreateMaterialProductDTO> createMaterialProductDTOS) {
        List<String> fileNames = request.products().stream()
                .map(product -> product.fileNames())
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<Long> imageIds = createMaterialProductDTOS.stream()
                .flatMap(createMaterialProductDTO -> createMaterialProductDTO.imageIds().stream())
                .collect(Collectors.toList());

        List<ImageDTO> imageDTOs = new ArrayList<>();
        for (int i = 0; i < imageIds.size(); i++) {
            ImageDTO imageDTO = ImageDTO.builder()
                    .fileName(fileNames.get(i))
                    .imageId(imageIds.get(i))
                    .build();
            imageDTOs.add(imageDTO);
        }
        return imageDTOs;
    }
}
