package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.C0033b0;
import com.flurry.sdk.C0108dk;
import com.flurry.sdk.C0269u;
import com.flurry.sdk.C0275u2;
import com.flurry.sdk.C0315y1;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.w */
public class C0285w implements C0275u2.AbstractC0276a {

    /* renamed from: u */
    private static final String f791u = "w";

    /* renamed from: a */
    private final C0299w1<C0160i> f792a = new C0299w1<>("proton config request", new C0133f0());

    /* renamed from: b */
    private final C0299w1<C0166j> f793b = new C0299w1<>("proton config response", new C0145g0());

    /* renamed from: c */
    private final C0278v f794c = new C0278v();

    /* renamed from: d */
    private final C0162i1<String, C0197n> f795d = new C0162i1<>();

    /* renamed from: e */
    private final List<C0033b0> f796e = new ArrayList();

    /* renamed from: f */
    private C0174k1<C0269u> f797f;

    /* renamed from: g */
    private C0174k1<List<C0033b0>> f798g;

    /* renamed from: h */
    private boolean f799h;

    /* renamed from: i */
    private String f800i;

    /* renamed from: j */
    private boolean f801j = true;

    /* renamed from: k */
    private boolean f802k;

    /* renamed from: l */
    private long f803l = 10000;

    /* renamed from: m */
    private long f804m;

    /* renamed from: n */
    private boolean f805n;

    /* renamed from: o */
    private C0166j f806o;

    /* renamed from: p */
    private boolean f807p;

    /* renamed from: q */
    public final Runnable f808q = new C0288c();

    /* renamed from: r */
    public final AbstractC0192m1<C0259s0> f809r;

    /* renamed from: s */
    public final AbstractC0192m1<C0264t0> f810s;

    /* renamed from: t */
    public final AbstractC0192m1<C0298w0> f811t;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$a */
    public class C0286a extends AbstractRunnableC0040b3 {
        C0286a() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0285w.this.m772L();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$b */
    public class C0287b extends AbstractRunnableC0040b3 {
        C0287b() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0285w.this.m770J();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$c */
    public class C0288c extends AbstractRunnableC0040b3 {
        C0288c() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0285w.this.m790x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$d */
    public class C0289d implements C0315y1.AbstractC0317b<byte[], byte[]> {

        /* renamed from: a */
        final /* synthetic */ long f815a;

        /* renamed from: b */
        final /* synthetic */ boolean f816b;

        /* access modifiers changed from: package-private */
        /* renamed from: com.flurry.sdk.w$d$a */
        public class C0290a extends AbstractRunnableC0040b3 {

            /* renamed from: d */
            final /* synthetic */ byte[] f818d;

            C0290a(byte[] bArr) {
                this.f818d = bArr;
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
                C0289d dVar = C0289d.this;
                C0285w.this.m775f(dVar.f815a, dVar.f816b, this.f818d);
            }
        }

