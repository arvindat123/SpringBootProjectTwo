package com.learning.technology.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="scheduled_tasks")
@RequiredArgsConstructor
public class ScheduledTasks implements Serializable {
    @Id
    @Column(name="login_id")
    private String loginId;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
