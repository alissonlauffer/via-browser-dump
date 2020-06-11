package mark.via.util;

import a.a.b.p.e;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import mark.via.BrowserApp;
import mark.via.gp.R;
import org.json.JSONObject;

/* compiled from: BrowserUtils */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f475a = Pattern.compile("^((ftp|http|https|intent)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");

    /* compiled from: BrowserUtils */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f476a;

        a(Context context) {
            this.f476a = context;
        }

        public void run() {
            mark.via.c.b.a(this.f476a).a();
            b.k(this.f476a);
        }
    }

    /* renamed from: mark.via.util.b$b  reason: collision with other inner class name */
    /* compiled from: BrowserUtils */
    class C0053b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f477a;

        C0053b(Context context) {
            this.f477a = context;
        }

        public void run() {
            WebViewDatabase instance = WebViewDatabase.getInstance(this.f477a);
            instance.clearFormData();
            instance.clearHttpAuthUsernamePassword();
            if (mark.via.b.a.g < 18) {
                instance.clearUsernamePassword();
            }
            CookieSyncManager.createInstance(this.f477a);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    /* compiled from: BrowserUtils */
    class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f478a;
        final /* synthetic */ Intent b;

        c(Context context, Intent intent) {
            this.f478a = context;
            this.b = intent;
        }

        public void onClick(View view) {
            this.f478a.startActivity(this.b);
        }
    }

    /* compiled from: BrowserUtils */
    class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f479a;
        final /* synthetic */ Intent b;

        d(Context context, Intent intent) {
            this.f479a = context;
            this.b = intent;
        }

        public void onClick(View view) {
            this.f479a.startActivity(this.b);
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (!l(trim)) {
            try {
                trim = URLEncoder.encode(trim, "utf-8");
            } catch (Exception unused) {
            }
            return "javascript:window.via.searchText('" + trim + "');";
        } else if (trim.contains("://") || trim.startsWith("about:") || trim.startsWith("mailto:") || trim.startsWith("tel:") || trim.startsWith("javascript:") || trim.startsWith("magnet:") || trim.startsWith("data:") || trim.startsWith("tg:")) {
            return trim;
        } else {
            return "http://" + trim;
        }
    }

    public static void b(Context context) {
    }

    public static void c(Context context) {
        WebView webView = new WebView(context);
        webView.clearCache(true);
        webView.destroy();
    }

    public static void d(Context context) {
        BrowserApp.b().execute(new C0053b(context));
    }

    public static void e(Context context) {
        WebViewDatabase.getInstance(context).clearFormData();
    }

    public static void f(Context context) {
        BrowserApp.a().execute(new a(context));
        if (mark.via.b.a.g < 18) {
            WebIconDatabase.getInstance().removeAllIcons();
        }
    }

    public static int g(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                return 1;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 == null || !networkInfo2.isConnected()) {
                return 0;
            }
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String[] h(Context context) {
        String str;
        mark.via.f.a b = mark.via.f.a.b(context);
        String str2 = "yahoo";
        String str3 = "https://search.yahoo.com/search?p=";
        switch (b.Z()) {
            case 0:
                str3 = b.a0();
                if (str3.startsWith("http://") || str3.startsWith("https://")) {
                    str2 = "unknown";
                    break;
                }
                str2 = "google";
                str3 = "https://www.google.com/search?q=";
                break;
            case 1:
                str3 = mark.via.d.b.c().a(b.k());
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
                if (!a.c()) {
                    if (!mark.via.b.a.b.equalsIgnoreCase("TW") && !mark.via.b.a.b.equalsIgnoreCase("JP") && !mark.via.b.a.b.equalsIgnoreCase("BR") && mark.via.b.a.b.equalsIgnoreCase("RU")) {
                        str3 = "https://www.yandex.ru/search?text=";
                        str2 = "yandex";
                        break;
                    }
                } else {
                    str3 = "https://yz.m.sm.cn/s?from=wm291047&q=";
                    str2 = "shenma";
                    break;
                }
            case 5:
                str3 = a.c() ? "https://m.so.com/s?q=" : "https://startpage.com/do/search?query=";
                str = a.c() ? "haosou" : "startpage";
                str2 = str;
                break;
            case 6:
                str3 = a.c() ? mark.via.d.b.c().c(b.k()) : "https://duckduckgo.com/?q=";
                str = a.c() ? "sougou" : "duckduckgo";
                str2 = str;
                break;
        }
        return new String[]{str3, str2};
    }

    public static boolean i(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("file://");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.b.a(android.content.Context, java.lang.String):int
      mark.via.util.b.a(int, java.lang.String):java.lang.String
      mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
      mark.via.util.b.a(android.webkit.WebView, int):void
      mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
    public static void j(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(mark.via.b.a.h));
        String str = context.getPackageManager().resolveActivity(intent, 0).activityInfo.packageName;
        if (str.equalsIgnoreCase("android")) {
            e.b(context, context.getString(R.string.gp), context.getResources().getString(R.string.gn, a(mark.via.b.a.h, true)), new c(context, intent));
        } else if (str.equalsIgnoreCase(a.a(context))) {
            e.a(context, context.getString(R.string.b0));
        } else {
            e.b(context, context.getString(R.string.gp), context.getResources().getString(R.string.i4), new d(context, new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + str))));
        }
    }

    /* access modifiers changed from: private */
    public static void k(Context context) {
        try {
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.isDirectory()) {
                h.a(cacheDir);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean l(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.startsWith("javascript:") && str.contains(" ")) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase(mark.via.b.a.f245a);
        if ((!lowerCase.startsWith("[") || lowerCase.indexOf("]") <= lowerCase.indexOf(":") || !lowerCase.contains(":")) && !lowerCase.startsWith("about:") && !lowerCase.startsWith("mailto:") && !lowerCase.startsWith("tel:") && ((!lowerCase.startsWith("file://") || lowerCase.equalsIgnoreCase("file://")) && ((!lowerCase.startsWith("javascript:") || lowerCase.equalsIgnoreCase("javascript:")) && ((!lowerCase.startsWith("http://") || lowerCase.equalsIgnoreCase("http://")) && ((!lowerCase.startsWith("https://") || lowerCase.equalsIgnoreCase("https://")) && ((!lowerCase.startsWith("ftp://") || lowerCase.equalsIgnoreCase("ftp://")) && ((!lowerCase.startsWith("intent://") || lowerCase.equalsIgnoreCase("intent://")) && ((!lowerCase.startsWith("magnet:") || lowerCase.equalsIgnoreCase("magnet:")) && ((!lowerCase.startsWith("data:") || lowerCase.equalsIgnoreCase("data:")) && ((!lowerCase.startsWith("tg:") || lowerCase.equalsIgnoreCase("tg:")) && (!lowerCase.contains("://") || lowerCase.startsWith("http://") || lowerCase.startsWith("https://")))))))))))) {
            return f475a.matcher(lowerCase).matches();
        }
        return true;
    }

    public static void a() {
        WebStorage.getInstance().deleteAllData();
    }

    public static int d(String str) {
        String h = h(str);
        int parseInt = Integer.parseInt(h.substring(0, 3), 16) + Integer.parseInt(h.substring((h.length() / 2) - 3, h.length() / 2), 16) + Integer.parseInt(h.substring(h.length() - 3), 16);
        do {
            parseInt /= 2;
        } while (parseInt > 80);
        return parseInt;
    }

    public static int i(Context context) {
        String c2 = a.c(context, "com.google.android.webview");
        if (TextUtils.isEmpty(c2) || !c2.contains(".")) {
            return 0;
        }
        try {
            return Integer.valueOf(c2.substring(0, c2.indexOf(".", 1))).intValue();
        } catch (Exception e) {
            a.a.b.p.d.a(e);
            return 0;
        }
    }

    public static String e(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String trim = str.trim();
        if (trim.startsWith("thunder://")) {
            String c2 = i.c(trim.replace("thunder://", str2));
            if (c2.length() > 4) {
                str2 = c2.substring(2, c2.length() - 2);
            }
        } else if (trim.startsWith("qqdl://")) {
            str2 = i.c(trim.replace("qqdl://", str2));
        } else if (trim.startsWith("flashget://")) {
            str2 = i.c(trim.replace("flashget://", str2)).replace("[FLASHGET]", str2);
        }
        return str2.trim();
    }

    public static String a(String str, boolean z) {
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

    public static boolean c(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("file://" + context.getFilesDir().getPath())) {
                return true;
            }
        }
        return false;
    }

    public static String f(String str) {
        String str2;
        String str3;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            str3 = str.substring(lastIndexOf);
            str2 = str.substring(0, lastIndexOf);
            int lastIndexOf2 = str2.lastIndexOf(".");
            if (lastIndexOf2 >= 0) {
                String substring = str2.substring(lastIndexOf2);
                if (substring.equals(".com") || substring.equals(".net") || substring.equals(".org") || substring.equals(".gov") || substring.equals(".co")) {
                    str2 = str2.substring(0, lastIndexOf2);
                    int lastIndexOf3 = str2.lastIndexOf(".");
                    if (lastIndexOf3 >= 0) {
                        str2 = str2.substring(lastIndexOf3).substring(1);
                    }
                    str3 = substring;
                } else {
                    str2 = substring.substring(1);
                }
            }
        } else {
            str3 = str;
            str2 = "";
        }
        return str2 + str3;
    }

    public static boolean k(String str) {
        return str.contains("-tt.ixigua.com") || str.contains("play.g3proxy.lecloud.com/vod/");
    }

    public static mark.via.a.a c(String str) {
        if (str == null || str.length() <= 10) {
            return null;
        }
        mark.via.a.a aVar = new mark.via.a.a();
        try {
            JSONObject jSONObject = new JSONObject(i.c(str));
            if (!jSONObject.isNull("id")) {
                if (!jSONObject.isNull("code")) {
                    aVar.b(jSONObject.optInt("id"));
                    aVar.d(jSONObject.optString("name"));
                    aVar.a(jSONObject.optString("author"));
                    aVar.e(jSONObject.optString("url"));
                    aVar.c(jSONObject.optString("info"));
                    aVar.b(jSONObject.optString("code"));
                    return aVar;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String g(String str) {
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

    public static boolean b(Context context, String str) {
        String v = mark.via.f.a.b(context).v();
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("file://" + context.getFilesDir().getPath()) || str.equals(v)) {
                return true;
            }
        }
        return false;
    }

    public static int a(Context context, String str) {
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

    public static String h(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(mark.via.b.a.d));
            return a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static String b(long j) {
        return a(j * 1024);
    }

    public static boolean j(String str) {
        if (str == null || str.isEmpty() || !str.contains(".")) {
            return false;
        }
        if (".aa|.aac|.aax|.act|.aiff|.amr|.ape|.au|.awb|.dct|.dvf|.dss|.flac|.gsm|.iklax|.ivs|.m4a|.m4b|.m4p|.mmf|.mp3|.mpc|.msv|.nsf|.ogg|.oga|.mogg|.opus|.ra|.rm|.raw|.sln|.tta|.vox|.wav|.wma|.wv|.8svx".contains(str) || ".webm|.mkv|.flv|.vob|.ogv|.drc|.dat|.mng|.avi|.mts|.m2ts|.mov|.qt|.wmv|.yuv|.rm|.rmvb|.asf|.amv|.mp4|.m4p|.m4v|.mpg|.mp2|.mpeg|.mpe|.mpv|.m2v|.svi|.3gp|.3g2|.mxf|.roq|.nsv|.flv|.f4v|.f4p|.f4a|.f4b|.m3u8|.ts".contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "file://" + context.getFilesDir().getPath() + "/";
        String substring = str.startsWith(str2) ? str.substring(str2.length()) : null;
        if (i == 8) {
            String v = mark.via.f.a.b(context).v();
            if (TextUtils.isEmpty(v)) {
                return false;
            }
            if (!v.startsWith("about:")) {
                if (!str.equalsIgnoreCase(v)) {
                    if (str.equalsIgnoreCase(v + "/")) {
                        return true;
                    }
                    return false;
                }
                return true;
            } else if (substring == null) {
                return false;
            } else {
                if (((v.equals("about:home") || v.equals("about:links")) && "homepage.html".equals(substring)) || (v.equals("about:bookmarks") && "bookmarks.html".equals(substring))) {
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

    public static boolean a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("file://" + context.getFilesDir().getPath()) || (!TextUtils.isEmpty(str2) && str.equals(str2))) {
                return true;
            }
        }
        return false;
    }

    public static void a(Activity activity) {
        Intent intent = new Intent("mark.qrcode.SCAN");
        intent.setClassName("mark.qrcode", "mark.qrcode.CaptureActivity");
        try {
            activity.startActivityForResult(intent, 911);
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.b.a(android.content.Context, java.lang.String):int
      mark.via.util.b.a(int, java.lang.String):java.lang.String
      mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
      mark.via.util.b.a(android.webkit.WebView, int):void
      mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String a2 = a(str, true);
        if (!a2.equalsIgnoreCase("baidu.com")) {
            return (!a2.equalsIgnoreCase("youku.com") || !str.startsWith("http://")) ? str : str.replaceFirst("http://", "https://");
        }
        String substring = str.substring(str.indexOf("baidu.com") + 9);
        if (substring.isEmpty()) {
            return str + "/?from=" + mark.via.d.b.c().b(5000);
        } else if (!substring.equals("/")) {
            return str;
        } else {
            return str + "?from=" + mark.via.d.b.c().b(5000);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    public static String a(int i, String str) {
        String str2;
        boolean equalsIgnoreCase = mark.via.b.a.b.equalsIgnoreCase("cn");
        String str3 = "zh";
        if (i == 0) {
            str2 = mark.via.b.a.f245a.getLanguage();
            String str4 = mark.via.b.a.b;
            if (str3.equalsIgnoreCase(str2)) {
                if (!"cn".equalsIgnoreCase(str4)) {
                    str3 = "zh-" + str4;
                }
                str = URLEncoder.encode(str, "utf-8");
                if (equalsIgnoreCase) {
                }
            }
        } else if (i != 2) {
            str3 = "en";
            str = URLEncoder.encode(str, "utf-8");
            if (equalsIgnoreCase) {
                return "http://fanyi.baidu.com/transpage?query=" + str + "&from=auto&to=" + str3 + "&source=url&ie=utf8&render=1";
            }
            return "https://translate.google.com/translate?sl=auto&tl=" + str3 + "&u=" + str;
        } else {
            str2 = equalsIgnoreCase ? "wyw" : "zh-CN";
        }
        str3 = str2;
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (equalsIgnoreCase) {
        }
    }

    public static boolean a(Intent intent) {
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

    public static void a(Context context, String str, Class<?> cls) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setComponent(new ComponentName(context, cls));
        intent.putExtra("intent", "mark.via.BROWSER");
        context.startActivity(intent);
    }

    public static String a(Intent intent, String str) {
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

    public static String a(long j) {
        String str;
        double d2 = (double) j;
        if (d2 >= 8.589934592E8d) {
            Double.isNaN(d2);
            d2 = ((d2 / 1024.0d) / 1024.0d) / 1024.0d;
            str = " GB";
        } else if (d2 >= 838860.8d) {
            Double.isNaN(d2);
            d2 = (d2 / 1024.0d) / 1024.0d;
            str = " MB";
        } else if (d2 >= 819.2d) {
            Double.isNaN(d2);
            d2 /= 1024.0d;
            str = " KB";
        } else {
            str = " B";
        }
        StringBuilder sb = new StringBuilder();
        double round = (double) Math.round(d2 * 100.0d);
        Double.isNaN(round);
        sb.append(round / 100.0d);
        sb.append(str);
        return sb.toString();
    }

    private static String a(byte[] bArr) {
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

    public static void a(WebView webView, int i) {
        if (webView != null && webView.getContext() != null) {
            Context context = webView.getContext();
            int measuredHeight = webView.getMeasuredHeight();
            int scrollY = webView.getScrollY();
            int contentHeight = (int) (((((float) webView.getContentHeight()) * r.a(context)) - ((float) measuredHeight)) - ((float) scrollY));
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min((measuredHeight / 5) * 4, scrollY);
                        if (Build.VERSION.SDK_INT >= 11) {
                            ObjectAnimator ofInt = ObjectAnimator.ofInt(webView, "scrollY", scrollY, scrollY - min);
                            ofInt.setDuration((long) context.getResources().getInteger(R.integer.f503a));
                            ofInt.start();
                            return;
                        }
                        webView.scrollTo(webView.getScrollX(), scrollY - min);
                    } else if (i == 3) {
                        int min2 = Math.min((measuredHeight / 5) * 4, contentHeight);
                        if (Build.VERSION.SDK_INT >= 11) {
                            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(webView, "scrollY", scrollY, scrollY + min2);
                            ofInt2.setDuration((long) context.getResources().getInteger(R.integer.f503a));
                            ofInt2.start();
                            return;
                        }
                        webView.scrollTo(webView.getScrollX(), scrollY + min2);
                    }
                } else if (Build.VERSION.SDK_INT >= 11) {
                    ObjectAnimator ofInt3 = ObjectAnimator.ofInt(webView, "scrollY", scrollY, (int) (((float) webView.getContentHeight()) * r.a(context)));
                    ofInt3.setDuration((long) context.getResources().getInteger(R.integer.f503a));
                    ofInt3.start();
                } else {
                    webView.scrollTo(webView.getScrollX(), (int) (((float) webView.getContentHeight()) * r.a(context)));
                }
            } else if (Build.VERSION.SDK_INT >= 11) {
                ObjectAnimator ofInt4 = ObjectAnimator.ofInt(webView, "scrollY", scrollY, 0);
                ofInt4.setDuration((long) context.getResources().getInteger(R.integer.f503a));
                ofInt4.start();
            } else {
                webView.scrollTo(webView.getScrollX(), 0);
            }
        }
    }

    public static boolean a(Activity activity, String str, String str2) {
        int indexOf;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("base64,")) >= 0) {
            if (str.startsWith("data:image/")) {
                str = str.substring(indexOf + 7);
            }
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            File file = new File(str2);
            if (decodeByteArray != null && (!file.exists() || file.delete())) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    if (decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                        fileOutputStream.flush();
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(file));
                        activity.sendBroadcast(intent);
                        z = true;
                    }
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    decodeByteArray.recycle();
                    throw th;
                }
                decodeByteArray.recycle();
                return z;
            }
        }
        return false;
    }

    public static void a(WebView webView) {
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
                if (mark.via.b.a.g <= 19) {
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
}
