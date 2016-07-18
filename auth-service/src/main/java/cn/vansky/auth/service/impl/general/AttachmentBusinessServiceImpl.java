/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.impl.general;

import cn.vansky.auth.bo.general.AttachmentBusiness;
import cn.vansky.auth.dao.general.AttachmentBusinessDao;
import cn.vansky.auth.service.general.AttachmentBusinessService;
import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `tb_attachment_business`
 */
@Service("attachmentBusinessService")
public class AttachmentBusinessServiceImpl extends GenericSqlMapServiceImpl<AttachmentBusiness, Long> implements AttachmentBusinessService {
    @Resource(name = "attachmentBusinessDao")
    private AttachmentBusinessDao attachmentBusinessDao;

    @Override
    public SqlMapDao<AttachmentBusiness, Long> getDao() {
        return attachmentBusinessDao;
    }
}