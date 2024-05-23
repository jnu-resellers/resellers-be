package com.cap.resellers.auction.controller;

import com.cap.resellers.auction.dto.request.CreateAuctionRequest;
import com.cap.resellers.auction.service.CreateAuctionService;
import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.material.service.CreateMaterialService;
import com.cap.resellers.material.service.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuctionController {
    private final CreateAuctionService createAuctionService;
    private final UploadImageService uploadImageService;
    private final CreateMaterialService createMaterialService;


    public ApiResponse<ApiResponse.CustomBody<Void>> createAuction(@RequestBody CreateAuctionRequest request) {
        Long memberId = 1L;
        createAuctionService.execute(request, memberId);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
