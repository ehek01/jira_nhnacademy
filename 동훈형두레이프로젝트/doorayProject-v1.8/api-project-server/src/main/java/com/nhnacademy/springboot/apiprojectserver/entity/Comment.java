package com.nhnacademy.springboot.apiprojectserver.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @Column(name="comment_id")
    Long commentId;

    String content;

    @Column(name = "created_dt")
    LocalDateTime createdDt;

    @Column(name = "modified_dt")
    LocalDateTime modifiedDt;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;
}
