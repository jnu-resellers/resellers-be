package com.cap.resellers.auction.dto.response;

import com.cap.resellers.auction.dto.GetMaterialsAuctionDto;

import java.util.List;

public record GetOwnAuctionResponse(List<GetMaterialsAuctionDto> materials) {
    public static GetOwnAuctionResponse from(List<GetMaterialsAuctionDto> materials) {
        return new GetOwnAuctionResponse(materials);
    }
}
