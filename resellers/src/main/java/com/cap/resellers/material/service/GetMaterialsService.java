package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.ProductDto;
import com.cap.resellers.material.dto.response.GetMaterialResponse;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import com.cap.resellers.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMaterialsService {
    private final ProductRepository productRepository;
    private final GetImageService getImageService;
    private final MaterialRepository materialRepository;

    public GetMaterialResponse execute() {
        return GetMaterialResponse.of(
                materialRepository.findAll().stream()
                        .map(material -> {
                            Optional<String> preSignedUrl = getImageService.execute(getImageId(material));
                            return ProductDto.of(preSignedUrl, material, totalPrice(material));
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
