package com.cap.resellers.auction.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record CreateAuctionRequest(@Schema(defaultValue = "LG 냉장고", description = "상품명") String productName,
                                   @Schema(defaultValue = "냉장고/냉동고") String itemType,
                                   @Schema(defaultValue = "파일명.jpeg") List<String> fileNames,
                                   @Schema(defaultValue = "100000", description = "현재 가격") Integer price,
                                   @Schema(defaultValue = "어쩌구 저쩌구", description = "설명") String description,
                                   @Schema(defaultValue = "문이 잘 안열려요.", description = "가격") String defect,
                                   @Schema(defaultValue = "010-0000-0000", description = "연락 수단") String contact,
                                   @Schema(defaultValue = "3",description = "경매 기간") Integer period,
                                   @Schema(defaultValue = "10000", description = "가격 단위") Integer priceUnit,
                                   Long memberId) {
}
