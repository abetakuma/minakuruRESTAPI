package com.example.user.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "free_times")
@Data
public class FreeTime {
    @Id
    private Long userId;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartMonday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndMonday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartTuesday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndTuesday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartWednesday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndWednesday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartThursday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndThursday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartFriday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndFriday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartSaturday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndSaturday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeStartSunday;

    @Temporal(TemporalType.TIME)
    private Date freeTimeEndSunday;
}
