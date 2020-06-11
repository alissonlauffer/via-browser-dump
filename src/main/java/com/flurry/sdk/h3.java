package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.u2;
import java.lang.Thread;
import java.util.Map;

public class h3 implements v1, u2.a, Thread.UncaughtExceptionHandler {
    private static final String b = h3.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private boolean f136a;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
     arg types: [java.lang.String, com.flurry.sdk.h3]
     candidates:
      com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
      com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
    @Override // com.flurry.sdk.v1
    public void a(Context context) {
        t2 a2 = t2.a();
        this.f136a = ((Boolean) a2.a("CaptureUncaughtExceptions")).booleanValue();
        a2.a("CaptureUncaughtExceptions", (u2.a) this);
        String str = b;
        s1.a(4, str, "initSettings, CrashReportingEnabled = " + this.f136a);
        i3 b2 = i3.b();
        synchronized (b2.b) {
            b2.b.put(this, null);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        th.printStackTrace();
        if (this.f136a) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                str = th.getMessage() != null ? th.getMessage() : "";
            } else {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (");
                    sb.append(th.getMessage());
                    sb.append(")\n");
                }
                str = sb.toString();
            }
            z3.a().a("uncaught", str, th, (Map<String, String>) null);
        }
        q2.d().a();
        v0.d().b();
    }

    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.f136a = ((Boolean) obj).booleanValue();
            String str2 = b;
            s1.a(4, str2, "onSettingUpdate, CrashReportingEnabled = " + this.f136a);
            return;
        }
        s1.a(6, b, "onSettingUpdate internal error!");
    }
}
