/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.impl.general;

import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.dao.general.AttachmentDao;
import cn.vansky.auth.dao.general.AttachmentMapper;
import cn.vansky.auth.dto.attachment.AttachmentDto;
import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment`
 */
@Repository("attachmentDao")
public class AttachmentDaoImpl extends ConfigurableBaseSqlMapDao<Attachment, Long> implements AttachmentDao {
    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public DaoMapper<Attachment, Long> getDaoMapper() {
        return attachmentMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public Collection<AttachmentDto> readAttachments(int typeId, long busId) {
        return attachmentMapper.readAttachments(typeId, busId);
    }
}