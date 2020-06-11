package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

public class z1 {
    /* access modifiers changed from: private */
    public static final String d = "z1";

    /* renamed from: a  reason: collision with root package name */
    private Timer f227a;
    private a b;
    /* access modifiers changed from: private */
    public dk c;

    class a extends TimerTask {
        private a() {
        }

        public final void run() {
            s1.a(3, z1.d, "HttpRequest timed out. Cancelling.");
            dk a2 = z1.this.c;
            long currentTimeMillis = System.currentTimeMillis() - a2.r;
            String str = dk.z;
            s1.a(3, str, "Timeout (" + currentTimeMillis + "MS) for url: " + a2.h);
            a2.u = 629;
            a2.y = true;
            a2.f();
            a2.g();
        }

        /* synthetic */ a(z1 z1Var, byte b) {
            this();
        }
    }

    public z1(dk dkVar) {
        this.c = dkVar;
    }

    public final synchronized void a() {
        if (this.f227a != null) {
            this.f227a.cancel();
            this.f227a = null;
            s1.a(3, d, "HttpRequestTimeoutTimer stopped.");
        }
        this.b = null;
    }

    public final synchronized void a(long j) {
        if (this.f227a != null) {
            a();
        }
        this.f227a = new Timer("HttpRequestTimeoutTimer");
        a aVar = new a(this, (byte) 0);
        this.b = aVar;
        this.f227a.schedule(aVar, j);
        String str = d;
        s1.a(3, str, "HttpRequestTimeoutTimer started: " + j + "MS");
    }
}
