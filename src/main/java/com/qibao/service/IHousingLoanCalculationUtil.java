package com.qibao.service;

import com.qibao.dto.HousingLoanDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by giozola on 2017/8/3.
 */
public interface IHousingLoanCalculationUtil {
    /**
     * 某月的还款信息
     * @return
     */
    HousingLoanDto getRepaymentByMonth(HousingLoanDto housingLoanDto);

    /**
     * 某年的还款信息
     */
    List<HousingLoanDto> getRepaymentByYear();

    /**
     * 所有的还款信息
     */
    List<HousingLoanDto> getAll(HousingLoanDto housingLoanDto);

}
