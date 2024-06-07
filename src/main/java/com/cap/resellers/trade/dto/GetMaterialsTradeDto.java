package com.cap.resellers.trade.dto;

import com.cap.resellers.material.model.Material;
import com.cap.resellers.trade.model.Trade;
import lombok.Builder;

@Builder
public record GetMaterialsTradeDto(String fileName, String productName, String itemType, Integer totalPrice, boolean tradeConfirmed, Long tradeId) {
    public static GetMaterialsTradeDto of(String fileName, Material material, Integer totalPrice, Trade trade) {
        return GetMaterialsTradeDto.builder()
                .fileName(fileName)
                .productName(material.getProduct().getName())
                .itemType(material.getItemType().getValue())
                .totalPrice(totalPrice)
                .tradeConfirmed(trade.getConfirm())
                .tradeId(trade.getId())
                .build();
    }
}
