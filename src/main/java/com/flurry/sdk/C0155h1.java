package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.flurry.sdk.C0082cn;
import com.flurry.sdk.C0084cp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.flurry.sdk.h1 */
public final class C0155h1 {

    /* renamed from: c */
    private static final String f471c = "h1";

    /* renamed from: d */
    private static final List<String> f472d = new ArrayList(Arrays.asList("FlurryFullscreenTakeoverActivity", "FlurryBrowserActivity"));

    /* renamed from: e */
    private static C0155h1 f473e;

    /* renamed from: f */
    private static boolean f474f;

    /* renamed from: g */
    private static String f475g;

    /* renamed from: a */
    private Application.ActivityLifecycleCallbacks f476a;

    /* renamed from: b */
    private ComponentCallbacks2 f477b;

    /* renamed from: com.flurry.sdk.h1$a */
    class C0156a implements Application.ActivityLifecycleCallbacks {
        C0156a() {
        }

        /* renamed from: a */
        private static void m468a(Activity activity, int i) {
            C0082cn cnVar = new C0082cn();
            cnVar.f246b = new WeakReference<>(activity);
            cnVar.f247c = i;
            cnVar.mo261b();
        }

        /* renamed from: b */
        private static boolean m469b(Activity activity) {
            return !C0155h1.f472d.contains(activity.getClass().getSimpleName());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivityCreated for activity:".concat(String.valueOf(activity)));
            m468a(activity, C0082cn.EnumC0083a.f248a);
            synchronized (C0155h1.this) {
                if (C0155h1.f475g == null) {
                    String unused = C0155h1.f475g = activity.getClass().getName();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivityDestroyed for activity:".concat(String.valueOf(activity)));
            m468a(activity, C0082cn.EnumC0083a.f249b);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivityPaused for activity:".concat(String.valueOf(activity)));
            m468a(activity, C0082cn.EnumC0083a.f250c);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivityResumed for activity:".concat(String.valueOf(activity)));
            if (!C0155h1.f474f) {
                C0155h1.m461c(true);
            }
            m468a(activity, C0082cn.EnumC0083a.f251d);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivitySaveInstanceState for activity:".concat(String.valueOf(activity)));
            m468a(activity, C0082cn.EnumC0083a.f254g);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivityStarted for activity:".concat(String.valueOf(activity)));
            if (m469b(activity)) {
                m468a(activity, C0082cn.EnumC0083a.f252e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            C0260s1.m686c(3, C0155h1.f471c, "onActivityStopped for activity:".concat(String.valueOf(activity)));
            if (m469b(activity)) {
                m468a(activity, C0082cn.EnumC0083a.f253f);
            }
        }
    }

    /* renamed from: com.flurry.sdk.h1$b */
    class ComponentCallbacks2C0157b implements ComponentCallbacks2 {
        ComponentCallbacks2C0157b(C0155h1 h1Var) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i) {
            if (i == 20) {
                C0155h1.m461c(false);
            }
        }
    }

    private C0155h1() {
        Context context = C0118e1.m386a().f361a;
        if (this.f476a == null) {
            C0156a aVar = new C0156a();
            this.f476a = aVar;
            ((Application) context).registerActivityLifecycleCallbacks(aVar);
        }
        if (this.f477b == null) {
            ComponentCallbacks2C0157b bVar = new ComponentCallbacks2C0157b(this);
            this.f477b = bVar;
            context.registerComponentCallbacks(bVar);
        }
    }

    /* renamed from: a */
    public static synchronized C0155h1 m459a() {
        C0155h1 h1Var;
        synchronized (C0155h1.class) {
            if (f473e == null) {
                f473e = new C0155h1();
            }
            h1Var = f473e;
        }
        return h1Var;
    }

    /* renamed from: c */
    static /* synthetic */ void m461c(boolean z) {
        f474f = z;
        C0118e1.m388f(z);
        C0199n1.m528a().mo269c(new C0084cp(f474f ? C0084cp.EnumC0085a.f256a : C0084cp.EnumC0085a.f257b));
    }

    /* renamed from: d */
    public final boolean mo216d() {
        return this.f476a != null;
    }

    /* renamed from: e */
    public final synchronized String mo217e() {
        return f475g;
    }
}
