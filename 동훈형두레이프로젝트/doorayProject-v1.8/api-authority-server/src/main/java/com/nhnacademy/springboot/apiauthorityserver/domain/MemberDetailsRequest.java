package com.nhnacademy.springboot.apiauthorityserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//
//public interface MemberDetailsDto{
//    String getUsername();
//    String getPassword();
//    String getEmail();
//
//    String getAuthority();
//
//}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailsRequest {
    String username;
    String password;
    String email;
    String authority;
}