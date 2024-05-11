package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import com.cap.resellers.material.dto.response.GetMaterialResponse;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMaterialService {
    private final MaterialRepository materialRepository;
    private final GetImageService getImageService;

    public GetMaterialResponse execute(Long materialId) {
        Material material = materialRepository.findById(materialId).orElseThrow(() -> new IllegalArgumentException("Material not found"));
        List<GetMaterialProductDto> dtos = material.getProducts().stream()
                .map(this::getMaterialsProductDtos)
                .collect(Collectors.toList());
        return GetMaterialResponse.of(material.getTitle(), material.getMember().getName(), dtos);
    }


    private GetMaterialProductDto getMaterialsProductDtos(Product product) {
        List<String> preSignedUrls = product.getImages().stream()
                .map(image -> getImageService.execute(image.getId()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return GetMaterialProductDto.of(preSignedUrls, product);
    }

}
