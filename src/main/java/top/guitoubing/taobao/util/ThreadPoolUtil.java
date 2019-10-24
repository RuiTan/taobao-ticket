package top.guitoubing.taobao.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil {

    private static ExecutorService cachedThreadPool;

    public static ExecutorService getCachedThreadPool(){
        if (null == cachedThreadPool) {
            cachedThreadPool = Executors.newCachedThreadPool();
        }
        return cachedThreadPool;
    }

}
