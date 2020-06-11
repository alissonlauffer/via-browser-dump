package com.flurry.sdk;

import android.content.Context;
import android.widget.Toast;
import com.flurry.sdk.AbstractC0099d2;
import com.flurry.sdk.C0108dk;
import com.flurry.sdk.C0275u2;
import com.flurry.sdk.C0315y1;

/* renamed from: com.flurry.sdk.l0 */
public class C0180l0 extends AbstractC0099d2 implements C0275u2.AbstractC0276a {

    /* renamed from: h */
    private static final String f531h = "l0";

    /* renamed from: f */
    private String f532f;

    /* renamed from: g */
    private boolean f533g;

    /* renamed from: com.flurry.sdk.l0$a */
    class C0181a implements C0315y1.AbstractC0317b<byte[], Void> {

        /* renamed from: a */
        final /* synthetic */ String f534a;

        /* renamed from: b */
        final /* synthetic */ String f535b;

        /* renamed from: com.flurry.sdk.l0$a$a */
        class RunnableC0182a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f537a;

            RunnableC0182a(C0181a aVar, int i) {
                this.f537a = i;
            }

            public final void run() {
                Context context = C0118e1.m386a().f361a;
                Toast.makeText(context, "SD HTTP Response Code: " + this.f537a, 0).show();
            }
        }

        C0181a(String str, String str2) {
            this.f534a = str;
            this.f535b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.C0315y1.AbstractC0317b
        /* renamed from: a */
        public final /* synthetic */ void mo165a(C0315y1<byte[], Void> y1Var, Void r4) {
            int i = y1Var.f337u;
            if (i > 0) {
                C0260s1.m701r(C0180l0.f531h, "Analytics report sent.");
                String str = C0180l0.f531h;
                C0260s1.m686c(3, str, "FlurryDataSender: report " + this.f534a + " sent. HTTP response: " + i);
                if (C0260s1.m695l() <= 3 && C0260s1.m700q()) {
                    C0118e1.m386a().mo189d(new RunnableC0182a(this, i));
                }
                C0180l0.this.mo166a(this.f534a, this.f535b, i);
                C0180l0.this.mo172i();
                return;
            }
            C0180l0.m509m(C0180l0.this, this.f534a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.l0$b */
    public class C0183b extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ int f538d;

        C0183b(C0180l0 l0Var, int i) {
            this.f538d = i;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            if (this.f538d == 200) {
                C0329z3.m900e();
                C0204o0 j = C0329z3.m903j();
                if (j != null) {
                    j.f614n = true;
                }
            }
        }
    }

    public C0180l0() {
        this((byte) 0);
    }

    /* renamed from: m */
    static /* synthetic */ void m509m(C0180l0 l0Var, String str) {
        C0118e1.m386a().mo191g(new AbstractC0099d2.C0105f(str));
    }

    /* renamed from: n */
    private void m510n(String str) {
        if (str != null && !str.endsWith(".do")) {
            C0260s1.m686c(5, f531h, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.f532f = str;
    }

    @Override // com.flurry.sdk.AbstractC0099d2
    /* renamed from: a */
    public final void mo166a(String str, String str2, int i) {
        C0118e1.m386a().mo191g(new C0183b(this, i));
        super.mo166a(str, str2, i);
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        str.hashCode();
        if (str.equals("UseHttps")) {
            this.f533g = ((Boolean) obj).booleanValue();
            String str2 = f531h;
            C0260s1.m686c(4, str2, "onSettingUpdate, UseHttps = " + this.f533g);
        } else if (!str.equals("ReportUrl")) {
            C0260s1.m686c(6, f531h, "onSettingUpdate internal error!");
        } else {
            String str3 = (String) obj;
            m510n(str3);
            C0260s1.m686c(4, f531h, "onSettingUpdate, ReportUrl = ".concat(String.valueOf(str3)));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flurry.sdk.AbstractC0099d2
    /* renamed from: c */
    public final void mo167c(byte[] bArr, String str, String str2) {
        String str3 = this.f532f;
        if (str3 == null) {
            str3 = this.f533g ? "https://data.flurry.com/aap.do" : "http://data.flurry.com/aap.do";
        }
        String l = Long.toString(System.currentTimeMillis());
        String str4 = f531h;
        C0260s1.m686c(4, str4, "FlurryDataSender: id = " + str + " to " + str3 + " at " + l);
        C0315y1 y1Var = new C0315y1();
        y1Var.f324h = str3;
        y1Var.f226d = 100000;
        y1Var.f325i = C0108dk.EnumC0109a.kPost;
        y1Var.mo174e("Content-Type", "application/octet-stream");
        y1Var.mo174e("X-Flurry-Sdk-Clock", l);
        y1Var.f869D = new C0158h2();
        y1Var.f867B = bArr;
        y1Var.f866A = new C0181a(str, str2);
        C0098d1.m348j().mo309f(this, y1Var);
    }

    private C0180l0(byte b) {
        super("Analytics", C0180l0.class.getSimpleName());
        this.f303b = "AnalyticsData_";
        C0266t2 e = C0266t2.m703e();
        this.f533g = ((Boolean) e.mo341a("UseHttps")).booleanValue();
        e.mo342b("UseHttps", this);
        String str = f531h;
        C0260s1.m686c(4, str, "initSettings, UseHttps = " + this.f533g);
        String str2 = (String) e.mo341a("ReportUrl");
        e.mo342b("ReportUrl", this);
        m510n(str2);
        C0260s1.m686c(4, str, "initSettings, ReportUrl = ".concat(String.valueOf(str2)));
        mo168e();
    }
}
