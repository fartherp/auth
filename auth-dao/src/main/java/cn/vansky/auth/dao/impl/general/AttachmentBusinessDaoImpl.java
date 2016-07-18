/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.impl.general;

import cn.vansky.auth.bo.general.AttachmentBusiness;
import cn.vansky.auth.dao.general.AttachmentBusinessDao;
import cn.vansky.auth.dao.general.AttachmentBusinessMapper;
import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * This class corresponds to the database table `tb_attachment_business`
 */
@Repository("attachmentBusinessDao")
public class AttachmentBusinessDaoImpl extends ConfigurableBaseSqlMapDao<AttachmentBusiness, Long> implements AttachmentBusinessDao {
    @Autowired
    private AttachmentBusinessMapper attachmentBusinessMapper;

    @Override
    public DaoMapper<AttachmentBusiness, Long> getDaoMapper() {
        return attachmentBusinessMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public void delRelations(int typeId, long busId) {
        attachmentBusinessMapper.delRelations(typeId, busId);
    }

    @Override
    public void addRelations(int typeId, long busId, Collection<Long> fileIds) {
        attachmentBusinessMapper.addRelations(typeId, busId, fileIds);
    }
}