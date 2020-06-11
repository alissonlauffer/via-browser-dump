package p000a.p001a.p002a.filter;

import org.json.JSONObject;

/* renamed from: a.a.a.f.c */
/* compiled from: FilterSubscription */
public class FilterSubscription {

    /* renamed from: a */
    private String f11a;

    /* renamed from: b */
    private String f12b;

    /* renamed from: c */
    private String f13c;

    /* renamed from: d */
    private String f14d;

    /* renamed from: e */
    private String f15e;

    /* renamed from: f */
    private boolean f16f = true;

    /* renamed from: g */
    private int f17g = 0;

    public FilterSubscription() {
    }

    /* renamed from: f */
    public static FilterSubscription m22f(String str) {
        FilterSubscription cVar = new FilterSubscription();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("url")) {
                return null;
            }
            if (jSONObject.isNull("filePath")) {
                return null;
            }
            cVar.mo37m(jSONObject.getString("url"));
            cVar.mo31h(jSONObject.getString("filePath"));
            if (!jSONObject.isNull("title")) {
                cVar.mo36l(jSONObject.getString("title"));
            }
            if (!jSONObject.isNull("homepage")) {
                cVar.mo33i(jSONObject.getString("homepage"));
            }
            if (!jSONObject.isNull("lincese")) {
                cVar.mo34j(jSONObject.getString("lincese"));
            }
            if (!jSONObject.isNull("enabled")) {
                cVar.mo30g(jSONObject.getBoolean("enabled"));
            }
            if (!jSONObject.isNull("size")) {
                cVar.mo35k(jSONObject.getInt("size"));
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String mo24a() {
        return this.f15e;
    }

    /* renamed from: b */
    public int mo25b() {
        return this.f17g;
    }

    /* renamed from: c */
    public String mo26c() {
        return this.f11a;
    }

    /* renamed from: d */
    public String mo27d() {
        return this.f12b;
    }

    /* renamed from: e */
    public boolean mo28e() {
        return this.f16f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FilterSubscription.class != obj.getClass()) {
            return false;
        }
        String str = this.f12b;
        String str2 = ((FilterSubscription) obj).f12b;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public void mo30g(boolean z) {
        this.f16f = z;
    }

    /* renamed from: h */
    public void mo31h(String str) {
        this.f15e = str;
    }

    public int hashCode() {
        String str = this.f12b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* renamed from: i */
    public void mo33i(String str) {
        this.f13c = str;
    }

    /* renamed from: j */
    public void mo34j(String str) {
        this.f14d = str;
    }

    /* renamed from: k */
    public void mo35k(int i) {
        this.f17g = i;
    }

    /* renamed from: l */
    public void mo36l(String str) {
        this.f11a = str;
    }

    /* renamed from: m */
    public void mo37m(String str) {
        this.f12b = str;
    }

    /* renamed from: n */
    public String mo38n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.f11a);
            jSONObject.put("url", this.f12b);
            jSONObject.put("homepage", this.f13c);
            jSONObject.put("lincese", this.f14d);
            jSONObject.put("filePath", this.f15e);
            jSONObject.put("enabled", this.f16f);
            jSONObject.put("size", this.f17g);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "FilterSubscription{title='" + this.f11a + "', url='" + this.f12b + "', homepage='" + this.f13c + "', lincese='" + this.f14d + "', filePath='" + this.f15e + "', enabled=" + this.f16f + ", size=" + this.f17g + '}';
    }

    public FilterSubscription(String str, String str2, boolean z) {
        this.f12b = str;
        this.f15e = str2;
        this.f16f = z;
    }
}
