package com.nhnacademy.springboot.apiauthorityserver.controller;

import com.nhnacademy.springboot.apiauthorityserver.domain.InsertMemberDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsRequest;
import com.nhnacademy.springboot.apiauthorityserver.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login/{username}")
    public MemberDetailsDto attemptLogin(@PathVariable String username) {
        return loginService.findUser(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/member")
    public InsertMemberDto register(@RequestBody MemberDetailsRequest memberDetailsRequest) {
        return loginService.memberRegister(memberDetailsRequest);
    }
}
