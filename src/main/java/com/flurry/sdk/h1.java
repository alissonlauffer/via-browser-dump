package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.flurry.sdk.cn;
import com.flurry.sdk.cp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class h1 {
    /* access modifiers changed from: private */
    public static final String c = "h1";
    /* access modifiers changed from: private */
    public static final List<String> d = new ArrayList(Arrays.asList("FlurryFullscreenTakeoverActivity", "FlurryBrowserActivity"));
    private static h1 e;
    /* access modifiers changed from: private */
    public static boolean f;
    /* access modifiers changed from: private */
    public static String g;

    /* renamed from: a  reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f134a;
    private ComponentCallbacks2 b;

    class b implements ComponentCallbacks2 {
        b(h1 h1Var) {
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
        }

        public final void onTrimMemory(int i) {
            if (i == 20) {
                h1.a(false);
            }
        }
    }

    private h1() {
        Context context = e1.a().f110a;
        if (this.f134a == null) {
            a aVar = new a();
            this.f134a = aVar;
            ((Application) context).registerActivityLifecycleCallbacks(aVar);
        }
        if (this.b == null) {
            b bVar = new b(this);
            this.b = bVar;
            context.registerComponentCallbacks(bVar);
        }
    }

    public static synchronized h1 c() {
        h1 h1Var;
        synchronized (h1.class) {
            if (e == null) {
                e = new h1();
            }
            h1Var = e;
        }
        return h1Var;
    }

    public final synchronized String b() {
        return g;
    }

    public final boolean a() {
        return this.f134a != null;
    }

    static /* synthetic */ void a(boolean z) {
        f = z;
        e1.a(z);
        n1.a().a(new cp(f ? cp.a.f93a : cp.a.b));
    }

    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        private static void a(Activity activity, int i) {
            cn cnVar = new cn();
            cnVar.b = new WeakReference<>(activity);
            cnVar.c = i;
            cnVar.b();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            s1.a(3, h1.c, "onActivityCreated for activity:".concat(String.valueOf(activity)));
            a(activity, cn.a.f92a);
            synchronized (h1.this) {
                if (h1.g == null) {
                    String unused = h1.g = activity.getClass().getName();
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            s1.a(3, h1.c, "onActivityDestroyed for activity:".concat(String.valueOf(activity)));
            a(activity, cn.a.b);
        }

        public final void onActivityPaused(Activity activity) {
            s1.a(3, h1.c, "onActivityPaused for activity:".concat(String.valueOf(activity)));
            a(activity, cn.a.c);
        }

        public final void onActivityResumed(Activity activity) {
            s1.a(3, h1.c, "onActivityResumed for activity:".concat(String.valueOf(activity)));
            if (!h1.f) {
                h1.a(true);
            }
            a(activity, cn.a.d);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            s1.a(3, h1.c, "onActivitySaveInstanceState for activity:".concat(String.valueOf(activity)));
            a(activity, cn.a.g);
        }

        public final void onActivityStarted(Activity activity) {
            s1.a(3, h1.c, "onActivityStarted for activity:".concat(String.valueOf(activity)));
            if (a(activity)) {
                a(activity, cn.a.e);
            }
        }

        public final void onActivityStopped(Activity activity) {
            s1.a(3, h1.c, "onActivityStopped for activity:".concat(String.valueOf(activity)));
            if (a(activity)) {
                a(activity, cn.a.f);
            }
        }

        private static boolean a(Activity activity) {
            return !h1.d.contains(activity.getClass().getSimpleName());
        }
    }
}
