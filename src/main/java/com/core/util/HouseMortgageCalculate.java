package com.core.util;

/**
 * Created by giozola on 2017/8/2.
 */
//房贷计算器

import com.qibao.dto.HousingLoanDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 等额本息法
 */
public class HouseMortgageCalculate {
    /**
     * 本金
     */
    private BigDecimal principal;
    /**
     * 年利率
     */
    private BigDecimal interestRateYear;
    /**
     * 还款月数
     */
    private int repaymentTimeMonth;
    /**
     * 月利率
     */
    private BigDecimal interestRateMonth;

    /**
     * 必需实力化放可使用。
     * @param principal
     * @param interestRateYear
     * @param repaymentTimeMonth
     */
    public HouseMortgageCalculate(Double principal, Double interestRateYear, int repaymentTimeMonth) {
        this.principal = new BigDecimal(principal);
        this.interestRateYear = new BigDecimal(interestRateYear);
        this.repaymentTimeMonth = repaymentTimeMonth;
        this.interestRateMonth = this.interestRateYear.divide(new BigDecimal(12), 8, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * 月供额
     * 〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
     *
     */
    public BigDecimal moneyByMonth() {
        BigDecimal temp =  coreInterest();
        BigDecimal numerator  = principal.multiply(interestRateMonth).multiply(temp);
        BigDecimal denominator = temp.subtract(BigDecimal.ONE);
        return numerator.divide(denominator,4,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 月应还本金
     * 贷款本金×月利率×(1+月利率)^(还款月序号-1)÷〔(1+月利率)^还款月数-1〕总利息=还款月数×每月月供额-贷款本金
     *
     * @return
     */
    public BigDecimal principalByMonth(int monthOrderNumber){
        BigDecimal temp = coreInterest();
        BigDecimal temp_1 = coreInterest(monthOrderNumber);
        BigDecimal numerator = principal.multiply(interestRateMonth).multiply(temp_1);
        BigDecimal denominator = temp.subtract(BigDecimal.ONE);
        return numerator.divide(denominator,4,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 月应还利息
     * @param monthOrderNumber
     * @return
     */
    public BigDecimal interestByMonth(int monthOrderNumber){
        return moneyByMonth().subtract(principalByMonth(monthOrderNumber));
    }

    /**
     * 总还款额
     * @return
     */
    public BigDecimal getAllMoney(){
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 1;i<=repaymentTimeMonth;i++){
            sum = sum.add(moneyByMonth());
        }
        return sum;
    }
    /**
     * 月还款信息
     */
    public HousingLoanDto repaymentMonth(int monthOrderNumber){
        HousingLoanDto housingLoanDto = new HousingLoanDto();
        housingLoanDto.setRepayment(moneyByMonth().doubleValue());
        housingLoanDto.setRepaymentPrincipal(principalByMonth(monthOrderNumber).doubleValue());
        housingLoanDto.setRepaymentInterest(interestByMonth(monthOrderNumber).doubleValue());
        return  housingLoanDto;
    }

    /**
     * 还款列表  月
     * @return
     */
    public List<HousingLoanDto> repaymentMonthList(){
        List<HousingLoanDto> housingLoanDtoList = new ArrayList<HousingLoanDto>();
        for (int i=1;i<=repaymentTimeMonth;i++){
            housingLoanDtoList.add(repaymentMonth(i));
        }
        return housingLoanDtoList;
    }


    /**
     * （1+月利率）^还款月数
     *
     * @return
     */
    private BigDecimal coreInterest() {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i <repaymentTimeMonth ; i++) {
            result = result.multiply(BigDecimal.ONE.add(interestRateMonth));
        }
        return result;
    }
    /**
     * （1+月利率）^（还款月序号-1）
     *
     * @return
     */
    private BigDecimal coreInterest(int monthOrderNumber) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i <monthOrderNumber-1 ; i++) {
            result = result.multiply(BigDecimal.ONE.add(interestRateMonth));
        }
        return result;
    }

}
