package com.cap.resellers.auction.dto.response;

import com.cap.resellers.auction.model.Auction;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record GetAuctionResponse(
        List<String> imageNames,
        String itemType,
        String productName,
        Integer bidCount,
        LocalDateTime startAt,
        LocalDateTime endAt,
        Integer startPrice,
        Integer nowPrice,
        String writer,
        String description,
        String defect

) {

    @Builder
    public GetAuctionResponse {
    }

    public static GetAuctionResponse of(Auction auction) {
        return GetAuctionResponse.builder()
                .imageNames(auction.getMaterial().getProduct().getImages().stream().map(image -> image.getFileName()).toList())
                .itemType(auction.getMaterial().getItemType().getValue())
                .productName(auction.getMaterial().getProduct().getName())
                .bidCount(auction.getBidCount())
                .startAt(auction.getStartAt())
                .endAt(auction.getDeadline())
                .startPrice(auction.getMaterial().getProduct().getPrice())
                .nowPrice(auction.getNowPrice())
                .writer(auction.getMaterial().getMember().getName())
                .description(auction.getMaterial().getProduct().getDescription())
                .defect(auction.getMaterial().getProduct().getDefect())
                .build();
    }
}