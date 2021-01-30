package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.flurry.sdk.v2 */
public final class ThreadFactoryC0283v2 implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f786a;

    /* renamed from: b */
    private final int f787b = 1;

    public ThreadFactoryC0283v2(String str) {
        this.f786a = new ThreadGroup(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f786a, runnable);
        thread.setName(this.f786a.getName() + ":" + thread.getId());
        thread.setPriority(this.f787b);
        return thread;
    }
}
