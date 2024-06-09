package com.cap.resellers.auction.dto;

import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.material.model.Material;
import lombok.Builder;

@Builder
public record GetMaterialsAuctionDto(String fileName, String productName, String itemType, Integer nowPrice, String auctionStatus, Long auctionId) {
    public static GetMaterialsAuctionDto of(String fileName, Material material, Integer nowPrice, Auction auction, RegisterAuctionStatus auctionStatus) {
        return GetMaterialsAuctionDto.builder()
                .fileName(fileName)
                .productName(material.getProduct().getName())
                .itemType(material.getItemType().getValue())
                .nowPrice(nowPrice)
                .auctionStatus(auctionStatus.getValue())
                .auctionId(auction.getId())
                .build();
    }
}
