package mark.via.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import java.util.Random;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.util.SupportUtil;
import mark.via.BrowserApp;
import mark.via.flurry.FlurryRemoteConfig;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.utils.AppUtils;
import mark.via.utils.ChannelUtils;
import mark.via.utils.EncodeUtils;
import mark.via.utils.InfoUtils;

/* renamed from: mark.via.j.a */
/* compiled from: PreferenceManager */
public class PreferenceManager {

    /* renamed from: b */
    private static PreferenceManager f1385b;

    /* renamed from: c */
    private static SharedPreferences f1386c;

    /* renamed from: a */
    private int f1387a = 0;

    /* renamed from: mark.via.j.a$a */
    /* compiled from: PreferenceManager */
    public static class C0465a {

        /* renamed from: a */
        public static final String[] f1388a = {"adblockplus", "imageswitch", "blockimages", "hidestatus", "java", "locationaccess", "passwords", "incognitoMode", "volume", "requestdesktopsite", "searchhint", "donottrack", "colormode", "pulltorefresh", "nightcss", "backforwardgesture", "hidesearchpart", "blockpopup", "forcetozoom", "powerfulcache", "webpagedebug", "autovideobtn", "3rdcookies"};

        /* renamed from: b */
        public static final String[] f1389b = {"download", "home", "searchurl", "userAgentString", "csstheme", "taghome", "bghome"};

        /* renamed from: c */
        public static final String[] f1390c = {"fullscreenmode", "searchweb", "textsize", "agentchoose", "screenOrientation", "keyback", "keyforward", "keyhome", "keytab", "keymenu", "gesturetoolbarleft", "gesturetoolbarright", "urlbox", "appui", "fghome", "logochioce", "homeskinchioce", "urlbarcolor", "fabdirection", "restoreclosedtabs", "encode", "cleardata2", "cleardataonexit2"};
    }

    private PreferenceManager(Context context) {
        f1386c = BrowserApp.m1387a(context).getSharedPreferences("settings", 0);
    }

    /* renamed from: M */
    public static PreferenceManager m1743M(Context context) {
        if (f1385b == null) {
            f1385b = new PreferenceManager(context);
        }
        return f1385b;
    }

    /* renamed from: d */
    private int m1744d(int i, int i2, int i3, int i4) {
        return (i < i3 || i > i2) ? i4 : i;
    }

    /* renamed from: A */
    public boolean mo1062A(int i) {
        SharedPreferences sharedPreferences = f1386c;
        return sharedPreferences.getBoolean("guided_" + i, false);
    }

    /* renamed from: A0 */
    public void mo1063A0(String str, long j) {
        if (str != null) {
            f1386c.edit().putLong(str, j).apply();
        }
    }

    /* renamed from: A1 */
    public void mo1064A1(boolean z) {
        mo1203y0("passwords", z);
    }

    /* renamed from: B */
    public boolean mo1065B() {
        return f1386c.getBoolean("hidesearchpart", false);
    }

