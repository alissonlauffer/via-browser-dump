package mark.via.f;

import a.a.b.p.d;
import a.a.b.p.g;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import java.util.Random;
import mark.via.BrowserApp;
import mark.via.d.b;
import mark.via.util.c;
import mark.via.util.f;
import mark.via.util.i;

/* compiled from: PreferenceManager */
public class a {
    private static a b;
    private static SharedPreferences c;

    /* renamed from: a  reason: collision with root package name */
    private int f251a = 0;

    /* renamed from: mark.via.f.a$a  reason: collision with other inner class name */
    /* compiled from: PreferenceManager */
    public static class C0028a {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f252a = {"adblockplus", "imageswitch", "blockimages", "hidestatus", "java", "locationaccess", "passwords", "incognitoMode", "volume", "requestdesktopsite", "searchhint", "donottrack", "colormode", "pulltorefresh", "nightcss", "backforwardgesture", "hidesearchpart", "blockpopup", "forcetozoom", "powerfulcache", "webpagedebug", "autovideobtn", "3rdcookies"};
        public static final String[] b = {"download", "home", "searchurl", "userAgentString", "csstheme", "taghome", "bghome"};
        public static final String[] c = {"fullscreenmode", "searchweb", "textsize", "agentchoose", "screenOrientation", "keyback", "keyforward", "keyhome", "keytab", "keymenu", "gesturetoolbarleft", "gesturetoolbarright", "urlbox", "appui", "fghome", "logochioce", "homeskinchioce", "urlbarcolor", "fabdirection", "restoreclosedtabs", "encode"};
    }

    private a(Context context) {
        c = BrowserApp.a(context).getSharedPreferences("settings", 0);
    }

    private int a(int i, int i2, int i3, int i4) {
        return (i < i3 || i > i2) ? i4 : i;
    }

    public static a b(Context context) {
        if (b == null) {
            b = new a(context);
        }
        return b;
    }

    public void A(int i) {
        a("agentchoose", i);
    }

    public void B(int i) {
        a("adblockedtimes", b() + i);
    }

    public boolean C() {
        return System.currentTimeMillis() < c.getLong("sslts", 0);
    }

    public boolean D() {
        return c.getBoolean("imageswitch", false);
    }

    public boolean E() {
        return c.getBoolean("incognitoMode", false);
    }

    public boolean F() {
        return c.getBoolean("java", true);
    }

    public int G() {
        return c.getInt("keyback", 2);
    }

    public int H() {
        return c.getInt("keyforward", 3);
    }

    public int I() {
        return c.getInt("keyhome", 4);
    }

    public int J() {
        return c.getInt("keymenu", 1);
    }

    public int K() {
        return c.getInt("keytab", 5);
    }

    public long L() {
        return c.getLong("lastcleantime", System.currentTimeMillis());
    }

    public boolean M() {
        return c.getBoolean("locationaccess", false);
    }

    public boolean N() {
        return c.getBoolean("login", false);
    }

    public int O() {
        return c.getInt("logochioce", 0);
    }

    public String P() {
        return c.getString("memory", "");
    }

    public boolean Q() {
        return Build.VERSION.SDK_INT < 29 && c.getBoolean("nightcss", false);
    }

    public boolean R() {
        return c.getBoolean("powerfulcache", false);
    }

    public boolean S() {
        return c.getBoolean("smartback", true);
    }

    public boolean T() {
        return c.getBoolean("requestdesktopsite", false);
    }

    public int U() {
        return c.getInt("restoreclosedtabs", 0);
    }

    public boolean V() {
        return c.getBoolean("passwords", true);
    }

    public long W() {
        return c.getLong("savedata", 0);
    }

    public int X() {
        return c.getInt("screenOrientation", 1);
    }

    public String Y() {
        return c.getString("searchbox", "");
    }

