/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.general;

import cn.vansky.auth.bo.general.CompositeDictionary;
import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `td_composite_dictionary`
 */
@SqlMapper
public interface CompositeDictionaryMapper extends DaoMapper<CompositeDictionary, Long> {

    List<CompositeDictionary> findByParams(Map<String, Object> params);
}