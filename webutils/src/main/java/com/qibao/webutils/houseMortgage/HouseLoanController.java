package com.qibao.webutils.houseMortgage;

import com.qibao.core.common.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/houseLoan")
public class HouseLoanController {

    @Autowired
    private IHousingLoanCalculationUtil  housingLoanCalculationUtil;

    /**
     * 计算器主页
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "houseLoan/index";
    }

    /**
     * 计算接口
     * @param principal 本金
     * @param interestRateYear 年利率
     * @param repaymentTimeMonth 还款月数
     * @param date 首月还款时间
     * @return
     */
    @RequestMapping("/caculate")
    public AjaxResult caculate(@RequestParam("principal")Double principal,
                               @RequestParam("interestRateYear")Double interestRateYear,
                               @RequestParam("repaymentTimeMonth")int repaymentTimeMonth,
                               @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return AjaxResult.getOK(housingLoanCalculationUtil.getAll(principal,interestRateYear,repaymentTimeMonth,date));
    }

}
