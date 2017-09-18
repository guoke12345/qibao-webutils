package com.qibao.dto;

import org.springframework.stereotype.Repository;

/**
 * Created by giozola on 2017/8/3.
 */
public class HousingLoanDto {
    /**
     * 日期，时间
     */
    private String data;
    /**
     * 还款金额
     */
    private Double repayment;
    /**
     * 还款 本金
     */
    private Double repaymentPrincipal;
    /**
     * 还款 利息
     */
    private Double repaymentInterest;

    /**
     * 还款年利率
     */
    private Double repaymentRate;

    /**
     * 贷款期限  月
     */
    private Integer repaymentTime;

    @Override
    public String toString() {
        return "HousingLoanDto{" +
                "data='" + data + '\'' +
                ", repayment=" + repayment +
                ", repaymentPrincipal=" + repaymentPrincipal +
                ", repaymentInterest=" + repaymentInterest +
                ", repaymentRate=" + repaymentRate +
                ", repaymentTime=" + repaymentTime +
                '}';
    }

    public Integer getRepaymentTime() {
        return repaymentTime;
    }

    public void setRepaymentTime(Integer repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    public Double getRepaymentRate() {
        return repaymentRate;
    }

    public void setRepaymentRate(Double repaymentRate) {
        this.repaymentRate = repaymentRate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getRepayment() {
        return repayment;
    }

    public void setRepayment(Double repayment) {
        this.repayment = repayment;
    }

    public Double getRepaymentPrincipal() {
        return repaymentPrincipal;
    }

    public void setRepaymentPrincipal(Double repaymentPrincipal) {
        this.repaymentPrincipal = repaymentPrincipal;
    }

    public Double getRepaymentInterest() {
        return repaymentInterest;
    }

    public void setRepaymentInterest(Double repaymentInterest) {
        this.repaymentInterest = repaymentInterest;
    }
}
