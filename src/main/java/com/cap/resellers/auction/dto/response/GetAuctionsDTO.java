package com.cap.resellers.auction.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

public record GetAuctionsDTO(
        String imageName,
        String itemType,
        String productName,
        Integer bidCount,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        LocalDateTime startAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        LocalDateTime endAt,
        Integer price,
        Long auctionId
) {

    @Builder
    public GetAuctionsDTO {
    }
}
