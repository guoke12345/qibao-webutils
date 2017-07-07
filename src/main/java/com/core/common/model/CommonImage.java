package com.core.common.model;

import java.io.Serializable;

/**
 * Created by Jemry.Liu on 2015/6/15.
 */
public class CommonImage implements Serializable {

    /**
     * pc端图片
     */
    private String pcImage;

    /**
     * 移动端图片
     */
    private String appImage;

    /**
     * 构造图片对象
     *
     * @param pcImage pc端图片
     * @param appImage 移动端图片
     */
    public CommonImage(String pcImage, String appImage) {
        this.pcImage = pcImage;
        this.appImage = appImage;
    }

    /**
     * 构造图片对象
     */
    public CommonImage() {

    }

    /**
     * 获取 pc端图片
     *
     * @return pc端图片
     */
    public String getPcImage() {
        return pcImage;
    }

    /**
     * 设置 pc端图片
     *
     * @param pcImage pc端图片
     */
    public void setPcImage(String pcImage) {
        this.pcImage = pcImage;
    }

    /**
     * 获取 移动端图片
     *
     * @return 移动端图片
     */
    public String getAppImage() {
        return appImage;
    }

    /**
     * 设置 移动端图片
     *
     * @param appImage 移动端图片
     */
    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }
}
