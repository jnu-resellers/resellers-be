package com.cap.resellers.material.dto.response;

import lombok.Builder;

import java.util.HashMap;

@Builder
public record GetQuestionResponse(
        HashMap<Integer, String> question
) {
    public static GetQuestionResponse of(HashMap<Integer, String> question) {
        return GetQuestionResponse.builder()
                .question(question)
                .build();
    }
}
