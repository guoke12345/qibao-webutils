package com.qibao.webutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 启动测试类
 * @version 1.0.0
 * @Description:
 * @author: weichao 2019/2/21 17 25
 */
@Controller
public class HelloWorld {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @RequestMapping("/test")
    public String  test(){
        logger.info("helloWorld!");
        return "HelloWorld";
    }
}
