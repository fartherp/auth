/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.user;

/**
 * This class corresponds to the database table `tb_user`
 */
public class User extends UserBase {

    /** 账户可用 */
    public static final Byte USE_ABLE = 1;

    /** 账户不可用 */
    public static final Byte NO_USE_ABLE = 2;

    private String menuIds;

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }
}