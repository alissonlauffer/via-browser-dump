package com.flurry.sdk;

import android.os.SystemClock;
import com.flurry.sdk.C0127ec;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.ch */
public class C0077ch {

    /* renamed from: a */
    WeakReference<C0125eb> f233a;

    /* renamed from: b */
    public volatile long f234b = 0;

    /* renamed from: c */
    public volatile long f235c = 0;

    /* renamed from: d */
    public volatile long f236d = -1;

    /* renamed from: e */
    public volatile long f237e = 0;

    /* renamed from: f */
    private final AbstractC0192m1<C0127ec> f238f;

    /* renamed from: g */
    private volatile long f239g;

    /* renamed from: h */
    private String f240h;

    /* renamed from: i */
    private String f241i;

    /* renamed from: j */
    private Map<String, String> f242j;

    /* renamed from: com.flurry.sdk.ch$a */
    class C0079a implements AbstractC0192m1<C0127ec> {
        C0079a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0127ec ecVar) {
            C0127ec ecVar2 = ecVar;
            if (C0077ch.this.f233a == null || ecVar2.f384c == C0077ch.this.f233a.get()) {
                int i = C0081c.f245a[ecVar2.f385d - 1];
                if (i == 1) {
                    C0077ch chVar = C0077ch.this;
                    C0125eb ebVar = ecVar2.f384c;
                    ecVar2.f383b.get();
                    chVar.f233a = new WeakReference<>(ebVar);
                    chVar.f234b = System.currentTimeMillis();
                    chVar.f235c = SystemClock.elapsedRealtime();
                    C0118e1.m386a().mo191g(new C0080b(chVar));
                } else if (i == 2) {
                    C0077ch chVar2 = C0077ch.this;
                    ecVar2.f383b.get();
                    chVar2.mo148b();
                } else if (i == 3) {
                    C0077ch chVar3 = C0077ch.this;
                    ecVar2.f383b.get();
                    chVar3.f236d = SystemClock.elapsedRealtime() - chVar3.f235c;
                } else if (i == 4) {
                    C0199n1.m528a().mo272f("com.flurry.android.sdk.FlurrySessionEvent", C0077ch.this.f238f);
                }
            }
        }
    }

    /* renamed from: com.flurry.sdk.ch$b */
    class C0080b extends AbstractRunnableC0040b3 {
        C0080b(C0077ch chVar) {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0279v0.m732e().mo346l();
        }
    }

    /* renamed from: com.flurry.sdk.ch$c */
    static /* synthetic */ class C0081c {

        /* renamed from: a */
        static final /* synthetic */ int[] f245a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            int[] iArr = new int[C0127ec.EnumC0128a.m408a().length];
            f245a = iArr;
            iArr[C0127ec.EnumC0128a.f387a - 1] = 1;
            f245a[C0127ec.EnumC0128a.f388b - 1] = 2;
            f245a[C0127ec.EnumC0128a.f389c - 1] = 3;
            try {
                f245a[C0127ec.EnumC0128a.f390d - 1] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public C0077ch() {
        C0079a aVar = new C0079a();
        this.f238f = aVar;
        this.f239g = 0;
        C0199n1.m528a().mo271e("com.flurry.android.sdk.FlurrySessionEvent", aVar);
        this.f242j = new LinkedHashMap<String, String>() {
            /* class com.flurry.sdk.C0077ch.C00782 */

            /* access modifiers changed from: protected */
            @Override // java.util.LinkedHashMap
            public final boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 10;
            }
        };
    }

    /* renamed from: b */
    public final synchronized void mo148b() {
        long j = C0243q2.m650a().f690d;
        if (j > 0) {
            this.f237e += System.currentTimeMillis() - j;
        }
    }

    /* renamed from: c */
    public final synchronized long mo149c() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f235c;
        if (elapsedRealtime <= this.f239g) {
            elapsedRealtime = this.f239g + 1;
            this.f239g = elapsedRealtime;
        }
        this.f239g = elapsedRealtime;
        return this.f239g;
    }

    /* renamed from: e */
    public final synchronized String mo150e() {
        return this.f240h;
    }

    /* renamed from: f */
    public final synchronized String mo151f() {
        return this.f241i;
    }

    /* renamed from: g */
    public final synchronized Map<String, String> mo152g() {
        return this.f242j;
    }
}
