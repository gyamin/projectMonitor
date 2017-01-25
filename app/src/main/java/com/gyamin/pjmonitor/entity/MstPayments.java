package com.gyamin.pjmonitor.entity;

import java.time.LocalDate;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MstPaymentsListener.class)
@Table(name = "mst_payments")
public class MstPayments {

    /** */
    @Id
    @Column(name = "id")
    Long id;

    /** */
    @Column(name = "pay_name")
    String payName;

    /** */
    @Column(name = "hourly_pay")
    Long hourlyPay;

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
     * Returns the payName.
     * 
     * @return the payName
     */
    public String getPayName() {
        return payName;
    }

    /** 
     * Sets the payName.
     * 
     * @param payName the payName
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }

    /** 
     * Returns the hourlyPay.
     * 
     * @return the hourlyPay
     */
    public Long getHourlyPay() {
        return hourlyPay;
    }

    /** 
     * Sets the hourlyPay.
     * 
     * @param hourlyPay the hourlyPay
     */
    public void setHourlyPay(Long hourlyPay) {
        this.hourlyPay = hourlyPay;
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