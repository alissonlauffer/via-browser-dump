package mark.via.ui.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.MailTo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import mark.via.gp.R;
import mark.via.h.a;
import mark.via.ui.view.b;
import mark.via.util.n;
import mark.via.util.r;

/* compiled from: BrowserView */
public class a implements b.C0051b {
    private static final String[] v = {"https://developer.apple.com/library/"};

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f440a;
    /* access modifiers changed from: private */
    public final Activity b;
    /* access modifiers changed from: private */
    public final Context c;
    /* access modifiers changed from: private */
    public final mark.via.f.a d;
    /* access modifiers changed from: private */
    public boolean e = false;
    /* access modifiers changed from: private */
    public boolean f = false;
    private final List<b> g = new ArrayList();
    private int h;
    private final FrameLayout.LayoutParams i;
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public int k = -1;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public boolean m = true;
    /* access modifiers changed from: private */
    public g n;
    /* access modifiers changed from: private */
    public mark.via.refactor.config.c o;
    private String p;
    /* access modifiers changed from: private */
    public mark.via.h.a q;
    private int r;
    private String s = "";
    private boolean t = false;
    private Bitmap u;

    /* renamed from: mark.via.ui.view.a$a  reason: collision with other inner class name */
    /* compiled from: BrowserView */
    class C0047a implements a.C0030a {
        C0047a() {
        }

        @Override // mark.via.h.a.C0030a
        public void a() {
            a.this.n.a(true);
        }
    }

    /* compiled from: BrowserView */
    class b implements View.OnLongClickListener {
        b() {
        }

        public boolean onLongClick(View view) {
            return a.this.n.c();
        }
    }

