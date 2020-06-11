package com.flurry.sdk;

import com.flurry.sdk.dk;
import com.flurry.sdk.y;
import com.flurry.sdk.y1;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class x extends c2<y> {
    /* access modifiers changed from: private */
    public static final String j = "x";
    public static long k;

    class a implements n2<List<y>> {
        a(x xVar) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<y>> a(int i) {
            return new k2(new y.a());
        }
    }

    class b implements y1.b<byte[], String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f214a;
        final /* synthetic */ z b;

        b(y yVar, z zVar) {
            this.f214a = yVar;
            this.b = zVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.y1.b
        public final /* synthetic */ void a(y1<byte[], String> y1Var, String str) {
            String str2 = str;
            y yVar = this.f214a;
            String str3 = yVar.r;
            b0 b0Var = yVar.m;
            String str4 = b0Var.g;
            bd bdVar = b0Var.d;
            s1.a(3, x.j, "Pulse report to " + str3 + " for " + str4 + ", HTTP status code is: " + ((dk) y1Var).u);
            int i = ((dk) y1Var).u;
            z zVar = this.b;
            int i2 = (int) ((dk) y1Var).s;
            if (i2 >= 0) {
                zVar.k += (long) i2;
            } else if (zVar.k <= 0) {
                zVar.k = 0;
            }
            this.b.e = i;
            if (!y1Var.c()) {
                Exception exc = ((dk) y1Var).t;
                boolean z = true;
                boolean z2 = exc != null && (exc instanceof SocketTimeoutException);
                if (!((dk) y1Var).y && !z2) {
                    z = false;
                }
                if (z) {
                    if (y1Var.d()) {
                        s1.a(3, x.j, "Timeout occurred when trying to connect to: " + str3 + ". Exception: " + ((dk) y1Var).t.getMessage());
                    } else {
                        s1.a(3, x.j, "Manually managed http request timeout occurred for: ".concat(String.valueOf(str3)));
                    }
                    x.a(x.this, this.b, this.f214a);
                } else {
                    s1.a(3, x.j, "Error occurred when trying to connect to: " + str3 + ". Exception: " + exc.getMessage());
                    x.a(x.this, this.b, this.f214a, str2);
                }
                c.b(str3, str4, bdVar);
            } else if (i >= 200 && i < 300) {
                x.b(x.this, this.b, this.f214a);
                c.a(str3, str4, bdVar);
            } else if (i < 300 || i >= 400) {
                s1.a(3, x.j, str4 + " report failed sending to : " + str3);
                x.a(x.this, this.b, this.f214a, str2);
                c.b(str3, str4, bdVar);
            } else {
                x.a(x.this, this.b, this.f214a, y1Var);
            }
        }
    }

    public x() {
        c2.i = 30000;
        ((c2) this).e = 30000;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.b2] */
    @Override // com.flurry.sdk.c2
    public final /* synthetic */ void a(y yVar) {
        y yVar2 = yVar;
        String str = j;
        s1.a(3, str, "Sending next pulse report to " + yVar2.r + " at: " + ((b2) yVar2).e);
        q0.a();
        long c2 = q0.c();
        if (c2 == 0) {
            c2 = k;
        }
        q0.a();
        long f = q0.f();
        if (f == 0) {
            f = System.currentTimeMillis() - c2;
        }
        z zVar = new z(yVar2, c2, f, ((b2) yVar2).c);
        y1 y1Var = new y1();
        ((dk) y1Var).h = ((b2) yVar2).e;
        ((c3) y1Var).d = 100000;
        if (yVar2.j.equals(bc.POST)) {
            y1Var.D = new h2();
            String str2 = yVar2.q;
            if (str2 != null) {
                y1Var.B = str2.getBytes();
            }
            ((dk) y1Var).i = dk.a.kPost;
        } else {
            ((dk) y1Var).i = dk.a.kGet;
        }
        int i = yVar2.o;
        ((dk) y1Var).j = i * 1000;
        int i2 = yVar2.p;
        ((dk) y1Var).k = i2 * 1000;
        ((dk) y1Var).q = true;
        ((dk) y1Var).v = true;
        ((dk) y1Var).w = (i + i2) * 1000;
        Map<String, String> map = yVar2.k;
        if (map != null) {
            for (String str3 : map.keySet()) {
                y1Var.a(str3, map.get(str3));
            }
        }
        ((dk) y1Var).l = false;
        y1Var.A = new b(yVar2, zVar);
        d1.a().a(this, y1Var);
    }

    @Override // com.flurry.sdk.c2
    public final synchronized void b(List<y> list) {
        a0.c().a();
    }

    static /* synthetic */ void b(x xVar, z zVar, y yVar) {
        String str = j;
        s1.a(3, str, yVar.m.g + " report sent successfully to : " + yVar.r);
        a0.c().a(zVar);
        xVar.c(yVar);
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private static HashMap<bd, String> f215a;

        static {
            HashMap<bd, String> hashMap = new HashMap<>();
            f215a = hashMap;
            hashMap.put(bd.INSTALL, "Install");
            f215a.put(bd.SESSION_START, "Session Start");
            f215a.put(bd.SESSION_END, "Session End");
            f215a.put(bd.APPLICATION_EVENT, "App Event");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean):com.flurry.android.FlurryEventRecordStatus
         arg types: [java.lang.String, java.util.HashMap, int]
         candidates:
          com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):com.flurry.android.FlurryEventRecordStatus
          com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean):com.flurry.android.FlurryEventRecordStatus */
        static void a(String str, String str2, bd bdVar) {
            if (!z3.a().e) {
                s1.a(4, x.j, "Not yahoo app. Don't log event Flurry.PulseSuccess");
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("fl.Partner", str);
            hashMap.put("fl.Event", str2);
            hashMap.put("fl.Trigger", a(bdVar));
            try {
                z3.a().a("Flurry.PulseSuccess", (Map<String, String>) hashMap, false);
            } catch (Throwable th) {
                s1.a(x.j, "Failed to log event: Flurry.PulseSuccess", th);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean):com.flurry.android.FlurryEventRecordStatus
         arg types: [java.lang.String, java.util.HashMap, int]
         candidates:
          com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):com.flurry.android.FlurryEventRecordStatus
          com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean):com.flurry.android.FlurryEventRecordStatus */
        static void b(String str, String str2, bd bdVar) {
            if (!z3.a().e) {
                s1.a(4, x.j, "Not yahoo app. Don't log event Flurry.PulseFail");
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("fl.Partner", str);
            hashMap.put("fl.Event", str2);
            hashMap.put("fl.Trigger", a(bdVar));
            try {
                z3.a().a("Flurry.PulseFail", (Map<String, String>) hashMap, false);
            } catch (Throwable th) {
                s1.a(x.j, "Failed to log event: Flurry.PulseFail", th);
            }
        }

        private static String a(bd bdVar) {
            String str = f215a.get(bdVar);
            return str == null ? "Unknown" : str;
        }
    }

    @Override // com.flurry.sdk.c2
    public final k1<List<y>> a() {
        return new k1<>(e1.a().f110a.getFileStreamPath(".yflurryanpulsecallbackreporter"), ".yflurryanpulsecallbackreporter", 2, new a(this));
    }

    @Override // com.flurry.sdk.c2
    public final synchronized void a(List<y> list) {
        a0.c();
        List<b0> d = a0.d();
        if (d != null) {
            if (d.size() != 0) {
                String str = j;
                s1.a(3, str, "Restoring " + d.size() + " from report queue.");
                for (b0 b0Var : d) {
                    a0.c().b(b0Var);
                }
                a0.c();
                for (b0 b0Var2 : a0.b()) {
                    for (y yVar : b0Var2.a()) {
                        if (!yVar.s) {
                            String str2 = j;
                            s1.a(3, str2, "Callback for " + yVar.m.g + " to " + yVar.r + " not completed.  Adding to reporter queue.");
                            list.add(yVar);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(x xVar, z zVar, y yVar) {
        a0.c().b(zVar);
        xVar.c(yVar);
    }

    static /* synthetic */ void a(x xVar, z zVar, y yVar, String str) {
        boolean b2 = a0.c().b(zVar, str);
        s1.a(3, j, "Failed report retrying: ".concat(String.valueOf(b2)));
        if (b2) {
            xVar.d(yVar);
        } else {
            xVar.c(yVar);
        }
    }

    static /* synthetic */ void a(x xVar, z zVar, y yVar, y1 y1Var) {
        List<String> a2 = y1Var.a("Location");
        String a3 = (a2 == null || a2.size() <= 0) ? null : d3.a(a2.get(0), ((b2) yVar).d);
        boolean a4 = a0.c().a(zVar, a3);
        if (a4) {
            s1.a(3, j, "Received redirect url. Retrying: ".concat(String.valueOf(a3)));
        } else {
            s1.a(3, j, "Received redirect url. Retrying: false");
        }
        if (a4) {
            ((b2) yVar).e = a3;
            ((dk) y1Var).h = a3;
            i1<String, String> i1Var = ((dk) y1Var).f;
            if (i1Var != null && i1Var.f139a.containsKey("Location")) {
                ((dk) y1Var).f.b("Location");
            }
            d1.a().a(xVar, y1Var);
            return;
        }
        xVar.c(yVar);
    }
}
