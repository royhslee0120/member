package com.member.service;

import com.member.dto.MemberCreateRequest;
import com.member.dto.MemberCreateResponse;
import com.member.dto.MemberGetResponse;
import com.member.entity.Member;
import com.member.exception.NotFoundException;
import com.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse create(MemberCreateRequest req) {
        Member saved = memberRepository.save(
                Member.builder()
                        .name(req.getName())
                        .age(req.getAge())
                        .mbti(req.getMbti())
                        .build()
        );
        return new MemberCreateResponse(saved);
    }

    @Transactional(readOnly = true)
    public MemberGetResponse get(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("member not found. id=" + id));
        return new MemberGetResponse(member);
    }
}