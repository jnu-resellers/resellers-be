package com.cap.resellers.trade.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.trade.dto.TradePriceDto;
import com.cap.resellers.trade.dto.reqeust.CreateTradeRequest;
import com.cap.resellers.trade.dto.response.CreateTradeResponse;
import com.cap.resellers.trade.service.CreateTradeService;
import com.cap.resellers.trade.service.GetTradePriceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TradeController {
    private final CreateTradeService createTradeService;
    private final GetTradePriceService getTradePriceService;
    @PostMapping("/trade")
    @Operation(summary = "기자재 거래", description = "기자재 거래가 되고 돈이 입금된 것을 확인하고 confirm(기본 false)을 true로 변경")
    public ApiResponse<ApiResponse.CustomBody<CreateTradeResponse>> createTrade(@RequestBody CreateTradeRequest request) {
        CreateTradeResponse response = createTradeService.execute(1L, request);
        return ApiResponseGenerator.success(response, HttpStatus.OK);
    }

    @GetMapping("/trade/prcie")
    @Operation(summary = "기자재 거래 가격 조회", description = "기자재 거래 가격 조회")
    public ApiResponse<ApiResponse.CustomBody<List<TradePriceDto>>> getTradePrice(@RequestParam String itemType) {
        List<TradePriceDto> response = getTradePriceService.execute(itemType);
        return ApiResponseGenerator.success(response, HttpStatus.OK);
    }
}
