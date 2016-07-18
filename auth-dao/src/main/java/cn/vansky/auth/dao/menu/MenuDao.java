/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.menu;

import cn.vansky.auth.bo.menu.Menu;
import cn.vansky.auth.dto.menu.MenuDto;
import cn.vansky.framework.core.dao.SqlMapDao;

import java.util.List;
import java.util.Map;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_menu
 *
 * @mbggenerated 2015-09-05 14:06:23
 */
public interface MenuDao extends SqlMapDao<Menu, Integer> {

    List<MenuDto> findPageList(Map<String, Object> params);

    List<Menu> findPageRoleMenu(Map<String, Object> params);

    List<Menu> findByRoleId(Integer roleId, Integer systemId);

    List<Menu> findByUserId(Integer userId, Integer systemId);
}