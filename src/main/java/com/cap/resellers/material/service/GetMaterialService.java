package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.GetMaterialProductDto;
import com.cap.resellers.material.dto.response.GetMaterialResponse;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetMaterialService {
    private final MaterialRepository materialRepository;
    private final GetImageService getImageService;
    @Transactional(readOnly = true)
    public GetMaterialResponse execute(Long materialId) {
        Material material = materialRepository.findById(materialId).orElseThrow(() -> new IllegalArgumentException("Material not found"));
        GetMaterialProductDto dto = getMaterialsProductDtos(material.getProduct());
        return GetMaterialResponse.of(material.getMember().getName(), dto, material.getContact(), materialId, material.getItemType());
    }


    private GetMaterialProductDto getMaterialsProductDtos(Product product) {
        List<String> fileNames = product.getImages().stream()
                .map(Image::getFileName)
                .filter(Objects::nonNull)
                .toList();
        return GetMaterialProductDto.of(fileNames, product);
    }

}
