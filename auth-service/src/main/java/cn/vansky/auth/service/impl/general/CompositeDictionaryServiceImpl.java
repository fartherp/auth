/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.impl.general;

import cn.vansky.auth.bo.general.CompositeDictionary;
import cn.vansky.auth.dao.general.CompositeDictionaryDao;
import cn.vansky.auth.service.general.CompositeDictionaryService;
import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * This class corresponds to the database table `td_composite_dictionary`
 */
@Service("compositeDictionaryService")
public class CompositeDictionaryServiceImpl extends GenericSqlMapServiceImpl<CompositeDictionary, Long> implements CompositeDictionaryService {
    @Resource(name = "compositeDictionaryDao")
    private CompositeDictionaryDao compositeDictionaryDao;

    @Override
    public SqlMapDao<CompositeDictionary, Long> getDao() {
        return compositeDictionaryDao;
    }
}