    /* renamed from: B0 */
    public void mo1066B0(String str, String str2) {
        if (str != null) {
            f1386c.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: B1 */
    public void mo1067B1(int i) {
        mo1206z0("screenOrientation", i);
    }

    /* renamed from: C */
    public boolean mo1068C() {
        return f1386c.getBoolean("hidestatus", false);
    }

    /* renamed from: C0 */
    public void mo1069C0(boolean z) {
        mo1203y0("adblockplus", z);
        GlobalConf.f1415o = z;
    }

    /* renamed from: C1 */
    public void mo1070C1(String str) {
        mo1066B0("searchbox", str);
    }

    /* renamed from: D */
    public String mo1071D() {
        return f1386c.getString("home", "about:home");
    }

    /* renamed from: D0 */
    public void mo1072D0(boolean z) {
        mo1203y0("autovideobtn", z);
    }

    /* renamed from: D1 */
    public void mo1073D1(int i) {
        mo1206z0("searchweb", i);
    }

    /* renamed from: E */
    public String mo1074E() {
        return InfoUtils.m2170i(f1386c.getString("bghome", "")).trim();
    }

    /* renamed from: E0 */
    public void mo1075E0(boolean z) {
        mo1203y0("backforwardgesture", z);
    }

    /* renamed from: E1 */
    public void mo1076E1(String str) {
        mo1066B0("searchurl", str);
    }

    /* renamed from: F */
    public int mo1077F() {
        String D = mo1071D();
        String[] strArr = {"about:home", "about:blank", "about:bookmarks", "about:links"};
        for (int i = 0; i < 4; i++) {
            if (D.equals(strArr[i])) {
                if (i == 3) {
                    return 0;
                } else {
                    return i;
                }
            }
        }
        return 3;
    }

    /* renamed from: F0 */
    public void mo1078F0(boolean z) {
        mo1203y0("3rdcookies", z);
    }

    /* renamed from: F1 */
    public void mo1079F1(int i) {
        mo1206z0("textsize", i);
    }

    /* renamed from: G */
    public int mo1080G() {
        return f1386c.getInt("fghome", 0);
    }

    /* renamed from: G0 */
    public void mo1081G0(boolean z) {
        mo1203y0("blockimages", z);
    }

    /* renamed from: G1 */
    public void mo1082G1(String str) {
        mo1066B0("csstheme", InfoUtils.m2169h(str.trim()));
    }

    /* renamed from: H */
    public int mo1083H() {
        return f1386c.getInt("homeskinchioce", 0);
    }

    /* renamed from: H0 */
    public void mo1084H0(boolean z) {
        mo1203y0("blockpopup", z);
    }

    /* renamed from: H1 */
    public void mo1085H1(int i) {
        mo1206z0("appui", i);
    }

    /* renamed from: I */
    public String mo1086I() {
        return InfoUtils.m2170i(f1386c.getString("taghome", "")).trim();
    }

    /* renamed from: I0 */
    public void mo1087I0(boolean z) {
        mo1203y0("builtin", z);
    }

    /* renamed from: I1 */
    public void mo1088I1(int i) {
        if (i >= 0) {
            i = -1;
        }
        mo1206z0("urlbarcolor", i);
    }

    /* renamed from: J */
    public boolean mo1089J() {
        return f1386c.getBoolean("ignoresecondarysslerror", true);
    }

    /* renamed from: J0 */
    public void mo1090J0(int i) {
        mo1206z0("changelogcode", i);
    }

    /* renamed from: J1 */
    public void mo1091J1(int i) {
        mo1206z0("urlbox", i);
    }

    /* renamed from: K */
    public boolean mo1092K() {
        return f1386c.getBoolean("imageswitch", false);
    }

    /* renamed from: K0 */
    public void mo1093K0(int i) {
        mo1206z0("cleardata2", i);
    }

    /* renamed from: K1 */
    public void mo1094K1(int i) {
        mo1206z0("agentchoose", i);
    }

    /* renamed from: L */
    public boolean mo1095L() {
        return f1386c.getBoolean("incognitoMode", false);
    }

    /* renamed from: L0 */
    public void mo1096L0(int i) {
        mo1206z0("cleardataonexit2", i);
    }

    /* renamed from: L1 */
    public void mo1097L1(String str) {
        mo1066B0("userAgentString", str);
    }

    /* renamed from: M0 */
    public void mo1098M0(String str) {
        mo1066B0("clipboard", str);
    }

    /* renamed from: M1 */
    public void mo1099M1(String str) {
        mo1066B0("username", str);
    }

    /* renamed from: N */
    public boolean mo1100N() {
        return f1386c.getBoolean("java", true);
    }

    /* renamed from: N0 */
    public void mo1101N0(int i) {
        mo1206z0("cloudserver", i);
    }

    /* renamed from: N1 */
    public void mo1102N1(String str) {
        mo1066B0("userpsw", EncodeUtils.m2139a(str));
    }

    /* renamed from: O */
    public int mo1103O() {
        return f1386c.getInt("keyback", 2);
    }

    /* renamed from: O0 */
    public void mo1104O0(boolean z) {
        mo1203y0("colormode", z);
    }

    /* renamed from: O1 */
    public void mo1105O1(boolean z) {
        mo1203y0("volume", z);
    }

    /* renamed from: P */
    public int mo1106P() {
        return f1386c.getInt("keyforward", 3);
    }

    /* renamed from: P0 */
    public void mo1107P0(String str) {
        mo1066B0("datachecker", str);
    }

    /* renamed from: P1 */
    public void mo1108P1(boolean z) {
        mo1203y0("webpagedebug", z);
    }

    /* renamed from: Q */
    public int mo1109Q() {
        return f1386c.getInt("keyhome", 4);
    }

    /* renamed from: Q0 */
    public void mo1110Q0(boolean z) {
        mo1203y0("donottrack", z);
    }

    /* renamed from: Q1 */
    public void mo1111Q1(int i) {
        mo1206z0("adblockedtimes", mo1145f() + i);
    }

    /* renamed from: R */
    public int mo1112R() {
        return f1386c.getInt("keymenu", 1);
    }

    /* renamed from: R0 */
    public void mo1113R0(String str) {
        if (Build.VERSION.SDK_INT < 29) {
            mo1066B0("download", str);
        }
    }

    /* renamed from: R1 */
    public void mo1114R1() {
        mo1063A0("lastcleantime", System.currentTimeMillis());
    }

    /* renamed from: S */
    public int mo1115S() {
        return f1386c.getInt("keytab", 5);
    }

    /* renamed from: S0 */
    public void mo1116S0(String str) {
        mo1066B0("dlmanager", str);
    }

    /* renamed from: T */
    public long mo1117T() {
        return f1386c.getLong("lastcleantime", System.currentTimeMillis());
    }

    /* renamed from: T0 */
    public void mo1118T0(String str) {
        mo1066B0("dltasks", str);
    }

    /* renamed from: U */
    public boolean mo1119U() {
        return f1386c.getBoolean("locationaccess", false);
    }

    /* renamed from: U0 */
    public void mo1120U0(int i) {
        mo1206z0("fabdirection", i);
    }

    /* renamed from: V */
    public boolean mo1121V() {
        return f1386c.getBoolean("login", false);
    }

    /* renamed from: V0 */
    public void mo1122V0(boolean z) {
        mo1203y0("forcetozoom", z);
    }

    /* renamed from: W */
    public int mo1123W() {
        return f1386c.getInt("logochioce", 0);
    }

    /* renamed from: W0 */
    public void mo1124W0(int i) {
        mo1206z0("fullscreenmode", i);
    }

    /* renamed from: X */
    public String mo1125X() {
        return f1386c.getString("memory", "");
    }

    /* renamed from: X0 */
    public void mo1126X0(int i) {
        mo1206z0("gesturetoolbarleft", i);
    }

    /* renamed from: Y */
    public boolean mo1127Y() {
        return Build.VERSION.SDK_INT < 29 && f1386c.getBoolean("nightcss", false);
    }

    /* renamed from: Y0 */
    public void mo1128Y0(int i) {
        mo1206z0("gesturetoolbarright", i);
    }

    /* renamed from: Z */
    public boolean mo1129Z(Context context) {
        boolean a = SupportUtil.m1386a(context);
        int i = this.f1387a;
        int i2 = 2;
        if (i != 0) {
            if (a == (i == 2)) {
                return i == 2;
            }
        }
        if (!f1386c.contains("nightmode")) {
            if (a != f1386c.getBoolean("nightmoderecord", !a)) {
                DataChecker.m1181c().mo668i(1, 2, 3, 4, 5);
                mo1203y0("nightmoderecord", a);
            }
            if (!a) {
                i2 = 1;
            }
            this.f1387a = i2;
            return a;
        }
        boolean z = f1386c.getBoolean("nightmode", false);
        if (!z) {
            i2 = 1;
        }
        this.f1387a = i2;
        return z;
    }

    /* renamed from: Z0 */
    public void mo1130Z0(int i) {
        mo1203y0("guided_" + i, true);
    }

    /* renamed from: a */
    public void mo1131a(long j) {
        String x = mo1199x();
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        if (!x.isEmpty()) {
            sb.append(",");
            sb.append(x);
        }
        mo1118T0(sb.toString());
    }

    /* renamed from: a0 */
    public boolean mo1132a0() {
        return f1386c.getBoolean("powerfulcache", false);
    }

    /* renamed from: a1 */
    public void mo1133a1(boolean z) {
        mo1203y0("hidesearchpart", z);
    }

    /* renamed from: b */
    public void mo1134b(int i) {
        mo1063A0("savedata", mo1146f0() + ((long) i));
    }

    /* renamed from: b0 */
    public boolean mo1135b0() {
        return f1386c.getBoolean("smartback", true);
    }

    /* renamed from: b1 */
    public void mo1136b1(boolean z) {
        mo1203y0("hidestatus", z);
    }

    /* renamed from: c */
    public boolean mo1137c(String str) {
        return f1386c.contains(str);
    }

    /* renamed from: c0 */
    public boolean mo1138c0() {
        return f1386c.getBoolean("requestdesktopsite", false);
    }

    /* renamed from: c1 */
    public void mo1139c1(String str) {
        mo1066B0("home", str);
    }

    /* renamed from: d0 */
    public int mo1140d0() {
        return f1386c.getInt("restoreclosedtabs", 0);
    }

    /* renamed from: d1 */
    public void mo1141d1(String str) {
        mo1066B0("bghome", InfoUtils.m2169h(str.trim()));
    }

    /* renamed from: e */
    public boolean mo1142e() {
        return f1386c.getBoolean("adblockplus", true);
    }

    /* renamed from: e0 */
    public boolean mo1143e0() {
        return f1386c.getBoolean("passwords", true);
    }

    /* renamed from: e1 */
    public void mo1144e1(int i) {
        mo1206z0("fghome", i);
    }

    /* renamed from: f */
    public int mo1145f() {
        return f1386c.getInt("adblockedtimes", 0);
    }

    /* renamed from: f0 */
    public long mo1146f0() {
        return f1386c.getLong("savedata", 0);
    }

    /* renamed from: f1 */
    public void mo1147f1(int i) {
        mo1206z0("homeskinchioce", i);
    }

    /* renamed from: g */
    public boolean mo1148g() {
        return f1386c.getBoolean("autovideobtn", false);
    }

    /* renamed from: g0 */
    public int mo1149g0() {
        return f1386c.getInt("screenOrientation", 1);
    }

    /* renamed from: g1 */
    public void mo1150g1(String str) {
        mo1066B0("taghome", InfoUtils.m2169h(str.trim()));
    }

    /* renamed from: h */
    public boolean mo1151h() {
        return f1386c.getBoolean("backforwardgesture", true);
    }

    /* renamed from: h0 */
    public String mo1152h0() {
        return f1386c.getString("searchbox", "");
    }

    /* renamed from: h1 */
    public void mo1153h1(boolean z) {
        mo1203y0("ignoresecondarysslerror", z);
    }

    /* renamed from: i */
    public boolean mo1154i() {
        return f1386c.getBoolean("3rdcookies", false);
    }

    /* renamed from: i0 */
    public int mo1155i0() {
        int i;
        if (!ChannelUtils.m2108c() || AppUtils.m2060h()) {
            i = (!AppUtils.m2060h() || mo1181r() >= FlurryRemoteConfig.m1694c().mo1047e()) ? 1 : 6;
        } else {
            i = 2;
        }
        return f1386c.getInt("searchweb", i);
    }

    /* renamed from: i1 */
    public void mo1156i1(boolean z) {
        mo1203y0("imageswitch", z);
    }

    /* renamed from: j */
    public boolean mo1157j() {
        return f1386c.getBoolean("blockimages", false);
    }

    /* renamed from: j0 */
    public String mo1158j0() {
        return f1386c.getString("searchurl", "https://www.google.com/search?q=");
    }

    /* renamed from: j1 */
    public void mo1159j1(boolean z) {
        mo1203y0("incognitoMode", z);
    }

    /* renamed from: k */
    public boolean mo1160k() {
        return f1386c.getBoolean("blockpopup", false);
    }

    /* renamed from: k0 */
    public boolean mo1161k0(String str) {
        return f1386c.getBoolean(str, false);
    }

    /* renamed from: k1 */
    public void mo1162k1(boolean z) {
        mo1203y0("java", z);
    }

    /* renamed from: l */
    public boolean mo1163l() {
        return f1386c.getBoolean("builtin", true);
    }

    /* renamed from: l0 */
    public int mo1164l0(String str) {
        return f1386c.getInt(str, 0);
    }

    /* renamed from: l1 */
    public void mo1165l1(int i) {
        mo1206z0("keyback", i);
    }

    /* renamed from: m */
    public int mo1166m() {
        return f1386c.getInt("changelogcode", 0);
    }

    /* renamed from: m0 */
    public String mo1167m0(String str) {
        return f1386c.getString(str, "");
    }

    /* renamed from: m1 */
    public void mo1168m1(int i) {
        mo1206z0("keyforward", i);
    }

    /* renamed from: n */
    public int mo1169n() {
        return f1386c.getInt("cleardata2", 7);
    }

    /* renamed from: n0 */
    public int mo1170n0() {
        return m1744d(f1386c.getInt("textsize", 3), 5, 1, 3);
    }

    /* renamed from: n1 */
    public void mo1171n1(int i) {
        mo1206z0("keyhome", i);
    }

    /* renamed from: o */
    public int mo1172o() {
        return f1386c.getInt("cleardataonexit2", 0);
    }

    /* renamed from: o0 */
    public String mo1173o0() {
        return InfoUtils.m2170i(f1386c.getString("csstheme", "")).trim();
    }

    /* renamed from: o1 */
    public void mo1174o1(int i) {
        mo1206z0("keymenu", i);
    }

    /* renamed from: p */
    public String mo1175p() {
        return f1386c.getString("clipboard", "");
    }

    /* renamed from: p0 */
    public int mo1176p0() {
        return f1386c.getInt("appui", 0);
    }

    /* renamed from: p1 */
    public void mo1177p1(int i) {
        mo1206z0("keytab", i);
    }

    /* renamed from: q */
    public int mo1178q() {
        return f1386c.getInt("cloudserver", AppUtils.m2060h() ? 1 : 0);
    }

    /* renamed from: q0 */
    public int mo1179q0() {
        int i = f1386c.getInt("urlbarcolor", -1);
        if (i < 0) {
            return i;
        }
        mo1088I1(-1);
        return -1;
    }

    /* renamed from: q1 */
    public void mo1180q1(boolean z) {
        mo1203y0("locationaccess", z);
    }

    /* renamed from: r */
    public int mo1181r() {
        int i = f1386c.getInt("cloudtag", -1);
        if (i >= 1 && i <= 10000) {
            return i;
        }
        int nextInt = new Random().nextInt(10000) + 1;
        mo1206z0("cloudtag", nextInt);
        return nextInt;
    }

    /* renamed from: r0 */
    public int mo1182r0() {
        return f1386c.getInt("urlbox", 0);
    }

    /* renamed from: r1 */
    public void mo1183r1(boolean z) {
        mo1203y0("login", z);
    }

    /* renamed from: s */
    public boolean mo1184s() {
        return f1386c.getBoolean("colormode", true);
    }

    /* renamed from: s0 */
    public int mo1185s0() {
        return f1386c.getInt("agentchoose", 1);
    }

    /* renamed from: s1 */
    public void mo1186s1(int i) {
        mo1206z0("logochioce", i);
    }

    /* renamed from: t */
    public String mo1187t() {
        return f1386c.getString("datachecker", "");
    }

    /* renamed from: t0 */
    public String mo1188t0(String str) {
        return f1386c.getString("userAgentString", str);
    }

    /* renamed from: t1 */
    public void mo1189t1(String str) {
        mo1066B0("memory", str);
    }

    /* renamed from: u */
    public boolean mo1190u() {
        return f1386c.getBoolean("donottrack", true);
    }

    /* renamed from: u0 */
    public String mo1191u0() {
        return f1386c.getString("username", "");
    }

    /* renamed from: u1 */
    public void mo1192u1(boolean z) {
        mo1203y0("nightcss", z);
    }

    /* renamed from: v */
    public String mo1193v() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Environment.DIRECTORY_DOWNLOADS;
        }
        String trim = f1386c.getString("download", Environment.DIRECTORY_DOWNLOADS).replace("/", "").trim();
        return "".equals(trim) ? Environment.DIRECTORY_DOWNLOADS : trim;
    }

