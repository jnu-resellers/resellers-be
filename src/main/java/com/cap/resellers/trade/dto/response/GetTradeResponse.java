package com.cap.resellers.trade.dto.response;

import com.cap.resellers.trade.dto.BuyProductDto;
import com.cap.resellers.trade.dto.SellerDto;
import lombok.Builder;

@Builder
public record GetTradeResponse(BuyProductDto buyProducts, SellerDto sellerInfo, Integer totalPrice) {
    public static GetTradeResponse of(BuyProductDto buyProducts, SellerDto sellerInfo, Integer totalPrice) {
        return GetTradeResponse.builder()
                .buyProducts(buyProducts)
                .sellerInfo(sellerInfo)
                .totalPrice(totalPrice)
                .build();
    }
}
