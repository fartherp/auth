package cn.vansky.auth.controller.role;

import cn.vansky.auth.bo.role.Role;
import cn.vansky.auth.bo.roleMenu.RoleMenu;
import cn.vansky.auth.controller.AbstractController;
import cn.vansky.auth.controller.general.KvVoExt;
import cn.vansky.auth.dto.role.RoleDto;
import cn.vansky.auth.service.menu.MenuService;
import cn.vansky.auth.service.role.RoleService;
import cn.vansky.auth.service.roleMenu.RoleMenuService;
import cn.vansky.auth.vo.role.RolePageVo;
import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/8/6
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends AbstractController {

    @Resource(name = "roleService")
    RoleService roleService;

    @Resource(name = "menuService")
    MenuService menuService;

    @Resource(name = "")
    RoleMenuService roleMenuService;

    @ResponseBody
    @RequestMapping(value = "/add_role")
    public String addRole(Role role) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", role.getName());
        params.put("system_id", role.getSystemId());
        KvVoExt kvVoExt = new KvVoExt(2, "角色", params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        role.setCreateTime(new Date());
        role.setCreateId(1);
        roleService.saveEntitySelective(role);
        String [] ds = role.getMenuIds().split(",");
        List<RoleMenu> ts = new ArrayList<RoleMenu>();
        for (String d :ds) {
            if (StringUtils.isBlank(d)) {
                continue;
            }
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(role.getId());
            roleMenu.setMenuId(Integer.valueOf(d));
            ts.add(roleMenu);
        }
        if (!ts.isEmpty()) {
            roleMenuService.saveBatch(ts);
        }
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_role")
    public String editRole(Role role) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", role.getName());
        params.put("system_id", role.getSystemId());
        KvVoExt kvVoExt = new KvVoExt(2, "角色", role.getId(), params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        roleService.updateEntitySelective(role);
        String [] ds = role.getMenuIds().split(",");
        List<RoleMenu> ts = new ArrayList<RoleMenu>();
        for (String d :ds) {
            if (StringUtils.isBlank(d)) {
                continue;
            }
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(role.getId());
            roleMenu.setMenuId(Integer.valueOf(d));
            ts.add(roleMenu);
        }
        if (!ts.isEmpty()) {
            params.put("roleId", role.getId());
            roleMenuService.delMenu(params);
            roleMenuService.saveBatch(ts);
        }
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageList(RolePageVo vo) {
        List<RoleDto> list = roleService.findPageList(vo.convertPageMap());
        vo.setRows(list);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }
}
