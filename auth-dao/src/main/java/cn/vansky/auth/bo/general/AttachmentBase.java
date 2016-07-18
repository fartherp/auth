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
 * This class corresponds to the database table `tb_attachment`
 */
public abstract class AttachmentBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_attachment`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_attachment`.id
     */
    private static final String PROPERTY_REMARK_ID = "附件id";

    /**
     * This field corresponds to the database column `tb_attachment`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Long id;

    /**
     * This field corresponds to the database column `tb_attachment`.business_type
     */
    private static final String PROPERTY_BUSINESSTYPE = "businessType";

    /**
     * This field corresponds to the database column `tb_attachment`.business_type
     */
    private static final String PROPERTY_REMARK_BUSINESSTYPE = "业务类型";

    /**
     * This field corresponds to the database column `tb_attachment`.business_type
     */
    @ColumnDescription(desc = PROPERTY_REMARK_BUSINESSTYPE)
    private Integer businessType;

    /**
     * This field corresponds to the database column `tb_attachment`.file_type
     */
    private static final String PROPERTY_FILETYPE = "fileType";

    /**
     * This field corresponds to the database column `tb_attachment`.file_type
     */
    private static final String PROPERTY_REMARK_FILETYPE = "附件类型";

    /**
     * This field corresponds to the database column `tb_attachment`.file_type
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FILETYPE)
    private String fileType;

    /**
     * This field corresponds to the database column `tb_attachment`.name
     */
    private static final String PROPERTY_NAME = "name";

    /**
     * This field corresponds to the database column `tb_attachment`.name
     */
    private static final String PROPERTY_REMARK_NAME = "附件显示名称";

    /**
     * This field corresponds to the database column `tb_attachment`.name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAME)
    private String name;

    /**
     * This field corresponds to the database column `tb_attachment`.path
     */
    private static final String PROPERTY_PATH = "path";

    /**
     * This field corresponds to the database column `tb_attachment`.path
     */
    private static final String PROPERTY_REMARK_PATH = "存储路径";

    /**
     * This field corresponds to the database column `tb_attachment`.path
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PATH)
    private String path;

    /**
     * This field corresponds to the database column `tb_attachment`.file_name
     */
    private static final String PROPERTY_FILENAME = "fileName";

    /**
     * This field corresponds to the database column `tb_attachment`.file_name
     */
    private static final String PROPERTY_REMARK_FILENAME = "文件名称";

    /**
     * This field corresponds to the database column `tb_attachment`.file_name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FILENAME)
    private String fileName;

    /**
     * This field corresponds to the database column `tb_attachment`.add_time
     */
    private static final String PROPERTY_ADDTIME = "addTime";

    /**
     * This field corresponds to the database column `tb_attachment`.add_time
     */
    private static final String PROPERTY_REMARK_ADDTIME = "上传时间";

    /**
     * This field corresponds to the database column `tb_attachment`.add_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ADDTIME)
    private Date addTime;

    /**
     * This field corresponds to the database column `tb_attachment`.add_user_id
     */
    private static final String PROPERTY_ADDUSERID = "addUserId";

    /**
     * This field corresponds to the database column `tb_attachment`.add_user_id
     */
    private static final String PROPERTY_REMARK_ADDUSERID = "上传人";

    /**
     * This field corresponds to the database column `tb_attachment`.add_user_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ADDUSERID)
    private Long addUserId;

    /**
     * This method returns the value of the database column `tb_attachment`.id
     *
     * @return the value of `tb_attachment`.id
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.id
     *
     * @param id the value for `tb_attachment`.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.business_type
     *
     * @return the value of `tb_attachment`.business_type
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.business_type
     *
     * @param businessType the value for `tb_attachment`.business_type
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.file_type
     *
     * @return the value of `tb_attachment`.file_type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.file_type
     *
     * @param fileType the value for `tb_attachment`.file_type
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.name
     *
     * @return the value of `tb_attachment`.name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.name
     *
     * @param name the value for `tb_attachment`.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.path
     *
     * @return the value of `tb_attachment`.path
     */
    public String getPath() {
        return path;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.path
     *
     * @param path the value for `tb_attachment`.path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.file_name
     *
     * @return the value of `tb_attachment`.file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.file_name
     *
     * @param fileName the value for `tb_attachment`.file_name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.add_time
     *
     * @return the value of `tb_attachment`.add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.add_time
     *
     * @param addTime the value for `tb_attachment`.add_time
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method returns the value of the database column `tb_attachment`.add_user_id
     *
     * @return the value of `tb_attachment`.add_user_id
     */
    public Long getAddUserId() {
        return addUserId;
    }

    /**
     * This method sets the value of the database column `tb_attachment`.add_user_id
     *
     * @param addUserId the value for `tb_attachment`.add_user_id
     */
    public void setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
    }
}