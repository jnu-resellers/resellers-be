package com.cap.resellers.trade.dto.response;

import com.cap.resellers.material.dto.GetMaterialsProductDto;
import com.cap.resellers.trade.dto.GetMaterialsTradeDto;

import java.util.List;

public record GetOwnTradeResponse(List<GetMaterialsTradeDto> materials) {
    public static GetOwnTradeResponse of(List<GetMaterialsTradeDto> materials) {
        return new GetOwnTradeResponse(materials);
    }
}
