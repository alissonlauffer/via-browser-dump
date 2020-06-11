package com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class m3 {
    private static final Map<String, m3> b = new HashMap();
    public static final m3 c = new m3("APP");

    /* renamed from: a  reason: collision with root package name */
    private String f160a;

    static {
        new m3("KILLSWITCH");
    }

    private m3(String str) {
        this.f160a = str;
        b.put(str, this);
    }

    public static m3 a(String str) {
        if (b.containsKey(str)) {
            return b.get(str);
        }
        return new m3(str);
    }

    public final String toString() {
        return this.f160a;
    }

    public static Collection<m3> a() {
        return b.values();
    }
}
