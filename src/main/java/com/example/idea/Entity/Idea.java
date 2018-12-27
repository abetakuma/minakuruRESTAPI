package com.example.idea.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ideas")
@Data
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ideaId;
    private String ideaName;
    private String picture;
    private String address1;
    private String address2;
    private String building;
    private Date ideaStartOn;
    private Date ideaEndOn;
    private Long category;
    private String qualification;
    private Date deadline;
    private Long userId;
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
