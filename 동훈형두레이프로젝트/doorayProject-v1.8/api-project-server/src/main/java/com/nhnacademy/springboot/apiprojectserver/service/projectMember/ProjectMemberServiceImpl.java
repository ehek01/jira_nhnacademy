package com.nhnacademy.springboot.apiprojectserver.service.projectMember;

import com.nhnacademy.springboot.apiprojectserver.domain.NewMemberRequest;
import com.nhnacademy.springboot.apiprojectserver.repository.projectmember.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService{
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public NewMemberRequest addNewMember(Long projectId, Long memberId) {

//        pr
        return null;
    }
}
