package com.cap.resellers.auction.controller;

import com.cap.resellers.auction.dto.request.BidAuctionRequest;
import com.cap.resellers.auction.dto.request.CreateAuctionRequest;
import com.cap.resellers.auction.dto.response.GetAuctionBidsResponse;
import com.cap.resellers.auction.dto.response.GetAuctionResponse;
import com.cap.resellers.auction.dto.response.GetAuctionsResponse;
import com.cap.resellers.auction.dto.response.GetOwnAuctionResponse;
import com.cap.resellers.auction.service.*;
import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
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
    private final BidAuctionService bidAuctionService;
    private final GetAuctionBidsService getAuctionBidsService;


    @PostMapping("/auction")
    @Operation(summary = "경매 생성", description = "경매를 생성합니다, ")
    public ApiResponse<ApiResponse.CustomBody<Void>> createAuction(@RequestBody CreateAuctionRequest request) {
        createAuctionService.execute(request, request.memberId());
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
    public ApiResponse<ApiResponse.CustomBody<Void>> getAuctions(@RequestParam(required = false) String sortType) {
        GetAuctionsResponse getAuctionsResponse = getAuctionsService.execute(sortType);
        return ApiResponseGenerator.success(getAuctionsResponse,HttpStatus.OK);
    }

    @PatchMapping("/auction")
    @Operation(summary = "경매 가격 입찰", description = "경매 입찰하여 가격 수정합니다.")
    public ApiResponse<ApiResponse.CustomBody<Void>> bidAuction(@RequestBody BidAuctionRequest request) {
        Integer nowPrice = bidAuctionService.execute(request);
        return ApiResponseGenerator.success(nowPrice,HttpStatus.OK);
    }

    @GetMapping("/auction/{auctionId}/bid")
    @Operation(summary = "경매 입찰 조회", description = "경매 입찰 목록을 조회합니다")
    public ApiResponse<GetAuctionBidsResponse> getAuctionBids(@PathVariable Long auctionId) {
        GetAuctionBidsResponse response = getAuctionBidsService.getAuctionBids(auctionId);
        return ApiResponseGenerator.success(response,HttpStatus.OK);
    }

    @Operation(summary = "등록한 경매 조회", description = "등록한 경매 목록을 조회합니다")
    @GetMapping("/auction/member/{memberId}")
    public ApiResponse<GetOwnAuctionResponse> getOwnAuction(@PathVariable Long memberId) {
        GetOwnAuctionResponse response = getAuctionsService.executeByMemberId(memberId);
        return ApiResponseGenerator.success(response,HttpStatus.OK);
    }
}
