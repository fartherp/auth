/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.userMenu;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_user_menu`
 */
public abstract class UserMenuBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_user_menu`.Id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_user_menu`.Id
     */
    private static final String PROPERTY_REMARK_ID = "用户-菜单ID";

    /**
     * This field corresponds to the database column `tb_user_menu`.Id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_user_menu`.user_id
     */
    private static final String PROPERTY_USERID = "userId";

    /**
     * This field corresponds to the database column `tb_user_menu`.user_id
     */
    private static final String PROPERTY_REMARK_USERID = "用户ID";

    /**
     * This field corresponds to the database column `tb_user_menu`.user_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_USERID)
    private Integer userId;

    /**
     * This field corresponds to the database column `tb_user_menu`.menu_id
     */
    private static final String PROPERTY_MENUID = "menuId";

    /**
     * This field corresponds to the database column `tb_user_menu`.menu_id
     */
    private static final String PROPERTY_REMARK_MENUID = "菜单ID";

    /**
     * This field corresponds to the database column `tb_user_menu`.menu_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_MENUID)
    private Integer menuId;

    /**
     * This method returns the value of the database column `tb_user_menu`.Id
     *
     * @return the value of `tb_user_menu`.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_user_menu`.Id
     *
     * @param id the value for `tb_user_menu`.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_user_menu`.user_id
     *
     * @return the value of `tb_user_menu`.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method sets the value of the database column `tb_user_menu`.user_id
     *
     * @param userId the value for `tb_user_menu`.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column `tb_user_menu`.menu_id
     *
     * @return the value of `tb_user_menu`.menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method sets the value of the database column `tb_user_menu`.menu_id
     *
     * @param menuId the value for `tb_user_menu`.menu_id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}