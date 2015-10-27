/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月24日 Created
 */
package com.xrkj.app.verification.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;

import com.xrkj.app.base.model.BaseEntity;

/**
 * <pre>
 * 验证码实体类
 * 验证码有时间限制，过期无效
 * 过期控制最好通过缓存工具管理
 * </pre>
 *
 * @author wwh
 * @date 2015年7月24日 上午11:15:13
 *
 */
public class Captcha extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 验证码文本
     */
    private String text;

    /**
     * 验证码UUID
     */
    private String uuid;

    /**
     * 验证码生成时间
     */
    private Date date;

    /**
     * 验证码图片
     */
    private BufferedImage image;

    /**
     * 验证码字节
     */
    private byte[] imageByte;

    /**
     * 获取 text
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置 text
     *
     * @param text
     *            the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取 uuid
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置 uuid
     *
     * @param uuid
     *            the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取 date
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     *
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取 image
     *
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * 设置 image
     *
     * @param image
     *            the image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * 获取 imageByte
     *
     * @return the imageByte
     */
    public byte[] getImageByte() {
        return imageByte;
    }

    /**
     * 设置 imageByte
     *
     * @param imageByte
     *            the imageByte to set
     */
    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

}
