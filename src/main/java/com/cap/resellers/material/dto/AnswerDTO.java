package com.cap.resellers.material.dto;

import lombok.Builder;

public record AnswerDTO(
        Boolean isMentoring,
        String first,
        String second,
        String third
) {

    @Builder
    public AnswerDTO {
    }
}
