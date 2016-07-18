package cn.vansky.auth.controller.menu;

import cn.vansky.auth.bo.menu.Menu;
import cn.vansky.auth.controller.AbstractController;
import cn.vansky.auth.controller.general.KvVoExt;
import cn.vansky.auth.dto.menu.MenuDto;
import cn.vansky.auth.service.menu.MenuService;
import cn.vansky.auth.vo.menu.AuthWrapperVo;
import cn.vansky.auth.vo.menu.MenuPageVo;
import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import cn.vansky.framework.core.web.filter.auth.AuthWrapper;
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
@RequestMapping(value = "/menu")
public class MenuController extends AbstractController {

    @Resource(name = "menuService")
    MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/add_menu")
    public String addMenu(Menu menu) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", menu.getName());
        params.put("system_id", menu.getSystemId());
        KvVoExt kvVoExt = new KvVoExt(8, "菜单", params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        Date date = new Date();
        menu.setCreateTime(date);
        menu.setCreateId(1);
        menuService.saveEntitySelective(menu);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_menu")
    public String editMenu(Menu menu) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", menu.getName());
        params.put("system_id", menu.getSystemId());
        KvVoExt kvVoExt = new KvVoExt(8, "菜单", menu.getId(), params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        menuService.updateEntitySelective(menu);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageList(MenuPageVo vo) {
        List<MenuDto> list = menuService.findPageList(vo.convertPageMap());
        vo.setRows(list);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list_role_menu")
    public String listRoleMenu(MenuPageVo vo) {
        List<Menu> ul = menuService.findPageRoleMenu(vo.convertPageMap());
        vo.setRows(ul);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list_user_menu")
    public String listUserMenu(MenuPageVo vo) {
        List<Menu> ul = menuService.findPageRoleMenu(vo.convertPageMap());
        vo.setRows(ul);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/get_auth")
    public String findAuthWrapper(AuthWrapperVo vo) {
        AuthWrapper authWrapper = menuService.findAuthWrapper(vo.getUserId(), vo.getSystemId());
        return JsonResp.asData(authWrapper).toJson();
    }
}
