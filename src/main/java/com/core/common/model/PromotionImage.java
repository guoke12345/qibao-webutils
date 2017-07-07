package com.core.common.model;

import java.io.Serializable;

/**
 * Created by mazz on 2015/09/12.
 */
public class PromotionImage implements Serializable {
    /**
     * 品牌logo图片
     */
    private String logoImg;

    /**
     * 大图
     */
    private String bigImg;

    /**
     * 首页图片
     */
    private String homeImg;

    /**
     * 获取 大图
     *
     * @return 大图
     */
    public String getBigImg() {
        return bigImg;
    }

    /**
     * 设置 大图
     *
     * @param bigImg 大图
     */
    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }

    /**
     * 获取 首页图片
     *
     * @return 首页图片
     */
    public String getHomeImg() {
        return homeImg;
    }

    /**
     * 设置 首页图片
     *
     * @param homeImg 首页图片
     */
    public void setHomeImg(String homeImg) {
        this.homeImg = homeImg;
    }

    /**
     * 获取 品牌logo图片
     *
     * @return 品牌logo图片
     */
    public String getLogoImg() {
        return logoImg;
    }

    /**
     * 设置 品牌logo图片
     *
     * @param logoImg 品牌logo图片
     */
    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }
}
