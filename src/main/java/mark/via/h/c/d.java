package mark.via.h.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.net.URLDecoder;
import java.util.UUID;
import mark.via.util.s;

/* compiled from: WebViewUtil */
public class d {
    public static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.getSettings().setJavaScriptEnabled(false);
                webView.setTag(null);
                webView.loadUrl("about:blank");
                webView.clearHistory();
                webView.clearCache(false);
                if (Build.VERSION.SDK_INT >= 11) {
                    webView.onPause();
                }
                if (Build.VERSION.SDK_INT <= 19) {
                    webView.freeMemory();
                }
                webView.removeAllViews();
                webView.destroyDrawingCache();
                webView.destroy();
            } catch (Exception unused) {
            }
        }
    }

    public static String b(WebView webView) {
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
        return b.b(title);
    }

    public static void c(WebView webView) {
        if (webView != null) {
            Context context = webView.getContext();
            try {
                webView.setOverScrollMode(2);
            } catch (Exception unused) {
            }
            webView.setDrawingCacheBackgroundColor(0);
            webView.setFocusableInTouchMode(true);
            webView.setFocusable(true);
            if (Build.VERSION.SDK_INT < 23) {
                webView.setAnimationCacheEnabled(false);
            }
            webView.setScrollbarFadingEnabled(true);
            webView.setSaveEnabled(true);
            if (Build.VERSION.SDK_INT >= 16) {
                webView.setScrollBarSize(10);
            }
            WebSettings settings = webView.getSettings();
            if (Build.VERSION.SDK_INT <= 18) {
                settings.setAppCacheMaxSize(Long.MAX_VALUE);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                settings.setEnableSmoothTransition(true);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    settings.setMediaPlaybackRequiresUserGesture(true);
                } catch (Exception unused2) {
                }
            }
            if (Build.VERSION.SDK_INT <= 19) {
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
            if (Build.VERSION.SDK_INT <= 18) {
                settings.setPluginState(WebSettings.PluginState.ON);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                settings.setBuiltInZoomControls(true);
                settings.setDisplayZoomControls(false);
                settings.setAllowContentAccess(true);
            } else {
                settings.setBuiltInZoomControls(false);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            if (Build.VERSION.SDK_INT <= 18) {
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    settings.setMixedContentMode(0);
                } catch (Exception unused3) {
                }
            }
            CookieManager.getInstance().setAcceptCookie(true);
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context.getApplicationContext());
            }
        }
    }

    public static void d(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11 && webView != null) {
            webView.onPause();
        }
    }

    public static void e(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11 && webView != null) {
            webView.onResume();
        }
    }

    public static String b(String str) {
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
        } else if (!s.h(trim)) {
            return null;
        }
        return trim;
    }

    public static boolean a(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 11 && webView != null && str != null && str.length() > 0) {
            try {
                webView.saveWebArchive(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String a(String str) {
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

    public static boolean c(String str) {
        if (str == null || str.length() < 7 || !str.substring(0, 4).equalsIgnoreCase("http")) {
            return false;
        }
        int indexOf = str.indexOf("://");
        if (indexOf == 4 || indexOf == 5) {
            return true;
        }
        return false;
    }
}
