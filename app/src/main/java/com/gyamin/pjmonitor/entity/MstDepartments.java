package com.gyamin.pjmonitor.entity;

import java.time.LocalDate;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MstDepartmentsListener.class)
@Table(name = "mst_departments")
public class MstDepartments {

    /** */
    @Id
    @Column(name = "id")
    Long id;

    /** */
    @Column(name = "department_name")
    String departmentName;

    /** */
    @Column(name = "created_at")
    LocalDate createdAt;

    /** */
    @Column(name = "modified_at")
    LocalDate modifiedAt;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * Returns the departmentName.
     * 
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /** 
     * Sets the departmentName.
     * 
     * @param departmentName the departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /** 
     * Returns the createdAt.
     * 
     * @return the createdAt
     */
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    /** 
     * Sets the createdAt.
     * 
     * @param createdAt the createdAt
     */
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    /** 
     * Returns the modifiedAt.
     * 
     * @return the modifiedAt
     */
    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    /** 
     * Sets the modifiedAt.
     * 
     * @param modifiedAt the modifiedAt
     */
    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}