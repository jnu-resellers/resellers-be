package com.cap.resellers.trade.dto;

import com.cap.resellers.material.model.Material;
import lombok.Builder;

@Builder
public record SellerDto(
        String contact,
        String accountNumber,
        String bankName,
        String name) {
    public static SellerDto from(Material material) {
        return SellerDto.builder()
                .contact(material.getContact())
                .accountNumber(material.getMember().getAccountNumber())
                .bankName(material.getMember().getBankName())
                .name(material.getMember().getName())
                .build();
    }
}
