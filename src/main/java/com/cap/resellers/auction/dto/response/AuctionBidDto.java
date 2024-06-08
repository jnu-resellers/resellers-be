package com.cap.resellers.auction.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AuctionBidDto(
        String nickname,
        Integer price,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd'T'HH:mm", timezone = "Asia/Seoul")
        LocalDateTime createdAt) {
    public static AuctionBidDto of(String nickname, Integer price, LocalDateTime createdAt) {
        return new AuctionBidDto(nickname, price, createdAt);
    }
}
