package com.cap.resellers.auction.dto.response;

import com.cap.resellers.auction.model.Auction;

import java.util.List;

public record GetAuctionsResponse(
        List<GetAuctionsDTO> auctions) {
    public static GetAuctionsResponse of(List<Auction> auctions) {
        return new GetAuctionsResponse(auctions.stream()
                .map(auction -> GetAuctionsDTO.builder()
                        .imageNames(auction.getMaterial().getProduct().getImages().stream().map(image -> image.getFileName()).toList())
                        .itemType(auction.getMaterial().getItemType().getValue())
                        .productName(auction.getMaterial().getProduct().getName())
                        .bidCount(auction.getBidCount())
                        .startAt(auction.getStartAt())
                        .endAt(auction.getDeadline())
                        .price(auction.getNowPrice())
                        .auctionId(auction.getId())
                        .build())
                .toList());
    }
}
