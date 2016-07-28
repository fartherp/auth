/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package file;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/7/28
 */
public class FileChangeTest {
    public static void main(String[] args) {
        try {
            // 构造观察类主要提供要观察的文件或目录，当然还有详细信息的filter
            FileAlterationObserver observer = new FileAlterationObserver("D:\\a", new FileFilterImpl());
            // 构造收听类 没啥好说的
            FileListenerAdaptor listener = new FileListenerAdaptor();
            // 为观察对象添加收听对象
            observer.addListener(listener);
            // 配置Monitor，第一个参数单位是毫秒，是监听的间隔；第二个参数就是绑定我们之前的观察对象。
            FileAlterationMonitor fileMonitor = new FileAlterationMonitor(10000, observer);
            // 启动开始监听
            fileMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
