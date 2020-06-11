package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* access modifiers changed from: package-private */
/* renamed from: com.flurry.sdk.r2 */
public final class C0255r2 {

    /* renamed from: a */
    private Timer f715a;

    /* renamed from: b */
    private C0256a f716b;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.r2$a */
    public class C0256a extends TimerTask {
        C0256a() {
        }

        public final void run() {
            C0255r2.this.mo328c();
            C0199n1.m528a().mo269c(new C0261s2());
        }
    }

    C0255r2() {
    }

    /* renamed from: a */
    public final synchronized void mo326a(long j) {
        if (mo327b()) {
            mo328c();
        }
        this.f715a = new Timer("FlurrySessionTimer");
        C0256a aVar = new C0256a();
        this.f716b = aVar;
        this.f715a.schedule(aVar, j);
    }

    /* renamed from: b */
    public final boolean mo327b() {
        return this.f715a != null;
    }

    /* renamed from: c */
    public final synchronized void mo328c() {
        Timer timer = this.f715a;
        if (timer != null) {
            timer.cancel();
            this.f715a = null;
        }
        this.f716b = null;
    }
}
