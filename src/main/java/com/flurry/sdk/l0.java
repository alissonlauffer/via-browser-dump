package com.flurry.sdk;

import android.content.Context;
import android.widget.Toast;
import com.flurry.sdk.d2;
import com.flurry.sdk.dk;
import com.flurry.sdk.u2;
import com.flurry.sdk.y1;

public class l0 extends d2 implements u2.a {
    /* access modifiers changed from: private */
    public static final String h = "l0";
    private String f;
    private boolean g;

    class a implements y1.b<byte[], Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f153a;
        final /* synthetic */ String b;

        /* renamed from: com.flurry.sdk.l0$a$a  reason: collision with other inner class name */
        class C0017a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f154a;

            C0017a(a aVar, int i) {
                this.f154a = i;
            }

            public final void run() {
                Context context = e1.a().f110a;
                Toast.makeText(context, "SD HTTP Response Code: " + this.f154a, 0).show();
            }
        }

        a(String str, String str2) {
            this.f153a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.y1.b
        public final /* synthetic */ void a(y1<byte[], Void> y1Var, Void voidR) {
            int i = ((dk) y1Var).u;
            if (i > 0) {
                s1.e(l0.h, "Analytics report sent.");
                String d = l0.h;
                s1.a(3, d, "FlurryDataSender: report " + this.f153a + " sent. HTTP response: " + i);
                if (s1.c() <= 3 && s1.d()) {
                    e1.a().a(new C0017a(this, i));
                }
                l0.this.a(this.f153a, this.b, i);
                l0.this.c();
                return;
            }
            e1.a().b(new d2.f(this.f153a));
        }
    }

    class b extends b3 {
        final /* synthetic */ int d;

        b(l0 l0Var, int i) {
            this.d = i;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            if (this.d == 200) {
                z3.a();
                o0 b = z3.b();
                if (b != null) {
                    b.n = true;
                }
            }
        }
    }

    public l0() {
        this((byte) 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
     arg types: [java.lang.String, com.flurry.sdk.l0]
     candidates:
      com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
      com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
    private l0(byte b2) {
        super("Analytics", l0.class.getSimpleName());
        ((d2) this).b = "AnalyticsData_";
        t2 a2 = t2.a();
        this.g = ((Boolean) a2.a("UseHttps")).booleanValue();
        a2.a("UseHttps", (u2.a) this);
        String str = h;
        s1.a(4, str, "initSettings, UseHttps = " + this.g);
        String str2 = (String) a2.a("ReportUrl");
        a2.a("ReportUrl", (u2.a) this);
        a(str2);
        s1.a(4, h, "initSettings, ReportUrl = ".concat(String.valueOf(str2)));
        a();
    }

    private void a(String str) {
        if (str != null && !str.endsWith(".do")) {
            s1.a(5, h, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.f = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -239660092) {
            if (hashCode == 1650629499 && str.equals("ReportUrl")) {
                c = 1;
                if (c == 0) {
                    this.g = ((Boolean) obj).booleanValue();
                    String str2 = h;
                    s1.a(4, str2, "onSettingUpdate, UseHttps = " + this.g);
                    return;
                } else if (c != 1) {
                    s1.a(6, h, "onSettingUpdate internal error!");
                    return;
                } else {
                    String str3 = (String) obj;
                    a(str3);
                    s1.a(4, h, "onSettingUpdate, ReportUrl = ".concat(String.valueOf(str3)));
                    return;
                }
            }
        } else if (str.equals("UseHttps")) {
            c = 0;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    @Override // com.flurry.sdk.d2
    public final void a(String str, String str2, int i) {
        e1.a().b(new b(this, i));
        super.a(str, str2, i);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [byte[], RequestObjectType] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.flurry.sdk.d2
    public final void a(byte[] r7, String str, String str2) {
        String str3 = this.f;
        if (str3 == null) {
            str3 = this.g ? "https://data.flurry.com/aap.do" : "http://data.flurry.com/aap.do";
        }
        String l = Long.toString(System.currentTimeMillis());
        String str4 = h;
        s1.a(4, str4, "FlurryDataSender: id = " + str + " to " + str3 + " at " + l);
        y1 y1Var = new y1();
        ((dk) y1Var).h = str3;
        ((c3) y1Var).d = 100000;
        ((dk) y1Var).i = dk.a.kPost;
        y1Var.a("Content-Type", "application/octet-stream");
        y1Var.a("X-Flurry-Sdk-Clock", l);
        y1Var.D = new h2();
        y1Var.B = r7;
        y1Var.A = new a(str, str2);
        d1.a().a(this, y1Var);
    }
}
