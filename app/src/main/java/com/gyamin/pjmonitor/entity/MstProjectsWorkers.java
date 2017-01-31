package com.gyamin.pjmonitor.entity;

import org.seasar.doma.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 */
@Entity()
@Table(name = "mst_projects")
public class MstProjectsWorkers extends MstProjects {


    /** */
    @Column(name = "family_name")
    String familyName;

    /** */
    @Column(name = "first_name")
    String firstName;

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
}