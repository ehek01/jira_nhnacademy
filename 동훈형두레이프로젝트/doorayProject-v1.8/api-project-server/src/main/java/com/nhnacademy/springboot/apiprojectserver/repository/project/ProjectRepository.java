package com.nhnacademy.springboot.apiprojectserver.repository.project;

import com.nhnacademy.springboot.apiprojectserver.domain.ProjectDto;
import com.nhnacademy.springboot.apiprojectserver.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<ProjectDto> findByProjectName(String projectName);
}
