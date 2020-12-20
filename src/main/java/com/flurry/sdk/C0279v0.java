package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.flurry.sdk.C0275u2;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"MissingPermission"})
/* renamed from: com.flurry.sdk.v0 */
public class C0279v0 implements C0275u2.AbstractC0276a {

    /* renamed from: j */
    private static final String f771j = "v0";

    /* renamed from: k */
    private static int f772k = -1;

    /* renamed from: l */
    private static int f773l = -1;

    /* renamed from: m */
    private static C0279v0 f774m;

    /* renamed from: a */
    private boolean f775a;

    /* renamed from: b */
    private Location f776b;

    /* renamed from: c */
    private long f777c = 0;

    /* renamed from: d */
    private LocationManager f778d = ((LocationManager) C0118e1.m386a().f361a.getSystemService("location"));

    /* renamed from: e */
    private C0281b f779e = new C0281b();

    /* renamed from: f */
    private Location f780f;

    /* renamed from: g */
    private boolean f781g = false;

    /* renamed from: h */
    private int f782h = 0;

    /* renamed from: i */
    private Timer f783i = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.v0$a */
    public class C0280a extends TimerTask {
        C0280a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (C0279v0.this.f777c > 0 && C0279v0.this.f777c < System.currentTimeMillis()) {
                C0260s1.m686c(4, C0279v0.f771j, "No location received in 90 seconds , stopping LocationManager");
                C0279v0.this.m740p();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.v0$b */
    public class C0281b implements LocationListener {
        public C0281b() {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location != null) {
                C0279v0.this.f780f = location;
            }
            if (C0279v0.m737j(C0279v0.this) >= 3) {
                C0260s1.m686c(4, C0279v0.f771j, "Max location reports reached, stopping");
                C0279v0.this.m740p();
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private C0279v0() {
        C0266t2 e = C0266t2.m703e();
        this.f775a = ((Boolean) e.mo341a("ReportLocation")).booleanValue();
        e.mo342b("ReportLocation", this);
        String str = f771j;
        C0260s1.m686c(4, str, "initSettings, ReportLocation = " + this.f775a);
        this.f776b = (Location) e.mo341a("ExplicitLocation");
        e.mo342b("ExplicitLocation", this);
        C0260s1.m686c(4, str, "initSettings, ExplicitLocation = " + this.f776b);
    }

    /* renamed from: d */
    private Location m731d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f778d.getLastKnownLocation(str);
        }
        return null;
    }

    /* renamed from: e */
    public static synchronized C0279v0 m732e() {
        C0279v0 v0Var;
        synchronized (C0279v0.class) {
            if (f774m == null) {
                f774m = new C0279v0();
            }
            v0Var = f774m;
        }
        return v0Var;
    }

    /* renamed from: f */
    private static boolean m733f(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    /* renamed from: h */
    private static boolean m735h(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* renamed from: i */
    public static int m736i() {
        return f772k;
    }

    /* renamed from: j */
    static /* synthetic */ int m737j(C0279v0 v0Var) {
        int i = v0Var.f782h + 1;
        v0Var.f782h = i;
        return i;
    }

    /* renamed from: k */
    public static int m738k() {
        return f773l;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: p */
    private void m740p() {
        if (this.f781g) {
            this.f778d.removeUpdates(this.f779e);
            this.f782h = 0;
            this.f777c = 0;
            m741q();
            this.f781g = false;
            C0260s1.m686c(4, f771j, "LocationProvider stopped");
        }
    }

    /* renamed from: q */
    private void m741q() {
        C0260s1.m686c(4, f771j, "Unregister location timer");
        Timer timer = this.f783i;
        if (timer != null) {
            timer.cancel();
            this.f783i = null;
        }
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        str.hashCode();
        if (str.equals("ReportLocation")) {
            this.f775a = ((Boolean) obj).booleanValue();
            String str2 = f771j;
            C0260s1.m686c(4, str2, "onSettingUpdate, ReportLocation = " + this.f775a);
        } else if (!str.equals("ExplicitLocation")) {
            C0260s1.m686c(6, f771j, "LocationProvider internal error! Had to be LocationCriteria, ReportLocation or ExplicitLocation key.");
        } else {
            this.f776b = (Location) obj;
            String str3 = f771j;
            C0260s1.m686c(4, str3, "onSettingUpdate, ExplicitLocation = " + this.f776b);
        }
    }

    /* renamed from: l */
    public final synchronized void mo346l() {
        String str = f771j;
        C0260s1.m686c(4, str, "Location update requested");
        if (this.f782h < 3 && !this.f781g && this.f775a && this.f776b == null) {
            Context context = C0118e1.m386a().f361a;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.f782h = 0;
                String str2 = m733f(context) ? "passive" : null;
                if (!TextUtils.isEmpty(str2)) {
                    this.f778d.requestLocationUpdates(str2, 10000, 0.0f, this.f779e, Looper.getMainLooper());
                }
                this.f780f = m731d(str2);
                this.f777c = System.currentTimeMillis() + 90000;
                Timer timer = this.f783i;
                if (timer != null) {
                    timer.cancel();
                    this.f783i = null;
                }
                C0260s1.m686c(4, str, "Register location timer");
                Timer timer2 = new Timer();
                this.f783i = timer2;
                timer2.schedule(new C0280a(), 90000);
                this.f781g = true;
                C0260s1.m686c(4, str, "LocationProvider started");
            }
        }
    }

    /* renamed from: m */
    public final synchronized void mo347m() {
        C0260s1.m686c(4, f771j, "Stop update location requested");
        m740p();
    }

    /* renamed from: n */
    public final Location mo348n() {
        Location location = this.f776b;
        if (location != null) {
            return location;
        }
        Location location2 = null;
        if (this.f775a) {
            Context context = C0118e1.m386a().f361a;
            if (!m733f(context) && !m735h(context)) {
                return null;
            }
            String str = m733f(context) ? "passive" : null;
            if (str != null) {
                Location d = m731d(str);
                if (d != null) {
                    this.f780f = d;
                }
                location2 = this.f780f;
            }
        }
        C0260s1.m686c(4, f771j, "getLocation() = ".concat(String.valueOf(location2)));
        return location2;
    }
}
