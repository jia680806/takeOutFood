package com.jia.reggie.common;

public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static ThreadLocal<Long> getThreadLocal() {
        return threadLocal;
    }

    public static void setThreadLocal(Long id) {
        threadLocal.set(id);
    }

    /**
     * 设置值
     *
     * @param id
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    /**
     * 获取值
     *
     * @return
     */
    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
