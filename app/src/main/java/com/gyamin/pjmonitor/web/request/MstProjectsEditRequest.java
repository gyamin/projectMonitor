package com.gyamin.pjmonitor.web.request;
import javax.validation.constraints.Max;
import java.time.LocalDate;

public class MstProjectsEditRequest extends MstProjectsNewRequest{
    String[] relatedOrders;
    String[] notRelatedOrders;

    public String[] getRelatedOrders() {
        return relatedOrders;
    }

    public void setRelatedOrders(String[] relatedOrders) {
        this.relatedOrders = relatedOrders;
    }

    public String[] getNotRelatedOrders() {
        return notRelatedOrders;
    }

    public void setNotRelatedOrders(String[] notRelatedOrders) {
        this.notRelatedOrders = notRelatedOrders;
    }
}
