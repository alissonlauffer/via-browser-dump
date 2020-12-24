package mark.via.browser;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.CompatUtils;
import mark.via.BrowserApp;
import mark.via.adapter.LogItem;
import mark.via.constants.Constants;
import mark.via.gp.R;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.p044m.p045a.PageManager;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ChannelUtils;
import mark.via.utils.ConfUtil;
import mark.via.utils.ViewUtils;
import mark.via.utils.WebViewUtil;
import timber.log.Timber;

/* renamed from: mark.via.browser.b0 */
/* compiled from: TabItem */
public class TabItem {

    /* renamed from: q */
    private static final FrameLayout.LayoutParams f1214q = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a */
    private final FrameLayout f1215a;

    /* renamed from: b */
    private final Activity f1216b;

    /* renamed from: c */
    private final Context f1217c;

    /* renamed from: d */
    private boolean f1218d = false;

    /* renamed from: e */
    private boolean f1219e = false;

    /* renamed from: f */
    private String f1220f;

    /* renamed from: g */
    private int f1221g;

    /* renamed from: h */
    private final List<FastViewWrapper> f1222h = new ArrayList();

    /* renamed from: i */
    private int f1223i;

    /* renamed from: j */
    private int f1224j;

    /* renamed from: k */
    private FastView f1225k;

    /* renamed from: l */
    private AbstractC0409b f1226l;

    /* renamed from: m */
    private NetworkLogger f1227m;

    /* renamed from: n */
    private String f1228n;

    /* renamed from: o */
    private int f1229o;

    /* renamed from: p */
    private boolean f1230p = false;

    /* renamed from: mark.via.browser.b0$b */
    /* compiled from: TabItem */
    public interface AbstractC0409b {
        /* renamed from: a */
        void mo844a(int i);

        /* renamed from: b */
        void mo845b(int i);

        /* renamed from: c */
        void mo846c(ValueCallback<Uri> valueCallback);

        /* renamed from: d */
        boolean mo847d();

        /* renamed from: e */
        void mo848e(WebView webView, boolean z, Message message);

        /* renamed from: f */
        void mo849f(View view, int i, WebChromeClient.CustomViewCallback customViewCallback);

        /* renamed from: g */
        void mo850g(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

        /* renamed from: h */
        void mo851h(String str, String str2, String str3, String str4, long j);

        /* renamed from: i */
        boolean mo852i(View view, MotionEvent motionEvent);

        /* renamed from: j */
        void mo853j(int i);

        /* renamed from: k */
        void mo854k();

        /* renamed from: l */
        void mo855l(WebView webView);

        /* renamed from: m */
        void mo856m(WebView webView);

        /* renamed from: n */
        void mo857n();

        /* renamed from: o */
        Object mo858o();

        /* renamed from: p */
        void mo859p(WebView webView, String str);

        /* renamed from: q */
        WebResourceResponse mo860q(WebView webView, WebResourceRequest webResourceRequest, String str, String str2);

        /* renamed from: r */
        boolean mo861r(WebView webView);

        /* renamed from: s */
        void mo862s(String str, String str2);

        /* renamed from: t */
        boolean mo863t(String str);

        /* renamed from: u */
        void mo864u(boolean z);
    }

    /* renamed from: mark.via.browser.b0$c */
    /* compiled from: TabItem */
    public class C0410c extends WebChromeClient {
        private C0410c() {
            TabItem.this = r1;
        }

