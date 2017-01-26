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
@Entity(listener = MstDepartmentsListener.class)
@Table(name = "mst_departments")
public class MstDepartments {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "department_name")
    String departmentName;

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