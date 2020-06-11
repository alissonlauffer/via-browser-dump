package com.flurry.sdk;

import com.flurry.sdk.u2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class eb implements u2.a {
    private static final List<Class<?>> f = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private final String f114a = eb.class.getSimpleName();
    private final Map<Class<?>, Object> b = new LinkedHashMap();
    long c;
    final Object d = new Object();
    private volatile int e = a.f115a;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f115a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
     arg types: [java.lang.String, com.flurry.sdk.eb]
     candidates:
      com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
      com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
    public eb() {
        ArrayList<Class<?>> arrayList;
        synchronized (f) {
            arrayList = new ArrayList(f);
        }
        for (Class<?> cls : arrayList) {
            try {
                Object newInstance = cls.newInstance();
                synchronized (this.b) {
                    this.b.put(cls, newInstance);
                }
            } catch (Exception e2) {
                String str = this.f114a;
                s1.a(5, str, "Module data " + cls + " is not available:", e2);
            }
        }
        t2 a2 = t2.a();
        this.c = ((Long) a2.a("ContinueSessionMillis")).longValue();
        a2.a("ContinueSessionMillis", (u2.a) this);
        String str2 = this.f114a;
        s1.a(4, str2, "initSettings, ContinueSessionMillis = " + this.c);
    }

    public static void b(Class<?> cls) {
        synchronized (f) {
            f.add(cls);
        }
    }

    public final Object a(Class<?> cls) {
        Object obj;
        synchronized (this.b) {
            obj = this.b.get(cls);
        }
        return obj;
    }

    public boolean a() {
        return false;
    }

    public final int c() {
        int i;
        synchronized (this.d) {
            i = this.e;
        }
        return i;
    }

    public final void a(int i) {
        synchronized (this.d) {
            this.e = i;
        }
    }

    public long b() {
        return this.c;
    }

    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        if (str.equals("ContinueSessionMillis")) {
            this.c = ((Long) obj).longValue();
            String str2 = this.f114a;
            s1.a(4, str2, "onSettingUpdate, ContinueSessionMillis = " + this.c);
            return;
        }
        s1.a(6, this.f114a, "onSettingUpdate internal error!");
    }
}