        /* renamed from: i */
        static /* synthetic */ void m1510i(JsPromptResult jsPromptResult, View view, TaoDialog.C0384l lVar) {
            String str = lVar.f1091c[0];
            if (TextUtils.isEmpty(str)) {
                jsPromptResult.cancel();
            } else {
                jsPromptResult.confirm(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            return LayoutInflater.from(TabItem.this.f1217c).inflate(R.layout.g, (ViewGroup) TabItem.this.f1216b.findViewById(16908290), false);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            try {
                TabItem.this.f1226l.mo848e(webView, z2, message);
                return true;
            } catch (Exception e) {
                Timber.m973c(e);
                return true;
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            String str2;
            if (str.length() > 50) {
                str2 = str.substring(0, 50) + "...";
            } else {
                str2 = str;
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1217c);
            g.mo620L(R.string.f0);
            g.mo645w(str2 + CompatUtils.m1336f(TabItem.this.f1217c, R.string.ff));
            g.mo635m(false);
            g.mo614F(R.string.c, new C0425o(callback, str));
            g.mo648z(R.string.p, new View$OnClickListenerC0417g(callback, str));
            g.mo622N();
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            super.onHideCustomView();
            Timber.m971a("onHideCustomView in callback", new Object[0]);
            TabItem.this.f1226l.mo857n();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            String str3;
            if (!webView.isShown()) {
                jsResult.cancel();
                return true;
            }
            String n = BrowserUtils.m2093n(str, false);
            if (TextUtils.isEmpty(n)) {
                str3 = TabItem.this.f1217c.getString(R.string.cr);
            } else {
                str3 = TabItem.this.f1217c.getString(R.string.cs, n);
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1217c);
            g.mo621M(str3);
            g.mo645w(str2);
            g.mo635m(false);
            g.mo614F(17039370, new C0426p(jsResult));
            g.mo610B(R.string.dq, new View$OnClickListenerC0422l(jsResult));
            g.mo622N();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if (!webView.isShown()) {
                jsResult.confirm();
                return true;
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1216b);
            g.mo620L(R.string.bs);
            g.mo645w(str2);
            g.mo635m(false);
            g.mo614F(R.string.ez, new C0420j(jsResult));
            g.mo648z(R.string.i9, new View$OnClickListenerC0418h(jsResult));
            g.mo622N();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            String str3;
            if (!webView.isShown()) {
                jsResult.cancel();
                return true;
            }
            String n = BrowserUtils.m2093n(str, false);
            if (TextUtils.isEmpty(n)) {
                str3 = TabItem.this.f1217c.getString(R.string.cr);
            } else {
                str3 = TabItem.this.f1217c.getString(R.string.cs, n);
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1217c);
            g.mo621M(str3);
            g.mo645w(str2);
            g.mo635m(false);
            g.mo614F(17039370, new C0421k(jsResult));
            g.mo648z(17039360, new View$OnClickListenerC0419i(jsResult));
            g.mo622N();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            String str4;
            if (!webView.isShown()) {
                jsPromptResult.cancel();
                return true;
            }
            String n = BrowserUtils.m2093n(str, false);
            if (TextUtils.isEmpty(n)) {
                str4 = TabItem.this.f1217c.getString(R.string.cr);
            } else {
                str4 = TabItem.this.f1217c.getString(R.string.cs, n);
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1217c);
            g.mo621M(str4);
            g.mo631f(str3, str2, 4);
            g.mo635m(false);
            g.mo614F(17039370, new C0423m(jsPromptResult));
            g.mo648z(17039360, new View$OnClickListenerC0424n(jsPromptResult));
            g.mo622N();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (permissionRequest != null) {
                Activity activity = TabItem.this.f1216b;
                permissionRequest.getClass();
                activity.runOnUiThread(new RunnableC0435y(permissionRequest));
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (webView.isShown() && (i == 100 || TabItem.this.f1228n == null || !BrowserUtils.m2101v(TabItem.this.f1217c, TabItem.this.f1228n))) {
                TabItem.this.f1226l.mo853j(i);
            }
            if (i > 30 && i < 100 && !TabItem.this.f1218d) {
                TabItem b0Var = TabItem.this;
                b0Var.f1218d = b0Var.f1226l.mo861r(webView);
            }
            if (i > 70 && i < 100) {
                TabItem.this.m1409E((FastView) webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            TabItem.this.m1432j0();
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (webView.isShown()) {
                TabItem.this.f1226l.mo854k();
            }
            TabItem.this.f1226l.mo862s(str, webView.getUrl());
            TabItem.this.m1432j0();
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            if (Constants.f1301f >= 19) {
                Timber.m971a("onShowCustomView in callback", new Object[0]);
                TabItem.this.f1226l.mo849f(view, 0, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            TabItem.this.f1226l.mo850g(valueCallback, fileChooserParams);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            TabItem.this.f1226l.mo846c(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            TabItem.this.f1226l.mo846c(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            TabItem.this.f1226l.mo846c(valueCallback);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, i, customViewCallback);
            int i2 = Constants.f1301f;
            if (i2 >= 14 && i2 <= 18) {
                TabItem.this.f1226l.mo849f(view, i, customViewCallback);
            }
        }
    }

    /* renamed from: mark.via.browser.b0$d */
    /* compiled from: TabItem */
    public class C0411d implements DownloadListener {
        private C0411d() {
            TabItem.this = r1;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            TabItem.this.f1226l.mo851h(str, str2, str3, str4, j);
        }
    }

    public TabItem(Activity activity, String str, AbstractC0409b bVar) {
        if (bVar != null) {
            this.f1216b = activity;
            this.f1217c = activity;
            this.f1226l = bVar;
            this.f1224j = 0;
            this.f1223i = -1;
            NetworkLogger a0Var = new NetworkLogger();
            a0Var.mo803h(new C0413c(this));
            this.f1227m = a0Var;
            this.f1215a = new FrameLayout(activity);
            m1442t(str);
            return;
        }
        throw new NullPointerException("TabItem callback can not be null");
    }

    /* renamed from: C */
    private boolean m1408C(String str) {
        m1442t(str);
        return true;
    }

    /* renamed from: E */
    private void m1409E(FastView fastView) {
        if (!this.f1219e && fastView != null) {
            this.f1219e = true;
            fastView.postDelayed(new RunnableC0433w(this, fastView), 200);
        }
    }

    /* renamed from: M */
    private int m1410M() {
        FastView fastView = this.f1225k;
        if (fastView == null) {
            return 0;
        }
        return fastView.getWebColor();
    }

    /* renamed from: P */
    private void m1411P(int i) {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            if (fastView.canGoBackOrForward(i)) {
                this.f1225k.goBackOrForward(i);
                return;
            }
            m1441s0(this.f1223i + i);
            m1430i0();
        }
    }

    /* renamed from: R */
    private void m1412R(Activity activity, FastView fastView) {
        this.f1226l.mo855l(fastView);
        ViewUtils.m2223a(fastView, CompatUtils.m1334d(activity, R.color.a8));
        if (Build.VERSION.SDK_INT >= 16) {
            fastView.setScrollBarSize(CompatUtils.m1333c(this.f1217c, R.dimen.m));
        }
        fastView.setWebChromeClient(new C0410c());
        fastView.setWebViewClient(new C0412e());
        fastView.setDownloadListener(new C0411d());
        fastView.setOnLongClickListener(new View$OnLongClickListenerC0415e(this));
        fastView.setOnTouchListener(new View$OnTouchListenerC0416f(this));
        fastView.addJavascriptInterface(this.f1226l.mo858o(), "via");
        mo810D(fastView);
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void mo822U(FastView fastView) {
        m1412R(this.f1216b, fastView);
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void mo823W(FastView fastView) {
        this.f1221g = ViewUtils.m2231i(fastView);
        this.f1220f = BrowserUtils.m2093n(fastView.getUrl(), false);
        fastView.setWebColor(this.f1221g);
        if (fastView.isShown()) {
            this.f1226l.mo844a(this.f1221g);
        }
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ boolean mo824Y(View view) {
        return this.f1226l.mo847d();
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ boolean mo825a0(View view, MotionEvent motionEvent) {
        return this.f1226l.mo852i(view, motionEvent);
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void mo826d0(boolean z, FastView fastView) {
        String b = z ? PageManager.m1938b(this.f1217c) : PageManager.m1943g(this.f1217c);
        this.f1228n = b;
        this.f1216b.runOnUiThread(new RunnableC0414d(fastView, b));
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void mo827f0(boolean z) {
        if (this.f1230p) {
            this.f1226l.mo864u(z);
        }
    }

    /* renamed from: g0 */
    private void m1427g0(FastView fastView) {
        if (fastView != null) {
            String str = GlobalConf.f1416p;
            if ("about:blank".equals(str) || !str.startsWith("about:")) {
                this.f1228n = str;
                fastView.loadUrl(str);
                return;
            }
            BrowserApp.m1389c().execute(new RunnableC0407b(this, str.equals("about:bookmarks"), fastView));
        }
    }

    /* renamed from: i0 */
    private void m1430i0() {
        m1432j0();
        if (this.f1215a.isShown()) {
            this.f1226l.mo854k();
            this.f1226l.mo853j(mo815J());
            int i = this.f1221g;
            this.f1226l.mo844a(m1410M());
            if (i != 0) {
                this.f1220f = BrowserUtils.m2093n(mo817L(), false);
            }
        }
    }

    /* renamed from: j0 */
    private void m1432j0() {
        this.f1226l.mo845b(this.f1229o);
    }

    /* renamed from: s0 */
    private void m1441s0(int i) {
        if (this.f1223i != i && i >= 0 && i < this.f1222h.size() && this.f1222h.get(i) != null) {
            WebViewUtil.m2049i(this.f1225k);
            FastView fastView = this.f1225k;
            if (fastView != null && fastView.getProgress() < 100) {
                this.f1225k.stopLoading();
            }
            FastViewWrapper zVar = this.f1222h.get(i);
            if (zVar.mo912g()) {
                zVar.mo914j();
            }
            this.f1223i = i;
            FastView f = zVar.mo911f();
            this.f1225k = f;
            this.f1228n = f.getUrl();
            this.f1225k.getId();
            this.f1215a.removeAllViews();
            this.f1215a.addView(this.f1225k, f1214q);
            mo810D(this.f1225k);
            WebViewUtil.m2050j(this.f1225k);
            this.f1227m.mo805i(this.f1223i);
            m1444z();
        }
    }

    /* renamed from: t */
    private void m1442t(String str) {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            fastView.setForwardEnable(false);
        }
        m1443x();
        FastViewWrapper zVar = new FastViewWrapper(this.f1217c);
        int i = this.f1224j;
        this.f1224j = i + 1;
        zVar.mo916l(i);
        zVar.mo915k(new C0434x(this));
        zVar.mo908a();
        int size = this.f1222h.size();
        FastView f = zVar.mo911f();
        this.f1222h.add(size, zVar);
        if (str == null) {
            m1427g0(f);
        } else {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                f.setReferer(mo817L());
                this.f1226l.mo859p(f, trim);
                this.f1228n = trim;
                f.loadUrl(trim);
            }
        }
        m1441s0(size);
    }

    /* renamed from: x */
    private void m1443x() {
        int size = this.f1222h.size();
        while (true) {
            size--;
            if (size > this.f1223i) {
                this.f1222h.get(size).mo910d();
                this.f1222h.remove(size);
            } else {
                return;
            }
        }
    }

    /* renamed from: z */
    private void m1444z() {
        int size = this.f1222h.size();
        if (size >= 6) {
            for (int i = 0; i < size; i++) {
                int i2 = this.f1223i;
                if (i < i2 - 3 || i > i2 + 2) {
                    FastViewWrapper zVar = this.f1222h.get(i);
                    if (!zVar.mo912g()) {
                        zVar.mo909b();
                    }
                }
            }
        }
    }

    /* renamed from: A */
    public boolean mo808A() {
        return this.f1227m.mo799d() == this.f1223i && this.f1227m.mo798c();
    }

    /* renamed from: B */
    public void mo809B() {
        mo830l0();
        this.f1230p = false;
    }

    /* renamed from: D */
    public void mo810D(FastView fastView) {
        this.f1226l.mo856m(fastView);
        this.f1226l.mo859p(fastView, fastView.getUrl());
    }

    /* renamed from: F */
    public FrameLayout mo811F() {
        return this.f1215a;
    }

    /* renamed from: G */
    public Bitmap mo812G() {
        FastView fastView = this.f1225k;
        if (fastView == null) {
            return null;
        }
        return fastView.getFavicon();
    }

    /* renamed from: H */
    public int mo813H() {
        return this.f1229o;
    }

    /* renamed from: I */
    public List<LogItem> mo814I() {
        return this.f1227m.mo800e();
    }

    /* renamed from: J */
    public int mo815J() {
        FastView fastView = this.f1225k;
        if (fastView == null || BrowserUtils.m2101v(this.f1217c, fastView.getUrl())) {
            return 100;
        }
        return this.f1225k.getProgress();
    }

    /* renamed from: K */
    public String mo816K() {
        FastView fastView = this.f1225k;
        String title = fastView == null ? null : fastView.getTitle();
        if (title == null || title.isEmpty()) {
            return CompatUtils.m1336f(this.f1217c, R.string.j5);
        }
        return title;
    }

    /* renamed from: L */
    public String mo817L() {
        FastView fastView = this.f1225k;
        if (fastView == null) {
            return null;
        }
        return fastView.getUrl();
    }

    /* renamed from: N */
    public FastView mo818N() {
        return this.f1225k;
    }

    /* renamed from: O */
    public void mo819O() {
        m1411P(-1);
    }

    /* renamed from: Q */
    public void mo820Q() {
        m1411P(1);
    }

    /* renamed from: S */
    public boolean mo821S() {
        return this.f1230p;
    }

    /* renamed from: h0 */
    public void mo828h0(String str) {
        if (!TextUtils.isEmpty(str) && !this.f1226l.mo863t(str)) {
            String L = mo817L();
            if (str.equals(L)) {
                this.f1226l.mo859p(this.f1225k, str);
                this.f1225k.reload();
            } else if (!ConfUtil.m2118e(str) || str.startsWith("javascript:") || L == null || L.isEmpty() || (URLUtil.isFileUrl(L) && URLUtil.isFileUrl(str))) {
                this.f1226l.mo859p(this.f1225k, str);
                this.f1225k.loadUrl(str);
                if (!str.startsWith("javascript:")) {
                    this.f1225k.setForwardEnable(true);
                    m1443x();
                }
            } else {
                m1442t(str);
            }
        }
    }

    /* renamed from: k0 */
    public void mo829k0() {
        this.f1226l = null;
        this.f1215a.removeAllViews();
        for (FastViewWrapper zVar : this.f1222h) {
            zVar.mo910d();
        }
        this.f1222h.clear();
        this.f1227m.mo801f();
        this.f1227m = null;
    }

    /* renamed from: l0 */
    public void mo830l0() {
        WebViewUtil.m2049i(this.f1225k);
    }

    /* renamed from: m0 */
    public void mo831m0() {
        WebViewUtil.m2050j(this.f1225k);
    }

    /* renamed from: n0 */
    public void mo832n0() {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            fastView.pauseTimers();
        }
    }

    /* renamed from: o0 */
    public void mo833o0() {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            fastView.reload();
            this.f1220f = null;
        }
    }

    /* renamed from: p0 */
    public void mo834p0() {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            fastView.requestFocus();
        }
    }

    /* renamed from: q0 */
    public void mo835q0() {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            fastView.resumeTimers();
        }
    }

    /* renamed from: r0 */
    public void mo836r0(int i) {
        this.f1229o = i;
    }

    /* renamed from: s */
    public void mo837s() {
        mo831m0();
        this.f1230p = true;
    }

    /* renamed from: t0 */
    public void mo838t0() {
        FastView fastView = this.f1225k;
        if (fastView != null) {
            fastView.stopLoading();
        }
    }

    /* renamed from: u */
    public void mo839u() {
        if (!this.f1219e) {
            m1409E(this.f1225k);
        } else if (this.f1215a.isShown()) {
            this.f1226l.mo844a(m1410M());
        }
    }

    /* renamed from: u0 */
    public void mo840u0(Context context) {
        GlobalConf.m1915a(context);
    }

    /* renamed from: v */
    public boolean mo841v() {
        FastView fastView;
        return this.f1223i > 0 || ((fastView = this.f1225k) != null && fastView.canGoBack());
    }

    /* renamed from: w */
    public boolean mo842w() {
        if (this.f1222h.size() > this.f1223i + 1) {
            return true;
        }
        FastView fastView = this.f1225k;
        return fastView != null && fastView.canGoForward();
    }

    /* renamed from: y */
    public void mo843y() {
        this.f1227m.mo797a(this.f1223i);
    }

    /* renamed from: mark.via.browser.b0$e */
    /* compiled from: TabItem */
    public class C0412e extends WebViewClient {
        private C0412e() {
            TabItem.this = r1;
        }

        /* renamed from: c */
        static /* synthetic */ void m1514c(HttpAuthHandler httpAuthHandler, View view, TaoDialog.C0384l lVar) {
            if (CompatUtils.m1339i(lVar.f1091c, 2)) {
                httpAuthHandler.cancel();
                return;
            }
            String[] strArr = lVar.f1091c;
            httpAuthHandler.proceed(strArr[0], strArr[1]);
        }

        /* renamed from: g */
        private boolean m1518g(WebView webView, String str, boolean z) {
            boolean z2;
            if ("NewWindow".equals(webView.getTag())) {
                webView.setTag(null);
                z2 = true;
            } else {
                z2 = false;
            }
            Timber.m971a("overrideUrlLoading: %s", str);
            if (TabItem.this.f1226l.mo863t(str) || (!z2 && z && TabItem.this.m1408C(str))) {
                return true;
            }
            ((FastView) webView).setForwardEnable(true);
            TabItem.this.m1443x();
            TabItem.this.f1226l.mo859p(webView, str);
            return false;
        }

        /* renamed from: h */
        private WebResourceResponse m1519h(WebView webView, WebResourceRequest webResourceRequest, String str) {
            WebResourceResponse q = TabItem.this.f1226l.mo860q(webView, webResourceRequest, str, TabItem.this.f1228n);
            if (!BrowserUtils.m2103x(TabItem.this.f1217c, str, GlobalConf.f1416p) && !str.endsWith("via_inject_blocker.css")) {
                TabItem.this.f1227m.mo802g(TabItem.this.f1223i, str, q != null);
            }
            return q;
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (!webView.isShown()) {
                message.sendToTarget();
                return;
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1216b);
            g.mo620L(R.string.il);
            g.mo644v(R.string.fb);
            g.mo635m(true);
            g.mo614F(17039370, new C0430t(message2));
            g.mo648z(17039360, new View$OnClickListenerC0432v(message));
            g.mo622N();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!TabItem.this.f1218d) {
                TabItem.this.f1226l.mo861r(webView);
            }
            TabItem.this.m1409E((FastView) webView);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            TabItem.this.f1228n = str;
            String n = BrowserUtils.m2093n(str, false);
            TabItem.this.mo843y();
            boolean y = BrowserUtils.m2104y(TabItem.this.f1217c, str);
            TabItem.this.f1218d = y;
            TabItem.this.f1219e = y;
            boolean isShown = webView.isShown();
            FastView fastView = (FastView) webView;
            if (isShown && !y) {
                TabItem.this.f1226l.mo854k();
            }
            TabItem.this.m1432j0();
            if (y) {
                TabItem.this.f1220f = n;
                TabItem.this.f1221g = 0;
                fastView.setWebColor(TabItem.this.f1221g);
                if (isShown) {
                    TabItem.this.f1226l.mo844a(TabItem.this.f1221g);
                }
            } else if (TabItem.this.f1221g != 0 && n.equals(TabItem.this.f1220f)) {
                TabItem.this.f1219e = true;
                fastView.setWebColor(TabItem.this.f1221g);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (!webView.isShown()) {
                httpAuthHandler.cancel();
                return;
            }
            TaoDialog g = TaoDialog.m1134g(TabItem.this.f1217c);
            g.mo620L(R.string.im);
            g.mo628c(0, "", R.string.e9, 1);
            g.mo628c(1, "", R.string.e5, 1);
            g.mo635m(false);
            g.mo614F(17039370, new C0428r(httpAuthHandler));
            g.mo648z(17039360, new View$OnClickListenerC0427q(httpAuthHandler));
            if (Build.VERSION.SDK_INT >= 26) {
                g.mo633j(0).setAutofillHints(new String[]{"username"});
                g.mo633j(1).setAutofillHints(new String[]{"password"});
                g.mo633j(1).setInputType(128);
            }
            g.mo622N();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (URLUtil.isFileUrl(webView.getUrl())) {
                sslErrorHandler.proceed();
            } else if (!webView.isShown()) {
                sslErrorHandler.cancel();
            } else {
                String str = null;
                if (!GlobalConf.f1410j) {
                    int primaryError = sslError.getPrimaryError();
                    if (primaryError == 0) {
                        str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.fg);
                    } else if (primaryError == 1) {
                        str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.fa);
                    } else if (primaryError == 2) {
                        str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.fc);
                    } else if (primaryError == 3) {
                        str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.fh);
                    } else if (primaryError == 4) {
                        str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.f6);
                    } else if (primaryError == 5) {
                        str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.fe);
                    }
                } else if (ChannelUtils.m2108c() && sslError.getPrimaryError() == 3) {
                    str = CompatUtils.m1336f(TabItem.this.f1217c, R.string.fh);
                }
                if (str != null) {
                    TaoDialog g = TaoDialog.m1134g(TabItem.this.f1216b);
                    g.mo620L(R.string.io);
                    g.mo645w(str);
                    g.mo635m(false);
                    g.mo614F(17039370, new C0429s(sslErrorHandler));
                    g.mo648z(17039360, new View$OnClickListenerC0431u(sslErrorHandler));
                    g.mo622N();
                    return;
                }
                sslErrorHandler.proceed();
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (!(Build.VERSION.SDK_INT < 21 || TabItem.this.f1226l == null || webView == null || webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                String uri = webResourceRequest.getUrl().toString();
                if (!TextUtils.isEmpty(uri)) {
                    return m1519h(webView, webResourceRequest, uri);
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT < 24) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            String uri = webResourceRequest.getUrl().toString();
            return m1518g(webView, uri, ConfUtil.m2118e(uri) && !webResourceRequest.isRedirect() && webResourceRequest.hasGesture());
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            int i = Build.VERSION.SDK_INT;
            if (i < 11 || i >= 21 || TabItem.this.f1226l == null || webView == null || TextUtils.isEmpty(str)) {
                return super.shouldInterceptRequest(webView, str);
            }
            return m1519h(webView, null, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebView.HitTestResult hitTestResult;
            int i = Build.VERSION.SDK_INT;
            if (i < 11 || i >= 24) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return m1518g(webView, str, (!ConfUtil.m2118e(str) || (hitTestResult = webView.getHitTestResult()) == null || hitTestResult.getType() == 0) ? false : true);
        }
    }
}
