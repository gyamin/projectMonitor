package com.gyamin.pjmonitor.web.request;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MstProjectsNewRequest {

    String projectNo;

    String projectName;

    Long salesWorkersId;

    Long customerId;

    Long plWorkersId;

    LocalDate scheduledStartDate;

    LocalDate scheduledEndDate;

    String status;
}
