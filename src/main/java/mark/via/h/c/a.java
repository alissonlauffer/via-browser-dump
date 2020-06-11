package mark.via.h.c;

import mark.via.refactor.config.SiteConf;

/* compiled from: ConfUtil */
public class a {
    public static byte a(boolean z) {
        return z ? (byte) 2 : 1;
    }

    public static String a(int i, String str, boolean z) {
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

    public static SiteConf a(SiteConf siteConf, mark.via.refactor.config.a aVar) {
        if (siteConf == null || aVar == null) {
            return null;
        }
        if (siteConf.f() != 6 && siteConf.f() == aVar.c()) {
            siteConf.a(0);
        }
        if (b(siteConf.b(), aVar.g())) {
            siteConf.b((byte) 0);
        }
        if (b(siteConf.a(), aVar.f())) {
            siteConf.a((byte) 0);
        }
        if (b(siteConf.d(), aVar.j())) {
            siteConf.c((byte) 0);
        }
        return siteConf;
    }

    public static boolean a(byte b) {
        return b == 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static boolean a(byte b, boolean z) {
        if (z) {
            return b != 1;
        }
        if (b != 2) {
            return false;
        }
    }

    public static SiteConf b(SiteConf siteConf, mark.via.refactor.config.a aVar) {
        if (siteConf == null || aVar == null) {
            return null;
        }
        if (siteConf.f() == 0) {
            siteConf.a(aVar.c());
        }
        byte b = 2;
        siteConf.b(a(siteConf.b(), aVar.g()) ? (byte) 2 : 1);
        siteConf.a(a(siteConf.a(), aVar.f()) ? (byte) 2 : 1);
        if (!a(siteConf.d(), aVar.j())) {
            b = 1;
        }
        siteConf.c(b);
        return siteConf;
    }

    private static boolean b(byte b, boolean z) {
        if (!z || b != 2) {
            return !z && b == 1;
        }
        return true;
    }
}
