package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;

/* renamed from: com.flurry.sdk.e1 */
public class C0118e1 {

    /* renamed from: g */
    private static final String f358g = "e1";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: h */
    private static C0118e1 f359h = null;

    /* renamed from: i */
    private static boolean f360i = false;

    /* renamed from: a */
    public final Context f361a;

    /* renamed from: b */
    private final Handler f362b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private final Handler f363c;

    /* renamed from: d */
    private final HandlerThread f364d;

    /* renamed from: e */
    public final String f365e;

    /* renamed from: f */
    private final C0274u1 f366f;

    private C0118e1(Context context, String str) {
        this.f361a = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("FlurryAgent");
        this.f364d = handlerThread;
        handlerThread.start();
        this.f363c = new Handler(handlerThread.getLooper());
        this.f365e = str;
        this.f366f = new C0274u1();
    }

    /* renamed from: a */
    public static C0118e1 m386a() {
        return f359h;
    }

    /* renamed from: c */
    public static synchronized void m387c(Context context, String str) {
        synchronized (C0118e1.class) {
            C0118e1 e1Var = f359h;
            if (e1Var != null) {
                if (e1Var.f365e.equals(str)) {
                    C0260s1.m701r(f358g, "Flurry is already initialized");
                    return;
                }
                throw new IllegalStateException("Only one API key per application is supported!");
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            } else if (!TextUtils.isEmpty(str)) {
                C0118e1 e1Var2 = new C0118e1(context, str);
                f359h = e1Var2;
                e1Var2.f366f.mo339a(context);
            } else {
                throw new IllegalArgumentException("API key must be specified");
            }
        }
    }

    /* renamed from: f */
    public static synchronized void m388f(boolean z) {
        synchronized (C0118e1.class) {
            f360i = z;
        }
    }

    /* renamed from: h */
    public static synchronized boolean m389h() {
        boolean z;
        synchronized (C0118e1.class) {
            z = f360i;
        }
        return z;
    }

    /* renamed from: b */
    public final AbstractC0282v1 mo188b(Class<? extends AbstractC0282v1> cls) {
        return this.f366f.mo340d(cls);
    }

    /* renamed from: d */
    public final void mo189d(Runnable runnable) {
        this.f362b.post(runnable);
    }

    /* renamed from: e */
    public final void mo190e(Runnable runnable, long j) {
        if (runnable != null) {
            this.f363c.postDelayed(runnable, j);
        }
    }

    /* renamed from: g */
    public final void mo191g(Runnable runnable) {
        this.f363c.post(runnable);
    }
}
