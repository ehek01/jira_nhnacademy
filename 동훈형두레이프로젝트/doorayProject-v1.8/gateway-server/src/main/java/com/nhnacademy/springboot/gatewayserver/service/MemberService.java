package com.nhnacademy.springboot.gatewayserver.service;

import com.nhnacademy.springboot.gatewayserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.gatewayserver.domain.MemberRequest;

public interface MemberService {
    MemberDetailsDto register(MemberRequest memberRequest);
}
