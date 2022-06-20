package com.nhnacademy.springboot.apiauthorityserver.domain;

public interface MemberDetailsDto {

    String getUsername();
    String getPassword();
    String getEmail();
    String getAuthority();
    String getStatus();

}
