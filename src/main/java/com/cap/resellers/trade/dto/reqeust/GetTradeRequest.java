package com.cap.resellers.trade.dto.reqeust;

import lombok.Builder;
@Builder
public record GetTradeRequest(Long materialId, Long tradeId) {
}
