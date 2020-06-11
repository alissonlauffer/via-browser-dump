package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.flurry.sdk.u2;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"MissingPermission"})
public class v0 implements u2.a {
    /* access modifiers changed from: private */
    public static final String j = "v0";
    private static int k = -1;
    private static int l = -1;
    private static v0 m;

    /* renamed from: a  reason: collision with root package name */
    private boolean f201a;
    private Location b;
    /* access modifiers changed from: private */
    public long c = 0;
    private LocationManager d = ((LocationManager) e1.a().f110a.getSystemService("location"));
    private b e = new b();
    /* access modifiers changed from: private */
    public Location f;
    private boolean g = false;
    private int h = 0;
    private Timer i = null;

    class a extends TimerTask {
        a() {
        }

        public final void run() {
            if (v0.this.c > 0 && v0.this.c < System.currentTimeMillis()) {
                s1.a(4, v0.j, "No location received in 90 seconds , stopping LocationManager");
                v0.this.h();
            }
        }
    }

    class b implements LocationListener {
        public b() {
        }

        public final void onLocationChanged(Location location) {
            if (location != null) {
                Location unused = v0.this.f = location;
            }
            if (v0.c(v0.this) >= 3) {
                s1.a(4, v0.j, "Max location reports reached, stopping");
                v0.this.h();
            }
        }

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
     arg types: [java.lang.String, com.flurry.sdk.v0]
     candidates:
      com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
      com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
    private v0() {
        t2 a2 = t2.a();
        this.f201a = ((Boolean) a2.a("ReportLocation")).booleanValue();
        a2.a("ReportLocation", (u2.a) this);
        String str = j;
        s1.a(4, str, "initSettings, ReportLocation = " + this.f201a);
        this.b = (Location) a2.a("ExplicitLocation");
        a2.a("ExplicitLocation", (u2.a) this);
        String str2 = j;
        s1.a(4, str2, "initSettings, ExplicitLocation = " + this.b);
    }

    static /* synthetic */ int c(v0 v0Var) {
        int i2 = v0Var.h + 1;
        v0Var.h = i2;
        return i2;
    }

    public static synchronized v0 d() {
        v0 v0Var;
        synchronized (v0.class) {
            if (m == null) {
                m = new v0();
            }
            v0Var = m;
        }
        return v0Var;
    }

    public static int e() {
        return k;
    }

    public static int f() {
        return l;
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.g) {
            this.d.removeUpdates(this.e);
            this.h = 0;
            this.c = 0;
            i();
            this.g = false;
            s1.a(4, j, "LocationProvider stopped");
        }
    }

    private void i() {
        s1.a(4, j, "Unregister location timer");
        Timer timer = this.i;
        if (timer != null) {
            timer.cancel();
            this.i = null;
        }
    }

    private static boolean b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public final Location c() {
        Location location = this.b;
        if (location != null) {
            return location;
        }
        Location location2 = null;
        if (this.f201a) {
            Context context = e1.a().f110a;
            if (!a(context) && !b(context)) {
                return null;
            }
            String str = a(context) ? "passive" : null;
            if (str != null) {
                Location a2 = a(str);
                if (a2 != null) {
                    this.f = a2;
                }
                location2 = this.f;
            }
        }
        s1.a(4, j, "getLocation() = ".concat(String.valueOf(location2)));
        return location2;
    }

    public final synchronized void a() {
        s1.a(4, j, "Location update requested");
        if (this.h < 3 && !this.g && this.f201a && this.b == null) {
            Context context = e1.a().f110a;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.h = 0;
                String str = a(context) ? "passive" : null;
                if (!TextUtils.isEmpty(str)) {
                    this.d.requestLocationUpdates(str, 10000, 0.0f, this.e, Looper.getMainLooper());
                }
                this.f = a(str);
                this.c = System.currentTimeMillis() + 90000;
                if (this.i != null) {
                    this.i.cancel();
                    this.i = null;
                }
                s1.a(4, j, "Register location timer");
                Timer timer = new Timer();
                this.i = timer;
                timer.schedule(new a(), 90000);
                this.g = true;
                s1.a(4, j, "LocationProvider started");
            }
        }
    }

    public final synchronized void b() {
        s1.a(4, j, "Stop update location requested");
        h();
    }

    private static boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private Location a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.d.getLastKnownLocation(str);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != -864112343) {
            if (hashCode == -300729815 && str.equals("ExplicitLocation")) {
                c2 = 1;
                if (c2 == 0) {
                    this.f201a = ((Boolean) obj).booleanValue();
                    String str2 = j;
                    s1.a(4, str2, "onSettingUpdate, ReportLocation = " + this.f201a);
                    return;
                } else if (c2 != 1) {
                    s1.a(6, j, "LocationProvider internal error! Had to be LocationCriteria, ReportLocation or ExplicitLocation key.");
                    return;
                } else {
                    this.b = (Location) obj;
                    String str3 = j;
                    s1.a(4, str3, "onSettingUpdate, ExplicitLocation = " + this.b);
                    return;
                }
            }
        } else if (str.equals("ReportLocation")) {
            c2 = 0;
            if (c2 == 0) {
            }
        }
        c2 = 65535;
        if (c2 == 0) {
        }
    }
}
