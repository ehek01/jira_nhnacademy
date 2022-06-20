package com.nhnacademy.springboot.apiauthorityserver.service.impl;

import com.nhnacademy.springboot.apiauthorityserver.MemberStatus;
import com.nhnacademy.springboot.apiauthorityserver.domain.InsertMemberDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsRequest;
import com.nhnacademy.springboot.apiauthorityserver.entity.Member;
import com.nhnacademy.springboot.apiauthorityserver.repository.AccountRepository;
import com.nhnacademy.springboot.apiauthorityserver.service.LoginService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Insert;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public MemberDetailsDto findUser(String userName) {
        return accountRepository.findByUsername(userName).orElse(null);
    }

    @Override
    public InsertMemberDto memberRegister(MemberDetailsRequest memberDetailsRequest) {
        MemberDetailsDto memberDetailsDto =
            accountRepository.findByUsername(memberDetailsRequest.getUsername()).orElse(null);

        if (Objects.isNull(memberDetailsDto)) {
            Member member = Member.builder()
                .username(memberDetailsRequest.getUsername())
                .password(memberDetailsRequest.getPassword())
                .email(memberDetailsRequest.getEmail())
                .authority(memberDetailsRequest.getAuthority())
                .status(MemberStatus.REGISTER.toString()).build();

            InsertMemberDto insertMemberDto = modelMapper.map(accountRepository.save(member), InsertMemberDto.class);

            return insertMemberDto;

        }

        return null;

    }
}
