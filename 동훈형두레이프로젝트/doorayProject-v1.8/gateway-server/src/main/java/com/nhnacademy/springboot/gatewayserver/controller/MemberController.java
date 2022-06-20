package com.nhnacademy.springboot.gatewayserver.controller;

import com.nhnacademy.springboot.gatewayserver.domain.MemberRequest;
import com.nhnacademy.springboot.gatewayserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "form/loginForm";
    }

    @GetMapping("/member/register")
    public String register() {
        return "form/registerForm";
    }

    @PostMapping("/member/register")
    public String doRegister(MemberRequest memberRequest) {
        memberService.register(memberRequest);
        return "index";
    }
}
