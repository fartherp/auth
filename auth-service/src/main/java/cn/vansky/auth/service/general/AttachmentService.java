/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.general;

import cn.vansky.auth.bo.general.AttachType;
import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.dto.attachment.AttachmentDto;
import cn.vansky.framework.core.service.GenericService;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment`
 */
public interface AttachmentService extends GenericService<Attachment, Long> {
    /**
     * 批量保存附件与业务关系, 当前业务实体有多个附件对象.
     * @param type 业务类型
     * @param busId 业务实体
     * @param fileIds 文件id集合
     */
    void saveRelations(AttachType type, Long busId, Collection<Long> fileIds);

    /**
     * 读取指定业务实体下挂的附件集合.
     *
     * 读取后的AttachFile对象中,包含该文件下载的url字段.
     *
     * @param type 业务类型
     * @param busId 业务实体
     * @return 附件集合
     */
    Collection<AttachmentDto> readAttachments(AttachType type, Long busId);
}