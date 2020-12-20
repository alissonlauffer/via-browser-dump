package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.sdk.AbstractC0192m1;
import com.flurry.sdk.AbstractC0282v1;
import com.flurry.sdk.C0118e1;
import com.flurry.sdk.C0127ec;
import com.flurry.sdk.C0178k3;
import com.flurry.sdk.C0199n1;
import com.flurry.sdk.C0260s1;
import com.flurry.sdk.C0266t2;
import com.flurry.sdk.C0274u1;
import com.flurry.sdk.C0309x3;
import com.flurry.sdk.C0328z2;
import com.flurry.sdk.C0329z3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.flurry.android.b */
public final class C0004b {

    /* renamed from: a */
    private static final String f43a = "b";

    /* renamed from: b */
    private static AbstractC0009c f44b;

    /* renamed from: c */
    private static final AbstractC0192m1<C0127ec> f45c = new C0005a();

    /* renamed from: d */
    private static String f46d = null;

    /* renamed from: e */
    private static String f47e = null;

    /* renamed from: f */
    private static AbstractC0003a f48f;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.android.b$a */
    public class C0005a implements AbstractC0192m1<C0127ec> {

        /* renamed from: com.flurry.android.b$a$a */
        class RunnableC0006a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0127ec f49a;

            RunnableC0006a(C0005a aVar, C0127ec ecVar) {
                this.f49a = ecVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (C0007b.f50a[this.f49a.f385d - 1] == 1 && C0004b.f44b != null) {
                    C0004b.f44b.mo81a();
                }
            }
        }

