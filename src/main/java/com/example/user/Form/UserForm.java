package com.example.user.Form;

import java.sql.Time;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UserForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String mailAddress;
    private String password;
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
    private Time freeTimeStartMonday;
    private Time freeTimeEndMonday;
    private Time freeTimeStartTuesday;
    private Time freeTimeEndTuesday;
    private Time freeTimeStartWednesday;
    private Time freeTimeEndWednesday;
    private Time freeTimeStartThursday;
    private Time freeTimeEndThursday;
    private Time freeTimeStartFriday;
    private Time freeTimeEndFriday;
    private Time freeTimeStartSaturday;
    private Time freeTimeEndSaturday;
    private Time freeTimeStartSunday;
    private Time freeTimeEndSunday;
}
