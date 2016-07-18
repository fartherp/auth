/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.user;

/**
 * This class corresponds to the database table `tb_user`
 */
public class User extends UserBase {
    private String menuIds;

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }
}