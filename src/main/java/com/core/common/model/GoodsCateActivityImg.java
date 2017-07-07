package com.core.common.model;

import java.io.Serializable;

/**
 * Created by supumall on 2015/9/16.
 */
public class GoodsCateActivityImg implements Serializable {

    /**
     * 活动图片1
     */
    private String image1;
    /**
     * 活动链接1
     */
    private String url1;
    /**
     * 活动图片2
     */
    private String image2;
    /**
     * 活动链接2
     */
    private String url2;


    /**
     * 构造活动图片对象
     */
    public GoodsCateActivityImg(){

    }

    /**
     * 构造活动图片对象
     *
     * @param image1 活动路片1
     * @param url1 活动路径
     * @param image2 活动图片2
     * @param url2 活动路径
     */
    public GoodsCateActivityImg(String image1, String url1, String image2, String url2) {
        this.image1 = image1;
        this.url1 = url1;
        this.image2 = image2;
        this.url2 = url2;
    }

    /**
     * 获取 活动图片1
     *
     * @return 活动图片1 image 1
     */
    public String getImage1() {
        return image1;
    }

    /**
     * 设置 活动图片1
     *
     * @param image1 活动图片1
     */
    public void setImage1(String image1) {
        this.image1 = image1;
    }

    /**
     * 获取 链接1
     *
     * @return 链接1 url 1
     */
    public String getUrl1() {
        return url1;
    }

    /**
     * 设置 链接1
     *
     * @param url1 链接1
     */
    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    /**
     * 获取 活动图片2
     *
     * @return 活动图片 image 2
     */
    public String getImage2() {
        return image2;
    }

    /**
     * 设置 活动图片2
     *
     * @param image2 活动图片2
     */
    public void setImage2(String image2) {
        this.image2 = image2;
    }

    /**
     * 获取 链接2
     *
     * @return 链接2 url 2
     */
    public String getUrl2() {
        return url2;
    }

    /**
     * 设置 链接2
     *
     * @param url2 链接2
     */
    public void setUrl2(String url2) {
        this.url2 = url2;
    }
}
