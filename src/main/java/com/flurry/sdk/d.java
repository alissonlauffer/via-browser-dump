package com.flurry.sdk;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.flurry.sdk.c0;
import com.flurry.sdk.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    /* access modifiers changed from: private */
    public static final String k = "d";
    private static volatile d l;
    private static final Object m = new Object();
    private static p3 n;

    /* renamed from: a  reason: collision with root package name */
    private a f96a;
    private l3 b;
    /* access modifiers changed from: private */
    public o3 c;
    public o2 d;
    private final Map<com.flurry.android.e, Pair<m3, WeakReference<Handler>>> e;
    /* access modifiers changed from: private */
    public final Map<m3, Pair<Boolean, Boolean>> f;
    private volatile boolean g;
    /* access modifiers changed from: private */
    public volatile boolean h;
    /* access modifiers changed from: private */
    public volatile boolean i;
    /* access modifiers changed from: private */
    public a j;

    /* access modifiers changed from: package-private */
    public enum a {
        Complete("Complete", 3),
        CompleteNoChange("No Change", 2),
        Fail("Fail", 1),
        None("None", 0);
        
        int e;
        private String f;

        private a(String str, int i) {
            this.f = str;
            this.e = i;
        }

        public final String toString() {
            return this.f;
        }
    }

    class b implements Runnable {
        b() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.flurry.sdk.d.a(com.flurry.sdk.m3, boolean):void
         arg types: [com.flurry.sdk.m3, int]
         candidates:
          com.flurry.sdk.d.a(com.flurry.sdk.d, com.flurry.sdk.d$a):com.flurry.sdk.d$a
          com.flurry.sdk.d.a(com.flurry.sdk.m3, boolean):void */
        /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
            java.lang.StackOverflowError
            	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
            	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
            */
        public final void run() {
            /*
                r8 = this;
                r0 = 1
                com.flurry.sdk.e1 r1 = com.flurry.sdk.e1.a()     // Catch:{ Exception -> 0x00cc }
                android.content.Context r1 = r1.f110a     // Catch:{ Exception -> 0x00cc }
                java.lang.String r1 = com.flurry.sdk.v3.b(r1)     // Catch:{ Exception -> 0x00cc }
                java.lang.String r2 = com.flurry.sdk.d.k     // Catch:{ Exception -> 0x00cc }
                java.lang.String r3 = "Cached Data: "
                java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00cc }
                java.lang.String r3 = r3.concat(r4)     // Catch:{ Exception -> 0x00cc }
                com.flurry.sdk.s1.a(r2, r3)     // Catch:{ Exception -> 0x00cc }
                if (r1 == 0) goto L_0x0086
                com.flurry.sdk.d r2 = com.flurry.sdk.d.this     // Catch:{ Exception -> 0x00cc }
                com.flurry.sdk.o2 r2 = r2.d     // Catch:{ Exception -> 0x00cc }
                java.lang.String r2 = r2.d()     // Catch:{ Exception -> 0x00cc }
                com.flurry.sdk.d r3 = com.flurry.sdk.d.this     // Catch:{ Exception -> 0x00cc }
                com.flurry.sdk.o2 r3 = r3.d     // Catch:{ Exception -> 0x00cc }
                android.content.SharedPreferences r4 = r3.f171a     // Catch:{ Exception -> 0x00cc }
                r5 = 0
                if (r4 == 0) goto L_0x003b
                android.content.SharedPreferences r3 = r3.f171a     // Catch:{ Exception -> 0x00cc }
                java.lang.String r4 = "lastRSA"
                java.lang.String r5 = r3.getString(r4, r5)     // Catch:{ Exception -> 0x00cc }
            L_0x003b:
                boolean r2 = com.flurry.sdk.v3.a(r2, r1, r5)     // Catch:{ Exception -> 0x00cc }
                if (r2 == 0) goto L_0x006b
                com.flurry.sdk.d r2 = com.flurry.sdk.d.this     // Catch:{ Exception -> 0x00cc }
                com.flurry.sdk.o3 r2 = r2.c     // Catch:{ Exception -> 0x00cc }
                if (r1 == 0) goto L_0x005e
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0056 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0056 }
                java.util.List r1 = com.flurry.sdk.j3.a(r3)     // Catch:{ Exception -> 0x0056 }
                r2.a(r1)     // Catch:{ Exception -> 0x0056 }
                goto L_0x005e
            L_0x0056:
                r1 = move-exception
                java.lang.String r3 = com.flurry.sdk.o3.e
                java.lang.String r4 = "Cached variants parsing error: "
                com.flurry.sdk.s1.a(r3, r4, r1)
            L_0x005e:
                com.flurry.sdk.p3 r1 = com.flurry.sdk.d.e()
                if (r1 == 0) goto L_0x0086
                com.flurry.sdk.d.e()
                com.flurry.sdk.p3.a(r2)
                goto L_0x0086
            L_0x006b:
                java.lang.String r1 = com.flurry.sdk.d.k
                java.lang.String r2 = "Incorrect signature for cache."
                com.flurry.sdk.s1.b(r1, r2)
                com.flurry.sdk.e1 r1 = com.flurry.sdk.e1.a()
                android.content.Context r1 = r1.f110a
                com.flurry.sdk.v3.c(r1)
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.o2 r1 = r1.d
                r1.c()
            L_0x0086:
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.d.c(r1)
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.o3 r1 = r1.c
                int r1 = r1.e()
                if (r1 <= 0) goto L_0x0119
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.o3 r1 = r1.c
                java.util.List r1 = r1.d()
                java.util.Iterator r1 = r1.iterator()
            L_0x00a5:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x00c9
                java.lang.Object r2 = r1.next()
                com.flurry.sdk.m3 r2 = (com.flurry.sdk.m3) r2
                com.flurry.sdk.d r3 = com.flurry.sdk.d.this
                java.util.Map r3 = r3.f
                android.util.Pair r4 = new android.util.Pair
                java.lang.Boolean r5 = java.lang.Boolean.TRUE
                java.lang.Boolean r6 = java.lang.Boolean.FALSE
                r4.<init>(r5, r6)
                r3.put(r2, r4)
                com.flurry.sdk.d r3 = com.flurry.sdk.d.this
                r3.a(r2, r0)
                goto L_0x00a5
            L_0x00c9:
                return
            L_0x00ca:
                r1 = move-exception
                goto L_0x011a
            L_0x00cc:
                r1 = move-exception
                java.lang.String r2 = com.flurry.sdk.d.k     // Catch:{ all -> 0x00ca }
                java.lang.String r3 = "Exception!"
                com.flurry.sdk.s1.a(r2, r3, r1)     // Catch:{ all -> 0x00ca }
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.d.c(r1)
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.o3 r1 = r1.c
                int r1 = r1.e()
                if (r1 <= 0) goto L_0x0119
                com.flurry.sdk.d r1 = com.flurry.sdk.d.this
                com.flurry.sdk.o3 r1 = r1.c
                java.util.List r1 = r1.d()
                java.util.Iterator r1 = r1.iterator()
            L_0x00f5:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0119
                java.lang.Object r2 = r1.next()
                com.flurry.sdk.m3 r2 = (com.flurry.sdk.m3) r2
                com.flurry.sdk.d r3 = com.flurry.sdk.d.this
                java.util.Map r3 = r3.f
                android.util.Pair r4 = new android.util.Pair
                java.lang.Boolean r5 = java.lang.Boolean.TRUE
                java.lang.Boolean r6 = java.lang.Boolean.FALSE
                r4.<init>(r5, r6)
                r3.put(r2, r4)
                com.flurry.sdk.d r3 = com.flurry.sdk.d.this
                r3.a(r2, r0)
                goto L_0x00f5
            L_0x0119:
                return
            L_0x011a:
                com.flurry.sdk.d r2 = com.flurry.sdk.d.this
                com.flurry.sdk.d.c(r2)
                com.flurry.sdk.d r2 = com.flurry.sdk.d.this
                com.flurry.sdk.o3 r2 = r2.c
                int r2 = r2.e()
                if (r2 <= 0) goto L_0x015d
                com.flurry.sdk.d r2 = com.flurry.sdk.d.this
                com.flurry.sdk.o3 r2 = r2.c
                java.util.List r2 = r2.d()
                java.util.Iterator r2 = r2.iterator()
            L_0x0139:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x015d
                java.lang.Object r3 = r2.next()
                com.flurry.sdk.m3 r3 = (com.flurry.sdk.m3) r3
                com.flurry.sdk.d r4 = com.flurry.sdk.d.this
                java.util.Map r4 = r4.f
                android.util.Pair r5 = new android.util.Pair
                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                java.lang.Boolean r7 = java.lang.Boolean.FALSE
                r5.<init>(r6, r7)
                r4.put(r3, r5)
                com.flurry.sdk.d r4 = com.flurry.sdk.d.this
                r4.a(r3, r0)
                goto L_0x0139
            L_0x015d:
                goto L_0x015f
            L_0x015e:
                throw r1
            L_0x015f:
                goto L_0x015e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.d.b.run():void");
        }
    }

    class c implements c0.d {
        c() {
        }

        @Override // com.flurry.sdk.c0.d
        public final void a(g gVar, boolean z) {
            a aVar;
            if (!z) {
                boolean unused = d.this.h = false;
            }
            g.a aVar2 = gVar.b;
            if (aVar2 == g.a.SUCCEED) {
                s1.a(d.k, "Fetch succeeded.");
                aVar = a.Complete;
                boolean unused2 = d.this.i = true;
                for (m3 m3Var : m3.a()) {
                    boolean z2 = false;
                    if (d.this.f.containsKey(m3Var)) {
                        z2 = ((Boolean) ((Pair) d.this.f.get(m3Var)).first).booleanValue();
                    }
                    d.this.f.put(m3Var, new Pair(Boolean.valueOf(z2), Boolean.FALSE));
                }
            } else if (aVar2 == g.a.NO_CHANGE) {
                s1.a(d.k, "Fetch finished.");
                aVar = a.CompleteNoChange;
            } else {
                s1.a(d.k, "Error occured while fetching: ".concat(String.valueOf(gVar)));
                aVar = a.Fail;
            }
            if (d.this.j.e <= aVar.e) {
                a unused3 = d.this.j = aVar;
            }
            d.b(d.this, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.d$d  reason: collision with other inner class name */
    public class C0013d extends b3 {
        final /* synthetic */ a d;
        final /* synthetic */ com.flurry.android.e e;

        C0013d(a aVar, com.flurry.android.e eVar) {
            this.d = aVar;
            this.e = eVar;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            int i = f.f100a[this.d.ordinal()];
            if (i == 2) {
                this.e.b();
            } else if (i == 3) {
                this.e.a();
            } else if (i == 4) {
                this.e.a(d.this.h);
            }
        }
    }

    class e extends b3 {
        final /* synthetic */ com.flurry.android.e d;
        final /* synthetic */ boolean e;

        e(d dVar, com.flurry.android.e eVar, boolean z) {
            this.d = eVar;
            this.e = z;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            this.d.b(this.e);
        }
    }

    static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f100a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[a.values().length];
            f100a = iArr;
            iArr[a.None.ordinal()] = 1;
            f100a[a.Complete.ordinal()] = 2;
            f100a[a.CompleteNoChange.ordinal()] = 3;
            try {
                f100a[a.Fail.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private d() {
        this((byte) 0);
    }

    public final List<n3> c() {
        o3 o3Var = this.c;
        if (o3Var != null) {
            return o3Var.b();
        }
        return null;
    }

    public String toString() {
        h();
        ArrayList arrayList = new ArrayList();
        List<n3> c2 = c();
        if (c2 == null || c2.isEmpty()) {
            return "No variants were found!";
        }
        for (n3 n3Var : c2) {
            arrayList.add(n3Var.toString());
        }
        return TextUtils.join(",", arrayList);
    }

    private d(byte b2) {
        this.e = new ConcurrentHashMap();
        this.f = new HashMap();
        this.g = false;
        this.h = false;
        this.j = a.None;
        n = null;
        for (m3 m3Var : m3.a()) {
            Map<m3, Pair<Boolean, Boolean>> map = this.f;
            Boolean bool = Boolean.FALSE;
            map.put(m3Var, new Pair<>(bool, bool));
        }
        this.b = new l3();
        this.c = new o3();
        this.d = new o2();
        new u3();
        t3.a(new b());
    }

    public static synchronized d d() {
        d g2;
        synchronized (d.class) {
            g2 = g();
        }
        return g2;
    }

    public static p3 e() {
        return n;
    }

    private static synchronized d g() {
        d dVar;
        synchronized (d.class) {
            if (l == null) {
                l = new d((byte) 0);
            }
            dVar = l;
        }
        return dVar;
    }

    private void h() {
        synchronized (m) {
            while (!this.g) {
                try {
                    m.wait();
                } catch (InterruptedException e2) {
                    s1.a(k, "Interrupted Exception!", e2);
                }
            }
        }
    }

    public final void b() {
        if (this.h) {
            s1.a(3, k, "Preventing re-entry...");
            return;
        }
        this.h = true;
        s1.a(3, k, "Fetch started");
        new c0(u3.a(e1.a().f110a, "https://cfg.flurry.com/sdk/v1/config"), new c(), this.d, this.c).a();
    }

    static /* synthetic */ void c(d dVar) {
        synchronized (m) {
            dVar.g = true;
            m.notifyAll();
        }
    }

    public final a a() {
        if (this.f96a == null) {
            h();
            this.f96a = new a(this.b, this.c);
        }
        return this.f96a;
    }

    public final void a(m3 m3Var, boolean z) {
        synchronized (this.e) {
            for (Map.Entry<com.flurry.android.e, Pair<m3, WeakReference<Handler>>> entry : this.e.entrySet()) {
                if (m3Var == null || m3Var == entry.getValue().first) {
                    Handler handler = (Handler) ((WeakReference) entry.getValue().second).get();
                    e eVar = new e(this, entry.getKey(), z);
                    if (handler == null) {
                        e1.a().a(eVar);
                    } else {
                        handler.post(eVar);
                    }
                }
            }
        }
    }

    static /* synthetic */ void b(d dVar, a aVar) {
        synchronized (dVar.e) {
            for (Map.Entry<com.flurry.android.e, Pair<m3, WeakReference<Handler>>> entry : dVar.e.entrySet()) {
                Handler handler = (Handler) ((WeakReference) entry.getValue().second).get();
                C0013d dVar2 = new C0013d(aVar, entry.getKey());
                if (handler == null) {
                    e1.a().a(dVar2);
                } else {
                    handler.post(dVar2);
                }
            }
        }
    }
}
