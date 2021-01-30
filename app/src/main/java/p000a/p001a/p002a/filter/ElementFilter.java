package p000a.p001a.p002a.filter;

import java.util.Arrays;

/* renamed from: a.a.a.f.a */
/* compiled from: ElementFilter */
public class ElementFilter implements Filter {

    /* renamed from: a */
    private String f9a;

    /* renamed from: b */
    private String[] f10b;

    /* renamed from: c */
    public static ElementFilter m16c(String str) {
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty() && trim.charAt(0) != '!' && !trim.contains(":has(") && !trim.contains("+js(") && !trim.contains("#?#")) {
                int indexOf = trim.indexOf("##");
                boolean z = indexOf < 0 && (indexOf = trim.indexOf("#@#")) >= 0;
                if (indexOf < 0) {
                    return null;
                }
                ElementFilter aVar = new ElementFilter();
                String substring = trim.substring(0, indexOf);
                if (z && substring.isEmpty()) {
                    return null;
                }
                if (substring.indexOf(44) >= 0) {
                    String[] split = substring.split(",");
                    if (z) {
                        int length = split.length;
                        for (int i = 0; i < length; i++) {
                            if (split[i].charAt(0) != '~') {
                                split[i] = '~' + split[i];
                            }
                        }
                    }
                    aVar.mo20e(split);
                } else if (!substring.isEmpty()) {
                    if (z && substring.charAt(0) != '~') {
                        substring = '~' + substring;
                    }
                    aVar.mo20e(new String[]{substring});
                }
                aVar.mo19d(trim.substring(indexOf + (z ? 3 : 2)));
                return aVar;
            }
        }
        return null;
    }

    @Override // p000a.p001a.p002a.filter.Filter
    /* renamed from: a */
    public String mo17a() {
        return this.f9a;
    }

    /* renamed from: b */
    public String[] mo18b() {
        return this.f10b;
    }

    /* renamed from: d */
    public void mo19d(String str) {
        this.f9a = str;
    }

    /* renamed from: e */
    public void mo20e(String[] strArr) {
        this.f10b = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ElementFilter.class != obj.getClass()) {
            return false;
        }
        ElementFilter aVar = (ElementFilter) obj;
        String str = this.f9a;
        if (str == null ? aVar.f9a == null : str.equals(aVar.f9a)) {
            return Arrays.equals(this.f10b, aVar.f10b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f9a;
        return ((str != null ? str.hashCode() : 0) * 31) + Arrays.hashCode(this.f10b);
    }

    public String toString() {
        return "ElementFilter{content='" + this.f9a + "', domain=" + Arrays.toString(this.f10b) + '}';
    }
}
