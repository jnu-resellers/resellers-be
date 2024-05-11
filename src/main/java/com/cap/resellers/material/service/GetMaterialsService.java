package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.GetMaterialsProductDto;
import com.cap.resellers.material.dto.response.GetMaterialsResponse;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMaterialsService {
    private final GetImageService getImageService;
    private final MaterialRepository materialRepository;

    public GetMaterialsResponse execute() {
        return GetMaterialsResponse.of(
                materialRepository.findAll().stream()
                        .map(material -> {
                            String preSignedUrl = getImageService.execute(getImageId(material));
                            return GetMaterialsProductDto.of(preSignedUrl, material, totalPrice(material));
                        })
                        .collect(Collectors.toList())
        );
    }

    private Long totalPrice(Material material) {
        return material.getProducts().stream()
                .mapToLong(Product::getPrice)
                .sum();
    }


    private Long getImageId(Material material) {
        return material.getProducts().stream()
                .findFirst()
                .flatMap(product -> product.getImages().stream().findFirst())
                .map(Image::getId)
                .orElse(null);
    }

}
