package com.modul.tps;

import com.core.common.exception.BusinessException;
import com.core.util.PostHelper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


/**
 * Created by giozola on 2017/9/19.
 */
public class OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    /**
     * 拉订单
      * @param _id
     * @return
     * @throws IOException
     */
    synchronized public static List<String> getOrder(Integer _id) throws IOException {
        logger.info("开始拉订单。");
        logger.info("拉取 {} 平台订单",ThirdPlatForm.getNameById(_id));
        String stringResult = null;
        StringBuffer requestParam = new StringBuffer("");
        try{
            stringResult = PostHelper.postStringEntity(ThirdPlatForm.getUrlById(_id),requestParam.toString());
        }catch (Exception e){
            logger.info("拉订单失败！");
        }
        logger.info("拉倒订单信息："+stringResult);
        if (stringResult ==null || stringResult.isEmpty()){
            return null;
        }
        JSONObject jsonResult = JSONObject.fromObject(stringResult);
        jsonResult = JSONObject.fromObject(jsonResult.get("data"));
        OrderGetMSG orderGetMSG  = (OrderGetMSG) JSONObject.toBean(jsonResult,OrderGetMSG.class);
        List<String>  arrayList = orderGetMSG.getOrderCodeList();
        return arrayList==null||arrayList.isEmpty() ? null : arrayList;
    }

    /**
     * 转存
     * @param id
     * @param orderCodeList
     * @throws IOException
     */
    synchronized public static void transOrder2LocalService(Integer id,List<String> orderCodeList) throws IOException {
        if (orderCodeList == null || orderCodeList.isEmpty()){
            throw new BusinessException("获取订单为空，没有可以转存的订单");
        }
         String stringResult = null;
         for (String string:orderCodeList) {
             String url  = "";
             StringBuffer requestParam = new StringBuffer("");
             try {
                 url = "http://120.27.228.102:8180/tps/admin/orderShop/transOrder2Local";
                 requestParam.append("platFlag=").append(id).append("&")
                         .append("orderCode=").append(string);
                 stringResult = PostHelper.postStringEntity(url,requestParam.toString());
             }catch (Exception e) {
                 logger.info("转存 失败 ，单号为：{}",string);
                 logger.info("服务器错误！ "+e);
             }
             if (stringResult.contains("true")){
                 logger.info("{} 转存成功！",string);
             }else{
                 logger.info("{} 转存失败 ！",string);
                 }
             }
         }
}
