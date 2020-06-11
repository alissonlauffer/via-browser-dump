package com.flurry.sdk;

import android.os.SystemClock;
import com.flurry.sdk.ec;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class ch {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<eb> f88a;
    public volatile long b = 0;
    public volatile long c = 0;
    public volatile long d = -1;
    public volatile long e = 0;
    /* access modifiers changed from: private */
    public final m1<ec> f = new a();
    private volatile long g = 0;
    private String h;
    private String i;
    private Map<String, String> j;

    class a implements m1<ec> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(ec ecVar) {
            ec ecVar2 = ecVar;
            if (ch.this.f88a == null || ecVar2.c == ch.this.f88a.get()) {
                int i = c.f91a[ecVar2.d - 1];
                if (i == 1) {
                    ch chVar = ch.this;
                    eb ebVar = ecVar2.c;
                    ecVar2.b.get();
                    chVar.f88a = new WeakReference<>(ebVar);
                    chVar.b = System.currentTimeMillis();
                    chVar.c = SystemClock.elapsedRealtime();
                    e1.a().b(new b(chVar));
                } else if (i == 2) {
                    ch chVar2 = ch.this;
                    ecVar2.b.get();
                    chVar2.a();
                } else if (i == 3) {
                    ch chVar3 = ch.this;
                    ecVar2.b.get();
                    chVar3.d = SystemClock.elapsedRealtime() - chVar3.c;
                } else if (i == 4) {
                    n1.a().b("com.flurry.android.sdk.FlurrySessionEvent", ch.this.f);
                }
            }
        }
    }

    class b extends b3 {
        b(ch chVar) {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            v0.d().a();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f91a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            int[] iArr = new int[ec.a.a().length];
            f91a = iArr;
            iArr[ec.a.f116a - 1] = 1;
            f91a[ec.a.b - 1] = 2;
            f91a[ec.a.c - 1] = 3;
            try {
                f91a[ec.a.d - 1] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ch() {
        n1.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.f);
        this.j = new LinkedHashMap<String, String>() {
            /* class com.flurry.sdk.ch.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // java.util.LinkedHashMap
            public final boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 10;
            }
        };
    }

    public final synchronized String c() {
        return this.h;
    }

    public final synchronized String d() {
        return this.i;
    }

    public final synchronized Map<String, String> e() {
        return this.j;
    }

    public final synchronized void a() {
        long j2 = q2.d().d;
        if (j2 > 0) {
            this.e += System.currentTimeMillis() - j2;
        }
    }

    public final synchronized long b() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (elapsedRealtime <= this.g) {
            elapsedRealtime = this.g + 1;
            this.g = elapsedRealtime;
        }
        this.g = elapsedRealtime;
        return this.g;
    }
}
