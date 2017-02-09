package com.gyamin.pjmonitor.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MstWorkersListener.class)
@Table(name = "mst_workers")
public class MstWorkers {

    /** */
    @Id
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "family_name")
    String familyName;

    /** */
    @Column(name = "first_name")
    String firstName;

    /** */
    @Column(name = "family_name_kana")
    String familyNameKana;

    /** */
    @Column(name = "first_name_kana")
    String firstNameKana;

    /** */
    @Column(name = "job_type")
    String jobType;

    /** */
    @Column(name = "department_id")
    Integer departmentId;

    /** */
    @Column(name = "payment_id")
    Integer paymentId;

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
     * Returns the familyName.
     * 
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /** 
     * Sets the familyName.
     * 
     * @param familyName the familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /** 
     * Returns the firstName.
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /** 
     * Sets the firstName.
     * 
     * @param firstName the firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** 
     * Returns the familyNameKana.
     * 
     * @return the familyNameKana
     */
    public String getFamilyNameKana() {
        return familyNameKana;
    }

    /** 
     * Sets the familyNameKana.
     * 
     * @param familyNameKana the familyNameKana
     */
    public void setFamilyNameKana(String familyNameKana) {
        this.familyNameKana = familyNameKana;
    }

    /** 
     * Returns the firstNameKana.
     * 
     * @return the firstNameKana
     */
    public String getFirstNameKana() {
        return firstNameKana;
    }

    /** 
     * Sets the firstNameKana.
     * 
     * @param firstNameKana the firstNameKana
     */
    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    /** 
     * Returns the jobType.
     * 
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }

    /** 
     * Sets the jobType.
     * 
     * @param jobType the jobType
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /** 
     * Returns the departmentId.
     * 
     * @return the departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /** 
     * Sets the departmentId.
     * 
     * @param departmentId the departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /** 
     * Returns the paymentId.
     * 
     * @return the paymentId
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /** 
     * Sets the paymentId.
     * 
     * @param paymentId the paymentId
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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