package com.gyamin.pjmonitor.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity()
@Table(name = "mst_projects")
public class MstProjects {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "project_no")
    String projectNo;

    /** */
    @Column(name = "project_name")
    String projectName;

    /** */
    @Column(name = "sales_workers_id")
    Long salesWorkersId;

    /** */
    @Column(name = "customer_id")
    Long customerId;

    /** */
    @Column(name = "pl_workers_id")
    Long plWorkersId;

    /** */
    @Column(name = "scheduled_start_date")
    LocalDate scheduledStartDate;

    /** */
    @Column(name = "scheduled_end_date")
    LocalDate scheduledEndDate;

    /** estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済) */
    @Column(name = "status")
    String status;

    /** */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** */
    @Column(name = "modified_at")
    LocalDateTime modifiedAt;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Returns the projectNo.
     * 
     * @return the projectNo
     */
    public String getProjectNo() {
        return projectNo;
    }

    /** 
     * Sets the projectNo.
     * 
     * @param projectNo the projectNo
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    /** 
     * Returns the projectName.
     * 
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /** 
     * Sets the projectName.
     * 
     * @param projectName the projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /** 
     * Returns the salesWorkersId.
     * 
     * @return the salesWorkersId
     */
    public Long getSalesWorkersId() {
        return salesWorkersId;
    }

    /** 
     * Sets the salesWorkersId.
     * 
     * @param salesWorkersId the salesWorkersId
     */
    public void setSalesWorkersId(Long salesWorkersId) {
        this.salesWorkersId = salesWorkersId;
    }

    /** 
     * Returns the customerId.
     * 
     * @return the customerId
     */
    public Long getCustomerId() {
        return customerId;
    }

    /** 
     * Sets the customerId.
     * 
     * @param customerId the customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /** 
     * Returns the plWorkersId.
     * 
     * @return the plWorkersId
     */
    public Long getPlWorkersId() {
        return plWorkersId;
    }

    /** 
     * Sets the plWorkersId.
     * 
     * @param plWorkersId the plWorkersId
     */
    public void setPlWorkersId(Long plWorkersId) {
        this.plWorkersId = plWorkersId;
    }

    /** 
     * Returns the scheduledStartDate.
     * 
     * @return the scheduledStartDate
     */
    public LocalDate getScheduledStartDate() {
        return scheduledStartDate;
    }

    /** 
     * Sets the scheduledStartDate.
     * 
     * @param scheduledStartDate the scheduledStartDate
     */
    public void setScheduledStartDate(LocalDate scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    /** 
     * Returns the scheduledEndDate.
     * 
     * @return the scheduledEndDate
     */
    public LocalDate getScheduledEndDate() {
        return scheduledEndDate;
    }

    /** 
     * Sets the scheduledEndDate.
     * 
     * @param scheduledEndDate the scheduledEndDate
     */
    public void setScheduledEndDate(LocalDate scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    /** 
     * Returns the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /** 
     * Sets the status.
     * 
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
     * Returns the createdAt.
     * 
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /** 
     * Sets the createdAt.
     * 
     * @param createdAt the createdAt
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /** 
     * Returns the modifiedAt.
     * 
     * @return the modifiedAt
     */
    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    /** 
     * Sets the modifiedAt.
     * 
     * @param modifiedAt the modifiedAt
     */
    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
