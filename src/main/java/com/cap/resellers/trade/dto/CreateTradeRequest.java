package com.cap.resellers.trade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;
@Builder
public record CreateTradeRequest(@Schema(description = "어떤 상품을 구매하려는지") Long productId,
                                 @Schema(description = "어떤 기자제(게시글)인지") Long materialId,
                                 @Schema(description = "수량") Integer quantity) {
}