        C0005a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0127ec ecVar) {
            C0118e1.m386a().mo189d(new RunnableC0006a(this, ecVar));
        }
    }

    /* renamed from: com.flurry.android.b$b */
    static /* synthetic */ class C0007b {

        /* renamed from: a */
        static final /* synthetic */ int[] f50a;

        static {
            int[] iArr = new int[C0127ec.EnumC0128a.m408a().length];
            f50a = iArr;
            try {
                iArr[C0127ec.EnumC0128a.f391e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.flurry.android.b$c */
    public static class C0008c {

        /* renamed from: i */
        private static AbstractC0009c f51i;

        /* renamed from: a */
        private boolean f52a = false;

        /* renamed from: b */
        private int f53b = 5;

        /* renamed from: c */
        private long f54c = 10000;

        /* renamed from: d */
        private boolean f55d = true;

        /* renamed from: e */
        private boolean f56e = false;

        /* renamed from: f */
        private boolean f57f = true;

        /* renamed from: g */
        List<AbstractC0012f> f58g = new ArrayList();

        /* renamed from: h */
        AbstractC0003a f59h;

        /* renamed from: a */
        public void mo76a(Context context, String str) {
            if (C0004b.m132d()) {
                C0004b.m130b(f51i, this.f52a, this.f53b, this.f54c, this.f55d, this.f56e, this.f57f, this.f58g, this.f59h, context, str);
            }
        }

        /* renamed from: b */
        public C0008c mo77b(boolean z) {
            this.f55d = z;
            return this;
        }

        /* renamed from: c */
        public C0008c mo78c(long j) {
            this.f54c = j;
            return this;
        }

        /* renamed from: d */
        public C0008c mo79d(boolean z) {
            this.f52a = z;
            return this;
        }

        /* renamed from: e */
        public C0008c mo80e(int i) {
            this.f53b = i;
            return this;
        }
    }

    static {
        new ArrayList();
    }

    private C0004b() {
    }

    /* renamed from: b */
    static /* synthetic */ void m130b(AbstractC0009c cVar, boolean z, int i, long j, boolean z2, boolean z3, boolean z4, List list, AbstractC0003a aVar, Context context, String str) {
        boolean z5;
        f44b = cVar;
        m142n(cVar);
        m143o(z);
        m144p(i);
        m141m(j);
        m140l(z2);
        int identifier = context.getResources().getIdentifier("FLURRY_IS_YAHOO_APP", "bool", context.getPackageName());
        if (identifier != 0) {
            z5 = context.getResources().getBoolean(identifier);
            C0260s1.m697n(f43a, "Found FLURRY_IS_YAHOO_APP resource id. Value: ".concat(String.valueOf(z5)));
        } else {
            z5 = false;
        }
        if (z5) {
            C0266t2.m703e().mo343c("ProtonEnabled", Boolean.valueOf(z3));
            if (!z3) {
                C0266t2.m703e().mo343c("analyticsEnabled", Boolean.TRUE);
            }
        } else if (z3) {
            C0260s1.m701r(f43a, "Flurry Pulse is not available anymore and the API will be removed in an upcoming release");
        }
        if (m132d()) {
            C0266t2.m703e().mo343c("IncludeBackgroundSessionsInMetrics", Boolean.valueOf(z4));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0274u1.m718b((AbstractC0282v1) ((AbstractC0012f) it.next()));
        }
        f46d = str;
        m135g(context, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m132d() {
        if (C0328z2.m891f(16)) {
            return true;
        }
        C0260s1.m693j(f43a, String.format(Locale.getDefault(), "Device SDK Version older than %d", 16));
        return false;
    }

    /* renamed from: e */
    public static synchronized AbstractC0003a m133e() {
        AbstractC0003a aVar;
        synchronized (C0004b.class) {
            aVar = f48f;
        }
        return aVar;
    }

    /* renamed from: f */
    public static String m134f() {
        return f47e;
    }

    @Deprecated
    /* renamed from: g */
    public static synchronized void m135g(Context context, String str) {
        synchronized (C0004b.class) {
            if (m132d()) {
                if (!TextUtils.isEmpty(str)) {
                    if (C0118e1.m386a() != null) {
                        C0260s1.m701r(f43a, "Flurry is already initialized");
                    }
                    try {
                        C0178k3.m506a();
                        C0118e1.m387c(context, str);
                    } catch (Throwable th) {
                        C0260s1.m689f(f43a, "", th);
                    }
                } else {
                    throw new IllegalArgumentException("API key not specified");
                }
            }
        }
    }

    /* renamed from: h */
    public static FlurryEventRecordStatus m136h(String str) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (!m132d()) {
            return flurryEventRecordStatus;
        }
        try {
            return C0329z3.m900e().mo376d(str, null, false, 0);
        } catch (Throwable th) {
            C0260s1.m689f(f43a, "Failed to log event: ".concat(String.valueOf(str)), th);
            return flurryEventRecordStatus;
        }
    }

    /* renamed from: i */
    public static FlurryEventRecordStatus m137i(String str, Map<String, String> map) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (!m132d()) {
            return flurryEventRecordStatus;
        }
        try {
            return C0329z3.m900e().mo374b(str, map, 0);
        } catch (Throwable th) {
            C0260s1.m689f(f43a, "Failed to log event: ".concat(String.valueOf(str)), th);
            return flurryEventRecordStatus;
        }
    }

    /* renamed from: j */
    public static void m138j(String str, String str2, String str3) {
        m139k(str, str2, str3, null);
    }

    /* renamed from: k */
    public static void m139k(String str, String str2, String str3, Map<String, String> map) {
        if (m132d()) {
            if (TextUtils.isEmpty(str)) {
                C0260s1.m693j(f43a, "String errorId passed to onError was empty.");
            } else if (TextUtils.isEmpty(str2)) {
                C0260s1.m693j(f43a, "String message passed to onError was empty.");
            } else if (TextUtils.isEmpty(str3)) {
                C0260s1.m693j(f43a, "String errorClass passed to onError was empty.");
            } else {
                try {
                    C0329z3 e = C0329z3.m900e();
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null && stackTrace.length > 2) {
                        int length = stackTrace.length - 2;
                        StackTraceElement[] stackTraceElementArr = new StackTraceElement[length];
                        System.arraycopy(stackTrace, 2, stackTraceElementArr, 0, length);
                        stackTrace = stackTraceElementArr;
                    }
                    Throwable th = new Throwable(str2);
                    th.setStackTrace(stackTrace);
                    e.mo377f(new C0309x3(str, str2, str3, th, null, map));
                } catch (Throwable th2) {
                    C0260s1.m689f(f43a, "", th2);
                }
            }
        }
    }

    @Deprecated
    /* renamed from: l */
    public static void m140l(boolean z) {
        if (m132d()) {
            C0266t2.m703e().mo343c("CaptureUncaughtExceptions", Boolean.valueOf(z));
        }
    }

    @Deprecated
    /* renamed from: m */
    public static void m141m(long j) {
        if (m132d()) {
            if (j < 5000) {
                C0260s1.m693j(f43a, "Invalid time set for session resumption: ".concat(String.valueOf(j)));
            } else {
                C0266t2.m703e().mo343c("ContinueSessionMillis", Long.valueOf(j));
            }
        }
    }

    @Deprecated
    /* renamed from: n */
    public static void m142n(AbstractC0009c cVar) {
        if (m132d()) {
            f44b = cVar;
            C0199n1.m528a().mo271e("com.flurry.android.sdk.FlurrySessionEvent", f45c);
        }
    }

    @Deprecated
    /* renamed from: o */
    public static void m143o(boolean z) {
        if (m132d()) {
            if (z) {
                C0260s1.m690g();
            } else {
                C0260s1.m684a();
            }
        }
    }

    @Deprecated
    /* renamed from: p */
    public static void m144p(int i) {
        if (m132d()) {
            C0260s1.m685b(i);
        }
    }

    /* renamed from: q */
    public static void m145q(boolean z) {
        if (m132d()) {
            C0266t2.m703e().mo343c("ReportLocation", Boolean.valueOf(z));
        }
    }
}
