package com.cap.resellers.auction.dto.response;

import com.cap.resellers.auction.model.Auction;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record GetAuctionResponse(
        List<String> imageNames,
        String itemType,
        String productName,
        Integer bidCount,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        LocalDateTime startAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
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
