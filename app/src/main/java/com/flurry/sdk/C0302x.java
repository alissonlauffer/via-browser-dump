package com.flurry.sdk;

import com.flurry.sdk.C0108dk;
import com.flurry.sdk.C0310y;
import com.flurry.sdk.C0315y1;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.x */
public class C0302x extends AbstractC0066c2<C0310y> {

    /* renamed from: j */
    private static final String f833j = "x";

    /* renamed from: k */
    public static long f834k;

    /* renamed from: com.flurry.sdk.x$a */
    class C0303a implements AbstractC0201n2<List<C0310y>> {
        C0303a(C0302x xVar) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0310y>> mo100a(int i) {
            return new C0175k2(new C0310y.C0311a());
        }
    }

    /* renamed from: com.flurry.sdk.x$b */
    class C0304b implements C0315y1.AbstractC0317b<byte[], String> {

        /* renamed from: a */
        final /* synthetic */ C0310y f835a;

        /* renamed from: b */
        final /* synthetic */ C0321z f836b;

        C0304b(C0310y yVar, C0321z zVar) {
            this.f835a = yVar;
            this.f836b = zVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.C0315y1.AbstractC0317b
        /* renamed from: a */
        public final /* synthetic */ void mo165a(C0315y1<byte[], String> y1Var, String str) {
            String str2 = str;
            C0310y yVar = this.f835a;
            String str3 = yVar.f859r;
            C0033b0 b0Var = yVar.f854m;
            String str4 = b0Var.f115g;
            EnumC0043bd bdVar = b0Var.f112d;
            C0260s1.m686c(3, C0302x.f833j, "Pulse report to " + str3 + " for " + str4 + ", HTTP status code is: " + y1Var.f337u);
            int i = y1Var.f337u;
            C0321z zVar = this.f836b;
            int i2 = (int) y1Var.f335s;
            if (i2 >= 0) {
                zVar.f888k += (long) i2;
            } else if (zVar.f888k <= 0) {
                zVar.f888k = 0;
            }
            zVar.f882e = i;
            if (!y1Var.mo175f()) {
                Exception exc = y1Var.f336t;
                boolean z = true;
                boolean z2 = exc != null && (exc instanceof SocketTimeoutException);
                if (!y1Var.f341y && !z2) {
                    z = false;
                }
                if (z) {
                    if (y1Var.mo176g()) {
                        C0260s1.m686c(3, C0302x.f833j, "Timeout occurred when trying to connect to: " + str3 + ". Exception: " + y1Var.f336t.getMessage());
                    } else {
                        C0260s1.m686c(3, C0302x.f833j, "Manually managed http request timeout occurred for: ".concat(String.valueOf(str3)));
                    }
                    C0302x.m818o(C0302x.this, this.f836b, this.f835a);
                } else {
                    C0260s1.m686c(3, C0302x.f833j, "Error occurred when trying to connect to: " + str3 + ". Exception: " + exc.getMessage());
                    C0302x.m820q(C0302x.this, this.f836b, this.f835a, str2);
                }
                C0305c.m831c(str3, str4, bdVar);
            } else if (i >= 200 && i < 300) {
                C0302x.m822s(C0302x.this, this.f836b, this.f835a);
                C0305c.m830b(str3, str4, bdVar);
            } else if (i < 300 || i >= 400) {
                C0260s1.m686c(3, C0302x.f833j, str4 + " report failed sending to : " + str3);
                C0302x.m820q(C0302x.this, this.f836b, this.f835a, str2);
                C0305c.m831c(str3, str4, bdVar);
            } else {
                C0302x.m819p(C0302x.this, this.f836b, this.f835a, y1Var);
            }
        }
    }

    /* renamed from: com.flurry.sdk.x$c */
    static class C0305c {

        /* renamed from: a */
        private static HashMap<EnumC0043bd, String> f838a;

        static {
            HashMap<EnumC0043bd, String> hashMap = new HashMap<>();
            f838a = hashMap;
            hashMap.put(EnumC0043bd.INSTALL, "Install");
            f838a.put(EnumC0043bd.SESSION_START, "Session Start");
            f838a.put(EnumC0043bd.SESSION_END, "Session End");
            f838a.put(EnumC0043bd.APPLICATION_EVENT, "App Event");
        }

        /* renamed from: a */
        private static String m829a(EnumC0043bd bdVar) {
            String str = f838a.get(bdVar);
            return str == null ? "Unknown" : str;
        }

