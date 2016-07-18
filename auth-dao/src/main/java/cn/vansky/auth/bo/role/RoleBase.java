/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.role;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `tb_role`
 */
public abstract class RoleBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_role`.Id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_role`.Id
     */
    private static final String PROPERTY_REMARK_ID = "角色ID";

    /**
     * This field corresponds to the database column `tb_role`.Id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_role`.name
     */
    private static final String PROPERTY_NAME = "name";

    /**
     * This field corresponds to the database column `tb_role`.name
     */
    private static final String PROPERTY_REMARK_NAME = "角色名";

    /**
     * This field corresponds to the database column `tb_role`.name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAME)
    private String name;

    /**
     * This field corresponds to the database column `tb_role`.remark
     */
    private static final String PROPERTY_REMARK = "remark";

    /**
     * This field corresponds to the database column `tb_role`.remark
     */
    private static final String PROPERTY_REMARK_REMARK = "备注";

    /**
     * This field corresponds to the database column `tb_role`.remark
     */
    @ColumnDescription(desc = PROPERTY_REMARK_REMARK)
    private String remark;

    /**
     * This field corresponds to the database column `tb_role`.system_id
     */
    private static final String PROPERTY_SYSTEMID = "systemId";

    /**
     * This field corresponds to the database column `tb_role`.system_id
     */
    private static final String PROPERTY_REMARK_SYSTEMID = "系统ID";

    /**
     * This field corresponds to the database column `tb_role`.system_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SYSTEMID)
    private Integer systemId;

    /**
     * This field corresponds to the database column `tb_role`.status
     */
    private static final String PROPERTY_STATUS = "status";

    /**
     * This field corresponds to the database column `tb_role`.status
     */
    private static final String PROPERTY_REMARK_STATUS = "状态:1:可用,2:不可用";

    /**
     * This field corresponds to the database column `tb_role`.status
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STATUS)
    private Byte status;

    /**
     * This field corresponds to the database column `tb_role`.create_id
     */
    private static final String PROPERTY_CREATEID = "createId";

    /**
     * This field corresponds to the database column `tb_role`.create_id
     */
    private static final String PROPERTY_REMARK_CREATEID = "操作人ID";

    /**
     * This field corresponds to the database column `tb_role`.create_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATEID)
    private Integer createId;

    /**
     * This field corresponds to the database column `tb_role`.create_time
     */
    private static final String PROPERTY_CREATETIME = "createTime";

    /**
     * This field corresponds to the database column `tb_role`.create_time
     */
    private static final String PROPERTY_REMARK_CREATETIME = "创建时间";

    /**
     * This field corresponds to the database column `tb_role`.create_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATETIME)
    private Date createTime;

    /**
     * This method returns the value of the database column `tb_role`.Id
     *
     * @return the value of `tb_role`.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_role`.Id
     *
     * @param id the value for `tb_role`.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_role`.name
     *
     * @return the value of `tb_role`.name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column `tb_role`.name
     *
     * @param name the value for `tb_role`.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the database column `tb_role`.remark
     *
     * @return the value of `tb_role`.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method sets the value of the database column `tb_role`.remark
     *
     * @param remark the value for `tb_role`.remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column `tb_role`.system_id
     *
     * @return the value of `tb_role`.system_id
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * This method sets the value of the database column `tb_role`.system_id
     *
     * @param systemId the value for `tb_role`.system_id
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * This method returns the value of the database column `tb_role`.status
     *
     * @return the value of `tb_role`.status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column `tb_role`.status
     *
     * @param status the value for `tb_role`.status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column `tb_role`.create_id
     *
     * @return the value of `tb_role`.create_id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * This method sets the value of the database column `tb_role`.create_id
     *
     * @param createId the value for `tb_role`.create_id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * This method returns the value of the database column `tb_role`.create_time
     *
     * @return the value of `tb_role`.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column `tb_role`.create_time
     *
     * @param createTime the value for `tb_role`.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}