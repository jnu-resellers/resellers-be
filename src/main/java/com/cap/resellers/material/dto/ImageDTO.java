package com.cap.resellers.material.dto;

import com.cap.resellers.product.model.Image;
import lombok.Builder;
import java.util.List;

public record ImageDTO(
        String fileName,
        Long imageId
) {

    @Builder
    public ImageDTO {
    }

    public static List<ImageDTO> of(List<Image> images, List<String> fileNames) {
        List<ImageDTO> imageDTOS = images.stream().map(image -> {
            int index = images.indexOf(image);
            return ImageDTO.builder()
                    .fileName(fileNames.get(index))
                    .imageId(image.getId())
                    .build();
        }).toList();
        return imageDTOS;
    }
}
