package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.g1 */
public class C0146g1 {

    /* renamed from: a */
    private static final HashMap<String, Map<String, String>> f450a = new HashMap<>();

    /* renamed from: b */
    private static C0146g1 f451b;

    /* renamed from: a */
    public static synchronized C0146g1 m447a() {
        C0146g1 g1Var;
        synchronized (C0146g1.class) {
            if (f451b == null) {
                f451b = new C0146g1();
            }
            g1Var = f451b;
        }
        return g1Var;
    }

    /* renamed from: b */
    public final synchronized HashMap<String, Map<String, String>> mo209b() {
        HashMap<String, Map<String, String>> hashMap;
        HashMap<String, Map<String, String>> hashMap2 = f450a;
        synchronized (hashMap2) {
            hashMap = new HashMap<>(hashMap2);
        }
        return hashMap;
    }
}
