/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.menu;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `tb_menu`
 */
public abstract class MenuBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_menu`.Id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_menu`.Id
     */
    private static final String PROPERTY_REMARK_ID = "菜单ID";

    /**
     * This field corresponds to the database column `tb_menu`.Id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_menu`.name
     */
    private static final String PROPERTY_NAME = "name";

    /**
     * This field corresponds to the database column `tb_menu`.name
     */
    private static final String PROPERTY_REMARK_NAME = "菜单名称";

    /**
     * This field corresponds to the database column `tb_menu`.name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAME)
    private String name;

    /**
     * This field corresponds to the database column `tb_menu`.remark
     */
    private static final String PROPERTY_REMARK = "remark";

    /**
     * This field corresponds to the database column `tb_menu`.remark
     */
    private static final String PROPERTY_REMARK_REMARK = "菜单备注";

    /**
     * This field corresponds to the database column `tb_menu`.remark
     */
    @ColumnDescription(desc = PROPERTY_REMARK_REMARK)
    private String remark;

    /**
     * This field corresponds to the database column `tb_menu`.parent_id
     */
    private static final String PROPERTY_PARENTID = "parentId";

    /**
     * This field corresponds to the database column `tb_menu`.parent_id
     */
    private static final String PROPERTY_REMARK_PARENTID = "父菜单ID";

    /**
     * This field corresponds to the database column `tb_menu`.parent_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PARENTID)
    private Integer parentId;

    /**
     * This field corresponds to the database column `tb_menu`.url
     */
    private static final String PROPERTY_URL = "url";

    /**
     * This field corresponds to the database column `tb_menu`.url
     */
    private static final String PROPERTY_REMARK_URL = "菜单URL";

    /**
     * This field corresponds to the database column `tb_menu`.url
     */
    @ColumnDescription(desc = PROPERTY_REMARK_URL)
    private String url;

    /**
     * This field corresponds to the database column `tb_menu`.icon
     */
    private static final String PROPERTY_ICON = "icon";

    /**
     * This field corresponds to the database column `tb_menu`.icon
     */
    private static final String PROPERTY_REMARK_ICON = "菜单图片";

    /**
     * This field corresponds to the database column `tb_menu`.icon
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ICON)
    private String icon;

    /**
     * This field corresponds to the database column `tb_menu`.system_id
     */
    private static final String PROPERTY_SYSTEMID = "systemId";

    /**
     * This field corresponds to the database column `tb_menu`.system_id
     */
    private static final String PROPERTY_REMARK_SYSTEMID = "系统ID";

    /**
     * This field corresponds to the database column `tb_menu`.system_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SYSTEMID)
    private Integer systemId;

    /**
     * This field corresponds to the database column `tb_menu`.level
     */
    private static final String PROPERTY_LEVEL = "level";

    /**
     * This field corresponds to the database column `tb_menu`.level
     */
    private static final String PROPERTY_REMARK_LEVEL = "菜单类型:1:菜单,2:按钮";

    /**
     * This field corresponds to the database column `tb_menu`.level
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LEVEL)
    private Byte level;

    /**
     * This field corresponds to the database column `tb_menu`.status
     */
    private static final String PROPERTY_STATUS = "status";

    /**
     * This field corresponds to the database column `tb_menu`.status
     */
    private static final String PROPERTY_REMARK_STATUS = "状态,1:可用,2:不可用";

    /**
     * This field corresponds to the database column `tb_menu`.status
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STATUS)
    private Byte status;

    /**
     * This field corresponds to the database column `tb_menu`.create_id
     */
    private static final String PROPERTY_CREATEID = "createId";

    /**
     * This field corresponds to the database column `tb_menu`.create_id
     */
    private static final String PROPERTY_REMARK_CREATEID = "操作人ID";

    /**
     * This field corresponds to the database column `tb_menu`.create_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATEID)
    private Integer createId;

    /**
     * This field corresponds to the database column `tb_menu`.create_time
     */
    private static final String PROPERTY_CREATETIME = "createTime";

    /**
     * This field corresponds to the database column `tb_menu`.create_time
     */
    private static final String PROPERTY_REMARK_CREATETIME = "创建时间";

    /**
     * This field corresponds to the database column `tb_menu`.create_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATETIME)
    private Date createTime;

    /**
     * This method returns the value of the database column `tb_menu`.Id
     *
     * @return the value of `tb_menu`.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_menu`.Id
     *
     * @param id the value for `tb_menu`.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_menu`.name
     *
     * @return the value of `tb_menu`.name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column `tb_menu`.name
     *
     * @param name the value for `tb_menu`.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the database column `tb_menu`.remark
     *
     * @return the value of `tb_menu`.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method sets the value of the database column `tb_menu`.remark
     *
     * @param remark the value for `tb_menu`.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column `tb_menu`.parent_id
     *
     * @return the value of `tb_menu`.parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method sets the value of the database column `tb_menu`.parent_id
     *
     * @param parentId the value for `tb_menu`.parent_id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method returns the value of the database column `tb_menu`.url
     *
     * @return the value of `tb_menu`.url
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method sets the value of the database column `tb_menu`.url
     *
     * @param url the value for `tb_menu`.url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method returns the value of the database column `tb_menu`.icon
     *
     * @return the value of `tb_menu`.icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method sets the value of the database column `tb_menu`.icon
     *
     * @param icon the value for `tb_menu`.icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method returns the value of the database column `tb_menu`.system_id
     *
     * @return the value of `tb_menu`.system_id
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * This method sets the value of the database column `tb_menu`.system_id
     *
     * @param systemId the value for `tb_menu`.system_id
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * This method returns the value of the database column `tb_menu`.level
     *
     * @return the value of `tb_menu`.level
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * This method sets the value of the database column `tb_menu`.level
     *
     * @param level the value for `tb_menu`.level
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * This method returns the value of the database column `tb_menu`.status
     *
     * @return the value of `tb_menu`.status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column `tb_menu`.status
     *
     * @param status the value for `tb_menu`.status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column `tb_menu`.create_id
     *
     * @return the value of `tb_menu`.create_id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * This method sets the value of the database column `tb_menu`.create_id
     *
     * @param createId the value for `tb_menu`.create_id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * This method returns the value of the database column `tb_menu`.create_time
     *
     * @return the value of `tb_menu`.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column `tb_menu`.create_time
     *
     * @param createTime the value for `tb_menu`.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}