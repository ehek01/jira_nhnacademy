package com.nhnacademy.springboot.apiprojectserver.domain;

import java.time.LocalDate;

public interface ProjectDto {
    String getProjectName();
    String getProjectStatus();
    LocalDate getProjectCreatedDt();
}
