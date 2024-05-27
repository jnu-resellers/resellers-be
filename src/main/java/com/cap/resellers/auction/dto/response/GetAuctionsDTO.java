package com.cap.resellers.auction.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

public record GetAuctionsDTO(
        String imageName,
        String itemType,
        String productName,
        Integer bidCount,
        LocalDateTime startAt,
        LocalDateTime endAt,
        Integer price,
        Long auctionId
) {

    @Builder
    public GetAuctionsDTO {
    }
}
