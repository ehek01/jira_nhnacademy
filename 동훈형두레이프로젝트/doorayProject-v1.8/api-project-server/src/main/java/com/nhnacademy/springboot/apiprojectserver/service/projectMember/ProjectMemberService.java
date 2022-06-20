package com.nhnacademy.springboot.apiprojectserver.service.projectMember;

import com.nhnacademy.springboot.apiprojectserver.domain.NewMemberRequest;

public interface ProjectMemberService {
    NewMemberRequest addNewMember(Long projectId, Long memberId);
}
