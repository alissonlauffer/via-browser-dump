package com.flurry.sdk;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.i1 */
public final class C0162i1<K, V> {

    /* renamed from: a */
    public final Map<K, List<V>> f493a = new HashMap();

    /* renamed from: b */
    private int f494b;

    /* renamed from: a */
    public final List<V> mo230a(K k) {
        if (k == null) {
            return Collections.emptyList();
        }
        List<V> b = mo231b(k, false);
        return b == null ? Collections.emptyList() : b;
    }

    /* renamed from: b */
    public final List<V> mo231b(K k, boolean z) {
        ArrayList arrayList;
        List<V> list = this.f493a.get(k);
        if (!z || list != null) {
            return list;
        }
        if (this.f494b > 0) {
            arrayList = new ArrayList(this.f494b);
        } else {
            arrayList = new ArrayList();
        }
        this.f493a.put(k, arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public final void mo232c() {
        this.f493a.clear();
    }

    /* renamed from: d */
    public final void mo233d(K k, V v) {
        if (k != null) {
            mo231b(k, true).add(v);
        }
    }

    /* renamed from: e */
    public final Collection<Map.Entry<K, V>> mo234e() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, List<V>> entry : this.f493a.entrySet()) {
            for (V v : entry.getValue()) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(entry.getKey(), v));
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public final boolean mo235f(K k) {
        return this.f493a.remove(k) != null;
    }

    /* renamed from: g */
    public final boolean mo236g(K k, V v) {
        List<V> b;
        if (k == null || (b = mo231b(k, false)) == null) {
            return false;
        }
        boolean remove = b.remove(v);
        if (b.size() == 0) {
            this.f493a.remove(k);
        }
        return remove;
    }
}
