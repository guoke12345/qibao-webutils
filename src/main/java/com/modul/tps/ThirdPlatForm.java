package com.modul.tps;

import com.core.common.exception.BusinessException;

public enum ThirdPlatForm {
    ICBC(3, "ICBC","http://192.168.5.51:8180/tps/admin/order/getICBCOrders"),YHD(5, "YHD","http://192.168.5.51:8180/tps/admin/order/getYHDOrders");

    private int _id;

    private String _name;

    private String _url;

    ThirdPlatForm(int id, String name,String url){
        _id = id;
        _name = name;
        _url = url;
    }

    public int getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    public String getUrl(){
        return _url;
    }
    public static String getNameById(int id) throws BusinessException {
        ThirdPlatForm result = null;

        for(ThirdPlatForm requestFrom : ThirdPlatForm.values()){
            if(requestFrom._id == id){
                result = requestFrom;
            }
        }
        if(result == null){
            throw new BusinessException("系统中未包含此请求来源类型");
        }else {
            return result.getName();
        }

    }
    public static String getUrlById(int id) throws BusinessException {
        ThirdPlatForm result = null;

        for(ThirdPlatForm requestFrom : ThirdPlatForm.values()){
            if(requestFrom._id == id){
                result = requestFrom;
            }
        }
        if(result == null){
            throw new BusinessException("系统中未包含此请求来源类型");
        }else {
            return result.getUrl();
        }

    }
    public static Integer getIdByName(String name) throws BusinessException {
        ThirdPlatForm result = null;

        for(ThirdPlatForm requestFrom : ThirdPlatForm.values()){
            if(requestFrom._name == name){
                result = requestFrom;
            }
        }
        if(result == null){
            throw new BusinessException("系统中未包含此请求来源类型");
        }else {
            return result.getId();
        }

    }
}