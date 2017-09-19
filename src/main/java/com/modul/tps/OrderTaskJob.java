package com.modul.tps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by giozola on 2017/9/19.
 */
@Component
public class OrderTaskJob {
    private Logger logger = LoggerFactory.getLogger(OrderTaskJob.class);

    @Scheduled(cron = "0 0 8,13,17 * * ?")
    public void task() throws IOException {
        logger.info("定时任务开始了...");
        List<String> ICBCList = OrderService.getOrder(3);
        List<String> YHDList = OrderService.getOrder(5);
        OrderService.transOrder2LocalService(3,ICBCList);
        OrderService.transOrder2LocalService(5,YHDList);
    }
}
