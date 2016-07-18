/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.impl.general;

import cn.vansky.auth.bo.general.CompositeDictionary;
import cn.vansky.auth.dao.general.CompositeDictionaryDao;
import cn.vansky.auth.dao.general.CompositeDictionaryMapper;
import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `td_composite_dictionary`
 */
@Repository("compositeDictionaryDao")
public class CompositeDictionaryDaoImpl extends ConfigurableBaseSqlMapDao<CompositeDictionary, Long> implements CompositeDictionaryDao {
    @Autowired
    private CompositeDictionaryMapper compositeDictionaryMapper;

    @Override
    public DaoMapper<CompositeDictionary, Long> getDaoMapper() {
        return compositeDictionaryMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public List<CompositeDictionary> findByParams(Map<String, Object> params) {
        return compositeDictionaryMapper.findByParams(params);
    }
}