package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.u2 */
public class C0275u2 {

    /* renamed from: a */
    private Map<String, Object> f768a = new HashMap();

    /* renamed from: b */
    private Map<String, List<AbstractC0276a>> f769b = new HashMap();

    /* renamed from: com.flurry.sdk.u2$a */
    public interface AbstractC0276a {
        /* renamed from: b */
        void mo197b(String str, Object obj);
    }

    /* renamed from: a */
    public final synchronized Object mo341a(String str) {
        return this.f768a.get(str);
    }

    /* renamed from: b */
    public final synchronized void mo342b(String str, AbstractC0276a aVar) {
        if (!TextUtils.isEmpty(str)) {
            List<AbstractC0276a> list = this.f769b.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(aVar);
            this.f769b.put(str, list);
        }
    }

    /* renamed from: c */
    public final synchronized void mo343c(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            Object obj2 = this.f768a.get(str);
            if (!(obj == obj2 || (obj != null && obj.equals(obj2)))) {
                if (obj == null) {
                    this.f768a.remove(str);
                } else {
                    this.f768a.put(str, obj);
                }
                if (this.f769b.get(str) != null) {
                    for (AbstractC0276a aVar : this.f769b.get(str)) {
                        aVar.mo197b(str, obj);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public final synchronized boolean mo344d(String str, AbstractC0276a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (aVar == null) {
            return false;
        }
        List<AbstractC0276a> list = this.f769b.get(str);
        if (list == null) {
            return false;
        }
        return list.remove(aVar);
    }
}
