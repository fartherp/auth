/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.dao.impl.role;

import cn.vansky.auth.dao.dbunit.BaseDbTestCase;
import cn.vansky.auth.dao.dbunit.UseDbUnit;
import cn.vansky.auth.dao.role.RoleDao;
import cn.vansky.auth.dto.role.RoleDto;
import cn.vansky.framework.core.orm.mybatis.plugin.page.BasePagination;
import cn.vansky.framework.core.orm.mybatis.plugin.page.Pagination;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleDaoImplTest extends BaseDbTestCase {

    @Resource(name = "roleDao")
    RoleDao dao;

    @Test
    @UseDbUnit(tables = { "tb_role" })
    public void testFindPageRole() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        Pagination pagination = new BasePagination();
        pagination.setLimit(50);
        pagination.setCurrentPage(1);
        params.put(Pagination.MAP_PAGE_FIELD, pagination);
        List<RoleDto> l1 = dao.findPageList(params);
        Assert.assertEquals(l1.size(), 4);
        params.put("roleName", "管理");
        List<RoleDto> l2 = dao.findPageList(params);
        Assert.assertEquals(l2.size(), 2);
        params.put("systemId", 2);
        List<RoleDto> l3 = dao.findPageList(params);
        Assert.assertEquals(l3.get(0).getId(), Integer.valueOf(3));
        params.remove("roleName");
        params.put("systemId", 1);
        List<RoleDto> l4 = dao.findPageList(params);
        Assert.assertEquals(l4.size(), 2);
    }
}