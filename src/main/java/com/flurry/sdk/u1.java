package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class u1 {
    private static final String b = "u1";
    private static final Map<Class<? extends v1>, t1> c = new LinkedHashMap();
    private static List<v1> d = new ArrayList();
    private static List<String> e;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends v1>, v1> f199a = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        e = arrayList;
        arrayList.add("com.flurry.android.marketing.core.FlurryMarketingCoreModule");
        e.add("com.flurry.android.marketing.FlurryMarketingModule");
        e.add("com.flurry.android.config.killswitch.FlurryKillSwitchModule");
        e.add("com.flurry.android.nativecrash.FlurryNativeCrashModule");
        e.add("com.flurry.android.FlurryAdModule");
        e.add("com.flurry.android.ymadlite.YahooAdModule");
    }

    public static void a(v1 v1Var) {
        if (v1Var != null) {
            boolean z = false;
            Iterator<v1> it = d.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getClass().getSimpleName().equals(v1Var.getClass().getSimpleName())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                d.add(v1Var);
                return;
            }
            String str = b;
            s1.a(3, str, v1Var + " has been register already as addOn module");
            return;
        }
        s1.e(b, "Module is null, cannot register it");
    }

    public static void b(Class<? extends v1> cls) {
        if (cls != null) {
            synchronized (c) {
                c.put(cls, new t1(cls));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.Map<java.lang.Class<? extends com.flurry.sdk.v1>, com.flurry.sdk.v1>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Class<?>} */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void a(Context context) {
        ArrayList<t1> arrayList;
        if (context == null) {
            s1.a(5, b, "Null context.");
            return;
        }
        synchronized (c) {
            arrayList = new ArrayList(c.values());
        }
        for (t1 t1Var : arrayList) {
            try {
                if (t1Var.f194a != null && Build.VERSION.SDK_INT >= t1Var.b) {
                    v1 v1Var = (v1) t1Var.f194a.newInstance();
                    v1Var.a(context);
                    this.f199a.put(t1Var.f194a, v1Var);
                }
            } catch (Exception e2) {
                String str = b;
                s1.a(5, str, "Flurry Module for class " + t1Var.f194a + " is not available:", e2);
            }
        }
        for (v1 v1Var2 : d) {
            try {
                v1Var2.a(context);
                this.f199a.put(v1Var2.getClass(), v1Var2);
            } catch (dd e3) {
                s1.b(b, e3.getMessage());
            }
        }
        q2.d().a(context);
        h1.c();
    }

    public final v1 a(Class<? extends v1> cls) {
        v1 v1Var;
        if (cls == null) {
            return null;
        }
        synchronized (this.f199a) {
            v1Var = this.f199a.get(cls);
        }
        if (v1Var != null) {
            return v1Var;
        }
        throw new IllegalStateException("Module was not registered/initialized. ".concat(String.valueOf(cls)));
    }
}
