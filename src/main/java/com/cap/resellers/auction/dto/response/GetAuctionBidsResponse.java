package com.cap.resellers.auction.dto.response;

import java.util.List;

public record GetAuctionBidsResponse(List<AuctionBidDto> bids) {
    public static GetAuctionBidsResponse of(List<AuctionBidDto> bids) {
        return new GetAuctionBidsResponse(bids);
    }
}
