/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.general;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `tb_attachment_business`
 */
public abstract class AttachmentBusinessBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_attachment_business`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_attachment_business`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增id";

    /**
     * This field corresponds to the database column `tb_attachment_business`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Long id;

    /**
     * This field corresponds to the database column `tb_attachment_business`.business_type
     */
    private static final String PROPERTY_BUSINESSTYPE = "businessType";

    /**
     * This field corresponds to the database column `tb_attachment_business`.business_type
     */
    private static final String PROPERTY_REMARK_BUSINESSTYPE = "业务类型";

    /**
     * This field corresponds to the database column `tb_attachment_business`.business_type
     */
    @ColumnDescription(desc = PROPERTY_REMARK_BUSINESSTYPE)
    private Integer businessType;

    /**
     * This field corresponds to the database column `tb_attachment_business`.business_id
     */
    private static final String PROPERTY_BUSINESSID = "businessId";

    /**
     * This field corresponds to the database column `tb_attachment_business`.business_id
     */
    private static final String PROPERTY_REMARK_BUSINESSID = "业务ID";

    /**
     * This field corresponds to the database column `tb_attachment_business`.business_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_BUSINESSID)
    private Long businessId;

    /**
     * This field corresponds to the database column `tb_attachment_business`.attachment_id
     */
    private static final String PROPERTY_ATTACHMENTID = "attachmentId";

    /**
     * This field corresponds to the database column `tb_attachment_business`.attachment_id
     */
    private static final String PROPERTY_REMARK_ATTACHMENTID = "附件id";

    /**
     * This field corresponds to the database column `tb_attachment_business`.attachment_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ATTACHMENTID)
    private Long attachmentId;

    /**
     * This field corresponds to the database column `tb_attachment_business`.add_time
     */
    private static final String PROPERTY_ADDTIME = "addTime";

    /**
     * This field corresponds to the database column `tb_attachment_business`.add_time
     */
    private static final String PROPERTY_REMARK_ADDTIME = "创建时间";

    /**
     * This field corresponds to the database column `tb_attachment_business`.add_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ADDTIME)
    private Date addTime;

    /**
     * This field corresponds to the database column `tb_attachment_business`.flag
     */
    private static final String PROPERTY_FLAG = "flag";

    /**
     * This field corresponds to the database column `tb_attachment_business`.flag
     */
    private static final String PROPERTY_REMARK_FLAG = "附件标志,1:可编辑,2:只读";

    /**
     * This field corresponds to the database column `tb_attachment_business`.flag
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FLAG)
    private Byte flag;

    /**
     * This method returns the value of the database column `tb_attachment_business`.id
     *
     * @return the value of `tb_attachment_business`.id
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_attachment_business`.id
     *
     * @param id the value for `tb_attachment_business`.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_attachment_business`.business_type
     *
     * @return the value of `tb_attachment_business`.business_type
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * This method sets the value of the database column `tb_attachment_business`.business_type
     *
     * @param businessType the value for `tb_attachment_business`.business_type
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * This method returns the value of the database column `tb_attachment_business`.business_id
     *
     * @return the value of `tb_attachment_business`.business_id
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * This method sets the value of the database column `tb_attachment_business`.business_id
     *
     * @param businessId the value for `tb_attachment_business`.business_id
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * This method returns the value of the database column `tb_attachment_business`.attachment_id
     *
     * @return the value of `tb_attachment_business`.attachment_id
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * This method sets the value of the database column `tb_attachment_business`.attachment_id
     *
     * @param attachmentId the value for `tb_attachment_business`.attachment_id
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * This method returns the value of the database column `tb_attachment_business`.add_time
     *
     * @return the value of `tb_attachment_business`.add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method sets the value of the database column `tb_attachment_business`.add_time
     *
     * @param addTime the value for `tb_attachment_business`.add_time
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method returns the value of the database column `tb_attachment_business`.flag
     *
     * @return the value of `tb_attachment_business`.flag
     */
    public Byte getFlag() {
        return flag;
    }

    /**
     * This method sets the value of the database column `tb_attachment_business`.flag
     *
     * @param flag the value for `tb_attachment_business`.flag
     */
    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}