package com.cap.resellers.auction.dto;

import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.material.model.Material;
import lombok.Builder;

@Builder
public record GetMaterialsAuctionDto(String fileName, Long materialId, String productName, String itemType, Integer totalPrice, boolean isSold, Long auctionId) {
    public static GetMaterialsAuctionDto of(String fileName, Material material, Integer totalPrice, Auction auction) {
        return GetMaterialsAuctionDto.builder()
                .fileName(fileName)
                .materialId(material.getId())
                .productName(material.getProduct().getName())
                .itemType(material.getItemType().getValue())
                .totalPrice(totalPrice)
                .isSold(material.getProduct().getIsSold())
                .auctionId(auction.getId())
                .build();
    }
}
