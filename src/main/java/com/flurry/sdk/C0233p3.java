package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.flurry.sdk.p3 */
public class C0233p3 {

    /* renamed from: a */
    private static final String f675a = "p3";

    /* renamed from: a */
    public static void m622a(int i, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exp_code", String.valueOf(i));
        hashMap.put("exp_ms", String.valueOf(j));
        if (str != null) {
            hashMap.put("exp_det", str);
        }
        if (C0260s1.m695l() <= 2) {
            C0260s1.m699p(f675a, String.format("YWA event: %1$s {%2$s}", "expsdk_data", hashMap.toString()));
        }
    }

    /* renamed from: b */
    public static void m623b(C0226o3 o3Var) {
        if (o3Var.mo305q() != 0) {
            ArrayList<C0202n3> arrayList = new ArrayList(o3Var.mo301k());
            Collections.sort(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (C0202n3 n3Var : arrayList) {
                arrayList2.add(Integer.toString(n3Var.f585b));
            }
        }
    }
}
