package com.nhnacademy.springboot.apiauthorityserver.repository;

import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsRequest;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomAccountRepository {
    MemberDetailsDto insertNewMember(MemberDetailsRequest memberDetailsRequest);
}
