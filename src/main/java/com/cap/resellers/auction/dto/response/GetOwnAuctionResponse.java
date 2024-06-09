package com.cap.resellers.auction.dto.response;

import com.cap.resellers.auction.dto.GetMaterialsRegisterAuctionDto;

import java.util.List;

public record GetOwnAuctionResponse(List<GetMaterialsRegisterAuctionDto> materials) {
    public static GetOwnAuctionResponse from(List<GetMaterialsRegisterAuctionDto> materials) {
        return new GetOwnAuctionResponse(materials);
    }
}
