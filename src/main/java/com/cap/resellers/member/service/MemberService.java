package com.cap.resellers.member.service;

import com.cap.resellers.member.dto.CreateMemberRequest;
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

    public void save(CreateMemberRequest request) {
        Member member = Member.createMember(request.name(), request.email(), request.password(), request.bankName(), request.accountNumber(), request.contact());
        memberRepository.save(member);
    }
}
