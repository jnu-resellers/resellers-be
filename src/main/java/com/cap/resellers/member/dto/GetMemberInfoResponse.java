package com.cap.resellers.member.dto;

public record GetMemberInfoResponse(String nickname, String email, String contact, String bankName, String accountNumber, Long memberId) {
    public static GetMemberInfoResponse of(String nickname, String email, String contact, String bankName, String accountNumber, Long memberId) {
        return new GetMemberInfoResponse(nickname, email, contact, bankName, accountNumber, memberId);
    }
}
