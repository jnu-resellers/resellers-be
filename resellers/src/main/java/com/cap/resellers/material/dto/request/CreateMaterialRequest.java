package com.cap.resellers.material.dto.request;

import lombok.Builder;

import java.util.List;

public record CreateMaterialRequest(
        String title,
        String jobType,
        List<ProductRequest> products
) {
    @Builder
    public CreateMaterialRequest {
    }
}
