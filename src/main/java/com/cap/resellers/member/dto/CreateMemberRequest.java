package com.cap.resellers.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

public record CreateMemberRequest(
        @Schema(description = "회원 이름") String name,
        @Schema(description = "회원 이메일") String email,
        @Schema(description = "회원 비밀번호") String password,
        @Schema(description = "회원 은행명") String bankName,
        @Schema(description = "회원 계좌번호") String accountNumber,
        @Schema(description = "회원 연락처") String contact
) {
    @Builder
    public CreateMemberRequest {
    }
}
