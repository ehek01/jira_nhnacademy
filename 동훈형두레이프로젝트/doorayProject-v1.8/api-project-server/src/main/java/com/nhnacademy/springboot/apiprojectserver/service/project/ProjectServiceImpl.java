package com.nhnacademy.springboot.apiprojectserver.service.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nhnacademy.springboot.apiprojectserver.config.ProjectStatus;
import com.nhnacademy.springboot.apiprojectserver.domain.ProjectDto;
import com.nhnacademy.springboot.apiprojectserver.domain.ProjectRequest;
import com.nhnacademy.springboot.apiprojectserver.entity.Member;
import com.nhnacademy.springboot.apiprojectserver.entity.Project;
import com.nhnacademy.springboot.apiprojectserver.entity.ProjectMember;
import com.nhnacademy.springboot.apiprojectserver.repository.member.MemberRepository;
import com.nhnacademy.springboot.apiprojectserver.repository.project.ProjectRepository;
import com.nhnacademy.springboot.apiprojectserver.repository.projectmember.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDto createProject(ProjectRequest projectRequest, Long memberId) {
        Optional<ProjectDto> dto =
            projectRepository.findByProjectName(projectRequest.getProjectName());

        Optional<Member> optionalMember = memberRepository.findById(memberId);

        if (dto.isEmpty()) {
            Project project = new Project();
            project.setProjectName(projectRequest.getProjectName());
            project.setProjectStatus(ProjectStatus.ENABLE.toString());
            project.setProjectCreatedDt(LocalDate.now());

            // memberid와 projectid로 projectmember 의 id를 만들어서
            // 그 id 로 projectmemberrepository.findbyid를 해서
            // setadmin을 해야합니다.
            ProjectMember.Id id = new ProjectMember.Id(project.getProjectId(), memberId);
            ProjectMember projectMember = new ProjectMember();
            projectMember.setId(id);
            projectMember.setMember(optionalMember.orElse(null));

            if(projectMemberRepository.findById(id).isEmpty()){

                projectMember.setIsAdmin("Y");
                project.addProjectMember(projectMember);
                projectMemberRepository.save(projectMember);
            }

            return modelMapper.map(projectRepository.save(project), ProjectRequest.class);
        }

        return null;
    }

    @Override
    public List<ProjectDto> readProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (Project project : projects) {
            projectDtoList.add(modelMapper.map(project, ProjectRequest.class));
        }

        return projectDtoList;
    }

    @Override
    public ProjectDto modifyProject(Long projectId,
                                    ProjectRequest projectRequest) {
        Optional<Project> project = projectRepository.findById(projectId);

        if (project.isEmpty()) {
            return null;
        }

        project.get().setProjectName(projectRequest.getProjectName());
        project.get().setProjectStatus(projectRequest.getProjectStatus());

        // DTO interface로 반환 하려 할 때, modelMapper를 사용하면 반환된 엔티티를 한번에 매핑 할 수 있는데,
        // 이 경우 modelMapper의 2번째 인자로 class를 받아야 하기 때문에, 정상작동 하지 않는다.
        // 따라서 속성값이 같은 ProjectRequest에 Dto를 상속받아서 반환이 DTO가 될 수 있도록 해줌.
        return modelMapper.map(projectRepository.save(project.get()), ProjectRequest.class);
    }

    @Override
    public boolean removeProject(Long projectId) {
        if(projectRepository.findById(projectId).isEmpty()) {
            return false;
        }

        projectRepository.deleteById(projectId);
        return true;
    }



}
