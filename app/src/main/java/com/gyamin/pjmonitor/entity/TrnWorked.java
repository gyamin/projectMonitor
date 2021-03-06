package com.gyamin.pjmonitor.entity;

import java.math.BigDecimal;
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
@Entity(listener = TrnWorkedListener.class)
@Table(name = "trn_worked")
public class TrnWorked {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "work_date")
    LocalDate workDate;

    /** */
    @Column(name = "worker_id")
    Long workerId;

    /** */
    @Column(name = "job_no")
    String jobNo;

    /** */
    @Column(name = "work_hours")
    BigDecimal workHours;

    /** */
    @Column(name = "work_type")
    String workType;

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
     * Returns the workDate.
     * 
     * @return the workDate
     */
    public LocalDate getWorkDate() {
        return workDate;
    }

    /** 
     * Sets the workDate.
     * 
     * @param workDate the workDate
     */
    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    /** 
     * Returns the workerId.
     * 
     * @return the workerId
     */
    public Long getWorkerId() {
        return workerId;
    }

    /** 
     * Sets the workerId.
     * 
     * @param workerId the workerId
     */
    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    /** 
     * Returns the jobNo.
     * 
     * @return the jobNo
     */
    public String getJobNo() {
        return jobNo;
    }

    /** 
     * Sets the jobNo.
     * 
     * @param jobNo the jobNo
     */
    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    /** 
     * Returns the workHours.
     * 
     * @return the workHours
     */
    public BigDecimal getWorkHours() {
        return workHours;
    }

    /** 
     * Sets the workHours.
     * 
     * @param workHours the workHours
     */
    public void setWorkHours(BigDecimal workHours) {
        this.workHours = workHours;
    }

    /** 
     * Returns the workType.
     * 
     * @return the workType
     */
    public String getWorkType() {
        return workType;
    }

    /** 
     * Sets the workType.
     * 
     * @param workType the workType
     */
    public void setWorkType(String workType) {
        this.workType = workType;
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