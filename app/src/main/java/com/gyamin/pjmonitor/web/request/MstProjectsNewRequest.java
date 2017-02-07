package com.gyamin.pjmonitor.web.request;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MstProjectsNewRequest {

    @Max(20)
    String projectNo;
    @Max(100)
    String projectName;

    Long salesWorkersId;

    Long customerId;

    Long plWorkersId;

    LocalDate scheduledStartDate;

    LocalDate scheduledEndDate;

    String status;

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getSalesWorkersId() {
        return salesWorkersId;
    }

    public void setSalesWorkersId(Long salesWorkersId) {
        this.salesWorkersId = salesWorkersId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPlWorkersId() {
        return plWorkersId;
    }

    public void setPlWorkersId(Long plWorkersId) {
        this.plWorkersId = plWorkersId;
    }

    public LocalDate getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(LocalDate scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public LocalDate getScheduledEndDate() {
        return scheduledEndDate;
    }

    public void setScheduledEndDate(LocalDate scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
