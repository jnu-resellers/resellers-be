package com.cap.resellers.member.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.member.dto.CreateMemberRequest;
import com.cap.resellers.member.dto.GetMemberInfoResponse;
import com.cap.resellers.member.dto.LoginRequest;
import com.cap.resellers.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "로그인", description = "로그인합니다.")
    @PostMapping("/member/login")
    public ApiResponse<ApiResponse.CustomBody<Long>>login(@RequestBody LoginRequest request) {
        Long memberId = memberService.login(request);
        return ApiResponseGenerator.success(memberId, HttpStatus.OK);
    }

    @Operation(summary = "아이디 중복확인", description = "아이디 중복확인합니다.")
    @GetMapping("/member/duplication")
    public ApiResponse<ApiResponse.CustomBody<String>> checkDuplication(@RequestParam String email) {
        String result = memberService.checkDuplication(email);
        return ApiResponseGenerator.success(result, HttpStatus.OK);
    }

    @Operation(summary = "회원정보 확인", description = "회원정보를 확인합니다.")
    @GetMapping("/member/{memberId}/info")
    public ApiResponse<GetMemberInfoResponse> getMemberInfo(@PathVariable Long memberId) {
        GetMemberInfoResponse response = memberService.getMemberInfo(memberId);
        return ApiResponseGenerator.success(response, HttpStatus.OK);
    }
}
