package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.flurry.sdk.bs;
import com.flurry.sdk.g;
import com.flurry.sdk.k;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class c0 {
    private static final String h = "c0";
    private static boolean i = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public g f80a;
    private t3 b;
    /* access modifiers changed from: private */
    public d c;
    /* access modifiers changed from: private */
    public o2 d;
    private o3 e;
    /* access modifiers changed from: private */
    public long f;
    /* access modifiers changed from: private */
    public k g;

    class a implements Runnable {
        a() {
        }

        public final void run() {
            g unused = c0.this.f80a = g.d;
            long unused2 = c0.this.f = System.currentTimeMillis();
            k unused3 = c0.this.g = null;
            c0.this.d.b();
            if (!c0.c(c0.this)) {
                c0.this.c.a(c0.this.f80a, false);
            } else {
                c0.this.b();
            }
        }
    }

    class b implements bs.h {
        b() {
        }

        @Override // com.flurry.sdk.bs.h
        public final void a() {
            c0.this.c();
        }
    }

    class c extends TimerTask {
        c() {
        }

        public final void run() {
            c0.this.c();
        }
    }

    public interface d {
        void a(g gVar, boolean z);
    }

    public c0(t3 t3Var, d dVar, o2 o2Var, o3 o3Var) {
        this.b = t3Var;
        this.c = dVar;
        this.d = o2Var;
        this.e = o3Var;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, boolean):org.json.JSONObject
     arg types: [java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, int]
     candidates:
      com.flurry.sdk.o3.a(java.util.List<com.flurry.sdk.n3>, java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>):void
      com.flurry.sdk.o3.a(java.util.Map<com.flurry.sdk.m3, android.util.SparseArray<com.flurry.sdk.n3>>, java.util.Map<com.flurry.sdk.m3, java.util.Map<java.lang.String, com.flurry.sdk.c>>, boolean):org.json.JSONObject */
    /* access modifiers changed from: private */
    public synchronized void c() {
        JSONObject a2;
        s1.a(h, "Fetching Config data.");
        this.b.run();
        g h2 = this.b.h();
        this.f80a = h2;
        if (h2 == g.c) {
            s1.a(h, "Processing Config fetched data.");
            try {
                String str = this.b.h;
                s1.a(h, "JSON body: ".concat(String.valueOf(str)));
                JSONObject jSONObject = new JSONObject(str);
                String d2 = this.b.d();
                String str2 = e1.a().e;
                String optString = jSONObject.optString("requestGuid");
                String optString2 = jSONObject.optString("apiKey");
                if (d2.equals(optString)) {
                    if (str2.equals(optString2)) {
                        List<n3> a3 = j3.a(jSONObject);
                        long optLong = jSONObject.optLong("refreshInSeconds");
                        this.e.d = optLong;
                        if (!v3.a(this.d.d()) || !this.b.c() || this.e.b(a3)) {
                            this.e.a(a3, this.b.c());
                            this.f80a = g.c;
                            o3 o3Var = this.e;
                            Context context = e1.a().f110a;
                            if (!this.b.c()) {
                                str = null;
                            }
                            if (str == null && (a2 = o3Var.a(o3Var.f172a, o3Var.c, false)) != null) {
                                str = a2.toString();
                            }
                            if (str != null) {
                                v3.a(context, str);
                            }
                            o2 o2Var = this.d;
                            String g2 = this.b.g();
                            if (o2Var.f171a != null) {
                                o2Var.f171a.edit().putString("lastETag", g2).apply();
                            }
                            o2 o2Var2 = this.d;
                            String e2 = this.b.e();
                            if (o2Var2.f171a != null) {
                                o2Var2.f171a.edit().putString("lastKeyId", e2).apply();
                            }
                            o2 o2Var3 = this.d;
                            String f2 = this.b.f();
                            if (o2Var3.f171a != null) {
                                o2Var3.f171a.edit().putString("lastRSA", f2).apply();
                            }
                        } else {
                            this.f80a = g.d;
                        }
                        i = true;
                        o2 o2Var4 = this.d;
                        String c2 = this.e.c();
                        if (o2Var4.f171a != null) {
                            s1.a(o2.f, "Save serized variant IDs: ".concat(String.valueOf(c2)));
                            o2Var4.f171a.edit().putString("com.flurry.sdk.variant_ids", c2).apply();
                        }
                        o2 o2Var5 = this.d;
                        if (o2Var5.f171a != null) {
                            o2Var5.f171a.edit().putInt("appVersion", o2Var5.b).apply();
                        }
                        this.d.a(System.currentTimeMillis());
                        o2 o2Var6 = this.d;
                        long j = optLong * 1000;
                        if (j == 0) {
                            o2Var6.c = 0;
                        } else if (j > 604800000) {
                            o2Var6.c = 604800000;
                        } else if (j < 60000) {
                            o2Var6.c = 60000;
                        } else {
                            o2Var6.c = j;
                        }
                        if (o2Var6.f171a != null) {
                            o2Var6.f171a.edit().putLong("refreshFetch", o2Var6.c).apply();
                        }
                        if (d.e() != null) {
                            d.e();
                            p3.a(this.e);
                        }
                        this.d.b();
                        if (d.e() != null) {
                            d.e();
                            p3.a(this.f80a.b.h, System.currentTimeMillis() - this.f, this.f80a.toString());
                        }
                        this.c.a(this.f80a, false);
                        return;
                    }
                }
                g.a aVar = g.a.AUTHENTICATE;
                this.f80a = new g(aVar, "Guid: " + d2 + ", payload: " + optString + " APIKey: " + str2 + ", payload: " + optString2);
                String str3 = h;
                StringBuilder sb = new StringBuilder("Authentication error: ");
                sb.append(this.f80a);
                s1.b(str3, sb.toString());
                d();
            } catch (JSONException e3) {
                s1.a(h, "Json parse error", e3);
                this.f80a = new g(g.a.NOT_VALID_JSON, e3.toString());
            } catch (Exception e4) {
                s1.a(h, "Fetch result error", e4);
                this.f80a = new g(g.a.OTHER, e4.toString());
            }
        } else if (h2 == g.d) {
            this.d.a(System.currentTimeMillis());
            this.d.b();
            this.c.a(this.f80a, false);
        } else {
            String str4 = h;
            s1.e(str4, "fetch error:" + this.f80a.toString());
            if (this.g == null && this.f80a.b == g.a.UNKNOWN_CERTIFICATE) {
                com.flurry.android.b.a("FlurryUnknownCertificate", this.f80a.f125a, h);
            }
            if (d.e() != null) {
                d.e();
                p3.a(this.f80a.b.h, System.currentTimeMillis() - this.f, this.f80a.toString());
            }
            d();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void b() {
        if (bs.e().a()) {
            c();
            return;
        }
        s1.a(h, "Waiting for ID provider.");
        bs.e().a(new b());
    }

    private void d() {
        s1.a(h, "Retry fetching Config data.");
        k kVar = this.g;
        if (kVar == null) {
            this.g = new k(k.a.values()[0]);
        } else {
            this.g = new k(kVar.f146a.a());
        }
        if (this.g.f146a == k.a.ABANDON) {
            this.c.a(this.f80a, false);
            return;
        }
        this.c.a(this.f80a, true);
        this.d.a(new c(), ((long) this.g.a()) * 1000);
    }

    public final synchronized void a() {
        s1.a(h, "Starting Config fetch.");
        t3.a(new a());
    }

    static /* synthetic */ boolean c(c0 c0Var) {
        if (!v3.a(e1.a().f110a)) {
            return true;
        }
        String str = h;
        s1.a(str, "Compare version: current=" + c0Var.d.b + ", recorded=" + c0Var.d.a());
        int a2 = c0Var.d.a();
        o2 o2Var = c0Var.d;
        if (a2 < o2Var.b) {
            return true;
        }
        long j = o2Var.c;
        long j2 = 0;
        if (j != 0) {
            SharedPreferences sharedPreferences = o2Var.f171a;
            if (sharedPreferences != null) {
                j2 = sharedPreferences.getLong("lastFetch", 0);
            }
            if (System.currentTimeMillis() - j2 > j) {
                return true;
            }
        } else if (!i) {
            return true;
        }
        s1.a(h, "It does not meet any criterias for data fetch.");
        return false;
    }
}
