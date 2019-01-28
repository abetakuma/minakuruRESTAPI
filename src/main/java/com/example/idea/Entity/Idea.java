package com.example.idea.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.user.entity.User;

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
    private Long address1;
    private String address2;
    private String building;
    private Date ideaStartOn;
    private Date ideaEndOn;
    private Long category;
    private String qualification;
    private Date deadline;
    private String goal;
    private String tag;
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

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name="ideas_users",
        joinColumns=@JoinColumn(name="idea_id"),
        inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private List<User> userList;
}