        /* renamed from: b */
        static void m830b(String str, String str2, EnumC0043bd bdVar) {
            if (!C0329z3.m900e().f903e) {
                C0260s1.m686c(4, C0302x.f833j, "Not yahoo app. Don't log event Flurry.PulseSuccess");
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("fl.Partner", str);
            hashMap.put("fl.Event", str2);
            hashMap.put("fl.Trigger", m829a(bdVar));
            try {
                C0329z3.m900e().mo375c("Flurry.PulseSuccess", hashMap, false);
            } catch (Throwable th) {
                C0260s1.m689f(C0302x.f833j, "Failed to log event: Flurry.PulseSuccess", th);
            }
        }

        /* renamed from: c */
        static void m831c(String str, String str2, EnumC0043bd bdVar) {
            if (!C0329z3.m900e().f903e) {
                C0260s1.m686c(4, C0302x.f833j, "Not yahoo app. Don't log event Flurry.PulseFail");
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("fl.Partner", str);
            hashMap.put("fl.Event", str2);
            hashMap.put("fl.Trigger", m829a(bdVar));
            try {
                C0329z3.m900e().mo375c("Flurry.PulseFail", hashMap, false);
            } catch (Throwable th) {
                C0260s1.m689f(C0302x.f833j, "Failed to log event: Flurry.PulseFail", th);
            }
        }
    }

    public C0302x() {
        AbstractC0066c2.f210i = 30000;
        this.f215e = 30000;
    }

    /* renamed from: o */
    static /* synthetic */ void m818o(C0302x xVar, C0321z zVar, C0310y yVar) {
        C0014a0.m169n().mo96h(zVar);
        xVar.mo145j(yVar);
    }

    /* renamed from: p */
    static /* synthetic */ void m819p(C0302x xVar, C0321z zVar, C0310y yVar, C0315y1 y1Var) {
        List<String> d = y1Var.mo173d("Location");
        String a = (d == null || d.size() <= 0) ? null : C0106d3.m364a(d.get(0), yVar.f128d);
        boolean e = C0014a0.m169n().mo94e(zVar, a);
        if (e) {
            C0260s1.m686c(3, f833j, "Received redirect url. Retrying: ".concat(String.valueOf(a)));
        } else {
            C0260s1.m686c(3, f833j, "Received redirect url. Retrying: false");
        }
        if (e) {
            yVar.f129e = a;
            y1Var.f324h = a;
            C0162i1<String, String> i1Var = y1Var.f322f;
            if (i1Var != null && i1Var.f493a.containsKey("Location")) {
                y1Var.f322f.mo235f("Location");
            }
            C0098d1.m348j().mo309f(xVar, y1Var);
            return;
        }
        xVar.mo145j(yVar);
    }

    /* renamed from: q */
    static /* synthetic */ void m820q(C0302x xVar, C0321z zVar, C0310y yVar, String str) {
        boolean j = C0014a0.m169n().mo98j(zVar, str);
        C0260s1.m686c(3, f833j, "Failed report retrying: ".concat(String.valueOf(j)));
        if (j) {
            xVar.mo146m(yVar);
        } else {
            xVar.mo145j(yVar);
        }
    }

    /* renamed from: s */
    static /* synthetic */ void m822s(C0302x xVar, C0321z zVar, C0310y yVar) {
        String str = f833j;
        C0260s1.m686c(3, str, yVar.f854m.f115g + " report sent successfully to : " + yVar.f859r);
        C0014a0.m169n().mo92b(zVar);
        xVar.mo145j(yVar);
    }

    @Override // com.flurry.sdk.AbstractC0066c2
    /* renamed from: a */
    public final C0174k1<List<C0310y>> mo140a() {
        return new C0174k1<>(C0118e1.m386a().f361a.getFileStreamPath(".yflurryanpulsecallbackreporter"), ".yflurryanpulsecallbackreporter", 2, new C0303a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.b2] */
    @Override // com.flurry.sdk.AbstractC0066c2
    /* renamed from: b */
    public final /* synthetic */ void mo141b(C0310y yVar) {
        C0310y yVar2 = yVar;
        String str = f833j;
        C0260s1.m686c(3, str, "Sending next pulse report to " + yVar2.f859r + " at: " + yVar2.f129e);
        C0235q0.m624b();
        long e = C0235q0.m627e();
        if (e == 0) {
            e = f834k;
        }
        C0235q0.m624b();
        long h = C0235q0.m630h();
        if (h == 0) {
            h = System.currentTimeMillis() - e;
        }
        C0321z zVar = new C0321z(yVar2, e, h, yVar2.f127c);
        C0315y1 y1Var = new C0315y1();
        y1Var.f324h = yVar2.f129e;
        y1Var.f226d = 100000;
        if (yVar2.f851j.equals(EnumC0042bc.POST)) {
            y1Var.f869D = new C0158h2();
            String str2 = yVar2.f858q;
            if (str2 != null) {
                y1Var.f867B = (RequestObjectType) str2.getBytes();
            }
            y1Var.f325i = C0108dk.EnumC0109a.kPost;
        } else {
            y1Var.f325i = C0108dk.EnumC0109a.kGet;
        }
        int i = yVar2.f856o;
        y1Var.f326j = i * 1000;
        int i2 = yVar2.f857p;
        y1Var.f327k = i2 * 1000;
        y1Var.f333q = true;
        y1Var.f338v = true;
        y1Var.f339w = (i + i2) * 1000;
        Map<String, String> map = yVar2.f852k;
        if (map != null) {
            for (String str3 : map.keySet()) {
                y1Var.mo174e(str3, map.get(str3));
            }
        }
        y1Var.f328l = false;
        y1Var.f866A = new C0304b(yVar2, zVar);
        C0098d1.m348j().mo309f(this, y1Var);
    }

    @Override // com.flurry.sdk.AbstractC0066c2
    /* renamed from: d */
    public final synchronized void mo142d(List<C0310y> list) {
        C0014a0.m169n();
        List<C0033b0> o = C0014a0.m170o();
        if (o != null) {
            if (o.size() != 0) {
                String str = f833j;
                C0260s1.m686c(3, str, "Restoring " + o.size() + " from report queue.");
                for (C0033b0 b0Var : o) {
                    C0014a0.m169n().mo97i(b0Var);
                }
                C0014a0.m169n();
                for (C0033b0 b0Var2 : C0014a0.m166k()) {
                    for (C0310y yVar : b0Var2.mo113d()) {
                        if (!yVar.f860s) {
                            String str2 = f833j;
                            C0260s1.m686c(3, str2, "Callback for " + yVar.f854m.f115g + " to " + yVar.f859r + " not completed.  Adding to reporter queue.");
                            list.add(yVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.flurry.sdk.AbstractC0066c2
    /* renamed from: h */
    public final synchronized void mo144h(List<C0310y> list) {
        C0014a0.m169n().mo95f();
    }
}
