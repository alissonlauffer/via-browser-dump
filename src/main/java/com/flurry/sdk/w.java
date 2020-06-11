package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.b0;
import com.flurry.sdk.dk;
import com.flurry.sdk.u;
import com.flurry.sdk.u2;
import com.flurry.sdk.y1;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class w implements u2.a {
    /* access modifiers changed from: private */
    public static final String u = "w";

    /* renamed from: a  reason: collision with root package name */
    private final w1<i> f206a = new w1<>("proton config request", new f0());
    /* access modifiers changed from: private */
    public final w1<j> b = new w1<>("proton config response", new g0());
    private final v c = new v();
    private final i1<String, n> d = new i1<>();
    private final List<b0> e = new ArrayList();
    private k1<u> f;
    private k1<List<b0>> g;
    private boolean h;
    private String i;
    private boolean j = true;
    private boolean k;
    /* access modifiers changed from: private */
    public long l = 10000;
    /* access modifiers changed from: private */
    public long m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public j o;
    /* access modifiers changed from: private */
    public boolean p;
    public final Runnable q = new c();
    public final m1<s0> r = new f();
    public final m1<t0> s = new g();
    public final m1<w0> t = new h();

    class a extends b3 {
        a() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            w.this.m();
        }
    }

    class b extends b3 {
        b() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            w.this.k();
        }
    }

    class c extends b3 {
        c() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            w.this.e();
        }
    }

    class d implements y1.b<byte[], byte[]> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f207a;
        final /* synthetic */ boolean b;

        class a extends b3 {
            final /* synthetic */ byte[] d;

            a(byte[] bArr) {
                this.d = bArr;
            }

            @Override // com.flurry.sdk.b3
            public final void a() {
                d dVar = d.this;
                w.this.a(dVar.f207a, dVar.b, this.d);
            }
        }

        d(long j, boolean z) {
            this.f207a = j;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.y1.b
        public final /* synthetic */ void a(y1<byte[], byte[]> y1Var, byte[] bArr) {
            j jVar;
            byte[] bArr2 = bArr;
            int i = ((dk) y1Var).u;
            s1.a(3, w.u, "Proton config request: HTTP status code is:".concat(String.valueOf(i)));
            if (i == 400 || i == 406 || i == 412 || i == 415) {
                long unused = w.this.l = 10000;
                return;
            }
            j jVar2 = null;
            if (y1Var.c() && bArr2 != null) {
                e1.a().b(new a(bArr2));
                try {
                    jVar = (j) w.this.b.a(bArr2);
                } catch (Exception e) {
                    s1.a(5, w.u, "Failed to decode proton config response: ".concat(String.valueOf(e)));
                    jVar = null;
                }
                if (w.b(jVar)) {
                    jVar2 = jVar;
                }
                if (jVar2 != null) {
                    long unused2 = w.this.l = 10000;
                    long unused3 = w.this.m = this.f207a;
                    boolean unused4 = w.this.n = this.b;
                    j unused5 = w.this.o = jVar2;
                    w.this.g();
                    if (!w.this.p) {
                        boolean unused6 = w.this.p = true;
                        w.this.b("flurry.session_start", (Map<String, String>) null);
                    }
                    w.this.h();
                }
            }
            if (jVar2 == null) {
                long j = w.this.l << 1;
                if (i == 429) {
                    List<String> a2 = y1Var.a("Retry-After");
                    if (!a2.isEmpty()) {
                        String str = a2.get(0);
                        s1.a(3, w.u, "Server returned retry time: ".concat(String.valueOf(str)));
                        try {
                            j = Long.parseLong(str) * 1000;
                        } catch (NumberFormatException unused7) {
                            s1.a(3, w.u, "Server returned nonsensical retry time");
                        }
                    }
                }
                long unused8 = w.this.l = j;
                s1.a(3, w.u, "Proton config request failed, backing off: " + w.this.l + "ms");
                e1.a().a(w.this.q, w.this.l);
            }
        }
    }

    class e extends b3 {
        e() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            w.this.e();
        }
    }

    class f implements m1<s0> {
        f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* bridge */ /* synthetic */ void a(s0 s0Var) {
            w.this.e();
        }
    }

    class g implements m1<t0> {
        g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* bridge */ /* synthetic */ void a(t0 t0Var) {
            w.this.e();
        }
    }

    class h implements m1<w0> {
        h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* bridge */ /* synthetic */ void a(w0 w0Var) {
            if (w0Var.b) {
                w.this.e();
            }
        }
    }

    class i implements n2<u> {
        i(w wVar) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<u> a(int i) {
            return new u.a();
        }
    }

    class j implements n2<List<b0>> {
        j(w wVar) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<b0>> a(int i) {
            return new k2(new b0.a());
        }
    }

    class k extends b3 {
        k() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            w.this.l();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
     arg types: [java.lang.String, com.flurry.sdk.w]
     candidates:
      com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
      com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
    public w() {
        t2 a2 = t2.a();
        this.h = ((Boolean) a2.a("ProtonEnabled")).booleanValue();
        a2.a("ProtonEnabled", (u2.a) this);
        String str = u;
        s1.a(4, str, "initSettings, protonEnabled = " + this.h);
        this.i = (String) a2.a("ProtonConfigUrl");
        a2.a("ProtonConfigUrl", (u2.a) this);
        String str2 = u;
        s1.a(4, str2, "initSettings, protonConfigUrl = " + this.i);
        this.j = ((Boolean) a2.a("analyticsEnabled")).booleanValue();
        a2.a("analyticsEnabled", (u2.a) this);
        String str3 = u;
        s1.a(4, str3, "initSettings, AnalyticsEnabled = " + this.j);
        n1.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", this.r);
        n1.a().a("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", this.s);
        n1.a().a("com.flurry.android.sdk.NetworkStateEvent", this.t);
        Context context = e1.a().f110a;
        this.f = new k1<>(context.getFileStreamPath(".yflurryprotonconfig." + Long.toString(z2.f(e1.a().e), 16)), ".yflurryprotonconfig.", 1, new i(this));
        this.g = new k1<>(context.getFileStreamPath(".yflurryprotonreport." + Long.toString(z2.f(e1.a().e), 16)), ".yflurryprotonreport.", 1, new j(this));
        e1.a().b(new k());
        e1.a().b(new a());
    }

    /* access modifiers changed from: private */
    public synchronized void l() {
        j jVar;
        u a2 = this.f.a();
        if (a2 != null) {
            j jVar2 = null;
            try {
                jVar = this.b.a(a2.c);
            } catch (Exception e2) {
                s1.a(5, u, "Failed to decode saved proton config response: ".concat(String.valueOf(e2)));
                this.f.b();
                jVar = null;
            }
            if (b(jVar)) {
                jVar2 = jVar;
            }
            if (jVar2 != null) {
                s1.a(4, u, "Loaded saved proton config response");
                this.l = 10000;
                this.m = a2.f197a;
                this.n = a2.b;
                this.o = jVar2;
                g();
            }
        }
        this.k = true;
        e1.a().b(new e());
    }

    /* access modifiers changed from: private */
    public synchronized void m() {
        s1.a(4, u, "Loading queued report data.");
        List<b0> a2 = this.g.a();
        if (a2 != null) {
            this.e.addAll(a2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [byte[], RequestObjectType] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        return;
     */
    public synchronized void e() {
        if (this.h) {
            z2.a();
            if (this.k) {
                if (bs.e().a()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z = !bs.e().d();
                    if (this.o != null) {
                        if (this.n != z) {
                            s1.a(3, u, "Limit ad tracking value has changed, purging");
                            this.o = null;
                        } else if (System.currentTimeMillis() < this.m + (this.o.f143a * 1000)) {
                            s1.a(3, u, "Cached Proton config valid, no need to refresh");
                            if (!this.p) {
                                this.p = true;
                                b("flurry.session_start", (Map<String, String>) null);
                            }
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j2 = this.m;
                            long j3 = this.o.b;
                            Long.signum(j3);
                            if (currentTimeMillis2 >= j2 + (j3 * 1000)) {
                                s1.a(3, u, "Cached Proton config expired, purging");
                                this.o = null;
                                this.d.a();
                            }
                        }
                    }
                    d1.a().a(this);
                    s1.a(3, u, "Requesting proton config");
                    ? f2 = f();
                    if (f2 != 0) {
                        y1 y1Var = new y1();
                        ((dk) y1Var).h = TextUtils.isEmpty(this.i) ? "https://proton.flurry.com/sdk/v1/config" : this.i;
                        ((c3) y1Var).d = 5000;
                        ((dk) y1Var).i = dk.a.kPost;
                        String num = Integer.toString(w1.b(f2));
                        y1Var.a("Content-Type", "application/x-flurry;version=2");
                        y1Var.a("Accept", "application/x-flurry;version=2");
                        y1Var.a("FM-Checksum", num);
                        y1Var.D = new h2();
                        y1Var.E = new h2();
                        y1Var.B = f2;
                        y1Var.A = new d(currentTimeMillis, z);
                        d1.a().a(this, y1Var);
                    }
                }
            }
        }
    }

    private byte[] f() {
        try {
            i iVar = new i();
            iVar.f137a = e1.a().e;
            iVar.b = w2.a(e1.a().f110a);
            iVar.c = w2.b(e1.a().f110a);
            iVar.d = f1.a();
            iVar.e = 3;
            y0.b();
            iVar.f = y0.c();
            iVar.g = !bs.e().d();
            m mVar = new m();
            iVar.h = mVar;
            mVar.f157a = new e();
            iVar.h.f157a.f108a = Build.MODEL;
            iVar.h.f157a.b = Build.BRAND;
            iVar.h.f157a.c = Build.ID;
            iVar.h.f157a.d = Build.DEVICE;
            iVar.h.f157a.e = Build.PRODUCT;
            iVar.h.f157a.f = Build.VERSION.RELEASE;
            iVar.i = new ArrayList();
            for (Map.Entry entry : Collections.unmodifiableMap(bs.e().b).entrySet()) {
                l lVar = new l();
                lVar.f152a = ((ca) entry.getKey()).d;
                if (((ca) entry.getKey()).e) {
                    lVar.b = new String((byte[]) entry.getValue());
                } else {
                    lVar.b = z2.a((byte[]) entry.getValue());
                }
                iVar.i.add(lVar);
            }
            Location c2 = v0.d().c();
            if (c2 != null) {
                int f2 = v0.f();
                q qVar = new q();
                iVar.j = qVar;
                qVar.f177a = new p();
                iVar.j.f177a.f173a = z2.a(c2.getLatitude(), f2);
                iVar.j.f177a.b = z2.a(c2.getLongitude(), f2);
                iVar.j.f177a.c = (float) z2.a((double) c2.getAccuracy(), f2);
            }
            String str = (String) t2.a().a("UserId");
            if (!str.equals("")) {
                s sVar = new s();
                iVar.k = sVar;
                sVar.f190a = str;
            }
            w1<i> w1Var = this.f206a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            w1Var.b.a(byteArrayOutputStream, iVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str2 = w1.c;
            s1.a(3, str2, "Encoding " + w1Var.f211a + ": " + new String(byteArray));
            j2 j2Var = new j2(new h2());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            j2Var.a(byteArrayOutputStream2, byteArray);
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            w1.c(byteArray2);
            return byteArray2;
        } catch (Exception e2) {
            s1.a(5, u, "Proton config request failed with exception: ".concat(String.valueOf(e2)));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        List<f> list;
        List<n> list2;
        if (this.o != null) {
            s1.a(5, u, "Processing config response");
            a0.a(this.o.d.c);
            a0.b(this.o.d.d * 1000);
            d0 b2 = d0.b();
            String str = this.o.d.e;
            if (str != null && !str.endsWith(".do")) {
                s1.a(5, d0.e, "overriding analytics agent report URL without an endpoint, are you sure?");
            }
            b2.f101a = str;
            if (this.h) {
                t2.a().a("analyticsEnabled", Boolean.valueOf(this.o.e.b));
            }
            this.d.a();
            h hVar = this.o.d;
            if (hVar != null && (list = hVar.f132a) != null) {
                for (f fVar : list) {
                    if (!(fVar == null || (list2 = fVar.c) == null)) {
                        for (n nVar : list2) {
                            if (nVar != null && !TextUtils.isEmpty(nVar.f161a)) {
                                nVar.b = fVar;
                                this.d.a(nVar.f161a, nVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        return;
     */
    public synchronized void h() {
        if (this.h) {
            z2.a();
            SharedPreferences sharedPreferences = e1.a().f110a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            if (sharedPreferences.getBoolean("com.flurry.android.flurryAppInstall", true)) {
                b("flurry.app_install", (Map<String, String>) null);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("com.flurry.android.flurryAppInstall", false);
                edit.apply();
            }
        }
    }

    private synchronized void i() {
        if (!this.j) {
            s1.e(u, "Analytics disabled, not sending pulse reports.");
            return;
        }
        String str = u;
        s1.a(4, str, "Sending " + this.e.size() + " queued reports.");
        for (b0 b0Var : this.e) {
            String str2 = u;
            s1.a(3, str2, "Firing Pulse callbacks for event: " + b0Var.g);
            a0.c().a(b0Var);
        }
        j();
    }

    private synchronized void j() {
        this.e.clear();
        this.g.b();
    }

    /* access modifiers changed from: private */
    public synchronized void k() {
        s1.a(4, u, "Saving queued report data.");
        this.g.a(this.e);
    }

    public final synchronized void c() {
        if (this.h) {
            z2.a();
            i();
        }
    }

    public final synchronized void b() {
        if (this.h) {
            z2.a();
            q0.a();
            b(q0.c());
            i();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != -1720015653) {
            if (hashCode != 640941243) {
                if (hashCode == 1591403975 && str.equals("ProtonConfigUrl")) {
                    c2 = 1;
                    if (c2 != 0) {
                        this.h = ((Boolean) obj).booleanValue();
                        String str2 = u;
                        s1.a(4, str2, "onSettingUpdate, protonEnabled = " + this.h);
                        return;
                    } else if (c2 == 1) {
                        this.i = (String) obj;
                        String str3 = u;
                        s1.a(4, str3, "onSettingUpdate, protonConfigUrl = " + this.i);
                        return;
                    } else if (c2 != 2) {
                        s1.a(6, u, "onSettingUpdate internal error!");
                        return;
                    } else {
                        this.j = ((Boolean) obj).booleanValue();
                        String str4 = u;
                        s1.a(4, str4, "onSettingUpdate, AnalyticsEnabled = " + this.j);
                        return;
                    }
                }
            } else if (str.equals("ProtonEnabled")) {
                c2 = 0;
                if (c2 != 0) {
                }
            }
        } else if (str.equals("analyticsEnabled")) {
            c2 = 2;
            if (c2 != 0) {
            }
        }
        c2 = 65535;
        if (c2 != 0) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x021c, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0106  */
    public synchronized void b(String str, Map<String, String> map) {
        bd bdVar;
        boolean z;
        String str2;
        Map<String, String> map2 = map;
        synchronized (this) {
            s1.a(3, u, "Event triggered: ".concat(String.valueOf(str)));
            if (!this.j) {
                s1.e(u, "Analytics and pulse have been disabled.");
            } else if (this.o == null) {
                s1.a(3, u, "Config response is empty. No events to fire.");
            } else {
                z2.a();
                if (!TextUtils.isEmpty(str)) {
                    List<n> a2 = this.d.a(str);
                    if (a2 == null) {
                        s1.a(3, u, "No events to fire. Returning.");
                    } else if (a2.size() == 0) {
                        s1.a(3, u, "No events to fire. Returning.");
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean z2 = map2 != null;
                        char c2 = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != 645204782) {
                            if (hashCode != 1371447545) {
                                if (hashCode == 1579613685 && str.equals("flurry.session_start")) {
                                    c2 = 0;
                                }
                            } else if (str.equals("flurry.app_install")) {
                                c2 = 2;
                            }
                        } else if (str.equals("flurry.session_end")) {
                            c2 = 1;
                        }
                        if (c2 == 0) {
                            bdVar = bd.SESSION_START;
                        } else if (c2 == 1) {
                            bdVar = bd.SESSION_END;
                        } else if (c2 != 2) {
                            bdVar = bd.APPLICATION_EVENT;
                        } else {
                            bdVar = bd.INSTALL;
                        }
                        HashMap hashMap = new HashMap();
                        Iterator<n> it = a2.iterator();
                        while (it.hasNext()) {
                            n next = it.next();
                            if (next instanceof o) {
                                s1.a(4, u, "Event contains triggers.");
                                String[] strArr = ((o) next).d;
                                if (strArr == null) {
                                    s1.a(4, u, "Template does not contain trigger values. Firing.");
                                } else if (strArr.length == 0) {
                                    s1.a(4, u, "Template does not contain trigger values. Firing.");
                                } else if (map2 == null) {
                                    s1.a(4, u, "Publisher has not passed in params list. Not firing.");
                                } else {
                                    z = false;
                                    str2 = map2.get(((o) next).c);
                                    if (str2 != null) {
                                        s1.a(4, u, "Publisher params has no value associated with proton key. Not firing.");
                                    } else {
                                        int length = strArr.length;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= length) {
                                                break;
                                            } else if (strArr[i2].equals(str2)) {
                                                z = true;
                                                break;
                                            } else {
                                                i2++;
                                            }
                                        }
                                        if (!z) {
                                            s1.a(4, u, "Publisher params list does not match proton param values. Not firing.");
                                        } else {
                                            s1.a(4, u, "Publisher params match proton values. Firing.");
                                        }
                                    }
                                }
                                z = true;
                                str2 = map2.get(((o) next).c);
                                if (str2 != null) {
                                }
                            }
                            f fVar = next.b;
                            if (fVar == null) {
                                s1.a(3, u, "Template is empty. Not firing current event.");
                            } else {
                                String str3 = u;
                                s1.a(3, str3, "Creating callback report for partner: " + fVar.b);
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("event_name", str);
                                hashMap2.put("event_time_millis", String.valueOf(currentTimeMillis));
                                hashMap.put(Long.valueOf(fVar.f120a), new y(fVar.b, fVar.f120a, this.c.a(fVar.e, hashMap2), System.currentTimeMillis() + 259200000, this.o.d.b, fVar.g, fVar.d, fVar.j, fVar.i, fVar.h, fVar.f != null ? this.c.a(fVar.f, hashMap2) : null));
                                map2 = map;
                                it = it;
                                currentTimeMillis = currentTimeMillis;
                            }
                        }
                        if (hashMap.size() != 0) {
                            q0.a();
                            long c3 = q0.c();
                            q0.a();
                            b0 b0Var = new b0(str, z2, c3, q0.f(), bdVar, hashMap);
                            if ("flurry.session_end".equals(str)) {
                                s1.a(3, u, "Storing Pulse callbacks for event: ".concat(String.valueOf(str)));
                                this.e.add(b0Var);
                                return;
                            }
                            s1.a(3, u, "Firing Pulse callbacks for event: ".concat(String.valueOf(str)));
                            a0.c().a(b0Var);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void a() {
        if (this.h) {
            z2.a();
            q0.a();
            x.k = q0.c();
            this.p = false;
            e();
        }
    }

    public final synchronized void a(long j2) {
        if (this.h) {
            z2.a();
            b(j2);
            b("flurry.session_end", (Map<String, String>) null);
            e1.a().b(new b());
        }
    }

    public final synchronized void a(String str, Map<String, String> map) {
        if (this.h) {
            z2.a();
            b(str, map);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(long j2, boolean z, byte[] bArr) {
        if (bArr != null) {
            s1.a(4, u, "Saving proton config response");
            u uVar = new u();
            uVar.f197a = j2;
            uVar.b = z;
            uVar.c = bArr;
            this.f.a(uVar);
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(j jVar) {
        boolean z;
        h hVar;
        String str;
        boolean z2;
        if (jVar == null) {
            return false;
        }
        h hVar2 = jVar.d;
        if (hVar2 != null && hVar2.f132a != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= hVar2.f132a.size()) {
                    break;
                }
                f fVar = hVar2.f132a.get(i2);
                if (fVar != null) {
                    if (fVar.b.equals("") || fVar.f120a == -1 || fVar.e.equals("")) {
                        break;
                    }
                    List<n> list = fVar.c;
                    if (list != null) {
                        for (n nVar : list) {
                            if (nVar.f161a.equals("")) {
                                s1.a(3, u, "An event is missing a name");
                            } else if ((nVar instanceof o) && ((o) nVar).c.equals("")) {
                                s1.a(3, u, "An event trigger is missing a param name");
                            }
                            z2 = false;
                        }
                    }
                    z2 = true;
                    if (!z2) {
                        break;
                    }
                }
                i2++;
            }
            s1.a(3, u, "A callback template is missing required values");
            z = false;
            if (!z && ((hVar = jVar.d) == null || (str = hVar.e) == null || !str.equals(""))) {
                return true;
            }
            s1.a(3, u, "Config response is missing required values.");
            return false;
        }
        z = true;
        if (!z) {
        }
        s1.a(3, u, "Config response is missing required values.");
        return false;
    }

    private synchronized void b(long j2) {
        Iterator<b0> it = this.e.iterator();
        while (it.hasNext()) {
            if (j2 == it.next().f62a) {
                it.remove();
            }
        }
    }
}
