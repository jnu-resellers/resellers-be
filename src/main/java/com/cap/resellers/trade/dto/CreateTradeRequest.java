package com.cap.resellers.trade.dto;

import lombok.Builder;

import java.util.List;
@Builder
public record CreateTradeRequest(List<ProductDto> products) {
}
