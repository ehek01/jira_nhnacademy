package com.nhnacademy.springboot.apiprojectserver.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest implements ProjectDto{
    private String projectName;

    private String projectStatus;

    private LocalDate projectCreatedDt;
}
