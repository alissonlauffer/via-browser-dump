package com.flurry.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.flurry.sdk.C0082cn;

/* renamed from: com.flurry.sdk.by */
public class C0054by extends BroadcastReceiver {

    /* renamed from: e */
    public static final String f173e = C0054by.class.getSimpleName();

    /* renamed from: f */
    private static C0054by f174f;

    /* renamed from: a */
    boolean f175a;

    /* renamed from: b */
    public boolean f176b;

    /* renamed from: c */
    private boolean f177c = false;

    /* renamed from: d */
    private final AbstractC0192m1<C0082cn> f178d = new C0056b();

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: com.flurry.sdk.by$a */
    public static final class EnumC0055a extends Enum<EnumC0055a> {

        /* renamed from: a */
        public static final int f179a = 1;

        /* renamed from: b */
        public static final int f180b = 2;

        /* renamed from: c */
        public static final int f181c = 3;

        /* renamed from: d */
        public static final int f182d = 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.by$b */
    public class C0056b implements AbstractC0192m1<C0082cn> {
        C0056b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0082cn cnVar) {
            C0082cn cnVar2 = cnVar;
            Activity activity = cnVar2.f246b.get();
            if (activity == null) {
                C0260s1.m686c(3, C0054by.f173e, "Activity has been destroyed, don't update network state.");
            } else if (C0057c.f184a[cnVar2.f247c - 1] == 1) {
                C0054by byVar = C0054by.this;
                byVar.f176b = byVar.m255b(activity);
            }
        }
    }

    /* renamed from: com.flurry.sdk.by$c */
    static /* synthetic */ class C0057c {

        /* renamed from: a */
        static final /* synthetic */ int[] f184a;

        static {
            int[] iArr = new int[C0082cn.EnumC0083a.m312a().length];
            f184a = iArr;
            try {
                iArr[C0082cn.EnumC0083a.f251d - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private C0054by() {
        boolean z = false;
        Context context = C0118e1.m386a().f361a;
        this.f177c = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? true : z;
        this.f176b = m255b(context);
        if (this.f177c) {
            m257e();
        }
    }

    /* renamed from: a */
    public static synchronized C0054by m254a() {
        C0054by byVar;
        synchronized (C0054by.class) {
            if (f174f == null) {
                f174f = new C0054by();
            }
            byVar = f174f;
        }
        return byVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private boolean m255b(Context context) {
        if (!this.f177c || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = m258f().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    private synchronized void m257e() {
        if (!this.f175a) {
            Context context = C0118e1.m386a().f361a;
            this.f176b = m255b(context);
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            C0199n1.m528a().mo271e("com.flurry.android.sdk.ActivityLifecycleEvent", this.f178d);
            this.f175a = true;
        }
    }

    /* renamed from: f */
    private static ConnectivityManager m258f() {
        return (ConnectivityManager) C0118e1.m386a().f361a.getSystemService("connectivity");
    }

    /* renamed from: d */
    public final int mo130d() {
        if (!this.f177c) {
            return EnumC0055a.f179a;
        }
        NetworkInfo activeNetworkInfo = m258f().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return EnumC0055a.f179a;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type == 1) {
                return EnumC0055a.f181c;
            }
            if (!(type == 2 || type == 3 || type == 4 || type == 5)) {
                if (type == 8) {
                    return EnumC0055a.f179a;
                }
                if (activeNetworkInfo.isConnected()) {
                    return EnumC0055a.f180b;
                }
                return EnumC0055a.f179a;
            }
        }
        return EnumC0055a.f182d;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean b = m255b(context);
        if (this.f176b != b) {
            this.f176b = b;
            C0298w0 w0Var = new C0298w0();
            w0Var.f825b = b;
            mo130d();
            C0199n1.m528a().mo269c(w0Var);
        }
    }
}
