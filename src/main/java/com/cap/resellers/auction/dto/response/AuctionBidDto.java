package com.cap.resellers.auction.dto.response;

public record AuctionBidDto(String nickname, Integer price) {
    public static AuctionBidDto of(String nickname, Integer price) {
        return new AuctionBidDto(nickname, price);
    }
}
