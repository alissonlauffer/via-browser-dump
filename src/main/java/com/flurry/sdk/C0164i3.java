package com.flurry.sdk;

import java.lang.Thread;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.flurry.sdk.i3 */
public final class C0164i3 {

    /* renamed from: c */
    private static C0164i3 f496c;

    /* renamed from: a */
    final Thread.UncaughtExceptionHandler f497a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    final Map<Thread.UncaughtExceptionHandler, Void> f498b = new WeakHashMap();

    /* renamed from: com.flurry.sdk.i3$a */
    final class C0165a implements Thread.UncaughtExceptionHandler {
        private C0165a() {
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : C0164i3.this.mo237b()) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = C0164i3.this.f497a;
            if (uncaughtExceptionHandler2 != null) {
                try {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                } catch (Throwable unused2) {
                }
            }
        }

        /* synthetic */ C0165a(C0164i3 i3Var, byte b) {
            this();
        }
    }

    private C0164i3() {
        Thread.setDefaultUncaughtExceptionHandler(new C0165a(this, (byte) 0));
    }

    /* renamed from: a */
    public static synchronized C0164i3 m483a() {
        C0164i3 i3Var;
        synchronized (C0164i3.class) {
            if (f496c == null) {
                f496c = new C0164i3();
            }
            i3Var = f496c;
        }
        return i3Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Set<Thread.UncaughtExceptionHandler> mo237b() {
        Set<Thread.UncaughtExceptionHandler> keySet;
        synchronized (this.f498b) {
            keySet = this.f498b.keySet();
        }
        return keySet;
    }
}
