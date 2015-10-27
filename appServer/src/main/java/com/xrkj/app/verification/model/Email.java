/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月28日 Created
 */
package com.xrkj.app.verification.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.xrkj.app.base.model.BaseEntity;

/**
 * <pre>
 * 电子邮件
 * 考虑一下还是觉得应该将邮件对象保存到数据库中
 * 先不做，需要的时候再看看设计成什么样子
 * </pre>
 *
 * @author wwh
 * @date 2015年7月28日 上午11:44:18
 *
 */
public class Email extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮件ID
     */
    private long id;//发送完了应该有一个地方标记状态，成功，失败等，有记录可查

    /**
     * 发送者
     */
    private String from;

    /**
     * 收件人列表
     */
    private String[] to;

    /**
     * 抄送人列表
     */
    private String[] cc;

    /**
     * 暗送人列表
     */
    private String[] bcc;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容，HTML格式
     */
    private String text;

    /**
     * 内连的对象
     */
    private Map<String, Resource> inline;

    /**
     * 附件
     */
    private MultipartFile[] attachment;

    /**
     * 获取 id
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * 设置 id
     *
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获取 from
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * 设置 from
     *
     * @param from
     *            the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 获取 to
     *
     * @return the to
     */
    public String[] getTo() {
        return to;
    }

    /**
     * 设置 to
     *
     * @param to
     *            the to to set
     */
    public void setTo(String[] to) {
        this.to = to;
    }

    /**
     * 获取 cc
     *
     * @return the cc
     */
    public String[] getCc() {
        return cc;
    }

    /**
     * 设置 cc
     *
     * @param cc
     *            the cc to set
     */
    public void setCc(String[] cc) {
        this.cc = cc;
    }

    /**
     * 获取 bcc
     *
     * @return the bcc
     */
    public String[] getBcc() {
        return bcc;
    }

    /**
     * 设置 bcc
     *
     * @param bcc
     *            the bcc to set
     */
    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    /**
     * 获取 subject
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置 subject
     *
     * @param subject
     *            the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

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
     * 获取 inline
     *
     * @return the inline
     */
    public Map<String, Resource> getInline() {
        return inline;
    }

    /**
     * 设置 inline
     *
     * @param inline
     *            the inline to set
     */
    public void setInline(Map<String, Resource> inline) {
        this.inline = inline;
    }

    /**
     * 获取 attachment
     *
     * @return the attachment
     */
    public MultipartFile[] getAttachment() {
        return attachment;
    }

    /**
     * 设置 attachment
     *
     * @param attachment
     *            the attachment to set
     */
    public void setAttachment(MultipartFile[] attachment) {
        this.attachment = attachment;
    }

}
