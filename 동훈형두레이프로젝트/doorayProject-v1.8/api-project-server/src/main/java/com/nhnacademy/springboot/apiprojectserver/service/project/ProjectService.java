package com.nhnacademy.springboot.apiprojectserver.service.project;

import com.nhnacademy.springboot.apiprojectserver.domain.NewMemberRequest;
import com.nhnacademy.springboot.apiprojectserver.domain.ProjectDto;
import com.nhnacademy.springboot.apiprojectserver.domain.ProjectRequest;
import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectRequest projectRequest, Long MemberId);

    List<ProjectDto> readProjects();

    ProjectDto modifyProject(Long projectId,
                             ProjectRequest projectRequest);

    boolean removeProject(Long projectId);


}
