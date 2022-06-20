package com.nhnacademy.springboot.apiprojectserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "projectmember")
public class ProjectMember {

    @EmbeddedId
    private Id id;

    @Column(name = "adminyn")
    String isAdmin;

    @MapsId("memberId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    public Member member;

    @MapsId("projectId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    @JsonBackReference
    public Project project;

    @OneToMany(mappedBy = "projectMember", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        task.setProjectMember(this);
        tasks.add(task);
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable{

        private Long memberId;

        private Long projectId;
    }
}
