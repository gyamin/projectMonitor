package com.gyamin.pjmonitor.entity;

import org.seasar.doma.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 */
@Entity()
@Table(name = "mst_projects")
public class MstProjectsReport {

    @Column(name = "project_id")
    String projectId;

    @Column(name = "project_name")
    String projectName;

    @Column(name = "workers_id")
    Integer workersId;

    @Column(name = "family_name")
    String familyName;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "week_num_of_year")
    String weekNumOfYear;

    @Column(name = "week_work_hours")
    BigDecimal workHours;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getWorkersId() {
        return workersId;
    }

    public void setWorkersId(Integer workersId) {
        this.workersId = workersId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getWeekNumOfYear() {
        return weekNumOfYear;
    }

    public void setWeekNumOfYear(String weekNumOfYear) {
        this.weekNumOfYear = weekNumOfYear;
    }

    public BigDecimal getWorkHours() {
        return workHours;
    }

    public void setWorkHours(BigDecimal workHours) {
        this.workHours = workHours;
    }
}
