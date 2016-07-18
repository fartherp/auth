/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.impl.role;

import cn.vansky.auth.dao.role.RoleDao;
import cn.vansky.auth.dto.role.RoleDto;
import cn.vansky.auth.service.role.RoleService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class RoleServiceImplTest {

    @InjectMocks
    RoleService service;

    @Mock
    RoleDao dao;

    @BeforeClass(alwaysRun = true)
    public void initMocks() {
        service = new RoleServiceImpl();
        ((RoleServiceImpl) service).getDao();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPageRole() throws Exception {
        List<RoleDto> list = new ArrayList<RoleDto>();
        for (int i = 1; i < 3; i++) {
            RoleDto r = new RoleDto();
            r.setId(i);
            r.setName("roleName" + i);
            r.setSystemId(i);
            r.setStatus((byte) i);
            r.setCreateTime(new Date());
            r.setRemark("roleRemark" + i);
            r.setCreateId(1);
            list.add(r);
        }
        Map<String, Object> params = new HashMap<String, Object>();
        Mockito.when(dao.findPageList(params)).thenReturn(list);
        List<RoleDto> rl = service.findPageList(params);
        Assert.assertEquals(rl.size(), 2);
    }
}