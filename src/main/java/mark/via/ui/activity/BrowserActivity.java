package mark.via.ui.activity;

import a.a.a.a;
import a.a.b.k.e.a;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebIconDatabase;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mark.via.BrowserApp;
import mark.via.c.a;
import mark.via.g.a;
import mark.via.gp.R;
import mark.via.i.c.c;
import mark.via.i.d.a;
import mark.via.i.d.b;
import mark.via.ui.bookmark.BookmarksManager;
import mark.via.ui.settings.AccountSettings;
import mark.via.ui.settings.SettingsCatalog;
import mark.via.ui.view.FastView;
import mark.via.ui.view.a;
import org.json.JSONArray;

public class BrowserActivity extends Activity implements a.g {
    private ImageView A;
    /* access modifiers changed from: private */
    public ListView A0;
    /* access modifiers changed from: private */
    public int B = 0;
    private Drawable B0;
    private BroadcastReceiver C;
    private mark.via.i.d.b C0;
    private int D;
    /* access modifiers changed from: private */
    public boolean D0 = false;
    /* access modifiers changed from: private */
    public FrameLayout E;
    private boolean E0 = false;
    /* access modifiers changed from: private */
    public int F;
    HashMap<String, String> F0 = null;
    private View G;
    private final ViewTreeObserver.OnGlobalLayoutListener G0 = new i0();
    private boolean H = false;
    private boolean H0 = false;
    /* access modifiers changed from: private */
    public ImageView I;
    /* access modifiers changed from: private */
    public int I0 = -1;
    /* access modifiers changed from: private */
    public ImageView J;
    private boolean J0 = false;
    /* access modifiers changed from: private */
    public View K;
    private boolean K0 = false;
    /* access modifiers changed from: private */
    public FrameLayout L;
    private boolean L0 = false;
    private View M;
    private final View.OnClickListener M0 = new j0();
    /* access modifiers changed from: private */
    public FrameLayout N;
    /* access modifiers changed from: private */
    public boolean N0 = false;
    private ImageView O;
    private final View.OnLongClickListener O0 = new n0();
    private View P;
    private mark.via.i.d.c Q;
    /* access modifiers changed from: private */
    public int R;
    private final AtomicBoolean S = new AtomicBoolean(false);
    private LayoutInflater T;
    private BrowserJsCallback U;
    /* access modifiers changed from: private */
    public int V = -1;
    private int W = -1;
    private boolean X = false;
    private boolean Y = false;
    /* access modifiers changed from: private */
    public boolean Z = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f293a;
    /* access modifiers changed from: private */
    public int a0 = -1;
    /* access modifiers changed from: private */
    public Context b;
    /* access modifiers changed from: private */
    public ViewGroup b0;
    /* access modifiers changed from: private */
    public List<mark.via.ui.view.a> c;
    private boolean c0 = false;
    private View d;
    private boolean d0 = false;
    private TextView e;
    private GestureDetector e0;
    /* access modifiers changed from: private */
    public FrameLayout f;
    /* access modifiers changed from: private */
    public a.a.a.a f0;
    /* access modifiers changed from: private */
    public RelativeLayout g;
    /* access modifiers changed from: private */
    public boolean g0 = false;
    /* access modifiers changed from: private */
    public AutoCompleteTextView h;
    /* access modifiers changed from: private */
    public mark.via.i.a.a h0;
    /* access modifiers changed from: private */
    public ProgressBar i;
    private int i0 = 0;
    /* access modifiers changed from: private */
    public mark.via.ui.view.a j = null;
    private int j0 = 0;
    /* access modifiers changed from: private */
    public int k = -1;
    private a.a.b.j.a k0;
    private int l = 0;
    /* access modifiers changed from: private */
    public mark.via.i.c.b l0;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public mark.via.i.c.a m0;
    private String n;
    private boolean n0 = false;
    /* access modifiers changed from: private */
    public mark.via.c.b o;
    /* access modifiers changed from: private */
    public int o0 = -1;
    /* access modifiers changed from: private */
    public mark.via.f.a p;
    private final AtomicBoolean p0 = new AtomicBoolean(false);
    private ValueCallback<Uri> q;
    private int q0;
    private mark.via.c.a r;
    private int r0;
    private View s;
    private WebView s0;
    private FrameLayout t;
    private a.a.b.l.c t0 = new m();
    private WebChromeClient.CustomViewCallback u;
    private View u0;
    private ImageView v;
    /* access modifiers changed from: private */
    public a.a.b.l.a v0;
    private long w = 0;
    private List<a.a.b.l.b> w0 = new ArrayList();
    /* access modifiers changed from: private */
    public int x = 0;
    /* access modifiers changed from: private */
    public List<a.a.b.l.b> x0 = new ArrayList();
    /* access modifiers changed from: private */
    public int y = 0;
    private View y0;
    private ValueCallback<Uri[]> z;
    /* access modifiers changed from: private */
    public a.a.b.k.a z0;

    private class BrowserJsCallback {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f294a;

            a(String str) {
                this.f294a = str;
            }

            public void run() {
                a.a.b.p.d.a("search: " + this.f294a);
                BrowserActivity.this.d(this.f294a);
            }
        }

        private BrowserJsCallback() {
        }

        @JavascriptInterface
        public void addon(String str) {
            mark.via.a.a c = mark.via.util.b.c(str);
            if (c != null) {
                int f = c.f();
                if (BrowserActivity.this.o.b(f)) {
                    BrowserActivity.this.o.a(f);
                    a.a.b.p.e.a(BrowserActivity.this.b, BrowserActivity.this.b.getResources().getString(R.string.ii));
                    return;
                }
                BrowserActivity.this.o.a(c);
                a.a.b.p.e.a(BrowserActivity.this.b, BrowserActivity.this.b.getResources().getString(R.string.ee));
            }
        }

        @JavascriptInterface
        public void changeBookmarkOrder(int i, int i2) {
            BrowserActivity.this.o.a(a.a.b.p.a.e(BrowserActivity.this.b, R.string.g).equals(BrowserActivity.this.j.k()) ? "" : BrowserActivity.this.j.k(), i, i2);
            a.a.b.j.a.b().d(2);
        }

        @JavascriptInterface
        public void changeFavoriteOrder(int i, int i2) {
            BrowserActivity.this.o.a(i, i2);
            a.a.b.j.a.b().d(1);
        }

        @JavascriptInterface
        public String getInstalledAddonID() {
            List<Integer> c = BrowserActivity.this.o.c();
            JSONArray jSONArray = new JSONArray();
            for (Integer num : c) {
                jSONArray.put(num.intValue());
            }
            return jSONArray.toString();
        }

