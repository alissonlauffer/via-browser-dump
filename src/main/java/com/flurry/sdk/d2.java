package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class d2 {

    /* renamed from: a  reason: collision with root package name */
    protected final String f103a;
    protected String b = "defaultDataKey_";
    Set<String> c = new HashSet();
    f2 d;
    private m1<w0> e = new a();

    class a implements m1<w0> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(w0 w0Var) {
            w0 w0Var2 = w0Var;
            String str = d2.this.f103a;
            s1.a(4, str, "onNetworkStateChanged : isNetworkEnable = " + w0Var2.b);
            if (w0Var2.b) {
                d2.this.c();
            }
        }
    }

    class b extends b3 {
        final /* synthetic */ String d;

        b(String str) {
            this.d = str;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            d2.this.d = new f2(this.d);
        }
    }

    class c extends b3 {
        final /* synthetic */ byte[] d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        c(byte[] bArr, String str, String str2) {
            this.d = bArr;
            this.e = str;
            this.f = str2;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            d2.this.c(this.d, this.e, this.f);
        }
    }

    class d extends b3 {
        d() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            d2.this.b();
        }
    }

    class e extends b3 {
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        e(String str, String str2) {
            this.d = str;
            this.e = str2;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            if (!d2.this.d.a(this.d, this.e)) {
                String str = d2.this.f103a;
                s1.a(6, str, "Internal error. Block wasn't deleted with id = " + this.d);
            }
            if (!d2.this.c.remove(this.d)) {
                String str2 = d2.this.f103a;
                s1.a(6, str2, "Internal error. Block with id = " + this.d + " was not in progress state");
            }
        }
    }

    public class f extends b3 {
        final /* synthetic */ String d;

        public f(String str) {
            this.d = str;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            if (!d2.this.c.remove(this.d)) {
                String str = d2.this.f103a;
                s1.a(6, str, "Internal error. Block with id = " + this.d + " was not in progress state");
            }
        }
    }

    public d2(String str, String str2) {
        this.f103a = str2;
        n1.a().a("com.flurry.android.sdk.NetworkStateEvent", this.e);
        e1.a().b(new b(str));
    }

    private boolean d() {
        return e() <= 5;
    }

    private int e() {
        return this.c.size();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        e1.a().b(new d());
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, String str, String str2);

    public final void b(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            s1.a(6, this.f103a, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        e1.a().b(new c(bArr, str, str2));
        a();
    }

    public final void c() {
        a();
    }

    /* access modifiers changed from: protected */
    public final void c(byte[] bArr, String str, String str2) {
        String str3 = this.b + str + "_" + str2;
        e2 e2Var = new e2(bArr);
        String str4 = e2Var.f111a;
        e2.b(str4).a(e2Var);
        s1.a(5, this.f103a, "Saving Block File " + str4 + " at " + e1.a().f110a.getFileStreamPath(e2.a(str4)));
        this.d.a(e2Var, str3);
    }

    /* access modifiers changed from: protected */
    public void a(String str, String str2, int i) {
        e1.a().b(new e(str, str2));
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (!by.b().b) {
            s1.a(5, this.f103a, "Reports were not sent! No Internet connection!");
            return;
        }
        ArrayList<String> arrayList = new ArrayList(this.d.b.keySet());
        if (arrayList.isEmpty()) {
            s1.a(4, this.f103a, "No more reports to send.");
            return;
        }
        for (String str : arrayList) {
            if (d()) {
                List<String> a2 = this.d.a(str);
                String str2 = this.f103a;
                s1.a(4, str2, "Number of not sent blocks = " + a2.size());
                for (String str3 : a2) {
                    if (!this.c.contains(str3)) {
                        if (!d()) {
                            break;
                        }
                        e2 a3 = e2.b(str3).a();
                        if (a3 == null) {
                            s1.a(6, this.f103a, "Internal ERROR! Cannot read!");
                            this.d.a(str3, str);
                        } else {
                            byte[] bArr = a3.b;
                            if (bArr == null || bArr.length == 0) {
                                s1.a(6, this.f103a, "Internal ERROR! Report is empty!");
                                this.d.a(str3, str);
                            } else {
                                s1.a(5, this.f103a, "Reading block info ".concat(String.valueOf(str3)));
                                this.c.add(str3);
                                a(bArr, str3, str);
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
    }
}
