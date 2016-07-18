package cn.vansky.auth.service.impl.general;

import cn.vansky.framework.core.file.NfsConfig;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/23
 */
public class AttachmentConfig extends NfsConfig {
    private String urlTpl;

    public String getUrlTpl() {
        return urlTpl;
    }

    public void setUrlTpl(String urlTpl) {
        this.urlTpl = urlTpl;
    }
}
