package com.cap.resellers.trade.dto.response;

public record CreateTradeResponse(Long materialId, Long tradeId) {
    public static CreateTradeResponse from(Long materialId, Long tradeId) {
        return new CreateTradeResponse(materialId, tradeId);
    }
}
