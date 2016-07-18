package cn.vansky.auth.vo.user;

import cn.vansky.auth.bo.user.User;
import cn.vansky.framework.core.vo.BaseVo;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/20
 */
public class UserPageVo extends BaseVo<User> {
    private String name;
    private Integer dicType = 3;
    private Integer systemId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDicType() {
        return dicType;
    }

    public void setDicType(Integer dicType) {
        this.dicType = dicType;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
}
