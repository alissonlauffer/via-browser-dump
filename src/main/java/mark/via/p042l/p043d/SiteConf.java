package mark.via.p042l.p043d;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: mark.via.l.d.d */
/* compiled from: SiteConf */
public class SiteConf {

    /* renamed from: a */
    private int f1421a = 0;

    /* renamed from: b */
    private String f1422b = null;

    /* renamed from: c */
    private int f1423c = 0;

    /* renamed from: mark.via.l.d.d$a */
    /* compiled from: SiteConf */
    public static class C0470a {
        /* renamed from: a */
        public static SiteConf m1935a(String str) {
            SiteConf dVar;
            JSONException e;
            if (str == null || str.isEmpty()) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dVar = new SiteConf();
                try {
                    dVar.mo1244r(jSONObject.optString("ua"));
                    dVar.mo1245s(jSONObject.optInt("uac"));
                    dVar.mo1242p(jSONObject.optInt("flag"));
                } catch (JSONException e2) {
                    e = e2;
                }
            } catch (JSONException e3) {
                e = e3;
                dVar = null;
                e.printStackTrace();
                if (dVar != null) {
                }
                return dVar;
            }
            if (dVar != null || !dVar.mo1237j()) {
                return dVar;
            }
            return null;
        }

        /* renamed from: b */
        public static String m1936b(SiteConf dVar) {
            if (dVar == null || dVar.mo1237j()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ua", dVar.mo1230c(null));
                if (dVar.mo1231d() != 0) {
                    jSONObject.put("uac", dVar.mo1231d());
                }
                jSONObject.put("flag", dVar.mo1229b());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    /* renamed from: a */
    private boolean m1916a(int i, boolean z) {
        if (i < 0 || i > 15) {
            return z;
        }
        int i2 = (this.f1423c >>> (i << 1)) & 3;
        if (i2 == 2) {
            return false;
        }
        if (i2 != 3) {
            return z;
        }
        return true;
    }

    /* renamed from: m */
    private void m1917m(int i, boolean z) {
        if (i >= 0 && i <= 15) {
            int i2 = i << 1;
            int i3 = this.f1423c | (2 << i2);
            this.f1423c = i3;
            if (z) {
                this.f1423c = (1 << i2) | i3;
            } else {
                this.f1423c = ((1 << i2) ^ -1) & i3;
            }
        }
    }

    /* renamed from: b */
    public int mo1229b() {
        return this.f1423c;
    }

    /* renamed from: c */
    public String mo1230c(String str) {
        String str2 = this.f1422b;
        return (str2 == null || str2.isEmpty()) ? str : this.f1422b;
    }

    /* renamed from: d */
    public int mo1231d() {
        return this.f1421a;
    }

    /* renamed from: e */
    public boolean mo1232e(boolean z) {
        return m1916a(4, z);
    }

    /* renamed from: f */
    public boolean mo1233f(boolean z) {
        return m1916a(2, z);
    }

    /* renamed from: g */
    public boolean mo1234g(boolean z) {
        return m1916a(3, z);
    }

    /* renamed from: h */
    public boolean mo1235h() {
        return m1916a(0, false);
    }

    /* renamed from: i */
    public boolean mo1236i(boolean z) {
        return m1916a(1, z);
    }

    /* renamed from: j */
    public boolean mo1237j() {
        String str = this.f1422b;
        return (str == null || str.isEmpty()) && (this.f1423c >> 2) == 0 && this.f1421a == -1;
    }

    /* renamed from: k */
    public void mo1238k(boolean z) {
        m1917m(4, z);
    }

    /* renamed from: l */
    public void mo1239l(boolean z) {
        m1917m(2, z);
    }

    /* renamed from: n */
    public void mo1240n(boolean z) {
        m1917m(3, z);
    }

    /* renamed from: o */
    public void mo1241o(boolean z) {
        m1917m(0, z);
    }

    /* renamed from: p */
    public void mo1242p(int i) {
        this.f1423c = i;
    }

    /* renamed from: q */
    public void mo1243q(boolean z) {
        m1917m(1, z);
    }

    /* renamed from: r */
    public void mo1244r(String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        this.f1422b = str;
    }

    /* renamed from: s */
    public void mo1245s(int i) {
        this.f1421a = i;
    }

    public String toString() {
        return "SiteConf{uaChoice=" + this.f1421a + ", ua='" + this.f1422b + "', flag=" + Integer.toBinaryString(this.f1423c) + '}';
    }
}
