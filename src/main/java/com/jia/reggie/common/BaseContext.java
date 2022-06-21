package com.jia.reggie.common;

public class BaseContext {
    private static ThreadLocal<Long> threadLocal =new ThreadLocal<>();

    public static ThreadLocal<Long> getThreadLocal() {
        return threadLocal;
    }

    public static void setThreadLocal(ThreadLocal<Long> threadLocal) {
        BaseContext.threadLocal = threadLocal;
    }
}
