package com.qibao.webutils.houseMortgage;

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
