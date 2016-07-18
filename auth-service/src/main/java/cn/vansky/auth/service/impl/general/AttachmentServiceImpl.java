/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.impl.general;

import cn.vansky.auth.bo.general.AttachType;
import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.dao.general.AttachmentDao;
import cn.vansky.auth.dao.general.AttachmentBusinessDao;
import cn.vansky.auth.dto.attachment.AttachmentDto;
import cn.vansky.auth.service.general.AttachmentService;
import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment`
 */
@Service("attachmentService")
public class AttachmentServiceImpl extends GenericSqlMapServiceImpl<Attachment, Long> implements AttachmentService {
    @Resource(name = "attachmentDao")
    private AttachmentDao attachmentDao;

    @Resource(name = "attachmentBusinessDao")
    AttachmentBusinessDao attachmentBusinessDao;

    @Override
    public SqlMapDao<Attachment, Long> getDao() {
        return attachmentDao;
    }

    public void saveRelations(AttachType type, Long busId, Collection<Long> fileIds) {
        Preconditions.checkNotNull(type, "业务类型不能为空");
        Preconditions.checkNotNull(busId, "业务ID不能为空");
        attachmentBusinessDao.delRelations(type.getTypeId(), busId);
        if (null == fileIds || fileIds.isEmpty()) {
            return;
        }
        attachmentBusinessDao.addRelations(type.getTypeId(), busId, fileIds);
    }

    public Collection<AttachmentDto> readAttachments(AttachType type, Long busId) {
        return attachmentDao.readAttachments(type.getTypeId(), busId);
    }
}