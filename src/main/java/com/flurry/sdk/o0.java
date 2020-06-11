package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.by;
import com.flurry.sdk.c2;
import com.flurry.sdk.ec;
import com.flurry.sdk.ep;
import com.flurry.sdk.m0;
import com.flurry.sdk.u2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class o0 implements u2.a {
    static final String E = "o0";
    static int F = 500;
    static int G = 10;
    static int H = 1000;
    static int I = 160000;
    static int J = 50;
    boolean A;
    /* access modifiers changed from: package-private */
    public boolean B = true;
    final m1<s0> C = new a();
    /* access modifiers changed from: private */
    public final m1<ec> D = new b();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f165a = new AtomicInteger(0);
    private final AtomicInteger b = new AtomicInteger(0);
    private final List<m0> c = new ArrayList();
    private final Map<String, List<String>> d = new HashMap();
    private final Map<String, String> e = new HashMap();
    private final Map<String, i0> f = new HashMap();
    private final List<j0> g = new ArrayList();
    private final List<h0> h = new ArrayList();
    private final List<String> i = new ArrayList();
    private final a4 j = new a4();
    /* access modifiers changed from: package-private */
    public WeakReference<eb> k;
    File l;
    k1<List<m0>> m;
    public boolean n;
    private long o;
    private String p;
    private String q;
    boolean r;
    String s;
    byte t;
    Long u;
    private int v = -1;
    private boolean w = true;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    class a implements m1<s0> {

        /* renamed from: com.flurry.sdk.o0$a$a  reason: collision with other inner class name */
        class C0019a extends b3 {
            C0019a() {
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.flurry.sdk.o0.a(com.flurry.sdk.o0, boolean, long):void
             arg types: [com.flurry.sdk.o0, int, long]
             candidates:
              com.flurry.sdk.o0.a(long, long, com.flurry.sdk.h0):com.flurry.sdk.m0
              com.flurry.sdk.o0.a(com.flurry.sdk.o0, boolean, long):void */
            @Override // com.flurry.sdk.b3
            public final void a() {
                o0 o0Var = o0.this;
                q0.a();
                o0Var.a(true, q0.c());
            }
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(s0 s0Var) {
            e1.a().b(new C0019a());
        }
    }

    class b implements m1<ec> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
         arg types: [java.lang.String, com.flurry.sdk.o0]
         candidates:
          com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
          com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(ec ecVar) {
            ec ecVar2 = ecVar;
            if (o0.this.k == null || ecVar2.c == o0.this.k.get()) {
                int i = q.f169a[ecVar2.d - 1];
                if (i == 1) {
                    o0 o0Var = o0.this;
                    eb ebVar = ecVar2.c;
                    Context context = ecVar2.b.get();
                    o0Var.k = new WeakReference<>(ebVar);
                    t2 a2 = t2.a();
                    o0Var.r = ((Boolean) a2.a("LogEvents")).booleanValue();
                    a2.a("LogEvents", (u2.a) o0Var);
                    String str = o0.E;
                    s1.a(4, str, "initSettings, LogEvents = " + o0Var.r);
                    o0Var.s = (String) a2.a("UserId");
                    a2.a("UserId", (u2.a) o0Var);
                    String str2 = o0.E;
                    s1.a(4, str2, "initSettings, UserId = " + o0Var.s);
                    o0Var.t = ((Byte) a2.a("Gender")).byteValue();
                    a2.a("Gender", (u2.a) o0Var);
                    String str3 = o0.E;
                    s1.a(4, str3, "initSettings, Gender = " + ((int) o0Var.t));
                    o0Var.u = (Long) a2.a("Age");
                    a2.a("Age", (u2.a) o0Var);
                    String str4 = o0.E;
                    s1.a(4, str4, "initSettings, BirthDate = " + o0Var.u);
                    o0Var.B = ((Boolean) a2.a("analyticsEnabled")).booleanValue();
                    a2.a("analyticsEnabled", (u2.a) o0Var);
                    String str5 = o0.E;
                    s1.a(4, str5, "initSettings, AnalyticsEnabled = " + o0Var.B);
                    o0Var.l = context.getFileStreamPath(".flurryagent." + Integer.toString(e1.a().e.hashCode(), 16));
                    o0Var.m = new k1<>(context.getFileStreamPath(".yflurryreport." + Long.toString(z2.f(e1.a().e), 16)), ".yflurryreport.", 1, new c(o0Var));
                    o0Var.A = ebVar.a();
                    o0Var.a(context);
                    o0Var.a(true);
                    if (z3.a().f230a != null) {
                        e1.a().b(new d(o0Var));
                    }
                    e1.a().b(new e());
                    e1.a().b(new f());
                    e1.a().b(new g());
                    if (bs.e().a()) {
                        e1.a().b(new h());
                    } else {
                        n1.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", o0Var.C);
                    }
                } else if (i == 2) {
                    o0 o0Var2 = o0.this;
                    ecVar2.b.get();
                    o0Var2.a();
                } else if (i == 3) {
                    o0 o0Var3 = o0.this;
                    ecVar2.b.get();
                    o0Var3.b();
                } else if (i == 4) {
                    n1.a().b("com.flurry.android.sdk.FlurrySessionEvent", o0.this.D);
                    o0.this.a(ecVar2.e);
                }
            }
        }
    }

    class c implements n2<List<m0>> {
        c(o0 o0Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<m0>> a(int i) {
            return new k2(new m0.a());
        }
    }

    class d extends b3 {
        d(o0 o0Var) {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            z3.a().f230a.a();
        }
    }

    class e extends b3 {
        e() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            o0.this.d();
        }
    }

    class f extends b3 {
        f() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            o0.d(o0.this);
        }
    }

    class g extends b3 {
        g() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            o0.e(o0.this);
        }
    }

    class h extends b3 {
        h() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.flurry.sdk.o0.a(com.flurry.sdk.o0, boolean, long):void
         arg types: [com.flurry.sdk.o0, int, long]
         candidates:
          com.flurry.sdk.o0.a(long, long, com.flurry.sdk.h0):com.flurry.sdk.m0
          com.flurry.sdk.o0.a(com.flurry.sdk.o0, boolean, long):void */
        @Override // com.flurry.sdk.b3
        public final void a() {
            o0 o0Var = o0.this;
            q0.a();
            o0Var.a(true, q0.c());
        }
    }

    class i extends b3 {
        i(o0 o0Var) {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            x xVar = z3.a().c;
            ((c2) xVar).c = false;
            e1.a().b(new c2.e());
        }
    }

    class j extends b3 {
        j(o0 o0Var) {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            z3.a().f230a.b();
        }
    }

    class k extends b3 {
        final /* synthetic */ long d;

        k(o0 o0Var, long j) {
            this.d = j;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            z3.a().f230a.a(this.d);
        }
    }

    class l extends b3 {
        l() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            o0.this.e();
        }
    }

    class m extends b3 {
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ Map j;

        m(long j2, long j3, long j4, int i2, String str, String str2, Map map) {
            this.d = j2;
            this.e = j3;
            this.f = j4;
            this.g = i2;
            this.h = str;
            this.i = str2;
            this.j = map;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            o0.a(o0.this, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    class n extends b3 {

        class a extends b3 {
            a(n nVar) {
            }

            @Override // com.flurry.sdk.b3
            public final void a() {
                ((c2) z3.a().c).c = true;
            }
        }

        n() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            if (o0.this.B && z3.a().f230a != null) {
                z3.a().f230a.c();
            }
            if (z3.a().c != null) {
                e1.a().b(new a(this));
            }
        }
    }

    class o extends b3 {
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ Map j;

        o(long j2, long j3, long j4, int i2, String str, String str2, Map map) {
            this.d = j2;
            this.e = j3;
            this.f = j4;
            this.g = i2;
            this.h = str;
            this.i = str2;
            this.j = map;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.flurry.sdk.o0.a(com.flurry.sdk.o0, boolean, long):void
         arg types: [com.flurry.sdk.o0, int, long]
         candidates:
          com.flurry.sdk.o0.a(long, long, com.flurry.sdk.h0):com.flurry.sdk.m0
          com.flurry.sdk.o0.a(com.flurry.sdk.o0, boolean, long):void */
        @Override // com.flurry.sdk.b3
        public final void a() {
            o0.a(o0.this, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            o0.this.a(false, this.d);
        }
    }

    class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f168a;
        final /* synthetic */ Map b;

        p(o0 o0Var, String str, Map map) {
            this.f168a = str;
            this.b = map;
        }

        public final void run() {
            z3.a().f230a.a(this.f168a, this.b);
        }
    }

    static /* synthetic */ class q {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f169a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            int[] iArr = new int[ec.a.a().length];
            f169a = iArr;
            iArr[ec.a.f116a - 1] = 1;
            f169a[ec.a.b - 1] = 2;
            f169a[ec.a.c - 1] = 3;
            try {
                f169a[ec.a.d - 1] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public o0() {
        n1.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.D);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        return;
     */
    public synchronized void d() {
        z2.a();
        s1.a(4, E, "Loading persistent session report data.");
        List<m0> a2 = this.m.a();
        if (a2 != null) {
            this.c.addAll(a2);
        } else if (this.l.exists()) {
            s1.a(4, E, "Legacy persistent agent data found, converting.");
            p0 a3 = b.a(this.l);
            if (a3 != null) {
                boolean z2 = a3.b;
                long j2 = a3.c;
                if (j2 <= 0) {
                    q0.a();
                    j2 = q0.c();
                }
                this.n = z2;
                this.o = j2;
                e();
                List unmodifiableList = Collections.unmodifiableList(a3.f174a);
                if (unmodifiableList != null) {
                    this.c.addAll(unmodifiableList);
                }
            }
            this.l.delete();
            f();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        SharedPreferences.Editor edit = e1.a().f110a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putBoolean("com.flurry.sdk.previous_successful_report", this.n);
        edit.putLong("com.flurry.sdk.initial_run_time", this.o);
        edit.putString("com.flurry.sdk.api_key", e1.a().e);
        edit.apply();
    }

    private static String c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null && i2 < 1000) {
                    sb.append(readLine);
                    sb.append("\n");
                    i2++;
                }
            }
            return sb.toString();
        } catch (IOException e2) {
            String str = E;
            s1.a(6, str, "There was an issue grabbing logcat. " + e2.getMessage());
            return "";
        }
    }

    private synchronized void f() {
        s1.a(4, E, "Saving persistent agent data.");
        this.m.a(this.c);
    }

    private synchronized void g() {
        a(false);
        q0.a();
        long c2 = q0.c();
        long e2 = q0.e();
        long g2 = q0.g();
        int k2 = q0.k() - 1;
        String h2 = q0.h();
        String i2 = q0.i();
        Map<String, String> j2 = q0.j();
        if (this.B && z3.a().f230a != null) {
            e1.a().b(new k(this, c2));
        }
        e1.a().b(new l());
        if (bs.e().a()) {
            e1.a().b(new m(c2, e2, g2, k2, h2, i2, j2));
        }
    }

    public final synchronized void b() {
        g();
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context) {
        Bundle extras;
        if ((context instanceof Activity) && (extras = ((Activity) context).getIntent().getExtras()) != null) {
            String str = E;
            s1.a(3, str, "Launch Options Bundle is present " + extras.toString());
            for (String str2 : extras.keySet()) {
                if (str2 != null) {
                    Object obj = extras.get(str2);
                    String obj2 = obj != null ? obj.toString() : "null";
                    this.d.put(str2, Collections.singletonList(obj2));
                    String str3 = E;
                    s1.a(3, str3, "Launch options Key: " + str2 + ". Its value: " + obj2);
                }
            }
        }
    }

    private synchronized void b(long j2) {
        for (j0 j0Var : this.g) {
            if (j0Var.e && !j0Var.f) {
                j0Var.a(j2);
            }
        }
    }

    static /* synthetic */ void e(o0 o0Var) {
        boolean z2;
        long j2;
        int i2;
        z2.a();
        File fileStreamPath = e1.a().f110a.getFileStreamPath(".yflurrynativecrash");
        String[] a2 = y2.a(fileStreamPath, Pattern.compile(".*" + Pattern.quote(".dmp") + "$"));
        for (String str : a2) {
            s1.a(3, E, "Native crash occurred in previous session! Found minidump file - ".concat(String.valueOf(str)));
            String a3 = ep.a(fileStreamPath, str);
            boolean z3 = true;
            if (TextUtils.isEmpty(a3)) {
                s1.a(6, E, "There was no breadcrumbs file associated with the minidump file.");
                z2 = true;
            } else {
                z2 = false;
            }
            s1.a(2, E, "Breadcrumbs file associated with minidump file - ".concat(String.valueOf(a3)));
            String a4 = ep.a(a3);
            String b2 = ep.b(a3);
            if (TextUtils.isEmpty(a4)) {
                s1.a(6, E, "There is no session id specified with crash breadcrumbs file: ".concat(String.valueOf(a3)));
                z2 = true;
            }
            long j3 = 0;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                j3 = Long.parseLong(a4);
                j2 = Long.parseLong(b2);
            } catch (NumberFormatException unused) {
                s1.a(6, E, "Issue parsing session id into start time: ".concat(String.valueOf(a4)));
                j2 = currentTimeMillis;
                z2 = true;
            }
            h0 h0Var = new h0(1, j2, "native", "", "", null, null, null);
            h0Var.j = c();
            File file = new File(fileStreamPath, a3);
            if (file.exists()) {
                List<e3> a5 = new f3(file).a();
                s1.a(2, E, "Number of crash breadcrumbs - " + a5.size());
                h0Var.a(a5);
                file.delete();
                z3 = z2;
                i2 = 6;
            } else {
                i2 = 6;
                s1.a(6, E, "Breadcrumbs file does not exist.");
            }
            File file2 = new File(fileStreamPath, str);
            if (!file2.exists()) {
                s1.a(6, E, "Minidump file doesn't exist.");
            } else if (z3) {
                s1.a(i2, E, "Some error occurred with minidump file. Deleting it.");
                file2.delete();
            } else {
                h0Var.k = y2.c(file2);
                file2.delete();
                m0 a6 = o0Var.a(j3, j2 - j3, h0Var);
                if (a6 != null) {
                    o0Var.c.add(a6);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @TargetApi(18)
    public final void a(boolean z2) {
        int i2;
        String str;
        int i3;
        String str2;
        if (z2) {
            this.e.put("boot.time", Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                this.e.put("disk.size.total.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.e.put("disk.size.available.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.e.put("disk.size.total.external", Long.toString(statFs2.getAvailableBlocksLong()));
                this.e.put("disk.size.available.external", Long.toString(statFs2.getAvailableBlocksLong()));
            } else {
                this.e.put("disk.size.total.internal", Long.toString((long) statFs.getAvailableBlocks()));
                this.e.put("disk.size.available.internal", Long.toString((long) statFs.getAvailableBlocks()));
                this.e.put("disk.size.total.external", Long.toString((long) statFs2.getAvailableBlocks()));
                this.e.put("disk.size.available.external", Long.toString((long) statFs2.getAvailableBlocks()));
            }
            Map<String, String> map = this.e;
            x0.a();
            map.put("carrier.name", x0.b());
            Map<String, String> map2 = this.e;
            x0.a();
            map2.put("carrier.details", x0.c());
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) e1.a().f110a.getSystemService("activity")).getMemoryInfo(memoryInfo);
        Map<String, String> map3 = this.e;
        StringBuilder sb = new StringBuilder("memory.available");
        String str3 = ".start";
        sb.append(z2 ? str3 : ".end");
        map3.put(sb.toString(), Long.toString(memoryInfo.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            Map<String, String> map4 = this.e;
            StringBuilder sb2 = new StringBuilder("memory.total");
            if (z2) {
                str2 = str3;
            } else {
                str2 = ".end";
            }
            sb2.append(str2);
            map4.put(sb2.toString(), Long.toString(memoryInfo.availMem));
        }
        boolean z3 = false;
        int i4 = -1;
        try {
            Intent registerReceiver = e1.a().f110a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                if (intExtra == 2 || intExtra == 5) {
                    z3 = true;
                }
                i3 = registerReceiver.getIntExtra("level", -1);
                try {
                    i2 = registerReceiver.getIntExtra("scale", -1);
                    i4 = i3;
                } catch (Exception e2) {
                    e = e2;
                    s1.a(5, E, "Error getting battery status: ".concat(String.valueOf(e)));
                    i4 = i3;
                    i2 = -1;
                    float f2 = ((float) i4) / ((float) i2);
                    Map<String, String> map5 = this.e;
                    StringBuilder sb3 = new StringBuilder("battery.charging");
                    if (!z2) {
                    }
                    sb3.append(str);
                    map5.put(sb3.toString(), Boolean.toString(z3));
                    Map<String, String> map6 = this.e;
                    StringBuilder sb4 = new StringBuilder("battery.remaining");
                    if (!z2) {
                    }
                    sb4.append(str3);
                    map6.put(sb4.toString(), Float.toString(f2));
                    if (!r1.b().f187a) {
                    }
                }
                float f22 = ((float) i4) / ((float) i2);
                Map<String, String> map52 = this.e;
                StringBuilder sb32 = new StringBuilder("battery.charging");
                if (!z2) {
                    str = str3;
                } else {
                    str = ".end";
                }
                sb32.append(str);
                map52.put(sb32.toString(), Boolean.toString(z3));
                Map<String, String> map62 = this.e;
                StringBuilder sb42 = new StringBuilder("battery.remaining");
                if (!z2) {
                    str3 = ".end";
                }
                sb42.append(str3);
                map62.put(sb42.toString(), Float.toString(f22));
                if (!r1.b().f187a) {
                    String a2 = r1.b().a();
                    this.e.put("instantapp.name", a2 != null ? a2 : "instant app");
                    s1.c(E, "instantAppName: ".concat(String.valueOf(a2)));
                    return;
                }
                return;
            }
        } catch (Exception e3) {
            e = e3;
            i3 = -1;
            s1.a(5, E, "Error getting battery status: ".concat(String.valueOf(e)));
            i4 = i3;
            i2 = -1;
            float f222 = ((float) i4) / ((float) i2);
            Map<String, String> map522 = this.e;
            StringBuilder sb322 = new StringBuilder("battery.charging");
            if (!z2) {
            }
            sb322.append(str);
            map522.put(sb322.toString(), Boolean.toString(z3));
            Map<String, String> map622 = this.e;
            StringBuilder sb422 = new StringBuilder("battery.remaining");
            if (!z2) {
            }
            sb422.append(str3);
            map622.put(sb422.toString(), Float.toString(f222));
            if (!r1.b().f187a) {
            }
        }
        i2 = -1;
        float f2222 = ((float) i4) / ((float) i2);
        Map<String, String> map5222 = this.e;
        StringBuilder sb3222 = new StringBuilder("battery.charging");
        if (!z2) {
        }
        sb3222.append(str);
        map5222.put(sb3222.toString(), Boolean.toString(z3));
        Map<String, String> map6222 = this.e;
        StringBuilder sb4222 = new StringBuilder("battery.remaining");
        if (!z2) {
        }
        sb4222.append(str3);
        map6222.put(sb4222.toString(), Float.toString(f2222));
        if (!r1.b().f187a) {
        }
    }

    static /* synthetic */ void d(o0 o0Var) {
        SharedPreferences sharedPreferences = e1.a().f110a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        o0Var.n = sharedPreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        q0.a();
        o0Var.o = sharedPreferences.getLong("com.flurry.sdk.initial_run_time", q0.c());
        o0Var.p = sharedPreferences.getString("com.flurry.sdk.api_key", "");
        o0Var.q = sharedPreferences.getString("com.flurry.sdk.variant_ids", null);
        if (TextUtils.isEmpty(o0Var.p) && o0Var.o > 0) {
            o0Var.p = e1.a().e;
        } else if (!o0Var.p.equals(e1.a().e)) {
            q0.a();
            o0Var.o = q0.c();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z2, long j2) {
        if (!this.B) {
            s1.a(3, E, "Analytics disabled, not sending agent report.");
        } else if (z2 || !this.c.isEmpty()) {
            String str = E;
            s1.a(3, str, "generating agent report with " + this.c.size() + " session reports.");
            byte[] bArr = null;
            try {
                bArr = new k0(e1.a().e, y0.b().a(), this.n, bs.e().d(), this.o, j2, this.c, Collections.unmodifiableMap(bs.e().b), this.j.a(), this.d, g1.b().a(), System.currentTimeMillis(), t2.a(), this.A).f148a;
            } catch (Exception e2) {
                s1.e(E, "Exception while generating report: ".concat(String.valueOf(e2)));
            }
            if (bArr == null) {
                s1.e(E, "Error generating report");
            } else {
                String str2 = E;
                s1.a(3, str2, "generated report of size " + bArr.length + " with " + this.c.size() + " reports.");
                l0 l0Var = z3.a().b;
                StringBuilder sb = new StringBuilder();
                sb.append(f1.a());
                l0Var.b(bArr, e1.a().e, sb.toString());
            }
            this.c.clear();
            this.m.b();
        }
    }

    public final synchronized void a() {
        this.v = x2.a();
        if (z3.a().c != null) {
            e1.a().b(new i(this));
        }
        if (this.B && z3.a().f230a != null) {
            e1.a().b(new j(this));
        }
    }

    private synchronized m0 a(long j2, long j3, long j4, int i2, String str, String str2, Map<String, String> map) {
        m0 m0Var;
        n0 n0Var = new n0();
        n0Var.s = ((Boolean) t2.a().a("IncludeBackgroundSessionsInMetrics")).booleanValue();
        if (this.A) {
            n0Var.r = ep.a.BACKGROUND.e;
        } else {
            n0Var.r = ep.a.ACTIVE.e;
        }
        n0Var.f162a = y0.b().a();
        n0Var.b = j2;
        n0Var.c = j3;
        n0Var.d = j4;
        n0Var.e = this.e;
        n0Var.f = str;
        n0Var.g = str2;
        n0Var.h = map;
        u0.a();
        n0Var.i = u0.b();
        u0.a();
        n0Var.j = TimeZone.getDefault().getID();
        n0Var.k = i2;
        n0Var.l = this.v != -1 ? this.v : x2.a();
        n0Var.m = this.s == null ? "" : this.s;
        n0Var.n = v0.d().c();
        n0Var.o = this.z;
        n0Var.x = ep.a(e1.a().f110a).i;
        n0Var.p = this.t;
        n0Var.q = this.u;
        n0Var.t = this.f;
        List<j0> list = this.g;
        String str3 = E;
        s1.a(3, str3, "Total events in session report: " + list.size());
        n0Var.u = list;
        n0Var.w = this.w;
        n0Var.z = this.h;
        n0Var.y = this.y;
        String str4 = E;
        s1.a(3, str4, "Total errors in session report: " + this.y);
        n0Var.v = this.i;
        n0Var.A = this.q;
        m0Var = null;
        try {
            m0Var = new m0(n0Var);
        } catch (IOException e2) {
            s1.a(5, E, "Error creating analytics session report: ".concat(String.valueOf(e2)));
        }
        if (m0Var == null) {
            s1.e(E, "New session report wasn't created");
        }
        return m0Var;
    }

    private synchronized m0 a(long j2, long j3, h0 h0Var) {
        m0 m0Var;
        n0 n0Var = new n0();
        n0Var.s = false;
        n0Var.r = ep.a.UNKNOWN.e;
        n0Var.f162a = y0.b().a();
        n0Var.b = j2;
        n0Var.c = j3;
        n0Var.d = 0;
        m0Var = null;
        n0Var.e = null;
        n0Var.f = null;
        n0Var.g = null;
        n0Var.h = null;
        n0Var.i = "";
        n0Var.j = "";
        n0Var.k = by.a.f75a - 1;
        n0Var.l = 0;
        n0Var.m = "";
        n0Var.n = null;
        n0Var.o = 0;
        n0Var.x = ep.a(e1.a().f110a).i;
        n0Var.p = -1;
        n0Var.q = null;
        n0Var.t = null;
        n0Var.u = null;
        n0Var.w = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(h0Var);
        n0Var.z = arrayList;
        n0Var.y = arrayList.size();
        String str = E;
        s1.a(3, str, "Total errors in native crash session report: " + arrayList.size());
        n0Var.v = new ArrayList();
        n0Var.A = null;
        try {
            m0Var = new m0(n0Var);
        } catch (IOException e2) {
            s1.a(5, E, "Error creating analytics native crash session report: ".concat(String.valueOf(e2)));
        }
        if (m0Var == null) {
            s1.e(E, "New native crash session report wasn't created");
        }
        return m0Var;
    }

    public final synchronized void a(long j2) {
        n1.a().a(this.C);
        q0.a();
        b(q0.e());
        e1.a().b(new n());
        if (bs.e().a()) {
            q0.a();
            e1.a().b(new o(j2, q0.e(), q0.g(), q0.k() - 1, q0.h(), q0.i(), q0.j()));
        }
        t2.a().b("Gender", this);
        t2.a().b("UserId", this);
        t2.a().b("Age", this);
        t2.a().b("LogEvents", this);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        char c2;
        switch (str.hashCode()) {
            case -1752163738:
                if (str.equals("UserId")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -738063011:
                if (str.equals("LogEvents")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 65759:
                if (str.equals("Age")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 2129321697:
                if (str.equals("Gender")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            this.r = ((Boolean) obj).booleanValue();
            String str2 = E;
            s1.a(4, str2, "onSettingUpdate, LogEvents = " + this.r);
        } else if (c2 == 1) {
            this.s = (String) obj;
            String str3 = E;
            s1.a(4, str3, "onSettingUpdate, UserId = " + this.s);
        } else if (c2 == 2) {
            this.t = ((Byte) obj).byteValue();
            String str4 = E;
            s1.a(4, str4, "onSettingUpdate, Gender = " + ((int) this.t));
        } else if (c2 == 3) {
            this.u = (Long) obj;
            String str5 = E;
            s1.a(4, str5, "onSettingUpdate, Birthdate = " + this.u);
        } else if (c2 != 4) {
            s1.a(6, E, "onSettingUpdate internal error!");
        } else {
            this.B = ((Boolean) obj).booleanValue();
            String str6 = E;
            s1.a(4, str6, "onSettingUpdate, AnalyticsEnabled = " + this.B);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x016b, code lost:
        return r0;
     */
    public final synchronized FlurryEventRecordStatus a(String str, Map<String, String> map, boolean z2, int i2) {
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
        if (!this.B) {
            FlurryEventRecordStatus flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventAnalyticsDisabled;
            s1.e(E, "Analytics has been disabled, not logging event.");
            return flurryEventRecordStatus2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        q0.a();
        long d2 = elapsedRealtime - q0.d();
        String b2 = z2.b(str);
        if (b2.length() == 0) {
            return FlurryEventRecordStatus.kFlurryEventFailed;
        }
        i0 i0Var = this.f.get(b2);
        if (i0Var != null) {
            i0Var.f138a++;
            s1.e(E, "Event count incremented: ".concat(String.valueOf(b2)));
            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
        } else if (this.f.size() < F) {
            i0 i0Var2 = new i0();
            i0Var2.f138a = 1;
            this.f.put(b2, i0Var2);
            s1.e(E, "Event count started: ".concat(String.valueOf(b2)));
        } else {
            s1.e(E, "Too many different events. Event not counted: ".concat(String.valueOf(b2)));
            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventUniqueCountExceeded;
        }
        if (!this.r || this.g.size() >= H || this.x >= I) {
            this.w = false;
        } else {
            Map<String, String> emptyMap = map == null ? Collections.emptyMap() : map;
            if (emptyMap.size() - i2 > G) {
                s1.e(E, "MaxEventParams exceeded: " + (emptyMap.size() - i2));
                flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
            } else {
                j0 j0Var = new j0(this.f165a.incrementAndGet(), b2, emptyMap, d2, z2);
                if (j0Var.b().length + this.x <= I) {
                    this.g.add(j0Var);
                    this.x += j0Var.b().length;
                    FlurryEventRecordStatus flurryEventRecordStatus3 = FlurryEventRecordStatus.kFlurryEventRecorded;
                    if ("Flurry.purchase".equals(b2)) {
                        Map<String, String> a2 = j0Var.a();
                        String str2 = a2.get("fl.OrderJSON");
                        String str3 = a2.get("fl.OrderJSONSignature");
                        if (!(str2 == null || str3 == null)) {
                            a2.remove("fl.OrderJSON");
                            a2.remove("fl.OrderJSONSignature");
                            j0Var.b(a2);
                            this.i.add(str3 + 10 + str2);
                        }
                    }
                    if (this.B && z3.a().f230a != null) {
                        e1.a().b(new p(this, b2, emptyMap));
                    }
                    flurryEventRecordStatus = flurryEventRecordStatus3;
                } else {
                    this.x = I;
                    this.w = false;
                    s1.e(E, "Event Log size exceeded. No more event details logged.");
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventLogCountExceeded;
                }
            }
        }
    }

    public final synchronized void a(String str, Map<String, String> map) {
        boolean z2;
        for (j0 j0Var : this.g) {
            if (!j0Var.e || j0Var.g != 0 || !j0Var.c.equals(str)) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                q0.a();
                long d2 = elapsedRealtime - q0.d();
                if (map != null && map.size() > 0 && this.x < I) {
                    int length = this.x - j0Var.b().length;
                    HashMap hashMap = new HashMap(j0Var.a());
                    j0Var.a(map);
                    if (j0Var.b().length + length > I) {
                        j0Var.b(hashMap);
                        this.w = false;
                        this.x = I;
                        s1.e(E, "Event Log size exceeded. No more event details logged.");
                    } else if (j0Var.a().size() > G) {
                        String str2 = E;
                        s1.e(str2, "MaxEventParams exceeded on endEvent: " + j0Var.a().size());
                        j0Var.b(hashMap);
                    } else {
                        this.x = length + j0Var.b().length;
                    }
                }
                j0Var.a(d2);
                return;
            }
        }
    }

    public final synchronized void a(x3 x3Var) {
        int i2 = 0;
        boolean z2 = x3Var.f218a != null && "uncaught".equals(x3Var.f218a);
        this.y++;
        if (this.h.size() < J) {
            h0 h0Var = new h0(this.b.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), x3Var.f218a, x3Var.b, x3Var.c, x3Var.d, x3Var.e, x3Var.f);
            h0Var.a(x3Var.g);
            this.h.add(h0Var);
            s1.e(E, "Error logged: " + h0Var.c);
        } else if (z2) {
            while (i2 < this.h.size()) {
                h0 h0Var2 = this.h.get(i2);
                if (h0Var2.c == null || "uncaught".equals(h0Var2.c)) {
                    i2++;
                } else {
                    h0 h0Var3 = new h0(this.b.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), x3Var.f218a, x3Var.b, x3Var.c, x3Var.d, x3Var.e, x3Var.f);
                    h0Var3.a(x3Var.g);
                    this.h.set(i2, h0Var3);
                    return;
                }
            }
        } else {
            s1.e(E, "Max errors logged. No more errors logged.");
        }
    }

    static /* synthetic */ void a(o0 o0Var, long j2, long j3, long j4, int i2, String str, String str2, Map map) {
        m0 a2 = o0Var.a(j2, j3, j4, i2, str, str2, map);
        o0Var.c.clear();
        o0Var.c.add(a2);
        o0Var.f();
    }
}
