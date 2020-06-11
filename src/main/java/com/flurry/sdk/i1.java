package com.flurry.sdk;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i1<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<K, List<V>> f139a = new HashMap();
    private int b;

    public final void a() {
        this.f139a.clear();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(java.lang.Object, boolean):java.util.List
     arg types: [K, int]
     candidates:
      MutableMD:(java.lang.Object, java.lang.Object):void
      MutableMD:(java.lang.Object, boolean):java.util.List */
    public final boolean b(K k, V v) {
        List<V> a2;
        if (k == null || (a2 = a((Object) k, false)) == null) {
            return false;
        }
        boolean remove = a2.remove(v);
        if (a2.size() == 0) {
            this.f139a.remove(k);
        }
        return remove;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(java.lang.Object, boolean):java.util.List
     arg types: [K, int]
     candidates:
      MutableMD:(java.lang.Object, java.lang.Object):void
      MutableMD:(java.lang.Object, boolean):java.util.List */
    public final List<V> a(K k) {
        if (k == null) {
            return Collections.emptyList();
        }
        List<V> a2 = a((Object) k, false);
        return a2 == null ? Collections.emptyList() : a2;
    }

    public final List<V> a(K k, boolean z) {
        ArrayList arrayList;
        List<V> list = this.f139a.get(k);
        if (!z || list != null) {
            return list;
        }
        if (this.b > 0) {
            arrayList = new ArrayList(this.b);
        } else {
            arrayList = new ArrayList();
        }
        this.f139a.put(k, arrayList);
        return arrayList;
    }

    public final boolean b(K k) {
        return this.f139a.remove(k) != null;
    }

    public final Collection<Map.Entry<K, V>> b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, List<V>> entry : this.f139a.entrySet()) {
            for (V v : entry.getValue()) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(entry.getKey(), v));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(java.lang.Object, boolean):java.util.List
     arg types: [K, int]
     candidates:
      MutableMD:(java.lang.Object, java.lang.Object):void
      MutableMD:(java.lang.Object, boolean):java.util.List */
    public final void a(K k, V v) {
        if (k != null) {
            a((Object) k, true).add(v);
        }
    }
}
