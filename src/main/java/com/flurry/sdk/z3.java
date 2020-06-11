package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.eb;
import com.flurry.sdk.ec;
import com.google.android.instantapps.InstantApps;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class z3 implements v1 {
    private static final String k = "z3";

    /* renamed from: a  reason: collision with root package name */
    public w f230a;
    public l0 b;
    public x c;
    public f3 d;
    public boolean e = false;
    private final Object f = new Object();
    private Queue<y3> g = new LinkedList();
    private Queue<y3> h = new LinkedList();
    private Queue<x3> i = new LinkedList();
    private final m1<ec> j = new a();

    class a implements m1<ec> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* bridge */ /* synthetic */ void a(ec ecVar) {
            if (b.f232a[ecVar.d - 1] == 1) {
                z3.a(z3.this);
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f232a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        static {
            int[] iArr = new int[eb.a.a().length];
            b = iArr;
            iArr[eb.a.f115a - 1] = 1;
            b[eb.a.b - 1] = 2;
            b[eb.a.c - 1] = 3;
            int[] iArr2 = new int[ec.a.a().length];
            f232a = iArr2;
            try {
                iArr2[ec.a.e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static synchronized z3 a() {
        z3 z3Var;
        synchronized (z3.class) {
            z3Var = (z3) e1.a().a(z3.class);
        }
        return z3Var;
    }

    public static o0 b() {
        eb c2 = q2.d().c();
        if (c2 == null) {
            return null;
        }
        return (o0) c2.a(o0.class);
    }

    private synchronized int c() {
        return q2.d().b();
    }

    private static void b(y3 y3Var) {
        o0 b2 = b();
        if (b2 != null) {
            b2.a(y3Var.f224a, y3Var.b);
        }
    }

    @Override // com.flurry.sdk.v1
    public void a(Context context) {
        eb.b(o0.class);
        this.b = new l0();
        this.f230a = new w();
        this.c = new x();
        this.d = new f3();
        n1.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.j);
        if (!z2.a(context, "android.permission.INTERNET")) {
            s1.b(k, "Application must declare permission: android.permission.INTERNET");
        }
        if (!z2.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            s1.e(k, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
        }
        int identifier = context.getResources().getIdentifier("FLURRY_IS_YAHOO_APP", "bool", context.getPackageName());
        if (identifier != 0) {
            this.e = context.getResources().getBoolean(identifier);
            String str = k;
            s1.c(str, "Found FLURRY_IS_YAHOO_APP resource id. Value: " + this.e);
        }
        r1 b2 = r1.b();
        try {
            Class.forName("com.google.android.instantapps.InstantApps");
            b2.f187a = InstantApps.isInstantApp(context);
            String str2 = r1.b;
            s1.a(str2, "isInstantApp: " + String.valueOf(b2.f187a));
        } catch (ClassNotFoundException unused) {
            s1.a(r1.b, "isInstantApps dependency is not added");
        }
    }

    private static void b(x3 x3Var) {
        o0 b2 = b();
        if (b2 != null) {
            b2.a(x3Var);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean, int):com.flurry.android.FlurryEventRecordStatus
     arg types: [java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int, int]
     candidates:
      com.flurry.sdk.z3.a(java.lang.String, java.lang.String, java.lang.Throwable, java.util.Map<java.lang.String, java.lang.String>):void
      com.flurry.sdk.z3.a(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean, int):com.flurry.android.FlurryEventRecordStatus */
    public final FlurryEventRecordStatus a(String str, Map<String, String> map, int i2) {
        return a(str, map, false, i2);
    }

    public final FlurryEventRecordStatus a(String str, Map<String, String> map, boolean z) {
        return a(str, map, z, 0);
    }

    public final FlurryEventRecordStatus a(String str, Map<String, String> map, boolean z, int i2) {
        y3 y3Var = new y3(str, map, z, i2);
        synchronized (this.f) {
            int i3 = b.b[c() - 1];
            if (i3 == 1) {
                String str2 = k;
                s1.a(str2, "There is no active Flurry session. Adding this event to deferred queue and flush them when the session initializes. Event: " + y3Var.f224a);
                this.g.add(y3Var);
                FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventLoggingDelayed;
                return flurryEventRecordStatus;
            } else if (i3 == 2) {
                String str3 = k;
                s1.a(str3, "Waiting for Flurry session to initialize before logging event: " + y3Var.f224a);
                this.g.add(y3Var);
                FlurryEventRecordStatus flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventLoggingDelayed;
                return flurryEventRecordStatus2;
            } else if (i3 != 3) {
                FlurryEventRecordStatus flurryEventRecordStatus3 = FlurryEventRecordStatus.kFlurryEventFailed;
                return flurryEventRecordStatus3;
            } else {
                FlurryEventRecordStatus a2 = a(y3Var);
                return a2;
            }
        }
    }

    private static FlurryEventRecordStatus a(y3 y3Var) {
        o0 b2 = b();
        return b2 != null ? b2.a(y3Var.f224a, y3Var.b, y3Var.c, y3Var.d) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    public final void a(String str, String str2, Throwable th, Map<String, String> map) {
        f3 f3Var;
        boolean z = str != null && "uncaught".equals(str);
        x3 x3Var = new x3(str, str2, th.getClass().getName(), th, g3.a(z), map);
        if (z && (f3Var = this.d) != null) {
            List<e3> a2 = f3Var.a();
            x3Var.g = a2;
            String str3 = k;
            s1.a(4, str3, "Total breadcrumbs - " + a2.size());
        }
        a(x3Var);
    }

    public final void a(x3 x3Var) {
        synchronized (this.f) {
            int i2 = b.b[c() - 1];
            if (i2 == 1) {
                String str = k;
                s1.a(str, "There is no active Flurry session. Adding this logging error to deferred queue and flush them when the session initializes. Error: " + x3Var.f218a);
                this.i.add(x3Var);
            } else if (i2 == 2) {
                String str2 = k;
                s1.a(str2, "Waiting for Flurry session to initialize before logging error: " + x3Var.f218a);
                this.i.add(x3Var);
            } else if (i2 == 3) {
                b(x3Var);
            }
        }
    }

    static /* synthetic */ void a(z3 z3Var) {
        s1.a(k, "Flushing deferred events queues.");
        synchronized (z3Var.f) {
            while (z3Var.g.peek() != null) {
                a(z3Var.g.poll());
            }
            while (z3Var.i.peek() != null) {
                b(z3Var.i.poll());
            }
            while (z3Var.h.peek() != null) {
                b(z3Var.h.poll());
            }
        }
    }
}
