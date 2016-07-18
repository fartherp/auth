/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.general;

import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.dto.attachment.AttachmentDto;
import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment`
 */
@SqlMapper
public interface AttachmentMapper extends DaoMapper<Attachment, Long> {
    /**
     * 根据业务类型及业务id获取附件列表
     * @param typeId 业务类型
     * @param busId 业务id
     * @return 附件列表
     */
    Collection<AttachmentDto> readAttachments(@Param("typeId") int typeId, @Param("busId") long busId);
}