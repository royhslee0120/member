package com.member.controller;

import com.member.dto.MemberCreateRequest;
import com.member.dto.MemberCreateResponse;
import com.member.dto.MemberGetResponse;
import com.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberCreateResponse> create(
            @Valid @RequestBody MemberCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberGetResponse> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(memberService.get(id));
    }
}