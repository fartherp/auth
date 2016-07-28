package file;/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/28
 */
public class FileListenerAdaptor extends FileAlterationListenerAdaptor {
    /**
     * File system observer started checking event.
     */
    @Override
    public void onStart(FileAlterationObserver observer) {
        // TODO Auto-generated method stub
        super.onStart(observer);
        System.out.println("文件系统观察者开始检查事件");
    }

    /**
     * File system observer finished checking event.
     */
    @Override
    public void onStop(FileAlterationObserver observer) {
        // TODO Auto-generated method stub
        super.onStop(observer);
        System.out.println("文件系统完成检查事件观测器");
    }

    /**
     * Directory created Event.
     */
    @Override
    public void onDirectoryCreate(File directory) {
        // TODO Auto-generated method stub
        super.onDirectoryCreate(directory);
        System.out.println("目录创建事件");
    }

    /**
     * Directory changed Event
     */
    @Override
    public void onDirectoryChange(File directory) {
        // TODO Auto-generated method stub
        super.onDirectoryChange(directory);
        System.out.println("目录改变事件");
    }

    /**
     * Directory deleted Event.
     */
    @Override
    public void onDirectoryDelete(File directory) {
        // TODO Auto-generated method stub
        super.onDirectoryDelete(directory);
        System.out.println("目录删除事件");
    }

    /**
     * File created Event.
     */
    @Override
    public void onFileCreate(File file) {
        // TODO Auto-generated method stub
        super.onFileCreate(file);
        System.out.println("文件创建事件");
        System.out.println("文件名称：" + file.getName());

    }

    /**
     * File changed Event.
     */
    @Override
    public void onFileChange(File file) {
        // TODO Auto-generated method stub
        super.onFileChange(file);
        System.out.println("文件改变事件");
    }

    /**
     * File deleted Event.
     */
    @Override
    public void onFileDelete(File file) {
        // TODO Auto-generated method stub
        super.onFileDelete(file);
        System.out.println("文件删除事件:" + file.getName());
    }
}
