package com.cap.resellers.trade.dto.response;

import com.cap.resellers.trade.dto.BuyProductDto;
import com.cap.resellers.trade.dto.SellerDto;
import lombok.Builder;

@Builder
public record CreateTradeResponse(BuyProductDto buyProducts, SellerDto sellerInfo, Integer totalPrice) {
    public static CreateTradeResponse of(BuyProductDto buyProducts, SellerDto sellerInfo, Integer totalPrice) {
        return CreateTradeResponse.builder()
                .buyProducts(buyProducts)
                .sellerInfo(sellerInfo)
                .totalPrice(totalPrice)
                .build();
    }
}
