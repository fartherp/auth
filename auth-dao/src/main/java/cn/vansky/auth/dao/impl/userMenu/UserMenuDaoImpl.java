/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.impl.userMenu;

import cn.vansky.auth.bo.userMenu.UserMenu;
import cn.vansky.auth.dao.userMenu.UserMenuDao;
import cn.vansky.auth.dao.userMenu.UserMenuMapper;
import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_user_menu
 *
 * @mbggenerated 2015-09-05 14:06:23
 */
@Repository("userMenuDao")
public class UserMenuDaoImpl extends ConfigurableBaseSqlMapDao<UserMenu, Integer> implements UserMenuDao {
    @Autowired
    private UserMenuMapper userMenuMapper;

    @Override
    public DaoMapper<UserMenu, Integer> getDaoMapper() {
        return userMenuMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public void delMenu(Map<String, Object> params) {
        userMenuMapper.delMenu(params);
    }
}