package com.nhnacademy.springboot.apiprojectserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Milestone {
    @Id
    @Column(name = "milestone_id")
    private Long milestoneId;

    @Column(name = "milestone_name")
    private String milestoneName;

    @Column(name = "milestone_expected_begin_dt")
    private LocalDate expectedBeginDt;

    @Column(name = "milestone_expected_complete_dt")
    private LocalDate expectedCompleteDt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
