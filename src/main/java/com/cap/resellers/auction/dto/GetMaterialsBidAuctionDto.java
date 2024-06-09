package com.cap.resellers.auction.dto;

import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.material.model.Material;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetMaterialsBidAuctionDto(String fileName, String productName, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul") LocalDateTime deadLine,
                                        String itemType, Integer nowPrice, Integer bidPrice, String auctionStatus, Long auctionId) {
    public static GetMaterialsBidAuctionDto of(String fileName, Material material, Integer nowPrice, Integer bidPrice, Auction auction, BidAuctionStatus auctionStatus) {
        return GetMaterialsBidAuctionDto.builder()
                .fileName(fileName)
                .productName(material.getProduct().getName())
                .itemType(material.getItemType().getValue())
                .nowPrice(nowPrice)
                .bidPrice(bidPrice)
                .deadLine(auction.getDeadline())
                .auctionStatus(auctionStatus.getValue())
                .auctionId(auction.getId())
                .build();
    }
}
