/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dto.attachment;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/3/11
 */
public class AttachmentDto {
    /**
     * 附件ID
     */
    private Long id;
    /**
     * 附件名称
     */
    private String name;
    /**
     * 业务类型名称
     */
    private String busType;
    /**
     * 创建人
     */
    private String createUserName;
    /**
     * 添加时间
     */
    private String addTimeStr;
    /**
     * 下载URL
     */
    private String url;
    /**
     * 编辑标志
     */
    private int flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getAddTimeStr() {
        return addTimeStr;
    }

    public void setAddTimeStr(String addTimeStr) {
        this.addTimeStr = addTimeStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
