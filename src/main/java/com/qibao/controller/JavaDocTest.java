package com.qibao.controller;

import com.qibao.dto.HousingLoanDto;
import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 接口文档测试类
 * @author 张伟超
 * @create 2017/10/15 0015
 **/
@Controller
@RequestMapping(value = "zhang")
public class JavaDocTest {

    /**
     * 文档接口测试
     * @param name 姓名
     * @param age 年龄
     * @return
     */
    @RequestMapping(value = "/san",method = RequestMethod.POST)
    @ApiDoc(HousingLoanDto.class)
    public String testDoc(@RequestParam String name,@RequestParam Integer age){

        return "张三利息";
    }

    /**
     * 不生成文档的测试方法
     * @param name 姓名
     * @param age 年龄
     * @return
     */
    @RequestMapping(value = "/si",method = RequestMethod.POST)
    @ApiDoc(HousingLoanDto.class)
    @Deprecated
    public String testNoDoc(@RequestParam String name,@RequestParam Integer age){

        return "张三利息";
    }
}
