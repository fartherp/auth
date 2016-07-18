package cn.vansky.auth.controller.user;

import cn.vansky.auth.bo.user.User;
import cn.vansky.auth.bo.userMenu.UserMenu;
import cn.vansky.auth.controller.AbstractController;
import cn.vansky.auth.controller.general.KvVoExt;
import cn.vansky.auth.dto.user.UserDto;
import cn.vansky.auth.service.user.UserService;
import cn.vansky.auth.service.userMenu.UserMenuService;
import cn.vansky.auth.vo.user.UserPageVo;
import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import cn.vansky.security.ISecurity;
import cn.vansky.security.single.MD5;
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
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "userMenuService")
    UserMenuService userMenuService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(User loginUser) {
        String securityPassword = MD5.digest(loginUser.getPassword().getBytes());
        loginUser.setPassword(securityPassword);
        User user = userService.findUserByMap(loginUser);
        if (null != user) {
            return JsonResp.asEmpty().toJson();
        }
        return JsonResp.asEmpty().error("用户名或密码错误").toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/add_user")
    public String addUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("system_id", user.getSystemId());
        KvVoExt kvVoExt = new KvVoExt(3, "用户", params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        String securityPassword = MD5.digest(user.getPassword().getBytes());
        user.setPassword(securityPassword);
        Date date = new Date();
        user.setCreateTime(date);
        user.setCreateId(1);
        userService.saveEntitySelective(user);
//        String [] ds = user.getMenuIds().split(",");
//        List<UserMenu> ts = new ArrayList<UserMenu>();
//        for (String d :ds) {
//            if (StringUtils.isBlank(d)) {
//                continue;
//            }
//            UserMenu roleMenu = new UserMenu();
//            roleMenu.setUserId(user.getId());
//            roleMenu.setMenuId(Integer.valueOf(d));
//            ts.add(roleMenu);
//        }
//        if (!ts.isEmpty()) {
//            userMenuService.saveBatch(ts);
//        }
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_user")
    public String editUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("system_id", user.getSystemId());
        KvVoExt kvVoExt = new KvVoExt(3, "用户", user.getId(), params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        userService.updateEntitySelective(user);
//        String [] ds = user.getMenuIds().split(",");
//        List<UserMenu> ts = new ArrayList<UserMenu>();
//        for (String d :ds) {
//            if (StringUtils.isBlank(d)) {
//                continue;
//            }
//            UserMenu roleMenu = new UserMenu();
//            roleMenu.setUserId(user.getId());
//            roleMenu.setMenuId(Integer.valueOf(d));
//            ts.add(roleMenu);
//        }
//        if (!ts.isEmpty()) {
//            userMenuService.saveBatch(ts);
//        }
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageList(UserPageVo vo) {
        List<UserDto> list = userService.findPageList(vo.convertPageMap());
        vo.setRows(list);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/remove_menus")
    public String removeMenu(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", user.getId());
        params.put("menus", user.getMenuIds().split(","));
        userMenuService.delMenu(params);
        return JsonResp.asEmpty().toJson();
    }
}
