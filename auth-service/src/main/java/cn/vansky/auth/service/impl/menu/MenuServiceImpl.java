/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.impl.menu;

import cn.vansky.auth.bo.menu.Menu;
import cn.vansky.auth.bo.user.User;
import cn.vansky.auth.dao.menu.MenuDao;
import cn.vansky.auth.dto.menu.MenuAuthDto;
import cn.vansky.auth.dto.menu.MenuDto;
import cn.vansky.auth.service.menu.MenuService;
import cn.vansky.auth.service.user.UserService;
import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import cn.vansky.framework.core.web.easyUI.model.EasyUITreeModel;
import cn.vansky.framework.core.web.easyUI.service.EasyUITreeService;
import cn.vansky.framework.core.web.filter.auth.AuthWrapper;
import cn.vansky.framework.core.web.filter.auth.GeneralAuthWrapper;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_menu
 *
 * @mbggenerated 2015-09-05 14:06:23
 */
@Service("menuService")
public class MenuServiceImpl extends GenericSqlMapServiceImpl<Menu, Integer> implements MenuService {
    @Resource(name = "menuDao")
    private MenuDao menuDao;

    @Resource(name = "easyUITreeService")
    EasyUITreeService easyUITreeService;

    @Resource(name = "userService")
    UserService userService;

    @Override
    public SqlMapDao<Menu, Integer> getDao() {
        return menuDao;
    }

    @Override
    public List<MenuDto> findPageList(Map<String, Object> params) {
        return menuDao.findPageList(params);
    }

    @Override
    public List<MenuAuthDto> findRoleMenu(Map<String, Object> params) {
        return menuDao.findRoleMenu(params);
    }

    @Override
    public GeneralAuthWrapper findAuthWrapper(Integer userId, Integer systemId) {
        GeneralAuthWrapper generalAuthWrapper = new GeneralAuthWrapper();
        User user = userService.findById(userId);
        if (user == null) {
            generalAuthWrapper.setStatus(1);
            generalAuthWrapper.setStatusInfo("权限系统没有此用户信息!");
        } else if (!user.getSystemId().equals(systemId)) {
            generalAuthWrapper.setStatus(1);
            generalAuthWrapper.setStatusInfo("登录系统标识设置错误!");
        } else if (User.NO_USE_ABLE.equals(user.getStatus())) {
            generalAuthWrapper.setStatus(1);
            generalAuthWrapper.setStatusInfo("权限账户被锁定,请联系管理员!");
        } else {
            List<Menu> allList = menuDao.findByRoleId(user.getRoleId(), systemId);
            allList.addAll(menuDao.findByUserId(userId, systemId));
            AuthWrapper authWrapper = new AuthWrapper();
            List<Menu> menuList = new ArrayList<Menu>();
            for (Menu menu : allList) {
                authWrapper.addUrl(menu.getUrl());
                if (menu.getLevel() == 1) {
                    menuList.add(menu);
                }
            }
            List<EasyUITreeModel> l = easyUITreeService.findChildren(menuList, new EasyUITreeService.ModelCall<Menu>() {
                @Override
                public EasyUITreeModel convert(Menu o) {
                    EasyUITreeModel model = new EasyUITreeModel();
                    model.setId(o.getId());
                    model.setText(o.getName());
                    model.setUrl(o.getUrl());
                    model.setPid(o.getParentId());
                    return model;
                }
            });
            authWrapper.setMenuList(l);
            generalAuthWrapper.setData(authWrapper);
        }
        return generalAuthWrapper;
    }
}