        C0289d(long j, boolean z) {
            this.f815a = j;
            this.f816b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.C0315y1.AbstractC0317b
        /* renamed from: a */
        public final /* synthetic */ void mo165a(C0315y1<byte[], byte[]> y1Var, byte[] bArr) {
            C0166j jVar;
            byte[] bArr2 = bArr;
            int i = y1Var.f337u;
            C0260s1.m686c(3, C0285w.f791u, "Proton config request: HTTP status code is:".concat(String.valueOf(i)));
            if (i == 400 || i == 406 || i == 412 || i == 415) {
                C0285w.this.f803l = 10000;
                return;
            }
            C0166j jVar2 = null;
            if (y1Var.mo175f() && bArr2 != null) {
                C0118e1.m386a().mo191g(new C0290a(bArr2));
                try {
                    jVar = (C0166j) C0285w.this.f793b.mo360c(bArr2);
                } catch (Exception e) {
                    C0260s1.m686c(5, C0285w.f791u, "Failed to decode proton config response: ".concat(String.valueOf(e)));
                    jVar = null;
                }
                if (C0285w.m785r(jVar)) {
                    jVar2 = jVar;
                }
                if (jVar2 != null) {
                    C0285w.this.f803l = 10000;
                    C0285w.this.f804m = this.f815a;
                    C0285w.this.f805n = this.f816b;
                    C0285w.this.f806o = jVar2;
                    C0285w.this.m761A();
                    if (!C0285w.this.f807p) {
                        C0285w.this.f807p = true;
                        C0285w.this.m784q("flurry.session_start", null);
                    }
                    C0285w.this.m763C();
                }
            }
            if (jVar2 == null) {
                long j = C0285w.this.f803l << 1;
                if (i == 429) {
                    List<String> d = y1Var.mo173d("Retry-After");
                    if (!d.isEmpty()) {
                        String str = d.get(0);
                        C0260s1.m686c(3, C0285w.f791u, "Server returned retry time: ".concat(String.valueOf(str)));
                        try {
                            j = Long.parseLong(str) * 1000;
                        } catch (NumberFormatException unused) {
                            C0260s1.m686c(3, C0285w.f791u, "Server returned nonsensical retry time");
                        }
                    }
                }
                C0285w.this.f803l = j;
                C0260s1.m686c(3, C0285w.f791u, "Proton config request failed, backing off: " + C0285w.this.f803l + "ms");
                C0118e1.m386a().mo190e(C0285w.this.f808q, C0285w.this.f803l);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$e */
    public class C0291e extends AbstractRunnableC0040b3 {
        C0291e() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0285w.this.m790x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$f */
    public class C0292f implements AbstractC0192m1<C0259s0> {
        C0292f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo74a(C0259s0 s0Var) {
            C0285w.this.m790x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$g */
    public class C0293g implements AbstractC0192m1<C0264t0> {
        C0293g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo74a(C0264t0 t0Var) {
            C0285w.this.m790x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$h */
    public class C0294h implements AbstractC0192m1<C0298w0> {
        C0294h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo74a(C0298w0 w0Var) {
            if (w0Var.f825b) {
                C0285w.this.m790x();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$i */
    public class C0295i implements AbstractC0201n2<C0269u> {
        C0295i(C0285w wVar) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<C0269u> mo100a(int i) {
            return new C0269u.C0270a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$j */
    public class C0296j implements AbstractC0201n2<List<C0033b0>> {
        C0296j(C0285w wVar) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0033b0>> mo100a(int i) {
            return new C0175k2(new C0033b0.C0034a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.w$k */
    public class C0297k extends AbstractRunnableC0040b3 {
        C0297k() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0285w.this.m771K();
        }
    }

    public C0285w() {
        C0292f fVar = new C0292f();
        this.f809r = fVar;
        C0293g gVar = new C0293g();
        this.f810s = gVar;
        C0294h hVar = new C0294h();
        this.f811t = hVar;
        C0266t2 e = C0266t2.m703e();
        this.f799h = ((Boolean) e.mo341a("ProtonEnabled")).booleanValue();
        e.mo342b("ProtonEnabled", this);
        String str = f791u;
        C0260s1.m686c(4, str, "initSettings, protonEnabled = " + this.f799h);
        this.f800i = (String) e.mo341a("ProtonConfigUrl");
        e.mo342b("ProtonConfigUrl", this);
        C0260s1.m686c(4, str, "initSettings, protonConfigUrl = " + this.f800i);
        this.f801j = ((Boolean) e.mo341a("analyticsEnabled")).booleanValue();
        e.mo342b("analyticsEnabled", this);
        C0260s1.m686c(4, str, "initSettings, AnalyticsEnabled = " + this.f801j);
        C0199n1.m528a().mo271e("com.flurry.android.sdk.IdProviderFinishedEvent", fVar);
        C0199n1.m528a().mo271e("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", gVar);
        C0199n1.m528a().mo271e("com.flurry.android.sdk.NetworkStateEvent", hVar);
        Context context = C0118e1.m386a().f361a;
        this.f797f = new C0174k1<>(context.getFileStreamPath(".yflurryprotonconfig." + Long.toString(C0328z2.m899n(C0118e1.m386a().f365e), 16)), ".yflurryprotonconfig.", 1, new C0295i(this));
        this.f798g = new C0174k1<>(context.getFileStreamPath(".yflurryprotonreport." + Long.toString(C0328z2.m899n(C0118e1.m386a().f365e), 16)), ".yflurryprotonreport.", 1, new C0296j(this));
        C0118e1.m386a().mo191g(new C0297k());
        C0118e1.m386a().mo191g(new C0286a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: A */
    private void m761A() {
        List<C0132f> list;
        List<C0197n> list2;
        if (this.f806o != null) {
            C0260s1.m686c(5, f791u, "Processing config response");
            C0014a0.m163a(this.f806o.f503d.f457c);
            C0014a0.m165g(this.f806o.f503d.f458d * 1000);
            C0095d0 a = C0095d0.m338a();
            String str = this.f806o.f503d.f459e;
            if (str != null && !str.endsWith(".do")) {
                C0260s1.m686c(5, C0095d0.f294e, "overriding analytics agent report URL without an endpoint, are you sure?");
            }
            a.f296a = str;
            if (this.f799h) {
                C0266t2.m703e().mo343c("analyticsEnabled", Boolean.valueOf(this.f806o.f504e.f726b));
            }
            this.f795d.mo232c();
            C0153h hVar = this.f806o.f503d;
            if (!(hVar == null || (list = hVar.f455a) == null)) {
                for (C0132f fVar : list) {
                    if (!(fVar == null || (list2 = fVar.f412c) == null)) {
                        for (C0197n nVar : list2) {
                            if (nVar != null && !TextUtils.isEmpty(nVar.f550a)) {
                                nVar.f551b = fVar;
                                this.f795d.mo233d(nVar.f550a, nVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: C */
    private synchronized void m763C() {
        if (this.f799h) {
            C0328z2.m889d();
            SharedPreferences sharedPreferences = C0118e1.m386a().f361a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            if (sharedPreferences.getBoolean("com.flurry.android.flurryAppInstall", true)) {
                m784q("flurry.app_install", null);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("com.flurry.android.flurryAppInstall", false);
                edit.apply();
            }
        }
    }

    /* renamed from: E */
    private synchronized void m765E() {
        if (!this.f801j) {
            C0260s1.m701r(f791u, "Analytics disabled, not sending pulse reports.");
            return;
        }
        String str = f791u;
        C0260s1.m686c(4, str, "Sending " + this.f796e.size() + " queued reports.");
        for (C0033b0 b0Var : this.f796e) {
            String str2 = f791u;
            C0260s1.m686c(3, str2, "Firing Pulse callbacks for event: " + b0Var.f115g);
            C0014a0.m169n().mo93d(b0Var);
        }
        m768H();
    }

    /* renamed from: H */
    private synchronized void m768H() {
        this.f796e.clear();
        this.f798g.mo254c();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: J */
    private synchronized void m770J() {
        C0260s1.m686c(4, f791u, "Saving queued report data.");
        this.f798g.mo253b(this.f796e);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: K */
    private synchronized void m771K() {
        C0166j jVar;
        C0269u a = this.f797f.mo252a();
        if (a != null) {
            C0166j jVar2 = null;
            try {
                jVar = this.f793b.mo360c(a.f761c);
            } catch (Exception e) {
                C0260s1.m686c(5, f791u, "Failed to decode saved proton config response: ".concat(String.valueOf(e)));
                this.f797f.mo254c();
                jVar = null;
            }
            if (m785r(jVar)) {
                jVar2 = jVar;
            }
            if (jVar2 != null) {
                C0260s1.m686c(4, f791u, "Loaded saved proton config response");
                this.f803l = 10000;
                this.f804m = a.f759a;
                this.f805n = a.f760b;
                this.f806o = jVar2;
                m761A();
            }
        }
        this.f802k = true;
        C0118e1.m386a().mo191g(new C0291e());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: L */
    private synchronized void m772L() {
        C0260s1.m686c(4, f791u, "Loading queued report data.");
        List<C0033b0> a = this.f798g.mo252a();
        if (a != null) {
            this.f796e.addAll(a);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private synchronized void m775f(long j, boolean z, byte[] bArr) {
        if (bArr != null) {
            C0260s1.m686c(4, f791u, "Saving proton config response");
            C0269u uVar = new C0269u();
            uVar.f759a = j;
            uVar.f760b = z;
            uVar.f761c = bArr;
            this.f797f.mo253b(uVar);
        }
    }

    /* renamed from: o */
    private synchronized void m782o(long j) {
        Iterator<C0033b0> it = this.f796e.iterator();
        while (it.hasNext()) {
            if (j == it.next().f109a) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f7  */
    /* renamed from: q */
    private synchronized void m784q(String str, Map<String, String> map) {
        EnumC0043bd bdVar;
        boolean z;
        String str2;
        Map<String, String> map2 = map;
        synchronized (this) {
            String str3 = f791u;
            C0260s1.m686c(3, str3, "Event triggered: ".concat(String.valueOf(str)));
            if (!this.f801j) {
                C0260s1.m701r(str3, "Analytics and pulse have been disabled.");
            } else if (this.f806o == null) {
                C0260s1.m686c(3, str3, "Config response is empty. No events to fire.");
            } else {
                C0328z2.m889d();
                if (!TextUtils.isEmpty(str)) {
                    List<C0197n> a = this.f795d.mo230a(str);
                    if (a == null) {
                        C0260s1.m686c(3, str3, "No events to fire. Returning.");
                    } else if (a.size() == 0) {
                        C0260s1.m686c(3, str3, "No events to fire. Returning.");
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean z2 = map2 != null;
                        char c = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != 645204782) {
                            if (hashCode != 1371447545) {
                                if (hashCode == 1579613685 && str.equals("flurry.session_start")) {
                                    c = 0;
                                }
                            } else if (str.equals("flurry.app_install")) {
                                c = 2;
                            }
                        } else if (str.equals("flurry.session_end")) {
                            c = 1;
                        }
                        if (c == 0) {
                            bdVar = EnumC0043bd.SESSION_START;
                        } else if (c == 1) {
                            bdVar = EnumC0043bd.SESSION_END;
                        } else if (c != 2) {
                            bdVar = EnumC0043bd.APPLICATION_EVENT;
                        } else {
                            bdVar = EnumC0043bd.INSTALL;
                        }
                        HashMap hashMap = new HashMap();
                        Iterator<C0197n> it = a.iterator();
                        while (it.hasNext()) {
                            C0197n next = it.next();
                            if (next instanceof C0203o) {
                                String str4 = f791u;
                                C0260s1.m686c(4, str4, "Event contains triggers.");
                                String[] strArr = ((C0203o) next).f590d;
                                if (strArr == null) {
                                    C0260s1.m686c(4, str4, "Template does not contain trigger values. Firing.");
                                } else if (strArr.length == 0) {
                                    C0260s1.m686c(4, str4, "Template does not contain trigger values. Firing.");
                                } else if (map2 == null) {
                                    C0260s1.m686c(4, str4, "Publisher has not passed in params list. Not firing.");
                                } else {
                                    z = false;
                                    str2 = map2.get(((C0203o) next).f589c);
                                    if (str2 != null) {
                                        C0260s1.m686c(4, str4, "Publisher params has no value associated with proton key. Not firing.");
                                    } else {
                                        int length = strArr.length;
                                        int i = 0;
                                        while (true) {
                                            if (i >= length) {
                                                break;
                                            } else if (strArr[i].equals(str2)) {
                                                z = true;
                                                break;
                                            } else {
                                                i++;
                                            }
                                        }
                                        if (!z) {
                                            C0260s1.m686c(4, f791u, "Publisher params list does not match proton param values. Not firing.");
                                        } else {
                                            C0260s1.m686c(4, f791u, "Publisher params match proton values. Firing.");
                                        }
                                    }
                                }
                                z = true;
                                str2 = map2.get(((C0203o) next).f589c);
                                if (str2 != null) {
                                }
                            }
                            C0132f fVar = next.f551b;
                            if (fVar == null) {
                                C0260s1.m686c(3, f791u, "Template is empty. Not firing current event.");
                            } else {
                                String str5 = f791u;
                                C0260s1.m686c(3, str5, "Creating callback report for partner: " + fVar.f411b);
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("event_name", str);
                                hashMap2.put("event_time_millis", String.valueOf(currentTimeMillis));
                                String c2 = this.f794c.mo345c(fVar.f414e, hashMap2);
                                String str6 = fVar.f415f;
                                hashMap.put(Long.valueOf(fVar.f410a), new C0310y(fVar.f411b, fVar.f410a, c2, System.currentTimeMillis() + 259200000, this.f806o.f503d.f456b, fVar.f416g, fVar.f413d, fVar.f419j, fVar.f418i, fVar.f417h, str6 != null ? this.f794c.mo345c(str6, hashMap2) : null));
                                map2 = map;
                                it = it;
                                currentTimeMillis = currentTimeMillis;
                            }
                        }
                        if (hashMap.size() != 0) {
                            C0235q0.m624b();
                            long e = C0235q0.m627e();
                            C0235q0.m624b();
                            C0033b0 b0Var = new C0033b0(str, z2, e, C0235q0.m630h(), bdVar, hashMap);
                            if ("flurry.session_end".equals(str)) {
                                C0260s1.m686c(3, f791u, "Storing Pulse callbacks for event: ".concat(String.valueOf(str)));
                                this.f796e.add(b0Var);
                                return;
                            }
                            C0260s1.m686c(3, f791u, "Firing Pulse callbacks for event: ".concat(String.valueOf(str)));
                            C0014a0.m169n().mo93d(b0Var);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public static boolean m785r(C0166j jVar) {
        boolean z;
        C0153h hVar;
        String str;
        boolean z2;
        if (jVar == null) {
            return false;
        }
        C0153h hVar2 = jVar.f503d;
        if (!(hVar2 == null || hVar2.f455a == null)) {
            int i = 0;
            while (true) {
                if (i >= hVar2.f455a.size()) {
                    break;
                }
                C0132f fVar = hVar2.f455a.get(i);
                if (fVar != null) {
                    if (fVar.f411b.equals("") || fVar.f410a == -1 || fVar.f414e.equals("")) {
                        break;
                    }
                    List<C0197n> list = fVar.f412c;
                    if (list != null) {
                        for (C0197n nVar : list) {
                            if (nVar.f550a.equals("")) {
                                C0260s1.m686c(3, f791u, "An event is missing a name");
                            } else if ((nVar instanceof C0203o) && ((C0203o) nVar).f589c.equals("")) {
                                C0260s1.m686c(3, f791u, "An event trigger is missing a param name");
                            }
                            z2 = false;
                        }
                    }
                    z2 = true;
                    if (!z2) {
                        break;
                    }
                }
                i++;
            }
            C0260s1.m686c(3, f791u, "A callback template is missing required values");
            z = false;
            if (!z && ((hVar = jVar.f503d) == null || (str = hVar.f459e) == null || !str.equals(""))) {
                return true;
            }
            C0260s1.m686c(3, f791u, "Config response is missing required values.");
            return false;
        }
        z = true;
        if (!z) {
        }
        C0260s1.m686c(3, f791u, "Config response is missing required values.");
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [byte[], RequestObjectType] */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: x */
    private synchronized void m790x() {
        if (this.f799h) {
            C0328z2.m889d();
            if (this.f802k) {
                if (C0044bs.m232a().mo124g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z = !C0044bs.m232a().mo127j();
                    if (this.f806o != null) {
                        if (this.f805n != z) {
                            C0260s1.m686c(3, f791u, "Limit ad tracking value has changed, purging");
                            this.f806o = null;
                        } else if (System.currentTimeMillis() < this.f804m + (this.f806o.f500a * 1000)) {
                            C0260s1.m686c(3, f791u, "Cached Proton config valid, no need to refresh");
                            if (!this.f807p) {
                                this.f807p = true;
                                m784q("flurry.session_start", null);
                            }
                            return;
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j = this.f804m;
                            long j2 = this.f806o.f501b;
                            Long.signum(j2);
                            if (currentTimeMillis2 >= j + (j2 * 1000)) {
                                C0260s1.m686c(3, f791u, "Cached Proton config expired, purging");
                                this.f806o = null;
                                this.f795d.mo232c();
                            }
                        }
                    }
                    C0098d1.m348j().mo308e(this);
                    C0260s1.m686c(3, f791u, "Requesting proton config");
                    ?? r3 = (RequestObjectType) m792z();
                    if (r3 != 0) {
                        C0315y1 y1Var = new C0315y1();
                        y1Var.f324h = TextUtils.isEmpty(this.f800i) ? "https://proton.flurry.com/sdk/v1/config" : this.f800i;
                        y1Var.f226d = 5000;
                        y1Var.f325i = C0108dk.EnumC0109a.kPost;
                        String num = Integer.toString(C0299w1.m811a(r3));
                        y1Var.mo174e("Content-Type", "application/x-flurry;version=2");
                        y1Var.mo174e("Accept", "application/x-flurry;version=2");
                        y1Var.mo174e("FM-Checksum", num);
                        y1Var.f869D = new C0158h2();
                        y1Var.f870E = new C0158h2();
                        y1Var.f867B = r3;
                        y1Var.f866A = new C0289d(currentTimeMillis, z);
                        C0098d1.m348j().mo309f(this, y1Var);
                    }
                }
            }
        }
    }

    /* renamed from: z */
    private byte[] m792z() {
        try {
            C0160i iVar = new C0160i();
            iVar.f481a = C0118e1.m386a().f365e;
            iVar.f482b = C0300w2.m815a(C0118e1.m386a().f361a);
            iVar.f483c = C0300w2.m816b(C0118e1.m386a().f361a);
            iVar.f484d = C0135f1.m416a();
            iVar.f485e = 3;
            C0314y0.m857a();
            iVar.f486f = C0314y0.m859d();
            iVar.f487g = !C0044bs.m232a().mo127j();
            C0187m mVar = new C0187m();
            iVar.f488h = mVar;
            C0113e eVar = new C0113e();
            mVar.f541a = eVar;
            eVar.f351a = Build.MODEL;
            eVar.f352b = Build.BRAND;
            eVar.f353c = Build.ID;
            eVar.f354d = Build.DEVICE;
            eVar.f355e = Build.PRODUCT;
            eVar.f356f = Build.VERSION.RELEASE;
            iVar.f489i = new ArrayList();
            for (Map.Entry entry : Collections.unmodifiableMap(C0044bs.m232a().f150b).entrySet()) {
                C0179l lVar = new C0179l();
                lVar.f529a = ((EnumC0076ca) entry.getKey()).f231d;
                if (((EnumC0076ca) entry.getKey()).f232e) {
                    lVar.f530b = new String((byte[]) entry.getValue());
                } else {
                    lVar.f530b = C0328z2.m895j((byte[]) entry.getValue());
                }
                iVar.f489i.add(lVar);
            }
            Location n = C0279v0.m732e().mo348n();
            if (n != null) {
                int k = C0279v0.m738k();
                C0234q qVar = new C0234q();
                iVar.f490j = qVar;
                C0227p pVar = new C0227p();
                qVar.f676a = pVar;
                pVar.f668a = C0328z2.m886a(n.getLatitude(), k);
                iVar.f490j.f676a.f669b = C0328z2.m886a(n.getLongitude(), k);
                iVar.f490j.f676a.f670c = (float) C0328z2.m886a((double) n.getAccuracy(), k);
            }
            String str = (String) C0266t2.m703e().mo341a("UserId");
            if (!str.equals("")) {
                C0258s sVar = new C0258s();
                iVar.f491k = sVar;
                sVar.f720a = str;
            }
            C0299w1<C0160i> w1Var = this.f792a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            w1Var.f829b.mo105a(byteArrayOutputStream, iVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str2 = C0299w1.f826c;
            C0260s1.m686c(3, str2, "Encoding " + w1Var.f828a + ": " + new String(byteArray));
            C0169j2 j2Var = new C0169j2(new C0158h2());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            j2Var.mo105a(byteArrayOutputStream2, byteArray);
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            C0299w1.m812b(byteArray2);
            return byteArray2;
        } catch (Exception e) {
            C0260s1.m686c(5, f791u, "Proton config request failed with exception: ".concat(String.valueOf(e)));
            return null;
        }
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    c = 0;
                    break;
                }
                break;
            case 640941243:
                if (str.equals("ProtonEnabled")) {
                    c = 1;
                    break;
                }
                break;
            case 1591403975:
                if (str.equals("ProtonConfigUrl")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f801j = ((Boolean) obj).booleanValue();
                String str2 = f791u;
                C0260s1.m686c(4, str2, "onSettingUpdate, AnalyticsEnabled = " + this.f801j);
                return;
            case 1:
                this.f799h = ((Boolean) obj).booleanValue();
                String str3 = f791u;
                C0260s1.m686c(4, str3, "onSettingUpdate, protonEnabled = " + this.f799h);
                return;
            case 2:
                this.f800i = (String) obj;
                String str4 = f791u;
                C0260s1.m686c(4, str4, "onSettingUpdate, protonConfigUrl = " + this.f800i);
                return;
            default:
                C0260s1.m686c(6, f791u, "onSettingUpdate internal error!");
                return;
        }
    }

    /* renamed from: d */
    public final synchronized void mo355d() {
        if (this.f799h) {
            C0328z2.m889d();
            C0235q0.m624b();
            C0302x.f834k = C0235q0.m627e();
            this.f807p = false;
            m790x();
        }
    }

    /* renamed from: e */
    public final synchronized void mo356e(long j) {
        if (this.f799h) {
            C0328z2.m889d();
            m782o(j);
            m784q("flurry.session_end", null);
            C0118e1.m386a().mo191g(new C0287b());
        }
    }

    /* renamed from: j */
    public final synchronized void mo357j(String str, Map<String, String> map) {
        if (this.f799h) {
            C0328z2.m889d();
            m784q(str, map);
        }
    }

    /* renamed from: n */
    public final synchronized void mo358n() {
        if (this.f799h) {
            C0328z2.m889d();
            C0235q0.m624b();
            m782o(C0235q0.m627e());
            m765E();
        }
    }

    /* renamed from: s */
    public final synchronized void mo359s() {
        if (this.f799h) {
            C0328z2.m889d();
            m765E();
        }
    }
}
