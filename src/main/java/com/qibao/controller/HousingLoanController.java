package com.qibao.controller;

import com.core.common.model.AjaxResult;
import com.core.controller.BaseController;
import com.qibao.dto.HousingLoanDto;
import com.qibao.service.IHousingLoanCalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by giozola on 2017/8/3.
 */
@Controller
@RequestMapping(value = "/houseloan")
public class HousingLoanController extends BaseController{

    @Autowired
    IHousingLoanCalculationUtil housingLoanCalculationUtil;

    /**
     * 页面
     * @return
     */
    @RequestMapping(value = "")
    public String toHouseLoanPage(){
        System.out.println("to house loan page!");
        return "houseloan";
    }

    /**
     * 还款列表
     * @param housingLoanDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getRepayment",method = RequestMethod.POST)
    public AjaxResult getRepayment(HousingLoanDto housingLoanDto){
        List<HousingLoanDto>  rapaymentDto  = housingLoanCalculationUtil.getAll(housingLoanDto);
        return AjaxResult.getOK(rapaymentDto);
    }

}
