package com.cap.resellers.trade.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.trade.dto.CreateTradeRequest;
import com.cap.resellers.trade.dto.CreateTradeResponse;
import com.cap.resellers.trade.service.CreateTradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TradeController {
    private final CreateTradeService createTradeService;
    @PostMapping("/trade")
    public ApiResponse<ApiResponse.CustomBody<CreateTradeResponse>> createTrade(@RequestBody CreateTradeRequest request) {
        CreateTradeResponse response = createTradeService.execute(1L, request);
        return ApiResponseGenerator.success(response, HttpStatus.OK);
    }
}
