package com.flurry.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.flurry.sdk.cn;

public class by extends BroadcastReceiver {
    public static final String e = by.class.getSimpleName();
    private static by f;

    /* renamed from: a  reason: collision with root package name */
    boolean f74a;
    public boolean b;
    private boolean c = false;
    private final m1<cn> d = new b();

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f75a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
    }

    class b implements m1<cn> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(cn cnVar) {
            cn cnVar2 = cnVar;
            Activity activity = cnVar2.b.get();
            if (activity == null) {
                s1.a(3, by.e, "Activity has been destroyed, don't update network state.");
            } else if (c.f77a[cnVar2.c - 1] == 1) {
                by byVar = by.this;
                byVar.b = byVar.a(activity);
            }
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f77a;

        static {
            int[] iArr = new int[cn.a.a().length];
            f77a = iArr;
            try {
                iArr[cn.a.d - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private by() {
        boolean z = false;
        Context context = e1.a().f110a;
        this.c = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? true : z;
        this.b = a(context);
        if (this.c) {
            c();
        }
    }

    public static synchronized by b() {
        by byVar;
        synchronized (by.class) {
            if (f == null) {
                f = new by();
            }
            byVar = f;
        }
        return byVar;
    }

    private synchronized void c() {
        if (!this.f74a) {
            Context context = e1.a().f110a;
            this.b = a(context);
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            n1.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", this.d);
            this.f74a = true;
        }
    }

    private static ConnectivityManager d() {
        return (ConnectivityManager) e1.a().f110a.getSystemService("connectivity");
    }

    public void onReceive(Context context, Intent intent) {
        boolean a2 = a(context);
        if (this.b != a2) {
            this.b = a2;
            w0 w0Var = new w0();
            w0Var.b = a2;
            a();
            n1.a().a(w0Var);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(Context context) {
        if (!this.c || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = d().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public final int a() {
        if (!this.c) {
            return a.f75a;
        }
        NetworkInfo activeNetworkInfo = d().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a.f75a;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type == 1) {
                return a.c;
            }
            if (!(type == 2 || type == 3 || type == 4 || type == 5)) {
                if (type == 8) {
                    return a.f75a;
                }
                if (activeNetworkInfo.isConnected()) {
                    return a.b;
                }
                return a.f75a;
            }
        }
        return a.d;
    }
}
