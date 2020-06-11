package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class p3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f176a = "p3";

    public static void a(o3 o3Var) {
        if (o3Var.e() != 0) {
            ArrayList<n3> arrayList = new ArrayList(o3Var.b());
            Collections.sort(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (n3 n3Var : arrayList) {
                arrayList2.add(Integer.toString(n3Var.b));
            }
        }
    }

    public static void a(int i, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exp_code", String.valueOf(i));
        hashMap.put("exp_ms", String.valueOf(j));
        if (str != null) {
            hashMap.put("exp_det", str);
        }
        if (s1.c() <= 2) {
            s1.d(f176a, String.format("YWA event: %1$s {%2$s}", "expsdk_data", hashMap.toString()));
        }
    }
}
