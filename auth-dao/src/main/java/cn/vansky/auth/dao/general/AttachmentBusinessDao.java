/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.general;

import cn.vansky.auth.bo.general.AttachmentBusiness;
import cn.vansky.framework.core.dao.SqlMapDao;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment_business`
 */
public interface AttachmentBusinessDao extends SqlMapDao<AttachmentBusiness, Long> {

    /**
     * Del relations.
     *
     * @param typeId the type id
     * @param busId the bus id
     */
    void delRelations(int typeId, long busId);
    /**
     * Adds the relations.
     *
     * @param typeId the type id
     * @param busId the bus id
     * @param fileIds the file ids
     */
    void addRelations(int typeId, long busId, Collection<Long> fileIds);
}