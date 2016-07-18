/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.bo.general;

/**
 * This class corresponds to the database table `tb_attachment`
 */
public class Attachment extends AttachmentBase {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}