package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.GetMaterialsProductDto;
import com.cap.resellers.material.dto.response.GetMaterialsResponse;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.product.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class GetMaterialsService {
    private final GetImageService getImageService;
    private final MaterialRepository materialRepository;
    @Transactional(readOnly = true)
    public GetMaterialsResponse execute(String sortType) {
        if(sortType == null) {
            return GetMaterialsResponse.of(
                    materialRepository.findAll().stream()
                            .filter(material -> material.getAuction() == null)
                            .sorted(Comparator.comparing(Material::getId).reversed())
                            .sorted(Comparator.comparing(material -> material.getProduct().getIsSold()))
                            .map(material -> {
                                String filename = material.getProduct().getImages().stream().findFirst().get().getFileName();
                                return GetMaterialsProductDto.of(filename, material, totalPrice(material),null);
                            })
                            .toList()
            );
        }
        return GetMaterialsResponse.of(
                materialRepository.findAll().stream()
                        .filter(material -> material.getAuction() == null)
                        .filter(material -> material.getItemType().getValue().equals(sortType))
                        .sorted(Comparator.comparing(Material::getId).reversed())
                        .sorted(Comparator.comparing(material -> material.getProduct().getIsSold()))
                        .map(material -> {
                            String filename = material.getProduct().getImages().stream().findFirst().get().getFileName();
                            return GetMaterialsProductDto.of(filename, material, totalPrice(material),null);
                        })
                        .toList()
        );
    }

    public GetMaterialsResponse executeByMemberId(Long memberId) {
        return GetMaterialsResponse.of(
                materialRepository.findByMemberId(memberId).stream()
                        .sorted(Comparator.comparing(Material::getId).reversed())
                        .map(material -> {
                            String filename = material.getProduct().getImages().stream().findFirst().get().getFileName();
                            return GetMaterialsProductDto.of(filename, material, totalPrice(material),null);
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
