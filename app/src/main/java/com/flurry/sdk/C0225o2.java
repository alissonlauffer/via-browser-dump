package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.flurry.sdk.o2 */
public class C0225o2 {

    /* renamed from: f */
    static final String f657f = "o2";

    /* renamed from: a */
    public final SharedPreferences f658a;

    /* renamed from: b */
    int f659b = 0;

    /* renamed from: c */
    long f660c;

    /* renamed from: d */
    private Timer f661d;

    /* renamed from: e */
    private final Object f662e = new Object();

    public C0225o2() {
        Context context = C0118e1.m386a().f361a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        this.f658a = sharedPreferences;
        C0314y0.m857a();
        this.f659b = C0314y0.m858c(context);
        this.f660c = sharedPreferences != null ? sharedPreferences.getLong("refreshFetch", 604800000) : 604800000;
    }

    /* renamed from: g */
    private void m584g() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("appVersion").apply();
        }
    }

    /* renamed from: h */
    private void m585h() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastFetch").apply();
        }
    }

    /* renamed from: i */
    private void m586i() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastETag").apply();
        }
    }

    /* renamed from: j */
    private void m587j() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastKeyId").apply();
        }
    }

    /* renamed from: k */
    private void m588k() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastRSA").apply();
        }
    }

    /* renamed from: l */
    private void m589l() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("com.flurry.sdk.variant_ids").apply();
        }
    }

    /* renamed from: a */
    public final int mo290a() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("appVersion", 0);
        }
        return 0;
    }

    /* renamed from: b */
    public final void mo291b(long j) {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastFetch", j).apply();
        }
    }

    /* renamed from: c */
    public final synchronized void mo292c(TimerTask timerTask, long j) {
        synchronized (this.f662e) {
            String str = f657f;
            C0260s1.m688e(str, "Record retry after " + j + " msecs.");
            Timer timer = new Timer("retry-scheduler");
            this.f661d = timer;
            timer.schedule(timerTask, j);
        }
    }

    /* renamed from: d */
    public final void mo293d() {
        synchronized (this.f662e) {
            if (this.f661d != null) {
                C0260s1.m686c(3, f657f, "Clear retry.");
                this.f661d.cancel();
                this.f661d.purge();
                this.f661d = null;
            }
        }
    }

    /* renamed from: e */
    public final void mo294e() {
        C0260s1.m688e(f657f, "Clear all ConfigMeta data.");
        mo293d();
        m584g();
        m585h();
        m586i();
        m587j();
        m588k();
        m589l();
    }

    /* renamed from: f */
    public final String mo295f() {
        SharedPreferences sharedPreferences = this.f658a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("lastKeyId", null);
        }
        return null;
    }
}
