package com.bawei6.basemodel.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：线程
 */
public class ThreadUtils {
    private volatile static ThreadUtils instance;

    private ThreadUtils() { }

    private ExecutorService executorService = newCachedThreadPool();

    /**
     * 创建线程方法
     * @return
     */
    public ExecutorService getExecutorService(){
        return executorService;
    }

    /**
     * 获取单例对象
     * @return
     */
    public static ThreadUtils getInstance() {
        if (instance == null) {
            synchronized (ThreadUtils.class){
                if (instance == null){
                    instance = new ThreadUtils();
                }
            }
        }
        return instance;
    }
}
