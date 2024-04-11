package com.cap.resellers.material.dto.request;

import lombok.Builder;

import java.util.List;

public record ProductRequest(

        List<String> fileNames,
        String name,
        Integer price,
        String description,
        Integer quantity
) {
    @Builder
    public ProductRequest {
    }
}
