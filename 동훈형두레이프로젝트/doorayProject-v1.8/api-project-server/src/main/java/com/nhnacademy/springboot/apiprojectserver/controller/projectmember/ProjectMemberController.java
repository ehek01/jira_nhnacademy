package com.nhnacademy.springboot.apiprojectserver.controller.projectmember;

import com.nhnacademy.springboot.apiprojectserver.domain.NewMemberRequest;
import com.nhnacademy.springboot.apiprojectserver.service.projectMember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @PostMapping("/newMember")
    public NewMemberRequest putInNewMember(@RequestParam Long projectId, @RequestParam Long memberId){
        return projectMemberService.addNewMember(projectId,memberId);
    }
}
