package com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.m3 */
public final class C0196m3 {

    /* renamed from: b */
    private static final Map<String, C0196m3> f547b = new HashMap();

    /* renamed from: c */
    public static final C0196m3 f548c = new C0196m3("APP");

    /* renamed from: a */
    private String f549a;

    static {
        new C0196m3("KILLSWITCH");
    }

    private C0196m3(String str) {
        this.f549a = str;
        f547b.put(str, this);
    }

    /* renamed from: a */
    public static C0196m3 m526a(String str) {
        Map<String, C0196m3> map = f547b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return new C0196m3(str);
    }

    /* renamed from: b */
    public static Collection<C0196m3> m527b() {
        return f547b.values();
    }

    public final String toString() {
        return this.f549a;
    }
}
