package mark.via.utils;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.adapter.AddonItem;
import mark.via.constants.Constants;
import mark.via.flurry.FlurryRemoteConfig;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.preference.PreferenceManager;
import org.json.JSONObject;

/* renamed from: mark.via.n.e */
/* compiled from: BrowserUtils */
public final class BrowserUtils {

    /* renamed from: mark.via.n.e$a */
    /* compiled from: BrowserUtils */
    public class RunnableC0494a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1514a;

        RunnableC0494a(Context context) {
            this.f1514a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatabaseHandler.m1595v(this.f1514a).mo979f();
            BrowserUtils.m2079J(this.f1514a);
        }
    }

    /* renamed from: mark.via.n.e$b */
    /* compiled from: BrowserUtils */
    public class RunnableC0495b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1515a;

        RunnableC0495b(Context context) {
            this.f1515a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewDatabase instance = WebViewDatabase.getInstance(this.f1515a);
            instance.clearFormData();
            instance.clearHttpAuthUsernamePassword();
            if (Constants.f1301f < 18) {
                instance.clearUsernamePassword();
            }
            CookieSyncManager.createInstance(this.f1515a);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    static {
        Pattern.compile("^((ftp|http|https|intent)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
    }

    /* renamed from: A */
    public static boolean m2070A(Intent intent) {
        boolean z = false;
        if (intent != null) {
            if (intent.getAction() != null && ("mark.via.BOOKMARK".equalsIgnoreCase(intent.getAction()) || "mark.via.HISTORY".equalsIgnoreCase(intent.getAction()) || "mark.via.SEARCH".equalsIgnoreCase(intent.getAction()) || "android.intent.action.WEB_SEARCH".equalsIgnoreCase(intent.getAction()))) {
                z = true;
            }
            if (intent.hasExtra("intent")) {
                z = "mark.via.BROWSER".equalsIgnoreCase(intent.getStringExtra("intent"));
            }
        }
        return !z;
    }

    /* renamed from: B */
    public static boolean m2071B(String str) {
        if (str == null || str.isEmpty() || !str.contains(".")) {
            return false;
        }
        if (".aa|.aac|.aax|.act|.aiff|.amr|.ape|.au|.awb|.dct|.dvf|.dss|.flac|.gsm|.iklax|.ivs|.m4a|.m4b|.m4p|.mmf|.mp3|.mpc|.msv|.nsf|.ogg|.oga|.mogg|.opus|.ra|.rm|.raw|.sln|.tta|.vox|.wav|.wma|.wv|.8svx".contains(str) || ".webm|.mkv|.flv|.vob|.ogv|.drc|.dat|.mng|.avi|.mts|.m2ts|.mov|.qt|.wmv|.yuv|.rm|.rmvb|.asf|.amv|.mp4|.m4p|.m4v|.mpg|.mp2|.mpeg|.mpe|.mpv|.m2v|.svi|.3gp|.3g2|.mxf|.roq|.nsv|.flv|.f4v|.f4p|.f4a|.f4b|.m3u8|.ts".contains(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: C */
    public static boolean m2072C(String str) {
        return str.contains("-tt.ixigua.com") || str.contains("play.g3proxy.lecloud.com/vod/");
    }

    /* renamed from: F */
    public static void m2075F(Context context, String str, Class<?> cls) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setComponent(new ComponentName(context, cls));
        intent.putExtra("intent", "mark.via.BROWSER");
        context.startActivity(intent);
    }

    /* renamed from: G */
    public static void m2076G(Activity activity) {
        Intent intent = new Intent("mark.qrcode.SCAN");
        intent.setClassName("mark.qrcode", "mark.qrcode.CaptureActivity");
        try {
            activity.startActivityForResult(intent, 911);
        } catch (Exception unused) {
        }
    }

    /* renamed from: H */
    public static void m2077H(WebView webView, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (webView != null && webView.getContext() != null) {
            Context context = webView.getContext();
            int measuredHeight = webView.getMeasuredHeight();
            int scrollY = webView.getScrollY();
            int contentHeight = (int) (((((float) webView.getContentHeight()) * ViewUtils.m2227e(context)) - ((float) measuredHeight)) - ((float) scrollY));
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min((measuredHeight / 5) * 4, scrollY);
                        if (i2 >= 11) {
                            ObjectAnimator ofInt = ObjectAnimator.ofInt(webView, "scrollY", scrollY, scrollY - min);
                            ofInt.setDuration((long) context.getResources().getInteger(R.integer.RES_2131296256));
                            ofInt.start();
                            return;
                        }
                        webView.scrollTo(webView.getScrollX(), scrollY - min);
                    } else if (i == 3) {
                        int min2 = Math.min((measuredHeight / 5) * 4, contentHeight);
                        if (i2 >= 11) {
                            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(webView, "scrollY", scrollY, scrollY + min2);
                            ofInt2.setDuration((long) context.getResources().getInteger(R.integer.RES_2131296256));
                            ofInt2.start();
                            return;
                        }
                        webView.scrollTo(webView.getScrollX(), scrollY + min2);
                    }
                } else if (i2 >= 11) {
                    ObjectAnimator ofInt3 = ObjectAnimator.ofInt(webView, "scrollY", scrollY, (int) (((float) webView.getContentHeight()) * ViewUtils.m2227e(context)));
                    ofInt3.setDuration((long) context.getResources().getInteger(R.integer.RES_2131296256));
                    ofInt3.start();
                } else {
                    webView.scrollTo(webView.getScrollX(), (int) (((float) webView.getContentHeight()) * ViewUtils.m2227e(context)));
                }
            } else if (i2 >= 11) {
                ObjectAnimator ofInt4 = ObjectAnimator.ofInt(webView, "scrollY", scrollY, 0);
                ofInt4.setDuration((long) context.getResources().getInteger(R.integer.RES_2131296256));
                ofInt4.start();
            } else {
                webView.scrollTo(webView.getScrollX(), 0);
            }
        }
    }

    /* renamed from: I */
    public static void m2078I(Context context) {
        String str = Constants.f1302g;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        String str2 = context.getPackageManager().resolveActivity(intent, 0).activityInfo.packageName;
        if (str2.equalsIgnoreCase("android")) {
            QuickUtils.m1381m(context, context.getString(R.string.RES_2131558695), context.getResources().getString(R.string.RES_2131558693, m2093n(str, true)), new C0492b(context, intent));
        } else if (str2.equalsIgnoreCase(AppUtils.m2054b(context))) {
            QuickUtils.m1384p(context, context.getString(R.string.RES_2131558464));
        } else {
            QuickUtils.m1381m(context, context.getString(R.string.RES_2131558695), context.getResources().getString(R.string.RES_2131558748), new C0491a(context, new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + str2))));
        }
    }

    /* renamed from: J */
    public static void m2079J(Context context) {
        try {
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.isDirectory()) {
                FileUtils.m2145a(cacheDir);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private static String m2081b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static void m2082c(Context context) {
    }

    /* renamed from: d */
    public static void m2083d() {
        WebStorage.getInstance().deleteAllData();
    }

    /* renamed from: e */
    public static void m2084e(Context context) {
        WebView webView = new WebView(context);
        webView.clearCache(true);
        webView.destroy();
    }

    /* renamed from: f */
    public static void m2085f(Context context) {
        BrowserApp.m1389c().execute(new RunnableC0495b(context));
    }

    /* renamed from: g */
    public static void m2086g(Context context) {
        WebViewDatabase.getInstance(context).clearFormData();
    }

    /* renamed from: h */
    public static void m2087h(Context context) {
        BrowserApp.m1388b().execute(new RunnableC0494a(context));
        if (Constants.f1301f < 18) {
            WebIconDatabase.getInstance().removeAllIcons();
        }
    }

    /* renamed from: i */
    public static void m2088i(WebView webView) {
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.getSettings().setJavaScriptEnabled(false);
                webView.setTag(null);
                webView.clearHistory();
                webView.clearCache(false);
                if (Build.VERSION.SDK_INT >= 11) {
                    webView.onPause();
                }
                if (Constants.f1301f <= 19) {
                    webView.freeMemory();
                }
                webView.removeAllViews();
                webView.destroyDrawingCache();
                webView.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: j */
    public static AddonItem m2089j(String str) {
        if (str == null || str.length() <= 10) {
            return null;
        }
        AddonItem aVar = new AddonItem();
        try {
            JSONObject jSONObject = new JSONObject(InfoUtils.m2170i(str));
            if (!jSONObject.isNull("id")) {
                if (!jSONObject.isNull("code")) {
                    aVar.mo930n(jSONObject.optInt("id"));
                    aVar.mo929m(jSONObject.optString("name"));
                    aVar.mo925i(jSONObject.optString("author"));
                    aVar.mo931o(jSONObject.optString("url"));
                    aVar.mo928l(jSONObject.optString("info"));
                    aVar.mo926j(jSONObject.optString("code"));
                    return aVar;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    public static int m2090k(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str2 = "file://" + context.getFilesDir().getPath() + "/";
        if (!str.startsWith(str2)) {
            return -1;
        }
        String substring = str.substring(str2.length());
        if ("homepage.html".equals(substring)) {
            return 1;
        }
        if ("bookmarks.html".equals(substring)) {
            return 2;
        }
        if ("folder.html".equals(substring)) {
            return 11;
        }
        if ("history.html".equals(substring)) {
            return 3;
        }
        if ("catalog.html".equals(substring)) {
            return 5;
        }
        if ("log.html".equals(substring)) {
            return 6;
        }
        if ("res.html".equals(substring)) {
            return 10;
        }
        if ("save.html".equals(substring)) {
            return 7;
        }
        if ("about.html".equals(substring)) {
            return 4;
        }
        return -1;
    }

    /* renamed from: l */
    public static String m2091l(long j) {
        String str;
        double d = (double) j;
        if (d >= 8.589934592E8d) {
            Double.isNaN(d);
            d = ((d / 1024.0d) / 1024.0d) / 1024.0d;
            str = " GB";
        } else if (d >= 838860.8d) {
            Double.isNaN(d);
            d = (d / 1024.0d) / 1024.0d;
            str = " MB";
        } else if (d >= 819.2d) {
            Double.isNaN(d);
            d /= 1024.0d;
            str = " KB";
        } else {
            str = " B";
        }
        StringBuilder sb = new StringBuilder();
        double round = (double) Math.round(d * 100.0d);
        Double.isNaN(round);
        sb.append(round / 100.0d);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: m */
    public static String m2092m(long j) {
        return m2091l(j * 1024);
    }

    /* renamed from: n */
    public static String m2093n(String str, boolean z) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.length() <= 0) {
            return "";
        }
        int indexOf = trim.indexOf("://");
        if (indexOf >= 0) {
            trim = trim.substring(indexOf + 3);
        }
        int indexOf2 = trim.indexOf(47);
        if (indexOf2 >= 0) {
            trim = trim.substring(0, indexOf2);
        }
        int indexOf3 = trim.indexOf(58);
        if (indexOf3 >= 0) {
            trim = trim.substring(0, indexOf3);
        }
        if (!z) {
            return trim;
        }
        if (trim.startsWith("www.")) {
            return trim.substring(4);
        }
        return trim.startsWith("m.") ? trim.substring(2) : trim;
    }

    /* renamed from: o */
    public static String m2094o(Intent intent, String str) {
        String str2 = null;
        if (intent == null) {
            return null;
        }
        String action = intent.getAction();
        if (action != null) {
            if (action.equalsIgnoreCase("mark.via.BOOKMARK")) {
                str2 = "v://bookmark";
            } else if (action.equalsIgnoreCase("mark.via.HISTORY")) {
                str2 = "v://history";
            } else if (action.equalsIgnoreCase("mark.via.SEARCH")) {
                str2 = str;
            }
        }
        if (intent.hasExtra("OPEN")) {
            return intent.getStringExtra("OPEN");
        }
        if (!intent.hasExtra("query")) {
            return intent.getDataString() != null ? intent.getDataString() : str2;
        }
        return str + intent.getStringExtra("query");
    }

    /* renamed from: p */
    public static int m2095p(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                return 1;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && networkInfo2.isConnected()) {
                return 2;
            }
        }
        return 0;
    }

    /* renamed from: q */
    public static int m2096q(String str) {
        String u = m2100u(str);
        int parseInt = Integer.parseInt(u.substring(0, 3), 16) + Integer.parseInt(u.substring((u.length() / 2) - 3, u.length() / 2), 16) + Integer.parseInt(u.substring(u.length() - 3), 16);
        do {
            parseInt /= 2;
        } while (parseInt > 80);
        return parseInt;
    }

    /* renamed from: r */
    public static String m2097r(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String trim = str.trim();
        if (trim.startsWith("thunder://")) {
            String i = InfoUtils.m2170i(trim.replace("thunder://", str2));
            if (i.length() > 4) {
                str2 = i.substring(2, i.length() - 2);
            }
        } else if (trim.startsWith("qqdl://")) {
            str2 = InfoUtils.m2170i(trim.replace("qqdl://", str2));
        } else if (trim.startsWith("flashget://")) {
            str2 = InfoUtils.m2170i(trim.replace("flashget://", str2)).replace("[FLASHGET]", str2);
        }
        return str2.trim();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: s */
    public static String[] m2098s(Context context) {
        String str;
        PreferenceManager M = PreferenceManager.m1743M(context);
        String str2 = "yahoo";
        String str3 = "https://search.yahoo.com/search?p=";
        switch (M.mo1155i0()) {
            case 0:
                str3 = M.mo1158j0();
                if (str3.startsWith("http://") || str3.startsWith("https://")) {
                    str2 = "unknown";
                    break;
                }
                str2 = "google";
                str3 = "https://www.google.com/search?q=";
                break;
            case 1:
                str3 = FlurryRemoteConfig.m1694c().mo1045b(M.mo1181r());
                str2 = "baidu";
                break;
            case 2:
            default:
                str2 = "google";
                str3 = "https://www.google.com/search?q=";
                break;
            case 3:
                str3 = "https://www.bing.com/search?q=";
                str2 = "bing";
                break;
            case 4:
                if (!AppUtils.m2060h()) {
                    String str4 = Constants.f1297b;
                    if (!str4.equalsIgnoreCase("TW") && !str4.equalsIgnoreCase("JP") && !str4.equalsIgnoreCase("BR") && str4.equalsIgnoreCase("RU")) {
                        str3 = "https://www.yandex.ru/search/touch/?text=";
                        str2 = "yandex";
                        break;
                    }
                } else {
                    str3 = "https://yz.m.sm.cn/s?from=wm291047&q=";
                    str2 = "shenma";
                    break;
                }
            case 5:
                str3 = AppUtils.m2060h() ? "https://m.so.com/s?q=" : "https://startpage.com/do/search?query=";
                str = AppUtils.m2060h() ? "haosou" : "startpage";
                str2 = str;
                break;
            case 6:
                str3 = AppUtils.m2060h() ? FlurryRemoteConfig.m1694c().mo1046d(M.mo1181r()) : "https://duckduckgo.com/?q=";
                str = AppUtils.m2060h() ? "sougou" : "duckduckgo";
                str2 = str;
                break;
        }
        return new String[]{str3, str2};
    }

    /* renamed from: t */
    public static String m2099t(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("?");
        if (lastIndexOf > -1) {
            str = str.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf("/");
        if (lastIndexOf2 > -1) {
            str = str.substring(lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf(".");
        if (lastIndexOf3 > -1) {
            str = str.substring(lastIndexOf3);
        }
        if (str.length() >= 7 || str.length() < 2 || !str.startsWith(".")) {
            return "";
        }
        return str;
    }

    /* renamed from: u */
    public static String m2100u(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(Constants.f1299d));
            return m2081b(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: v */
    public static boolean m2101v(Context context, String str) {
        String str2 = GlobalConf.f1416p;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("file://" + context.getFilesDir().getPath()) || str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: w */
    public static boolean m2102w(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "file://" + context.getFilesDir().getPath() + "/";
        String substring = str.startsWith(str2) ? str.substring(str2.length()) : null;
        if (i == 8) {
            String D = PreferenceManager.m1743M(context).mo1071D();
            if (TextUtils.isEmpty(D)) {
                return false;
            }
            if (!D.startsWith("about:")) {
                if (!str.equalsIgnoreCase(D)) {
                    if (!str.equalsIgnoreCase(D + "/")) {
                        return false;
                    }
                }
                return true;
            } else if (substring == null) {
                return false;
            } else {
                if (((D.equals("about:home") || D.equals("about:links")) && "homepage.html".equals(substring)) || (D.equals("about:bookmarks") && "bookmarks.html".equals(substring))) {
                    return true;
                }
                return false;
            }
        } else if (substring == null) {
            return false;
        } else {
            if ((i != 1 || !"homepage.html".equals(substring)) && ((i != 2 || (!"bookmarks.html".equals(substring) && !"folder.html".equals(substring))) && ((i != 3 || !"history.html".equals(substring)) && ((i != 4 || !"about.html".equals(substring)) && ((i != 5 || !"catalog.html".equals(substring)) && ((i != 6 || !"log.html".equals(substring)) && ((i != 10 || !"res.html".equals(substring)) && (i != 7 || !"save.html".equals(substring))))))))) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: x */
    public static boolean m2103x(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("file://" + context.getFilesDir().getPath()) || (!TextUtils.isEmpty(str2) && str.equals(str2))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: y */
    public static boolean m2104y(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("file://" + context.getFilesDir().getPath())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: z */
    public static boolean m2105z(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("file://");
    }
}
