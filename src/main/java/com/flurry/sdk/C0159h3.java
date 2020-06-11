package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.C0275u2;
import java.lang.Thread;

/* renamed from: com.flurry.sdk.h3 */
public class C0159h3 implements AbstractC0282v1, C0275u2.AbstractC0276a, Thread.UncaughtExceptionHandler {

    /* renamed from: b */
    private static final String f479b = C0159h3.class.getSimpleName();

    /* renamed from: a */
    private boolean f480a;

    @Override // com.flurry.sdk.AbstractC0282v1
    /* renamed from: a */
    public void mo228a(Context context) {
        C0266t2 e = C0266t2.m703e();
        this.f480a = ((Boolean) e.mo341a("CaptureUncaughtExceptions")).booleanValue();
        e.mo342b("CaptureUncaughtExceptions", this);
        String str = f479b;
        C0260s1.m686c(4, str, "initSettings, CrashReportingEnabled = " + this.f480a);
        C0164i3 a = C0164i3.m483a();
        synchronized (a.f498b) {
            a.f498b.put(this, null);
        }
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.f480a = ((Boolean) obj).booleanValue();
            String str2 = f479b;
            C0260s1.m686c(4, str2, "onSettingUpdate, CrashReportingEnabled = " + this.f480a);
            return;
        }
        C0260s1.m686c(6, f479b, "onSettingUpdate internal error!");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        th.printStackTrace();
        if (this.f480a) {
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
            C0329z3.m900e().mo378h("uncaught", str, th, null);
        }
        C0243q2.m650a().mo316i();
        C0279v0.m732e().mo347m();
    }
}
