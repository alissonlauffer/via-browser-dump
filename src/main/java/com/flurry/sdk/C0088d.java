package com.flurry.sdk;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.flurry.android.AbstractC0011e;
import com.flurry.sdk.C0060c0;
import com.flurry.sdk.C0143g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.flurry.sdk.d */
public class C0088d {

    /* renamed from: k */
    private static final String f265k = "d";

    /* renamed from: l */
    private static volatile C0088d f266l;

    /* renamed from: m */
    private static final Object f267m = new Object();

    /* renamed from: n */
    private static C0233p3 f268n;

    /* renamed from: a */
    private C0013a f269a;

    /* renamed from: b */
    private C0186l3 f270b;

    /* renamed from: c */
    private C0226o3 f271c;

    /* renamed from: d */
    public C0225o2 f272d;

    /* renamed from: e */
    private final Map<AbstractC0011e, Pair<C0196m3, WeakReference<Handler>>> f273e;

    /* renamed from: f */
    private final Map<C0196m3, Pair<Boolean, Boolean>> f274f;

    /* renamed from: g */
    private volatile boolean f275g;

    /* renamed from: h */
    private volatile boolean f276h;

    /* renamed from: i */
    private volatile boolean f277i;

    /* renamed from: j */
    private EnumC0089a f278j;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.d$a */
    public enum EnumC0089a {
        Complete("Complete", 3),
        CompleteNoChange("No Change", 2),
        Fail("Fail", 1),
        None("None", 0);
        

        /* renamed from: e */
        int f284e;

        /* renamed from: f */
        private String f285f;

        private EnumC0089a(String str, int i) {
            this.f285f = str;
            this.f284e = i;
        }

        public final String toString() {
            return this.f285f;
        }
    }

    /* renamed from: com.flurry.sdk.d$b */
    class RunnableC0090b implements Runnable {
        RunnableC0090b() {
        }

