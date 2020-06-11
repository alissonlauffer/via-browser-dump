package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.flurry.sdk.z1 */
public class C0326z1 {

    /* renamed from: d */
    private static final String f892d = "z1";

    /* renamed from: a */
    private Timer f893a;

    /* renamed from: b */
    private C0327a f894b;

    /* renamed from: c */
    private C0108dk f895c;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.z1$a */
    public class C0327a extends TimerTask {
        private C0327a() {
        }

        public final void run() {
            C0260s1.m686c(3, C0326z1.f892d, "HttpRequest timed out. Cancelling.");
            C0108dk dkVar = C0326z1.this.f895c;
            long currentTimeMillis = System.currentTimeMillis() - dkVar.f334r;
            String str = C0108dk.f320z;
            C0260s1.m686c(3, str, "Timeout (" + currentTimeMillis + "MS) for url: " + dkVar.f324h);
            dkVar.f337u = 629;
            dkVar.f341y = true;
            dkVar.mo178i();
            dkVar.mo179j();
        }

        /* synthetic */ C0327a(C0326z1 z1Var, byte b) {
            this();
        }
    }

    public C0326z1(C0108dk dkVar) {
        this.f895c = dkVar;
    }

    /* renamed from: b */
    public final synchronized void mo371b() {
        Timer timer = this.f893a;
        if (timer != null) {
            timer.cancel();
            this.f893a = null;
            C0260s1.m686c(3, f892d, "HttpRequestTimeoutTimer stopped.");
        }
        this.f894b = null;
    }

    /* renamed from: c */
    public final synchronized void mo372c(long j) {
        if (this.f893a != null) {
            mo371b();
        }
        this.f893a = new Timer("HttpRequestTimeoutTimer");
        C0327a aVar = new C0327a(this, (byte) 0);
        this.f894b = aVar;
        this.f893a.schedule(aVar, j);
        String str = f892d;
        C0260s1.m686c(3, str, "HttpRequestTimeoutTimer started: " + j + "MS");
    }
}
