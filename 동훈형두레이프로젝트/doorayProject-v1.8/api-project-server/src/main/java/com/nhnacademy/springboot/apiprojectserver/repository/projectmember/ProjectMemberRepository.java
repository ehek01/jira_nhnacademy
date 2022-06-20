package com.nhnacademy.springboot.apiprojectserver.repository.projectmember;

import com.nhnacademy.springboot.apiprojectserver.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.Id> {
}
