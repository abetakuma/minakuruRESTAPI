package com.example.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.idea.entity.Idea;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private Long age;
    private Long sex;
    private String hobby;
    private String interest;
    private Long prefecture;
    private String city;
    private String supply;
    private Long acceptInvitation;
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

    @ManyToMany(mappedBy="userList")
    private List<Idea> ideaList;
}
