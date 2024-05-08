package com.cap.resellers.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ApiResponse<ApiResponse.CustomBody<Void>> health() {
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
