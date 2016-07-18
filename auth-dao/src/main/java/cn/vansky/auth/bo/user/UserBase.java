/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.user;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `tb_user`
 */
public abstract class UserBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_user`.Id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_user`.Id
     */
    private static final String PROPERTY_REMARK_ID = "用户ID";

    /**
     * This field corresponds to the database column `tb_user`.Id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_user`.name
     */
    private static final String PROPERTY_NAME = "name";

    /**
     * This field corresponds to the database column `tb_user`.name
     */
    private static final String PROPERTY_REMARK_NAME = "用户名";

    /**
     * This field corresponds to the database column `tb_user`.name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAME)
    private String name;

    /**
     * This field corresponds to the database column `tb_user`.password
     */
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * This field corresponds to the database column `tb_user`.password
     */
    private static final String PROPERTY_REMARK_PASSWORD = "用户密码";

    /**
     * This field corresponds to the database column `tb_user`.password
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PASSWORD)
    private String password;

    /**
     * This field corresponds to the database column `tb_user`.email
     */
    private static final String PROPERTY_EMAIL = "email";

    /**
     * This field corresponds to the database column `tb_user`.email
     */
    private static final String PROPERTY_REMARK_EMAIL = "邮箱";

    /**
     * This field corresponds to the database column `tb_user`.email
     */
    @ColumnDescription(desc = PROPERTY_REMARK_EMAIL)
    private String email;

    /**
     * This field corresponds to the database column `tb_user`.phone
     */
    private static final String PROPERTY_PHONE = "phone";

    /**
     * This field corresponds to the database column `tb_user`.phone
     */
    private static final String PROPERTY_REMARK_PHONE = "手机号";

    /**
     * This field corresponds to the database column `tb_user`.phone
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PHONE)
    private String phone;

    /**
     * This field corresponds to the database column `tb_user`.sex
     */
    private static final String PROPERTY_SEX = "sex";

    /**
     * This field corresponds to the database column `tb_user`.sex
     */
    private static final String PROPERTY_REMARK_SEX = "性别，1:男，2:女";

    /**
     * This field corresponds to the database column `tb_user`.sex
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SEX)
    private Byte sex;

    /**
     * This field corresponds to the database column `tb_user`.role_id
     */
    private static final String PROPERTY_ROLEID = "roleId";

    /**
     * This field corresponds to the database column `tb_user`.role_id
     */
    private static final String PROPERTY_REMARK_ROLEID = "角色ID";

    /**
     * This field corresponds to the database column `tb_user`.role_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ROLEID)
    private Integer roleId;

    /**
     * This field corresponds to the database column `tb_user`.system_id
     */
    private static final String PROPERTY_SYSTEMID = "systemId";

    /**
     * This field corresponds to the database column `tb_user`.system_id
     */
    private static final String PROPERTY_REMARK_SYSTEMID = "系统ID";

    /**
     * This field corresponds to the database column `tb_user`.system_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SYSTEMID)
    private Integer systemId;

    /**
     * This field corresponds to the database column `tb_user`.status
     */
    private static final String PROPERTY_STATUS = "status";

    /**
     * This field corresponds to the database column `tb_user`.status
     */
    private static final String PROPERTY_REMARK_STATUS = "状态:1:可用,2:不可用";

    /**
     * This field corresponds to the database column `tb_user`.status
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STATUS)
    private Byte status;

    /**
     * This field corresponds to the database column `tb_user`.create_id
     */
    private static final String PROPERTY_CREATEID = "createId";

    /**
     * This field corresponds to the database column `tb_user`.create_id
     */
    private static final String PROPERTY_REMARK_CREATEID = "操作人ID";

    /**
     * This field corresponds to the database column `tb_user`.create_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATEID)
    private Integer createId;

    /**
     * This field corresponds to the database column `tb_user`.create_time
     */
    private static final String PROPERTY_CREATETIME = "createTime";

    /**
     * This field corresponds to the database column `tb_user`.create_time
     */
    private static final String PROPERTY_REMARK_CREATETIME = "创建时间";

    /**
     * This field corresponds to the database column `tb_user`.create_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATETIME)
    private Date createTime;

    /**
     * This method returns the value of the database column `tb_user`.Id
     *
     * @return the value of `tb_user`.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_user`.Id
     *
     * @param id the value for `tb_user`.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_user`.name
     *
     * @return the value of `tb_user`.name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column `tb_user`.name
     *
     * @param name the value for `tb_user`.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the database column `tb_user`.password
     *
     * @return the value of `tb_user`.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the value of the database column `tb_user`.password
     *
     * @param password the value for `tb_user`.password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the value of the database column `tb_user`.email
     *
     * @return the value of `tb_user`.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the value of the database column `tb_user`.email
     *
     * @param email the value for `tb_user`.email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the value of the database column `tb_user`.phone
     *
     * @return the value of `tb_user`.phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method sets the value of the database column `tb_user`.phone
     *
     * @param phone the value for `tb_user`.phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method returns the value of the database column `tb_user`.sex
     *
     * @return the value of `tb_user`.sex
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * This method sets the value of the database column `tb_user`.sex
     *
     * @param sex the value for `tb_user`.sex
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * This method returns the value of the database column `tb_user`.role_id
     *
     * @return the value of `tb_user`.role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method sets the value of the database column `tb_user`.role_id
     *
     * @param roleId the value for `tb_user`.role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method returns the value of the database column `tb_user`.system_id
     *
     * @return the value of `tb_user`.system_id
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * This method sets the value of the database column `tb_user`.system_id
     *
     * @param systemId the value for `tb_user`.system_id
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * This method returns the value of the database column `tb_user`.status
     *
     * @return the value of `tb_user`.status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column `tb_user`.status
     *
     * @param status the value for `tb_user`.status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column `tb_user`.create_id
     *
     * @return the value of `tb_user`.create_id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * This method sets the value of the database column `tb_user`.create_id
     *
     * @param createId the value for `tb_user`.create_id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * This method returns the value of the database column `tb_user`.create_time
     *
     * @return the value of `tb_user`.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column `tb_user`.create_time
     *
     * @param createTime the value for `tb_user`.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}