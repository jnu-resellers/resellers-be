package com.cap.resellers.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {
    public ApiResponse<ApiResponse.CustomBody<Void>> health() {
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
