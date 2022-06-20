package com.nhnacademy.springboot.apiauthorityserver.service;

import com.nhnacademy.springboot.apiauthorityserver.domain.InsertMemberDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsRequest;

public interface LoginService {
    MemberDetailsDto findUser(String userName);
    InsertMemberDto memberRegister(MemberDetailsRequest memberDetailsRequest);
}
