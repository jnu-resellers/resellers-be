package com.cap.resellers.auction.controller;

import com.cap.resellers.auction.dto.request.CreateAuctionRequest;
import com.cap.resellers.auction.dto.response.GetAuctionResponse;
import com.cap.resellers.auction.dto.response.GetAuctionsResponse;
import com.cap.resellers.auction.service.CreateAuctionService;
import com.cap.resellers.auction.service.GetAuctionService;
import com.cap.resellers.auction.service.GetAuctionsService;
import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.material.service.CreateMaterialService;
import com.cap.resellers.material.service.UploadImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "기자재(경매)", description = "Auction API")
public class AuctionController {
    private final CreateAuctionService createAuctionService;
    private final GetAuctionService getAuctionService;
    private final GetAuctionsService getAuctionsService;


    @PostMapping("/auction")
    @Operation(summary = "경매 생성", description = "경매를 생성합니다, 경매를 생성하는 사람은 항상 member_pk가 1입니다")
    public ApiResponse<ApiResponse.CustomBody<Void>> createAuction(@RequestBody CreateAuctionRequest request) {
        Long memberId = 1L;
        createAuctionService.execute(request, memberId);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @GetMapping("/auction/{auctionId}")
    @Operation(summary = "경매 조회", description = "경매를 조회합니다")
    public ApiResponse<ApiResponse.CustomBody<Void>> getAuction(@PathVariable Long auctionId) {
        GetAuctionResponse getAuctionResponse = getAuctionService.execute(auctionId);
        return ApiResponseGenerator.success(getAuctionResponse,HttpStatus.OK);
    }

    @GetMapping("/auction")
    @Operation(summary = "경매 목록 조회", description = "경매 목록을 조회합니다")
    public ApiResponse<ApiResponse.CustomBody<Void>> getAuctions() {
        GetAuctionsResponse getAuctionsResponse = getAuctionsService.execute();
        return ApiResponseGenerator.success(getAuctionsResponse,HttpStatus.OK);
    }
}
