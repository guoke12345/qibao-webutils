package com.qibao.controller;

import com.core.controller.BaseController;
import com.qibao.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by giozola on 2017/6/26.
 */
@Controller
@RequestMapping(value = "index")
public class Index extends BaseController{

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "hello")
    public String hello(){
        System.out.println(studentService.getByName().getClasses());
        return "index";
    }
}