    /* renamed from: v0 */
    public String mo1194v0() {
        return f1386c.getString("userpsw", "");
    }

    /* renamed from: v1 */
    public void mo1195v1(Context context, boolean z) {
        boolean a = SupportUtil.m1386a(context);
        int i = 2;
        if (z == a) {
            if (f1386c.contains("nightmode")) {
                f1386c.edit().remove("nightmode").apply();
            }
            if (!a) {
                i = 1;
            }
            this.f1387a = i;
        } else {
            mo1203y0("nightmode", z);
            if (!z) {
                i = 1;
            }
            this.f1387a = i;
        }
        mo1203y0("nightmoderecord", z);
    }

    /* renamed from: w */
    public String mo1196w() {
        return f1386c.getString("dlmanager", "");
    }

    /* renamed from: w0 */
    public boolean mo1197w0() {
        return f1386c.getBoolean("volume", false);
    }

    /* renamed from: w1 */
    public void mo1198w1(boolean z) {
        mo1203y0("powerfulcache", z);
    }

    /* renamed from: x */
    public String mo1199x() {
        return f1386c.getString("dltasks", "");
    }

    /* renamed from: x0 */
    public boolean mo1200x0() {
        return f1386c.getBoolean("webpagedebug", false);
    }

    /* renamed from: x1 */
    public void mo1201x1(boolean z) {
        mo1203y0("smartback", z);
    }

    /* renamed from: y */
    public int mo1202y() {
        return f1386c.getInt("fabdirection", 0);
    }

    /* renamed from: y0 */
    public void mo1203y0(String str, boolean z) {
        if (str != null) {
            f1386c.edit().putBoolean(str, z).apply();
        }
    }

    /* renamed from: y1 */
    public void mo1204y1(boolean z) {
        mo1203y0("requestdesktopsite", z);
    }

    /* renamed from: z */
    public int mo1205z() {
        return f1386c.getInt("fullscreenmode", 0);
    }

    /* renamed from: z0 */
    public void mo1206z0(String str, int i) {
        if (str != null) {
            f1386c.edit().putInt(str, i).apply();
        }
    }

    /* renamed from: z1 */
    public void mo1207z1(int i) {
        mo1206z0("restoreclosedtabs", i);
    }
}
