package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.u1 */
public final class C0274u1 {

    /* renamed from: b */
    private static final String f763b = "u1";

    /* renamed from: c */
    private static final Map<Class<? extends AbstractC0282v1>, C0265t1> f764c = new LinkedHashMap();

    /* renamed from: d */
    private static List<AbstractC0282v1> f765d = new ArrayList();

    /* renamed from: e */
    private static List<String> f766e;

    /* renamed from: a */
    private final Map<Class<? extends AbstractC0282v1>, AbstractC0282v1> f767a = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        f766e = arrayList;
        arrayList.add("com.flurry.android.marketing.core.FlurryMarketingCoreModule");
        f766e.add("com.flurry.android.marketing.FlurryMarketingModule");
        f766e.add("com.flurry.android.config.killswitch.FlurryKillSwitchModule");
        f766e.add("com.flurry.android.nativecrash.FlurryNativeCrashModule");
        f766e.add("com.flurry.android.FlurryAdModule");
        f766e.add("com.flurry.android.ymadlite.YahooAdModule");
    }

    /* renamed from: b */
    public static void m718b(AbstractC0282v1 v1Var) {
        if (v1Var != null) {
            boolean z = false;
            Iterator<AbstractC0282v1> it = f765d.iterator();
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
                f765d.add(v1Var);
                return;
            }
            String str = f763b;
            C0260s1.m686c(3, str, v1Var + " has been register already as addOn module");
            return;
        }
        C0260s1.m701r(f763b, "Module is null, cannot register it");
    }

    /* renamed from: c */
    public static void m719c(Class<? extends AbstractC0282v1> cls) {
        if (cls != null) {
            Map<Class<? extends AbstractC0282v1>, C0265t1> map = f764c;
            synchronized (map) {
                map.put(cls, new C0265t1(cls));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.Map<java.lang.Class<? extends com.flurry.sdk.v1>, com.flurry.sdk.v1> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final synchronized void mo339a(Context context) {
        ArrayList<C0265t1> arrayList;
        if (context == null) {
            C0260s1.m686c(5, f763b, "Null context.");
            return;
        }
        Map<Class<? extends AbstractC0282v1>, C0265t1> map = f764c;
        synchronized (map) {
            arrayList = new ArrayList(map.values());
        }
        for (C0265t1 t1Var : arrayList) {
            try {
                Class<? extends AbstractC0282v1> cls = t1Var.f727a;
                if (cls != null && Build.VERSION.SDK_INT >= t1Var.f728b) {
                    AbstractC0282v1 v1Var = (AbstractC0282v1) cls.newInstance();
                    v1Var.mo228a(context);
                    this.f767a.put(t1Var.f727a, v1Var);
                }
            } catch (Exception e) {
                String str = f763b;
                C0260s1.m687d(5, str, "Flurry Module for class " + t1Var.f727a + " is not available:", e);
            }
        }
        for (AbstractC0282v1 v1Var2 : f765d) {
            try {
                v1Var2.mo228a(context);
                this.f767a.put(v1Var2.getClass(), v1Var2);
            } catch (C0107dd e2) {
                C0260s1.m693j(f763b, e2.getMessage());
            }
        }
        C0243q2.m650a().mo315b(context);
        C0155h1.m459a();
    }

    /* renamed from: d */
    public final AbstractC0282v1 mo340d(Class<? extends AbstractC0282v1> cls) {
        AbstractC0282v1 v1Var;
        if (cls == null) {
            return null;
        }
        synchronized (this.f767a) {
            v1Var = this.f767a.get(cls);
        }
        if (v1Var != null) {
            return v1Var;
        }
        throw new IllegalStateException("Module was not registered/initialized. ".concat(String.valueOf(cls)));
    }
}
