package com.cap.resellers.member.service;

import com.cap.resellers.member.dto.CreateMemberRequest;
import com.cap.resellers.member.dto.GetMemberInfoResponse;
import com.cap.resellers.member.dto.LoginRequest;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public void save(CreateMemberRequest request) {
        Member member = Member.createMember(request.name(), request.email(), request.password(), request.bankName(), request.accountNumber(), request.contact());
        memberRepository.save(member);
    }

    public Long login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.email()).orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호를 확인해주세요."));
        if(member.getPassword().equals(request.password())) {
            return member.getId();
        } else {
            throw new IllegalArgumentException("아이디 혹은 비밀번호를 확인해주세요.");
        }
    }

    public String checkDuplication(String email) {
        if(memberRepository.existsByEmail(email)) {
            return "중복된 아이디입니다.";
        } else {
            return "사용 가능한 아이디입니다.";
        }
    }

    public GetMemberInfoResponse getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return GetMemberInfoResponse.of(member.getName(), member.getEmail(), member.getContact(), member.getBankName(), member.getAccountNumber(), member.getId());
    }
}
