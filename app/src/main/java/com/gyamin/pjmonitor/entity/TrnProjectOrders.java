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
@Entity(listener = TrnProjectOrdersListener.class)
@Table(name = "trn_project_orders")
public class TrnProjectOrders {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "project_id")
    Integer projectId;

    /** */
    @Column(name = "department_id")
    Long departmentId;

    /** */
    @Column(name = "job_no")
    String jobNo;

    /** */
    @Column(name = "order_name")
    String orderName;

    /** 生産/非生産 */
    @Column(name = "order_kind")
    String orderKind;

    /** */
    @Column(name = "sales_workers_id")
    Long salesWorkersId;

    /** */
    @Column(name = "ordered_date")
    LocalDate orderedDate;

    /** */
    @Column(name = "ordered_hours")
    BigDecimal orderedHours;

    /** */
    @Column(name = "ordered_volume")
    Long orderedVolume;

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
     * Returns the projectId.
     * 
     * @return the projectId
     */
    public Integer getProjectId() {
        return projectId;
    }

    /** 
     * Sets the projectId.
     * 
     * @param projectId the projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /** 
     * Returns the departmentId.
     * 
     * @return the departmentId
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /** 
     * Sets the departmentId.
     * 
     * @param departmentId the departmentId
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
     * Returns the orderName.
     * 
     * @return the orderName
     */
    public String getOrderName() {
        return orderName;
    }

    /** 
     * Sets the orderName.
     * 
     * @param orderName the orderName
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    /** 
     * Returns the orderKind.
     * 
     * @return the orderKind
     */
    public String getOrderKind() {
        return orderKind;
    }

    /** 
     * Sets the orderKind.
     * 
     * @param orderKind the orderKind
     */
    public void setOrderKind(String orderKind) {
        this.orderKind = orderKind;
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
     * Returns the orderedDate.
     * 
     * @return the orderedDate
     */
    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    /** 
     * Sets the orderedDate.
     * 
     * @param orderedDate the orderedDate
     */
    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }

    /** 
     * Returns the orderedHours.
     * 
     * @return the orderedHours
     */
    public BigDecimal getOrderedHours() {
        return orderedHours;
    }

    /** 
     * Sets the orderedHours.
     * 
     * @param orderedHours the orderedHours
     */
    public void setOrderedHours(BigDecimal orderedHours) {
        this.orderedHours = orderedHours;
    }

    /** 
     * Returns the orderedVolume.
     * 
     * @return the orderedVolume
     */
    public Long getOrderedVolume() {
        return orderedVolume;
    }

    /** 
     * Sets the orderedVolume.
     * 
     * @param orderedVolume the orderedVolume
     */
    public void setOrderedVolume(Long orderedVolume) {
        this.orderedVolume = orderedVolume;
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