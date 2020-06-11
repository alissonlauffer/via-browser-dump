package com.flurry.sdk;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

public final class v2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f204a;
    private final int b = 1;

    public v2(String str) {
        this.f204a = new ThreadGroup(str);
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        Thread thread = new Thread(this.f204a, runnable);
        thread.setName(this.f204a.getName() + ":" + thread.getId());
        thread.setPriority(this.b);
        return thread;
    }
}
