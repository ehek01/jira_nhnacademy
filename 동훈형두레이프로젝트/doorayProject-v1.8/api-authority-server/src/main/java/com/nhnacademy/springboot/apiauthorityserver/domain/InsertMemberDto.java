package com.nhnacademy.springboot.apiauthorityserver.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertMemberDto {

    String username;
    String email;
    String authority;
    String status;

}
