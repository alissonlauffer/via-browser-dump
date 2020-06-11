package com.flurry.sdk;

import java.lang.Thread;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class i3 {
    private static i3 c;

    /* renamed from: a  reason: collision with root package name */
    final Thread.UncaughtExceptionHandler f141a = Thread.getDefaultUncaughtExceptionHandler();
    final Map<Thread.UncaughtExceptionHandler, Void> b = new WeakHashMap();

    final class a implements Thread.UncaughtExceptionHandler {
        private a() {
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : i3.this.a()) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = i3.this.f141a;
            if (uncaughtExceptionHandler2 != null) {
                try {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                } catch (Throwable unused2) {
                }
            }
        }

        /* synthetic */ a(i3 i3Var, byte b) {
            this();
        }
    }

    private i3() {
        Thread.setDefaultUncaughtExceptionHandler(new a(this, (byte) 0));
    }

    public static synchronized i3 b() {
        i3 i3Var;
        synchronized (i3.class) {
            if (c == null) {
                c = new i3();
            }
            i3Var = c;
        }
        return i3Var;
    }

    /* access modifiers changed from: package-private */
    public final Set<Thread.UncaughtExceptionHandler> a() {
        Set<Thread.UncaughtExceptionHandler> keySet;
        synchronized (this.b) {
            keySet = this.b.keySet();
        }
        return keySet;
    }
}
