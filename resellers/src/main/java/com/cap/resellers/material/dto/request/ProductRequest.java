package com.cap.resellers.material.dto.request;

import lombok.Builder;

import java.util.List;

public record ProductRequest(

        List<String> fileNames,
        String name,
        Long price,
        String description
) {
    @Builder
    public ProductRequest {
    }
}
