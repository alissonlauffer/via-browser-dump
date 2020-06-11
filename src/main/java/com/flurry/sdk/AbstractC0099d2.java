package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.flurry.sdk.d2 */
public abstract class AbstractC0099d2 {

    /* renamed from: a */
    protected final String f302a;

    /* renamed from: b */
    protected String f303b = "defaultDataKey_";

    /* renamed from: c */
    Set<String> f304c = new HashSet();

    /* renamed from: d */
    C0136f2 f305d;

    /* renamed from: e */
    private AbstractC0192m1<C0298w0> f306e = new C0100a();

    /* renamed from: com.flurry.sdk.d2$a */
    class C0100a implements AbstractC0192m1<C0298w0> {
        C0100a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0298w0 w0Var) {
            C0298w0 w0Var2 = w0Var;
            String str = AbstractC0099d2.this.f302a;
            C0260s1.m686c(4, str, "onNetworkStateChanged : isNetworkEnable = " + w0Var2.f825b);
            if (w0Var2.f825b) {
                AbstractC0099d2.this.mo172i();
            }
        }
    }

    /* renamed from: com.flurry.sdk.d2$b */
    class C0101b extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ String f308d;

        C0101b(String str) {
            this.f308d = str;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0099d2.this.f305d = new C0136f2(this.f308d);
        }
    }

    /* renamed from: com.flurry.sdk.d2$c */
    class C0102c extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ byte[] f310d;

        /* renamed from: e */
        final /* synthetic */ String f311e;

        /* renamed from: f */
        final /* synthetic */ String f312f;

        C0102c(byte[] bArr, String str, String str2) {
            this.f310d = bArr;
            this.f311e = str;
            this.f312f = str2;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0099d2.this.mo171h(this.f310d, this.f311e, this.f312f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.d2$d */
    public class C0103d extends AbstractRunnableC0040b3 {
        C0103d() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0099d2.this.mo170g();
        }
    }

    /* renamed from: com.flurry.sdk.d2$e */
    class C0104e extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ String f315d;

        /* renamed from: e */
        final /* synthetic */ String f316e;

        C0104e(String str, String str2) {
            this.f315d = str;
            this.f316e = str2;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            if (!AbstractC0099d2.this.f305d.mo205f(this.f315d, this.f316e)) {
                String str = AbstractC0099d2.this.f302a;
                C0260s1.m686c(6, str, "Internal error. Block wasn't deleted with id = " + this.f315d);
            }
            if (!AbstractC0099d2.this.f304c.remove(this.f315d)) {
                String str2 = AbstractC0099d2.this.f302a;
                C0260s1.m686c(6, str2, "Internal error. Block with id = " + this.f315d + " was not in progress state");
            }
        }
    }

    /* renamed from: com.flurry.sdk.d2$f */
    public class C0105f extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ String f318d;

        public C0105f(String str) {
            this.f318d = str;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            if (!AbstractC0099d2.this.f304c.remove(this.f318d)) {
                String str = AbstractC0099d2.this.f302a;
                C0260s1.m686c(6, str, "Internal error. Block with id = " + this.f318d + " was not in progress state");
            }
        }
    }

    public AbstractC0099d2(String str, String str2) {
        this.f302a = str2;
        C0199n1.m528a().mo271e("com.flurry.android.sdk.NetworkStateEvent", this.f306e);
        C0118e1.m386a().mo191g(new C0101b(str));
    }

    /* renamed from: d */
    private boolean m349d() {
        return m350j() <= 5;
    }

    /* renamed from: j */
    private int m350j() {
        return this.f304c.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo166a(String str, String str2, int i) {
        C0118e1.m386a().mo191g(new C0104e(str, str2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo167c(byte[] bArr, String str, String str2);

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo168e() {
        C0118e1.m386a().mo191g(new C0103d());
    }

    /* renamed from: f */
    public final void mo169f(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            C0260s1.m686c(6, this.f302a, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        C0118e1.m386a().mo191g(new C0102c(bArr, str, str2));
        mo168e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final void mo170g() {
        if (!C0054by.m254a().f176b) {
            C0260s1.m686c(5, this.f302a, "Reports were not sent! No Internet connection!");
            return;
        }
        ArrayList<String> arrayList = new ArrayList(this.f305d.f425b.keySet());
        if (arrayList.isEmpty()) {
            C0260s1.m686c(4, this.f302a, "No more reports to send.");
            return;
        }
        for (String str : arrayList) {
            if (m349d()) {
                List<String> a = this.f305d.mo203a(str);
                String str2 = this.f302a;
                C0260s1.m686c(4, str2, "Number of not sent blocks = " + a.size());
                for (String str3 : a) {
                    if (!this.f304c.contains(str3)) {
                        if (!m349d()) {
                            break;
                        }
                        C0119e2 a2 = C0119e2.m395b(str3).mo252a();
                        if (a2 == null) {
                            C0260s1.m686c(6, this.f302a, "Internal ERROR! Cannot read!");
                            this.f305d.mo205f(str3, str);
                        } else {
                            byte[] bArr = a2.f368b;
                            if (bArr == null || bArr.length == 0) {
                                C0260s1.m686c(6, this.f302a, "Internal ERROR! Report is empty!");
                                this.f305d.mo205f(str3, str);
                            } else {
                                C0260s1.m686c(5, this.f302a, "Reading block info ".concat(String.valueOf(str3)));
                                this.f304c.add(str3);
                                mo167c(bArr, str3, str);
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final void mo171h(byte[] bArr, String str, String str2) {
        String str3 = this.f303b + str + "_" + str2;
        C0119e2 e2Var = new C0119e2(bArr);
        String str4 = e2Var.f367a;
        C0119e2.m395b(str4).mo253b(e2Var);
        C0260s1.m686c(5, this.f302a, "Saving Block File " + str4 + " at " + C0118e1.m386a().f361a.getFileStreamPath(C0119e2.m394a(str4)));
        this.f305d.mo204c(e2Var, str3);
    }

    /* renamed from: i */
    public final void mo172i() {
        mo168e();
    }
}
