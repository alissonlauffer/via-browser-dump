package mark.via.refactor.config;

import a.a.b.p.d;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import mark.via.BrowserApp;
import mark.via.ui.view.FastView;

/* compiled from: SiteConfManager */
public class c {
    private static String e = "g";
    private static volatile c f;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, SiteConf> f290a;
    private a b;
    /* access modifiers changed from: private */
    public b c;
    private int d = 0;

    /* compiled from: SiteConfManager */
    class a implements Runnable {
        a() {
        }

        public void run() {
            c cVar = c.this;
            HashMap unused = cVar.f290a = cVar.c.a();
        }
    }

    /* compiled from: SiteConfManager */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SiteConf f292a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        b(SiteConf siteConf, String str, boolean z) {
            this.f292a = siteConf;
            this.b = str;
            this.c = z;
        }

        public void run() {
            if (this.f292a.c() < 0) {
                this.f292a.a(c.this.c.a(this.b, this.f292a));
            } else if (this.c) {
                c.this.c.a(this.f292a.c());
            } else {
                c.this.c.a(this.f292a);
            }
        }
    }

    private c(Context context) {
        this.b = a.b(context);
        this.c = b.a(context);
        c();
        b();
    }

    private void c() {
        BrowserApp.b().execute(new a());
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
    private boolean e(String str) {
        return "forum.softpedia.com".equals(mark.via.util.b.a(str, false));
    }

    public void b() {
        this.d++;
        e = "g" + this.d;
    }

    public void d(String str) {
        SiteConf siteConf;
        if (str != null && str.length() != 0 && (siteConf = this.f290a.get(str)) != null) {
            boolean h = siteConf.h();
            if (h) {
                this.f290a.remove(str);
                if (siteConf.c() < 0) {
                    return;
                }
            }
            BrowserApp.b().execute(new b(siteConf, str, h));
        }
    }

    public void c(WebView webView) {
        if (webView != null) {
            a(webView, webView.getUrl());
        }
    }

    public static c a(Context context) {
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    f = new c(context);
                }
            }
        }
        return f;
    }

    public void b(WebView webView) {
        WebSettings settings;
        if (webView != null && (settings = webView.getSettings()) != null) {
            int i = -1;
            if (Build.VERSION.SDK_INT >= 29) {
                boolean n = this.b.n();
                webView.setBackgroundColor(n ? 0 : -1);
                settings.setForceDark(n ? 2 : 1);
                d.a("set force dark: " + n);
            } else {
                webView.setBackgroundColor(-1);
            }
            settings.setSupportMultipleWindows(this.b.m());
            settings.setGeolocationEnabled(this.b.l());
            if (mark.via.b.a.g <= 18) {
                settings.setSavePassword(this.b.p());
            }
            if (this.b.k()) {
                i = 1;
            }
            settings.setCacheMode(i);
            if (Build.VERSION.SDK_INT >= 14) {
                settings.setTextZoom(new int[]{130, 115, 100, 85, 70}[this.b.b() - 1]);
            } else {
                settings.setTextSize(new WebSettings.TextSize[]{WebSettings.TextSize.LARGEST, WebSettings.TextSize.LARGER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.SMALLER, WebSettings.TextSize.SMALLEST}[this.b.b() - 1]);
            }
            try {
                ((FastView) webView).setDoNotTrack(this.b.h());
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, this.b.e());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(this.b.q());
            }
        }
    }

    public boolean c(String str) {
        return a().o() && !e(str);
    }

    public void a(WebView webView) {
        mark.via.h.c.d.c(webView);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.webkit.WebView] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.b.a(android.content.Context, java.lang.String):int
      mark.via.util.b.a(int, java.lang.String):java.lang.String
      mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
      mark.via.util.b.a(android.webkit.WebView, int):void
      mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void a(WebView r6, String str) {
        SiteConf siteConf;
        if (r6 != 0) {
            String str2 = (String) r6.getTag();
            WebSettings settings = r6.getSettings();
            if (str == null || !URLUtil.isFileUrl(str)) {
                String a2 = mark.via.util.b.a(str, false);
                if (a2 == null || a2.length() <= 0 || (siteConf = this.f290a.get(a2)) == null || !siteConf.g()) {
                    if (!e.equals(str2)) {
                        settings.setUserAgentString(this.b.d());
                        settings.setJavaScriptEnabled(this.b.j());
                        settings.setLoadsImagesAutomatically(!this.b.f());
                        settings.setBlockNetworkImage(this.b.f());
                        r6.setTag(e);
                    }
                } else if (!a2.equals(str2)) {
                    settings.setUserAgentString(mark.via.h.c.a.a(siteConf.f() == 0 ? this.b.c() : siteConf.f(), siteConf.e(), mark.via.h.c.a.a(siteConf.b(), this.b.g())));
                    settings.setJavaScriptEnabled(mark.via.h.c.a.a(siteConf.d(), this.b.j()));
                    boolean a3 = mark.via.h.c.a.a(siteConf.a(), this.b.f());
                    settings.setLoadsImagesAutomatically(!a3);
                    settings.setBlockNetworkImage(a3);
                    r6.setTag(a2);
                }
            } else if (!"f".equals(str2)) {
                settings.setLoadsImagesAutomatically(true);
                settings.setBlockNetworkImage(false);
                settings.setJavaScriptEnabled(true);
                settings.setUserAgentString(null);
                r6.setTag("f");
            }
        }
    }

    public SiteConf b(String str) {
        SiteConf siteConf;
        if (str == null || str.isEmpty() || (siteConf = this.f290a.get(str)) == null) {
            siteConf = new SiteConf();
        }
        return mark.via.h.c.a.b(siteConf, this.b);
    }

    public boolean a(String str) {
        SiteConf siteConf;
        if (TextUtils.isEmpty(str) || (siteConf = this.f290a.get(str)) == null || !siteConf.g()) {
            return this.b.g();
        }
        return mark.via.h.c.a.a(siteConf.b(), this.b.g());
    }

    public void a(String str, SiteConf siteConf) {
        if (str != null && siteConf != null) {
            this.f290a.put(str, mark.via.h.c.a.a(siteConf, this.b));
        }
    }

    public a a() {
        return this.b;
    }
}
