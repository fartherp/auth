package file;/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

import cn.vansky.framework.common.util.DateUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/28
 */
public class FileFilterImpl implements FileFilter {
    /**
     * @return return false:返回主目录下所有文件详细(不包含所有子目录)
     */
    @Override
    public boolean accept(File file) {
        // TODO Auto-generated method stub
        System.out.println("文件路径: " + file);
        System.out.println("最后修改时间： " + DateUtil.format(DateUtil.yyMMddHHmmss, new Date(file.lastModified())));
        return true;
    }
}