    public int Z() {
        int i;
        if (!c.b() || mark.via.util.a.c()) {
            i = (!mark.via.util.a.c() || k() >= b.c().b()) ? 1 : 6;
        } else {
            i = 2;
        }
        return c.getInt("searchweb", i);
    }

    public boolean a() {
        return c.getBoolean("adblockplus", true);
    }

    public String a0() {
        return c.getString("searchurl", "https://www.google.com/search?q=");
    }

    public int b0() {
        return a(c.getInt("textsize", 3), 5, 1, 3);
    }

    public int c(String str) {
        return c.getInt(str, 0);
    }

    public String c0() {
        return i.c(c.getString("csstheme", "")).trim();
    }

    public boolean d(int i) {
        SharedPreferences sharedPreferences = c;
        return sharedPreferences.getBoolean("guided_" + i, false);
    }

    public int d0() {
        return c.getInt("appui", 0);
    }

    public String e(String str) {
        return c.getString("userAgentString", str);
    }

    public int e0() {
        int i = c.getInt("urlbarcolor", -1);
        if (i < 0) {
            return i;
        }
        y(-1);
        return -1;
    }

    public boolean f() {
        return c.getBoolean("blockimages", false);
    }

    public int f0() {
        return c.getInt("urlbox", 0);
    }

    public void g(boolean z) {
        a("colormode", z);
    }

    public int g0() {
        return c.getInt("agentchoose", 1);
    }

    public int h() {
        return c.getInt("changelogcode", 0);
    }

    public String h0() {
        return c.getString("username", "");
    }

    public void i(int i) {
        a("gesturetoolbarleft", i);
    }

    public String i0() {
        return c.getString("userpsw", "");
    }

    public void j(int i) {
        a("gesturetoolbarright", i);
    }

    public boolean j0() {
        return c.getBoolean("volume", false);
    }

    public void k(boolean z) {
        a("hidestatus", z);
    }

    public boolean k0() {
        return c.getBoolean("webpagedebug", false);
    }

    public boolean l() {
        return c.getBoolean("colormode", true);
    }

    public void l0() {
        a("sslts", System.currentTimeMillis() + 86400000);
    }

    public void m(boolean z) {
        a("imageswitch", z);
    }

    public void m0() {
        a("lastcleantime", System.currentTimeMillis());
    }

    public boolean n() {
        return c.getBoolean("donottrack", true);
    }

    public String o() {
        String trim = c.getString("download", Environment.DIRECTORY_DOWNLOADS).replace("/", "").trim();
        return "".equals(trim) ? Environment.DIRECTORY_DOWNLOADS : trim;
    }

    public void p(String str) {
        a("searchurl", str);
    }

    public void q(boolean z) {
        a("login", z);
    }

    public void r(boolean z) {
        a("nightcss", z);
    }

    public int s() {
        return c.getInt("fullscreenmode", 0);
    }

    public void t(boolean z) {
        a("smartback", z);
    }

    public boolean u() {
        return c.getBoolean("hidestatus", false);
    }

    public String v() {
        return c.getString("home", "about:home");
    }

    public void w(int i) {
        a("textsize", i);
    }

    public int x() {
        String v = v();
        String[] strArr = {"about:home", "about:blank", "about:bookmarks", "about:links"};
        int i = 0;
        while (i < 4) {
            if (!v.equals(strArr[i])) {
                i++;
            } else if (i == 3) {
                return 0;
            } else {
                return i;
            }
        }
        return 3;
    }

    public int y() {
        return c.getInt("fghome", 0);
    }

    public void z(int i) {
        a("urlbox", i);
    }

    public String A() {
        return i.c(c.getString("taghome", "")).trim();
    }

    public boolean B() {
        return c.getBoolean("ignoresecondarysslerror", true);
    }

