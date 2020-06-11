package p000a.p001a.p002a.filter.p004e;

import android.webkit.WebResourceRequest;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.p002a.filter.ElementFilter;
import p000a.p001a.p002a.filter.Filter;
import p000a.p001a.p002a.filter.FilterSubscription;
import p000a.p001a.p002a.filter.RequestFilter;
import p000a.p001a.p002a.util.FilterUtils;

/* renamed from: a.a.a.f.e.a */
/* compiled from: DefaultFilterDataRepository */
public class DefaultFilterDataRepository implements FilterDataRepository {

    /* renamed from: a */
    private FilterDataSource f23a;

    /* renamed from: b */
    private FilterDataSource f24b;

    /* renamed from: c */
    private FilterSubscriptionDataSource f25c;

    /* renamed from: d */
    private HashMap<String, RequestFilter> f26d;

    /* renamed from: e */
    private boolean f27e = false;

    /* renamed from: f */
    private boolean f28f;

    /* renamed from: g */
    private HashMap<String, String> f29g;

    /* renamed from: h */
    private HashSet<String> f30h;

    /* renamed from: i */
    private String f31i = null;

    public DefaultFilterDataRepository(FilterDataSource cVar, FilterDataSource cVar2, FilterSubscriptionDataSource dVar, boolean z) {
        this.f23a = cVar;
        this.f24b = cVar2;
        this.f25c = dVar;
        this.f28f = z;
        this.f26d = new HashMap<>();
        this.f29g = new HashMap<>();
    }

    /* renamed from: b */
    private void m48b(Filter bVar) {
        String d;
        if (bVar != null) {
            if (bVar instanceof ElementFilter) {
                ElementFilter aVar = (ElementFilter) bVar;
                if (aVar.mo18b() == null || aVar.mo18b().length == 0) {
                    HashSet<String> hashSet = this.f30h;
                    if (hashSet != null) {
                        hashSet.add(aVar.mo17a());
                    } else {
                        this.f31i = FilterUtils.m96a(this.f31i, aVar.mo17a());
                    }
                } else {
                    String[] b = aVar.mo18b();
                    for (String str : b) {
                        if (str != null && str.length() > 2) {
                            HashMap<String, String> hashMap = this.f29g;
                            hashMap.put(str, FilterUtils.m96a(hashMap.get(str), aVar.mo17a()));
                        }
                    }
                }
            } else if ((bVar instanceof RequestFilter) && (d = FilterUtils.m99d(bVar.mo17a(), this.f26d.keySet())) != null) {
                this.f26d.put(d, (RequestFilter) bVar);
            }
        }
    }

    /* renamed from: l */
    private void m49l(List<Filter> list) {
        for (Filter bVar : list) {
            m48b(bVar);
        }
    }

    /* renamed from: m */
    private void m50m() {
        HashSet<String> hashSet = this.f30h;
        if (hashSet != null && !hashSet.isEmpty()) {
            Iterator<String> it = this.f30h.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            this.f31i = sb.toString();
            this.f30h.clear();
            this.f30h = null;
        }
    }

