package com.cap.resellers.material.dto.request;

import com.cap.resellers.material.dto.AnswerDTO;
import lombok.Builder;

import java.util.List;

public record CreateMaterialRequest(
        String title,
        String itemType,
        List<ProductRequest> products,
        AnswerDTO answers
) {
    @Builder
    public CreateMaterialRequest {
    }
}