        @JavascriptInterface
        public void openSettings(int i) {
            if (i != 0) {
                if (i == 1) {
                    Intent intent = new Intent(BrowserActivity.this.f293a, AccountSettings.class);
                    intent.putExtra("info", i);
                    BrowserActivity.this.f293a.startActivity(intent);
                }
            } else if (mark.via.util.a.a(BrowserActivity.this.b, 0)) {
                Intent intent2 = new Intent();
                intent2.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath())), "*/*");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setClass(BrowserActivity.this.f293a, FileFinder.class);
                BrowserActivity.this.f293a.startActivityForResult(intent2, 101);
            }
        }

        @JavascriptInterface
        public void record(String str, String str2) {
            if (str != null && !str.isEmpty() && !str.startsWith("file://")) {
                BrowserActivity.this.o.a(str, str2, str2.contains(","));
            }
        }

        @JavascriptInterface
        public void searchText(String str) {
            BrowserActivity.this.f293a.runOnUiThread(new a(str));
        }

        @JavascriptInterface
        public void toast(String str) {
            a.a.b.p.e.a(BrowserActivity.this.b, str);
        }

        /* synthetic */ BrowserJsCallback(BrowserActivity browserActivity, j jVar) {
            this();
        }
    }

    class a extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f295a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String[] d;

        /* renamed from: mark.via.ui.activity.BrowserActivity$a$a  reason: collision with other inner class name */
        class C0040a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String[] f296a;

            C0040a(String[] strArr) {
                this.f296a = strArr;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: mark.via.util.a.a(android.content.Context, boolean):java.lang.String
             arg types: [android.app.Activity, int]
             candidates:
              mark.via.util.a.a(android.app.Activity, java.lang.String):void
              mark.via.util.a.a(android.content.Context, android.view.View):void
              mark.via.util.a.a(android.content.Context, int):boolean
              mark.via.util.a.a(android.content.Context, java.lang.String):boolean
              mark.via.util.a.a(android.content.Context, java.lang.String[]):boolean
              mark.via.util.a.a(android.content.Context, boolean):java.lang.String */
            public void run() {
                Activity e0 = BrowserActivity.this.f293a;
                String str = a.this.b;
                StringBuilder sb = new StringBuilder();
                sb.append(mark.via.util.a.a((Context) BrowserActivity.this.f293a, false));
                sb.append(this.f296a[0]);
                a.a.b.p.e.a(BrowserActivity.this.f293a, mark.via.util.b.a(e0, str, sb.toString()) ? R.string.ct : R.string.cu);
            }
        }

        class b extends a.a.b.o.c {
            b() {
            }

            @Override // a.a.b.o.c
            public void a() {
                BrowserActivity.this.j(5);
            }
        }

        a(boolean z, String str, String str2, String[] strArr) {
            this.f295a = z;
            this.b = str;
            this.c = str2;
            this.d = strArr;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                if (this.f295a) {
                    BrowserApp.b().execute(new C0040a(strArr));
                    return;
                }
                long a2 = BrowserActivity.this.f0.a(strArr[1], strArr[0], this.c, this.d[1]);
                if (a2 == -1) {
                    a.a.b.p.e.a(BrowserActivity.this.b, (int) R.string.cu);
                    return;
                }
                BrowserActivity.this.m0.a(a2);
                new a.a.b.o.a(BrowserActivity.this.f293a, (int) R.string.cx, (int) R.string.iv, new b()).h();
            }
        }
    }

    class a0 implements AdapterView.OnItemClickListener {
        a0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                BrowserActivity.this.d(((TextView) view.findViewById(R.id.bj)).getText().toString());
            } catch (Exception e) {
                a.a.b.p.d.a(e);
            }
        }
    }

    class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f299a;

        b(BrowserActivity browserActivity, EditText editText) {
            this.f299a = editText;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                String obj = this.f299a.getText().toString();
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf == -1 || obj.length() - lastIndexOf >= 7) {
                    this.f299a.selectAll();
                } else {
                    this.f299a.setSelection(0, lastIndexOf);
                }
            }
        }
    }

    class b0 extends a.a.b.o.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f300a;

        b0(String[] strArr) {
            this.f300a = strArr;
        }

        @Override // a.a.b.o.c
        public void a() {
            boolean unused = BrowserActivity.this.a(this.f300a);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f301a;
        final /* synthetic */ String[] b;
        final /* synthetic */ a.a.b.i.d c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f302a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.f302a = str;
                this.b = str2;
            }

            public void run() {
                if (!TextUtils.isEmpty(this.f302a)) {
                    c.this.c.a(this.f302a);
                }
                c.this.c.a(0, this.b);
            }
        }

        c(String str, String[] strArr, a.a.b.i.d dVar) {
            this.f301a = str;
            this.b = strArr;
            this.c = dVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        public void run() {
            HttpURLConnection httpURLConnection;
            Throwable th;
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f301a).openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestProperty("Cookie", CookieManager.getInstance().getCookie(this.f301a));
                    httpURLConnection.setDoInput(false);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        String a2 = mark.via.util.b.a(Build.VERSION.SDK_INT >= 24 ? httpURLConnection.getContentLengthLong() : (long) httpURLConnection.getContentLength());
                        this.b[1] = httpURLConnection.getContentType();
                        this.b[0] = httpURLConnection.getHeaderField("Content-Disposition");
                        a.a.b.p.d.a("fetch data: ", Arrays.toString(this.b));
                        String a3 = a.a.a.b.a(this.f301a, this.b[0], this.b[1]);
                        if (mark.via.util.c.a("vmos") && a3.endsWith(".apk")) {
                            this.b[1] = "application/vnd.android.package-archive";
                        }
                        BrowserActivity.this.f293a.runOnUiThread(new a(a.a.b.p.a.e(BrowserActivity.this.f293a, R.string.d9) + ": " + a2, a3));
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception unused) {
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                if (httpURLConnection2 == null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th3) {
                httpURLConnection = null;
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    class d implements Animation.AnimationListener {
        d() {
        }

        public void onAnimationEnd(Animation animation) {
            if (Build.VERSION.SDK_INT >= 11) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(BrowserActivity.this.f, "translationY", 0.0f, (float) BrowserActivity.this.F);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(BrowserActivity.this.i, "translationY", (float) (-BrowserActivity.this.F), 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration((long) ((BrowserActivity.this.b.getResources().getInteger(R.integer.f503a) * 3) / 2));
                animatorSet.start();
                return;
            }
            BrowserActivity.this.f.setPadding(0, BrowserActivity.this.F, 0, 0);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class d0 extends a.a.b.o.c {
        d0() {
        }

        @Override // a.a.b.o.c
        public void a() {
            mark.via.util.b.j(BrowserActivity.this.b);
        }
    }

    class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f306a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        class a implements mark.via.h.b.b {
            a() {
            }

            @Override // mark.via.h.b.b
            public void a() {
                if (mark.via.util.b.a(BrowserActivity.this.b, BrowserActivity.this.j.l(), 2)) {
                    BrowserActivity.this.j.x();
                }
            }
        }

        class b implements mark.via.h.b.b {
            b() {
            }

            @Override // mark.via.h.b.b
            public void a() {
                BrowserActivity.this.j.x();
            }
        }

        class c implements mark.via.h.b.b {
            c() {
            }

            @Override // mark.via.h.b.b
            public void a() {
                BrowserActivity.this.j.x();
            }
        }

        class d implements View.OnClickListener {
            d() {
            }

            public void onClick(View view) {
                BrowserActivity browserActivity = BrowserActivity.this;
                int c = browserActivity.g(browserActivity.R);
                if (c != -1) {
                    ((mark.via.ui.view.a) BrowserActivity.this.c.get(c)).d();
                    BrowserActivity.this.j.x();
                }
            }
        }

        e(String str, String str2, int i, String str3) {
            this.f306a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
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
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.util.a.a(android.content.Context, boolean):java.lang.String
         arg types: [android.content.Context, int]
         candidates:
          mark.via.util.a.a(android.app.Activity, java.lang.String):void
          mark.via.util.a.a(android.content.Context, android.view.View):void
          mark.via.util.a.a(android.content.Context, int):boolean
          mark.via.util.a.a(android.content.Context, java.lang.String):boolean
          mark.via.util.a.a(android.content.Context, java.lang.String[]):boolean
          mark.via.util.a.a(android.content.Context, boolean):java.lang.String */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean, java.lang.String):mark.via.ui.view.a
         arg types: [mark.via.ui.activity.BrowserActivity, int, java.lang.String]
         candidates:
          mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String, boolean):mark.via.ui.view.a
          mark.via.ui.activity.BrowserActivity.a(a.a.b.k.c, mark.via.ui.view.a, int):void
          mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String, java.lang.String):void
          mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, a.a.b.l.b, int):void
          mark.via.ui.activity.BrowserActivity.a(android.view.View, int, android.webkit.WebChromeClient$CustomViewCallback):void
          mark.via.ui.activity.BrowserActivity.a(android.webkit.WebView, boolean, android.os.Message):void
          mark.via.ui.activity.BrowserActivity.a(mark.via.ui.view.a, int, java.lang.String):void
          mark.via.ui.view.a.g.a(android.view.View, int, android.webkit.WebChromeClient$CustomViewCallback):void
          mark.via.ui.view.a.g.a(android.webkit.WebView, boolean, android.os.Message):void
          mark.via.ui.view.a.g.a(mark.via.ui.view.a, int, java.lang.String):void
          mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean, java.lang.String):mark.via.ui.view.a */
        public void onClick(View view) {
            String str;
            String str2;
            int id = view.getId();
            boolean z = false;
            switch (id) {
                case 0:
                case 1:
                    BrowserActivity browserActivity = BrowserActivity.this;
                    if (id >= 1) {
                        z = true;
                    }
                    mark.via.ui.view.a unused = browserActivity.b(z, this.f306a);
                    return;
                case 2:
                    mark.via.ui.view.a unused2 = BrowserActivity.this.b(true, this.b);
                    return;
                case 3:
                    Context y = BrowserActivity.this.b;
                    if (this.c == 6) {
                        String str3 = this.f306a;
                        str = str3.substring(str3.indexOf("://") + 3);
                    } else {
                        str = this.f306a;
                    }
                    mark.via.util.p.a(y, str, (int) R.string.i6);
                    return;
                case 4:
                case 5:
                case 30:
                default:
                    return;
                case 6:
                    BrowserActivity.this.a(this.b, null, "attachment", "image/*", -1);
                    return;
                case 7:
                    BrowserActivity browserActivity2 = BrowserActivity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(mark.via.util.a.c() ? "https://pic.sogou.com/ris?flag=1&drag=0&query=" : "https://images.google.com/searchbyimage?image_url=");
                    sb.append(this.b);
                    mark.via.ui.view.a unused3 = browserActivity2.a(true, sb.toString());
                    return;
                case 8:
                    if (BrowserActivity.this.j != null && BrowserActivity.this.j.m() != null) {
                        BrowserActivity.this.j.c("javascript: var pic=function(){var c=document.getElementsByTagName(\"img\"),f=c.length,e=Array(f),d=[];d.push(\"<html><head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=1, minimal-ui'><title>Source</title><style type='text/css'>* {padding: 0; margin: 0} img{display: block; margin: auto; text-align: center; max-width: 100%;}</style><script type=\\\"text/javascript\\\"> function download(obj) {console.log(obj.src); } \\x3c/script></head><body>\");for(var b=0;b<f;b++)e[b]=c[b].src,e[b]&&99<c[b].height&&99<c[b].width&&d.push('<img onclick=\"download(this)\" src=\"'+e[b]+'\"/>');d.push(\"</body></html>\");a=window.open(\"\");a.document.write(d.join(\"\"));a.focus()};pic();");
                        return;
                    }
                    return;
                case 9:
                    mark.via.h.b.a.a(BrowserActivity.this.b, this.f306a, BrowserActivity.this.m, new a());
                    return;
                case 10:
                    BrowserActivity.this.a(this.f306a);
                    return;
                case 11:
                    mark.via.h.b.a.a(BrowserActivity.this.b, this.f306a);
                    BrowserActivity.this.j.x();
                    return;
                case 12:
                case 13:
                    String substring = this.f306a.substring(9);
                    try {
                        substring = URLDecoder.decode(this.f306a.substring(9), "utf-8");
                    } catch (UnsupportedEncodingException unused4) {
                    }
                    b bVar = new b();
                    if (id == 12) {
                        mark.via.h.b.a.b(BrowserActivity.this.b, substring, bVar);
                        return;
                    } else {
                        mark.via.h.b.a.a(BrowserActivity.this.b, substring, bVar);
                        return;
                    }
                case 14:
                    BrowserActivity.this.b(this.f306a);
                    return;
                case 15:
                    BrowserActivity.this.o.e(this.f306a);
                    a.a.b.j.a.b().d(1);
                    BrowserActivity.this.j.x();
                    return;
                case 16:
                    mark.via.h.b.c.a(BrowserActivity.this.b, this.f306a);
                    BrowserActivity.this.j.x();
                    return;
                case 17:
                    mark.via.h.b.c.a(BrowserActivity.this.b, new c());
                    return;
                case 18:
                    String str4 = this.f306a;
                    String decode = Uri.decode(str4.substring(str4.lastIndexOf("/") + 1));
                    if (mark.via.h.c.b.a(mark.via.util.a.a(BrowserActivity.this.b, false) + decode)) {
                        BrowserActivity.this.j.x();
                        return;
                    }
                    Context y2 = BrowserActivity.this.b;
                    a.a.b.p.e.a(y2, BrowserActivity.this.b.getResources().getString(R.string.c_) + mark.via.util.a.a(BrowserActivity.this.b, false));
                    return;
                case 19:
                    BrowserActivity browserActivity3 = BrowserActivity.this;
                    int c2 = browserActivity3.g(browserActivity3.R);
                    if (c2 == -1) {
                        str2 = null;
                    } else {
                        str2 = ((mark.via.ui.view.a) BrowserActivity.this.c.get(c2)).k();
                    }
                    mark.via.util.j.a(BrowserActivity.this.f293a, this.f306a, str2);
                    return;
                case 20:
                    BrowserActivity.this.a(this.f306a, null, "attachment", null, -1);
                    return;
                case 21:
                    a.a.b.p.e.a(BrowserActivity.this.b, (int) R.string.n, (int) R.string.cm, new d());
                    return;
                case 22:
                    a.a.b.p.e.a(BrowserActivity.this.b, (int) R.string.a5, a.a.b.p.a.e(BrowserActivity.this.b, R.string.g1) + "\n" + BrowserActivity.this.j.k() + "\n\n" + a.a.b.p.a.e(BrowserActivity.this.b, R.string.g2) + "\n" + BrowserActivity.this.j.l() + "\n\n" + a.a.b.p.a.e(BrowserActivity.this.b, R.string.g0) + "\n" + this.f306a);
                    return;
                case 23:
                    BrowserActivity.this.j.c(mark.via.b.b.a(BrowserActivity.this.b, this.f306a));
                    return;
                case 24:
                case 25:
                    String a2 = mark.via.util.b.a(this.f306a, false);
                    if (id == 24) {
                        BrowserActivity.this.h0.a(a2);
                        a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.a(BrowserActivity.this.b, (int) R.string.b_, a2));
                        return;
                    }
                    BrowserActivity.this.h0.e(a2);
                    a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.a(BrowserActivity.this.b, (int) R.string.ih, a2));
                    return;
                case 26:
                case 27:
                    String str5 = this.f306a;
                    String substring2 = str5.substring(str5.indexOf("://") + 3);
                    if (id == 26) {
                        BrowserActivity.this.h0.a(substring2);
                        a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.a(BrowserActivity.this.b, (int) R.string.b_, substring2));
                        return;
                    }
                    BrowserActivity.this.h0.e(substring2);
                    a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.a(BrowserActivity.this.b, (int) R.string.ih, substring2));
                    return;
                case 28:
                    BrowserActivity.this.f293a.startActivity(new Intent(BrowserActivity.this.b, BookmarksManager.class));
                    return;
                case 29:
                    a.a.b.p.e.a(BrowserActivity.this.b, this.d, (int) R.string.i5);
                    return;
                case 31:
                    mark.via.util.j.a(BrowserActivity.this.b, this.f306a);
                    return;
            }
        }
    }

    class e0 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        int f311a;
        int b;
        int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;

        e0(boolean z, boolean z2, boolean z3) {
            this.d = z;
            this.e = z2;
            this.f = z3;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f311a = intValue;
            this.b = intValue;
            this.c = intValue;
            BrowserActivity.this.N.setBackgroundColor(this.f311a);
            BrowserActivity.this.L.setBackgroundColor(this.f311a);
            BrowserActivity.this.f293a.getWindow().setBackgroundDrawable(new ColorDrawable(this.f311a));
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.d && !this.e) {
                    this.b = mark.via.util.r.a(-16777216, this.f311a, 0.2f);
                }
                BrowserActivity.this.getWindow().setStatusBarColor(this.b);
                if (Build.VERSION.SDK_INT >= 27) {
                    if (this.d && !this.f) {
                        this.c = mark.via.util.r.a(-16777216, this.f311a, 0.2f);
                    }
                    BrowserActivity.this.getWindow().setNavigationBarColor(this.c);
                }
            }
        }
    }

    class f implements mark.via.h.b.b {
        f() {
        }

        @Override // mark.via.h.b.b
        public void a() {
            if (mark.via.util.b.a(BrowserActivity.this.b, BrowserActivity.this.j.l(), 2)) {
                BrowserActivity.this.j.x();
            }
        }
    }

    class f0 implements a.C0029a {
        f0() {
        }

        @Override // mark.via.g.a.C0029a
        public void a(String str) {
            if (!TextUtils.isEmpty(str) && "android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
                BrowserActivity.this.W();
            }
        }
    }

    class g extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f314a;
        final /* synthetic */ mark.via.a.b b;

        g(String str, mark.via.a.b bVar) {
            this.f314a = str;
            this.b = bVar;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.b(mark.via.a.b, boolean):void
         arg types: [mark.via.a.b, int]
         candidates:
          mark.via.c.b.b(java.lang.String, java.lang.String):void
          mark.via.c.b.b(mark.via.a.b, boolean):void */
        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                BrowserActivity.this.o.e(this.f314a);
                this.b.b(strArr[0]);
                this.b.c(mark.via.util.s.a(strArr[1], BrowserActivity.this.m));
                BrowserActivity.this.o.b(this.b, false);
                a.a.b.j.a.b().d(1);
                if (mark.via.util.b.a(BrowserActivity.this.b, BrowserActivity.this.j.l(), 1)) {
                    BrowserActivity.this.j.x();
                }
            }
        }
    }

    class g0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ mark.via.a.a f315a;

        g0(mark.via.a.a aVar) {
            this.f315a = aVar;
        }

        public void run() {
            BrowserActivity.this.o.a(this.f315a);
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f316a;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f317a;

            a(String str) {
                this.f317a = str;
            }

            public void run() {
                a.a.b.p.d.a(this.f317a);
                BrowserActivity browserActivity = BrowserActivity.this;
                mark.via.ui.view.a unused = browserActivity.a(true, "file://" + this.f317a);
            }
        }

        h(String str) {
            this.f316a = str;
        }

        public void run() {
            String str = this.f316a;
            String replace = str.substring(str.lastIndexOf(47) + 1).replace("%", "");
            if (replace.isEmpty()) {
                replace = UUID.randomUUID() + ".html";
            }
            String a2 = mark.via.util.g.a(BrowserActivity.this.b, Uri.parse(this.f316a), replace);
            if (a2 != null) {
                BrowserActivity.this.runOnUiThread(new a(a2));
            }
        }
    }

    class h0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f318a;
        final /* synthetic */ String b;
        final /* synthetic */ mark.via.ui.view.a c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f319a;

            a(String str) {
                this.f319a = str;
            }

            public void run() {
                boolean z = h0.this.c == null;
                h0 h0Var = h0.this;
                mark.via.ui.view.a h = z ? BrowserActivity.this.j : h0Var.c;
                int a2 = mark.via.util.b.a(BrowserActivity.this.b, h.l());
                if (h0.this.f318a == a2) {
                    h.m().reload();
                } else if (a2 != 0 && a2 != -1) {
                    h.m().loadUrl(this.f319a);
                } else if (z) {
                    mark.via.ui.view.a unused = BrowserActivity.this.a(true, this.f319a);
                } else {
                    h.c(this.f319a);
                }
            }
        }

        h0(int i, String str, mark.via.ui.view.a aVar) {
            this.f318a = i;
            this.b = str;
            this.c = aVar;
        }

        public void run() {
            String str;
            List<mark.via.a.c> list = null;
            switch (this.f318a) {
                case 2:
                    str = mark.via.i.b.a.a(BrowserActivity.this.b, null);
                    break;
                case 3:
                    str = mark.via.i.b.a.d(BrowserActivity.this.b);
                    break;
                case 4:
                    str = mark.via.i.b.a.a(BrowserActivity.this.b);
                    break;
                case 5:
                    str = mark.via.i.b.a.c(BrowserActivity.this.b);
                    break;
                case 6:
                case 10:
                    BrowserActivity browserActivity = BrowserActivity.this;
                    int c2 = browserActivity.g(browserActivity.R);
                    Context y = BrowserActivity.this.b;
                    if (c2 != -1) {
                        list = ((mark.via.ui.view.a) BrowserActivity.this.c.get(c2)).h();
                    }
                    str = mark.via.i.b.a.a(y, list, this.f318a == 10);
                    break;
                case 7:
                    str = mark.via.i.b.a.f(BrowserActivity.this.b);
                    break;
                case 8:
                case 9:
                default:
                    str = mark.via.i.b.a.e(BrowserActivity.this.b);
                    break;
                case 11:
                    str = mark.via.i.b.a.a(BrowserActivity.this.b, this.b);
                    break;
            }
            BrowserActivity.this.f293a.runOnUiThread(new a(str));
        }
    }

    class i implements TextWatcher {
        i() {
        }

        public void afterTextChanged(Editable editable) {
            if (BrowserActivity.this.j != null) {
                BrowserActivity.this.j.a(editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class i0 implements ViewTreeObserver.OnGlobalLayoutListener {
        i0() {
        }

        public void onGlobalLayout() {
            if (BrowserActivity.this.I0 == -1) {
                BrowserActivity browserActivity = BrowserActivity.this;
                int unused = browserActivity.I0 = browserActivity.b0.getRootView().getHeight() - BrowserActivity.this.b0.getHeight();
            }
            if ((BrowserActivity.this.b0.getRootView().getHeight() - BrowserActivity.this.b0.getHeight()) - BrowserActivity.this.I0 >= BrowserActivity.this.b.getResources().getDimensionPixelSize(R.dimen.f500a) * 2) {
                BrowserActivity.this.D();
            } else {
                BrowserActivity.this.y();
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        public void run() {
            BrowserActivity.this.t();
        }
    }

    class j0 implements View.OnClickListener {

        class a extends a.a.b.i.i {

            /* renamed from: mark.via.ui.activity.BrowserActivity$j0$a$a  reason: collision with other inner class name */
            class C0041a extends a.a.b.i.i {
                C0041a() {
                }

                @Override // a.a.b.i.i
                public void a(String[] strArr) {
                    if (!a.a.b.p.a.a(strArr, 1)) {
                        String i = mark.via.util.s.i(strArr[0]);
                        if (i.contains("://")) {
                            BrowserActivity.this.p.v(0);
                            BrowserActivity.this.p.p(i);
                            BrowserActivity browserActivity = BrowserActivity.this;
                            String unused = browserActivity.m = browserActivity.p.a0();
                            if (!BrowserActivity.this.m.startsWith("http://") && !BrowserActivity.this.m.startsWith("https://")) {
                                String unused2 = BrowserActivity.this.m = mark.via.d.b.c().a(BrowserActivity.this.p.k());
                            }
                        }
                    }
                }
            }

            a() {
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                if (i == 0) {
                    a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(BrowserActivity.this.b).b(R.string.c0);
                    dVar.a(0, BrowserActivity.this.p.a0(), R.string.c0);
                    dVar.b(0, 2);
                    ((a.a.b.i.d) dVar.a(17039370, new C0041a())).g();
                    return;
                }
                BrowserActivity.this.p.v(i);
                BrowserActivity browserActivity = BrowserActivity.this;
                String unused = browserActivity.m = mark.via.util.b.h(browserActivity.b)[0];
            }
        }

        j0() {
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.b /*{ENCODED_INT: 2131230721}*/:
                    mark.via.ui.view.a unused = BrowserActivity.this.a(true, null);
                    return;
                case R.id.d /*{ENCODED_INT: 2131230723}*/:
                    BrowserActivity.this.Q();
                    return;
                case R.id.f /*{ENCODED_INT: 2131230725}*/:
                    BrowserActivity.this.F();
                    return;
                case R.id.au /*{ENCODED_INT: 2131230777}*/:
                    if (BrowserActivity.this.h.hasFocus()) {
                        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(BrowserActivity.this.b).b(R.string.gh);
                        hVar.b(R.array.k, BrowserActivity.this.p.Z());
                        hVar.a(new a());
                        hVar.g();
                        return;
                    } else if (BrowserActivity.this.a0 == 6) {
                        BrowserActivity.this.n();
                        return;
                    } else if (!mark.via.util.b.i(BrowserActivity.this.j.l())) {
                        BrowserActivity.this.j(6);
                        return;
                    } else {
                        return;
                    }
                case R.id.av /*{ENCODED_INT: 2131230778}*/:
                    int Z = BrowserActivity.this.B;
                    if (Z == 1) {
                        BrowserActivity.this.j.B();
                        return;
                    } else if (Z == 2) {
                        BrowserActivity browserActivity = BrowserActivity.this;
                        browserActivity.d(browserActivity.h.getText().toString().trim());
                        return;
                    } else if (Z == 3) {
                        mark.via.util.b.a(BrowserActivity.this.f293a);
                        return;
                    } else if (BrowserActivity.this.a0 != 6 || !BrowserActivity.this.l0.f()) {
                        BrowserActivity.this.j.x();
                        return;
                    } else {
                        BrowserActivity.this.n();
                        return;
                    }
                case R.id.ay /*{ENCODED_INT: 2131230781}*/:
                    BrowserActivity.this.l();
                    return;
                case R.id.az /*{ENCODED_INT: 2131230782}*/:
                    if (BrowserActivity.this.a0 != -1) {
                        BrowserActivity.this.n();
                        return;
                    } else {
                        BrowserActivity.this.m();
                        return;
                    }
                case R.id.b0 /*{ENCODED_INT: 2131230783}*/:
                    if (!BrowserActivity.this.p()) {
                        if (BrowserActivity.this.j != null) {
                            BrowserActivity.this.j.p();
                            return;
                        } else {
                            mark.via.ui.view.a unused2 = BrowserActivity.this.a(true, null);
                            return;
                        }
                    } else {
                        return;
                    }
                case R.id.b1 /*{ENCODED_INT: 2131230784}*/:
                    if (BrowserActivity.this.a0 != -1) {
                        BrowserActivity.this.n();
                        return;
                    } else {
                        BrowserActivity.this.j(3);
                        return;
                    }
                case R.id.b3 /*{ENCODED_INT: 2131230786}*/:
                    if (BrowserActivity.this.o0 == 0) {
                        BrowserActivity.this.finish();
                        return;
                    } else if (BrowserActivity.this.a0 == -1) {
                        BrowserActivity.this.j(0);
                        return;
                    } else {
                        BrowserActivity.this.n();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View view) {
            if (BrowserActivity.this.j != null && BrowserActivity.this.j.m() != null) {
                BrowserActivity.this.j.m().findNext(false);
            }
        }
    }

    class k0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f327a;

        k0(boolean z) {
            this.f327a = z;
        }

        public void run() {
            if (this.f327a) {
                mark.via.util.r.d(BrowserActivity.this.J, a.a.b.h.a.a(5));
            } else {
                mark.via.util.r.a(BrowserActivity.this.J, a.a.b.h.a.b(5));
            }
            boolean unused = BrowserActivity.this.N0 = this.f327a;
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View view) {
            if (BrowserActivity.this.j != null && BrowserActivity.this.j.m() != null) {
                BrowserActivity.this.j.m().findNext(true);
            }
        }
    }

    class l0 extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f329a;

        l0(List list) {
            this.f329a = list;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            mark.via.util.j.a(BrowserActivity.this.f293a, (String) this.f329a.get(i), BrowserActivity.this.j.k());
        }
    }

    class m extends a.a.b.l.c {

        class a extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebView f331a;

            a(WebView webView) {
                this.f331a = webView;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: mark.via.util.a.a(android.content.Context, boolean):java.lang.String
             arg types: [android.content.Context, int]
             candidates:
              mark.via.util.a.a(android.app.Activity, java.lang.String):void
              mark.via.util.a.a(android.content.Context, android.view.View):void
              mark.via.util.a.a(android.content.Context, int):boolean
              mark.via.util.a.a(android.content.Context, java.lang.String):boolean
              mark.via.util.a.a(android.content.Context, java.lang.String[]):boolean
              mark.via.util.a.a(android.content.Context, boolean):java.lang.String */
            @Override // a.a.b.i.i
            public void a(String[] strArr) {
                if (!a.a.b.p.a.a(strArr, 1)) {
                    if (mark.via.h.c.d.a(this.f331a, mark.via.h.c.b.a(mark.via.util.a.a(BrowserActivity.this.b, false), strArr[0], ".mht"))) {
                        a.a.b.p.e.a(BrowserActivity.this.b, (int) R.string.ge);
                    }
                }
            }
        }

        class b extends a.a.b.i.i {
            b() {
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                BrowserActivity.this.n();
                mark.via.ui.view.a unused = BrowserActivity.this.a(true, mark.via.util.b.a(i, BrowserActivity.this.j.l()));
            }
        }

        class c extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String[][] f333a;

            c(String[][] strArr) {
                this.f333a = strArr;
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                String str = this.f333a[0][i];
                BrowserActivity.this.p.i(str);
                BrowserActivity.this.f0.c(str);
                a.a.b.p.e.a(BrowserActivity.this.b, this.f333a[1][i]);
                BrowserActivity.this.n();
            }
        }

        m() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.d.a.a(java.lang.String, boolean):void
         arg types: [java.lang.String, int]
         candidates:
          mark.via.d.a.a(java.lang.String, java.lang.String):void
          mark.via.d.a.a(android.app.Application, int):void
          mark.via.d.a.a(java.lang.String, boolean):void */
        @Override // a.a.b.l.c
        public void a(a.a.b.l.b bVar, int i) {
            int b2 = bVar.b();
            switch (b2) {
                case R.string.f505a /*{ENCODED_INT: 2131492864}*/:
                    mark.via.d.a.a().a("add_bookmark", true);
                    BrowserActivity.this.n();
                    BrowserActivity.this.f();
                    return;
                case R.string.g /*{ENCODED_INT: 2131492870}*/:
                    mark.via.d.a.a().a("bookmark", true);
                    BrowserActivity.this.n();
                    BrowserActivity.this.a((mark.via.ui.view.a) null, 2, (String) null);
                    return;
                case R.string.q /*{ENCODED_INT: 2131492880}*/:
                    mark.via.d.a.a().a("download", true);
                    if (!BrowserActivity.this.f0.b(BrowserActivity.this.f293a)) {
                        BrowserActivity.this.j(5);
                        return;
                    }
                    return;
                case R.string.a2 /*{ENCODED_INT: 2131492892}*/:
                    mark.via.d.a.a().a("night", true);
                    BrowserActivity.this.n();
                    BrowserActivity.this.p.a(BrowserActivity.this.b, !BrowserActivity.this.p.a(BrowserActivity.this.b));
                    BrowserActivity.this.T();
                    return;
                case R.string.a6 /*{ENCODED_INT: 2131492896}*/:
                    BrowserActivity.this.n();
                    boolean z = !BrowserActivity.this.p.T();
                    BrowserActivity.this.p.u(z);
                    if (z) {
                        mark.via.d.a.a().a("pc_view", true);
                    }
                    bVar.a(z);
                    BrowserActivity.this.W();
                    if (BrowserActivity.this.j != null && !mark.via.util.b.b(BrowserActivity.this.b, BrowserActivity.this.j.l())) {
                        BrowserActivity.this.j.x();
                        return;
                    }
                    return;
                case R.string.g_ /*{ENCODED_INT: 2131493122}*/:
                    mark.via.d.a.a().a("res", false);
                    BrowserActivity.this.n();
                    BrowserActivity.this.J();
                    return;
                case R.string.gq /*{ENCODED_INT: 2131493139}*/:
                    mark.via.d.a.a().a("settings", true);
                    BrowserActivity.this.n();
                    BrowserActivity.this.startActivity(new Intent(BrowserActivity.this.b, SettingsCatalog.class));
                    return;
                default:
                    switch (b2) {
                        case R.string.s /*{ENCODED_INT: 2131492882}*/:
                            mark.via.d.a.a().a("find_in_page", false);
                            BrowserActivity.this.n();
                            BrowserActivity.this.h(14);
                            return;
                        case R.string.t /*{ENCODED_INT: 2131492883}*/:
                            BrowserActivity.this.n();
                            boolean z2 = !BrowserActivity.this.p.u();
                            BrowserActivity.this.p.k(z2);
                            if (z2) {
                                mark.via.d.a.a().a("full_screen", false);
                            }
                            BrowserActivity.this.U();
                            bVar.a(z2);
                            return;
                        case R.string.u /*{ENCODED_INT: 2131492884}*/:
                            mark.via.d.a.a().a("history", true);
                            BrowserActivity.this.n();
                            BrowserActivity.this.a((mark.via.ui.view.a) null, 3, (String) null);
                            return;
                        case R.string.v /*{ENCODED_INT: 2131492885}*/:
                            if (BrowserActivity.this.p.D()) {
                                BrowserActivity.this.p.m(false);
                                BrowserActivity.this.p.e(false);
                                bVar.a(BrowserActivity.this.getResources().getString(R.string.dz));
                                a.a.b.p.e.a(BrowserActivity.this.b, BrowserActivity.this.getResources().getString(R.string.dz));
                            } else if (BrowserActivity.this.p.f()) {
                                BrowserActivity.this.p.m(true);
                                bVar.a(BrowserActivity.this.getResources().getString(R.string.dy));
                                a.a.b.p.e.a(BrowserActivity.this.b, BrowserActivity.this.getResources().getString(R.string.dy));
                            } else {
                                mark.via.d.a.a().a("pic", false);
                                BrowserActivity.this.p.e(true);
                                bVar.a(BrowserActivity.this.getResources().getString(R.string.e0));
                                a.a.b.p.e.a(BrowserActivity.this.b, BrowserActivity.this.getResources().getString(R.string.e0));
                            }
                            BrowserActivity.this.W();
                            return;
                        case R.string.w /*{ENCODED_INT: 2131492886}*/:
                            BrowserActivity.this.n();
                            boolean z3 = !BrowserActivity.this.p.E();
                            BrowserActivity.this.p.n(z3);
                            a.a.b.j.a.b().d(3);
                            if (z3) {
                                mark.via.d.a.a().a("incognito", true);
                                mark.via.util.r.c(BrowserActivity.this.K.findViewById(R.id.al));
                            }
                            a.a.b.p.e.a(BrowserActivity.this.b, z3 ? R.string.ec : R.string.eb);
                            bVar.a(z3);
                            return;
                        case R.string.x /*{ENCODED_INT: 2131492887}*/:
                            mark.via.d.a.a().a("net_log", false);
                            BrowserActivity.this.n();
                            if (!mark.via.util.b.b(BrowserActivity.this.b, BrowserActivity.this.j.l())) {
                                BrowserActivity browserActivity = BrowserActivity.this;
                                int unused = browserActivity.R = browserActivity.j.g();
                            }
                            BrowserActivity browserActivity2 = BrowserActivity.this;
                            int c2 = browserActivity2.g(browserActivity2.R);
                            if (c2 == -1 || ((mark.via.ui.view.a) BrowserActivity.this.c.get(c2)).h().isEmpty()) {
                                a.a.b.p.e.a(BrowserActivity.this.b, (int) R.string.f9);
                                return;
                            } else {
                                BrowserActivity.this.a((mark.via.ui.view.a) null, 6, (String) null);
                                return;
                            }
                        default:
                            switch (b2) {
                                case R.string.ab /*{ENCODED_INT: 2131492902}*/:
                                    mark.via.d.a.a().a("save_page", false);
                                    BrowserActivity.this.n();
                                    if (BrowserActivity.this.j == null || !mark.via.h.c.d.c(BrowserActivity.this.j.l())) {
                                        a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.e(BrowserActivity.this.b, R.string.bg));
                                        return;
                                    }
                                    FastView m = BrowserActivity.this.j.m();
                                    if (m != null && mark.via.util.a.a(BrowserActivity.this.b, 1)) {
                                        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(BrowserActivity.this.b).b(R.string.ab);
                                        dVar.a(0, mark.via.h.c.d.b(m), R.string.dq);
                                        ((a.a.b.i.d) ((a.a.b.i.d) dVar.a(17039370, new a(m))).a(17039360, (View.OnClickListener) null)).g();
                                        return;
                                    }
                                    return;
                                case R.string.ac /*{ENCODED_INT: 2131492903}*/:
                                    mark.via.d.a.a().a("saved_pages", false);
                                    BrowserActivity.this.n();
                                    BrowserActivity.this.a((mark.via.ui.view.a) null, 7, (String) null);
                                    return;
                                default:
                                    switch (b2) {
                                        case R.string.ae /*{ENCODED_INT: 2131492905}*/:
                                            mark.via.d.a.a().a("share", true);
                                            BrowserActivity.this.n();
                                            if (BrowserActivity.this.j == null || mark.via.util.b.i(BrowserActivity.this.j.l())) {
                                                mark.via.util.j.a(BrowserActivity.this.b, "http://viayoo.com/");
                                                return;
                                            } else {
                                                mark.via.util.j.a(BrowserActivity.this.b, BrowserActivity.this.j.l());
                                                return;
                                            }
                                        case R.string.af /*{ENCODED_INT: 2131492906}*/:
                                            mark.via.d.a.a().a("sources", false);
                                            BrowserActivity.this.n();
                                            if (Build.VERSION.SDK_INT >= 21 && URLUtil.isFileUrl(BrowserActivity.this.j.l())) {
                                                mark.via.ui.view.a unused2 = BrowserActivity.this.a(true, "view-source:" + BrowserActivity.this.j.l());
                                                return;
                                            } else if (!mark.via.h.c.d.c(BrowserActivity.this.j.l())) {
                                                a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.e(BrowserActivity.this.b, R.string.bg));
                                                return;
                                            } else if (Build.VERSION.SDK_INT >= 21) {
                                                mark.via.ui.view.a unused3 = BrowserActivity.this.a(true, "view-source:" + BrowserActivity.this.j.l());
                                                return;
                                            } else {
                                                a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.e(BrowserActivity.this.b, R.string.i_));
                                                BrowserActivity.this.j.c("javascript:s=document.documentElement.outerHTML;a=window.open('');a.document.write(\"<html><head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no, minimal-ui'><title>Source</title><style type='text/css'>* {padding: 0; margin: 0} body{padding: 5px 10px;word-break:break-all;color: #666;line-height: 1.4;}</style></head><body></body></html>\");a.document.body.innerText=s;");
                                                return;
                                            }
                                        case R.string.ag /*{ENCODED_INT: 2131492907}*/:
                                            BrowserActivity.this.S();
                                            return;
                                        case R.string.ah /*{ENCODED_INT: 2131492908}*/:
                                            mark.via.d.a.a().a("translate", false);
                                            if (BrowserActivity.this.j == null || !mark.via.h.c.d.c(BrowserActivity.this.j.l())) {
                                                BrowserActivity.this.n();
                                                a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.e(BrowserActivity.this.b, R.string.bg));
                                                return;
                                            } else if (mark.via.util.a.c()) {
                                                BrowserActivity.this.j.c("javascript:void((function(){if(!document.body){return}var popup=document.querySelectorAll('.cyxy-target-popup');if(popup&&popup.length>0){return}try{var trs=document.createElement('script');trs.type='text/javascript';trs.charset='UTF-8';trs.src=('https:'==document.location.protocol?'https://':'http://')+'caiyunapp.com/dest/trs.js';document.body.appendChild(trs);var css=css=document.createElement('style');css.type='text/css';css.charset='UTF-8';css.appendChild(document.createTextNode('.cyxy-personal,.cyxy-favorite{display: none !important;}'));document.head.appendChild(css)}catch(e){alert(e)}document.addEventListener('securitypolicyviolation',function handler(e){console.error('securitypolicyviolation',e);alert('由于当前网站的内容安全策略(Content Security Policy)，无法启动翻译程序');document.removeEventListener('securitypolicyviolation',handler)})})());");
                                                return;
                                            } else {
                                                String[] strArr = new String[3];
                                                strArr[0] = a.a.b.p.a.e(BrowserActivity.this.b, R.string.by);
                                                strArr[1] = "English";
                                                strArr[2] = mark.via.util.a.c() ? "文言文" : "中文";
                                                a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(BrowserActivity.this.b).b(R.string.ah);
                                                hVar.a(strArr, 0);
                                                hVar.a(new b());
                                                hVar.g();
                                                return;
                                            }
                                        case R.string.ai /*{ENCODED_INT: 2131492909}*/:
                                            BrowserActivity.this.a(bVar, i);
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.d.a.a(java.lang.String, boolean):void
         arg types: [java.lang.String, int]
         candidates:
          mark.via.d.a.a(java.lang.String, java.lang.String):void
          mark.via.d.a.a(android.app.Application, int):void
          mark.via.d.a.a(java.lang.String, boolean):void */
        @Override // a.a.b.l.c
        public void b(a.a.b.l.b bVar, int i) {
            String l;
            switch (bVar.b()) {
                case R.string.g /*{ENCODED_INT: 2131492870}*/:
                    BrowserActivity.this.startActivity(new Intent(BrowserActivity.this.b, BookmarksManager.class));
                    return;
                case R.string.q /*{ENCODED_INT: 2131492880}*/:
                    String[][] a2 = a.a.a.a.c(BrowserActivity.this.b).a(BrowserActivity.this.f293a);
                    a2[1][0] = a.a.b.p.a.e(BrowserActivity.this.b, R.string.hs);
                    String p = BrowserActivity.this.p.p();
                    int length = a2[0].length;
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (p.equals(a2[0][i3])) {
                            i2 = i3;
                        }
                    }
                    a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(BrowserActivity.this.b).b(R.string.ar);
                    hVar.a(a2[1], i2);
                    hVar.a(new c(a2));
                    hVar.a(BrowserActivity.this.v0.a(i));
                    return;
                case R.string.a2 /*{ENCODED_INT: 2131492892}*/:
                    if (Build.VERSION.SDK_INT < 29) {
                        boolean z = !BrowserActivity.this.p.Q();
                        BrowserActivity.this.p.r(z);
                        a.a.b.p.e.a(BrowserActivity.this.b, z ? R.string.f5 : R.string.f4);
                        return;
                    }
                    return;
                case R.string.a6 /*{ENCODED_INT: 2131492896}*/:
                    BrowserActivity.this.a(bVar, i);
                    return;
                case R.string.ae /*{ENCODED_INT: 2131492905}*/:
                    BrowserActivity.this.n();
                    if (BrowserActivity.this.j != null && (l = BrowserActivity.this.j.l()) != null && !mark.via.util.b.a(BrowserActivity.this.b, l, (String) null)) {
                        mark.via.util.j.a(BrowserActivity.this.f293a, l);
                        return;
                    }
                    return;
                case R.string.ag /*{ENCODED_INT: 2131492907}*/:
                    BrowserActivity.this.n();
                    mark.via.d.a.a().a("res", false);
                    BrowserActivity.this.n();
                    BrowserActivity.this.J();
                    return;
                default:
                    return;
            }
        }
    }

    class m0 extends a.a.b.i.i {
        m0() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.d.a.a(java.lang.String, boolean):void
         arg types: [java.lang.String, int]
         candidates:
          mark.via.d.a.a(java.lang.String, java.lang.String):void
          mark.via.d.a.a(android.app.Application, int):void
          mark.via.d.a.a(java.lang.String, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
         arg types: [java.lang.String, int]
         candidates:
          mark.via.util.b.a(android.content.Context, java.lang.String):int
          mark.via.util.b.a(int, java.lang.String):java.lang.String
          mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
          mark.via.util.b.a(android.webkit.WebView, int):void
          mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
        @Override // a.a.b.i.i
        public void a(int i) {
            BrowserActivity.this.p.A(i + 1);
            if (i == 0) {
                mark.via.d.a.a().a("ua", false);
            }
            Iterator it = BrowserActivity.this.x0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.a.b.l.b bVar = (a.a.b.l.b) it.next();
                if (bVar.b() == R.string.ai) {
                    bVar.a(BrowserActivity.this.p.g0() != 1);
                }
            }
            BrowserActivity.this.W();
            if (BrowserActivity.this.j != null && !mark.via.util.b.b(BrowserActivity.this.b, BrowserActivity.this.j.l())) {
                String a2 = mark.via.util.b.a(BrowserActivity.this.j.l(), false);
                if (!TextUtils.isEmpty(a2) && !"pan.baidu.com".equalsIgnoreCase(a2) && !"yun.baidu.com".equalsIgnoreCase(a2) && !"eyun.baidu.com".equalsIgnoreCase(a2)) {
                    BrowserActivity.this.j.x();
                }
            }
            a.a.b.p.e.a(BrowserActivity.this.b, a.a.b.p.a.a(BrowserActivity.this.b, (int) R.string.go, BrowserActivity.this.b.getResources().getStringArray(R.array.o)[i]));
            BrowserActivity.this.n();
        }
    }

    class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f335a;

        n(int i) {
            this.f335a = i;
        }

        public void onClick(View view) {
            BrowserActivity.this.f(this.f335a);
        }
    }

    class n0 implements View.OnLongClickListener {
        n0() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.d.a.a(java.lang.String, boolean):void
         arg types: [java.lang.String, int]
         candidates:
          mark.via.d.a.a(java.lang.String, java.lang.String):void
          mark.via.d.a.a(android.app.Application, int):void
          mark.via.d.a.a(java.lang.String, boolean):void */
        public boolean onLongClick(View view) {
            int id = view.getId();
            if (id == R.id.f) {
                mark.via.d.a.a().a("res", false);
                BrowserActivity.this.n();
                BrowserActivity.this.J();
                return true;
            } else if (id != R.id.b3) {
                switch (id) {
                    case R.id.ay /*{ENCODED_INT: 2131230781}*/:
                        BrowserActivity browserActivity = BrowserActivity.this;
                        browserActivity.h(browserActivity.p.G());
                        return true;
                    case R.id.az /*{ENCODED_INT: 2131230782}*/:
                        BrowserActivity browserActivity2 = BrowserActivity.this;
                        browserActivity2.h(browserActivity2.p.H());
                        return true;
                    case R.id.b0 /*{ENCODED_INT: 2131230783}*/:
                        BrowserActivity browserActivity3 = BrowserActivity.this;
                        browserActivity3.h(browserActivity3.p.I());
                        return true;
                    case R.id.b1 /*{ENCODED_INT: 2131230784}*/:
                        if (BrowserActivity.this.o0 != -1) {
                            return true;
                        }
                        BrowserActivity browserActivity4 = BrowserActivity.this;
                        browserActivity4.h(browserActivity4.p.J());
                        return true;
                    default:
                        return true;
                }
            } else if (BrowserActivity.this.o0 != -1) {
                return true;
            } else {
                BrowserActivity browserActivity5 = BrowserActivity.this;
                browserActivity5.h(browserActivity5.p.K());
                return true;
            }
        }
    }

    class o extends a.a.b.k.a<mark.via.ui.view.a> {
        o(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(a.a.b.k.c cVar, mark.via.ui.view.a aVar, int i) {
            BrowserActivity.this.a(cVar, aVar, i);
        }
    }

    class o0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f337a;

        o0(String str) {
            this.f337a = str;
        }

        public void onClick(View view) {
            a.a.b.p.e.a(BrowserActivity.this.b, this.f337a, BrowserActivity.this.getResources().getString(R.string.i5));
        }
    }

    class p implements AdapterView.OnItemClickListener {
        p() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BrowserActivity.this.n();
            a.a.b.p.d.a("show tab: " + i);
            BrowserActivity.this.k(i);
        }
    }

    class p0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f339a;

        p0(String str) {
            this.f339a = str;
        }

        public void onClick(View view) {
            BrowserActivity.this.d(this.f339a);
        }
    }

    class q implements AdapterView.OnItemLongClickListener {
        q() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            String l = ((mark.via.ui.view.a) BrowserActivity.this.z0.getItem(i)).l();
            if (mark.via.util.b.i(l)) {
                return true;
            }
            mark.via.util.p.a(BrowserActivity.this.b, l, (int) R.string.i6);
            return true;
        }
    }

    class q0 implements a.C0026a {
        q0() {
        }

        @Override // mark.via.c.a.C0026a
        public void a(String str, String str2, String str3) {
            BrowserActivity.this.a(str, str2, str3);
        }
    }

    class r implements a.e {
        r() {
        }

        @Override // a.a.b.k.e.a.e
        public void a(ListView listView, int[] iArr) {
            for (int i : iArr) {
                BrowserActivity.this.f(i);
            }
        }

        @Override // a.a.b.k.e.a.e
        public boolean a(int i) {
            return true;
        }
    }

    class r0 extends a.a.b.o.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Message f343a;

        r0(Message message) {
            this.f343a = message;
        }

        @Override // a.a.b.o.c
        public void a() {
            BrowserActivity.this.a(this.f343a);
        }
    }

    class s0 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f346a;

        s0(String str) {
            this.f346a = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.util.j.a(android.content.Context, java.lang.String):void
         arg types: [android.app.Activity, java.lang.String]
         candidates:
          mark.via.util.j.a(android.app.Activity, java.lang.String):void
          mark.via.util.j.a(android.content.Context, java.lang.String):void */
        public void onClick(View view) {
            mark.via.util.j.a((Context) BrowserActivity.this.f293a, this.f346a);
        }
    }

    class t extends GestureDetector.SimpleOnGestureListener {
        t() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            BrowserActivity.this.C();
        }
    }

    class u implements Runnable {
        u() {
        }

        public void run() {
            BrowserActivity.this.A0.setSelection(BrowserActivity.this.k);
        }
    }

    class w implements View.OnClickListener {
        w() {
        }

        public void onClick(View view) {
            boolean unused = BrowserActivity.this.p();
        }
    }

    class x implements TextWatcher {
        x(BrowserActivity browserActivity) {
        }

        public void afterTextChanged(Editable editable) {
            for (CharacterStyle characterStyle : (CharacterStyle[]) editable.getSpans(0, editable.length(), MetricAffectingSpan.class)) {
                editable.removeSpan(characterStyle);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class y implements View.OnFocusChangeListener {
        y() {
        }

        public void onFocusChange(View view, boolean z) {
            int i = 8;
            if (!z) {
                if (BrowserActivity.this.Z && BrowserActivity.this.j != null && mark.via.util.b.a(BrowserActivity.this.b, BrowserActivity.this.j.l(), 8)) {
                    BrowserActivity.this.i(3);
                } else if (BrowserActivity.this.j == null || BrowserActivity.this.j.j() >= 100) {
                    BrowserActivity.this.i(0);
                } else {
                    BrowserActivity.this.i(1);
                }
                BrowserActivity.this.h.setText("");
                boolean unused = BrowserActivity.this.p();
            } else {
                BrowserActivity.this.i(2);
                if (BrowserActivity.this.a0 != -1) {
                    mark.via.util.r.a(BrowserActivity.this.g, (Animation) null);
                }
                if (BrowserActivity.this.j != null) {
                    BrowserActivity.this.h.setText(BrowserActivity.this.j.b(BrowserActivity.this.m));
                    BrowserActivity.this.h.selectAll();
                }
                mark.via.util.a.e(BrowserActivity.this.b);
                BrowserActivity.this.R();
            }
            if (BrowserActivity.this.V != 1) {
                FrameLayout Q = BrowserActivity.this.E;
                if (!z) {
                    i = 0;
                }
                Q.setVisibility(i);
                BrowserActivity.this.h.setBackgroundResource(z ? 17170445 : R.drawable.c);
                BrowserActivity.this.h.setPadding(mark.via.util.r.a(BrowserActivity.this.b, 42), mark.via.util.r.a(BrowserActivity.this.b, 10), mark.via.util.r.a(BrowserActivity.this.b, 42), mark.via.util.r.a(BrowserActivity.this.b, 10));
            }
        }
    }

    class z implements View.OnKeyListener {
        z() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66) {
                return i == 82;
            }
            mark.via.util.a.a(BrowserActivity.this.b, BrowserActivity.this.f);
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.d(browserActivity.h.getText().toString().trim());
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        if (i2 == 911) {
            if (intent != null && intent.hasExtra("data")) {
                String stringExtra = intent.getStringExtra("data");
                a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(this.b).b(R.string.cl);
                cVar.c(stringExtra);
                cVar.c(false);
                ((a.a.b.i.c) ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(17039370, new p0(stringExtra))).a(17039360, (View.OnClickListener) null)).b(R.string.l, new o0(stringExtra))).g();
            }
        } else if (i2 == 101) {
            if (intent != null && intent.getData() != null) {
                String a2 = mark.via.util.h.a(this.b, intent.getData());
                if (a2 == null) {
                    a.a.b.p.e.a(this.b, (int) R.string.e3);
                    return;
                }
                int a3 = new mark.via.e.a(this.b).a(new File(a2));
                Context context = this.b;
                if (a3 > 0) {
                    str = a3 + " " + this.b.getResources().getString(R.string.eu);
                } else {
                    str = context.getResources().getString(R.string.e3);
                }
                a.a.b.p.e.a(context, str);
                if (a3 > 0) {
                    a.a.b.j.a.b().d(2);
                }
            }
        } else if (i2 != 111) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                ValueCallback<Uri[]> valueCallback = this.z;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i3, intent));
                }
            } else if (this.q != null) {
                this.q.onReceiveValue((intent == null || i3 != -1) ? null : intent.getData());
                this.q = null;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 2 || i2 == 1) {
            mark.via.i.d.b bVar = this.C0;
            if (bVar != null) {
                bVar.a();
            }
            if (this.s == null) {
                a.a.b.p.d.a("on config change and video not playing");
                M();
            }
        }
        T();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f293a = this;
        this.b = this;
        this.p = mark.via.f.a.b(this);
        a.a.b.j.a b2 = a.a.b.j.a.b();
        this.k0 = b2;
        b2.a(this.p.m());
        this.k0.a(1, this.p.i());
        Activity activity = this.f293a;
        boolean a2 = this.p.a(this.b);
        this.n0 = a2;
        mark.via.util.r.a(activity, a2);
        setContentView(R.layout.d);
        r();
        x();
        w();
        s();
        getWindow().getDecorView().post(new j());
        q();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.p.f(a.a.b.j.a.b().b(1));
        this.f.removeAllViews();
        for (mark.via.ui.view.a aVar : this.c) {
            if (aVar != null) {
                aVar.s();
            }
        }
        this.j = null;
        this.c.clear();
        mark.via.util.b.a(this.s0);
        this.o.close();
        unregisterReceiver(this.C);
        this.f0.b(this.b);
        if (this.H0) {
            mark.via.util.r.a(this.b0, this.G0);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            if (this.t == null && this.s == null && B()) {
                return true;
            }
            return false;
        } else if (i2 == 25) {
            if (this.t == null && this.s == null && A()) {
                return true;
            }
            return false;
        } else if (i2 == 4) {
            z();
            return true;
        } else if (i2 == 84) {
            h(4);
            return true;
        } else if (i2 != 62) {
            return false;
        } else {
            mark.via.util.b.a(this.j.m(), 3);
            return true;
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 25) {
            return this.t == null && this.s == null;
        }
        if (i2 != 24) {
            return super.onKeyUp(i2, keyEvent);
        }
        if (this.t == null && this.s == null) {
            return true;
        }
        return false;
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        if (this.W == 1) {
            Q();
        }
        j(3);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            String a2 = mark.via.util.b.a(intent, this.m);
            if (!TextUtils.isEmpty(a2)) {
                c(a2);
                this.S.set(mark.via.util.b.a(intent));
            }
            super.onNewIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.J0) {
            mark.via.util.a.a(this.b, this.f);
        }
        L();
        this.m0.f();
        int i2 = this.i0;
        if (i2 > 0) {
            this.p.B(i2);
            this.p.a(this.j0);
            this.i0 = 0;
            this.j0 = 0;
        }
        this.S.set(false);
        mark.via.ui.view.a aVar = this.j;
        if (aVar != null) {
            aVar.t();
            this.j.w();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        mark.via.util.a.a(this.b, i2, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        mark.via.ui.view.a aVar = this.j;
        if (aVar != null) {
            aVar.z();
            this.j.u();
            if (this.s == null) {
                a.a.b.p.d.a("init prefs");
                s();
                d();
                c(this.j.j());
                E();
                G();
                mark.via.util.i.a(this.b);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.g0 = true;
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.g0 = false;
        this.p.g(a.a.b.j.a.b().a());
        super.onStop();
    }

    private boolean A() {
        if (!this.p.j0()) {
            return false;
        }
        mark.via.util.b.a(this.j.m(), 3);
        return true;
    }

    private boolean B() {
        if (!this.p.j0()) {
            return false;
        }
        mark.via.util.b.a(this.j.m(), 2);
        return true;
    }

    /* access modifiers changed from: private */
    public void C() {
        if (this.r == null) {
            mark.via.c.a aVar = new mark.via.c.a();
            aVar.a(new q0());
            this.r = aVar;
        }
        Message obtainMessage = this.r.obtainMessage();
        if (obtainMessage != null) {
            obtainMessage.setTarget(this.r);
        }
        if (this.j.m() != null) {
            this.j.m().requestFocusNodeHref(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        if (this.J0) {
            return;
        }
        if (this.V != 3 || !this.h.hasFocus()) {
            boolean z2 = false;
            this.K0 = this.L.getVisibility() == 0;
            if (this.I.getVisibility() == 0) {
                z2 = true;
            }
            this.L0 = z2;
            if (this.K0) {
                mark.via.util.r.a(this.L, (Animation) null);
            }
            if (this.L0) {
                mark.via.util.r.a(this.I, (Animation) null);
            }
            this.J0 = true;
            return;
        }
        this.J0 = true;
    }

    private void E() {
        a.a.b.p.d.a("onWebSettingsChanged");
        if (a.a.b.j.a.b().a(158)) {
            a.a.b.p.d.a("update web settings");
            W();
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        mark.via.ui.view.a aVar = this.j;
        if (aVar != null && aVar.A()) {
            List<mark.via.a.c> h2 = this.j.h();
            if (!h2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (mark.via.a.c cVar : h2) {
                    if (cVar != null && cVar.e()) {
                        arrayList.add(cVar.c());
                    }
                }
                if (arrayList.size() == 1) {
                    mark.via.util.j.a(this.f293a, (String) arrayList.get(0), this.j.k());
                    return;
                } else if (arrayList.size() > 1) {
                    a.a.b.i.h hVar = new a.a.b.i.h(this.b);
                    hVar.b(this.j.k());
                    a.a.b.i.h hVar2 = hVar;
                    hVar2.a((String[]) arrayList.toArray(new String[arrayList.size()]), -1);
                    hVar2.a(new l0(arrayList));
                    hVar2.g();
                    return;
                } else {
                    return;
                }
            }
        }
        a(false);
    }

    private void G() {
        char a2 = a.a.b.j.a.b().a(2);
        if (a.a.b.j.a.b().a(1)) {
            a2 = 2;
        }
        if (a2 != 0) {
            Iterator<mark.via.ui.view.a> it = this.c.iterator();
            while (it.hasNext()) {
                mark.via.ui.view.a next = it.next();
                String l2 = next != null ? next.l() : "";
                if (!TextUtils.isEmpty(l2) && next != null) {
                    if ((a2 == 2 && mark.via.util.b.a(this.b, l2, 1)) || (a2 == 1 && mark.via.util.b.a(this.b, l2, 2))) {
                        next.x();
                    }
                }
            }
        }
    }

    private void H() {
        a.a.b.k.a aVar = this.z0;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            V();
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b.getResources().getDimensionPixelSize(R.dimen.c), this.b.getResources().getDimensionPixelSize(R.dimen.c));
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.b);
        int r2 = this.p.r();
        if (r2 == 4 || r2 == 1 || r2 == 6) {
            layoutParams.addRule(10, -1);
        }
        if (r2 == 5 || r2 == 0 || r2 == 7) {
            layoutParams.addRule(12, -1);
        }
        if (r2 == 4 || r2 == 2 || r2 == 5) {
            layoutParams.addRule(9, -1);
        }
        if (r2 == 6 || r2 == 3 || r2 == 7) {
            layoutParams.addRule(11, -1);
        }
        if (r2 == 1 || r2 == 0) {
            layoutParams.addRule(14, -1);
        }
        if (r2 == 2 || r2 == 3) {
            layoutParams.addRule(15, -1);
        }
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        this.I.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void J() {
        if (!mark.via.util.b.b(this.b, this.j.l())) {
            this.R = this.j.g();
        }
        int g2 = g(this.R);
        if (g2 == -1 || !this.c.get(g2).A()) {
            Context context = this.b;
            a.a.b.p.e.a(context, getResources().getString(R.string.f_) + getResources().getString(R.string.ga));
            return;
        }
        a((mark.via.ui.view.a) null, 10, (String) null);
    }

    private void K() {
        int i2 = this.o0;
        if (i2 != -1) {
            if (i2 == 0 || i2 == 1) {
                View[] viewArr = {this.K.findViewById(R.id.ay), this.K.findViewById(R.id.az), this.K.findViewById(R.id.b0), this.K.findViewById(R.id.b2)};
                for (int i3 = 0; i3 < 4; i3++) {
                    mark.via.util.r.e(viewArr[i3], a.a.b.h.a.a(5));
                }
                if (this.V != 1) {
                    View[] viewArr2 = {this.M.findViewById(R.id.r), this.M.findViewById(R.id.au), this.M.findViewById(R.id.av)};
                    for (int i4 = 0; i4 < 3; i4++) {
                        mark.via.util.r.e(viewArr2[i4], a.a.b.h.a.a(5));
                    }
                }
                ImageView imageView = (ImageView) this.K.findViewById(R.id.b1);
                imageView.setImageResource(R.drawable.ai);
                imageView.startAnimation(a.a.b.h.a.a(5));
            }
            ImageView imageView2 = (ImageView) this.K.findViewById(R.id.b3);
            int i5 = this.o0;
            if (i5 == 0 || i5 == 1) {
                imageView2.setImageResource(R.drawable.az);
                imageView2.startAnimation(a.a.b.h.a.a(5));
            }
            if (this.o0 == 1) {
                mark.via.util.r.e(this.K.findViewById(R.id.b3), a.a.b.h.a.a(5));
            }
            this.o0 = -1;
        }
    }

    private void L() {
        if (this.c.size() > 0 && !this.p.E() && this.p.U() != 0) {
            StringBuilder sb = new StringBuilder();
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                mark.via.ui.view.a aVar = this.c.get(i2);
                if (aVar != null && !TextUtils.isEmpty(aVar.l()) && !mark.via.util.b.b(this.b, aVar.l())) {
                    sb.append(aVar.l());
                    sb.append("|$|SEPARATOR|$|");
                }
            }
            this.p.n(sb.toString());
        }
    }

    private void M() {
        int i2;
        int i3;
        int i4;
        int d02 = this.p.d0();
        boolean z2 = false;
        if (d02 == 0) {
            d02 = this.Y || this.f293a.getResources().getConfiguration().orientation == 2 ? 2 : 1;
        }
        a.a.b.p.d.a("set app layout: orientention:" + this.f293a.getResources().getConfiguration().orientation);
        if (this.V != d02) {
            a.a.b.p.d.a("begin setting app layout");
            int i5 = this.V;
            boolean z3 = i5 == -1 || d02 == 1 || i5 == 1;
            this.V = d02;
            this.N.removeAllViews();
            this.L.removeAllViews();
            if (z3) {
                int i6 = mark.via.util.r.c(this.b) >= 5.9d ? 1 : 0;
                boolean z4 = this.Y;
                int i7 = (5 - (i6 ^ 1)) - (z4 ^ true ? 1 : 0);
                if (d02 == 1) {
                    this.E.removeAllViews();
                } else {
                    this.E.addView(this.K);
                }
                int i8 = 8;
                this.K.findViewById(R.id.ay).setVisibility((d02 == 1 || z4) ? 0 : 8);
                View findViewById = this.K.findViewById(R.id.az);
                if (d02 == 1 || i6 != 0) {
                    i8 = 0;
                }
                findViewById.setVisibility(i8);
                ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
                layoutParams.width = mark.via.util.r.a(this.b, d02 == 1 ? 0 : i7 * 42);
                this.E.setLayoutParams(layoutParams);
            }
            if (d02 == 1) {
                this.L.addView(this.K);
                this.N.addView(this.M);
            } else if (d02 == 2) {
                this.N.addView(this.M);
            } else if (d02 == 3) {
                this.L.addView(this.M);
            }
            ViewGroup.LayoutParams layoutParams2 = this.N.getLayoutParams();
            if (d02 == 3) {
                i2 = 0;
            } else {
                i2 = this.F;
            }
            layoutParams2.height = i2;
            this.N.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.L.getLayoutParams();
            if (d02 == 2) {
                i3 = 0;
            } else {
                i3 = this.b.getResources().getDimensionPixelSize(R.dimen.f500a);
            }
            layoutParams3.height = i3;
            this.L.setLayoutParams(layoutParams3);
            this.h.setBackgroundResource(d02 == 1 ? 17170445 : R.drawable.c);
            this.h.setPadding(mark.via.util.r.a(this.b, 42), mark.via.util.r.a(this.b, 10), mark.via.util.r.a(this.b, 42), mark.via.util.r.a(this.b, 10));
            n();
            if (!this.Y || this.V == 1) {
                i4 = mark.via.util.r.b(this.b);
            } else {
                i4 = Math.min(mark.via.util.r.b(this.b) - mark.via.util.r.a(this.b, 100), mark.via.util.r.a(this.b, 400));
            }
            c.a b2 = c.a.b();
            b2.a(i4);
            b2.a();
            ListView listView = this.A0;
            if (listView != null) {
                if (this.V != 2) {
                    z2 = true;
                }
                listView.setStackFromBottom(z2);
            }
        }
    }

    private void N() {
        if (!this.X && this.p.s() == 2) {
            this.X = true;
            I();
            mark.via.i.d.a aVar = new mark.via.i.d.a(this.b);
            aVar.a(this.I);
            aVar.a(mark.via.util.r.a(this.b, 4));
            aVar.a(true);
            aVar.a(new c0());
        }
    }

    private void O() {
        mark.via.ui.view.a aVar;
        if (this.h.hasFocus()) {
            return;
        }
        if (!this.Z || (aVar = this.j) == null || !mark.via.util.b.a(this.b, aVar.l(), 8)) {
            i(0);
        } else {
            i(3);
        }
    }

    private void P() {
        if (!this.h.hasFocus()) {
            i(1);
        }
    }

    /* access modifiers changed from: private */
    public void Q() {
        if (this.N.getVisibility() != 0 && this.W != 0 && !this.J0) {
            mark.via.util.r.a(this.N, a.a.b.h.a.a(3), this.V == 3 ? null : new d());
            mark.via.util.r.d(this.L, a.a.b.h.a.a(5));
            mark.via.util.r.a(this.I, a.a.b.h.a.b(5));
        }
    }

    /* access modifiers changed from: private */
    public void R() {
        if (this.d == null) {
            View view = new View(this.b);
            this.d = view;
            view.setVisibility(8);
            this.d.setBackgroundColor(a.a.b.p.a.a(this.b, (int) R.color.a3));
            this.d.setClickable(true);
            this.d.setFocusable(true);
            this.d.setOnClickListener(new w());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(2, R.id.ax);
            layoutParams.addRule(3, R.id.bo);
            layoutParams.alignWithParent = true;
            this.b0.addView(this.d, 2, layoutParams);
        }
        mark.via.util.r.d(this.d, a.a.b.h.a.a(1));
    }

    /* access modifiers changed from: private */
    public void S() {
        boolean z2 = false;
        if (this.x0.isEmpty()) {
            this.x0.add(a.a.b.l.b.a(this.b, R.string.s, R.drawable.s));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.ab, R.drawable.aq));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.ac, R.drawable.al));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.ah, R.drawable.ax));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.af, R.drawable.a9));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.t, R.drawable.ad, this.p.u()));
            a.a.b.l.b a2 = a.a.b.l.b.a(this.b, R.string.v, R.drawable.an);
            a2.a(a.a.b.p.a.e(this.b, this.p.D() ? R.string.dy : this.p.f() ? R.string.e0 : R.string.dz));
            this.x0.add(a2);
            this.x0.add(a.a.b.l.b.a(this.b, R.string.g_, R.drawable.ap));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.ai, R.drawable.ay, this.p.g0() != 1));
            this.x0.add(a.a.b.l.b.a(this.b, R.string.x, R.drawable.ah));
        }
        Context context = this.b;
        mark.via.ui.view.a aVar = this.j;
        boolean z3 = !mark.via.util.b.b(context, aVar != null ? aVar.l() : null);
        boolean z4 = mark.via.h.c.d.c(this.j.l()) || (Build.VERSION.SDK_INT >= 21 && URLUtil.isFileUrl(this.j.l()));
        for (a.a.b.l.b bVar : this.x0) {
            int b2 = bVar.b();
            if (b2 == R.string.af) {
                bVar.b(z4);
            } else if (b2 == R.string.ah || b2 == R.string.ab) {
                bVar.b(z3);
            }
        }
        this.v0.a(this.x0);
        View view = this.u0;
        if (this.V != 2) {
            z2 = true;
        }
        mark.via.util.r.a(view, z2);
    }

    /* access modifiers changed from: private */
    public void T() {
        boolean a2 = this.p.a(this.b);
        if (a2 != this.n0) {
            if (Build.VERSION.SDK_INT < 11) {
                b(a2);
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            alphaAnimation.setDuration(800);
            b(a2);
            this.b0.startAnimation(alphaAnimation);
        }
    }

    /* access modifiers changed from: private */
    public void U() {
        boolean u2 = this.p.u();
        int i2 = 0;
        int i3 = (u2 || this.p.s() > 0) ? 1 : 0;
        if (u2) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().clearFlags(1024);
        }
        if (this.W != i3) {
            int d2 = mark.via.util.r.d(this.f293a);
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.s);
            int i4 = mark.via.b.a.g;
            this.F = dimensionPixelSize + ((i4 < 19 || i4 >= 21 || u2) ? 0 : d2);
            float f2 = 0.0f;
            if (i3 != 0) {
                boolean z2 = this.p.d0() == 3;
                this.f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                if (this.N.getVisibility() == 0) {
                    if (Build.VERSION.SDK_INT >= 11) {
                        FrameLayout frameLayout = this.f;
                        if (!z2) {
                            f2 = (float) this.F;
                        }
                        frameLayout.setTranslationY(f2);
                    } else {
                        this.f.setPadding(0, z2 ? 0 : this.F, 0, 0);
                    }
                }
            } else {
                mark.via.util.r.d(this.N, (Animation) null);
                mark.via.util.r.d(this.L, (Animation) null);
                if (Build.VERSION.SDK_INT >= 11) {
                    this.f.setTranslationY(0.0f);
                } else {
                    this.f.setPadding(0, 0, 0, 0);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, this.N.getId());
                layoutParams.addRule(2, this.L.getId());
                this.f.setLayoutParams(layoutParams);
            }
            int i5 = mark.via.b.a.g;
            if (i5 >= 19 && i5 < 21) {
                if (!u2) {
                    this.f293a.getWindow().addFlags(67108864);
                }
                ViewGroup.LayoutParams layoutParams2 = this.N.getLayoutParams();
                layoutParams2.height = (!u2 && this.p.d0() == 3) ? d2 : this.F;
                this.N.setLayoutParams(layoutParams2);
                FrameLayout frameLayout2 = this.N;
                if (u2) {
                    d2 = 0;
                }
                frameLayout2.setPadding(0, d2, 0, 0);
                ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.f293a.findViewById(16908290)).getChildAt(0);
                viewGroup.setFitsSystemWindows(u2);
                viewGroup.setClipToPadding(true);
                if (this.G == null) {
                    this.G = new View(this.f293a);
                    this.G.setLayoutParams(new LinearLayout.LayoutParams(-1, mark.via.util.r.d(this.b)));
                    this.G.setBackgroundColor(a.a.b.p.a.a(this.b, (int) R.color.c));
                    viewGroup.addView(this.G);
                }
                View view = this.G;
                if (u2) {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
            this.W = i3;
        }
    }

    private void V() {
        ListView listView = this.A0;
        if (listView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
            int min = Math.min(this.z0.getCount() * a.a.b.p.a.c(this.b, R.dimen.r), ((this.b0.getHeight() - this.N.getHeight()) - this.L.getHeight()) - a.a.b.p.a.c(this.b, R.dimen.f500a));
            if (layoutParams.height != min) {
                layoutParams.height = min;
                this.A0.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void W() {
        FastView m2;
        if (this.j != null) {
            a.a.b.p.d.a("updateWebSettings");
            this.j.a(this.b);
            for (mark.via.ui.view.a aVar : this.c) {
                if (!(aVar == null || (m2 = aVar.m()) == null)) {
                    aVar.b(m2);
                }
            }
            a.a.b.j.a.b().c(158);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    private View k() {
        if (this.y0 == null) {
            Context context = this.b;
            this.B0 = a.a.b.p.a.a(context, (int) R.drawable.ay, a.a.b.p.a.b(context, (int) R.attr.f));
            ListView a2 = a.a.b.p.c.a(this.b);
            this.A0 = a2;
            a2.setStackFromBottom(this.V != 2);
            this.z0 = new o(this.b, R.layout.w, this.c);
            this.A0.setOnItemClickListener(new p());
            this.A0.setOnItemLongClickListener(new q());
            this.A0.setAdapter((ListAdapter) this.z0);
            if (Build.VERSION.SDK_INT >= 11) {
                a.a.b.k.e.a aVar = new a.a.b.k.e.a(this.A0, new r());
                this.A0.setOnTouchListener(aVar);
                this.A0.setOnScrollListener(aVar.a());
            }
            ImageView imageView = new ImageView(this.b);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, a.a.b.p.a.c(this.b, R.dimen.f500a)));
            imageView.setContentDescription(a.a.b.p.a.e(this.b, R.string.a1));
            a.a.b.p.a.b(imageView, a.a.b.p.b.a(this.b, 10.0f));
            imageView.setBackgroundResource(R.drawable.f);
            Context context2 = this.b;
            imageView.setImageDrawable(a.a.b.p.a.a(context2, (int) R.drawable.a5, a.a.b.p.a.b(context2, (int) R.attr.f)));
            imageView.setId(R.id.b);
            imageView.setOnClickListener(this.M0);
            View a3 = a.a.b.p.c.a(this.A0, imageView);
            this.y0 = a3;
            a3.setBackgroundColor(a.a.b.p.a.b(this.b, (int) R.attr.f497a));
            a(this.y0);
        }
        return this.y0;
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!p()) {
            mark.via.ui.view.a aVar = this.j;
            if (aVar == null || !aVar.b()) {
                mark.via.ui.view.a aVar2 = this.j;
                if (aVar2 != null && !mark.via.util.b.a(this.b, aVar2.l(), 1) && !mark.via.util.b.a(this.b, this.j.l(), 8)) {
                    f(this.k);
                    return;
                }
                return;
            }
            if (this.j.j() < 100) {
                this.j.B();
            }
            this.j.n();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        mark.via.ui.view.a aVar = this.j;
        if (aVar != null && aVar.c()) {
            if (this.j.j() < 100) {
                this.j.B();
            }
            this.j.o();
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        mark.via.ui.view.a aVar;
        int i2 = this.a0;
        if (i2 != -1) {
            if (i2 == 6 && (aVar = this.j) != null) {
                this.l0.a(aVar.m());
            }
            this.a0 = -1;
            if (!(this.N.getVisibility() == 0 || this.L.getVisibility() == 0 || this.p.s() != 2)) {
                mark.via.util.r.d(this.I, a.a.b.h.a.a(1));
            }
            mark.via.util.r.a(this.g, a.a.b.h.a.b(((Boolean) this.g.getTag()).booleanValue() ? 3 : 5));
            p();
            mark.via.ui.view.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.a("");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.J.setElevation((float) mark.via.util.r.a(this.b, 12));
            }
            K();
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        if (this.N.getVisibility() != 8 && this.W != 0 && !this.J0) {
            if (this.V != 3) {
                if (Build.VERSION.SDK_INT >= 11) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, "translationY", (float) this.F, 0.0f);
                    ofFloat.setDuration((long) this.b.getResources().getInteger(R.integer.f503a));
                    ofFloat.start();
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.i, "translationY", (float) this.F, 0.0f);
                    ofFloat2.setDuration((long) this.b.getResources().getInteger(R.integer.f503a));
                    ofFloat2.start();
                } else {
                    this.f.setPadding(0, 0, 0, 0);
                }
            }
            mark.via.util.r.a(this.N, a.a.b.h.a.b(3));
            mark.via.util.r.a(this.L, a.a.b.h.a.b(5));
            if (this.p.s() == 2) {
                mark.via.util.r.d(this.I, a.a.b.h.a.a(5));
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean p() {
        View view;
        if (this.a0 == -1 && ((view = this.d) == null || view.getVisibility() == 8)) {
            return false;
        }
        if (this.a0 != -1) {
            n();
            return true;
        }
        if (this.h.hasFocus()) {
            mark.via.ui.view.a aVar = this.j;
            if (aVar != null && mark.via.util.b.b(this.b, aVar.l())) {
                String trim = this.h.getText().toString().trim();
                if (!trim.equals(a.a.b.j.a.b().b(1)) && !trim.equals(this.p.Y())) {
                    this.p.o(trim);
                }
            }
            mark.via.util.a.a(this.b, this.f);
        }
        mark.via.ui.view.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.y();
        }
        mark.via.util.r.a(this.d, a.a.b.h.a.b(1));
        return true;
    }

    private void q() {
        a(0);
        if (this.p.c(0)) {
            mark.via.util.b.c(this.b);
        } else if (System.currentTimeMillis() - this.p.L() >= 432000000) {
            mark.via.util.b.c(this.b);
            this.p.m0();
        }
        if (this.p.c(1)) {
            mark.via.util.b.e(this.b);
        }
        if (this.p.c(2)) {
            mark.via.util.b.f(this.b);
        }
        if (this.p.c(3)) {
            mark.via.util.b.a();
        }
        if (this.p.c(4)) {
            mark.via.util.b.d(this.b);
        }
        int h2 = this.p.h();
        mark.via.d.a.a().a(h2);
        if (20200525 > h2) {
            a.a.b.j.a.b().a(1, 2, 3, 5);
            this.c0 = true;
            if (this.p.h() == 0) {
                mark.via.util.a.d(this.b);
            } else {
                mark.via.util.a.a(this.b, 2);
                if (this.p.d(18) && this.p.P().isEmpty()) {
                    this.p.k(18);
                    new a.a.b.o.a(this.f293a, (int) R.string.gl, 17039370, new d0()).h();
                }
            }
            this.p.e(20200525);
        }
        g();
    }

    private void r() {
        this.C = new mark.via.g.a(new f0());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.C, intentFilter, "mark.via.permission.BROADCAST", null);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void s() {
        mark.via.ui.view.a aVar;
        int i2 = 0;
        a.a.b.p.d.a("initPrefs");
        int X2 = this.p.X();
        if (X2 == 2) {
            setRequestedOrientation(10);
        } else if (X2 == 3) {
            setRequestedOrientation(1);
        } else if (X2 != 4) {
            setRequestedOrientation(2);
        } else {
            setRequestedOrientation(0);
        }
        String[] h2 = mark.via.util.b.h(this.b);
        this.m = h2[0];
        this.n = h2[1];
        this.Z = mark.via.util.a.a(this.b, "mark.qrcode");
        this.f0.b(this.p.o());
        this.f0.c(this.p.p());
        boolean c2 = this.p.c();
        this.d0 = c2;
        ImageView imageView = this.J;
        if (!c2 || (aVar = this.j) == null || !aVar.A()) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.h0.a(this.p.a());
        this.E0 = this.p.d();
        U();
        M();
        N();
    }

    /* access modifiers changed from: private */
    public void t() {
        String a2 = getIntent() != null ? mark.via.util.b.a(getIntent(), this.m) : null;
        boolean z2 = false;
        int U2 = this.p.E() ? 0 : this.p.U();
        String P2 = this.p.P();
        String[] split = P2.split("\\|\\$\\|SEPARATOR\\|\\$\\|");
        boolean z3 = U2 == 0 || U2 == 2 || !a(split);
        if (U2 == 2 && !P2.isEmpty() && !P2.equals("|$|SEPARATOR|$|") && split.length > 0) {
            a.a.b.p.e.a(this.b, (int) R.string.gc, 17039370, new b0(split));
        }
        if ((!mark.via.util.c.a("vmos")) && e()) {
            z2 = true;
        }
        if (a2 != null || (z3 && !z2)) {
            c(a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            this.S.set(mark.via.util.b.a(getIntent()));
        }
    }

    private void u() {
        if (this.K == null) {
            View findViewById = findViewById(R.id.aw);
            this.K = findViewById;
            this.e = (TextView) findViewById.findViewById(R.id.b2);
            mark.via.util.r.a(this.M0, this.K.findViewById(R.id.ay), this.K.findViewById(R.id.az), this.K.findViewById(R.id.b0), this.K.findViewById(R.id.b1), this.K.findViewById(R.id.b3));
            mark.via.util.r.a(this.O0, this.K.findViewById(R.id.ay), this.K.findViewById(R.id.az), this.K.findViewById(R.id.b0), this.K.findViewById(R.id.b1), this.K.findViewById(R.id.b3));
        }
    }

    private void v() {
        if (this.M == null) {
            View findViewById = findViewById(R.id.bn);
            this.M = findViewById;
            this.v = (ImageView) findViewById.findViewById(R.id.au);
            this.D = -1;
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.M.findViewById(R.id.r);
            this.h = autoCompleteTextView;
            autoCompleteTextView.addTextChangedListener(new x(this));
            this.A = (ImageView) this.M.findViewById(R.id.av);
            this.h.setOnFocusChangeListener(new y());
            this.h.setOnKeyListener(new z());
            this.h.setOnItemClickListener(new a0());
            this.h.setAdapter(new mark.via.a.e(this.b));
            this.E = (FrameLayout) this.M.findViewById(R.id.af);
            mark.via.util.r.a(this.M0, this.v, this.A);
        }
    }

    private void w() {
        this.b0 = (ViewGroup) findViewById(R.id.am);
        this.N = (FrameLayout) findViewById(R.id.bo);
        this.L = (FrameLayout) findViewById(R.id.ax);
        this.f = (FrameLayout) findViewById(R.id.z);
        this.i = (ProgressBar) findViewById(R.id.ah);
        this.I = (ImageView) findViewById(R.id.d);
        this.J = (ImageView) findViewById(R.id.f);
        this.O = (ImageView) findViewById(R.id.e);
        this.Q = new mark.via.i.d.c(this.i);
        if (Build.VERSION.SDK_INT >= 11) {
            this.I.setAlpha(0.6f);
            this.J.setAlpha(0.6f);
            if (Build.VERSION.SDK_INT >= 21) {
                this.I.setElevation((float) mark.via.util.r.a(this.b, 12));
                this.O.setElevation((float) mark.via.util.r.a(this.b, 12));
                this.J.setElevation((float) mark.via.util.r.a(this.b, 12));
            }
        }
        this.J.setOnClickListener(this.M0);
        this.J.setOnLongClickListener(this.O0);
        this.O.setVisibility(Build.VERSION.SDK_INT >= 11 ? 4 : 8);
        u();
        v();
    }

    private void x() {
        this.h0 = mark.via.i.a.a.b(this.b);
        a.a.a.a c2 = a.a.a.a.c(this.b);
        c2.a(new s());
        this.f0 = c2;
        c2.a(this.b);
        this.m0 = new mark.via.i.c.a(this.f293a);
        this.l0 = new mark.via.i.c.b(this.f293a);
        this.o = mark.via.c.b.a(this.b);
        this.T = (LayoutInflater) this.b.getSystemService("layout_inflater");
        this.c = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) {
            WebIconDatabase.getInstance().open(getDir("icons", 0).getPath());
        }
        this.Y = mark.via.util.r.g(this.b);
        this.e0 = new GestureDetector(this.f293a, new t());
    }

    /* access modifiers changed from: private */
    public void y() {
        if (this.J0) {
            if (this.K0) {
                mark.via.util.r.d(this.L, (Animation) null);
            }
            if (this.L0) {
                mark.via.util.r.d(this.I, (Animation) null);
            }
            this.J0 = false;
        }
    }

    private void z() {
        if (!p()) {
            mark.via.ui.view.a aVar = this.j;
            if ((aVar == null || aVar.r()) && this.t == null && this.s == null) {
                Context context = this.b;
                mark.via.ui.view.a aVar2 = this.j;
                if (!mark.via.util.b.a(context, aVar2 != null ? aVar2.l() : "", 8)) {
                    l();
                } else if (this.c.size() > 1) {
                    int i2 = this.k;
                    if (i2 >= 0) {
                        f(i2);
                    }
                } else if (System.currentTimeMillis() - this.w > 1500) {
                    a.a.b.p.e.a(this.b, getResources().getString(R.string.eq));
                    this.w = System.currentTimeMillis();
                } else {
                    finish();
                }
            } else {
                a();
            }
        }
    }

    class s implements a.c {

        class a extends a.a.b.o.c {
            a() {
            }

            @Override // a.a.b.o.c
            public void a() {
                BrowserActivity.this.j(5);
            }
        }

        s() {
        }

        @Override // a.a.a.a.c
        public void a(long j) {
            if (BrowserActivity.this.a0 != 5) {
                new a.a.b.o.a(BrowserActivity.this.f293a, (int) R.string.ct, (int) R.string.iv, new a()).h();
            }
        }

        @Override // a.a.a.a.c
        public void b(long j) {
            BrowserActivity.this.m0.b(j);
        }

        @Override // a.a.a.a.c
        public void a(long... jArr) {
            if (!BrowserActivity.this.g0) {
                BrowserActivity.this.startActivity(new Intent(BrowserActivity.this.b, BrowserActivity.class));
            }
            BrowserActivity.this.j(5);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
     arg types: [int, java.lang.String]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a */
    private boolean e() {
        if ((20200525 <= this.p.h() && !this.c0) || !mark.via.util.a.c()) {
            return false;
        }
        a.a.b.j.a.b().d(4);
        a(true, mark.via.i.b.a.a(this.b));
        return true;
    }

    /* access modifiers changed from: private */
    public void f() {
        mark.via.ui.view.a aVar = this.j;
        if (aVar != null) {
            mark.via.h.b.a.a(this.b, aVar.l(), this.j.k(), this.m, new f());
        }
    }

    /* access modifiers changed from: private */
    public int g(int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i2 == this.c.get(i3).g()) {
                return i3;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public boolean h() {
        mark.via.ui.view.a aVar = this.j;
        if (aVar == null) {
            return false;
        }
        if (aVar.b() || (!mark.via.util.b.a(this.b, this.j.l(), 1) && !mark.via.util.b.a(this.b, this.j.l(), 8))) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    private View i() {
        if (this.u0 == null) {
            List<a.a.b.l.b> list = this.w0;
            Context context = this.b;
            list.add(a.a.b.l.b.a(context, R.string.a2, R.drawable.aj, this.p.a(context)));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.g, R.drawable.a8));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.u, R.drawable.ae));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.q, R.drawable.a_));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.w, R.drawable.ak, this.p.E()));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.ae, R.drawable.au));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.f505a, R.drawable.a6));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.a6, R.drawable.am, this.p.T()));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.ag, R.drawable.aw));
            this.w0.add(a.a.b.l.b.a(this.b, R.string.gq, R.drawable.at));
            a.a.b.l.a a2 = a.a.b.l.a.a(this.b);
            a2.a(this.w0);
            a2.a(this.t0);
            this.v0 = a2;
            View a3 = a2.a();
            this.u0 = a3;
            a3.setBackgroundColor(a.a.b.p.a.b(this.b, (int) R.attr.f497a));
            a.a.b.p.a.a(this.u0, 0, a.a.b.p.b.a(this.b, 15.0f));
            a(this.u0);
        } else {
            this.v0.a(this.w0);
        }
        return this.u0;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"RtlHardcoded"})
    public void j(int i2) {
        if (i2 != this.a0) {
            RelativeLayout relativeLayout = this.g;
            int i3 = 3;
            if (relativeLayout == null) {
                RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
                this.g = relativeLayout2;
                relativeLayout2.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(2, R.id.ax);
                layoutParams.addRule(3, R.id.bo);
                layoutParams.alignWithParent = true;
                ViewGroup viewGroup = this.b0;
                viewGroup.addView(this.g, viewGroup.getChildCount() - 3, layoutParams);
            } else {
                relativeLayout.removeAllViews();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.J.setElevation(0.0f);
            }
            boolean z2 = false;
            boolean z3 = this.V == 2;
            this.a0 = i2;
            if (i2 == 0) {
                R();
                this.g.addView(k());
                if (this.j != null) {
                    this.A0.post(new u());
                }
            } else if (i2 == 2) {
                this.g.addView(j());
                if (this.j != null) {
                    this.j.a(((EditText) j().findViewById(R.id.x)).getText().toString());
                }
            } else if (i2 == 3) {
                R();
                this.g.addView(i());
                d(0);
            } else if (i2 == 5) {
                R();
                this.g.addView(this.m0.a());
                d(1);
            } else if (i2 != 6) {
                this.a0 = -1;
                return;
            } else {
                if (this.V != 3) {
                    z2 = true;
                }
                R();
                String l2 = this.j.l();
                RelativeLayout relativeLayout3 = this.g;
                mark.via.i.c.b bVar = this.l0;
                bVar.a(l2);
                relativeLayout3.addView(bVar.a());
                z3 = z2;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                this.g.setGravity(z3 ? 8388661 : 8388693);
            } else {
                this.g.setGravity(z3 ? 53 : 85);
            }
            this.g.setTag(Boolean.valueOf(z3));
            RelativeLayout relativeLayout4 = this.g;
            if (!z3) {
                i3 = 5;
            }
            mark.via.util.r.c(relativeLayout4, a.a.b.h.a.a(i3));
            mark.via.util.r.a(this.I, a.a.b.h.a.b(1));
        }
    }

    private void d(int i2) {
        if (this.o0 != i2 && !this.Y && this.f293a.getResources().getConfiguration().orientation != 2) {
            if (i2 == 0 || (i2 == 1 && this.o0 != 0)) {
                View[] viewArr = {this.K.findViewById(R.id.ay), this.K.findViewById(R.id.az), this.K.findViewById(R.id.b0), this.K.findViewById(R.id.b2)};
                for (int i3 = 0; i3 < 4; i3++) {
                    mark.via.util.r.b(viewArr[i3], a.a.b.h.a.b(5));
                }
                if (this.V != 1) {
                    View[] viewArr2 = {this.M.findViewById(R.id.r), this.M.findViewById(R.id.au), this.M.findViewById(R.id.av)};
                    for (int i4 = 0; i4 < 3; i4++) {
                        mark.via.util.r.b(viewArr2[i4], a.a.b.h.a.b(5));
                    }
                }
                ImageView imageView = (ImageView) this.K.findViewById(R.id.b1);
                imageView.setImageResource(R.drawable.u);
                imageView.startAnimation(a.a.b.h.a.a(5));
            }
            ImageView imageView2 = (ImageView) this.K.findViewById(R.id.b3);
            if (i2 == 0) {
                imageView2.setImageResource(R.drawable.aa);
                imageView2.startAnimation(a.a.b.h.a.a(5));
            } else if (i2 == 1) {
                mark.via.util.r.b(imageView2, a.a.b.h.a.b(5));
            }
            this.o0 = i2;
        }
    }

    @Override // mark.via.ui.view.a.g
    public void c(int i2) {
        int i3 = i2 + 20;
        this.Q.a(i3);
        if (i3 >= 100) {
            O();
        } else {
            P();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
     arg types: [int, ?[OBJECT, ARRAY]]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        return;
     */
    public synchronized void f(int i2) {
        if (i2 < this.c.size()) {
            if (i2 >= 0) {
                a.a.b.p.d.a("delete tab: " + i2);
                boolean z2 = this.S.compareAndSet(true, false) && i2 == this.k && this.j != null && !mark.via.util.b.b(this.b, this.j.l());
                if (i2 == this.k) {
                    if (i2 > 0) {
                        k(i2 - 1);
                    } else if (this.c.size() > 1) {
                        k(1);
                        this.k = 0;
                    } else if (!z2) {
                        a(true, (String) null);
                        this.k = 0;
                    } else {
                        this.k = -1;
                        this.j = null;
                    }
                } else if (i2 < this.k) {
                    this.k--;
                }
                mark.via.ui.view.a aVar = this.c.get(i2);
                this.c.remove(i2);
                if (aVar != null) {
                    aVar.s();
                }
                H();
                this.e.setText(this.c.size() <= 99 ? String.valueOf(this.c.size()) : ":)");
                if (z2) {
                    if (this.c.size() > 0) {
                        moveTaskToBack(true);
                    } else {
                        finish();
                    }
                }
            }
        }
    }

    private void g() {
        if (!this.H0) {
            this.b0.getViewTreeObserver().addOnGlobalLayoutListener(this.G0);
            this.H0 = true;
        }
    }

    @Override // mark.via.ui.view.a.g
    public boolean b(String str, String str2) {
        if (this.h0.d(str2) || URLUtil.isFileUrl(str2) || !this.h0.d(str)) {
            return false;
        }
        this.i0++;
        this.j0 += mark.via.util.b.d(str);
        return true;
    }

    class v implements b.a {
        v() {
        }

        @Override // mark.via.i.d.b.a
        public int a() {
            if (BrowserActivity.this.j == null || BrowserActivity.this.j.m() == null) {
                return 12;
            }
            int i = 0;
            int i2 = 1;
            boolean z = Build.VERSION.SDK_INT < 14 || (!BrowserActivity.this.j.m().canScrollHorizontally(1) && !BrowserActivity.this.j.m().canScrollHorizontally(-1));
            if (!z || !BrowserActivity.this.h()) {
                i2 = 0;
            }
            int i3 = 12 | i2;
            if (z && BrowserActivity.this.j.c()) {
                i = 2;
            }
            return i3 | i;
        }

        @Override // mark.via.i.d.b.a
        public boolean b() {
            return BrowserActivity.this.D0;
        }

        @Override // mark.via.i.d.b.a
        public void a(View view, int i) {
            if (i == 1) {
                ((ImageView) view).setImageDrawable(a.a.b.p.a.d(BrowserActivity.this.b, R.drawable.a7));
            } else if (i == 2) {
                ((ImageView) view).setImageDrawable(a.a.b.p.a.d(BrowserActivity.this.b, R.drawable.t));
            }
        }

        @Override // mark.via.i.d.b.a
        public void a(int i) {
            if (i == 1) {
                BrowserActivity.this.l();
            } else if (i == 2) {
                BrowserActivity.this.m();
            } else if (i == 4) {
                BrowserActivity.this.o();
            } else if (i == 8 && BrowserActivity.this.p.s() != 2) {
                BrowserActivity.this.Q();
            }
        }

        @Override // mark.via.i.d.b.a
        public void a(int i, int i2) {
            int unused = BrowserActivity.this.x = i;
            BrowserActivity browserActivity = BrowserActivity.this;
            int unused2 = browserActivity.y = i2 + browserActivity.N.getHeight();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
     arg types: [int, java.lang.String]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a */
    private void c(String str) {
        if (str == null || !str.startsWith("content://")) {
            a(true, str);
        } else {
            BrowserApp.b().execute(new h(str));
        }
    }

    private void e(int i2) {
        int i3;
        View view;
        boolean a2 = mark.via.util.r.a(i2);
        Context context = this.b;
        int i4 = 17170443;
        if (this.p.a(context)) {
            i3 = R.color.x;
        } else {
            i3 = mark.via.util.r.a(i2) ? R.color.w : 17170443;
        }
        int a3 = a.a.b.p.a.a(context, i3);
        Context context2 = this.b;
        if (this.p.a(context2)) {
            i4 = R.color.r;
        } else if (mark.via.util.r.a(i2)) {
            i4 = R.color.q;
        }
        int a4 = a.a.b.p.a.a(context2, i4);
        mark.via.util.r.a(a4, (ImageView) this.M.findViewById(R.id.au), (ImageView) this.M.findViewById(R.id.av), (ImageView) this.K.findViewById(R.id.ay), (ImageView) this.K.findViewById(R.id.az), (ImageView) this.K.findViewById(R.id.b0), (ImageView) this.K.findViewById(R.id.b3), (ImageView) this.K.findViewById(R.id.b1));
        this.e.setTextColor(a4);
        this.h.setTextColor(a3);
        this.h.setHintTextColor(a3);
        boolean e2 = mark.via.util.r.e(this.f293a, a2);
        boolean d2 = mark.via.util.r.d(this.f293a, a2);
        int i5 = mark.via.b.a.g;
        if (i5 >= 19 && i5 < 21 && !this.p.u() && (view = this.G) != null) {
            view.setVisibility((!a2 || e2) ? 8 : 0);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.D), Integer.valueOf(i2));
            ofObject.addUpdateListener(new e0(a2, e2, d2));
            ofObject.setDuration((long) this.b.getResources().getInteger(R.integer.f503a));
            ofObject.start();
            this.D = i2;
            return;
        }
        this.D = i2;
        this.N.setBackgroundColor(i2);
        this.L.setBackgroundColor(this.D);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
     arg types: [int, ?[OBJECT, ARRAY]]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a */
    /* access modifiers changed from: private */
    public void h(int i2) {
        switch (i2) {
            case 1:
                mark.via.ui.view.a aVar = this.j;
                if (aVar != null) {
                    aVar.x();
                    return;
                }
                return;
            case 2:
                mark.via.util.b.a(this.j.m(), 0);
                return;
            case 3:
                mark.via.util.b.a(this.j.m(), 1);
                return;
            case 4:
                Q();
                this.h.requestFocus();
                return;
            case 5:
                a(true, (String) null);
                return;
            case 6:
                f();
                return;
            case 7:
                a((mark.via.ui.view.a) null, 2, (String) null);
                return;
            case 8:
                a((mark.via.ui.view.a) null, 3, (String) null);
                return;
            case 9:
                f(this.k);
                return;
            case 10:
                int i3 = this.k;
                if (i3 > 1) {
                    k(i3 - 1);
                    return;
                } else if (this.c.size() > 1) {
                    k(this.c.size() - 1);
                    return;
                } else {
                    return;
                }
            case 11:
                if (this.k < this.c.size() - 1) {
                    k(this.k + 1);
                    return;
                } else if (this.c.size() > 1) {
                    k(0);
                    return;
                } else {
                    return;
                }
            case 12:
                l();
                return;
            case 13:
                this.j.o();
                return;
            case 14:
                if (this.a0 != -1) {
                    n();
                    return;
                } else {
                    j(2);
                    return;
                }
            case 15:
                if (this.a0 == -1) {
                    j(0);
                    return;
                } else {
                    n();
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        mark.via.a.b j2 = this.o.j(str);
        String f2 = j2.f();
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(this.b).b(R.string.hx);
        dVar.a(0, j2.e(), R.string.dq);
        dVar.a(1, j2.f(), R.string.dr);
        ((a.a.b.i.d) dVar.a(17039370, new g(f2, j2))).g();
    }

    class c0 implements a.d {

        /* renamed from: a  reason: collision with root package name */
        int f303a;

        c0() {
        }

        @Override // mark.via.i.d.a.d
        public int[] a(View view, int i, int i2) {
            char c;
            int i3;
            int i4 = 2;
            int[] iArr = new int[2];
            int e = mark.via.util.r.e(BrowserActivity.this.b);
            int f = mark.via.util.r.f(BrowserActivity.this.b);
            int dimensionPixelSize = BrowserActivity.this.b.getResources().getDimensionPixelSize(R.dimen.b);
            int width = view.getWidth();
            int height = view.getHeight();
            int i5 = f / 3;
            int i6 = 1;
            int i7 = 0;
            if (i < i5) {
                iArr[0] = dimensionPixelSize;
                c = 0;
            } else if (i > i5 * 2) {
                iArr[0] = (f - width) - dimensionPixelSize;
                c = 2;
            } else {
                iArr[0] = (f - width) / 2;
                c = 1;
            }
            int i8 = e / 3;
            if (i2 < i8) {
                iArr[1] = dimensionPixelSize;
                if (c == 0) {
                    i6 = 4;
                } else if (c == 2) {
                    i6 = 6;
                }
            } else if (i2 > i8 * 2) {
                iArr[1] = (e - height) - dimensionPixelSize;
                if (c == 0) {
                    i7 = 5;
                } else if (c == 2) {
                    i7 = 7;
                }
                i6 = i7;
            } else {
                int i9 = e - height;
                if (c == 1) {
                    i3 = i9 - dimensionPixelSize;
                } else {
                    i3 = i9 / 2;
                }
                iArr[1] = i3;
                if (c != 0) {
                    i4 = c == 2 ? 3 : 0;
                }
                i6 = i4;
            }
            BrowserActivity.this.p.g(i6);
            return iArr;
        }

        @Override // mark.via.i.d.a.d
        public void b(int i) {
            int i2;
            if (i == 0 && this.f303a != 2) {
                i2 = R.drawable.a7;
                this.f303a = 2;
            } else if (i == 1 && this.f303a != 1) {
                i2 = R.drawable.t;
                this.f303a = 1;
            } else if (i == 2 && this.f303a != 3) {
                i2 = R.drawable.az;
                this.f303a = 3;
            } else if (i == 3 && this.f303a != 5) {
                i2 = R.drawable.ao;
                this.f303a = 5;
            } else if (i != -1 || this.f303a == 0) {
                i2 = -1;
            } else {
                i2 = R.drawable.ai;
                this.f303a = 0;
            }
            if (i2 != -1) {
                BrowserActivity.this.I.setImageDrawable(a.a.b.p.a.d(BrowserActivity.this.b, i2));
            }
        }

        @Override // mark.via.i.d.a.d
        public void a() {
            BrowserActivity.this.I();
        }

        @Override // mark.via.i.d.a.d
        public void a(int i) {
            if (i == 0) {
                BrowserActivity.this.h(12);
            } else if (i == 1) {
                BrowserActivity.this.h(13);
            } else if (i == 2) {
                BrowserActivity.this.h(15);
            } else if (i == 3) {
                BrowserActivity.this.h(1);
            }
        }

        @Override // mark.via.i.d.a.d
        public void b() {
            BrowserActivity.this.Q();
        }
    }

    @Override // mark.via.ui.view.a.g
    public boolean c() {
        return this.H;
    }

    @Override // mark.via.ui.view.a.g
    public void a(String str, String str2) {
        if (!this.p.E()) {
            mark.via.h.b.c.a(this.b, str2, str);
        }
    }

    @Override // mark.via.ui.view.a.g
    public void a(ValueCallback<Uri> valueCallback) {
        this.q = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        startActivityForResult(Intent.createChooser(intent, getString(R.string.hz)), 111);
    }

    @Override // mark.via.ui.view.a.g
    public void b(int i2) {
        int g2 = g(i2);
        if (this.A0 != null && g2 >= 0) {
            a.a.b.p.d.a("update tab: " + g2);
            a(a.a.b.k.f.a.a(this.A0, g2), this.c.get(g2), g2);
        }
    }

    @Override // mark.via.ui.view.a.g
    @TargetApi(21)
    public void a(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (mark.via.b.a.g >= 21) {
            this.z = valueCallback;
            try {
                Intent createIntent = fileChooserParams.createIntent();
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                if (acceptTypes != null && acceptTypes.length > 0 && a.a.a.d.a(acceptTypes) > 0) {
                    if (acceptTypes.length > 1) {
                        createIntent.setType("*/*");
                        createIntent.putExtra("android.intent.extra.MIME_TYPES", acceptTypes);
                    } else {
                        createIntent.setType(acceptTypes[0]);
                    }
                }
                String str = (String) fileChooserParams.getTitle();
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.hz);
                }
                startActivityForResult(Intent.createChooser(createIntent, str), 111);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String, boolean):mark.via.ui.view.a
     arg types: [boolean, java.lang.String, int]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean, java.lang.String):mark.via.ui.view.a
      mark.via.ui.activity.BrowserActivity.a(a.a.b.k.c, mark.via.ui.view.a, int):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, int, android.webkit.WebChromeClient$CustomViewCallback):void
      mark.via.ui.activity.BrowserActivity.a(android.webkit.WebView, boolean, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.view.a, int, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, int, android.webkit.WebChromeClient$CustomViewCallback):void
      mark.via.ui.view.a.g.a(android.webkit.WebView, boolean, android.os.Message):void
      mark.via.ui.view.a.g.a(mark.via.ui.view.a, int, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String, boolean):mark.via.ui.view.a */
    /* access modifiers changed from: private */
    public mark.via.ui.view.a b(boolean z2, String str) {
        return a(z2, str, false);
    }

    private void b(boolean z2) {
        Drawable drawable;
        int i2;
        this.n0 = z2;
        a.a.b.j.a.b().a(1, 2, 3, 4, 5);
        boolean Q2 = this.p.Q();
        this.f293a.setTheme(z2 ? R.style.f506a : R.style.b);
        this.y0 = null;
        this.L.setBackgroundResource(z2 ? R.color.i : R.color.h);
        Window window = this.f293a.getWindow();
        if (!z2 || !Q2) {
            drawable = a.a.b.p.a.d(this.b, R.color.h);
        } else {
            drawable = a.a.b.p.a.d(this.b, R.color.i);
        }
        window.setBackgroundDrawable(drawable);
        View view = this.u0;
        int i3 = R.color.f499a;
        if (view != null) {
            view.setBackgroundResource(z2 ? R.color.f499a : R.color.b);
            this.w0.get(0).a(z2);
            this.v0.a(0, this.w0.get(0));
        }
        this.m0.e();
        this.l0.e();
        View view2 = this.P;
        if (view2 != null) {
            View findViewById = view2.findViewById(R.id.u);
            if (!z2 || Q2) {
                i3 = R.color.b;
            }
            findViewById.setBackgroundResource(i3);
        }
        this.f.setForeground(a.a.b.p.a.d(this.b, (!z2 || Q2) ? R.color.a9 : R.color.a_));
        for (mark.via.ui.view.a aVar : this.c) {
            if (aVar != null) {
                String l2 = aVar.l();
                if (!TextUtils.isEmpty(l2)) {
                    if (mark.via.util.b.i(l2)) {
                        aVar.x();
                    } else if (Q2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("javascript:");
                        sb.append(z2 ? "if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);var o=document.getElementsByTagName(\"head\");if(o.length>0&&o[0].appendChild(css)){}};" : "if(document.getElementById(\"via_inject_css_night\")){var night_e=document.getElementById(\"via_inject_css_night\");night_e.parentNode.removeChild(night_e)};");
                        aVar.c(sb.toString());
                    }
                }
            }
        }
        if (z2) {
            i2 = a.a.b.p.a.a(this.b, (int) R.color.i);
        } else {
            i2 = this.p.e0();
        }
        e(i2);
        W();
    }

    /* access modifiers changed from: private */
    public void i(int i2) {
        if (this.B != i2) {
            if (i2 == 1) {
                this.A.setImageResource(R.drawable.r);
            } else if (i2 == 2) {
                this.A.setImageResource(R.drawable.t);
            } else if (i2 != 3) {
                this.A.setImageResource(R.drawable.ao);
            } else {
                this.A.setImageResource(R.drawable.ar);
            }
            this.B = i2;
        }
    }

    /* access modifiers changed from: private */
    public void k(int i2) {
        if (i2 >= 0 && i2 < this.c.size() && i2 != this.k) {
            a.a.b.p.d.a("show tab: " + i2);
            this.S.set(false);
            mark.via.ui.view.a aVar = this.c.get(i2);
            mark.via.ui.view.a aVar2 = this.j;
            if (aVar2 != null) {
                this.f.removeView(aVar2.i());
                this.j.e();
            }
            this.f.addView(aVar.i());
            this.j = aVar;
            aVar.a();
            this.j.y();
            this.j.v();
            this.k = i2;
            c(aVar.j());
            d();
            a(aVar.A());
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
    @Override // mark.via.ui.view.a.g
    public void d() {
        mark.via.ui.view.a aVar = this.j;
        if (aVar != null) {
            String l2 = aVar.l();
            String k2 = this.j.k();
            if (TextUtils.isEmpty(l2)) {
                l2 = k2;
            }
            int f02 = this.p.f0();
            if (f02 == 0 || mark.via.util.b.b(this.b, l2) || (mark.via.util.b.i(l2) && f02 == 2)) {
                if (!TextUtils.isEmpty(k2)) {
                    this.h.setHint(k2);
                }
            } else if (f02 == 1 || f02 == 2) {
                this.h.setHint(f02 == 1 ? l2 : mark.via.util.b.a(l2, true));
            }
            boolean startsWith = l2.startsWith("https://");
            if (this.p0.compareAndSet(!startsWith, startsWith)) {
                this.v.setImageResource(startsWith ? R.drawable.ag : R.drawable.as);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
     arg types: [int, int]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void */
    @Override // mark.via.ui.view.a.g
    public void a(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view != null) {
            if (this.s == null || customViewCallback == null) {
                view.setKeepScreenOn(true);
                this.s = view;
                this.u = customViewCallback;
                FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
                if (Build.VERSION.SDK_INT >= 11) {
                    this.q0 = frameLayout.getSystemUiVisibility();
                }
                this.r0 = getRequestedOrientation();
                setRequestedOrientation(i2);
                a.a.b.p.d.a("set orientation: l");
                FrameLayout frameLayout2 = new FrameLayout(this);
                this.t = frameLayout2;
                frameLayout2.setBackgroundColor(a.a.b.p.a.a(this.b, 17170444));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.t.addView(this.s, layoutParams);
                frameLayout.addView(this.t, layoutParams);
                frameLayout.requestLayout();
                this.j.b(8);
                a(true, true);
                mark.via.util.r.a(this.I, (Animation) null);
                return;
            }
            try {
                customViewCallback.onCustomViewHidden();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (str == null || str.isEmpty() || this.j == null) {
            p();
            return;
        }
        String trim = str.trim();
        this.j.B();
        if (mark.via.util.s.h(trim)) {
            this.j.c(mark.via.util.s.a(trim, this.m));
        } else {
            try {
                trim = URLEncoder.encode(trim, "utf-8");
            } catch (Exception unused) {
            }
            mark.via.ui.view.a aVar = this.j;
            aVar.c(this.m + trim);
            mark.via.d.a.a().b(this.n);
        }
        this.p.o("");
        mark.via.util.a.a(this.b, this.f);
        mark.via.ui.view.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.y();
        }
        n();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private View j() {
        if (this.P == null) {
            View inflate = this.T.inflate(R.layout.c, (ViewGroup) this.f293a.findViewById(16908290), false);
            this.P = inflate;
            a(inflate);
            ((EditText) this.P.findViewById(R.id.x)).addTextChangedListener(new i());
            this.P.findViewById(R.id.w).setOnClickListener(new k());
            this.P.findViewById(R.id.v).setOnClickListener(new l());
        }
        return this.P;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
     arg types: [boolean, int]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void */
    @Override // mark.via.ui.view.a.g
    public void a() {
        if (this.s == null || this.u == null || this.j == null) {
            WebChromeClient.CustomViewCallback customViewCallback = this.u;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                } catch (Exception unused) {
                }
                this.u = null;
                return;
            }
            return;
        }
        setRequestedOrientation(this.r0);
        a.a.b.p.d.a("set orientation: p");
        this.j.b(0);
        this.s.setKeepScreenOn(false);
        FrameLayout frameLayout = this.t;
        if (frameLayout != null) {
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.t);
            }
            this.t.removeAllViews();
        }
        a(this.p.u(), false);
        this.t = null;
        this.s = null;
        try {
            this.u.onCustomViewHidden();
        } catch (Exception unused2) {
        }
        this.u = null;
        if (Build.VERSION.SDK_INT >= 11) {
            getWindow().getDecorView().setSystemUiVisibility(this.q0);
        }
        if (this.L.getVisibility() == 8 && this.N.getVisibility() == 8 && this.p.s() == 2) {
            mark.via.util.r.d(this.I, (Animation) null);
        }
    }

    @Override // mark.via.ui.view.a.g
    public Object b() {
        if (this.U == null) {
            this.U = new BrowserJsCallback(this, null);
        }
        return this.U;
    }

    @Override // mark.via.ui.view.a.g
    public void a(WebView webView, boolean z2, Message message) {
        a.a.b.p.d.a("on create window");
        if (message != null) {
            if (!this.p.g() || z2) {
                a(message);
            } else if (webView != null && webView.isShown()) {
                new a.a.b.o.a(this.f293a, (int) R.string.bb, (int) R.string.az, new r0(message)).h();
            }
        }
    }

    @Override // mark.via.ui.view.a.g
    public void a(String str, String str2, String str3, String str4, long j2) {
        String str5;
        String str6;
        boolean z2 = str != null && str.startsWith("data:image/");
        if ((z2 || !this.f0.a(this.f293a, str)) && mark.via.util.a.a(this.f293a, 1)) {
            if (z2) {
                str5 = UUID.randomUUID() + "." + (str.indexOf(";") > 0 ? str.substring(11, str.indexOf(";")) : "png");
                str6 = str4;
            } else {
                str6 = str4;
                str5 = a.a.a.b.a(str, str3, str6);
            }
            if (mark.via.util.c.a("vmos") && str5.endsWith(".apk")) {
                str6 = "application/vnd.android.package-archive";
            }
            String[] strArr = {str3, str6};
            a.a.b.i.d dVar = new a.a.b.i.d(this.f293a);
            a.a.b.i.d dVar2 = (a.a.b.i.d) dVar.b(R.string.ck);
            dVar2.c(false);
            a.a.b.i.d dVar3 = dVar2;
            dVar3.a(0, str5, "");
            dVar3.a(1, str, "");
            ((a.a.b.i.d) ((a.a.b.i.d) dVar3.a(17039370, new a(z2, str, str2, strArr))).a(17039360, (View.OnClickListener) null)).b(R.string.ae, new s0(str));
            EditText c2 = dVar.c(0);
            c2.setOnFocusChangeListener(new b(this, c2));
            if (j2 >= 0 || z2) {
                dVar.a(a.a.b.p.a.e(this.f293a, R.string.d9) + ": " + mark.via.util.b.a(j2));
            } else {
                BrowserApp.b().execute(new c(str, strArr, dVar));
            }
            dVar.g();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.b(boolean, java.lang.String):mark.via.ui.view.a
     arg types: [int, java.lang.String]
     candidates:
      mark.via.ui.activity.BrowserActivity.b(mark.via.ui.activity.BrowserActivity, int):int
      mark.via.ui.activity.BrowserActivity.b(mark.via.ui.activity.BrowserActivity, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.b(java.lang.String, java.lang.String):boolean
      mark.via.ui.view.a.g.b(java.lang.String, java.lang.String):boolean
      mark.via.ui.activity.BrowserActivity.b(boolean, java.lang.String):mark.via.ui.view.a */
    /* access modifiers changed from: private */
    public void a(Message message) {
        mark.via.ui.view.a b2 = b(true, "");
        b2.m().setTag("NewWindow");
        a.a.b.p.d.a("new window");
        ((WebView.WebViewTransport) message.obj).setWebView(b2.m());
        message.sendToTarget();
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
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        if (r0 != 11) goto L_0x019e;
     */
    public void a(String str, String str2, String str3) {
        boolean z2 = true;
        this.H = !TextUtils.isEmpty(str);
        int a2 = mark.via.util.b.a(this.b, this.j.l());
        if (a2 != 0 || str2 == null) {
            mark.via.ui.view.a aVar = this.j;
            if (aVar != null && aVar.m() != null) {
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    a.a.b.i.e eVar = new a.a.b.i.e(this.b);
                    eVar.a(new e(str, str2, a2, str3));
                    if (mark.via.h.c.d.c(str)) {
                        eVar.b(0, R.string.a3);
                        eVar.b(1, R.string.a4);
                    }
                    if (a2 == -1) {
                        if (!TextUtils.isEmpty(str2)) {
                            eVar.b(2, R.string.al);
                            eVar.b(6, R.string.aa);
                            eVar.b(7, R.string.gi);
                            if (this.p.F()) {
                                eVar.b(8, R.string.a7);
                            }
                        }
                        eVar.b(22, R.string.a5);
                        if (this.p.F()) {
                            eVar.b(23, R.string.y);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            eVar.b(29, R.string.k);
                        }
                    } else if (a2 != 1) {
                        int i2 = 11;
                        if (a2 != 2) {
                            if (a2 != 3) {
                                if (a2 != 6) {
                                    if (a2 == 7) {
                                        eVar.b(18, R.string.m);
                                    } else if (a2 != 10) {
                                    }
                                }
                                if (a2 == 6) {
                                    String a3 = mark.via.util.b.a(str, false);
                                    String substring = str.substring(str.indexOf("://") + 3);
                                    mark.via.i.a.a aVar2 = this.h0;
                                    if (aVar2 != null && aVar2.a() && !this.h0.c(a3) && !this.h0.c(substring)) {
                                        boolean b2 = this.h0.b(a3);
                                        eVar.b(b2 ? 25 : 24, b2 ? R.string.aj : R.string.e);
                                        boolean b3 = this.h0.b(substring);
                                        eVar.b(b3 ? 27 : 26, b3 ? R.string.ak : R.string.f);
                                    }
                                }
                                if (a2 == 10) {
                                    eVar.b(19, R.string.a8);
                                }
                                eVar.b(20, R.string.q);
                                eVar.b(21, R.string.n);
                            } else {
                                eVar.b(16, R.string.m);
                                eVar.b(17, R.string.n);
                            }
                        }
                        boolean z3 = str != null && str.startsWith("folder://");
                        if (!z3 || !str.equals("folder://")) {
                            z2 = false;
                        }
                        if (!z2) {
                            eVar.b(z3 ? 12 : 9, R.string.r);
                            if (!z3) {
                                eVar.b(10, R.string.b);
                            }
                            if (z3) {
                                i2 = 13;
                            }
                            eVar.b(i2, R.string.m);
                        }
                    } else {
                        eVar.b(14, R.string.r);
                        eVar.b(15, R.string.m);
                    }
                    if (!TextUtils.isEmpty(str) && !str.startsWith("folder://") && !str.startsWith("javascript:")) {
                        eVar.b(3, R.string.i);
                        eVar.b(31, R.string.ae);
                    }
                    eVar.a(this.x, this.y);
                    return;
                }
                return;
            }
            return;
        }
        a(str2, null, "attachment", "image/*", -1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.c.b.b(mark.via.a.b, boolean):void
     arg types: [mark.via.a.b, int]
     candidates:
      mark.via.c.b.b(java.lang.String, java.lang.String):void
      mark.via.c.b.b(mark.via.a.b, boolean):void */
    /* access modifiers changed from: private */
    public void a(String str) {
        mark.via.c.b bVar = this.o;
        bVar.b(bVar.i(str), true);
        a.a.b.j.a.b().d(1);
        Context context = this.b;
        a.a.b.p.e.a(context, a.a.b.p.a.e(context, R.string.aq));
    }

    /* access modifiers changed from: private */
    public void a(a.a.b.k.c cVar, mark.via.ui.view.a aVar, int i2) {
        if (cVar != null && aVar != null) {
            TextView textView = (TextView) cVar.a(R.id.bd);
            textView.setText(aVar.k());
            if (aVar.q()) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextColor(a.a.b.p.a.a(this.b, (int) R.color.p));
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
                textView.setTextColor(a.a.b.p.a.b(this.b, (int) R.attr.h));
            }
            Bitmap f2 = aVar.f();
            if (f2 != null) {
                cVar.a(R.id.a7, f2);
            } else {
                cVar.a(R.id.a7, this.B0);
            }
            cVar.a(R.id.a5, new n(i2));
        }
    }

    private void a(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (!this.Y || this.V == 1) {
                layoutParams.width = mark.via.util.r.b(this.b);
            } else {
                layoutParams.width = Math.min(mark.via.util.r.b(this.b) - mark.via.util.r.a(this.b, 100), mark.via.util.r.a(this.b, 400));
            }
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // mark.via.ui.view.a.g
    public boolean a(View view, MotionEvent motionEvent) {
        this.e0.onTouchEvent(motionEvent);
        boolean z2 = false;
        if (view == null) {
            return false;
        }
        if (this.E0 && ((FastView) view).a()) {
            z2 = true;
        }
        this.D0 = z2;
        if (this.C0 == null) {
            mark.via.i.d.b bVar = new mark.via.i.d.b();
            bVar.a(this.O);
            bVar.a(new v());
            this.C0 = bVar;
        }
        return this.C0.a(view, motionEvent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a
     arg types: [int, java.lang.String]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String):java.lang.String
      mark.via.ui.activity.BrowserActivity.a(a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, int):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(boolean, boolean):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean):boolean
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, java.lang.String[]):boolean
      mark.via.ui.activity.BrowserActivity.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.view.a.g.a(android.webkit.ValueCallback<android.net.Uri[]>, android.webkit.WebChromeClient$FileChooserParams):void
      mark.via.ui.view.a.g.a(java.lang.String, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, android.view.MotionEvent):boolean
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String):mark.via.ui.view.a */
    /* access modifiers changed from: private */
    public boolean a(String[] strArr) {
        int i2;
        if (strArr == null || strArr.length <= 0) {
            i2 = 0;
        } else {
            i2 = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    a(true, str);
                    i2++;
                }
            }
        }
        if (i2 != 0) {
            return true;
        }
        return false;
    }

    private mark.via.ui.view.a a(boolean z2, String str, boolean z3) {
        a.a.b.p.d.a("new tab(" + z2 + "," + z3 + ")");
        this.S.set(false);
        mark.via.ui.view.a aVar = new mark.via.ui.view.a(this.f293a, str, this);
        aVar.a(this.l);
        int size = z3 ? this.c.size() : this.k + 1;
        this.c.add(size, aVar);
        this.l++;
        if (z2) {
            mark.via.ui.view.a aVar2 = this.j;
            if (aVar2 != null) {
                this.f.removeView(aVar2.i());
                this.j.e();
            }
            this.j = aVar;
            aVar.a();
            this.k = size;
            c(aVar.j());
            this.f.addView(aVar.i());
        } else {
            aVar.e();
        }
        p();
        H();
        int size2 = this.c.size();
        this.e.setText(size2 <= 99 ? String.valueOf(size2) : ":)");
        if (size2 > 1) {
            mark.via.util.r.c(this.K.findViewById(R.id.al));
        }
        return aVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String, boolean):mark.via.ui.view.a
     arg types: [boolean, java.lang.String, int]
     candidates:
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, boolean, java.lang.String):mark.via.ui.view.a
      mark.via.ui.activity.BrowserActivity.a(a.a.b.k.c, mark.via.ui.view.a, int):void
      mark.via.ui.activity.BrowserActivity.a(java.lang.String, java.lang.String, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.activity.BrowserActivity, a.a.b.l.b, int):void
      mark.via.ui.activity.BrowserActivity.a(android.view.View, int, android.webkit.WebChromeClient$CustomViewCallback):void
      mark.via.ui.activity.BrowserActivity.a(android.webkit.WebView, boolean, android.os.Message):void
      mark.via.ui.activity.BrowserActivity.a(mark.via.ui.view.a, int, java.lang.String):void
      mark.via.ui.view.a.g.a(android.view.View, int, android.webkit.WebChromeClient$CustomViewCallback):void
      mark.via.ui.view.a.g.a(android.webkit.WebView, boolean, android.os.Message):void
      mark.via.ui.view.a.g.a(mark.via.ui.view.a, int, java.lang.String):void
      mark.via.ui.activity.BrowserActivity.a(boolean, java.lang.String, boolean):mark.via.ui.view.a */
    /* access modifiers changed from: private */
    public mark.via.ui.view.a a(boolean z2, String str) {
        return a(z2, str, true);
    }

    @Override // mark.via.ui.view.a.g
    public void a(int i2) {
        if (i2 == 0) {
            i2 = this.p.e0();
        }
        if (this.D != i2 && !this.p.a(this.b) && this.p.l()) {
            e(i2);
        }
    }

    private void a(boolean z2, boolean z3) {
        Window window = getWindow();
        View decorView = window.getDecorView();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z2) {
            attributes.flags |= 1024;
            if (Build.VERSION.SDK_INT >= 19 && z3) {
                decorView.setSystemUiVisibility(5638);
            } else if (Build.VERSION.SDK_INT >= 14) {
                decorView.setSystemUiVisibility(0);
            }
        } else {
            attributes.flags &= -1025;
            if (Build.VERSION.SDK_INT >= 14) {
                decorView.setSystemUiVisibility(0);
            }
        }
        window.setAttributes(attributes);
    }

    @Override // mark.via.ui.view.a.g
    public void a(mark.via.a.a aVar) {
        if (aVar != null) {
            BrowserApp.a().execute(new g0(aVar));
            Context context = this.b;
            a.a.b.p.e.a(context, context.getResources().getString(R.string.ee));
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.k.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.k.a(java.util.HashMap<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      mark.via.util.k.a(java.lang.String, boolean):java.lang.String */
    @Override // mark.via.ui.view.a.g
    public boolean a(WebView webView) {
        int i2;
        if (webView == null || !webView.getSettings().getJavaScriptEnabled() || mark.via.util.b.i(webView.getUrl())) {
            return false;
        }
        String a2 = mark.via.util.b.a(webView.getUrl(), false);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (this.F0 == null) {
            this.F0 = mark.via.util.k.a();
        }
        StringBuilder sb = new StringBuilder();
        String a3 = mark.via.util.k.a(this.F0, a2);
        if (!TextUtils.isEmpty(a3)) {
            sb.append(a3);
        }
        String a4 = mark.via.util.k.a(this.o.l(a2), false);
        if (!TextUtils.isEmpty(a4)) {
            sb.append(a4);
        }
        if (mark.via.refactor.config.c.a(this.b).a(a2)) {
            sb.append("if(document&&!document.getElementById('via_inject_custom_meta')){var meta=document.createElement('meta');meta.id='via_inject_custom_meta';meta.setAttribute('name','viewport');meta.setAttribute('content','minimum-scale=0.1, initial-scale=0.1, maximum-scale=10, user-scalable=yes');var o=document.getElementsByTagName('head');if(o.length>0&&o[0].appendChild(meta)){document.body.style.zoom=1}}");
        }
        if (this.p.Q() && this.p.a(this.b)) {
            sb.append("if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);var o=document.getElementsByTagName(\"head\");if(o.length>0&&o[0].appendChild(css)){}};");
        }
        if (sb.length() > 0) {
            webView.loadUrl("javascript:" + sb.toString().trim());
            i2 = 0;
        } else {
            i2 = -1;
        }
        String k2 = this.o.k(a2);
        if (!TextUtils.isEmpty(k2)) {
            webView.loadUrl("javascript:" + k2);
            i2++;
        }
        if (i2 > -1) {
            return true;
        }
        return false;
    }

    @Override // mark.via.ui.view.a.g
    public void a(mark.via.ui.view.a aVar, int i2, String str) {
        if (i2 != -1 && i2 != 0) {
            if (aVar != null || this.j != null) {
                BrowserApp.b().execute(new h0(i2, str, aVar));
            }
        }
    }

    @Override // mark.via.ui.view.a.g
    public void a(boolean z2) {
        if (this.d0 && z2 != this.N0) {
            this.J.post(new k0(z2));
        }
    }

    /* access modifiers changed from: private */
    public void a(a.a.b.l.b bVar, int i2) {
        a.a.b.i.h hVar = new a.a.b.i.h(this.b);
        hVar.b(R.array.o, this.p.g0() - 1);
        hVar.a(new m0());
        hVar.a(this.v0.a(i2));
    }
}