    /* renamed from: n */
    private RequestFilter m51n(String str, int i, String str2) {
        if (!this.f27e && !str.isEmpty() && !str.equals(str2)) {
            String h = FilterUtils.m103h(str);
            String h2 = FilterUtils.m103h(str2);
            boolean z = !FilterUtils.m107l(h, h2);
            int indexOf = str.indexOf("://");
            int i2 = indexOf < 0 ? -1 : indexOf + 2;
            int length = str.length() - 5;
            int i3 = 0;
            while (true) {
                i2++;
                if (i2 > length || i3 >= 32) {
                    return null;
                }
                RequestFilter dVar = this.f26d.get(str.substring(i2, i2 + 5));
                if (dVar != null) {
                    i3++;
                    if ((dVar.mo42e() == 0 || (dVar.mo42e() & i) != 0) && FilterUtils.m111p(dVar.mo17a(), str) && FilterUtils.m112q(dVar.mo40c(), h2) && FilterUtils.m114s(dVar.mo41d(), z)) {
                        return dVar;
                    }
                }
            }
        }
        return null;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: a */
    public Filter mo51a(String str) {
        return this.f24b.mo61a(str);
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: c */
    public boolean mo52c(String str) {
        PrintStream printStream = System.out;
        printStream.println("Add filter: " + str);
        Filter c = this.f24b.mo63c(str);
        if (c != null) {
            PrintStream printStream2 = System.out;
            printStream2.println("Cache filter: " + c);
            m48b(c);
        }
        return c != null;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: d */
    public boolean mo53d(String str) {
        System.out.println("Remove raw: " + str);
        Filter d = this.f24b.mo64d(str);
        if (d == null) {
            return false;
        }
        System.out.println("Remove filter: " + d);
        if (d instanceof RequestFilter) {
            String a = d.mo17a();
            int i = -1;
            int length = a.length() - 5;
            while (true) {
                i++;
                if (i > length) {
                    break;
                }
                String substring = a.substring(i, i + 5);
                RequestFilter dVar = this.f26d.get(substring);
                if (dVar != null && a.equals(dVar.mo17a())) {
                    System.out.println("Remove cached key: " + substring + ", content: " + dVar.mo17a());
                    this.f26d.remove(substring);
                    break;
                }
            }
        } else if (d instanceof ElementFilter) {
            ElementFilter aVar = (ElementFilter) d;
            if (aVar.mo18b() == null || aVar.mo18b().length == 0) {
                this.f31i = FilterUtils.m116u(this.f31i, aVar.mo17a());
            } else {
                String[] b = aVar.mo18b();
                for (String str2 : b) {
                    if (str2 != null && !str2.isEmpty()) {
                        String u = FilterUtils.m116u(this.f29g.get(str2), aVar.mo17a());
                        if (u == null || u.isEmpty()) {
                            System.out.println("Remove element filter map key: " + str2);
                            this.f29g.remove(str2);
                        } else {
                            System.out.println("New element filter map: " + str2 + ":" + u);
                            this.f29g.put(str2, u);
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: e */
    public RequestFilter mo54e(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return m51n(webResourceRequest.getUrl().toString(), FilterUtils.m100e(webResourceRequest, str), str);
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: f */
    public boolean mo55f(boolean z) {
        if (this.f28f == z) {
            return false;
        }
        this.f28f = z;
        return true;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: g */
    public void mo56g() {
        this.f27e = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.f30h = new HashSet<>();
        this.f26d.clear();
        m49l(this.f24b.mo62b());
        if (this.f28f) {
            m49l(this.f23a.mo62b());
        }
        m49l(this.f25c.mo66b());
        m50m();
        PrintStream printStream = System.out;
        printStream.println("Load filters done: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        this.f27e = false;
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: h */
    public boolean mo57h(List<FilterSubscription> list) {
        return this.f25c.mo65a(list);
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: i */
    public String mo58i(String str) {
        String h;
        String str2;
        String str3 = null;
        if (this.f27e || str == null || (h = FilterUtils.m103h(str)) == null || h.isEmpty()) {
            return null;
        }
        String str4 = this.f29g.get(h);
        String str5 = this.f29g.get('~' + h);
        String k = FilterUtils.m106k(h);
        if (!h.equals(k)) {
            str3 = this.f29g.get(k);
            str2 = this.f29g.get('~' + k);
        } else {
            str2 = null;
        }
        StringBuilder sb = new StringBuilder();
        String str6 = this.f31i;
        if (str6 != null && !str6.isEmpty()) {
            sb.append(this.f31i);
            sb.append(',');
        }
        if (str4 != null && !str4.isEmpty()) {
            sb.append(str4);
            sb.append(',');
        }
        if (str3 != null && !str3.isEmpty()) {
            sb.append(str3);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        StringBuilder sb2 = new StringBuilder();
        if (str5 != null && !str5.isEmpty()) {
            sb2.append(str5);
            sb2.append(',');
        }
        if (str2 != null && !str2.isEmpty()) {
            sb2.append(str2);
            sb2.append(',');
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return FilterUtils.m116u(sb.toString(), sb2.toString());
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: j */
    public RequestFilter mo59j(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return m51n(str, FilterUtils.m101f(str, str2), str2);
    }

    @Override // p000a.p001a.p002a.filter.p004e.FilterDataRepository
    /* renamed from: k */
    public List<FilterSubscription> mo60k() {
        return this.f25c.mo67c();
    }
}
