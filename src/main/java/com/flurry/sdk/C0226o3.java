package com.flurry.sdk;

import android.util.SparseArray;
import com.flurry.sdk.C0058c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.o3 */
public class C0226o3 {

    /* renamed from: e */
    static final String f663e = "o3";

    /* renamed from: a */
    Map<C0196m3, SparseArray<C0202n3>> f664a;

    /* renamed from: b */
    private Map<C0196m3, Map<String, C0058c>> f665b;

    /* renamed from: c */
    Map<C0196m3, Map<String, C0058c>> f666c;

    /* renamed from: d */
    long f667d;

    public C0226o3() {
        mo298d();
    }

    /* renamed from: b */
    private synchronized List<C0202n3> m596b(Map<C0196m3, SparseArray<C0202n3>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (SparseArray<C0202n3> sparseArray : map.values()) {
            for (int i = 0; i < sparseArray.size(); i++) {
                arrayList.add(sparseArray.valueAt(i));
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private synchronized void m597f(List<C0202n3> list, Map<C0196m3, SparseArray<C0202n3>> map) {
        for (C0202n3 n3Var : list) {
            int i = n3Var.f585b;
            C0196m3 m3Var = n3Var.f584a;
            SparseArray<C0202n3> sparseArray = map.get(m3Var);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                map.put(m3Var, sparseArray);
            } else {
                C0202n3 n3Var2 = sparseArray.get(i);
                if (n3Var2 != null) {
                    n3Var.mo275c(n3Var2);
                }
            }
            sparseArray.put(i, n3Var);
        }
    }

    /* renamed from: g */
    private synchronized void m598g(List<C0202n3> list, Map<C0196m3, SparseArray<C0202n3>> map, Map<C0196m3, Map<String, C0058c>> map2) {
        HashMap hashMap = new HashMap();
        m600i(map, hashMap, true, false);
        for (C0202n3 n3Var : list) {
            SparseArray sparseArray = (SparseArray) hashMap.get(n3Var.f584a);
            if (sparseArray != null) {
                sparseArray.remove(n3Var.f585b);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            C0196m3 m3Var = (C0196m3) entry.getKey();
            SparseArray sparseArray2 = (SparseArray) entry.getValue();
            SparseArray<C0202n3> sparseArray3 = map.get(m3Var);
            Map<String, C0058c> map3 = map2.get(m3Var);
            for (int i = 0; i < sparseArray2.size(); i++) {
                C0202n3 n3Var2 = (C0202n3) sparseArray2.valueAt(i);
                sparseArray3.remove(n3Var2.f585b);
                for (String str : n3Var2.f588e.keySet()) {
                    map3.remove(str);
                }
            }
        }
    }

    /* renamed from: h */
    private static void m599h(Map<C0196m3, Map<String, C0058c>> map, Map<C0196m3, Map<String, C0058c>> map2, C0196m3 m3Var, boolean z) {
        for (Map.Entry<C0196m3, Map<String, C0058c>> entry : map.entrySet()) {
            C0196m3 key = entry.getKey();
            if (m3Var == null || m3Var == key) {
                Map<String, C0058c> value = entry.getValue();
                if (z) {
                    value = new HashMap(value);
                }
                map2.put(key, value);
            }
        }
    }

    /* renamed from: i */
    private static void m600i(Map<C0196m3, SparseArray<C0202n3>> map, Map<C0196m3, SparseArray<C0202n3>> map2, boolean z, boolean z2) {
        SparseArray<C0202n3> sparseArray;
        for (Map.Entry<C0196m3, SparseArray<C0202n3>> entry : map.entrySet()) {
            C0196m3 key = entry.getKey();
            if (z) {
                SparseArray<C0202n3> value = entry.getValue();
                sparseArray = new SparseArray<>(value.size());
                for (int i = 0; i < value.size(); i++) {
                    C0202n3 valueAt = value.valueAt(i);
                    int i2 = valueAt.f585b;
                    if (z2) {
                        valueAt = new C0202n3(valueAt);
                    }
                    sparseArray.put(i2, valueAt);
                }
            } else {
                sparseArray = entry.getValue();
            }
            map2.put(key, sparseArray);
        }
    }

    /* renamed from: l */
    private synchronized void m601l(List<C0202n3> list, Map<C0196m3, Map<String, C0058c>> map) {
        for (C0202n3 n3Var : list) {
            C0196m3 m3Var = n3Var.f584a;
            Map<String, C0058c> map2 = map.get(m3Var);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(m3Var, map2);
            }
            for (Map.Entry<String, C0058c> entry : n3Var.mo274b()) {
                String key = entry.getKey();
                C0058c value = entry.getValue();
                if (value.f188a == C0058c.EnumC0059a.Tombstone) {
                    map2.remove(key);
                } else {
                    map2.put(key, value);
                }
            }
        }
    }

    /* renamed from: o */
    private synchronized void m602o(List<C0202n3> list) {
        for (C0202n3 n3Var : list) {
            C0196m3 m3Var = n3Var.f584a;
            Map<String, C0058c> map = this.f665b.get(m3Var);
            if (map == null) {
                map = new HashMap<>();
                this.f665b.put(m3Var, map);
            }
            Map<String, C0058c> map2 = this.f666c.get(m3Var);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.f666c.put(m3Var, map2);
            }
            for (Map.Entry<String, C0058c> entry : n3Var.mo274b()) {
                String key = entry.getKey();
                C0058c value = entry.getValue();
                map.put(key, value);
                map2.put(key, value);
            }
        }
    }

    /* renamed from: r */
    private synchronized void m603r() {
        this.f664a = new HashMap();
        this.f666c = new HashMap();
        for (C0196m3 m3Var : C0196m3.m527b()) {
            this.f664a.put(m3Var, new SparseArray<>());
            this.f666c.put(m3Var, new HashMap());
        }
    }

    /* renamed from: a */
    public final C0058c mo296a(String str, C0196m3 m3Var) {
        if (m3Var == null) {
            for (Map<String, C0058c> map : this.f665b.values()) {
                C0058c cVar = map.get(str);
                if (cVar != null) {
                    return cVar;
                }
            }
            return null;
        }
        Map<String, C0058c> map2 = this.f665b.get(m3Var);
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final JSONObject mo297c(Map<C0196m3, SparseArray<C0202n3>> map, Map<C0196m3, Map<String, C0058c>> map2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            List<C0202n3> b = m596b(map);
            if (z) {
                Collections.sort(b);
            }
            for (C0202n3 n3Var : b) {
                Map<String, C0058c> map3 = map2.get(n3Var.f584a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", n3Var.f585b);
                jSONObject2.put("version", n3Var.f586c);
                jSONObject2.put("document", n3Var.f584a.toString());
                JSONArray jSONArray2 = new JSONArray();
                for (Map.Entry<String, C0058c> entry : z ? new TreeMap(n3Var.f588e).entrySet() : n3Var.mo274b()) {
                    String key = entry.getKey();
                    C0058c cVar = map3.get(key);
                    if (cVar != null) {
                        jSONArray2.put(cVar.mo133b(key));
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("variants", jSONArray);
            jSONObject.put("refreshInSeconds", this.f667d);
            return jSONObject;
        } catch (JSONException e) {
            C0260s1.m689f(f663e, "Error to create JSON object.", e);
            return null;
        }
    }

    /* renamed from: d */
    public final synchronized void mo298d() {
        m603r();
        this.f665b = new HashMap();
        for (C0196m3 m3Var : C0196m3.m527b()) {
            this.f665b.put(m3Var, new HashMap());
        }
    }

    /* renamed from: e */
    public final synchronized void mo299e(List<C0202n3> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                m597f(list, this.f664a);
                m602o(list);
            }
        }
    }

    /* renamed from: j */
    public final synchronized boolean mo300j(List<C0202n3> list, boolean z) {
        if (list == null) {
            return true;
        }
        if (list.isEmpty()) {
            m603r();
            return true;
        } else if (z) {
            m603r();
            m597f(list, this.f664a);
            m601l(list, this.f666c);
            return true;
        } else {
            HashMap hashMap = new HashMap();
            m600i(this.f664a, hashMap, true, true);
            HashMap hashMap2 = new HashMap();
            m599h(this.f666c, hashMap2, null, true);
            m598g(list, hashMap, hashMap2);
            m597f(list, hashMap);
            m601l(list, hashMap2);
            C0260s1.m688e(f663e, "Verify ETag merged JSON: ".concat(String.valueOf(mo297c(hashMap, hashMap2, true))));
            m600i(hashMap, this.f664a, false, false);
            m599h(hashMap2, this.f666c, null, false);
            return true;
        }
    }

    /* renamed from: k */
    public final synchronized List<C0202n3> mo301k() {
        return m596b(this.f664a);
    }

    /* renamed from: m */
    public final synchronized boolean mo302m(List<C0202n3> list) {
        if (list == null) {
            return false;
        }
        if (list.size() != mo305q()) {
            return true;
        }
        for (C0202n3 n3Var : list) {
            SparseArray<C0202n3> sparseArray = this.f664a.get(n3Var.f584a);
            if (sparseArray == null) {
                return true;
            }
            C0202n3 n3Var2 = sparseArray.get(n3Var.f585b);
            if (n3Var2 == null) {
                return true;
            }
            if (n3Var.f586c != n3Var2.f586c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    public final synchronized String mo303n() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i = 0;
        for (SparseArray<C0202n3> sparseArray : this.f664a.values()) {
            i += sparseArray.size();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                C0202n3 valueAt = sparseArray.valueAt(i2);
                sb.append("," + valueAt.f585b);
                sb.append("," + valueAt.f586c);
            }
        }
        sb.insert(0, i);
        return sb.toString();
    }

    /* renamed from: p */
    public final synchronized List<C0196m3> mo304p() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<C0196m3, SparseArray<C0202n3>> entry : this.f664a.entrySet()) {
            if (entry.getValue().size() > 0) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    /* renamed from: q */
    public final synchronized int mo305q() {
        int i;
        i = 0;
        for (SparseArray<C0202n3> sparseArray : this.f664a.values()) {
            i += sparseArray.size();
        }
        return i;
    }
}