    public boolean a(Context context) {
        boolean a2 = g.a(context);
        int i = this.f251a;
        int i2 = 2;
        if (i != 0) {
            if (a2 == (i == 2)) {
                if (this.f251a == 2) {
                    return true;
                }
                return false;
            }
        }
        if (!c.contains("nightmode")) {
            if (a2 != c.getBoolean("nightmoderecord", !a2)) {
                a.a.b.j.a.b().a(1, 2, 3, 4, 5);
                a("nightmoderecord", a2);
            }
            if (!a2) {
                i2 = 1;
            }
            this.f251a = i2;
            return a2;
        }
        boolean z = c.getBoolean("nightmode", false);
        if (!z) {
            i2 = 1;
        }
        this.f251a = i2;
        return z;
    }

    public void c(boolean z) {
        a("backforwardgesture", z);
    }

    public String d(String str) {
        return c.getString(str, "");
    }

    public void e(boolean z) {
        a("blockimages", z);
    }

    public void f(boolean z) {
        a("blockpopup", z);
    }

    public boolean g() {
        return c.getBoolean("blockpopup", false);
    }

    public void h(boolean z) {
        a("donottrack", z);
    }

    public void i(boolean z) {
        a("forcetozoom", z);
    }

    public void j(boolean z) {
        a("hidesearchpart", z);
    }

    public void k(String str) {
        a("home", str);
    }

    public void l(String str) {
        a("bghome", i.b(str.trim()));
    }

    public void m(String str) {
        a("taghome", i.b(str.trim()));
    }

    public void n(boolean z) {
        a("incognitoMode", z);
    }

    public void p(int i) {
        a("keyhome", i);
    }

    public void q(int i) {
        a("keymenu", i);
    }

    public void r(String str) {
        a("userAgentString", str);
    }

    public void s(String str) {
        a("username", str);
    }

    public void t(String str) {
        a("userpsw", f.a(str));
    }

    public void u(boolean z) {
        a("requestdesktopsite", z);
    }

    public void v(boolean z) {
        a("passwords", z);
    }

    public void w(boolean z) {
        a("volume", z);
    }

    public void y(int i) {
        if (i >= 0) {
            i = -1;
        }
        a("urlbarcolor", i);
    }

    public int z() {
        return c.getInt("homeskinchioce", 0);
    }

    public boolean c(int i) {
        SharedPreferences sharedPreferences = c;
        return sharedPreferences.getBoolean("cleardatatypeonexit_" + i, false);
    }

    public boolean d() {
        return c.getBoolean("backforwardgesture", true);
    }

    public void e(int i) {
        a("changelogcode", i);
    }

    public void f(String str) {
        a("clipboard", str);
    }

    public void g(int i) {
        a("fabdirection", i);
    }

    public void h(String str) {
        a("download", str.replace("/", "").trim());
    }

    public String i() {
        return c.getString("clipboard", "");
    }

