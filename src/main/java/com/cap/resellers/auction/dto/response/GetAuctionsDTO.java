package com.cap.resellers.auction.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record GetAuctionsDTO(
        List<String> imageNames,
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
