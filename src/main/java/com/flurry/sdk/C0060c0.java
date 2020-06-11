package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.flurry.android.C0004b;
import com.flurry.sdk.C0044bs;
import com.flurry.sdk.C0143g;
import com.flurry.sdk.C0171k;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.c0 */
public class C0060c0 {

    /* renamed from: h */
    private static final String f195h = "c0";

    /* renamed from: i */
    private static boolean f196i = false;

    /* renamed from: a */
    private C0143g f197a;

    /* renamed from: b */
    private AbstractRunnableC0267t3 f198b;

    /* renamed from: c */
    private AbstractC0064d f199c;

    /* renamed from: d */
    private C0225o2 f200d;

    /* renamed from: e */
    private C0226o3 f201e;

    /* renamed from: f */
    private long f202f;

    /* renamed from: g */
    private C0171k f203g;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.c0$a */
    public class RunnableC0061a implements Runnable {
        RunnableC0061a() {
        }

        public final void run() {
            C0060c0.this.f197a = C0143g.f437d;
            C0060c0.this.f202f = System.currentTimeMillis();
            C0060c0.this.f203g = null;
            C0060c0.this.f200d.mo293d();
            if (!C0060c0.m270h(C0060c0.this)) {
                C0060c0.this.f199c.mo138a(C0060c0.this.f197a, false);
            } else {
                C0060c0.this.m268f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.c0$b */
    public class C0062b implements C0044bs.AbstractC0053h {
        C0062b() {
        }

        @Override // com.flurry.sdk.C0044bs.AbstractC0053h
        /* renamed from: a */
        public final void mo129a() {
            C0060c0.this.m269g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.c0$c */
    public class C0063c extends TimerTask {
        C0063c() {
        }

        public final void run() {
            C0060c0.this.m269g();
        }
    }

    /* renamed from: com.flurry.sdk.c0$d */
    public interface AbstractC0064d {
        /* renamed from: a */
        void mo138a(C0143g gVar, boolean z);
    }

    public C0060c0(AbstractRunnableC0267t3 t3Var, AbstractC0064d dVar, C0225o2 o2Var, C0226o3 o3Var) {
        this.f198b = t3Var;
        this.f199c = dVar;
        this.f200d = o2Var;
        this.f201e = o3Var;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private synchronized void m268f() {
        if (C0044bs.m232a().mo124g()) {
            m269g();
            return;
        }
        C0260s1.m688e(f195h, "Waiting for ID provider.");
        C0044bs.m232a().mo123b(new C0062b());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: g */
    private synchronized void m269g() {
        JSONObject c;
        String str = f195h;
        C0260s1.m688e(str, "Fetching Config data.");
        this.f198b.run();
        C0143g j = this.f198b.mo334j();
        this.f197a = j;
        C0143g gVar = C0143g.f436c;
        if (j == gVar) {
            C0260s1.m688e(str, "Processing Config fetched data.");
            try {
                String str2 = this.f198b.f757h;
                C0260s1.m688e(str, "JSON body: ".concat(String.valueOf(str2)));
                JSONObject jSONObject = new JSONObject(str2);
                String f = this.f198b.mo330f();
                String str3 = C0118e1.m386a().f365e;
                String optString = jSONObject.optString("requestGuid");
                String optString2 = jSONObject.optString("apiKey");
                if (f.equals(optString)) {
                    if (str3.equals(optString2)) {
                        List<C0202n3> a = C0170j3.m494a(jSONObject);
                        long optLong = jSONObject.optLong("refreshInSeconds");
                        this.f201e.f667d = optLong;
                        if (!C0284v3.m751e(this.f200d.mo295f()) || !this.f198b.mo324e() || this.f201e.mo302m(a)) {
                            this.f201e.mo300j(a, this.f198b.mo324e());
                            this.f197a = gVar;
                            C0226o3 o3Var = this.f201e;
                            Context context = C0118e1.m386a().f361a;
                            if (!this.f198b.mo324e()) {
                                str2 = null;
                            }
                            if (str2 == null && (c = o3Var.mo297c(o3Var.f664a, o3Var.f666c, false)) != null) {
                                str2 = c.toString();
                            }
                            if (str2 != null) {
                                C0284v3.m747a(context, str2);
                            }
                            C0225o2 o2Var = this.f200d;
                            String i = this.f198b.mo333i();
                            SharedPreferences sharedPreferences = o2Var.f658a;
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putString("lastETag", i).apply();
                            }
                            C0225o2 o2Var2 = this.f200d;
                            String g = this.f198b.mo331g();
                            SharedPreferences sharedPreferences2 = o2Var2.f658a;
                            if (sharedPreferences2 != null) {
                                sharedPreferences2.edit().putString("lastKeyId", g).apply();
                            }
                            C0225o2 o2Var3 = this.f200d;
                            String h = this.f198b.mo332h();
                            SharedPreferences sharedPreferences3 = o2Var3.f658a;
                            if (sharedPreferences3 != null) {
                                sharedPreferences3.edit().putString("lastRSA", h).apply();
                            }
                        } else {
                            this.f197a = C0143g.f437d;
                        }
                        f196i = true;
                        C0225o2 o2Var4 = this.f200d;
                        String n = this.f201e.mo303n();
                        if (o2Var4.f658a != null) {
                            C0260s1.m688e(C0225o2.f657f, "Save serized variant IDs: ".concat(String.valueOf(n)));
                            o2Var4.f658a.edit().putString("com.flurry.sdk.variant_ids", n).apply();
                        }
                        C0225o2 o2Var5 = this.f200d;
                        SharedPreferences sharedPreferences4 = o2Var5.f658a;
                        if (sharedPreferences4 != null) {
                            sharedPreferences4.edit().putInt("appVersion", o2Var5.f659b).apply();
                        }
                        this.f200d.mo291b(System.currentTimeMillis());
                        C0225o2 o2Var6 = this.f200d;
                        long j2 = optLong * 1000;
                        if (j2 == 0) {
                            o2Var6.f660c = 0;
                        } else if (j2 > 604800000) {
                            o2Var6.f660c = 604800000;
                        } else if (j2 < 60000) {
                            o2Var6.f660c = 60000;
                        } else {
                            o2Var6.f660c = j2;
                        }
                        SharedPreferences sharedPreferences5 = o2Var6.f658a;
                        if (sharedPreferences5 != null) {
                            sharedPreferences5.edit().putLong("refreshFetch", o2Var6.f660c).apply();
                        }
                        if (C0088d.m320f() != null) {
                            C0088d.m320f();
                            C0233p3.m623b(this.f201e);
                        }
                        this.f200d.mo293d();
                        if (C0088d.m320f() != null) {
                            C0088d.m320f();
                            C0233p3.m622a(this.f197a.f439b.f448h, System.currentTimeMillis() - this.f202f, this.f197a.toString());
                        }
                        this.f199c.mo138a(this.f197a, false);
                        return;
                    }
                }
                C0143g.EnumC0144a aVar = C0143g.EnumC0144a.AUTHENTICATE;
                this.f197a = new C0143g(aVar, "Guid: " + f + ", payload: " + optString + " APIKey: " + str3 + ", payload: " + optString2);
                StringBuilder sb = new StringBuilder("Authentication error: ");
                sb.append(this.f197a);
                C0260s1.m693j(str, sb.toString());
                m272j();
            } catch (JSONException e) {
                C0260s1.m689f(f195h, "Json parse error", e);
                this.f197a = new C0143g(C0143g.EnumC0144a.NOT_VALID_JSON, e.toString());
            } catch (Exception e2) {
                C0260s1.m689f(f195h, "Fetch result error", e2);
                this.f197a = new C0143g(C0143g.EnumC0144a.OTHER, e2.toString());
            }
        } else if (j == C0143g.f437d) {
            this.f200d.mo291b(System.currentTimeMillis());
            this.f200d.mo293d();
            this.f199c.mo138a(this.f197a, false);
        } else {
            C0260s1.m701r(str, "fetch error:" + this.f197a.toString());
            if (this.f203g == null) {
                C0143g gVar2 = this.f197a;
                if (gVar2.f439b == C0143g.EnumC0144a.UNKNOWN_CERTIFICATE) {
                    C0004b.m138j("FlurryUnknownCertificate", gVar2.f438a, str);
                }
            }
            if (C0088d.m320f() != null) {
                C0088d.m320f();
                C0233p3.m622a(this.f197a.f439b.f448h, System.currentTimeMillis() - this.f202f, this.f197a.toString());
            }
            m272j();
        }
    }

    /* renamed from: h */
    static /* synthetic */ boolean m270h(C0060c0 c0Var) {
        if (!C0284v3.m750d(C0118e1.m386a().f361a)) {
            return true;
        }
        String str = f195h;
        C0260s1.m688e(str, "Compare version: current=" + c0Var.f200d.f659b + ", recorded=" + c0Var.f200d.mo290a());
        int a = c0Var.f200d.mo290a();
        C0225o2 o2Var = c0Var.f200d;
        if (a < o2Var.f659b) {
            return true;
        }
        long j = o2Var.f660c;
        long j2 = 0;
        if (j != 0) {
            SharedPreferences sharedPreferences = o2Var.f658a;
            if (sharedPreferences != null) {
                j2 = sharedPreferences.getLong("lastFetch", 0);
            }
            if (System.currentTimeMillis() - j2 > j) {
                return true;
            }
        } else if (!f196i) {
            return true;
        }
        C0260s1.m688e(str, "It does not meet any criterias for data fetch.");
        return false;
    }

    /* renamed from: j */
    private void m272j() {
        C0260s1.m688e(f195h, "Retry fetching Config data.");
        C0171k kVar = this.f203g;
        if (kVar == null) {
            this.f203g = new C0171k(C0171k.EnumC0172a.values()[0]);
        } else {
            this.f203g = new C0171k(kVar.f513a.mo251a());
        }
        if (this.f203g.f513a == C0171k.EnumC0172a.ABANDON) {
            this.f199c.mo138a(this.f197a, false);
            return;
        }
        this.f199c.mo138a(this.f197a, true);
        this.f200d.mo292c(new C0063c(), ((long) this.f203g.mo250a()) * 1000);
    }

    /* renamed from: d */
    public final synchronized void mo135d() {
        C0260s1.m688e(f195h, "Starting Config fetch.");
        AbstractRunnableC0267t3.m704b(new RunnableC0061a());
    }
}
