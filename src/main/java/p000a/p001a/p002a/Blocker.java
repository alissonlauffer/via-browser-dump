package p000a.p001a.p002a;

import android.content.Context;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java9.util.concurrent.CompletableFuture;
import p000a.p001a.p002a.filter.FilterSubscription;
import p000a.p001a.p002a.filter.RequestFilter;
import p000a.p001a.p002a.filter.p004e.DefaultFilterDataRepository;
import p000a.p001a.p002a.filter.p004e.FilterDataRepository;
import p000a.p001a.p002a.filter.p004e.p005e.CustomFilterDataSource;
import p000a.p001a.p002a.filter.p004e.p006f.FilterFilesDataSource;
import p000a.p001a.p002a.filter.p004e.p007g.InnerFilterDataSource;

/* renamed from: a.a.a.e */
/* compiled from: Blocker */
public class Blocker {

    /* renamed from: b */
    public static final WebResourceResponse f7b = (Build.VERSION.SDK_INT >= 11 ? new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream("".getBytes(Charset.forName("UTF-8")))) : null);

    /* renamed from: a */
    private FilterDataRepository f8a;

    public Blocker(FilterDataRepository bVar) {
        this.f8a = bVar;
        bVar.getClass();
        CompletableFuture.m995n(new RunnableC0002d(bVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void mo9f(String str) {
        this.f8a.mo52c(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void mo10h(String str) {
        this.f8a.mo53d(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void mo11j(List list) {
        if (this.f8a.mo57h(list)) {
            this.f8a.mo56g();
        }
    }

    /* renamed from: k */
    public static Blocker m3k(Context context, String str, String str2, boolean z) {
        return new Blocker(new DefaultFilterDataRepository(new InnerFilterDataSource(context), new CustomFilterDataSource(str), new FilterFilesDataSource(str2), z));
    }

    /* renamed from: a */
    public void mo5a(String str) {
        if (str != null && !str.isEmpty() && str.charAt(0) != '!') {
            CompletableFuture.m995n(new RunnableC0000b(this, str));
        }
    }

    /* renamed from: b */
    public boolean mo6b(String str) {
        return this.f8a.mo51a(str) != null;
    }

    /* renamed from: c */
    public String mo7c(String str) {
        String i = this.f8a.mo58i(str);
        if (i == null || i.isEmpty()) {
            return null;
        }
        return i + "{display: none !important}";
    }

    /* renamed from: d */
    public List<FilterSubscription> mo8d() {
        return this.f8a.mo60k();
    }

    /* renamed from: l */
    public void mo12l(String str) {
        if (str != null && !str.isEmpty() && str.charAt(0) != '!') {
            CompletableFuture.m995n(new lambda(this, str));
        }
    }

    /* renamed from: m */
    public void mo13m(List<FilterSubscription> list) {
        CompletableFuture.m995n(new RunnableC0001c(this, list));
    }

    /* renamed from: n */
    public void mo14n(boolean z) {
        if (this.f8a.mo55f(z)) {
            FilterDataRepository bVar = this.f8a;
            bVar.getClass();
            CompletableFuture.m995n(new RunnableC0002d(bVar));
        }
    }

    /* renamed from: o */
    public boolean mo15o(WebResourceRequest webResourceRequest, String str) {
        RequestFilter e = this.f8a.mo54e(webResourceRequest, str);
        return e != null && !e.mo44f();
    }

    /* renamed from: p */
    public boolean mo16p(String str, String str2) {
        RequestFilter j = this.f8a.mo59j(str, str2);
        return j != null && !j.mo44f();
    }
}