    /* compiled from: BrowserView */
    class c implements View.OnTouchListener {
        c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return a.this.n.a(view, motionEvent);
        }
    }

    /* compiled from: BrowserView */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f444a;

        d(WebView webView) {
            this.f444a = webView;
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
         method: mark.via.ui.view.a.d(mark.via.ui.view.a, boolean):boolean
         arg types: [mark.via.ui.view.a, int]
         candidates:
          mark.via.ui.view.a.d(mark.via.ui.view.a, java.lang.String):void
          mark.via.ui.view.a.d(mark.via.ui.view.a, boolean):boolean */
        public void run() {
            int unused = a.this.k = r.a(this.f444a);
            ((FastView) this.f444a).setWebColor(a.this.k);
            String unused2 = a.this.l = mark.via.util.b.a(this.f444a.getUrl(), false);
            if (this.f444a.isShown()) {
                a.this.n.a(a.this.k);
            }
            boolean unused3 = a.this.j = false;
        }
    }

    /* compiled from: BrowserView */
    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f445a;
        final /* synthetic */ WebView b;

        e(Runnable runnable, WebView webView) {
            this.f445a = runnable;
            this.b = webView;
        }

        public void run() {
            this.f445a.run();
            if (a.this.k == -1) {
                this.b.postDelayed(this.f445a, 200);
            }
        }
    }

    /* compiled from: BrowserView */
    class f implements Runnable {
        f() {
        }

        public void run() {
            if (!a.this.G()) {
                a aVar = a.this;
                if (!aVar.b(aVar.m())) {
                    a.this.n.a(a.this.D());
                }
            }
        }
    }

    /* compiled from: BrowserView */
    public interface g {
        void a();

        void a(int i);

        void a(View view, int i, WebChromeClient.CustomViewCallback customViewCallback);

        void a(ValueCallback<Uri> valueCallback);

        void a(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

        void a(WebView webView, boolean z, Message message);

        void a(String str, String str2);

        void a(String str, String str2, String str3, String str4, long j);

        void a(mark.via.a.a aVar);

        void a(a aVar, int i, String str);

        void a(boolean z);

        boolean a(View view, MotionEvent motionEvent);

        boolean a(WebView webView);

        Object b();

        void b(int i);

        boolean b(String str, String str2);

        void c(int i);

        boolean c();

        void d();
    }

    /* compiled from: BrowserView */
    private class h extends WebChromeClient {

        /* renamed from: mark.via.ui.view.a$h$a  reason: collision with other inner class name */
        /* compiled from: BrowserView */
        class C0048a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsResult f448a;

            C0048a(h hVar, JsResult jsResult) {
                this.f448a = jsResult;
            }

            public void onClick(View view) {
                this.f448a.cancel();
            }
        }

        /* compiled from: BrowserView */
        class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsResult f449a;

            b(h hVar, JsResult jsResult) {
                this.f449a = jsResult;
            }

            public void onClick(View view) {
                this.f449a.confirm();
            }
        }

        /* compiled from: BrowserView */
        class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ GeolocationPermissions.Callback f450a;
            final /* synthetic */ String b;

            c(h hVar, GeolocationPermissions.Callback callback, String str) {
                this.f450a = callback;
                this.b = str;
            }

            public void onClick(View view) {
                this.f450a.invoke(this.b, false, true);
            }
        }

        /* compiled from: BrowserView */
        class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ GeolocationPermissions.Callback f451a;
            final /* synthetic */ String b;

            d(h hVar, GeolocationPermissions.Callback callback, String str) {
                this.f451a = callback;
                this.b = str;
            }

            public void onClick(View view) {
                this.f451a.invoke(this.b, true, true);
            }
        }

        /* compiled from: BrowserView */
        class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PermissionRequest f452a;

            e(h hVar, PermissionRequest permissionRequest) {
                this.f452a = permissionRequest;
            }

            @TargetApi(21)
            public void run() {
                this.f452a.deny();
            }
        }

        /* compiled from: BrowserView */
        class f implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsResult f453a;

            f(h hVar, JsResult jsResult) {
                this.f453a = jsResult;
            }

            public void onClick(View view) {
                this.f453a.cancel();
            }
        }

        /* compiled from: BrowserView */
        class g implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsResult f454a;

            g(h hVar, JsResult jsResult) {
                this.f454a = jsResult;
            }

            public void onClick(View view) {
                this.f454a.confirm();
            }
        }

        /* renamed from: mark.via.ui.view.a$h$h  reason: collision with other inner class name */
        /* compiled from: BrowserView */
        class C0049h implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsResult f455a;

            C0049h(h hVar, JsResult jsResult) {
                this.f455a = jsResult;
            }

            public void onClick(View view) {
                this.f455a.cancel();
            }
        }

        /* compiled from: BrowserView */
        class i implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsResult f456a;

            i(h hVar, JsResult jsResult) {
                this.f456a = jsResult;
            }

            public void onClick(View view) {
                this.f456a.confirm();
            }
        }

        /* compiled from: BrowserView */
        class j implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsPromptResult f457a;

            j(h hVar, JsPromptResult jsPromptResult) {
                this.f457a = jsPromptResult;
            }

            public void onClick(View view) {
                this.f457a.cancel();
            }
        }

        /* compiled from: BrowserView */
        class k extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JsPromptResult f458a;

            k(h hVar, JsPromptResult jsPromptResult) {
                this.f458a = jsPromptResult;
            }

            @Override // a.a.b.i.i
            public void a(String[] strArr) {
                String str = strArr[0];
                if (TextUtils.isEmpty(str)) {
                    this.f458a.cancel();
                } else {
                    this.f458a.confirm(str);
                }
            }
        }

        private h() {
        }

        public Bitmap getDefaultVideoPoster() {
            new BitmapFactory.Options().inSampleSize = 4;
            return BitmapFactory.decodeResource(a.this.c.getResources(), 17301540);
        }

        public View getVideoLoadingProgressView() {
            return LayoutInflater.from(a.this.c).inflate(R.layout.h, (ViewGroup) null);
        }

        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            try {
                a.this.n.a(webView, z2, message);
                return true;
            } catch (Exception e2) {
                a.a.b.p.d.a(e2);
                return true;
            }
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            String str2;
            if (str.length() > 50) {
                str2 = str.substring(0, 50) + "...";
            } else {
                str2 = str;
            }
            a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(a.this.c).b(R.string.eh);
            cVar.c(str2 + a.a.b.p.a.e(a.this.c, R.string.ew));
            cVar.b(false);
            ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(R.string.c, new d(this, callback, str))).a(R.string.p, new c(this, callback, str))).g();
        }

        public void onHideCustomView() {
            a.this.n.a();
            super.onHideCustomView();
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(a.this.c).b(R.string.cl);
            cVar.c(str2);
            cVar.b(false);
            ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(17039370, new g(this, jsResult))).b(R.string.db, new f(this, jsResult))).g();
            return true;
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(a.this.b).b(R.string.bq);
            cVar.c(str2);
            cVar.b(false);
            ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(R.string.eg, new b(this, jsResult))).a(R.string.hn, new C0048a(this, jsResult))).g();
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(a.this.c).b(R.string.cl);
            cVar.c(str2);
            cVar.b(false);
            ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(17039370, new i(this, jsResult))).a(17039360, new C0049h(this, jsResult))).g();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(a.this.c).b(R.string.cl);
            dVar.a(0, str3, str2);
            dVar.b(false);
            ((a.a.b.i.d) ((a.a.b.i.d) dVar.a(17039370, new k(this, jsPromptResult))).a(17039360, new j(this, jsPromptResult))).g();
            return true;
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (permissionRequest != null) {
                a.this.b.runOnUiThread(new e(this, permissionRequest));
            }
        }

        public void onProgressChanged(WebView webView, int i2) {
            if (webView.isShown() && (i2 == 100 || !a.this.f(webView.getUrl()))) {
                a.this.n.c(i2);
            }
            if (i2 > 30 && i2 < 100 && !a.this.e) {
                a aVar = a.this;
                boolean unused = aVar.e = aVar.n.a(webView);
            }
            if (i2 > 80 && i2 < 100) {
                a.this.a(webView);
            }
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            a.this.a(bitmap);
        }

        public void onReceivedTitle(WebView webView, String str) {
            a.this.g(str);
            if (webView.isShown()) {
                a.this.n.d();
            }
            a.this.n.a(str, webView.getUrl());
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (mark.via.b.a.g >= 19) {
                a.this.n.a(view, 0, customViewCallback);
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            a.this.n.a(valueCallback, fileChooserParams);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            a.this.n.a(valueCallback);
        }

        /* synthetic */ h(a aVar, C0047a aVar2) {
            this();
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            a.this.n.a(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            a.this.n.a(valueCallback);
        }

        @Deprecated
        public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            int i3 = mark.via.b.a.g;
            if (i3 >= 14 && i3 <= 18) {
                a.this.n.a(view, i2, customViewCallback);
                super.onShowCustomView(view, i2, customViewCallback);
            }
        }
    }

    /* compiled from: BrowserView */
    private class i implements DownloadListener {
        private i() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            a.this.n.a(str, str2, str3, str4, j);
        }

        /* synthetic */ i(a aVar, C0047a aVar2) {
            this();
        }
    }

    /* compiled from: BrowserView */
    private class j extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private String[] f460a;
        private int b;

        /* renamed from: mark.via.ui.view.a$j$a  reason: collision with other inner class name */
        /* compiled from: BrowserView */
        class C0050a extends a.a.b.i.i {
            C0050a() {
            }

            @Override // a.a.b.i.i
            public void a(String[] strArr) {
                if (!a.a.b.p.a.a(strArr, 2)) {
                    mark.via.a.a aVar = new mark.via.a.a();
                    aVar.e(strArr[0]);
                    aVar.b(mark.via.util.i.b(strArr[1]));
                    a.this.n.a(aVar);
                }
            }
        }

        /* compiled from: BrowserView */
        class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ HttpAuthHandler f462a;

            b(j jVar, HttpAuthHandler httpAuthHandler) {
                this.f462a = httpAuthHandler;
            }

            public void onClick(View view) {
                this.f462a.cancel();
            }
        }

        /* compiled from: BrowserView */
        class c extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ HttpAuthHandler f463a;

            c(j jVar, HttpAuthHandler httpAuthHandler) {
                this.f463a = httpAuthHandler;
            }

            @Override // a.a.b.i.i
            public void a(String[] strArr) {
                if (a.a.b.p.a.a(strArr, 2)) {
                    this.f463a.cancel();
                } else {
                    this.f463a.proceed(strArr[0], strArr[1]);
                }
            }
        }

        /* compiled from: BrowserView */
        class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SslErrorHandler f464a;

            d(j jVar, SslErrorHandler sslErrorHandler) {
                this.f464a = sslErrorHandler;
            }

            public void onClick(View view) {
                this.f464a.cancel();
            }
        }

        /* compiled from: BrowserView */
        class e extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SslErrorHandler f465a;

            e(SslErrorHandler sslErrorHandler) {
                this.f465a = sslErrorHandler;
            }

            @Override // a.a.b.i.i
            public void a(boolean z) {
                if (z) {
                    a.this.d.l0();
                }
            }

            @Override // a.a.b.i.i
            public void a() {
                j.a(j.this);
                this.f465a.proceed();
            }
        }

        /* compiled from: BrowserView */
        class f implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Message f466a;

            f(j jVar, Message message) {
                this.f466a = message;
            }

            public void onClick(View view) {
                this.f466a.sendToTarget();
            }
        }

        /* compiled from: BrowserView */
        class g implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Message f467a;

            g(j jVar, Message message) {
                this.f467a = message;
            }

            public void onClick(View view) {
                this.f467a.sendToTarget();
            }
        }

        private j() {
            this.f460a = new String[2];
            this.b = 0;
        }

        static /* synthetic */ int a(j jVar) {
            int i = jVar.b;
            jVar.b = i + 1;
            return i;
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(a.this.b).b(R.string.i0);
            cVar.c(R.string.es);
            cVar.b(true);
            ((a.a.b.i.c) ((a.a.b.i.c) cVar.c(17039370, new g(this, message2))).a(17039360, new f(this, message))).g();
        }

        public void onPageFinished(WebView webView, String str) {
            if (!a.this.e) {
                a.this.n.a(webView);
            }
            a.this.a(webView);
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
         method: mark.via.ui.view.a.b(mark.via.ui.view.a, boolean):boolean
         arg types: [mark.via.ui.view.a, int]
         candidates:
          mark.via.ui.view.a.b(mark.via.ui.view.a, android.webkit.WebView):boolean
          mark.via.ui.view.a.b(mark.via.ui.view.a, java.lang.String):boolean
          mark.via.ui.view.a.b(mark.via.ui.view.a, boolean):boolean */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.ui.view.a.d(mark.via.ui.view.a, boolean):boolean
         arg types: [mark.via.ui.view.a, int]
         candidates:
          mark.via.ui.view.a.d(mark.via.ui.view.a, java.lang.String):void
          mark.via.ui.view.a.d(mark.via.ui.view.a, boolean):boolean */
        @SuppressLint({"SetJavaScriptEnabled"})
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String a2 = mark.via.util.b.a(str, false);
            String[] strArr = this.f460a;
            strArr[0] = str;
            strArr[1] = a2;
            a.this.d();
            boolean c2 = mark.via.util.b.c(a.this.c, str);
            boolean unused = a.this.e = c2;
            boolean unused2 = a.this.f = false;
            boolean isShown = webView.isShown();
            a aVar = a.this;
            boolean unused3 = aVar.m = !c2 && !aVar.n.b(str, null);
            FastView fastView = (FastView) webView;
            if (isShown && !c2) {
                a.this.n.d();
            }
            a.this.a((Bitmap) null);
            if (c2) {
                String unused4 = a.this.l = a2;
                boolean unused5 = a.this.j = false;
                int unused6 = a.this.k = 0;
                if (isShown) {
                    a.this.n.a(a.this.k);
                }
                fastView.setWebColor(a.this.k);
            } else if (a.this.k == 0 || !a2.equals(a.this.l)) {
                boolean unused7 = a.this.j = true;
                fastView.setWebColor(0);
            } else {
                boolean unused8 = a.this.j = false;
                fastView.setWebColor(a.this.k);
            }
            if (!TextUtils.isEmpty(str)) {
                if (a2.contains("greasyfork.org") && str.endsWith("user.js")) {
                    a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(a.this.c).b(R.string.ap);
                    dVar.a(0, "", R.string.gg);
                    dVar.a(1, mark.via.b.b.a(str), R.string.gf);
                    dVar.c(false);
                    ((a.a.b.i.d) dVar.a(17039370, new C0050a())).g();
                    webView.stopLoading();
                }
                if (webView.isShown() && a.this.f(str)) {
                    a.this.n.c(100);
                }
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(a.this.c).b(R.string.i1);
            dVar.a(0, "", R.string.ds);
            dVar.a(1, "", R.string.f0do);
            dVar.b(false);
            a.a.b.i.d dVar2 = (a.a.b.i.d) ((a.a.b.i.d) dVar.a(17039370, new c(this, httpAuthHandler))).a(17039360, new b(this, httpAuthHandler));
            if (Build.VERSION.SDK_INT >= 26) {
                dVar2.c(0).setAutofillHints(new String[]{"username"});
                dVar2.c(1).setAutofillHints(new String[]{"password"});
                dVar2.c(1).setInputType(128);
            }
            dVar2.g();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: MutableMD:(int, boolean):a.a.b.i.a
         arg types: [int, int]
         candidates:
          MutableMD:(int, a.a.b.i.i):a.a.b.i.a
          MutableMD:(int, android.view.View$OnClickListener):a.a.b.i.a
          MutableMD:(java.lang.String, a.a.b.i.i):a.a.b.i.a
          MutableMD:(java.lang.String, android.view.View$OnClickListener):a.a.b.i.a
          MutableMD:(java.lang.String, boolean):a.a.b.i.a
          a.a.b.i.a.a(int, int):void
          a.a.b.i.a.a(android.widget.TextView, java.lang.String):boolean
          MutableMD:(int, boolean):a.a.b.i.a */
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (URLUtil.isFileUrl(webView.getUrl())) {
                sslErrorHandler.proceed();
            }
            String str = null;
            if (!a.this.d.C()) {
                if (!a.this.o.a().i()) {
                    int primaryError = sslError.getPrimaryError();
                    if (primaryError == 0) {
                        str = a.a.b.p.a.e(a.this.c, R.string.ex);
                    } else if (primaryError == 1) {
                        str = a.a.b.p.a.e(a.this.c, R.string.er);
                    } else if (primaryError == 2) {
                        str = a.a.b.p.a.e(a.this.c, R.string.et);
                    } else if (primaryError == 3) {
                        str = a.a.b.p.a.e(a.this.c, R.string.ey);
                    } else if (primaryError == 4) {
                        str = a.a.b.p.a.e(a.this.c, R.string.em);
                    } else if (primaryError == 5) {
                        str = a.a.b.p.a.e(a.this.c, R.string.ev);
                    }
                } else if (mark.via.util.c.b() && sslError.getPrimaryError() == 3) {
                    str = a.a.b.p.a.e(a.this.c, R.string.ey);
                }
            }
            if (str != null) {
                a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(a.this.b).b(R.string.i3);
                cVar.c(str);
                cVar.b(false);
                a.a.b.i.c cVar2 = (a.a.b.i.c) ((a.a.b.i.c) cVar.a(17039370, new e(sslErrorHandler))).a(17039360, new d(this, sslErrorHandler));
                if (this.b >= 3) {
                    cVar2.a(R.string.dx, false);
                }
                cVar2.g();
                return;
            }
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT < 21 || !a(webView, webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return (WebResourceResponse) mark.via.b.a.f;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT < 24) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            String uri = webResourceRequest.getUrl().toString();
            return a(webView, uri, a.this.o.c(uri) && !webResourceRequest.isRedirect() && webResourceRequest.hasGesture());
        }

        private boolean a(WebView webView, String str) {
            boolean z = false;
            if (webView == null) {
                return false;
            }
            if (a.this.m && a.this.n.b(str, null)) {
                z = true;
            }
            if (!mark.via.util.b.a(a.this.c, str, a.this.o.a().a())) {
                a.this.q.a(webView.getId(), str, z);
            }
            return z;
        }

        /* synthetic */ j(a aVar, C0047a aVar2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            int i = Build.VERSION.SDK_INT;
            if (i < 11 || i >= 21 || !a(webView, str)) {
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) mark.via.b.a.f;
        }

        private boolean a(WebView webView, String str, boolean z) {
            boolean z2;
            if ("NewWindow".equals(webView.getTag())) {
                webView.setTag(null);
                a.a.b.p.d.a("is new window");
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                a.a.b.p.d.a(str);
            }
            if (a.this.e(str) || (!z2 && z && a.this.d(str))) {
                return true;
            }
            ((FastView) webView).setCanForward(true);
            a.this.C();
            a.this.o.a(webView, str);
            return false;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(11)
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebView.HitTestResult hitTestResult;
            int i = Build.VERSION.SDK_INT;
            if (i < 11 || i >= 24) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return a(webView, str, (!a.this.o.c(str) || (hitTestResult = webView.getHitTestResult()) == null || hitTestResult.getType() == 0) ? false : true);
        }
    }

    public a(Activity activity, String str, g gVar) {
        this.b = activity;
        this.c = activity;
        this.n = gVar;
        this.d = mark.via.f.a.b(activity);
        mark.via.h.a aVar = new mark.via.h.a();
        aVar.a(new C0047a());
        this.q = aVar;
        this.f440a = new FrameLayout(activity);
        this.o = mark.via.refactor.config.c.a(this.c);
        this.p = "file://" + this.c.getFilesDir().getPath();
        this.i = new FrameLayout.LayoutParams(-1, -1);
        b bVar = new b(this.c, this);
        this.h = this.g.size();
        this.g.add(bVar);
        bVar.c().setId(this.h);
        this.f440a.addView(bVar.c(), this.i);
        if (str != null && !str.trim().isEmpty() && !e(str)) {
            this.o.a(bVar.c(), str);
            bVar.c().loadUrl(str);
        } else if (str == null) {
            p();
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        int size = this.g.size();
        if (size > this.h + 1) {
            while (true) {
                size--;
                if (size > this.h) {
                    this.g.get(size).b();
                    this.g.remove(size);
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public int D() {
        return m().getWebColor();
    }

    private void E() {
        int size = this.g.size();
        if (size >= 6) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = this.h;
                if (i3 < i4 - 3 || i3 > i4 + 2) {
                    b bVar = this.g.get(i3);
                    if (!bVar.d()) {
                        bVar.a();
                    }
                } else {
                    i2++;
                }
            }
            a.a.b.p.d.a("Compressed count: " + i2);
        }
    }

    private boolean F() {
        return m().getProgress() < 100;
    }

    /* access modifiers changed from: private */
    public boolean G() {
        int i2 = this.h;
        return i2 < 0 || i2 >= this.g.size();
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
    private void H() {
        FastView m2 = m();
        g(m2.getTitle());
        a(m2.getFavicon());
        if (this.f440a.isShown()) {
            this.n.d();
            this.n.c(m2.getProgress());
            this.n.a(m2.getWebColor());
            this.l = mark.via.util.b.a(m2.getUrl(), false);
        }
    }

    public boolean A() {
        return this.q.b() == this.h && this.q.a();
    }

    public void B() {
        m().stopLoading();
    }

    public void n() {
        FastView m2 = m();
        if (m2.canGoBack()) {
            m2.goBack();
            return;
        }
        int i2 = this.h;
        if (i2 > 0) {
            this.h = i2 - 1;
            this.f440a.removeAllViews();
            b bVar = this.g.get(this.h);
            if (bVar.d()) {
                bVar.e();
            }
            this.f440a.addView(bVar.c(), this.i);
            b(bVar.c());
            c(i2);
            d(this.h);
            H();
            this.n.a(A());
            E();
        }
    }

    public void o() {
        FastView m2 = m();
        if (m2.canGoForward()) {
            m2.goForward();
            return;
        }
        int size = this.g.size();
        int i2 = this.h;
        if (size > i2 + 1) {
            this.h = i2 + 1;
            this.f440a.removeAllViews();
            b bVar = this.g.get(this.h);
            if (bVar.d()) {
                bVar.e();
            }
            this.f440a.addView(bVar.c(), this.i);
            b(bVar.c());
            c(i2);
            d(this.h);
            H();
            this.n.a(A());
            E();
        }
    }

    public void p() {
        if (!mark.via.util.b.a(this.c, m().getUrl(), 8)) {
            String a2 = this.o.a().a();
            if (a2.startsWith("about:home") || a2.startsWith("about:links")) {
                this.n.a(this, 1, (String) null);
            } else if (a2.startsWith("about:bookmarks")) {
                this.n.a(this, 2, (String) null);
            } else {
                m().loadUrl(a2);
            }
        }
    }

    public boolean q() {
        return this.t;
    }

    public boolean r() {
        FrameLayout frameLayout = this.f440a;
        return frameLayout != null && frameLayout.isShown();
    }

    public void s() {
        this.n = null;
        this.f440a.removeAllViews();
        for (b bVar : this.g) {
            bVar.b();
        }
        this.g.clear();
        this.q.d();
        this.q = null;
    }

    public void t() {
        c(this.h);
    }

    public void u() {
        d(this.h);
    }

    public void v() {
        if (!F() && !G()) {
            if (mark.via.util.b.a(this.c, l(), this.o.a().a()) || D() != 0) {
                this.n.a(D());
            } else {
                new Handler().postDelayed(new f(), 400);
            }
        }
    }

    public void w() {
        m().pauseTimers();
    }

    public void x() {
        FastView m2 = m();
        if (m2 != null && m2.getUrl() != null) {
            int a2 = mark.via.util.b.a(this.c, m2.getUrl());
            String str = null;
            if (a2 == 0 || a2 == -1) {
                this.l = null;
                m2.reload();
                return;
            }
            g gVar = this.n;
            if (a2 == 11) {
                str = m2.getTitle();
            }
            gVar.a(this, a2, str);
        }
    }

    public void y() {
        if (m() != null) {
            m().requestFocus();
        }
    }

    public void z() {
        m().resumeTimers();
    }

    /* access modifiers changed from: private */
    public boolean f(String str) {
        return str != null && !str.isEmpty() && str.startsWith("file://") && (str.startsWith(this.p) || str.equalsIgnoreCase(this.o.a().a()));
    }

    public int g() {
        return this.r;
    }

    public List<mark.via.a.c> h() {
        return this.q.c();
    }

    public FrameLayout i() {
        return this.f440a;
    }

    public int j() {
        return m().getProgress();
    }

    public String k() {
        return TextUtils.isEmpty(this.s) ? a.a.b.p.a.e(this.c, R.string.ij) : this.s;
    }

    public String l() {
        if (G()) {
            return "";
        }
        return m().getUrl();
    }

    public FastView m() {
        if (G()) {
            return null;
        }
        return this.g.get(this.h).c();
    }

    /* access modifiers changed from: private */
    public void g(String str) {
        if (!k().equals(str)) {
            this.s = str;
            this.n.b(this.r);
        }
    }

    public void e() {
        t();
        this.t = false;
    }

    private void c(int i2) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.g.get(i2).c().onPause();
        }
    }

    private void d(int i2) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.g.get(i2).c().onResume();
        }
    }

    /* access modifiers changed from: private */
    public boolean e(String str) {
        if (str.contains("mailto:")) {
            if (MailTo.isMailTo(str)) {
                MailTo parse = MailTo.parse(str);
                try {
                    this.b.startActivity(mark.via.util.j.a(parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
                } catch (Exception e2) {
                    a.a.b.p.d.a(e2);
                }
            }
            return true;
        } else if (str.startsWith("tel:")) {
            try {
                this.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
            return true;
        } else if (str.startsWith("magnet:") || str.startsWith("intent://")) {
            mark.via.util.j.b(this.b, str);
            return true;
        } else if (str.startsWith("folder://")) {
            String substring = str.substring(9);
            this.n.a((a) null, substring.isEmpty() ? 2 : 11, substring);
            C();
            m().setCanForward(true);
            return true;
        } else if (str.startsWith("history://")) {
            this.n.a(this, 3, (String) null);
            C();
            m().setCanForward(true);
            return true;
        } else if (str.startsWith("v://")) {
            int a2 = n.a(str);
            if (a2 != 1) {
                this.n.a(this, a2, (String) null);
            } else {
                p();
            }
            C();
            m().setCanForward(true);
            return true;
        } else if (str.startsWith("thunder://") || str.startsWith("qqdl://") || str.startsWith("flashget://")) {
            String e3 = mark.via.util.b.e(str);
            if (!TextUtils.isEmpty(e3)) {
                this.n.a(e3, this.o.a().d(), "attachment", null, -1);
            }
            return true;
        } else if (str.startsWith("tg:")) {
            if (!str.startsWith("tg://")) {
                str = "tg://" + str.substring(str.indexOf("tg:") + 3);
            }
            mark.via.util.j.b(this.b, str);
            return true;
        } else if (str.startsWith("baidubox://")) {
            return true;
        } else {
            if (str.startsWith("file://") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://") || str.startsWith("javascript:") || str.startsWith("about:") || str.startsWith("folder://") || str.startsWith("data:") || str.startsWith("tg:") || str.startsWith("view-source:") || !str.contains("://")) {
                return false;
            }
            mark.via.util.j.b(this.b, str);
            return true;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void b(FastView fastView) {
        this.o.b(fastView);
        this.o.c(fastView);
    }

    public Bitmap f() {
        return this.u;
    }

    /* access modifiers changed from: private */
    public boolean d(String str) {
        c(str);
        return true;
    }

    public boolean c() {
        return this.g.size() > this.h + 1 || m().canGoForward();
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
    public boolean b(WebView webView) {
        boolean z;
        if (webView == null) {
            return false;
        }
        if ((!this.j && this.k != -1) || webView.getMeasuredWidth() <= 0) {
            return false;
        }
        int a2 = r.a(webView);
        this.k = a2;
        ((FastView) webView).setWebColor(a2);
        this.l = mark.via.util.b.a(webView.getUrl(), false);
        if (webView.isShown()) {
            this.n.a(this.k);
            z = true;
        } else {
            z = false;
        }
        this.j = false;
        return z;
    }

    @Override // mark.via.ui.view.b.C0051b
    public void a(FastView fastView) {
        a(this.b, fastView);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [mark.via.ui.view.b$b, mark.via.ui.view.a] */
    public void c(String str) {
        if (!TextUtils.isEmpty(str) && ((a) this).h < ((a) this).g.size()) {
            FastView c2 = ((a) this).g.get(((a) this).h).c();
            String url = c2.getUrl();
            String a2 = mark.via.util.b.a(str);
            if (e(a2)) {
                return;
            }
            if (a2.equals(url)) {
                ((a) this).o.a(c2, url);
                c2.reload();
            } else if (!((a) this).o.c(a2) || a2.startsWith("javascript:") || url == null || url.isEmpty() || a.a.b.p.f.a(a2, v)) {
                ((a) this).o.a(c2, a2);
                c2.loadUrl(a2);
            } else {
                m().setCanForward(false);
                C();
                b bVar = new b(((a) this).c, this);
                bVar.c().setReferer(l());
                bVar.c().loadUrl(a2);
                int i2 = ((a) this).h;
                ((a) this).h = ((a) this).g.size();
                bVar.c().setId(((a) this).h);
                ((a) this).g.add(bVar);
                ((a) this).f440a.removeAllViews();
                ((a) this).o.a(bVar.c(), a2);
                ((a) this).f440a.addView(bVar.c(), ((a) this).i);
                c(i2);
                d(((a) this).h);
                E();
            }
        }
    }

    public void d() {
        this.q.a(this.h);
        this.n.a(false);
    }

    private void a(Activity activity, FastView fastView) {
        this.o.a(fastView);
        r.a(fastView, a.a.b.p.a.d(activity, R.color.a7));
        if (Build.VERSION.SDK_INT >= 16) {
            fastView.setScrollBarSize(a.a.b.p.a.c(this.c, R.dimen.h));
        }
        fastView.setWebChromeClient(new h(this, null));
        fastView.setWebViewClient(new j(this, null));
        fastView.setDownloadListener(new i(this, null));
        fastView.setOnLongClickListener(new b());
        fastView.setOnTouchListener(new c());
        fastView.addJavascriptInterface(this.n.b(), "via");
        b(fastView);
    }

    public void b(int i2) {
        FrameLayout frameLayout = this.f440a;
        if (frameLayout != null) {
            frameLayout.setVisibility(i2);
        }
    }

    public boolean b() {
        return this.h > 0 || m().canGoBack();
    }

    public String b(String str) {
        String url = m().getUrl();
        if (!TextUtils.isEmpty(url) && !mark.via.util.b.a(this.c, url, this.o.a().a())) {
            return url.startsWith(str) ? mark.via.h.c.d.a(url) : url;
        }
        String Y = this.d.Y();
        if (!TextUtils.isEmpty(Y)) {
            return Y;
        }
        String b2 = mark.via.h.c.d.b(a.a.b.p.e.a(this.c));
        if (TextUtils.isEmpty(b2)) {
            return b2;
        }
        if (b2.equals(a.a.b.j.a.b().b(1))) {
            return "";
        }
        a.a.b.j.a.b().a(1, b2);
        return b2;
    }

    public void a(Context context) {
        this.o.b();
        this.o.a().a(context);
    }

    /* access modifiers changed from: private */
    public void a(WebView webView) {
        if (!this.f && webView != null) {
            if ((this.j || this.k == -1) && webView.getMeasuredWidth() > 0) {
                this.f = true;
                webView.postDelayed(new e(new d(webView), webView), 200);
            }
        }
    }

    public void a(String str) {
        if (str == null) {
            str = "";
        }
        if (Build.VERSION.SDK_INT >= 16) {
            m().findAllAsync(str);
        } else {
            m().findAll(str);
        }
    }

    public void a(int i2) {
        this.r = i2;
    }

    public void a() {
        u();
        this.t = true;
    }

    /* access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (this.u != bitmap) {
            this.u = bitmap;
            this.n.b(this.r);
        }
    }
}
