/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.roleMenu;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_role_menu`
 */
public abstract class RoleMenuBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_role_menu`.Id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_role_menu`.Id
     */
    private static final String PROPERTY_REMARK_ID = "角色-菜单ID";

    /**
     * This field corresponds to the database column `tb_role_menu`.Id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_role_menu`.role_id
     */
    private static final String PROPERTY_ROLEID = "roleId";

    /**
     * This field corresponds to the database column `tb_role_menu`.role_id
     */
    private static final String PROPERTY_REMARK_ROLEID = "角色ID";

    /**
     * This field corresponds to the database column `tb_role_menu`.role_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ROLEID)
    private Integer roleId;

    /**
     * This field corresponds to the database column `tb_role_menu`.menu_id
     */
    private static final String PROPERTY_MENUID = "menuId";

    /**
     * This field corresponds to the database column `tb_role_menu`.menu_id
     */
    private static final String PROPERTY_REMARK_MENUID = "菜单ID";

    /**
     * This field corresponds to the database column `tb_role_menu`.menu_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_MENUID)
    private Integer menuId;

    /**
     * This method returns the value of the database column `tb_role_menu`.Id
     *
     * @return the value of `tb_role_menu`.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_role_menu`.Id
     *
     * @param id the value for `tb_role_menu`.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_role_menu`.role_id
     *
     * @return the value of `tb_role_menu`.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method sets the value of the database column `tb_role_menu`.role_id
     *
     * @param roleId the value for `tb_role_menu`.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the value of the database column `tb_role_menu`.menu_id
     *
     * @return the value of `tb_role_menu`.menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method sets the value of the database column `tb_role_menu`.menu_id
     *
     * @param menuId the value for `tb_role_menu`.menu_id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}