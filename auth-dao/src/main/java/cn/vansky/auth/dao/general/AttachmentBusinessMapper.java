/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.general;

import cn.vansky.auth.bo.general.AttachmentBusiness;
import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment_business`
 */
@SqlMapper
public interface AttachmentBusinessMapper extends DaoMapper<AttachmentBusiness, Long> {
    /**
     * Del relations.
     *
     * @param typeId the type id
     * @param busId the bus id
     */
    void delRelations(@Param("typeId") int typeId, @Param("busId") long busId);

    /**
     * Adds the relations.
     *
     * @param typeId the type id
     * @param busId the bus id
     * @param fileIds the file ids
     */
    void addRelations(@Param("typeId") int typeId,
                      @Param("busId") long busId,
                      @Param("fileIds") Collection<Long> fileIds);
}