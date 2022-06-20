package com.nhnacademy.springboot.apiprojectserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_created_dt")
    private LocalDateTime taskCreateDt;

    @Column(name = "task_expected_complete_dt")
    private LocalDateTime expectedCompleteDt;

    @Column(name = "task_completed_dt")
    private LocalDateTime completeDt;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "member_id"),
        @JoinColumn(name = "project_id")
    })
    @JsonBackReference
    private ProjectMember projectMember;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public void addTag(Tag tag){
        tag.setTask(this);
        tags.add(tag);
    }

    public void addComment(Comment comment){
        comment.setTask(this);
        comments.add(comment);
    }
}
