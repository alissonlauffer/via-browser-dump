package mark.via.p042l;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import mark.via.BrowserApp;
import mark.via.browser.FastView;
import mark.via.constants.Constants;
import mark.via.p042l.p043d.ConfDataSource;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.p042l.p043d.SiteConf;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ConfUtil;
import mark.via.utils.WebViewUtil;
import timber.log.Timber;

/* renamed from: mark.via.l.c */
/* compiled from: ConfManager */
public class ConfManager {

    /* renamed from: c */
    public static String f1398c = "g";

    /* renamed from: a */
    private ConfDataSource f1399a;

    /* renamed from: b */
    private SiteConf f1400b;

    public ConfManager(ConfDataSource aVar) {
        this.f1399a = aVar;
        m1897i();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void mo1220f() {
        GlobalConf.f1420t.clear();
        GlobalConf.f1420t.putAll(this.f1399a.mo1223a());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void mo1221h(boolean z, String str, boolean z2) {
        if (z) {
            this.f1399a.mo1224b(str);
        } else if (z2) {
            this.f1399a.mo1225c(str, this.f1400b);
        } else {
            this.f1399a.mo1226d(str, this.f1400b);
        }
    }

    /* renamed from: i */
    private void m1897i() {
        BrowserApp.m1389c().execute(new RunnableC0468a(this));
    }

    /* renamed from: a */
    public void mo1216a(WebView webView) {
        WebViewUtil.m2046f(webView);
    }

    /* renamed from: b */
    public void mo1217b(WebView webView) {
        int i = Build.VERSION.SDK_INT;
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            if (i < 29 || !GlobalConf.f1414n) {
                webView.setBackgroundColor(-1);
            } else {
                boolean z = GlobalConf.f1413m;
                webView.setBackgroundColor(z ? 0 : -1);
                settings.setForceDark(z ? 2 : 1);
            }
            settings.setSupportMultipleWindows(GlobalConf.f1408h);
            settings.setGeolocationEnabled(GlobalConf.f1403c);
            if (Constants.f1301f <= 18) {
                settings.setSavePassword(GlobalConf.f1404d);
            }
            settings.setCacheMode(-1);
            if (i >= 14) {
                settings.setTextZoom(new int[]{130, 115, 100, 85, 70}[GlobalConf.f1418r - 1]);
            } else {
                settings.setTextSize(new WebSettings.TextSize[]{WebSettings.TextSize.LARGEST, WebSettings.TextSize.LARGER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.SMALLER, WebSettings.TextSize.SMALLEST}[GlobalConf.f1418r - 1]);
            }
            try {
                ((FastView) webView).setDoNotTrack(GlobalConf.f1405e);
            } catch (Exception unused) {
            }
            if (i >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, !GlobalConf.f1412l);
            }
            if (i >= 19) {
                WebView.setWebContentsDebuggingEnabled(GlobalConf.f1411k);
            }
        }
    }

    /* renamed from: c */
    public void mo1218c(WebView webView, String str) {
        SiteConf dVar;
        if (webView != null) {
            String str2 = (String) webView.getTag();
            WebSettings settings = webView.getSettings();
            if (str == null || !URLUtil.isFileUrl(str)) {
                String n = BrowserUtils.m2093n(str, false);
                if (n == null || n.length() <= 0 || (dVar = GlobalConf.f1420t.get(n)) == null || !dVar.mo1235h()) {
                    if (!f1398c.equals(str2)) {
                        settings.setUserAgentString(GlobalConf.f1417q);
                        settings.setJavaScriptEnabled(GlobalConf.f1407g);
                        settings.setLoadsImagesAutomatically(!GlobalConf.f1406f);
                        settings.setBlockNetworkImage(GlobalConf.f1406f);
                        webView.setTag(f1398c);
                    }
                } else if (!n.equals(str2)) {
                    settings.setUserAgentString(ConfUtil.m2115b(dVar.mo1231d() == -1 ? GlobalConf.f1419s : dVar.mo1231d(), dVar.mo1230c(null), dVar.mo1234g(GlobalConf.f1402b)));
                    settings.setJavaScriptEnabled(dVar.mo1236i(GlobalConf.f1407g));
                    boolean f = dVar.mo1233f(GlobalConf.f1406f);
                    settings.setLoadsImagesAutomatically(!f);
                    settings.setBlockNetworkImage(f);
                    webView.setTag(n);
                }
            } else if (!"f".equals(str2)) {
                settings.setLoadsImagesAutomatically(true);
                settings.setBlockNetworkImage(false);
                settings.setJavaScriptEnabled(true);
                settings.setUserAgentString(null);
                webView.setTag("f");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r2 == null) goto L_0x0014;
     */
    /* renamed from: d */
    public SiteConf mo1219d(String str) {
        if (str != null && !str.isEmpty()) {
            SiteConf dVar = GlobalConf.f1420t.get(str);
            this.f1400b = dVar;
        }
        this.f1400b = new SiteConf();
        return this.f1400b;
    }

    /* renamed from: j */
    public void mo1222j(String str) {
        SiteConf dVar;
        if (str != null && str.length() != 0 && (dVar = this.f1400b) != null) {
            Timber.m971a("cachesiteconf: %s", dVar.toString());
            boolean j = this.f1400b.mo1237j();
            boolean containsKey = GlobalConf.f1420t.containsKey(str);
            if (j) {
                GlobalConf.f1420t.remove(str);
                if (!containsKey) {
                    return;
                }
            } else {
                GlobalConf.f1420t.put(str, this.f1400b);
            }
            BrowserApp.m1389c().execute(new RunnableC0469b(this, j, str, containsKey));
        }
    }
}
