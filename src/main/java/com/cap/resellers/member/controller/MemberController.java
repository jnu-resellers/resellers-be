package com.cap.resellers.member.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.member.dto.CreateMemberRequest;
import com.cap.resellers.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "회원", description = "MEMBER API")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 생성", description = "회원을 생성합니다.")
    @PostMapping("/member")
    public ApiResponse<ApiResponse.CustomBody<Void>> createMember(@RequestBody CreateMemberRequest request) {
        memberService.save(request);
        return ApiResponseGenerator.success(HttpStatus.CREATED);
    }
}
