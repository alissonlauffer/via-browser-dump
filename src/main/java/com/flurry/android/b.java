package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.flurry.sdk.e1;
import com.flurry.sdk.ec;
import com.flurry.sdk.k3;
import com.flurry.sdk.m1;
import com.flurry.sdk.n1;
import com.flurry.sdk.s1;
import com.flurry.sdk.t2;
import com.flurry.sdk.u1;
import com.flurry.sdk.v1;
import com.flurry.sdk.x3;
import com.flurry.sdk.z2;
import com.flurry.sdk.z3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46a = "b";
    /* access modifiers changed from: private */
    public static c b;
    private static final m1<ec> c = new a();
    private static String d = null;
    private static String e = null;
    private static a f = null;

    class a implements m1<ec> {

        /* renamed from: com.flurry.android.b$a$a  reason: collision with other inner class name */
        class C0008a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ec f47a;

            C0008a(a aVar, ec ecVar) {
                this.f47a = ecVar;
            }

            public final void run() {
                if (C0009b.f48a[this.f47a.d - 1] == 1 && b.b != null) {
                    b.b.a();
                }
            }
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(ec ecVar) {
            e1.a().a(new C0008a(this, ecVar));
        }
    }

    /* renamed from: com.flurry.android.b$b  reason: collision with other inner class name */
    static /* synthetic */ class C0009b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f48a;

        static {
            int[] iArr = new int[ec.a.a().length];
            f48a = iArr;
            try {
                iArr[ec.a.e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class c {
        private static c i;

        /* renamed from: a  reason: collision with root package name */
        private boolean f49a = false;
        private int b = 5;
        private long c = 10000;
        private boolean d = true;
        private boolean e = false;
        private boolean f = true;
        List<f> g = new ArrayList();
        a h;

        public c a(int i2) {
            this.b = i2;
            return this;
        }

        public c b(boolean z) {
            this.f49a = z;
            return this;
        }

        public c a(long j) {
            this.c = j;
            return this;
        }

        public c a(boolean z) {
            this.d = z;
            return this;
        }

        public void a(@NonNull Context context, @NonNull String str) {
            if (b.c()) {
                b.a(i, this.f49a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, context, str);
            }
        }
    }

    static {
        new ArrayList();
    }

    private b() {
    }

    public static void c(boolean z) {
        if (c()) {
            t2.a().a("ReportLocation", Boolean.valueOf(z));
        }
    }

    public static synchronized a d() {
        a aVar;
        synchronized (b.class) {
            aVar = f;
        }
        return aVar;
    }

    public static String e() {
        return e;
    }

    @Deprecated
    public static void a(@NonNull c cVar) {
        if (c()) {
            b = cVar;
            n1.a().a("com.flurry.android.sdk.FlurrySessionEvent", c);
        }
    }

    @Deprecated
    public static void b(boolean z) {
        if (c()) {
            if (z) {
                s1.b();
            } else {
                s1.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean c() {
        if (z2.a(16)) {
            return true;
        }
        s1.b(f46a, String.format(Locale.getDefault(), "Device SDK Version older than %d", 16));
        return false;
    }

    @Deprecated
    public static void a(int i) {
        if (c()) {
            s1.a(i);
        }
    }

    @Deprecated
    public static void a(long j) {
        if (c()) {
            if (j < 5000) {
                s1.b(f46a, "Invalid time set for session resumption: ".concat(String.valueOf(j)));
            } else {
                t2.a().a("ContinueSessionMillis", Long.valueOf(j));
            }
        }
    }

    @Deprecated
    public static void a(boolean z) {
        if (c()) {
            t2.a().a("CaptureUncaughtExceptions", Boolean.valueOf(z));
        }
    }

    @Deprecated
    public static synchronized void a(@NonNull Context context, @NonNull String str) {
        synchronized (b.class) {
            if (c()) {
                if (!TextUtils.isEmpty(str)) {
                    if (e1.a() != null) {
                        s1.e(f46a, "Flurry is already initialized");
                    }
                    try {
                        k3.a();
                        e1.a(context, str);
                    } catch (Throwable th) {
                        s1.a(f46a, "", th);
                    }
                } else {
                    throw new IllegalArgumentException("API key not specified");
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean, int):com.flurry.android.FlurryEventRecordStatus
     arg types: [java.lang.String, ?[OBJECT, ARRAY], int, int]
     candidates:
      com.flurry.sdk.z3.a(java.lang.String, java.lang.String, java.lang.Throwable, java.util.Map<java.lang.String, java.lang.String>):void
      com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean, int):com.flurry.android.FlurryEventRecordStatus */
    @NonNull
    public static FlurryEventRecordStatus a(@NonNull String str) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (!c()) {
            return flurryEventRecordStatus;
        }
        try {
            return z3.a().a(str, (Map<String, String>) null, false, 0);
        } catch (Throwable th) {
            s1.a(f46a, "Failed to log event: ".concat(String.valueOf(str)), th);
            return flurryEventRecordStatus;
        }
    }

    @NonNull
    public static FlurryEventRecordStatus a(@NonNull String str, @NonNull Map<String, String> map) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (!c()) {
            return flurryEventRecordStatus;
        }
        try {
            return z3.a().a(str, map, 0);
        } catch (Throwable th) {
            s1.a(f46a, "Failed to log event: ".concat(String.valueOf(str)), th);
            return flurryEventRecordStatus;
        }
    }

    public static void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        a(str, str2, str3, null);
    }

    public static void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Map<String, String> map) {
        if (c()) {
            if (TextUtils.isEmpty(str)) {
                s1.b(f46a, "String errorId passed to onError was empty.");
            } else if (TextUtils.isEmpty(str2)) {
                s1.b(f46a, "String message passed to onError was empty.");
            } else if (TextUtils.isEmpty(str3)) {
                s1.b(f46a, "String errorClass passed to onError was empty.");
            } else {
                try {
                    z3 a2 = z3.a();
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null && stackTrace.length > 2) {
                        int length = stackTrace.length - 2;
                        StackTraceElement[] stackTraceElementArr = new StackTraceElement[length];
                        System.arraycopy(stackTrace, 2, stackTraceElementArr, 0, length);
                        stackTrace = stackTraceElementArr;
                    }
                    Throwable th = new Throwable(str2);
                    th.setStackTrace(stackTrace);
                    a2.a(new x3(str, str2, str3, th, null, map));
                } catch (Throwable th2) {
                    s1.a(f46a, "", th2);
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, boolean z, int i, long j, boolean z2, boolean z3, boolean z4, List list, a aVar, Context context, String str) {
        boolean z5;
        b = cVar;
        a(cVar);
        b(z);
        a(i);
        a(j);
        a(z2);
        int identifier = context.getResources().getIdentifier("FLURRY_IS_YAHOO_APP", "bool", context.getPackageName());
        if (identifier != 0) {
            z5 = context.getResources().getBoolean(identifier);
            s1.c(f46a, "Found FLURRY_IS_YAHOO_APP resource id. Value: ".concat(String.valueOf(z5)));
        } else {
            z5 = false;
        }
        if (z5) {
            t2.a().a("ProtonEnabled", Boolean.valueOf(z3));
            if (!z3) {
                t2.a().a("analyticsEnabled", Boolean.TRUE);
            }
        } else if (z3) {
            s1.e(f46a, "Flurry Pulse is not available anymore and the API will be removed in an upcoming release");
        }
        if (c()) {
            t2.a().a("IncludeBackgroundSessionsInMetrics", Boolean.valueOf(z4));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u1.a((v1) ((f) it.next()));
        }
        f = aVar;
        d = str;
        a(context, str);
    }
}
