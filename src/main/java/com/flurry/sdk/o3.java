package com.flurry.sdk;

import android.util.SparseArray;
import com.flurry.sdk.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o3 {
    static final String e = "o3";

    /* renamed from: a  reason: collision with root package name */
    Map<m3, SparseArray<n3>> f172a;
    private Map<m3, Map<String, c>> b;
    Map<m3, Map<String, c>> c;
    long d;

    public o3() {
        a();
    }

    private synchronized void c(List<n3> list) {
        for (n3 n3Var : list) {
            m3 m3Var = n3Var.f164a;
            Map<String, c> map = this.b.get(m3Var);
            if (map == null) {
                map = new HashMap<>();
                this.b.put(m3Var, map);
            }
            Map<String, c> map2 = this.c.get(m3Var);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.c.put(m3Var, map2);
            }
            for (Map.Entry<String, c> entry : n3Var.a()) {
                String key = entry.getKey();
                c value = entry.getValue();
                map.put(key, value);
                map2.put(key, value);
            }
        }
    }

    private synchronized void f() {
        this.f172a = new HashMap();
        this.c = new HashMap();
        for (m3 m3Var : m3.a()) {
            this.f172a.put(m3Var, new SparseArray<>());
            this.c.put(m3Var, new HashMap());
        }
    }

    public final synchronized void a(List<n3> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                a(list, this.f172a);
                c(list);
            }
        }
    }

    public final synchronized boolean b(List<n3> list) {
        if (list == null) {
            return false;
        }
        if (list.size() != e()) {
            return true;
        }
        for (n3 n3Var : list) {
            SparseArray<n3> sparseArray = this.f172a.get(n3Var.f164a);
            if (sparseArray == null) {
                return true;
            }
            n3 n3Var2 = sparseArray.get(n3Var.b);
            if (n3Var2 == null) {
                return true;
            }
            if (n3Var.c != n3Var2.c) {
                return true;
            }
        }
        return false;
    }

    public final synchronized List<m3> d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<m3, SparseArray<n3>> entry : this.f172a.entrySet()) {
            if (entry.getValue().size() > 0) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public final synchronized int e() {
        int i;
        i = 0;
        for (SparseArray<n3> sparseArray : this.f172a.values()) {
            i += sparseArray.size();
        }
        return i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void
     arg types: [java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.HashMap, int, int]
     candidates:
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void
     arg types: [java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.HashMap, ?[OBJECT, ARRAY], int]
     candidates:
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, boolean):org.json.JSONObject
     arg types: [java.util.HashMap, java.util.HashMap, int]
     candidates:
      com.flurry.sdk.o3.a(java.util.List<com.flurry.sdk.n3>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, boolean):org.json.JSONObject */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void
     arg types: [java.util.HashMap, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, int, int]
     candidates:
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void
     arg types: [java.util.HashMap, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, ?[OBJECT, ARRAY], int]
     candidates:
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void */
    public final synchronized boolean a(List<n3> list, boolean z) {
        if (list == null) {
            return true;
        }
        if (list.isEmpty()) {
            f();
            return true;
        } else if (z) {
            f();
            a(list, this.f172a);
            b(list, this.c);
            return true;
        } else {
            HashMap hashMap = new HashMap();
            a(this.f172a, (Map<m3, SparseArray<n3>>) hashMap, true, true);
            HashMap hashMap2 = new HashMap();
            a(this.c, (Map<m3, Map<String, c>>) hashMap2, (m3) null, true);
            a(list, hashMap, hashMap2);
            a(list, hashMap);
            b(list, hashMap2);
            s1.a(e, "Verify ETag merged JSON: ".concat(String.valueOf(a((Map<m3, SparseArray<n3>>) hashMap, (Map<m3, Map<String, c>>) hashMap2, true))));
            a((Map<m3, SparseArray<n3>>) hashMap, this.f172a, false, false);
            a((Map<m3, Map<String, c>>) hashMap2, this.c, (m3) null, false);
            return true;
        }
    }

    private synchronized void b(List<n3> list, Map<m3, Map<String, c>> map) {
        for (n3 n3Var : list) {
            m3 m3Var = n3Var.f164a;
            Map<String, c> map2 = map.get(m3Var);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(m3Var, map2);
            }
            for (Map.Entry<String, c> entry : n3Var.a()) {
                String key = entry.getKey();
                c value = entry.getValue();
                if (value.f78a == c.a.Tombstone) {
                    map2.remove(key);
                } else {
                    map2.put(key, value);
                }
            }
        }
    }

    public final synchronized String c() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i = 0;
        for (SparseArray<n3> sparseArray : this.f172a.values()) {
            i += sparseArray.size();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                n3 valueAt = sparseArray.valueAt(i2);
                sb.append("," + valueAt.b);
                sb.append("," + valueAt.c);
            }
        }
        sb.insert(0, i);
        return sb.toString();
    }

    private static void a(Map<m3, SparseArray<n3>> map, Map<m3, SparseArray<n3>> map2, boolean z, boolean z2) {
        SparseArray<n3> sparseArray;
        for (Map.Entry<m3, SparseArray<n3>> entry : map.entrySet()) {
            m3 key = entry.getKey();
            if (z) {
                SparseArray<n3> value = entry.getValue();
                sparseArray = new SparseArray<>(value.size());
                for (int i = 0; i < value.size(); i++) {
                    n3 valueAt = value.valueAt(i);
                    int i2 = valueAt.b;
                    if (z2) {
                        valueAt = new n3(valueAt);
                    }
                    sparseArray.put(i2, valueAt);
                }
            } else {
                sparseArray = entry.getValue();
            }
            map2.put(key, sparseArray);
        }
    }

    public final synchronized List<n3> b() {
        return a(this.f172a);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void
     arg types: [java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.HashMap, int, int]
     candidates:
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, com.flurry.sdk.m3, boolean):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, boolean, boolean):void */
    private synchronized void a(List<n3> list, Map<m3, SparseArray<n3>> map, Map<m3, Map<String, c>> map2) {
        HashMap hashMap = new HashMap();
        a(map, (Map<m3, SparseArray<n3>>) hashMap, true, false);
        for (n3 n3Var : list) {
            SparseArray sparseArray = (SparseArray) hashMap.get(n3Var.f164a);
            if (sparseArray != null) {
                sparseArray.remove(n3Var.b);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            m3 m3Var = (m3) entry.getKey();
            SparseArray sparseArray2 = (SparseArray) entry.getValue();
            SparseArray<n3> sparseArray3 = map.get(m3Var);
            Map<String, c> map3 = map2.get(m3Var);
            for (int i = 0; i < sparseArray2.size(); i++) {
                n3 n3Var2 = (n3) sparseArray2.valueAt(i);
                sparseArray3.remove(n3Var2.b);
                for (String str : n3Var2.e.keySet()) {
                    map3.remove(str);
                }
            }
        }
    }

    private synchronized void a(List<n3> list, Map<m3, SparseArray<n3>> map) {
        for (n3 n3Var : list) {
            int i = n3Var.b;
            m3 m3Var = n3Var.f164a;
            SparseArray<n3> sparseArray = map.get(m3Var);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                map.put(m3Var, sparseArray);
            } else {
                n3 n3Var2 = sparseArray.get(i);
                if (n3Var2 != null) {
                    n3Var.a(n3Var2);
                }
            }
            sparseArray.put(i, n3Var);
        }
    }

    private static void a(Map<m3, Map<String, c>> map, Map<m3, Map<String, c>> map2, m3 m3Var, boolean z) {
        for (Map.Entry<m3, Map<String, c>> entry : map.entrySet()) {
            m3 key = entry.getKey();
            if (m3Var == null || m3Var == key) {
                Map<String, c> value = entry.getValue();
                if (z) {
                    value = new HashMap(value);
                }
                map2.put(key, value);
            }
        }
    }

    public final c a(String str, m3 m3Var) {
        if (m3Var == null) {
            for (Map<String, c> map : this.b.values()) {
                c cVar = map.get(str);
                if (cVar != null) {
                    return cVar;
                }
            }
            return null;
        }
        Map<String, c> map2 = this.b.get(m3Var);
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    public final synchronized void a() {
        f();
        this.b = new HashMap();
        for (m3 m3Var : m3.a()) {
            this.b.put(m3Var, new HashMap());
        }
    }

    private synchronized List<n3> a(Map<m3, SparseArray<n3>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (SparseArray<n3> sparseArray : map.values()) {
            for (int i = 0; i < sparseArray.size(); i++) {
                arrayList.add(sparseArray.valueAt(i));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(Map<m3, SparseArray<n3>> map, Map<m3, Map<String, c>> map2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            List<n3> a2 = a(map);
            if (z) {
                Collections.sort(a2);
            }
            for (n3 n3Var : a2) {
                Map<String, c> map3 = map2.get(n3Var.f164a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", n3Var.b);
                jSONObject2.put("version", n3Var.c);
                jSONObject2.put("document", n3Var.f164a.toString());
                JSONArray jSONArray2 = new JSONArray();
                for (Map.Entry<String, c> entry : z ? new TreeMap(n3Var.e).entrySet() : n3Var.a()) {
                    String key = entry.getKey();
                    c cVar = map3.get(key);
                    if (cVar != null) {
                        jSONArray2.put(cVar.a(key));
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("variants", jSONArray);
            jSONObject.put("refreshInSeconds", this.d);
            return jSONObject;
        } catch (JSONException e2) {
            s1.a(e, "Error to create JSON object.", e2);
            return null;
        }
    }
}
