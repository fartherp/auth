package cn.vansky.auth.bo.general;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/23
 */
public enum AttachType {
    TEST(1000000, "test", "nfsAttachStore");

    /**
     * 类型id, 取值范围 (>= 20)
     */
    private int typeId;

    /**
     * 类型名称
     */
    private String name;

    private String beanName;

    /**
     * 构造函数
     *
     * @param typeId 类型id
     * @param name 类型名称
     * @param beanName beanName
     */
    AttachType(int typeId, String name, String beanName) {
        this.typeId = typeId;
        this.name = name;
        this.beanName = beanName;
    }

    /**
     * 获取typeId
     *
     * @return typeId
     */
    public int getTypeId() {
        return this.typeId;
    }

    /**
     * 获取类型名称
     *
     * @return 名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 上传使用的方式
     * @return beanName
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * From type id.
     *
     * @param id the type id
     * @return the attach type
     */
    public static AttachType fromTypeId(Object id) {
        if (null == id) {
            return null;
        }
        int typeId = NumberUtils.toInt(id.toString());
        AttachType[] types = AttachType.values();
        for (AttachType type: types) {
            if (type.getTypeId() == typeId) {
                return type;
            }
        }

        return null;
    }
}
