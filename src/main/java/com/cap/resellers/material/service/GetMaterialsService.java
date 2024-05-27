package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.GetMaterialsProductDto;
import com.cap.resellers.material.dto.response.GetMaterialsResponse;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.product.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMaterialsService {
    private final GetImageService getImageService;
    private final MaterialRepository materialRepository;

    public GetMaterialsResponse execute() {
        return GetMaterialsResponse.of(
                materialRepository.findAll().stream()
                        .filter(material -> material.getAuction() == null)
                        .map(material -> {
                            String filename = material.getProduct().getImages().stream().findFirst().get().getFileName();
                            return GetMaterialsProductDto.of(filename, material, totalPrice(material));
                        })
                        .toList()
        );
    }

    private Integer totalPrice(Material material) {
        return material.getProduct().getPrice();
    }


    private Long getImageId(Material material) {
        return material.getProduct().getImages().stream()
                .findFirst()
                .map(Image::getId)
                .orElse(null);
    }

}
