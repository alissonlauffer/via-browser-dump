package p000a.p001a.p002a.filter.p004e;

import android.webkit.WebResourceRequest;
import java.util.List;
import p000a.p001a.p002a.filter.Filter;
import p000a.p001a.p002a.filter.FilterSubscription;
import p000a.p001a.p002a.filter.RequestFilter;

/* renamed from: a.a.a.f.e.b */
/* compiled from: FilterDataRepository */
public interface FilterDataRepository {
    /* renamed from: a */
    Filter mo51a(String str);

    /* renamed from: c */
    boolean mo52c(String str);

    /* renamed from: d */
    boolean mo53d(String str);

    /* renamed from: e */
    RequestFilter mo54e(WebResourceRequest webResourceRequest, String str);

    /* renamed from: f */
    boolean mo55f(boolean z);

    /* renamed from: g */
    void mo56g();

    /* renamed from: h */
    boolean mo57h(List<FilterSubscription> list);

    /* renamed from: i */
    String mo58i(String str);

    /* renamed from: j */
    RequestFilter mo59j(String str, String str2);

    /* renamed from: k */
    List<FilterSubscription> mo60k();
}
