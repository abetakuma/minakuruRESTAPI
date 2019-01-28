package com.example.idea.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ideas_users")
@Data
public class relationIdeasUsers {
    @Id
    private Long ideaId;
    private Long userId;
    private Long isJoin;
    private Long isInvite;
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
    		setCreatedAt(new Date());
    		setUpdatedAt(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(new Date());
    }
}
