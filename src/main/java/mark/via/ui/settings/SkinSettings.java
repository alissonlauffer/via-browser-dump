package mark.via.ui.settings;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.BrowserApp;
import mark.via.gp.R;
import mark.via.util.r;

public class SkinSettings extends BaseSettings {
    private FrameLayout d;
    /* access modifiers changed from: private */
    public WebView e;
    /* access modifiers changed from: private */
    public boolean f = false;
    /* access modifiers changed from: private */
    public boolean g = false;
    private boolean h = false;
    private a.a.b.i.b i;

    class a extends a.a.b.i.i {
        a() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            ((BaseSettings) SkinSettings.this).c.q(strArr[0]);
            a.a.b.j.a.b().d(1);
            boolean unused = SkinSettings.this.f = true;
            SkinSettings.this.e();
        }
    }

    class b implements a.a.b.n.c {
        b() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        @Override // a.a.b.n.c
        public void a(a.a.b.n.b bVar, int i) {
            int b = bVar.b();
            if (b == R.string.bz) {
                SkinSettings.this.g();
            } else if (b == R.string.hg) {
                ((BaseSettings) SkinSettings.this).c.j(bVar.e());
                a.a.b.j.a.b().d(1);
                boolean unused = SkinSettings.this.f = true;
                SkinSettings.this.e();
            }
        }
    }

    class c implements SeekBar.OnSeekBarChangeListener {
        c() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        public void onStopTrackingTouch(SeekBar seekBar) {
            ((BaseSettings) SkinSettings.this).c.l(seekBar.getProgress());
            a.a.b.j.a.b().d(1);
            boolean unused = SkinSettings.this.f = true;
            SkinSettings.this.e();
        }
    }

    class d implements View.OnTouchListener {
        d(SkinSettings skinSettings) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends WebViewClient {
        e() {
        }

        public void onPageFinished(WebView webView, String str) {
            SkinSettings.this.f();
        }
    }

    class f extends WebChromeClient {
        f() {
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i > 50) {
                SkinSettings.this.f();
            }
        }
    }

    class g implements Runnable {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f433a;

            a(String str) {
                this.f433a = str;
            }

            public void run() {
                SkinSettings.this.e.loadUrl(this.f433a);
            }
        }

        g() {
        }

        public void run() {
            SkinSettings.this.runOnUiThread(new a(mark.via.i.b.a.e(((BaseActivity) SkinSettings.this).b)));
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            SkinSettings.this.a(r.a(SkinSettings.this.e));
        }
    }

    class i extends a.a.b.i.i {
        i() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        @Override // a.a.b.i.i
        public void a(int i) {
            boolean z = false;
            if (i == 0) {
                ((BaseSettings) SkinSettings.this).c.m("");
                ((BaseSettings) SkinSettings.this).c.s(0);
                a.a.b.j.a.b().d(1);
                boolean unused = SkinSettings.this.f = true;
                SkinSettings.this.e();
            } else if (i != 1) {
                if (i == 2 || i == 3) {
                    SkinSettings skinSettings = SkinSettings.this;
                    if (i > 2) {
                        z = true;
                    }
                    skinSettings.a(z);
                } else if (i == 4) {
                    ((BaseSettings) SkinSettings.this).c.m("<br>");
                    ((BaseSettings) SkinSettings.this).c.s(4);
                    a.a.b.j.a.b().d(1);
                    boolean unused2 = SkinSettings.this.f = true;
                    SkinSettings.this.e();
                }
            } else if (mark.via.util.a.a(((BaseActivity) SkinSettings.this).b, 0)) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.PICK");
                intent.setType("image/*");
                try {
                    SkinSettings.this.startActivityForResult(Intent.createChooser(intent, ((BaseActivity) SkinSettings.this).b.getResources().getString(R.string.g4)), 176);
                } catch (Exception e) {
                    a.a.b.p.d.a(e);
                }
            }
        }
    }

    class j extends a.a.b.i.i {
        j() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        @Override // a.a.b.i.i
        public void a(int i) {
            if (i == 0) {
                ((BaseSettings) SkinSettings.this).c.l("");
                boolean unused = SkinSettings.this.g = false;
                ((BaseSettings) SkinSettings.this).c.y(-1);
                SkinSettings.this.a(-1);
                a.a.b.j.a.b().d(1);
                boolean unused2 = SkinSettings.this.f = true;
                SkinSettings.this.e();
            } else if (mark.via.util.a.a(((BaseActivity) SkinSettings.this).b, 0)) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.PICK");
                intent.setType("image/*");
                try {
                    SkinSettings.this.startActivityForResult(Intent.createChooser(intent, ((BaseActivity) SkinSettings.this).b.getResources().getString(R.string.g4)), 177);
                } catch (Exception e) {
                    a.a.b.p.d.a(e);
                }
            }
        }
    }

    class k extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f437a;

        k(boolean z) {
            this.f437a = z;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            String str = strArr[0];
            if (str != null) {
                if (this.f437a && !"<img class=\"smaller\" src=\"file:///android_asset/logo.png\"></img>".contains(str)) {
                    ((BaseSettings) SkinSettings.this).c.m(str);
                    ((BaseSettings) SkinSettings.this).c.s(3);
                } else if (!this.f437a) {
                    ((BaseSettings) SkinSettings.this).c.s(2);
                    ((BaseSettings) SkinSettings.this).c.m(str);
                }
                a.a.b.j.a.b().d(1);
                boolean unused = SkinSettings.this.f = true;
                SkinSettings.this.e();
            }
        }
    }

    class l extends a.a.b.i.i {
        l() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean
         arg types: [mark.via.ui.settings.SkinSettings, int]
         candidates:
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, int):void
          mark.via.ui.settings.SkinSettings.a(mark.via.ui.settings.SkinSettings, boolean):boolean */
        @Override // a.a.b.i.i
        public void a(int i) {
            ((BaseSettings) SkinSettings.this).c.m(i);
            a.a.b.j.a.b().d(1);
            boolean unused = SkinSettings.this.f = true;
            SkinSettings.this.e();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (intent != null) {
            String b2 = mark.via.util.h.b(((BaseActivity) this).b, intent.getData());
            if (i2 == 176) {
                if (b2.isEmpty()) {
                    b2 = "android_asset/logo.png";
                }
                ((BaseSettings) this).c.s(1);
                ((BaseSettings) this).c.m("<img class=\"smaller\" src=\"file:///" + b2 + "\"></img>");
                a.a.b.j.a.b().d(1);
                this.f = true;
                e();
            } else if (i2 == 177) {
                ((BaseSettings) this).c.l(b2);
                this.g = true;
                a.a.b.j.a.b().d(1);
                this.f = true;
                e();
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b());
        r.b(findViewById(a.a.b.m.a.f));
        a(((BaseSettings) this).c.e0());
        e();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ((BaseSettings) this).c.g(a.a.b.j.a.b().a());
        this.d.removeAllViews();
        mark.via.h.c.d.a(this.e);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        mark.via.h.c.d.d(this.e);
        if (this.f) {
            a.a.b.j.a.b().a(1, 2, 3, 4, 5);
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        mark.via.util.a.a(((BaseActivity) this).b, i2, iArr);
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings
    public void onResume() {
        super.onResume();
        mark.via.h.c.d.e(this.e);
        mark.via.util.i.a(((BaseActivity) this).b);
    }

    public void onSettingsItemClick(View view) {
        switch (view.getId()) {
            case R.id.c /*{ENCODED_INT: 2131230722}*/:
                mark.via.d.a.a().h("background");
                a();
                return;
            case R.id.ab /*{ENCODED_INT: 2131230758}*/:
                mark.via.d.a.a().h("logo");
                d();
                return;
            case R.id.an /*{ENCODED_INT: 2131230770}*/:
                mark.via.d.a.a().h("settings");
                c();
                return;
            case R.id.ao /*{ENCODED_INT: 2131230771}*/:
                ((BaseSettings) this).c.k("about:home");
                findViewById(R.id.aq).setVisibility(8);
                return;
            case R.id.ar /*{ENCODED_INT: 2131230774}*/:
                mark.via.d.a.a().h("style");
                h();
                return;
            default:
                return;
        }
    }

    private void d() {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.hh);
        hVar.b(R.array.g, ((BaseSettings) this).c.O());
        hVar.a(new i());
        hVar.a(findViewById(R.id.ab));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void e() {
        if (this.e == null) {
            this.g = !((BaseSettings) this).c.w().isEmpty() || !((BaseSettings) this).c.c0().isEmpty();
            WebView webView = new WebView(((BaseActivity) this).f233a);
            this.e = webView;
            this.d.addView(webView);
            this.e.setOnTouchListener(new d(this));
            this.e.setHorizontalScrollBarEnabled(false);
            this.e.setVerticalScrollBarEnabled(false);
            WebSettings settings = this.e.getSettings();
            settings.setJavaScriptEnabled(true);
            int b0 = ((BaseSettings) this).c.b0();
            if (b0 > 5 || b0 < 1) {
                b0 = 3;
            }
            if (Build.VERSION.SDK_INT >= 14) {
                settings.setTextZoom(new int[]{130, 115, 100, 85, 70}[b0 - 1]);
            } else {
                settings.setTextSize(new WebSettings.TextSize[]{WebSettings.TextSize.LARGEST, WebSettings.TextSize.LARGER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.SMALLER, WebSettings.TextSize.SMALLEST}[b0 - 1]);
            }
            this.e.setWebViewClient(new e());
            this.e.setWebChromeClient(new f());
        }
        this.h = this.g;
        BrowserApp.b().execute(new g());
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.h) {
            this.h = false;
            new Handler().postDelayed(new h(), 500);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        a.a.b.i.b bVar = this.i;
        if (bVar != null) {
            bVar.c();
        }
        a.a.b.i.d dVar = new a.a.b.i.d(((BaseActivity) this).b);
        dVar.a(0, ((BaseSettings) this).c.c0(), R.string.bz);
        dVar.b(0, 8);
        ((a.a.b.i.d) dVar.a(17039370, new a())).a(findViewById(R.id.an));
    }

    private void h() {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.hj);
        hVar.b(R.array.f, ((BaseSettings) this).c.z());
        hVar.a(new l());
        hVar.a(findViewById(R.id.ar));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gz);
        a2.a(R.string.ca);
        View a3 = a2.a();
        View inflate = ((LayoutInflater) ((BaseActivity) this).b.getSystemService("layout_inflater")).inflate(R.layout.x, (ViewGroup) ((BaseActivity) this).f233a.findViewById(16908290), false);
        a.a.b.p.a.a(inflate.findViewById(R.id.aq), !"about:home".equals(((BaseSettings) this).c.v()));
        this.d = (FrameLayout) inflate.findViewById(R.id.f502a);
        int b2 = a.a.b.p.a.b(((BaseActivity) this).b, (int) R.attr.j);
        mark.via.util.l.a(inflate, R.id.ab, R.drawable.ay, b2);
        mark.via.util.l.a(inflate, R.id.c, R.drawable.an, b2);
        mark.via.util.l.a(inflate, R.id.ar, R.drawable.av, b2);
        mark.via.util.l.a(inflate, R.id.an, R.drawable.at, b2);
        return a.a.b.p.c.a(a3, inflate);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    private void c() {
        if (this.i == null) {
            a.a.b.n.a a2 = a.a.b.n.a.a(((BaseActivity) this).b);
            a2.a(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.hg, ((BaseSettings) this).c.t()));
            a2.a(a.a.b.n.b.a(((BaseActivity) this).b, R.string.bz));
            a2.a();
            a2.a(new b());
            View b2 = a2.b();
            a.a.b.k.f.a.a((ListView) b2);
            TextView textView = new TextView(new ContextThemeWrapper(((BaseActivity) this).b, (int) R.style.j));
            a.a.b.p.a.a(textView, a.a.b.p.a.c(((BaseActivity) this).b, R.dimen.e), a.a.b.p.b.a(((BaseActivity) this).b, 10.0f));
            textView.setText(R.string.b5);
            textView.setId(99);
            SeekBar seekBar = new SeekBar(new ContextThemeWrapper(((BaseActivity) this).b, (int) R.style.p));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            int c2 = a.a.b.p.a.c(((BaseActivity) this).b, R.dimen.e);
            layoutParams.leftMargin = c2;
            layoutParams.rightMargin = c2;
            int a3 = a.a.b.p.b.a(((BaseActivity) this).b, 2.0f);
            layoutParams.topMargin = a3;
            layoutParams.bottomMargin = a3;
            seekBar.setLayoutParams(layoutParams);
            seekBar.setId(88);
            seekBar.setMax(80);
            seekBar.setProgress(Math.min(((BaseSettings) this).c.y(), 80));
            seekBar.setProgressDrawable(a.a.b.p.a.d(((BaseActivity) this).b, R.drawable.z));
            seekBar.setThumb(a.a.b.p.a.d(((BaseActivity) this).b, R.drawable.a0));
            seekBar.setMinimumHeight(a.a.b.p.b.a(((BaseActivity) this).b, 2.0f));
            seekBar.setOnSeekBarChangeListener(new c());
            a.a.b.i.b bVar = new a.a.b.i.b(((BaseActivity) this).b);
            this.i = bVar;
            bVar.b(a.a.b.p.c.a(b2, textView, seekBar));
        }
        this.i.a(findViewById(R.id.an));
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        int i3;
        if (r.a(i2) || ((BaseSettings) this).c.a(((BaseActivity) this).b)) {
            i3 = a.a.b.p.a.a(((BaseActivity) this).b, (int) R.color.w);
        } else {
            i3 = a.a.b.p.a.a(((BaseActivity) this).b, (int) R.color.x);
        }
        if (!((BaseSettings) this).c.a(((BaseActivity) this).b)) {
            findViewById(a.a.b.m.a.f).setBackgroundColor(i2);
            ((ImageView) findViewById(a.a.b.m.a.h)).setColorFilter(i3);
            ((TextView) findViewById(a.a.b.m.a.g)).setTextColor(i3);
            if (Build.VERSION.SDK_INT >= 21) {
                r.a(((BaseActivity) this).f233a, findViewById(a.a.b.m.a.f), i2);
                if (Build.VERSION.SDK_INT >= 27) {
                    r.d(((BaseActivity) this).f233a, r.a(i2));
                    getWindow().setNavigationBarColor(i2);
                }
            }
        }
        int e0 = ((BaseSettings) this).c.e0();
        ((BaseSettings) this).c.y(i2);
        if (r.a(e0) != r.a(i2)) {
            a.a.b.j.a.b().d(1);
            this.f = true;
            e();
        }
    }

    private void a() {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.hd);
        hVar.b(R.array.f496a, ((BaseSettings) this).c.w().isEmpty() ^ true ? 1 : 0);
        hVar.a(new j());
        hVar.a(findViewById(R.id.c));
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        String A = ((BaseSettings) this).c.A();
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(z ? R.string.dv : R.string.ht);
        if ("<br>".equalsIgnoreCase(A)) {
            A = "";
        }
        dVar.a(0, A, "");
        dVar.b(0, 4);
        ((a.a.b.i.d) dVar.a(17039370, new k(z))).a(findViewById(R.id.ab));
    }
}
