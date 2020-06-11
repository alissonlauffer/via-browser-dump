package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;

public class o2 {
    static final String f = "o2";

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f171a;
    int b = 0;
    long c;
    private Timer d;
    private final Object e = new Object();

    public o2() {
        Context context = e1.a().f110a;
        this.f171a = context.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        y0.b();
        this.b = y0.a(context);
        SharedPreferences sharedPreferences = this.f171a;
        this.c = sharedPreferences != null ? sharedPreferences.getLong("refreshFetch", 604800000) : 604800000;
    }

    private void e() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("appVersion").apply();
        }
    }

    private void f() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastFetch").apply();
        }
    }

    private void g() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastETag").apply();
        }
    }

    private void h() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastKeyId").apply();
        }
    }

    private void i() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastRSA").apply();
        }
    }

    private void j() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("com.flurry.sdk.variant_ids").apply();
        }
    }

    public final int a() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("appVersion", 0);
        }
        return 0;
    }

    public final void b() {
        synchronized (this.e) {
            if (this.d != null) {
                s1.a(3, f, "Clear retry.");
                this.d.cancel();
                this.d.purge();
                this.d = null;
            }
        }
    }

    public final void c() {
        s1.a(f, "Clear all ConfigMeta data.");
        b();
        e();
        f();
        g();
        h();
        i();
        j();
    }

    public final String d() {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("lastKeyId", null);
        }
        return null;
    }

    public final synchronized void a(TimerTask timerTask, long j) {
        synchronized (this.e) {
            String str = f;
            s1.a(str, "Record retry after " + j + " msecs.");
            Timer timer = new Timer("retry-scheduler");
            this.d = timer;
            timer.schedule(timerTask, j);
        }
    }

    public final void a(long j) {
        SharedPreferences sharedPreferences = this.f171a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastFetch", j).apply();
        }
    }
}
