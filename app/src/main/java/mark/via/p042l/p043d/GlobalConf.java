package mark.via.p042l.p043d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.HashMap;
import mark.via.p042l.ConfManager;
import mark.via.preference.PreferenceManager;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ConfUtil;
import mark.via.utils.RomUtils;
import mark.via.utils.WebViewUtil;

/* renamed from: mark.via.l.d.c */
/* compiled from: GlobalConf */
public class GlobalConf {

    /* renamed from: a */
    public static int f1401a;

    /* renamed from: b */
    public static boolean f1402b;

    /* renamed from: c */
    public static boolean f1403c;

    /* renamed from: d */
    public static boolean f1404d;

    /* renamed from: e */
    public static boolean f1405e;

    /* renamed from: f */
    public static boolean f1406f;

    /* renamed from: g */
    public static boolean f1407g;

    /* renamed from: h */
    public static boolean f1408h;

    /* renamed from: i */
    public static boolean f1409i;

    /* renamed from: j */
    public static boolean f1410j;

    /* renamed from: k */
    public static boolean f1411k;

    /* renamed from: l */
    public static boolean f1412l;

    /* renamed from: m */
    public static boolean f1413m;

    /* renamed from: n */
    public static boolean f1414n;

    /* renamed from: o */
    public static boolean f1415o;

    /* renamed from: p */
    public static String f1416p;

    /* renamed from: q */
    public static String f1417q;

    /* renamed from: r */
    public static int f1418r;

    /* renamed from: s */
    public static int f1419s;

    /* renamed from: t */
    public static HashMap<String, SiteConf> f1420t = new HashMap<>();

    /* renamed from: a */
    public static void m1915a(Context context) {
        PackageInfo b;
        String str;
        int indexOf;
        boolean z = true;
        f1401a++;
        ConfManager.f1398c = "g" + f1401a;
        PreferenceManager M = PreferenceManager.m1743M(context);
        f1416p = M.mo1071D();
        int i = Build.VERSION.SDK_INT;
        f1408h = i >= 26 || !RomUtils.m2191c();
        f1403c = M.mo1119U();
        f1404d = M.mo1143e0();
        f1407g = M.mo1100N();
        f1406f = (M.mo1092K() && BrowserUtils.m2095p(context) == 2) || (!M.mo1092K() && M.mo1157j());
        f1418r = M.mo1170n0();
        f1405e = M.mo1190u() || M.mo1095L();
        f1409i = M.mo1135b0();
        f1410j = M.mo1089J();
        f1402b = M.mo1138c0();
        M.mo1132a0();
        f1411k = M.mo1200x0();
        f1412l = M.mo1154i();
        f1419s = M.mo1185s0();
        f1413m = M.mo1129Z(context);
        f1417q = ConfUtil.m2115b(f1419s, M.mo1188t0(null), f1402b);
        f1415o = M.mo1142e();
        f1414n = false;
        if (i >= 29 && (b = WebViewUtil.m2042b()) != null && (indexOf = (str = b.versionName).indexOf(46)) > 0) {
            try {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                if (parseInt < 80) {
                    if (parseInt >= 30 || parseInt < 10) {
                        z = false;
                    }
                }
                f1414n = z;
            } catch (NumberFormatException unused) {
            }
        }
    }
}
