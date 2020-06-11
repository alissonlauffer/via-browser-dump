package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;

public class e1 {
    private static final String g = "e1";
    @SuppressLint({"StaticFieldLeak"})
    private static e1 h = null;
    private static boolean i = false;

    /* renamed from: a  reason: collision with root package name */
    public final Context f110a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Handler c;
    private final HandlerThread d;
    public final String e;
    private final u1 f;

    private e1(Context context, String str) {
        this.f110a = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("FlurryAgent");
        this.d = handlerThread;
        handlerThread.start();
        this.c = new Handler(this.d.getLooper());
        this.e = str;
        this.f = new u1();
    }

    public static e1 a() {
        return h;
    }

    public final void b(Runnable runnable) {
        this.c.post(runnable);
    }

    public static synchronized void a(Context context, String str) {
        synchronized (e1.class) {
            if (h != null) {
                if (h.e.equals(str)) {
                    s1.e(g, "Flurry is already initialized");
                    return;
                }
                throw new IllegalStateException("Only one API key per application is supported!");
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            } else if (!TextUtils.isEmpty(str)) {
                e1 e1Var = new e1(context, str);
                h = e1Var;
                e1Var.f.a(context);
            } else {
                throw new IllegalArgumentException("API key must be specified");
            }
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (e1.class) {
            z = i;
        }
        return z;
    }

    public final void a(Runnable runnable) {
        this.b.post(runnable);
    }

    public final void a(Runnable runnable, long j) {
        if (runnable != null) {
            this.c.postDelayed(runnable, j);
        }
    }

    public final v1 a(Class<? extends v1> cls) {
        return this.f.a(cls);
    }

    public static synchronized void a(boolean z) {
        synchronized (e1.class) {
            i = z;
        }
    }
}
