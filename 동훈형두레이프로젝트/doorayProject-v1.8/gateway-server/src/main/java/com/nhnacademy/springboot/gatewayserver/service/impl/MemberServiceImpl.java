package com.nhnacademy.springboot.gatewayserver.service.impl;

import com.nhnacademy.springboot.gatewayserver.adaptor.MemberAdaptor;
import com.nhnacademy.springboot.gatewayserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.gatewayserver.domain.MemberRequest;
import com.nhnacademy.springboot.gatewayserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberAdaptor memberAdaptor;

    @Override
    public MemberDetailsDto register(MemberRequest memberRequest) {
        return memberAdaptor.insertMember(memberRequest);
    }
}
