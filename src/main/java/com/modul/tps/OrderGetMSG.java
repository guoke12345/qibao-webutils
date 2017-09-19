package com.modul.tps;

import java.util.List;

public class OrderGetMSG {
    private List<String> orderCodeList;
    private Boolean isSuccess;
    private String orderGetStartTime;
    private String orderGetEndTime;
    public List<String> getOrderCodeList() {
        return orderCodeList;
    }
    public void setOrderCodeList(List<String> orderCodeList) {
        this.orderCodeList = orderCodeList;
    }
    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getOrderGetStartTime() {
        return orderGetStartTime;
    }

    public void setOrderGetStartTime(String orderGetStartTime) {
        this.orderGetStartTime = orderGetStartTime;
    }

    public String getOrderGetEndTime() {
        return orderGetEndTime;
    }

    public void setOrderGetEndTime(String orderGetEndTime) {
        this.orderGetEndTime = orderGetEndTime;
    }
}