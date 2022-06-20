package com.nhnacademy.springboot.apiauthorityserver.repository;

import com.nhnacademy.springboot.apiauthorityserver.domain.InsertMemberDto;
import com.nhnacademy.springboot.apiauthorityserver.domain.MemberDetailsDto;
import com.nhnacademy.springboot.apiauthorityserver.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends JpaRepository<Member, Long> {
    Optional<MemberDetailsDto> findByUsername(String username);

    @Transactional
    // @Modifying
    @Query(value = "insert into Member(username, password, email, authority, status) values(?1,?2,?3,?4,?5) ", nativeQuery = true)
    InsertMemberDto InsertMember(String username, String password, String email, String authority, String status);
}
