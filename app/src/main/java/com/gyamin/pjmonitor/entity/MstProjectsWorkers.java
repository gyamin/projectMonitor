package com.gyamin.pjmonitor.entity;

import org.seasar.doma.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 */
@Entity()
@Table(name = "mst_projects")
public class MstProjectsWorkers extends MstProjects {

    @Column(name = "sales_worker_first_name")
    String salesWorkerFirstName;

    @Column(name = "sales_worker_family_name")
    String salesWorkerFamilyName;

    @Column(name = "pl_worker_first_name")
    String plWorkerFirstName;

    @Column(name = "pl_worker_family_name")
    String plWorkerFamilyName;

    public String getSalesWorkerFirstName() {
        return salesWorkerFirstName;
    }

    public void setSalesWorkerFirstName(String salesWorkerFirstName) {
        this.salesWorkerFirstName = salesWorkerFirstName;
    }

    public String getSalesWorkerFamilyName() {
        return salesWorkerFamilyName;
    }

    public void setSalesWorkerFamilyName(String salesWorkerFamilyName) {
        this.salesWorkerFamilyName = salesWorkerFamilyName;
    }

    public String getPlWorkerFirstName() {
        return plWorkerFirstName;
    }

    public void setPlWorkerFirstName(String plWorkerFirstName) {
        this.plWorkerFirstName = plWorkerFirstName;
    }

    public String getPlWorkerFamilyName() {
        return plWorkerFamilyName;
    }

    public void setPlWorkerFamilyName(String plWorkerFamilyName) {
        this.plWorkerFamilyName = plWorkerFamilyName;
    }
}
