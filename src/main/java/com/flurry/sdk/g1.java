package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

public class g1 {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Map<String, String>> f128a = new HashMap<>();
    private static g1 b;

    public static synchronized g1 b() {
        g1 g1Var;
        synchronized (g1.class) {
            if (b == null) {
                b = new g1();
            }
            g1Var = b;
        }
        return g1Var;
    }

    public final synchronized HashMap<String, Map<String, String>> a() {
        HashMap<String, Map<String, String>> hashMap;
        synchronized (f128a) {
            hashMap = new HashMap<>(f128a);
        }
        return hashMap;
    }
}
