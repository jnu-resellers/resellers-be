package com.cap.resellers.auction.dto.request;

import lombok.Builder;

public record BidAuctionRequest(
        Long auctionId,
        Integer price,
        Long memberId
) {

    @Builder
    public BidAuctionRequest {
    }

}
