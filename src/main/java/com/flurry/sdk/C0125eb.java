package com.flurry.sdk;

import com.flurry.sdk.C0275u2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.eb */
public class C0125eb implements C0275u2.AbstractC0276a {

    /* renamed from: f */
    private static final List<Class<?>> f373f = new ArrayList();

    /* renamed from: a */
    private final String f374a = C0125eb.class.getSimpleName();

    /* renamed from: b */
    private final Map<Class<?>, Object> f375b = new LinkedHashMap();

    /* renamed from: c */
    long f376c;

    /* renamed from: d */
    final Object f377d = new Object();

    /* renamed from: e */
    private volatile int f378e = EnumC0126a.f379a;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: com.flurry.sdk.eb$a */
    public static final class EnumC0126a extends Enum<EnumC0126a> {

        /* renamed from: a */
        public static final int f379a = 1;

        /* renamed from: b */
        public static final int f380b = 2;

        /* renamed from: c */
        public static final int f381c = 3;

        /* renamed from: d */
        private static final /* synthetic */ int[] f382d = {1, 2, 3};

        /* renamed from: a */
        public static int[] m407a() {
            return (int[]) f382d.clone();
        }
    }

    public C0125eb() {
        ArrayList<Class<?>> arrayList;
        List<Class<?>> list = f373f;
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        for (Class<?> cls : arrayList) {
            try {
                Object newInstance = cls.newInstance();
                synchronized (this.f375b) {
                    this.f375b.put(cls, newInstance);
                }
            } catch (Exception e) {
                String str = this.f374a;
                C0260s1.m687d(5, str, "Module data " + cls + " is not available:", e);
            }
        }
        C0266t2 e2 = C0266t2.m703e();
        this.f376c = ((Long) e2.mo341a("ContinueSessionMillis")).longValue();
        e2.mo342b("ContinueSessionMillis", this);
        String str2 = this.f374a;
        C0260s1.m686c(4, str2, "initSettings, ContinueSessionMillis = " + this.f376c);
    }

    /* renamed from: c */
    public static void m400c(Class<?> cls) {
        List<Class<?>> list = f373f;
        synchronized (list) {
            list.add(cls);
        }
    }

    /* renamed from: a */
    public final void mo196a(int i) {
        synchronized (this.f377d) {
            this.f378e = i;
        }
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        if (str.equals("ContinueSessionMillis")) {
            this.f376c = ((Long) obj).longValue();
            String str2 = this.f374a;
            C0260s1.m686c(4, str2, "onSettingUpdate, ContinueSessionMillis = " + this.f376c);
            return;
        }
        C0260s1.m686c(6, this.f374a, "onSettingUpdate internal error!");
    }

    /* renamed from: d */
    public boolean mo198d() {
        return false;
    }

    /* renamed from: e */
    public long mo199e() {
        return this.f376c;
    }

    /* renamed from: f */
    public final int mo200f() {
        int i;
        synchronized (this.f377d) {
            i = this.f378e;
        }
        return i;
    }

    /* renamed from: g */
    public final Object mo201g(Class<?> cls) {
        Object obj;
        synchronized (this.f375b) {
            obj = this.f375b.get(cls);
        }
        return obj;
    }
}
