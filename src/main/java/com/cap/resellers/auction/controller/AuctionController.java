package com.cap.resellers.auction.controller;

import com.cap.resellers.auction.dto.request.CreateAuctionRequest;
import com.cap.resellers.auction.service.CreateAuctionService;
import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.material.service.CreateMaterialService;
import com.cap.resellers.material.service.UploadImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "기자재(경매)", description = "Auction API")
public class AuctionController {
    private final CreateAuctionService createAuctionService;
    private final UploadImageService uploadImageService;
    private final CreateMaterialService createMaterialService;

    @PostMapping("/auction")
    @Operation(summary = "경매 생성", description = "경매를 생성합니다, 경매를 생성하는 사람은 항상 member_pk가 1입니다")
    public ApiResponse<ApiResponse.CustomBody<Void>> createAuction(@RequestBody CreateAuctionRequest request) {
        Long memberId = 1L;
        createAuctionService.execute(request, memberId);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
