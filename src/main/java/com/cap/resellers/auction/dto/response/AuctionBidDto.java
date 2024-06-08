package com.cap.resellers.auction.dto.response;

import java.time.LocalDateTime;

public record AuctionBidDto(
        String nickname,
        Integer price,
        LocalDateTime createdAt) {
    public static AuctionBidDto of(String nickname, Integer price, LocalDateTime createdAt) {
        return new AuctionBidDto(nickname, price, createdAt);
    }
}
