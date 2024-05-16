package com.cap.resellers.trade.dto;

import com.cap.resellers.material.model.Material;
import lombok.Builder;

@Builder
public record SellerDto(String contact) {
    public static SellerDto from(Material material) {
        return SellerDto.builder()
                .contact(material.getContact())
                .build();
    }
}