        /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
            java.lang.StackOverflowError
            	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
            */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 342
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C0088d.RunnableC0090b.run():void");
        }
    }

    /* renamed from: com.flurry.sdk.d$c */
    class C0091c implements C0060c0.AbstractC0064d {
        C0091c() {
        }

        @Override // com.flurry.sdk.C0060c0.AbstractC0064d
        /* renamed from: a */
        public final void mo138a(C0143g gVar, boolean z) {
            EnumC0089a aVar;
            if (!z) {
                C0088d.this.f276h = false;
            }
            C0143g.EnumC0144a aVar2 = gVar.f439b;
            if (aVar2 == C0143g.EnumC0144a.SUCCEED) {
                C0260s1.m688e(C0088d.f265k, "Fetch succeeded.");
                aVar = EnumC0089a.Complete;
                C0088d.this.f277i = true;
                for (C0196m3 m3Var : C0196m3.m527b()) {
                    boolean z2 = false;
                    if (C0088d.this.f274f.containsKey(m3Var)) {
                        z2 = ((Boolean) ((Pair) C0088d.this.f274f.get(m3Var)).first).booleanValue();
                    }
                    C0088d.this.f274f.put(m3Var, new Pair(Boolean.valueOf(z2), Boolean.FALSE));
                }
            } else if (aVar2 == C0143g.EnumC0144a.NO_CHANGE) {
                C0260s1.m688e(C0088d.f265k, "Fetch finished.");
                aVar = EnumC0089a.CompleteNoChange;
            } else {
                C0260s1.m688e(C0088d.f265k, "Error occured while fetching: ".concat(String.valueOf(gVar)));
                aVar = EnumC0089a.Fail;
            }
            if (C0088d.this.f278j.f284e <= aVar.f284e) {
                C0088d.this.f278j = aVar;
            }
            C0088d.m321g(C0088d.this, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.d$d */
    public class C0092d extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ EnumC0089a f288d;

        /* renamed from: e */
        final /* synthetic */ AbstractC0011e f289e;

        C0092d(EnumC0089a aVar, AbstractC0011e eVar) {
            this.f288d = aVar;
            this.f289e = eVar;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            int i = C0094f.f293a[this.f288d.ordinal()];
            if (i == 2) {
                this.f289e.mo87b();
            } else if (i == 3) {
                this.f289e.mo86a();
            } else if (i == 4) {
                this.f289e.mo88c(C0088d.this.f276h);
            }
        }
    }

    /* renamed from: com.flurry.sdk.d$e */
    class C0093e extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ AbstractC0011e f291d;

        /* renamed from: e */
        final /* synthetic */ boolean f292e;

        C0093e(C0088d dVar, AbstractC0011e eVar, boolean z) {
            this.f291d = eVar;
            this.f292e = z;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            this.f291d.mo89d(this.f292e);
        }
    }

    /* renamed from: com.flurry.sdk.d$f */
    static /* synthetic */ class C0094f {

        /* renamed from: a */
        static final /* synthetic */ int[] f293a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[EnumC0089a.values().length];
            f293a = iArr;
            iArr[EnumC0089a.None.ordinal()] = 1;
            f293a[EnumC0089a.Complete.ordinal()] = 2;
            f293a[EnumC0089a.CompleteNoChange.ordinal()] = 3;
            try {
                f293a[EnumC0089a.Fail.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private C0088d() {
        this((byte) 0);
    }

    /* renamed from: b */
    public static synchronized C0088d m317b() {
        C0088d q;
        synchronized (C0088d.class) {
            q = m328q();
        }
        return q;
    }

    /* renamed from: f */
    public static C0233p3 m320f() {
        return f268n;
    }

    /* renamed from: g */
    static /* synthetic */ void m321g(C0088d dVar, EnumC0089a aVar) {
        synchronized (dVar.f273e) {
            for (Map.Entry<AbstractC0011e, Pair<C0196m3, WeakReference<Handler>>> entry : dVar.f273e.entrySet()) {
                Handler handler = (Handler) ((WeakReference) entry.getValue().second).get();
                C0092d dVar2 = new C0092d(aVar, entry.getKey());
                if (handler == null) {
                    C0118e1.m386a().mo189d(dVar2);
                } else {
                    handler.post(dVar2);
                }
            }
        }
    }

    /* renamed from: i */
    static /* synthetic */ void m322i(C0088d dVar) {
        Object obj = f267m;
        synchronized (obj) {
            dVar.f275g = true;
            obj.notifyAll();
        }
    }

    /* renamed from: q */
    private static synchronized C0088d m328q() {
        C0088d dVar;
        synchronized (C0088d.class) {
            if (f266l == null) {
                f266l = new C0088d((byte) 0);
            }
            dVar = f266l;
        }
        return dVar;
    }

    /* renamed from: s */
    private void m330s() {
        synchronized (f267m) {
            while (!this.f275g) {
                try {
                    f267m.wait();
                } catch (InterruptedException e) {
                    C0260s1.m689f(f265k, "Interrupted Exception!", e);
                }
            }
        }
    }

    /* renamed from: d */
    public final void mo156d(C0196m3 m3Var, boolean z) {
        synchronized (this.f273e) {
            for (Map.Entry<AbstractC0011e, Pair<C0196m3, WeakReference<Handler>>> entry : this.f273e.entrySet()) {
                if (m3Var == null || m3Var == entry.getValue().first) {
                    Handler handler = (Handler) ((WeakReference) entry.getValue().second).get();
                    C0093e eVar = new C0093e(this, entry.getKey(), z);
                    if (handler == null) {
                        C0118e1.m386a().mo189d(eVar);
                    } else {
                        handler.post(eVar);
                    }
                }
            }
        }
    }

    /* renamed from: h */
    public final C0013a mo157h() {
        if (this.f269a == null) {
            m330s();
            this.f269a = new C0013a(this.f270b, this.f271c);
        }
        return this.f269a;
    }

    /* renamed from: k */
    public final void mo158k() {
        if (this.f276h) {
            C0260s1.m686c(3, f265k, "Preventing re-entry...");
            return;
        }
        this.f276h = true;
        C0260s1.m686c(3, f265k, "Fetch started");
        new C0060c0(C0277u3.m727a(C0118e1.m386a().f361a, "https://cfg.flurry.com/sdk/v1/config"), new C0091c(), this.f272d, this.f271c).mo135d();
    }

    /* renamed from: m */
    public final List<C0202n3> mo159m() {
        C0226o3 o3Var = this.f271c;
        if (o3Var != null) {
            return o3Var.mo301k();
        }
        return null;
    }

    public String toString() {
        m330s();
        ArrayList arrayList = new ArrayList();
        List<C0202n3> m = mo159m();
        if (m == null || m.isEmpty()) {
            return "No variants were found!";
        }
        for (C0202n3 n3Var : m) {
            arrayList.add(n3Var.toString());
        }
        return TextUtils.join(",", arrayList);
    }

    private C0088d(byte b) {
        this.f273e = new ConcurrentHashMap();
        this.f274f = new HashMap();
        this.f275g = false;
        this.f276h = false;
        this.f278j = EnumC0089a.None;
        f268n = null;
        for (C0196m3 m3Var : C0196m3.m527b()) {
            Map<C0196m3, Pair<Boolean, Boolean>> map = this.f274f;
            Boolean bool = Boolean.FALSE;
            map.put(m3Var, new Pair<>(bool, bool));
        }
        this.f270b = new C0186l3();
        this.f271c = new C0226o3();
        this.f272d = new C0225o2();
        AbstractRunnableC0267t3.m704b(new RunnableC0090b());
    }
}
