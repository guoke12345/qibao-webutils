package com.modul.tps;

import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Created by giozola on 2017/9/19.
 */
@Controller
@RequestMapping("/tps/order")
public class OrderController {
    @RequestMapping(value = "transTask",method = RequestMethod.POST)
    public void TransOrderTask() throws IOException {
        List<String> ICBCList = OrderService.getOrder(3);
        List<String> YHDList = OrderService.getOrder(5);
        OrderService.transOrder2LocalService(3,ICBCList);
        OrderService.transOrder2LocalService(5,YHDList);
    }
}
