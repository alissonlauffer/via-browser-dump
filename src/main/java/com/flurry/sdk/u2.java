package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class u2 {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f200a = new HashMap();
    private Map<String, List<a>> b = new HashMap();

    public interface a {
        void a(String str, Object obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        return;
     */
    public final synchronized void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            Object obj2 = this.f200a.get(str);
            if (!(obj == obj2 || (obj != null && obj.equals(obj2)))) {
                if (obj == null) {
                    this.f200a.remove(str);
                } else {
                    this.f200a.put(str, obj);
                }
                if (this.b.get(str) != null) {
                    for (a aVar : this.b.get(str)) {
                        aVar.a(str, obj);
                    }
                }
            }
        }
    }

    public final synchronized boolean b(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (aVar == null) {
            return false;
        }
        List<a> list = this.b.get(str);
        if (list == null) {
            return false;
        }
        return list.remove(aVar);
    }

    public final synchronized Object a(String str) {
        return this.f200a.get(str);
    }

    public final synchronized void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            List<a> list = this.b.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(aVar);
            this.b.put(str, list);
        }
    }
}
