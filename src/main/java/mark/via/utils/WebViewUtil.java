package mark.via.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.net.URLDecoder;
import java.util.UUID;

/* renamed from: mark.via.n.a0 */
/* compiled from: WebViewUtil */
public class WebViewUtil {
    /* renamed from: a */
    public static void m2041a(WebView webView) {
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.getSettings().setJavaScriptEnabled(false);
                webView.setTag(null);
                webView.loadUrl("about:blank");
                webView.clearHistory();
                webView.clearCache(false);
                int i = Build.VERSION.SDK_INT;
                if (i >= 11) {
                    webView.onPause();
                }
                if (i <= 19) {
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

    @SuppressLint({"PrivateApi"})
    /* renamed from: b */
    public static PackageInfo m2042b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return WebView.getCurrentWebViewPackage();
        }
        if (i < 21) {
            return null;
        }
        try {
            return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m2043c(WebView webView) {
        if (webView == null) {
            return UUID.randomUUID().toString();
        }
        String title = webView.getTitle();
        if (title == null || title.length() <= 0) {
            title = webView.getUrl();
        }
        if (title != null && title.length() > 128) {
            title = title.substring(0, 128);
        }
        return FileUtil.m2144c(title);
    }

    /* renamed from: d */
    public static String m2044d(String str) {
        String str2;
        int indexOf;
        char charAt;
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] strArr = {"word=", "q=", "keyword=", "text=", "query=", "p="};
        int i = 0;
        while (true) {
            if (i >= 6) {
                break;
            }
            str2 = strArr[i];
            indexOf = str.indexOf(str2);
            if (indexOf <= 0 || !((charAt = str.charAt(indexOf - 1)) == '?' || charAt == '&')) {
                i++;
            }
        }
        str = str.substring(indexOf + str2.length());
        System.out.println(str);
        int indexOf2 = str.indexOf(38);
        if (indexOf2 > 0) {
            str = str.substring(0, indexOf2);
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: e */
    public static String m2045e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf("http://");
        if (indexOf < 0) {
            indexOf = trim.indexOf("https://");
        }
        if (indexOf >= 0) {
            trim = trim.substring(indexOf);
            String[] strArr = {"\n", "\t", " "};
            for (int i = 0; i < 3; i++) {
                int indexOf2 = trim.indexOf(strArr[i]);
                if (indexOf2 > 0) {
                    trim = trim.substring(0, indexOf2);
                }
            }
        } else if (!WebAdressUtils.m2253e(trim)) {
            return null;
        }
        return trim;
    }

    /* renamed from: f */
    public static void m2046f(WebView webView) {
        int i = Build.VERSION.SDK_INT;
        if (webView != null) {
            Context context = webView.getContext();
            try {
                webView.setOverScrollMode(2);
            } catch (Exception unused) {
            }
            webView.setDrawingCacheBackgroundColor(0);
            webView.setFocusableInTouchMode(true);
            webView.setFocusable(true);
            if (i < 23) {
                webView.setAnimationCacheEnabled(false);
            }
            webView.setScrollbarFadingEnabled(true);
            webView.setSaveEnabled(true);
            if (i >= 16) {
                webView.setScrollBarSize(10);
            }
            WebSettings settings = webView.getSettings();
            if (i <= 18) {
                settings.setAppCacheMaxSize(Long.MAX_VALUE);
            }
            if (i >= 11) {
                settings.setEnableSmoothTransition(true);
            }
            if (i >= 17) {
                try {
                    settings.setMediaPlaybackRequiresUserGesture(true);
                } catch (Exception unused2) {
                }
            }
            if (i <= 19) {
                settings.setDatabasePath(context.getCacheDir() + "/databases");
            }
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(context.getCacheDir().toString());
            settings.setGeolocationDatabasePath(context.getFilesDir().toString());
            settings.setAllowFileAccess(true);
            settings.setDatabaseEnabled(true);
            settings.setSaveFormData(true);
            settings.setSupportZoom(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            if (i <= 18) {
                settings.setPluginState(WebSettings.PluginState.ON);
            }
            if (i >= 11) {
                settings.setBuiltInZoomControls(true);
                settings.setDisplayZoomControls(false);
                settings.setAllowContentAccess(true);
            } else {
                settings.setBuiltInZoomControls(false);
            }
            if (i >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            if (i <= 18) {
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            if (i >= 21) {
                try {
                    settings.setMixedContentMode(0);
                } catch (Exception unused3) {
                }
            }
            CookieManager.getInstance().setAcceptCookie(true);
            if (i < 21) {
                CookieSyncManager.createInstance(context.getApplicationContext());
            }
        }
    }

    /* renamed from: g */
    public static boolean m2047g(String str) {
        if (str == null || str.length() < 7 || !str.substring(0, 4).equalsIgnoreCase("http")) {
            return false;
        }
        int indexOf = str.indexOf("://");
        if (indexOf == 4 || indexOf == 5) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public static void m2048h(WebView webView, String str) {
        if (str != null && !str.isEmpty() && webView != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript(str, null);
            } else {
                webView.loadUrl(str);
            }
        }
    }

    /* renamed from: i */
    public static void m2049i(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11 && webView != null) {
            webView.onPause();
        }
    }

    /* renamed from: j */
    public static void m2050j(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11 && webView != null) {
            webView.onResume();
        }
    }

    /* renamed from: k */
    public static boolean m2051k(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 11 && webView != null && str != null && str.length() > 0) {
            try {
                webView.saveWebArchive(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
