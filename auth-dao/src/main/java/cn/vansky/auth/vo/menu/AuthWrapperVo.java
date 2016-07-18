/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.vo.menu;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/5/22
 */
public class AuthWrapperVo {
    private Integer userId;
    private Integer systemId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
}
