package com.nhnacademy.springboot.apiauthorityserver.repository;

import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsRequest;
import com.nhnacademy.springboot.apiauthorityserver.entity.Member;
import com.nhnacademy.springboot.apiauthorityserver.entity.QMember;
import javax.management.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.binding.QuerydslBindingsFactory;

public class AccountRepositoryImpl extends QuerydslRepositorySupport implements CustomAccountRepository {

    // private final SqlQueryFactory sqlQueryFactory;

    public AccountRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public MemberDetailsDto insertNewMember(MemberDetailsRequest memberDetailsRequest) {
        QMember member = QMember.member;
        // from(member)
            // .

        return null;
    }
}
