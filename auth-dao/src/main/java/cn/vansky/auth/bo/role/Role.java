/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.role;

/**
 * This class corresponds to the database table `tb_role`
 */
public class Role extends RoleBase {
    private String menuIds;

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }
}