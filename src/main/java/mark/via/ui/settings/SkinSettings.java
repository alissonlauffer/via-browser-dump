package mark.via.ui.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.lib.frogsupport.adapter.util.ListUtils;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.settings.OnFrogSettingsClickListener;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FrogUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.via.BrowserApp;
import mark.via.flurry.FlurryHelper;
import mark.via.gp.R;
import mark.via.p044m.p045a.PageManager;
import mark.via.utils.AppUtils;
import mark.via.utils.FileIntentUtils;
import mark.via.utils.FileUtils;
import mark.via.utils.MenuUtils;
import mark.via.utils.ViewUtils;
import mark.via.utils.WebViewUtil;

public class SkinSettings extends BaseSettings {

    /* renamed from: d */
    private FrameLayout f1840d;

    /* renamed from: e */
    private WebView f1841e;

    /* renamed from: f */
    private boolean f1842f = false;

    /* renamed from: g */
    private boolean f1843g = false;

    /* renamed from: h */
    private boolean f1844h = false;

    /* renamed from: i */
    private TaoDialog f1845i;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SkinSettings$a */
    public class C0599a extends WebViewClient {
        C0599a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            SkinSettings.this.m2815E();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SkinSettings$b */
    public class C0600b extends WebChromeClient {
        C0600b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i > 50) {
                SkinSettings.this.m2815E();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SkinSettings$c */
    public class RunnableC0601c implements Runnable {

        /* renamed from: mark.via.ui.settings.SkinSettings$c$a */
        class RunnableC0602a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f1849a;

            RunnableC0602a(String str) {
                this.f1849a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                SkinSettings.this.f1841e.loadUrl(this.f1849a);
            }
        }

        RunnableC0601c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SkinSettings.this.runOnUiThread(new RunnableC0602a(PageManager.m1943g(((BaseActivity) SkinSettings.this).f1039b)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SkinSettings$d */
    public class C0603d implements OnFrogSettingsClickListener {
        C0603d() {
        }

        @Override // mark.lib.frogsupport.settings.OnFrogSettingsClickListener
        /* renamed from: a */
        public void mo764a(FrogSettingsBean bVar, int i) {
            int b = bVar.mo754b();
            if (b == R.string.c1) {
                SkinSettings.this.m2816F();
            } else if (b == R.string.i2) {
                SkinSettings.this.f1803c.mo1133a1(bVar.mo757e());
                DataChecker.m1181c().mo667h(1);
                SkinSettings.this.f1842f = true;
                SkinSettings.this.m2814D();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SkinSettings$e */
    public class C0604e implements SeekBar.OnSeekBarChangeListener {
        C0604e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SkinSettings.this.f1803c.mo1144e1(seekBar.getProgress());
            DataChecker.m1181c().mo667h(1);
            SkinSettings.this.f1842f = true;
            SkinSettings.this.m2814D();
        }
    }

    /* renamed from: B */
    private void m2812B(boolean z) {
        String I = this.f1803c.mo1086I();
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(z ? R.string.eb : R.string.ie);
        if ("<br>".equalsIgnoreCase(I)) {
            I = "";
        }
        g.mo629d(0, I, "", 4);
        g.mo614F(17039370, new C0638j1(this, z));
        g.mo622N();
    }

    /* renamed from: C */
    private void m2813C() {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.i3);
        g.mo618J(R.array.g, this.f1803c.mo1123W(), new C0623e1(this));
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: D */
    private void m2814D() {
        if (this.f1841e == null) {
            this.f1843g = !this.f1803c.mo1074E().isEmpty() || !this.f1803c.mo1173o0().isEmpty();
            WebView webView = new WebView(this.f1038a);
            this.f1841e = webView;
            this.f1840d.addView(webView);
            this.f1841e.setOnTouchListener(View$OnTouchListenerC0641k1.f1928a);
            this.f1841e.setHorizontalScrollBarEnabled(false);
            this.f1841e.setVerticalScrollBarEnabled(false);
            WebSettings settings = this.f1841e.getSettings();
            settings.setJavaScriptEnabled(true);
            int n0 = this.f1803c.mo1170n0();
            if (n0 > 5 || n0 < 1) {
                n0 = 3;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 14) {
                settings.setTextZoom(new int[]{130, 115, 100, 85, 70}[n0 - 1]);
            } else {
                settings.setTextSize(new WebSettings.TextSize[]{WebSettings.TextSize.LARGEST, WebSettings.TextSize.LARGER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.SMALLER, WebSettings.TextSize.SMALLEST}[n0 - 1]);
            }
            if (i >= 11) {
                settings.setAllowContentAccess(true);
            }
            settings.setAllowFileAccess(true);
            if (i >= 16) {
                settings.setAllowFileAccessFromFileURLs(true);
            }
            this.f1841e.setWebViewClient(new C0599a());
            this.f1841e.setWebChromeClient(new C0600b());
        }
        this.f1844h = this.f1843g;
        BrowserApp.m1389c().execute(new RunnableC0601c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: E */
    private void m2815E() {
        if (this.f1844h) {
            this.f1844h = false;
            new Handler().postDelayed(new RunnableC0635i1(this), 500);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: F */
    private void m2816F() {
        TaoDialog cVar = this.f1845i;
        if (cVar != null) {
            cVar.mo632i();
        }
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.c1);
        g.mo630e(this.f1803c.mo1173o0(), R.string.c1, 8);
        g.mo636n(false);
        g.mo614F(17039370, new C0617c1(this));
        g.mo622N();
    }

    /* renamed from: G */
    private void m2817G() {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.i5);
        g.mo618J(R.array.f, this.f1803c.mo1083H(), new C0626f1(this));
        g.mo622N();
    }

    /* renamed from: g */
    private void m2824g() {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.hz);
        g.mo618J(R.array.a, !this.f1803c.mo1074E().isEmpty(), new C0629g1(this));
        g.mo622N();
    }

    /* renamed from: h */
    private View m2825h() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.hj);
        g.mo734k(R.string.cg);
        View p = g.mo738p();
        View inflate = ((LayoutInflater) this.f1039b.getSystemService("layout_inflater")).inflate(R.layout.y, (ViewGroup) this.f1038a.findViewById(16908290), false);
        CompatUtils.m1346p(inflate.findViewById(R.id.am), !"about:home".equals(this.f1803c.mo1071D()));
        this.f1840d = (FrameLayout) inflate.findViewById(R.id.a);
        int b = CompatUtils.m1332b(this.f1039b, R.attr.j);
        MenuUtils.m2185a(inflate, R.id.a8, R.drawable.ax, b);
        MenuUtils.m2185a(inflate, R.id.c, R.drawable.am, b);
        MenuUtils.m2185a(inflate, R.id.an, R.drawable.au, b);
        MenuUtils.m2185a(inflate, R.id.aj, R.drawable.as, b);
        return LayoutUtils.m1365c(p, inflate);
    }

    /* renamed from: i */
    private void m2826i(int i) {
        int i2;
        if (ViewUtils.m2239q(i) || this.f1803c.mo1129Z(this.f1039b)) {
            i2 = CompatUtils.m1331a(this.f1039b, R.color.x);
        } else {
            i2 = CompatUtils.m1331a(this.f1039b, R.color.y);
        }
        if (!this.f1803c.mo1129Z(this.f1039b)) {
            findViewById(FrogNavigator.f1148f).setBackgroundColor(i);
            ((ImageView) findViewById(FrogNavigator.f1150h)).setColorFilter(i2);
            ((TextView) findViewById(FrogNavigator.f1149g)).setTextColor(i2);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21) {
                ViewUtils.m2214A(this.f1038a, findViewById(FrogNavigator.f1148f), i);
                if (i3 >= 27) {
                    ViewUtils.m2248z(this.f1038a, ViewUtils.m2239q(i));
                    getWindow().setNavigationBarColor(i);
                }
            }
        }
        int q0 = this.f1803c.mo1179q0();
        this.f1803c.mo1088I1(i);
        if (ViewUtils.m2239q(q0) != ViewUtils.m2239q(i)) {
            DataChecker.m1181c().mo667h(1);
            this.f1842f = true;
            m2814D();
        }
    }

    /* renamed from: j */
    private void m2827j() {
        if (this.f1845i == null) {
            FrogSettings j = FrogSettings.m1279j(this.f1039b);
            j.mo743e(FrogSettingsBean.m1297p(this.f1039b, R.string.i2, this.f1803c.mo1065B()));
            j.mo743e(FrogSettingsBean.m1292k(this.f1039b, R.string.c1));
            j.mo744g();
            j.mo748l(new C0603d());
            View o = j.mo750o();
            ListUtils.m1229b((ListView) o);
            TextView textView = new TextView(new ContextThemeWrapper(this.f1039b, (int) R.style.k));
            CompatUtils.m1343m(textView, CompatUtils.m1333c(this.f1039b, R.dimen.j), FrogUtils.m1354a(this.f1039b, 10.0f));
            textView.setText(R.string.b6);
            textView.setId(99);
            SeekBar seekBar = new SeekBar(new ContextThemeWrapper(this.f1039b, (int) R.style.q));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            int c = CompatUtils.m1333c(this.f1039b, R.dimen.j);
            layoutParams.leftMargin = c;
            layoutParams.rightMargin = c;
            int a = FrogUtils.m1354a(this.f1039b, 12.0f);
            layoutParams.topMargin = a;
            layoutParams.bottomMargin = a;
            seekBar.setLayoutParams(layoutParams);
            seekBar.setId(88);
            seekBar.setMax(80);
            seekBar.setProgress(Math.min(this.f1803c.mo1080G(), 80));
            seekBar.setProgressDrawable(CompatUtils.m1334d(this.f1039b, R.drawable.x));
            seekBar.setThumb(CompatUtils.m1334d(this.f1039b, R.drawable.y));
            seekBar.setMinimumHeight(FrogUtils.m1354a(this.f1039b, 2.0f));
            seekBar.setOnSeekBarChangeListener(new C0604e());
            TaoDialog g = TaoDialog.m1134g(this.f1039b);
            g.mo639q(LayoutUtils.m1365c(o, textView, seekBar));
            this.f1845i = g;
        }
        this.f1845i.mo622N();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void mo1522l(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            this.f1803c.mo1141d1("");
            this.f1843g = false;
            this.f1803c.mo1088I1(-1);
            m2826i(-1);
            DataChecker.m1181c().mo667h(1);
            this.f1842f = true;
            m2814D();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, this.f1039b.getResources().getString(R.string.gn)), 177);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void mo1523n(boolean z, View view, TaoDialog.C0384l lVar) {
        String str = lVar.f1091c[0];
        if (str != null) {
            if (z && !"<img class=\"smaller\" src=\"file:///android_asset/logo.png\"></img>".contains(str)) {
                this.f1803c.mo1150g1(str);
                this.f1803c.mo1186s1(3);
            } else if (!z) {
                this.f1803c.mo1186s1(2);
                this.f1803c.mo1150g1(str);
            }
            DataChecker.m1181c().mo667h(1);
            this.f1842f = true;
            m2814D();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void mo1530p(AdapterView adapterView, View view, int i, long j) {
        boolean z = false;
        if (i == 0) {
            this.f1803c.mo1150g1("");
            this.f1803c.mo1186s1(0);
            DataChecker.m1181c().mo667h(1);
            this.f1842f = true;
            m2814D();
        } else if (i == 1) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, this.f1039b.getResources().getString(R.string.gn)), 176);
        } else if (i == 2 || i == 3) {
            if (i > 2) {
                z = true;
            }
            m2812B(z);
        } else if (i == 4) {
            this.f1803c.mo1150g1("<br>");
            this.f1803c.mo1186s1(4);
            DataChecker.m1181c().mo667h(1);
            this.f1842f = true;
            m2814D();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void mo1531r(int i, String str) {
        if (i == 176) {
            StringBuilder sb = new StringBuilder();
            sb.append("<img class=\"smaller\" src=\"file:///");
            if (str == null) {
                str = "android_asset/logo.png";
            }
            sb.append(str);
            sb.append("\"></img>");
            String sb2 = sb.toString();
            this.f1803c.mo1186s1(1);
            this.f1803c.mo1150g1(sb2);
        } else if (str != null) {
            this.f1803c.mo1141d1(str);
            this.f1843g = true;
        } else {
            return;
        }
        DataChecker.m1181c().mo667h(1);
        this.f1842f = true;
        m2814D();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void mo1532t(String str, Uri uri, int i, String str2) {
        String str3;
        if (!str.isEmpty()) {
            Context context = this.f1039b;
            StringBuilder sb = new StringBuilder();
            sb.append(i == 176 ? "logo" : "bg");
            sb.append(str2);
            str3 = FileIntentUtils.m2141b(context, uri, sb.toString());
        } else {
            str3 = null;
        }
        runOnUiThread(new RunnableC0620d1(this, i, str3));
    }

    /* renamed from: u */
    static /* synthetic */ boolean m2833u(View view, MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void mo1533w() {
        m2826i(ViewUtils.m2231i(this.f1841e));
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void mo1534y(View view, TaoDialog.C0384l lVar) {
        this.f1803c.mo1082G1(lVar.f1091c[0]);
        DataChecker.m1181c().mo667h(1);
        this.f1842f = true;
        m2814D();
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void mo1521A(AdapterView adapterView, View view, int i, long j) {
        this.f1803c.mo1147f1(i);
        DataChecker.m1181c().mo667h(1);
        this.f1842f = true;
        m2814D();
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String l = FileUtils.m2156l(this.f1039b, data);
            int lastIndexOf = l.lastIndexOf(46);
            String substring = lastIndexOf > -1 ? l.substring(lastIndexOf) : ".png";
            if (i == 176 || i == 177) {
                BrowserApp.m1389c().execute(new RunnableC0632h1(this, l, data, i, substring));
            }
        }
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m2825h());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
        m2826i(this.f1803c.mo1179q0());
        m2814D();
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        this.f1803c.mo1107P0(DataChecker.m1181c().mo662b());
        this.f1840d.removeAllViews();
        WebViewUtil.m2041a(this.f1841e);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        WebViewUtil.m2049i(this.f1841e);
        if (this.f1842f) {
            DataChecker.m1181c().mo668i(1, 2, 3, 4, 5);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        AppUtils.m2062j(this.f1039b, i, iArr);
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WebViewUtil.m2050j(this.f1841e);
    }

    public void onSettingsItemClick(View view) {
        switch (view.getId()) {
            case R.id.c /* 2131230722 */:
                FlurryHelper.m1681a().mo1043l("background");
                m2824g();
                return;
            case R.id.a8 /* 2131230754 */:
                FlurryHelper.m1681a().mo1043l("logo");
                m2813C();
                return;
            case R.id.aj /* 2131230766 */:
                FlurryHelper.m1681a().mo1043l("settings");
                m2827j();
                return;
            case R.id.ak /* 2131230767 */:
                this.f1803c.mo1139c1("about:home");
                findViewById(R.id.am).setVisibility(8);
                return;
            case R.id.an /* 2131230770 */:
                FlurryHelper.m1681a().mo1043l("style");
                m2817G();
                return;
            default:
                return;
        }
    }
}
