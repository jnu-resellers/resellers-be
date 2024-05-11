package com.cap.resellers.trade.dto;

import com.cap.resellers.member.model.Member;
import lombok.Builder;

@Builder
public record SellerDto(String bankName, String accountNumber, String sellerName, String contact) {
    public static SellerDto of(Member seller) {
        return SellerDto.builder()
                .bankName(seller.getBankName())
                .accountNumber(seller.getAccountNumber())
                .sellerName(seller.getName())
                .contact(seller.getContact())
                .build();
    }
}