    public void j(String str) {
        a("dltasks", str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.f.a.a(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      mark.via.f.a.a(int, boolean):void
      mark.via.f.a.a(android.content.Context, boolean):void
      mark.via.f.a.a(java.lang.String, int):void
      mark.via.f.a.a(java.lang.String, long):void
      mark.via.f.a.a(java.lang.String, java.lang.String):void
      mark.via.f.a.a(java.lang.String, boolean):void */
    public void k(int i) {
        a("guided_" + i, true);
    }

    public void l(int i) {
        a("fghome", i);
    }

    public void m(int i) {
        a("homeskinchioce", i);
    }

    public void n(String str) {
        a("memory", str);
    }

    public void p(boolean z) {
        a("locationaccess", z);
    }

    public void q(String str) {
        a("csstheme", i.b(str.trim()));
    }

    public void r(int i) {
        a("keytab", i);
    }

    public void s(int i) {
        a("logochioce", i);
    }

    public void t(int i) {
        a("restoreclosedtabs", i);
    }

    public void u(int i) {
        a("screenOrientation", i);
    }

    public void v(int i) {
        a("searchweb", i);
    }

    public String w() {
        return i.c(c.getString("bghome", "")).trim();
    }

    public void x(int i) {
        a("appui", i);
    }

    public boolean b(String str) {
        return c.getBoolean(str, false);
    }

    public boolean c() {
        return c.getBoolean("autovideobtn", false);
    }

    public void d(boolean z) {
        a("3rdcookies", z);
    }

    public boolean e() {
        return c.getBoolean("3rdcookies", false);
    }

    public void f(int i) {
        a("cloudserver", i);
    }

    public void g(String str) {
        a("datachecker", str);
    }

    public void h(int i) {
        a("fullscreenmode", i);
    }

    public void i(String str) {
        a("dlmanager", str);
    }

    public int j() {
        return c.getInt("cloudserver", mark.via.util.a.c() ? 1 : 0);
    }

    public int k() {
        int i = c.getInt("cloudtag", -1);
        if (i >= 1 && i <= 10000) {
            return i;
        }
        int nextInt = new Random().nextInt(10000) + 1;
        a("cloudtag", nextInt);
        return nextInt;
    }

    public void l(boolean z) {
        a("ignoresecondarysslerror", z);
    }

    public String m() {
        return c.getString("datachecker", "");
    }

    public void n(int i) {
        a("keyback", i);
    }

    public String p() {
        return c.getString("dlmanager", "");
    }

    public String q() {
        return c.getString("dltasks", "");
    }

    public int r() {
        return c.getInt("fabdirection", 0);
    }

    public void s(boolean z) {
        a("powerfulcache", z);
    }

    public boolean t() {
        return c.getBoolean("hidesearchpart", false);
    }

    public void x(boolean z) {
        a("webpagedebug", z);
    }

    public int b() {
        return c.getInt("adblockedtimes", 0);
    }

    public void o(boolean z) {
        a("java", z);
    }

    public boolean b(int i) {
        boolean z = (i == 3 || i == 4) ? false : true;
        SharedPreferences sharedPreferences = c;
        return sharedPreferences.getBoolean("cleardatatype_" + i, z);
    }

    public void o(int i) {
        a("keyforward", i);
    }

    public void b(int i, boolean z) {
        a("cleardatatypeonexit_" + i, z);
    }

    public void o(String str) {
        a("searchbox", str);
    }

    public void b(boolean z) {
        a("autovideobtn", z);
    }

    public void a(Context context, boolean z) {
        boolean a2 = g.a(context);
        int i = 2;
        if (z == a2) {
            if (c.contains("nightmode")) {
                c.edit().remove("nightmode").apply();
            }
            if (!a2) {
                i = 1;
            }
            this.f251a = i;
        } else {
            a("nightmode", z);
            if (!z) {
                i = 1;
            }
            this.f251a = i;
        }
        a("nightmoderecord", z);
    }

    public void a(String str, boolean z) {
        if (str != null) {
            d.a("update: ", str, ", new: ", Boolean.valueOf(z));
            c.edit().putBoolean(str, z).apply();
        }
    }

    public void a(String str, int i) {
        if (str != null) {
            d.a("update: ", str, ", new: ", Integer.valueOf(i));
            c.edit().putInt(str, i).apply();
        }
    }

    public void a(String str, String str2) {
        if (str != null) {
            d.a("update: ", str, ", new: ", str2);
            c.edit().putString(str, str2).apply();
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            d.a("update: ", str, ", new: ", Long.valueOf(j));
            c.edit().putLong(str, j).apply();
        }
    }

    public void a(boolean z) {
        a("adblockplus", z);
    }

    public boolean a(String str) {
        return c.contains(str);
    }

    public void a(int i) {
        a("savedata", W() + ((long) i));
    }

    public void a(int i, boolean z) {
        a("cleardatatype_" + i, z);
    }

    public void a(long j) {
        String q = q();
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        if (!q.isEmpty()) {
            sb.append(",");
            sb.append(q);
        }
        j(sb.toString());
    }
}
