package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

final class r2 {

    /* renamed from: a  reason: collision with root package name */
    private Timer f188a;
    private a b;

    class a extends TimerTask {
        a() {
        }

        public final void run() {
            r2.this.b();
            n1.a().a(new s2());
        }
    }

    r2() {
    }

    public final synchronized void a(long j) {
        if (a()) {
            b();
        }
        this.f188a = new Timer("FlurrySessionTimer");
        a aVar = new a();
        this.b = aVar;
        this.f188a.schedule(aVar, j);
    }

    public final synchronized void b() {
        if (this.f188a != null) {
            this.f188a.cancel();
            this.f188a = null;
        }
        this.b = null;
    }

    public final boolean a() {
        return this.f188a != null;
    }
}
