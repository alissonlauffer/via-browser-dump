package mark.via.utils;

import android.text.TextUtils;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.p042l.p043d.SiteConf;

/* renamed from: mark.via.n.h */
/* compiled from: ConfUtil */
public class ConfUtil {
    /* renamed from: a */
    public static boolean m2114a(String str) {
        SiteConf dVar;
        if (TextUtils.isEmpty(str) || (dVar = GlobalConf.f1420t.get(str)) == null || !dVar.mo1235h()) {
            return GlobalConf.f1402b;
        }
        return dVar.mo1234g(GlobalConf.f1402b);
    }

    /* renamed from: b */
    public static String m2115b(int i, String str, boolean z) {
        if (i == 2) {
            str = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
        } else if (i == 3) {
            str = "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko";
        } else if (i == 4) {
            str = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1 Mobile/15E148 Safari/604.1";
        } else if (i == 5) {
            str = "Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba";
        } else if (i != 6) {
            str = null;
        }
        return (!z || i == 2 || i == 3) ? str : "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
    }

    /* renamed from: c */
    public static boolean m2116c(String str) {
        SiteConf dVar;
        if (TextUtils.isEmpty(str) || (dVar = GlobalConf.f1420t.get(str)) == null || !dVar.mo1235h()) {
            return GlobalConf.f1415o;
        }
        return dVar.mo1232e(GlobalConf.f1415o);
    }

    /* renamed from: d */
    private static boolean m2117d(String str) {
        String n = BrowserUtils.m2093n(str, false);
        if ("forum.softpedia.com".equals(n) || "3g.163.com".equals(n)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m2118e(String str) {
        return GlobalConf.f1409i && !m2117d(str);
    }
}
