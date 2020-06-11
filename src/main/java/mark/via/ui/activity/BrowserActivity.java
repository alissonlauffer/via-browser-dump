package mark.via.ui.activity;

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
import android.net.MailTo;
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
import android.view.WindowInsets;
import android.view.WindowInsetsController;
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
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mark.lib.frogsupport.adapter.CommonAdapter;
import mark.lib.frogsupport.adapter.ViewHolder;
import mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener;
import mark.lib.frogsupport.adapter.util.ListUtils;
import mark.lib.frogsupport.animation.AnimationHelper;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.menu.FrogMenu;
import mark.lib.frogsupport.menu.FrogMenuBean;
import mark.lib.frogsupport.menu.OnFrogMenusClickListener;
import mark.lib.frogsupport.toast.FrogToast;
import mark.lib.frogsupport.toast.OnFrogToastListener;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FileCompat;
import mark.lib.frogsupport.util.FrogUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.adapter.AddonItem;
import mark.via.adapter.HistoryItem;
import mark.via.adapter.LogItem;
import mark.via.adapter.SearchAdapter;
import mark.via.browser.FastView;
import mark.via.browser.TabItem;
import mark.via.component.BrowserModule;
import mark.via.component.DaggerBrowserComponent;
import mark.via.constants.Constants;
import mark.via.constants.JS;
import mark.via.flurry.FlurryHelper;
import mark.via.flurry.FlurryRemoteConfig;
import mark.via.gp.R;
import mark.via.handler.ClickHandler;
import mark.via.handler.DatabaseHandler;
import mark.via.helpers.BookmarkHelper;
import mark.via.helpers.Callback;
import mark.via.helpers.FileLoggingHelper;
import mark.via.helpers.HistoryHelper;
import mark.via.manager.BookmarkManager;
import mark.via.p042l.ConfManager;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.p044m.p045a.PageManager;
import mark.via.p044m.p046b.DownloaderSlice;
import mark.via.p044m.p046b.SiteConfSlice;
import mark.via.p044m.p046b.Slice;
import mark.via.p044m.p047c.FabDragListener;
import mark.via.p044m.p047c.GestureTouchEvent;
import mark.via.p044m.p047c.SmoothProgressBar;
import mark.via.preference.PreferenceManager;
import mark.via.receivers.BrowserBroadcastReceiver;
import mark.via.ui.settings.AccountSettings;
import mark.via.ui.settings.CustomFiltersUI;
import mark.via.ui.settings.SettingsCatalog;
import mark.via.utils.AppUtils;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ChannelUtils;
import mark.via.utils.ConfUtil;
import mark.via.utils.FileIntentUtils;
import mark.via.utils.FileUtil;
import mark.via.utils.FileUtils;
import mark.via.utils.InfoUtils;
import mark.via.utils.IntentUtils;
import mark.via.utils.JSUtils;
import mark.via.utils.PageUtil;
import mark.via.utils.SupportUtils;
import mark.via.utils.ViewUtils;
import mark.via.utils.WebAdressUtils;
import mark.via.utils.WebViewUtil;
import org.json.JSONArray;
import p000a.p001a.p002a.Blocker;
import p000a.p001a.p002a.util.FilterUtils;
import p016e.p017a.p018a.Downloader;
import p016e.p017a.p018a.DownloaderUtils;
import p016e.p017a.p018a.MimeTypeUtils;
import timber.log.Timber;

public class BrowserActivity extends Activity implements TabItem.AbstractC0409b {

    /* renamed from: A */
    private ImageView f1560A;

    /* renamed from: A0 */
    private List<FrogMenuBean> f1561A0 = new ArrayList();

    /* renamed from: B */
    private int f1562B = 0;

    /* renamed from: B0 */
    private View f1563B0;

    /* renamed from: C */
    private BroadcastReceiver f1564C;

    /* renamed from: C0 */
    private CommonAdapter f1565C0;

    /* renamed from: D */
    private int f1566D;

    /* renamed from: D0 */
    private ListView f1567D0;

    /* renamed from: E */
    private FrameLayout f1568E;

    /* renamed from: E0 */
    private Drawable f1569E0;

    /* renamed from: F */
    private int f1570F;

    /* renamed from: F0 */
    private GestureTouchEvent f1571F0;

    /* renamed from: G */
    private View f1572G;

    /* renamed from: G0 */
    private boolean f1573G0 = false;

    /* renamed from: H */
    private boolean f1574H = false;

    /* renamed from: H0 */
    private boolean f1575H0 = false;

    /* renamed from: I */
    private ImageView f1576I;

    /* renamed from: I0 */
    private final ViewTreeObserver.OnGlobalLayoutListener f1577I0 = new ViewTreeObserver$OnGlobalLayoutListenerC0528q();

    /* renamed from: J */
    private ImageView f1578J;

    /* renamed from: J0 */
    private boolean f1579J0 = false;

    /* renamed from: K */
    private View f1580K;

    /* renamed from: K0 */
    private int f1581K0 = -1;

    /* renamed from: L */
    private FrameLayout f1582L;

    /* renamed from: L0 */
    private boolean f1583L0 = false;

    /* renamed from: M */
    private View f1584M;

    /* renamed from: M0 */
    private boolean f1585M0 = false;

    /* renamed from: N */
    private FrameLayout f1586N;

    /* renamed from: N0 */
    private boolean f1587N0 = false;

    /* renamed from: O */
    private ImageView f1588O;

    /* renamed from: O0 */
    private final View.OnClickListener f1589O0 = new View$OnClickListenerC0529r();

    /* renamed from: P */
    private View f1590P;

    /* renamed from: P0 */
    private long f1591P0 = 0;

    /* renamed from: Q */
    private SmoothProgressBar f1592Q;

    /* renamed from: Q0 */
    private int f1593Q0 = 0;

    /* renamed from: R */
    private int f1594R;

    /* renamed from: R0 */
    private boolean f1595R0 = false;

    /* renamed from: S */
    private final AtomicBoolean f1596S = new AtomicBoolean(false);

    /* renamed from: S0 */
    private final View.OnLongClickListener f1597S0 = new View$OnLongClickListenerC0531t();

    /* renamed from: T */
    private LayoutInflater f1598T;

    /* renamed from: U */
    private BrowserJsCallback f1599U;

    /* renamed from: V */
    private int f1600V = -1;

    /* renamed from: W */
    private int f1601W = -1;

    /* renamed from: X */
    private boolean f1602X = false;

    /* renamed from: Y */
    private boolean f1603Y = false;

    /* renamed from: Z */
    private boolean f1604Z = false;

    /* renamed from: a */
    private Activity f1605a;

    /* renamed from: a0 */
    private int f1606a0 = -1;

    /* renamed from: b */
    private Context f1607b;

    /* renamed from: b0 */
    private ViewGroup f1608b0;

    /* renamed from: c */
    private List<TabItem> f1609c;

    /* renamed from: c0 */
    private boolean f1610c0 = false;

    /* renamed from: d */
    private View f1611d;

    /* renamed from: d0 */
    private boolean f1612d0 = false;

    /* renamed from: e */
    private TextView f1613e;

    /* renamed from: e0 */
    private GestureDetector f1614e0;

    /* renamed from: f */
    private FrameLayout f1615f;

    /* renamed from: f0 */
    private Downloader f1616f0;

    /* renamed from: g */
    private RelativeLayout f1617g;

    /* renamed from: g0 */
    private boolean f1618g0 = false;

    /* renamed from: h */
    private AutoCompleteTextView f1619h;

    /* renamed from: h0 */
    private int f1620h0 = 0;

    /* renamed from: i */
    private ProgressBar f1621i;

    /* renamed from: i0 */
    private int f1622i0 = 0;

    /* renamed from: j */
    private TabItem f1623j = null;

    /* renamed from: j0 */
    private DataChecker f1624j0;

    /* renamed from: k */
    private int f1625k = -1;

    /* renamed from: k0 */
    private SiteConfSlice f1626k0;

    /* renamed from: l */
    private int f1627l = 0;

    /* renamed from: l0 */
    private DownloaderSlice f1628l0;

    /* renamed from: m */
    private String f1629m;

    /* renamed from: m0 */
    private boolean f1630m0 = false;

    /* renamed from: n */
    private String f1631n;

    /* renamed from: n0 */
    Blocker f1632n0;

    /* renamed from: o */
    private DatabaseHandler f1633o;

    /* renamed from: o0 */
    String f1634o0;

    /* renamed from: p */
    private PreferenceManager f1635p;

    /* renamed from: p0 */
    ConfManager f1636p0;

    /* renamed from: q */
    private ValueCallback<Uri> f1637q;

    /* renamed from: q0 */
    private int f1638q0 = -1;

    /* renamed from: r */
    private ClickHandler f1639r;

    /* renamed from: r0 */
    private final AtomicBoolean f1640r0 = new AtomicBoolean(false);

    /* renamed from: s */
    private View f1641s;

    /* renamed from: s0 */
    private int f1642s0;

    /* renamed from: t */
    private FrameLayout f1643t;

    /* renamed from: t0 */
    private int f1644t0;

    /* renamed from: u */
    private WebChromeClient.CustomViewCallback f1645u;

    /* renamed from: u0 */
    private WebView f1646u0;

    /* renamed from: v */
    private ImageView f1647v;

    /* renamed from: v0 */
    private Runnable f1648v0 = null;

    /* renamed from: w */
    private long f1649w = 0;

    /* renamed from: w0 */
    private OnFrogMenusClickListener f1650w0 = new C0513c();

    /* renamed from: x */
    private int f1651x = 0;

    /* renamed from: x0 */
    private View f1652x0;

    /* renamed from: y */
    private int f1653y = 0;

    /* renamed from: y0 */
    private FrogMenu f1654y0;

    /* renamed from: z */
    private ValueCallback<Uri[]> f1655z;

    /* renamed from: z0 */
    private List<FrogMenuBean> f1656z0 = new ArrayList();

    /* access modifiers changed from: private */
    public class BrowserJsCallback {

        /* renamed from: mark.via.ui.activity.BrowserActivity$BrowserJsCallback$a */
        class RunnableC0509a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f1657a;

            /* renamed from: b */
            final /* synthetic */ int f1658b;

            /* renamed from: c */
            final /* synthetic */ int f1659c;

            RunnableC0509a(String str, int i, int i2) {
                this.f1657a = str;
                this.f1658b = i;
                this.f1659c = i2;
            }

            public void run() {
                String str;
                if (CompatUtils.m1336f(BrowserActivity.this.f1607b, R.string.g).equals(this.f1657a)) {
                    str = "";
                } else {
                    str = this.f1657a;
                }
                BrowserActivity.this.f1633o.mo974a(str, this.f1658b, this.f1659c);
                DataChecker.m1181c().mo667h(2);
            }
        }

        private BrowserJsCallback() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void mo1389b(String str) {
            BrowserActivity.this.m2414n3(str);
        }

        @JavascriptInterface
        public void addon(String str) {
            AddonItem j = BrowserUtils.m2089j(str);
            if (j != null) {
                int f = j.mo922f();
                if (BrowserActivity.this.f1633o.mo967B(f)) {
                    BrowserActivity.this.f1633o.mo977d(f);
                    QuickUtils.m1384p(BrowserActivity.this.f1607b, BrowserActivity.this.f1607b.getResources().getString(R.string.j4));
                    return;
                }
                BrowserActivity.this.f1633o.mo970F(j);
                QuickUtils.m1384p(BrowserActivity.this.f1607b, BrowserActivity.this.f1607b.getResources().getString(R.string.ev));
            }
        }

        @JavascriptInterface
        public void changeBookmarkOrder(String str, int i, int i2) {
            BrowserApp.m1389c().execute(new RunnableC0509a(str, i, i2));
        }

        @JavascriptInterface
        public void changeFavoriteOrder(int i, int i2) {
            BrowserActivity.this.f1633o.mo975b(i, i2);
            DataChecker.m1181c().mo667h(1);
        }

        @JavascriptInterface
        public String getInstalledAddonID() {
            List<Integer> n = BrowserActivity.this.f1633o.mo987n();
            JSONArray jSONArray = new JSONArray();
            for (Integer num : n) {
                jSONArray.put(num.intValue());
            }
            return jSONArray.toString();
        }

        @JavascriptInterface
        public void openSettings(int i) {
            if (i == 0) {
                FileCompat.m1353g(BrowserActivity.this.f1605a, "text/html", 101);
            } else if (i == 1) {
                Intent intent = new Intent(BrowserActivity.this.f1605a, AccountSettings.class);
                intent.putExtra("info", i);
                BrowserActivity.this.f1605a.startActivity(intent);
            }
        }

        @JavascriptInterface
        public void record(String str, String str2) {
            if (str != null && !str.isEmpty() && !str.startsWith("file://")) {
                BrowserActivity.this.f1632n0.mo5a(FilterUtils.m118w(str, str2));
            }
        }

        @JavascriptInterface
        public void searchText(String str) {
            BrowserActivity.this.f1605a.runOnUiThread(new RunnableC0562m(this, str));
        }

        @JavascriptInterface
        public void toast(String str) {
            QuickUtils.m1384p(BrowserActivity.this.f1607b, str);
        }

        /* synthetic */ BrowserJsCallback(BrowserActivity browserActivity, C0522k kVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$a */
    public class C0510a implements Callback {
        C0510a() {
        }

        @Override // mark.via.helpers.Callback
        /* renamed from: a */
        public void mo1052a() {
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.m2393h3(browserActivity.f1625k);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$a0 */
    public class C0511a0 implements Callback {
        C0511a0() {
        }

        @Override // mark.via.helpers.Callback
        /* renamed from: a */
        public void mo1052a() {
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.m2393h3(browserActivity.f1625k);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$b */
    public class C0512b implements TextWatcher {
        C0512b() {
        }

        public void afterTextChanged(Editable editable) {
            BrowserActivity.this.m2357X0(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: mark.via.ui.activity.BrowserActivity$c */
    class C0513c extends OnFrogMenusClickListener {
        C0513c() {
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void mo1401d(String[][] strArr, AdapterView adapterView, View view, int i, long j) {
            String str = strArr[0][i];
            BrowserActivity.this.f1635p.mo1116S0(str);
            BrowserActivity.this.f1616f0.mo393o(str);
            QuickUtils.m1384p(BrowserActivity.this.f1607b, strArr[1][i]);
            BrowserActivity.this.m2399j1();
        }

        @Override // mark.lib.frogsupport.menu.OnFrogMenusClickListener
        /* renamed from: a */
        public void mo727a(FrogMenuBean bVar, int i) {
            int b = bVar.mo716b();
            switch (b) {
                case R.string.a /* 2131558400 */:
                    FlurryHelper.m1681a().mo1036d("add_bookmark", true);
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.m2329P0();
                    return;
                case R.string.g /* 2131558406 */:
                    FlurryHelper.m1681a().mo1036d("bookmark", true);
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.m2372b3(2, null);
                    return;
                case R.string.q /* 2131558416 */:
                    FlurryHelper.m1681a().mo1036d("download", true);
                    if (!BrowserActivity.this.f1616f0.mo385g(BrowserActivity.this.f1605a)) {
                        BrowserActivity.this.m2461z3(5);
                        return;
                    }
                    return;
                case R.string.a2 /* 2131558428 */:
                    FlurryHelper.m1681a().mo1036d("night", true);
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.f1635p.mo1195v1(BrowserActivity.this.f1607b, !BrowserActivity.this.f1635p.mo1129Z(BrowserActivity.this.f1607b));
                    BrowserActivity.this.m2298G3();
                    return;
                case R.string.a6 /* 2131558432 */:
                    BrowserActivity.this.m2399j1();
                    boolean z = !BrowserActivity.this.f1635p.mo1138c0();
                    BrowserActivity.this.f1635p.mo1204y1(z);
                    if (z) {
                        FlurryHelper.m1681a().mo1036d("pc_view", true);
                    }
                    bVar.mo721g(z);
                    BrowserActivity.this.m2315K3();
                    if (BrowserActivity.this.f1623j != null && !BrowserUtils.m2101v(BrowserActivity.this.f1607b, BrowserActivity.this.f1623j.mo817L())) {
                        BrowserActivity.this.f1623j.mo833o0();
                        return;
                    }
                    return;
                case R.string.gu /* 2131558679 */:
                    FlurryHelper.m1681a().mo1036d("res", false);
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.m2400j3();
                    return;
                case R.string.ha /* 2131558696 */:
                    FlurryHelper.m1681a().mo1036d("settings", true);
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.startActivity(new Intent(BrowserActivity.this.f1607b, SettingsCatalog.class));
                    return;
                default:
                    switch (b) {
                        case R.string.s /* 2131558418 */:
                            FlurryHelper.m1681a().mo1036d("find_in_page", false);
                            BrowserActivity.this.m2399j1();
                            BrowserActivity.this.m2379d3(14);
                            return;
                        case R.string.t /* 2131558419 */:
                            BrowserActivity.this.m2399j1();
                            boolean z2 = !BrowserActivity.this.f1635p.mo1068C();
                            BrowserActivity.this.f1635p.mo1136b1(z2);
                            if (z2) {
                                FlurryHelper.m1681a().mo1036d("full_screen", false);
                            }
                            BrowserActivity.this.m2303H3();
                            bVar.mo721g(z2);
                            return;
                        case R.string.u /* 2131558420 */:
                            FlurryHelper.m1681a().mo1036d("history", true);
                            BrowserActivity.this.m2399j1();
                            BrowserActivity.this.m2372b3(3, null);
                            return;
                        case R.string.v /* 2131558421 */:
                            if (BrowserActivity.this.f1635p.mo1092K()) {
                                BrowserActivity.this.f1635p.mo1156i1(false);
                                BrowserActivity.this.f1635p.mo1081G0(false);
                                bVar.mo725k(BrowserActivity.this.getResources().getString(R.string.ef));
                                QuickUtils.m1384p(BrowserActivity.this.f1607b, BrowserActivity.this.getResources().getString(R.string.ef));
                            } else if (BrowserActivity.this.f1635p.mo1157j()) {
                                BrowserActivity.this.f1635p.mo1156i1(true);
                                bVar.mo725k(BrowserActivity.this.getResources().getString(R.string.ee));
                                QuickUtils.m1384p(BrowserActivity.this.f1607b, BrowserActivity.this.getResources().getString(R.string.ee));
                            } else {
                                FlurryHelper.m1681a().mo1036d("pic", false);
                                BrowserActivity.this.f1635p.mo1081G0(true);
                                bVar.mo725k(BrowserActivity.this.getResources().getString(R.string.eg));
                                QuickUtils.m1384p(BrowserActivity.this.f1607b, BrowserActivity.this.getResources().getString(R.string.eg));
                            }
                            BrowserActivity.this.m2315K3();
                            return;
                        case R.string.w /* 2131558422 */:
                            BrowserActivity.this.m2399j1();
                            boolean z3 = !BrowserActivity.this.f1635p.mo1095L();
                            BrowserActivity.this.f1635p.mo1159j1(z3);
                            DataChecker.m1181c().mo667h(3);
                            if (z3) {
                                FlurryHelper.m1681a().mo1036d("incognito", true);
                                ViewUtils.m2241s(BrowserActivity.this.f1580K.findViewById(R.id.ah));
                            }
                            QuickUtils.m1382n(BrowserActivity.this.f1607b, z3 ? R.string.et : R.string.es);
                            bVar.mo721g(z3);
                            return;
                        case R.string.x /* 2131558423 */:
                            FlurryHelper.m1681a().mo1036d("net_log", false);
                            BrowserActivity.this.m2399j1();
                            if (!BrowserUtils.m2101v(BrowserActivity.this.f1607b, BrowserActivity.this.f1623j.mo817L())) {
                                BrowserActivity browserActivity = BrowserActivity.this;
                                browserActivity.f1594R = browserActivity.f1623j.mo813H();
                            }
                            BrowserActivity browserActivity2 = BrowserActivity.this;
                            int e1 = browserActivity2.m2381e1(browserActivity2.f1594R);
                            if (e1 == -1 || ((TabItem) BrowserActivity.this.f1609c.get(e1)).mo814I().isEmpty()) {
                                QuickUtils.m1382n(BrowserActivity.this.f1607b, R.string.fs);
                                return;
                            } else {
                                BrowserActivity.this.m2372b3(6, null);
                                return;
                            }
                        default:
                            switch (b) {
                                case R.string.ab /* 2131558438 */:
                                    FlurryHelper.m1681a().mo1036d("save_page", false);
                                    BrowserActivity.this.m2399j1();
                                    BrowserActivity.this.m2379d3(18);
                                    return;
                                case R.string.ac /* 2131558439 */:
                                    FlurryHelper.m1681a().mo1036d("saved_pages", false);
                                    BrowserActivity.this.m2399j1();
                                    BrowserActivity.this.m2372b3(7, null);
                                    return;
                                default:
                                    switch (b) {
                                        case R.string.ae /* 2131558441 */:
                                            FlurryHelper.m1681a().mo1036d("share", true);
                                            BrowserActivity.this.m2399j1();
                                            if (BrowserActivity.this.f1623j == null || BrowserUtils.m2105z(BrowserActivity.this.f1623j.mo817L())) {
                                                IntentUtils.m2179f(BrowserActivity.this.f1607b, "http://viayoo.com/");
                                                return;
                                            }
                                            String K = BrowserActivity.this.f1623j.mo816K();
                                            if (CompatUtils.m1336f(BrowserActivity.this.f1607b, R.string.j5).equals(K) || K == null || K.isEmpty()) {
                                                IntentUtils.m2179f(BrowserActivity.this.f1607b, BrowserActivity.this.f1623j.mo817L());
                                                return;
                                            }
                                            IntentUtils.m2179f(BrowserActivity.this.f1607b, K + "\n" + BrowserActivity.this.f1623j.mo817L());
                                            return;
                                        case R.string.af /* 2131558442 */:
                                            FlurryHelper.m1681a().mo1036d("sources", false);
                                            BrowserActivity.this.m2399j1();
                                            BrowserActivity.this.m2379d3(19);
                                            return;
                                        case R.string.ag /* 2131558443 */:
                                            BrowserActivity.this.m2290E3();
                                            return;
                                        case R.string.ah /* 2131558444 */:
                                            FlurryHelper.m1681a().mo1036d("translate", false);
                                            if (BrowserActivity.this.f1623j == null || !WebViewUtil.m2047g(BrowserActivity.this.f1623j.mo817L())) {
                                                BrowserActivity.this.m2399j1();
                                                QuickUtils.m1384p(BrowserActivity.this.f1607b, CompatUtils.m1336f(BrowserActivity.this.f1607b, R.string.bi));
                                                return;
                                            }
                                            BrowserActivity.this.m2399j1();
                                            QuickUtils.m1382n(BrowserActivity.this.f1607b, R.string.iv);
                                            BrowserActivity.this.f1623j.mo828h0(JS.m1587a());
                                            return;
                                        case R.string.ai /* 2131558445 */:
                                            BrowserActivity.this.m2448w3(bVar, i);
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        }

        @Override // mark.lib.frogsupport.menu.OnFrogMenusClickListener
        /* renamed from: b */
        public void mo728b(FrogMenuBean bVar, int i) {
            String L;
            switch (bVar.mo716b()) {
                case R.string.q /* 2131558416 */:
                    String[][] d = Downloader.m919e(BrowserActivity.this.f1607b).mo384d(BrowserActivity.this.f1605a);
                    d[1][0] = CompatUtils.m1336f(BrowserActivity.this.f1607b, R.string.id);
                    String w = BrowserActivity.this.f1635p.mo1196w();
                    int length = d[0].length;
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (w.equals(d[0][i3])) {
                            i2 = i3;
                        }
                    }
                    TaoDialog g = TaoDialog.m1134g(BrowserActivity.this.f1607b);
                    g.mo620L(R.string.as);
                    g.mo619K(d[1], i2, new C0540b(this, d));
                    g.mo624P(BrowserActivity.this.f1654y0.mo707e(i));
                    return;
                case R.string.x /* 2131558423 */:
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.startActivity(new Intent(BrowserActivity.this.f1607b, CustomFiltersUI.class));
                    return;
                case R.string.a2 /* 2131558428 */:
                    if (Build.VERSION.SDK_INT < 29) {
                        boolean z = !BrowserActivity.this.f1635p.mo1127Y();
                        BrowserActivity.this.f1635p.mo1192u1(z);
                        QuickUtils.m1382n(BrowserActivity.this.f1607b, z ? R.string.fo : R.string.fn);
                        return;
                    }
                    return;
                case R.string.a6 /* 2131558432 */:
                    BrowserActivity.this.m2448w3(bVar, i);
                    return;
                case R.string.ae /* 2131558441 */:
                    BrowserActivity.this.m2399j1();
                    if (!(BrowserActivity.this.f1623j == null || (L = BrowserActivity.this.f1623j.mo817L()) == null || BrowserUtils.m2103x(BrowserActivity.this.f1607b, L, null))) {
                        IntentUtils.m2175b(BrowserActivity.this.f1605a, L);
                        return;
                    }
                    return;
                case R.string.ag /* 2131558443 */:
                    BrowserActivity.this.m2399j1();
                    FlurryHelper.m1681a().mo1036d("res", false);
                    BrowserActivity.this.m2399j1();
                    BrowserActivity.this.m2400j3();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$d */
    public class View$OnClickListenerC0514d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f1665a;

        View$OnClickListenerC0514d(int i) {
            this.f1665a = i;
        }

        public void onClick(View view) {
            BrowserActivity.this.m2350V0(this.f1665a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$e */
    public class C0515e extends CommonAdapter<TabItem> {
        C0515e(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, TabItem b0Var, int i) {
            BrowserActivity.this.m2443v3(cVar, b0Var, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$f */
    public class C0516f implements AdapterView.OnItemClickListener {
        C0516f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BrowserActivity.this.m2399j1();
            BrowserActivity.this.m2282C3(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$g */
    public class C0517g implements SwipeDismissListViewTouchListener.AbstractC0391e {
        C0517g() {
        }

        @Override // mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener.AbstractC0391e
        /* renamed from: a */
        public boolean mo703a(int i) {
            return true;
        }

        @Override // mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener.AbstractC0391e
        /* renamed from: b */
        public void mo704b(ListView listView, int[] iArr) {
            for (int i : iArr) {
                BrowserActivity.this.m2350V0(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$h */
    public class C0518h implements Downloader.AbstractC0337c {

        /* renamed from: mark.via.ui.activity.BrowserActivity$h$a */
        class C0519a extends OnFrogToastListener {
            C0519a() {
            }

            @Override // mark.lib.frogsupport.toast.OnFrogToastListener
            /* renamed from: a */
            public void mo778a() {
                BrowserActivity.this.m2461z3(5);
            }
        }

        C0518h() {
        }

        @Override // p016e.p017a.p018a.Downloader.AbstractC0337c
        /* renamed from: a */
        public void mo398a(long j) {
            BrowserActivity.this.f1628l0.mo1259m(j);
        }

        @Override // p016e.p017a.p018a.Downloader.AbstractC0337c
        /* renamed from: b */
        public void mo399b(long j) {
            if (BrowserActivity.this.f1606a0 != 5) {
                new FrogToast(BrowserActivity.this.f1605a, (int) R.string.d0, (int) R.string.jm, new C0519a()).mo773m();
            }
        }

        @Override // p016e.p017a.p018a.Downloader.AbstractC0337c
        /* renamed from: c */
        public void mo400c(long... jArr) {
            if (!BrowserActivity.this.f1618g0) {
                BrowserActivity.this.startActivity(new Intent(BrowserActivity.this.f1607b, BrowserActivity.class));
            }
            BrowserActivity.this.m2461z3(5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$i */
    public class C0520i extends GestureDetector.SimpleOnGestureListener {
        C0520i() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            BrowserActivity.this.m2358X2();
        }
    }

    /* renamed from: mark.via.ui.activity.BrowserActivity$j */
    class C0521j implements GestureTouchEvent.AbstractC0488a {
        C0521j() {
        }

        @Override // mark.via.p044m.p047c.GestureTouchEvent.AbstractC0488a
        /* renamed from: a */
        public boolean mo1295a() {
            return BrowserActivity.this.f1573G0;
        }

        @Override // mark.via.p044m.p047c.GestureTouchEvent.AbstractC0488a
        /* renamed from: b */
        public void mo1296b(View view, int i) {
            if (i == 1) {
                ((ImageView) view).setImageDrawable(CompatUtils.m1334d(BrowserActivity.this.f1607b, R.drawable.a6));
            } else if (i == 2) {
                ((ImageView) view).setImageDrawable(CompatUtils.m1334d(BrowserActivity.this.f1607b, R.drawable.r));
            }
        }

        @Override // mark.via.p044m.p047c.GestureTouchEvent.AbstractC0488a
        /* renamed from: c */
        public int mo1297c() {
            if (BrowserActivity.this.f1623j == null || BrowserActivity.this.f1623j.mo818N() == null) {
                return 12;
            }
            int i = 0;
            int i2 = 1;
            boolean z = Build.VERSION.SDK_INT < 14 || (!BrowserActivity.this.f1623j.mo818N().canScrollHorizontally(1) && !BrowserActivity.this.f1623j.mo818N().canScrollHorizontally(-1));
            if (!z || !BrowserActivity.this.m2339S0()) {
                i2 = 0;
            }
            int i3 = 12 | i2;
            if (z && BrowserActivity.this.f1623j.mo842w()) {
                i = 2;
            }
            return i3 | i;
        }

        @Override // mark.via.p044m.p047c.GestureTouchEvent.AbstractC0488a
        /* renamed from: d */
        public void mo1298d(int i, int i2) {
            BrowserActivity.this.f1651x = i;
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.f1653y = i2 + browserActivity.f1586N.getHeight();
        }

        @Override // mark.via.p044m.p047c.GestureTouchEvent.AbstractC0488a
        /* renamed from: e */
        public void mo1299e(int i) {
            if (i == 1) {
                BrowserActivity.this.m2385f1();
            } else if (i == 2) {
                BrowserActivity.this.m2388g1();
            } else if (i == 4) {
                BrowserActivity.this.m2402k1();
            } else if (i == 8 && BrowserActivity.this.f1635p.mo1205z() != 2) {
                BrowserActivity.this.m2274A3();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$k */
    public class C0522k implements BrowserBroadcastReceiver.AbstractC0467a {
        C0522k() {
        }

        @Override // mark.via.receivers.BrowserBroadcastReceiver.AbstractC0467a
        /* renamed from: a */
        public void mo1213a(String str) {
            if (!TextUtils.isEmpty(str) && "android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
                BrowserActivity.this.m2315K3();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$l */
    public class C0523l implements TextWatcher {
        C0523l(BrowserActivity browserActivity) {
        }

        public void afterTextChanged(Editable editable) {
            if (!(editable == null || editable.length() == 0)) {
                for (CharacterStyle characterStyle : (CharacterStyle[]) editable.getSpans(0, editable.length(), MetricAffectingSpan.class)) {
                    editable.removeSpan(characterStyle);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$m */
    public class C0524m extends OnFrogToastListener {

        /* renamed from: a */
        final /* synthetic */ String[] f1675a;

        C0524m(String[] strArr) {
            this.f1675a = strArr;
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            BrowserActivity.this.m2404k3(this.f1675a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$n */
    public class C0525n implements FabDragListener.AbstractC0487d {

        /* renamed from: a */
        int f1677a;

        C0525n() {
        }

        @Override // mark.via.p044m.p047c.FabDragListener.AbstractC0487d
        /* renamed from: a */
        public void mo1286a(int i) {
            int i2;
            if (i == 0 && this.f1677a != 2) {
                i2 = R.drawable.a6;
                this.f1677a = 2;
            } else if (i == 1 && this.f1677a != 1) {
                i2 = R.drawable.r;
                this.f1677a = 1;
            } else if (i == 2 && this.f1677a != 3) {
                i2 = R.drawable.ay;
                this.f1677a = 3;
            } else if (i == 3 && this.f1677a != 5) {
                i2 = R.drawable.an;
                this.f1677a = 5;
            } else if (i != -1 || this.f1677a == 0) {
                i2 = -1;
            } else {
                i2 = R.drawable.ah;
                this.f1677a = 0;
            }
            if (i2 != -1) {
                BrowserActivity.this.f1576I.setImageDrawable(CompatUtils.m1334d(BrowserActivity.this.f1607b, i2));
            }
        }

        @Override // mark.via.p044m.p047c.FabDragListener.AbstractC0487d
        /* renamed from: b */
        public int[] mo1287b(View view, int i, int i2) {
            char c;
            int i3;
            int i4 = 2;
            int[] iArr = new int[2];
            int j = ViewUtils.m2232j(BrowserActivity.this.f1607b);
            int k = ViewUtils.m2233k(BrowserActivity.this.f1607b);
            int dimensionPixelSize = BrowserActivity.this.f1607b.getResources().getDimensionPixelSize(R.dimen.b);
            int width = view.getWidth();
            int height = view.getHeight();
            int i5 = k / 3;
            int i6 = 1;
            int i7 = 0;
            if (i < i5) {
                iArr[0] = dimensionPixelSize;
                c = 0;
            } else if (i > i5 * 2) {
                iArr[0] = (k - width) - dimensionPixelSize;
                c = 2;
            } else {
                iArr[0] = (k - width) / 2;
                c = 1;
            }
            int i8 = j / 3;
            if (i2 < i8) {
                iArr[1] = dimensionPixelSize;
                if (c == 0) {
                    i6 = 4;
                } else if (c == 2) {
                    i6 = 6;
                }
            } else if (i2 > i8 * 2) {
                iArr[1] = (j - height) - dimensionPixelSize;
                if (c == 0) {
                    i7 = 5;
                } else if (c == 2) {
                    i7 = 7;
                }
                i6 = i7;
            } else {
                int i9 = j - height;
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
            BrowserActivity.this.f1635p.mo1120U0(i6);
            return iArr;
        }

        @Override // mark.via.p044m.p047c.FabDragListener.AbstractC0487d
        /* renamed from: c */
        public void mo1288c() {
            BrowserActivity.this.m2397i3();
        }

        @Override // mark.via.p044m.p047c.FabDragListener.AbstractC0487d
        /* renamed from: d */
        public void mo1289d(int i) {
            if (i == 0) {
                BrowserActivity.this.m2379d3(12);
            } else if (i == 1) {
                BrowserActivity.this.m2379d3(13);
            } else if (i == 2) {
                BrowserActivity.this.m2379d3(15);
            } else if (i == 3) {
                BrowserActivity.this.m2379d3(1);
            }
        }

        @Override // mark.via.p044m.p047c.FabDragListener.AbstractC0487d
        /* renamed from: e */
        public void mo1290e() {
            BrowserActivity.this.m2274A3();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$o */
    public class C0526o extends OnFrogToastListener {
        C0526o() {
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            BrowserUtils.m2078I(BrowserActivity.this.f1607b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$p */
    public class C0527p implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        int f1680a;

        /* renamed from: b */
        int f1681b;

        /* renamed from: c */
        int f1682c;

        /* renamed from: d */
        final /* synthetic */ boolean f1683d;

        /* renamed from: e */
        final /* synthetic */ boolean f1684e;

        /* renamed from: f */
        final /* synthetic */ boolean f1685f;

        C0527p(boolean z, boolean z2, boolean z3) {
            this.f1683d = z;
            this.f1684e = z2;
            this.f1685f = z3;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f1680a = intValue;
            this.f1681b = intValue;
            this.f1682c = intValue;
            BrowserActivity.this.f1586N.setBackgroundColor(this.f1680a);
            BrowserActivity.this.f1582L.setBackgroundColor(this.f1680a);
            BrowserActivity.this.f1605a.getWindow().setBackgroundDrawable(new ColorDrawable(this.f1680a));
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                if (this.f1683d && !this.f1684e) {
                    this.f1681b = ViewUtils.m2242t(-16777216, this.f1680a, 0.2f);
                }
                BrowserActivity.this.getWindow().setStatusBarColor(this.f1681b);
                if (i >= 27) {
                    if (this.f1683d && !this.f1685f) {
                        this.f1682c = ViewUtils.m2242t(-16777216, this.f1680a, 0.2f);
                    }
                    BrowserActivity.this.getWindow().setNavigationBarColor(this.f1682c);
                }
            }
        }
    }

    /* renamed from: mark.via.ui.activity.BrowserActivity$q */
    class ViewTreeObserver$OnGlobalLayoutListenerC0528q implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserver$OnGlobalLayoutListenerC0528q() {
        }

        public void onGlobalLayout() {
            if (BrowserActivity.this.f1581K0 == -1) {
                BrowserActivity browserActivity = BrowserActivity.this;
                browserActivity.f1581K0 = browserActivity.f1608b0.getRootView().getHeight() - BrowserActivity.this.f1608b0.getHeight();
            }
            if ((BrowserActivity.this.f1608b0.getRootView().getHeight() - BrowserActivity.this.f1608b0.getHeight()) - BrowserActivity.this.f1581K0 >= BrowserActivity.this.f1607b.getResources().getDimensionPixelSize(R.dimen.a) * 2) {
                BrowserActivity.this.m2362Y2();
            } else {
                BrowserActivity.this.m2344T2();
            }
        }
    }

    /* renamed from: mark.via.ui.activity.BrowserActivity$r */
    class View$OnClickListenerC0529r implements View.OnClickListener {
        View$OnClickListenerC0529r() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void mo1411b(View view, TaoDialog.C0384l lVar) {
            if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
                String f = WebAdressUtils.m2254f(lVar.f1091c[0]);
                if (f.contains("://")) {
                    BrowserActivity.this.f1635p.mo1073D1(0);
                    BrowserActivity.this.f1635p.mo1076E1(f);
                    BrowserActivity browserActivity = BrowserActivity.this;
                    browserActivity.f1629m = browserActivity.f1635p.mo1158j0();
                    if (!BrowserActivity.this.f1629m.startsWith("http://") && !BrowserActivity.this.f1629m.startsWith("https://")) {
                        BrowserActivity.this.f1629m = FlurryRemoteConfig.m1694c().mo1045b(BrowserActivity.this.f1635p.mo1181r());
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void mo1412d(View view, AdapterView adapterView, View view2, int i, long j) {
            if (i == 0) {
                TaoDialog g = TaoDialog.m1134g(BrowserActivity.this.f1607b);
                g.mo620L(R.string.c5);
                g.mo628c(0, BrowserActivity.this.f1635p.mo1158j0(), R.string.c5, 2);
                g.mo614F(17039370, new C0546e(this));
                g.mo624P(view);
                return;
            }
            BrowserActivity.this.f1635p.mo1073D1(i);
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.f1629m = BrowserUtils.m2098s(browserActivity.f1607b)[0];
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.b /* 2131230721 */:
                    BrowserActivity.this.m2334Q2(true, null);
                    return;
                case R.id.d /* 2131230723 */:
                    BrowserActivity.this.m2274A3();
                    return;
                case R.id.f /* 2131230725 */:
                    BrowserActivity.this.m2383e3();
                    return;
                case R.id.aq /* 2131230773 */:
                    if (BrowserActivity.this.f1619h.hasFocus()) {
                        TaoDialog g = TaoDialog.m1134g(BrowserActivity.this.f1607b);
                        g.mo620L(R.string.h2);
                        g.mo618J(R.array.k, BrowserActivity.this.f1635p.mo1155i0(), new C0544d(this, view));
                        g.mo624P(view);
                        return;
                    } else if (BrowserActivity.this.f1606a0 == 6) {
                        BrowserActivity.this.m2399j1();
                        return;
                    } else if (!BrowserUtils.m2105z(BrowserActivity.this.f1623j.mo817L())) {
                        BrowserActivity.this.m2461z3(6);
                        return;
                    } else {
                        return;
                    }
                case R.id.ar /* 2131230774 */:
                    int i = BrowserActivity.this.f1562B;
                    if (i == 1) {
                        BrowserActivity.this.f1623j.mo838t0();
                        return;
                    } else if (i == 2) {
                        BrowserActivity browserActivity = BrowserActivity.this;
                        browserActivity.m2414n3(browserActivity.f1619h.getText().toString().trim());
                        return;
                    } else if (i == 3) {
                        BrowserUtils.m2076G(BrowserActivity.this.f1605a);
                        return;
                    } else if (BrowserActivity.this.f1606a0 != 6 || !BrowserActivity.this.f1626k0.mo1264g()) {
                        BrowserActivity.this.f1623j.mo833o0();
                        return;
                    } else {
                        BrowserActivity.this.m2399j1();
                        return;
                    }
                case R.id.au /* 2131230777 */:
                    BrowserActivity.this.m2385f1();
                    return;
                case R.id.av /* 2131230778 */:
                    if (BrowserActivity.this.f1606a0 != -1) {
                        BrowserActivity.this.m2399j1();
                        return;
                    } else {
                        BrowserActivity.this.m2388g1();
                        return;
                    }
                case R.id.aw /* 2131230779 */:
                    if (!BrowserActivity.this.m2406l1()) {
                        if (BrowserActivity.this.f1623j != null) {
                            BrowserActivity.this.m2392h1();
                            BrowserActivity.this.m2306I3();
                            return;
                        }
                        BrowserActivity.this.m2334Q2(true, null);
                        return;
                    }
                    return;
                case R.id.ax /* 2131230780 */:
                    if (BrowserActivity.this.f1606a0 != -1) {
                        BrowserActivity.this.m2399j1();
                        return;
                    } else {
                        BrowserActivity.this.m2461z3(3);
                        return;
                    }
                case R.id.az /* 2131230782 */:
                    if (BrowserActivity.this.f1638q0 == 0) {
                        BrowserActivity.this.finish();
                        return;
                    } else if (BrowserActivity.this.f1606a0 == -1) {
                        BrowserActivity.this.m2461z3(0);
                        return;
                    } else {
                        BrowserActivity.this.m2399j1();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$s */
    public class RunnableC0530s implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f1689a;

        RunnableC0530s(boolean z) {
            this.f1689a = z;
        }

        public void run() {
            if (this.f1689a) {
                ViewUtils.m2219F(BrowserActivity.this.f1578J, AnimationHelper.m1120b(5));
            } else {
                ViewUtils.m2234l(BrowserActivity.this.f1578J, AnimationHelper.m1121c(5));
            }
            BrowserActivity.this.f1595R0 = this.f1689a;
        }
    }

    /* renamed from: mark.via.ui.activity.BrowserActivity$t */
    class View$OnLongClickListenerC0531t implements View.OnLongClickListener {
        View$OnLongClickListenerC0531t() {
        }

        public boolean onLongClick(View view) {
            int id = view.getId();
            if (id == R.id.f) {
                FlurryHelper.m1681a().mo1036d("res", false);
                BrowserActivity.this.m2399j1();
                BrowserActivity.this.m2400j3();
                return true;
            } else if (id != R.id.az) {
                switch (id) {
                    case R.id.au /* 2131230777 */:
                        BrowserActivity browserActivity = BrowserActivity.this;
                        browserActivity.m2379d3(browserActivity.f1635p.mo1103O());
                        return true;
                    case R.id.av /* 2131230778 */:
                        BrowserActivity browserActivity2 = BrowserActivity.this;
                        browserActivity2.m2379d3(browserActivity2.f1635p.mo1106P());
                        return true;
                    case R.id.aw /* 2131230779 */:
                        BrowserActivity browserActivity3 = BrowserActivity.this;
                        browserActivity3.m2379d3(browserActivity3.f1635p.mo1109Q());
                        return true;
                    case R.id.ax /* 2131230780 */:
                        if (BrowserActivity.this.f1638q0 != -1) {
                            return true;
                        }
                        BrowserActivity browserActivity4 = BrowserActivity.this;
                        browserActivity4.m2379d3(browserActivity4.f1635p.mo1112R());
                        return true;
                    default:
                        return true;
                }
            } else if (BrowserActivity.this.f1638q0 != -1) {
                return true;
            } else {
                BrowserActivity browserActivity5 = BrowserActivity.this;
                browserActivity5.m2379d3(browserActivity5.f1635p.mo1115S());
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$u */
    public class C0532u implements ClickHandler.AbstractC0441a {
        C0532u() {
        }

        @Override // mark.via.handler.ClickHandler.AbstractC0441a
        /* renamed from: a */
        public void mo965a(String str, String str2, String str3) {
            BrowserActivity.this.m2330P2(str, str2, str3);
        }
    }

    /* renamed from: mark.via.ui.activity.BrowserActivity$v */
    class C0533v extends OnFrogToastListener {

        /* renamed from: a */
        final /* synthetic */ Message f1693a;

        C0533v(Message message) {
            this.f1693a = message;
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            BrowserActivity.this.m2376c3(this.f1693a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$w */
    public class C0534w extends OnFrogToastListener {
        C0534w() {
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            BrowserActivity.this.m2461z3(5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$x  reason: invalid class name */
    public class animationAnimation$AnimationListenerC0535x implements Animation.AnimationListener {
        animationAnimation$AnimationListenerC0535x() {
        }

        public void onAnimationEnd(Animation animation) {
            if (Build.VERSION.SDK_INT >= 11) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(BrowserActivity.this.f1615f, "translationY", 0.0f, (float) BrowserActivity.this.f1570F);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(BrowserActivity.this.f1621i, "translationY", (float) (-BrowserActivity.this.f1570F), 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration((long) ((BrowserActivity.this.f1607b.getResources().getInteger(R.integer.a) * 3) / 2));
                animatorSet.start();
                return;
            }
            BrowserActivity.this.f1615f.setPadding(0, BrowserActivity.this.f1570F, 0, 0);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$y */
    public class C0536y implements Callback {
        C0536y() {
        }

        @Override // mark.via.helpers.Callback
        /* renamed from: a */
        public void mo1052a() {
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.m2393h3(browserActivity.f1625k);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.activity.BrowserActivity$z */
    public class C0537z implements Callback {
        C0537z() {
        }

        @Override // mark.via.helpers.Callback
        /* renamed from: a */
        public void mo1052a() {
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.m2393h3(browserActivity.f1625k);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: A3 */
    private void m2274A3() {
        if (this.f1586N.getVisibility() != 0 && this.f1601W != 0 && !this.f1583L0) {
            ViewUtils.m2220G(this.f1586N, AnimationHelper.m1120b(3), this.f1600V == 3 ? null : new animationAnimation$AnimationListenerC0535x());
            ViewUtils.m2219F(this.f1582L, AnimationHelper.m1120b(5));
            ViewUtils.m2234l(this.f1576I, AnimationHelper.m1121c(5));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B2 */
    public /* synthetic */ void mo1343C2(List list, AdapterView adapterView, View view, int i, long j) {
        IntentUtils.m2176c(this.f1605a, (String) list.get(i), this.f1623j.mo816K());
    }

    /* renamed from: B3 */
    private void m2279B3() {
        if (this.f1611d == null) {
            View view = new View(this.f1607b);
            this.f1611d = view;
            view.setVisibility(8);
            this.f1611d.setBackgroundColor(CompatUtils.m1331a(this.f1607b, R.color.a4));
            this.f1611d.setClickable(true);
            this.f1611d.setFocusable(true);
            this.f1611d.setOnClickListener(new View$OnClickListenerC0541b0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(2, R.id.at);
            layoutParams.addRule(3, R.id.bk);
            layoutParams.alignWithParent = true;
            this.f1608b0.addView(this.f1611d, 2, layoutParams);
        }
        ViewUtils.m2219F(this.f1611d, AnimationHelper.m1120b(1));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: C3 */
    private void m2282C3(int i) {
        m2287D3(i, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: D1 */
    public /* synthetic */ void mo1344E1(String str, TaoDialog.C0384l lVar) {
        String str2;
        if (Build.VERSION.SDK_INT < 29) {
            str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + this.f1635p.mo1193v() + File.separatorChar;
        } else {
            str2 = null;
        }
        QuickUtils.m1382n(this.f1605a, FileCompat.m1352f(this.f1607b, str, str2, lVar.f1091c[0]) ? R.string.d0 : R.string.d1);
    }

    /* access modifiers changed from: private */
    /* renamed from: D2 */
    public /* synthetic */ void mo1345E2(int i, String str) {
        if (i < this.f1609c.size()) {
            this.f1609c.get(i).mo828h0(str);
        }
    }

    /* renamed from: D3 */
    private void m2287D3(int i, boolean z) {
        if (i >= 0 && i < this.f1609c.size() && i != this.f1625k) {
            this.f1596S.set(false);
            TabItem b0Var = this.f1609c.get(i);
            TabItem b0Var2 = this.f1623j;
            if (b0Var2 != null) {
                this.f1615f.removeView(b0Var2.mo811F());
                this.f1623j.mo809B();
            }
            this.f1615f.addView(b0Var.mo811F());
            this.f1623j = b0Var;
            this.f1625k = i;
            b0Var.mo837s();
            this.f1623j.mo834p0();
            mo853j(b0Var.mo815J());
            mo864u(b0Var.mo808A());
            if (z) {
                this.f1623j.mo839u();
                mo854k();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: E3 */
    private void m2290E3() {
        int i;
        boolean z = false;
        if (this.f1561A0.isEmpty()) {
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.s, R.drawable.q));
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.ab, R.drawable.ap));
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.ac, R.drawable.ak));
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.ah, R.drawable.aw));
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.af, R.drawable.a8));
            this.f1561A0.add(FrogMenuBean.m1244m(this.f1607b, R.string.t, R.drawable.ac, this.f1635p.mo1068C()));
            FrogMenuBean l = FrogMenuBean.m1243l(this.f1607b, R.string.v, R.drawable.am);
            Context context = this.f1607b;
            if (this.f1635p.mo1092K()) {
                i = R.string.ee;
            } else {
                i = this.f1635p.mo1157j() ? R.string.eg : R.string.ef;
            }
            l.mo725k(CompatUtils.m1336f(context, i));
            this.f1561A0.add(l);
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.gu, R.drawable.ao));
            this.f1561A0.add(FrogMenuBean.m1244m(this.f1607b, R.string.ai, R.drawable.ax, this.f1635p.mo1185s0() != 1));
            this.f1561A0.add(FrogMenuBean.m1243l(this.f1607b, R.string.x, R.drawable.ag));
        }
        Context context2 = this.f1607b;
        TabItem b0Var = this.f1623j;
        boolean z2 = !BrowserUtils.m2101v(context2, b0Var != null ? b0Var.mo817L() : null);
        boolean z3 = WebViewUtil.m2047g(this.f1623j.mo817L()) || (Build.VERSION.SDK_INT >= 21 && URLUtil.isFileUrl(this.f1623j.mo817L()));
        for (FrogMenuBean bVar : this.f1561A0) {
            int b = bVar.mo716b();
            if (b == R.string.af) {
                bVar.mo723i(z3);
            } else if (b == R.string.ah || b == R.string.ab) {
                bVar.mo723i(z2);
            }
        }
        this.f1654y0.mo708g(this.f1561A0);
        View view = this.f1652x0;
        if (this.f1600V != 2) {
            z = true;
        }
        ViewUtils.m2236n(view, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: F1 */
    public /* synthetic */ void mo1346G1(boolean z, String str, String str2, String[] strArr, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
            if (z) {
                BrowserApp.m1389c().execute(new RunnableC0548f(this, str, lVar));
                return;
            }
            long c = this.f1616f0.mo383c(str, lVar.f1091c[0], str2, strArr[1]);
            if (c == -1) {
                QuickUtils.m1382n(this.f1607b, R.string.d1);
                return;
            }
            this.f1628l0.mo1256i(c);
            QuickUtils.m1383o(this.f1607b, R.string.d5, R.string.jm, new C0534w());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F2 */
    public /* synthetic */ void mo1347G2(int i, String str, int i2) {
        this.f1605a.runOnUiThread(new RunnableC0547e0(this, i2, m2374c1(i, str)));
    }

    /* renamed from: F3 */
    private void m2295F3(boolean z) {
        int i;
        this.f1630m0 = z;
        DataChecker.m1181c().mo668i(1, 2, 3, 4, 5);
        boolean Y = this.f1635p.mo1127Y();
        this.f1605a.setTheme(z ? R.style.a : R.style.b);
        this.f1563B0 = null;
        FrameLayout frameLayout = this.f1582L;
        int i2 = R.color.f;
        frameLayout.setBackgroundResource(z ? R.color.g : R.color.f);
        Window window = this.f1605a.getWindow();
        Context context = this.f1607b;
        if (z) {
            i2 = R.color.g;
        }
        window.setBackgroundDrawable(CompatUtils.m1334d(context, i2));
        View view = this.f1652x0;
        int i3 = R.color.h;
        if (view != null) {
            view.setBackgroundResource(z ? R.color.h : R.color.k);
            this.f1656z0.get(0).mo721g(z);
            this.f1654y0.mo710i(0, this.f1656z0.get(0));
        }
        this.f1628l0.mo1255f();
        this.f1626k0.mo1255f();
        View view2 = this.f1590P;
        if (view2 != null) {
            View findViewById = view2.findViewById(R.id.r);
            if (!z || Y) {
                i3 = R.color.k;
            }
            findViewById.setBackgroundResource(i3);
        }
        this.f1615f.setForeground(CompatUtils.m1334d(this.f1607b, z ? R.color.aa : R.color.a_));
        if (z) {
            i = CompatUtils.m1331a(this.f1607b, R.color.g);
        } else {
            i = this.f1635p.mo1179q0();
        }
        m2346U0(i);
        m2390g3();
        m2315K3();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: G3 */
    private void m2298G3() {
        boolean Z = this.f1635p.mo1129Z(this.f1607b);
        if (Z != this.f1630m0) {
            if (Build.VERSION.SDK_INT < 11) {
                m2295F3(Z);
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            alphaAnimation.setDuration(800);
            m2295F3(Z);
            this.f1608b0.startAnimation(alphaAnimation);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H1 */
    public /* synthetic */ void mo1348I1(String str, View view) {
        QuickUtils.m1370b(this.f1607b, str, R.string.ir);
    }

    /* access modifiers changed from: private */
    /* renamed from: H2 */
    public /* synthetic */ void mo1349I2(AdapterView adapterView, View view, int i, long j) {
        this.f1635p.mo1094K1(i + 1);
        if (i == 0) {
            FlurryHelper.m1681a().mo1036d("ua", false);
        }
        Iterator<FrogMenuBean> it = this.f1561A0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FrogMenuBean next = it.next();
            if (next.mo716b() == R.string.ai) {
                next.mo721g(this.f1635p.mo1185s0() != 1);
            }
        }
        m2315K3();
        TabItem b0Var = this.f1623j;
        if (b0Var != null && !BrowserUtils.m2101v(this.f1607b, b0Var.mo817L())) {
            String n = BrowserUtils.m2093n(this.f1623j.mo817L(), false);
            if (!TextUtils.isEmpty(n) && !"pan.baidu.com".equalsIgnoreCase(n) && !"yun.baidu.com".equalsIgnoreCase(n) && !"eyun.baidu.com".equalsIgnoreCase(n)) {
                this.f1623j.mo833o0();
            }
        }
        Context context = this.f1607b;
        QuickUtils.m1384p(context, CompatUtils.m1337g(context, R.string.h9, context.getResources().getStringArray(R.array.o)[i]));
        m2399j1();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: H3 */
    private void m2303H3() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        boolean C = this.f1635p.mo1068C();
        int i3 = 0;
        int i4 = (C || this.f1635p.mo1205z() > 0) ? 1 : 0;
        if (C) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().clearFlags(1024);
        }
        if (this.f1601W != i4) {
            int h = ViewUtils.m2230h(this.f1605a);
            int dimensionPixelSize = this.f1607b.getResources().getDimensionPixelSize(R.dimen.x);
            int i5 = Constants.f1301f;
            this.f1570F = dimensionPixelSize + ((i5 < 19 || i5 >= 21 || C) ? 0 : h);
            float f = 0.0f;
            if (i4 != 0) {
                boolean z = this.f1635p.mo1176p0() == 3;
                this.f1615f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                if (this.f1586N.getVisibility() == 0) {
                    if (i2 >= 11) {
                        FrameLayout frameLayout = this.f1615f;
                        if (!z) {
                            f = (float) this.f1570F;
                        }
                        frameLayout.setTranslationY(f);
                    } else {
                        this.f1615f.setPadding(0, z ? 0 : this.f1570F, 0, 0);
                    }
                }
            } else {
                ViewUtils.m2219F(this.f1586N, null);
                ViewUtils.m2219F(this.f1582L, null);
                if (i2 >= 11) {
                    this.f1615f.setTranslationY(0.0f);
                } else {
                    this.f1615f.setPadding(0, 0, 0, 0);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, this.f1586N.getId());
                layoutParams.addRule(2, this.f1582L.getId());
                this.f1615f.setLayoutParams(layoutParams);
            }
            if (i5 >= 19 && i5 < 21) {
                if (!C) {
                    this.f1605a.getWindow().addFlags(67108864);
                }
                ViewGroup.LayoutParams layoutParams2 = this.f1586N.getLayoutParams();
                if (C) {
                    i = this.f1570F;
                } else {
                    i = this.f1635p.mo1176p0() == 3 ? h : this.f1570F;
                }
                layoutParams2.height = i;
                this.f1586N.setLayoutParams(layoutParams2);
                FrameLayout frameLayout2 = this.f1586N;
                if (C) {
                    h = 0;
                }
                frameLayout2.setPadding(0, h, 0, 0);
                ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.f1605a.findViewById(16908290)).getChildAt(0);
                viewGroup.setFitsSystemWindows(C);
                viewGroup.setClipToPadding(true);
                if (this.f1572G == null) {
                    this.f1572G = new View(this.f1605a);
                    this.f1572G.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.m2230h(this.f1607b)));
                    this.f1572G.setBackgroundColor(CompatUtils.m1331a(this.f1607b, R.color.a));
                    viewGroup.addView(this.f1572G);
                }
                View view = this.f1572G;
                if (C) {
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
            this.f1601W = i4;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: I3 */
    private void m2306I3() {
        File file;
        long j = this.f1591P0;
        long currentTimeMillis = System.currentTimeMillis();
        this.f1591P0 = currentTimeMillis;
        if (currentTimeMillis - j < 300) {
            int i = this.f1593Q0 + 1;
            this.f1593Q0 = i;
            if (i >= 8) {
                this.f1593Q0 = 0;
                FileLoggingHelper d = FileLoggingHelper.m1727d();
                if (d.mo1054f()) {
                    d.mo1057i();
                    TaoDialog g = TaoDialog.m1134g(this.f1607b);
                    g.mo621M("Logcat");
                    g.mo645w(d.mo1053e());
                    g.mo635m(false);
                    g.mo614F(R.string.l, new C0550g(this, d));
                    g.mo648z(17039360, null);
                    g.mo622N();
                    return;
                }
                if (this.f1607b.getExternalCacheDir() != null) {
                    file = this.f1607b.getExternalCacheDir();
                } else {
                    file = this.f1607b.getCacheDir();
                }
                d.mo1055g(file.getAbsolutePath(), "log.txt");
                d.mo1056h();
                QuickUtils.m1384p(this.f1607b, "Start logging");
            }
        }
    }

    /* renamed from: J1 */
    static /* synthetic */ void m2309J1(EditText editText, View view, boolean z) {
        if (z) {
            String obj = editText.getText().toString();
            int lastIndexOf = obj.lastIndexOf(".");
            if (lastIndexOf == -1 || obj.length() - lastIndexOf >= 7) {
                editText.selectAll();
            } else {
                editText.setSelection(0, lastIndexOf);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J2 */
    public /* synthetic */ void mo1350K2() {
        this.f1567D0.setSelection(this.f1625k);
    }

    /* renamed from: J3 */
    private void m2311J3() {
        ListView listView = this.f1567D0;
        if (listView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
            int min = Math.min(this.f1565C0.getCount() * CompatUtils.m1333c(this.f1607b, R.dimen.w), ((this.f1608b0.getHeight() - this.f1586N.getHeight()) - this.f1582L.getHeight()) - CompatUtils.m1333c(this.f1607b, R.dimen.a));
            if (layoutParams.height != min) {
                layoutParams.height = min;
                this.f1567D0.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K1 */
    public /* synthetic */ void mo1351L1(String str, HistoryItem bVar, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 2)) {
            this.f1633o.mo982i(str);
            bVar.mo947l(lVar.f1091c[0]);
            bVar.mo948m(WebAdressUtils.m2255g(lVar.f1091c[1], this.f1629m));
            this.f1633o.mo972H(bVar, false);
            DataChecker.m1181c().mo667h(1);
            m2393h3(this.f1625k);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: K3 */
    private void m2315K3() {
        FastView N;
        TabItem b0Var = this.f1623j;
        if (b0Var != null) {
            b0Var.mo840u0(this.f1607b);
            for (TabItem b0Var2 : this.f1609c) {
                if (!(b0Var2 == null || (N = b0Var2.mo818N()) == null)) {
                    b0Var2.mo810D(N);
                }
            }
            DataChecker.m1181c().mo664e(158);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: L2 */
    public /* synthetic */ void mo1352M2(View view) {
        m2406l1();
    }

    /* access modifiers changed from: private */
    /* renamed from: M1 */
    public /* synthetic */ void mo1353N1(View view) {
        m2379d3(16);
    }

    /* access modifiers changed from: private */
    /* renamed from: N2 */
    public /* synthetic */ void mo1354O2(FileLoggingHelper nVar, View view, TaoDialog.C0384l lVar) {
        QuickUtils.m1370b(this.f1607b, nVar.mo1053e(), R.string.iq);
    }

    /* renamed from: O0 */
    private void m2326O0(AddonItem aVar) {
        if (aVar != null) {
            BrowserApp.m1388b().execute(new RunnableC0573s(this, aVar));
            Context context = this.f1607b;
            QuickUtils.m1384p(context, context.getResources().getString(R.string.ev));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O1 */
    public /* synthetic */ void mo1355P1(View view) {
        m2379d3(17);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: P0 */
    private void m2329P0() {
        TabItem b0Var = this.f1623j;
        if (b0Var != null) {
            BookmarkHelper.m1707a(this.f1607b, b0Var.mo817L(), this.f1623j.mo816K(), this.f1629m, new C0510a());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r4 != 11) goto L_0x025c;
     */
    /* renamed from: P2 */
    private void m2330P2(String str, String str2, String str3) {
        boolean z = true;
        this.f1574H = !TextUtils.isEmpty(str);
        int k = BrowserUtils.m2090k(this.f1607b, this.f1623j.mo817L());
        if (k != 0 || str2 == null) {
            TabItem b0Var = this.f1623j;
            if (b0Var != null && b0Var.mo818N() != null) {
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    ArrayList arrayList = new ArrayList();
                    if (WebViewUtil.m2047g(str)) {
                        arrayList.add(new TaoDialog.C0381i(0, getString(R.string.a3)));
                        arrayList.add(new TaoDialog.C0381i(1, getString(R.string.a4)));
                    }
                    if (k == -1) {
                        if (!TextUtils.isEmpty(str2)) {
                            arrayList.add(new TaoDialog.C0381i(2, getString(R.string.al)));
                            arrayList.add(new TaoDialog.C0381i(6, getString(R.string.aa)));
                            arrayList.add(new TaoDialog.C0381i(7, getString(R.string.h3)));
                            if (this.f1635p.mo1100N()) {
                                arrayList.add(new TaoDialog.C0381i(8, getString(R.string.a7)));
                            }
                        }
                        arrayList.add(new TaoDialog.C0381i(22, getString(R.string.a5)));
                        if (this.f1635p.mo1100N()) {
                            arrayList.add(new TaoDialog.C0381i(23, getString(R.string.y)));
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            arrayList.add(new TaoDialog.C0381i(29, getString(R.string.k)));
                        }
                    } else if (k != 1) {
                        int i = 11;
                        if (k != 2) {
                            if (k != 3) {
                                if (k != 6) {
                                    if (k == 7) {
                                        arrayList.add(new TaoDialog.C0381i(18, getString(R.string.m)));
                                    } else if (k != 10) {
                                    }
                                }
                                if (k == 6) {
                                    String n = BrowserUtils.m2093n(str, false);
                                    if (this.f1632n0 != null && ConfUtil.m2116c(n)) {
                                        boolean b = this.f1632n0.mo6b(FilterUtils.m119x(str, true));
                                        boolean b2 = this.f1632n0.mo6b(FilterUtils.m119x(str, false));
                                        if (b || b2 || !this.f1632n0.mo16p(str, null)) {
                                            arrayList.add(new TaoDialog.C0381i(b ? 25 : 24, getString(b ? R.string.aj : R.string.e)));
                                            arrayList.add(new TaoDialog.C0381i(b2 ? 27 : 26, getString(b2 ? R.string.ak : R.string.f)));
                                        }
                                    }
                                }
                                if (k == 10) {
                                    arrayList.add(new TaoDialog.C0381i(19, getString(R.string.a8)));
                                }
                                arrayList.add(new TaoDialog.C0381i(20, getString(R.string.q)));
                                arrayList.add(new TaoDialog.C0381i(21, getString(R.string.n)));
                            } else {
                                arrayList.add(new TaoDialog.C0381i(16, getString(R.string.m)));
                                arrayList.add(new TaoDialog.C0381i(17, getString(R.string.n)));
                            }
                        }
                        boolean z2 = str != null && str.startsWith("folder://");
                        if (!z2 || !str.equals("folder://")) {
                            z = false;
                        }
                        if (!z) {
                            arrayList.add(new TaoDialog.C0381i(z2 ? 12 : 9, getString(R.string.r)));
                            if (!z2) {
                                arrayList.add(new TaoDialog.C0381i(10, getString(R.string.b)));
                            }
                            if (z2) {
                                i = 13;
                            }
                            arrayList.add(new TaoDialog.C0381i(i, getString(R.string.m)));
                        }
                    } else if (str != null && !str.equals("folder://")) {
                        arrayList.add(new TaoDialog.C0381i(14, getString(R.string.r)));
                        arrayList.add(new TaoDialog.C0381i(15, getString(R.string.m)));
                    }
                    if (!TextUtils.isEmpty(str) && !str.startsWith("folder://") && !str.startsWith("javascript:") && !str.startsWith("file://")) {
                        arrayList.add(new TaoDialog.C0381i(3, getString(R.string.i)));
                        arrayList.add(new TaoDialog.C0381i(31, getString(R.string.ae)));
                    }
                    if (!arrayList.isEmpty()) {
                        TaoDialog g = TaoDialog.m1134g(this.f1607b);
                        g.mo642t(arrayList, new C0551g0(this, str, str2, k, str3));
                        g.mo623O(this.f1651x, this.f1653y);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        m2277B1(str2, null, "attachment", "image/*", -1);
    }

    /* renamed from: Q0 */
    private void m2332Q0(String str) {
        DatabaseHandler bVar = this.f1633o;
        bVar.mo972H(bVar.mo992q(str), true);
        DataChecker.m1181c().mo667h(1);
        Context context = this.f1607b;
        QuickUtils.m1384p(context, CompatUtils.m1336f(context, R.string.ar));
    }

    /* access modifiers changed from: private */
    /* renamed from: Q1 */
    public /* synthetic */ boolean mo1356R1(AdapterView adapterView, View view, int i, long j) {
        String L = ((TabItem) this.f1565C0.getItem(i)).mo817L();
        if (BrowserUtils.m2105z(L)) {
            return true;
        }
        SupportUtils.m2195a(this.f1607b, L, R.string.ir);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: Q2 */
    private TabItem m2334Q2(boolean z, String str) {
        return m2337R2(z, str, true);
    }

    /* renamed from: R0 */
    private void m2336R0() {
        if (!this.f1579J0) {
            this.f1608b0.getViewTreeObserver().addOnGlobalLayoutListener(this.f1577I0);
            this.f1579J0 = true;
        }
    }

    /* renamed from: R2 */
    private TabItem m2337R2(boolean z, String str, boolean z2) {
        this.f1596S.set(false);
        TabItem b0Var = new TabItem(this.f1605a, str, this);
        b0Var.mo836r0(this.f1627l);
        int size = z2 ? this.f1609c.size() : this.f1625k + 1;
        this.f1609c.add(size, b0Var);
        this.f1627l++;
        m2406l1();
        m2386f3();
        int size2 = this.f1609c.size();
        this.f1613e.setText(size2 <= 99 ? String.valueOf(size2) : ":)");
        if (size2 > 1) {
            ViewUtils.m2241s(this.f1580K.findViewById(R.id.ah));
        }
        if (z) {
            m2287D3(size, false);
        } else {
            b0Var.mo809B();
        }
        return b0Var;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: S0 */
    private boolean m2339S0() {
        TabItem b0Var = this.f1623j;
        if (b0Var == null) {
            return false;
        }
        if (b0Var.mo841v() || (!BrowserUtils.m2102w(this.f1607b, this.f1623j.mo817L(), 1) && !BrowserUtils.m2102w(this.f1607b, this.f1623j.mo817L(), 8))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: S1 */
    public /* synthetic */ void mo1357T1(String str) {
        this.f1623j.mo828h0(str);
    }

    /* renamed from: S2 */
    private TabItem m2341S2(boolean z, String str) {
        return m2337R2(z, str, false);
    }

    /* renamed from: T0 */
    private void m2343T0(int i) {
        if (!(this.f1638q0 == i || this.f1603Y || this.f1605a.getResources().getConfiguration().orientation == 2)) {
            if (i == 0 || (i == 1 && this.f1638q0 != 0)) {
                View[] viewArr = {this.f1580K.findViewById(R.id.au), this.f1580K.findViewById(R.id.av), this.f1580K.findViewById(R.id.aw), this.f1580K.findViewById(R.id.ay)};
                for (int i2 = 0; i2 < 4; i2++) {
                    ViewUtils.m2235m(viewArr[i2], AnimationHelper.m1121c(5));
                }
                if (this.f1600V != 1) {
                    View[] viewArr2 = {this.f1584M.findViewById(R.id.o), this.f1584M.findViewById(R.id.aq), this.f1584M.findViewById(R.id.ar)};
                    for (int i3 = 0; i3 < 3; i3++) {
                        ViewUtils.m2235m(viewArr2[i3], AnimationHelper.m1121c(5));
                    }
                }
                ImageView imageView = (ImageView) this.f1580K.findViewById(R.id.ax);
                imageView.setImageResource(R.drawable.s);
                imageView.startAnimation(AnimationHelper.m1120b(5));
            }
            ImageView imageView2 = (ImageView) this.f1580K.findViewById(R.id.az);
            if (i == 0) {
                imageView2.setImageResource(R.drawable.a_);
                imageView2.startAnimation(AnimationHelper.m1120b(5));
            } else if (i == 1) {
                ViewUtils.m2235m(imageView2, AnimationHelper.m1121c(5));
            }
            this.f1638q0 = i;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: T2 */
    private void m2344T2() {
        if (this.f1583L0) {
            if (this.f1585M0) {
                ViewUtils.m2219F(this.f1582L, null);
            }
            if (this.f1587N0) {
                ViewUtils.m2219F(this.f1576I, null);
            }
            this.f1583L0 = false;
        }
    }

    /* renamed from: U0 */
    private void m2346U0(int i) {
        int i2;
        View view;
        boolean q = ViewUtils.m2239q(i);
        Context context = this.f1607b;
        int i3 = 17170443;
        if (this.f1635p.mo1129Z(context)) {
            i2 = R.color.y;
        } else {
            i2 = ViewUtils.m2239q(i) ? R.color.x : 17170443;
        }
        int a = CompatUtils.m1331a(context, i2);
        Context context2 = this.f1607b;
        if (this.f1635p.mo1129Z(context2)) {
            i3 = R.color.s;
        } else if (ViewUtils.m2239q(i)) {
            i3 = R.color.r;
        }
        int a2 = CompatUtils.m1331a(context2, i3);
        ViewUtils.m2245w(a2, (ImageView) this.f1584M.findViewById(R.id.aq), (ImageView) this.f1584M.findViewById(R.id.ar), (ImageView) this.f1580K.findViewById(R.id.au), (ImageView) this.f1580K.findViewById(R.id.av), (ImageView) this.f1580K.findViewById(R.id.aw), (ImageView) this.f1580K.findViewById(R.id.az), (ImageView) this.f1580K.findViewById(R.id.ax));
        this.f1613e.setTextColor(a2);
        this.f1619h.setTextColor(a);
        this.f1619h.setHintTextColor(a);
        boolean B = ViewUtils.m2215B(this.f1605a, q);
        boolean z = ViewUtils.m2248z(this.f1605a, q);
        int i4 = Constants.f1301f;
        if (i4 >= 19 && i4 < 21 && !this.f1635p.mo1068C() && (view = this.f1572G) != null) {
            view.setVisibility((!q || B) ? 8 : 0);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f1566D), Integer.valueOf(i));
            ofObject.addUpdateListener(new C0527p(q, B, z));
            ofObject.setDuration((long) this.f1607b.getResources().getInteger(R.integer.a));
            ofObject.start();
            this.f1566D = i;
            return;
        }
        this.f1566D = i;
        this.f1586N.setBackgroundColor(i);
        this.f1582L.setBackgroundColor(this.f1566D);
    }

    /* access modifiers changed from: private */
    /* renamed from: U1 */
    public /* synthetic */ void mo1358V1(int i) {
        this.f1605a.runOnUiThread(new RunnableC0565n0(this, m2371b1(i)));
    }

    /* renamed from: U2 */
    private void m2348U2() {
        if (!m2406l1()) {
            if (this.f1643t == null && this.f1641s == null) {
                Context context = this.f1607b;
                TabItem b0Var = this.f1623j;
                if (!BrowserUtils.m2102w(context, b0Var != null ? b0Var.mo817L() : "", 8)) {
                    m2385f1();
                } else if (this.f1609c.size() > 1) {
                    int i = this.f1625k;
                    if (i >= 0) {
                        m2350V0(i);
                    }
                } else if (System.currentTimeMillis() - this.f1649w > 1500) {
                    QuickUtils.m1384p(this.f1607b, getResources().getString(R.string.f_));
                    this.f1649w = System.currentTimeMillis();
                } else {
                    finish();
                }
            } else {
                mo857n();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: V0 */
    private synchronized void m2350V0(int i) {
        TabItem b0Var;
        if (i < this.f1609c.size()) {
            if (i >= 0) {
                boolean z = this.f1596S.compareAndSet(true, false) && i == this.f1625k && (b0Var = this.f1623j) != null && !BrowserUtils.m2101v(this.f1607b, b0Var.mo817L());
                int i2 = this.f1625k;
                if (i == i2) {
                    if (i > 0) {
                        m2282C3(i - 1);
                    } else if (this.f1609c.size() > 1) {
                        m2282C3(1);
                        this.f1625k = 0;
                    } else if (!z) {
                        m2334Q2(true, null);
                        this.f1625k = 0;
                    } else {
                        this.f1625k = -1;
                        this.f1623j = null;
                    }
                } else if (i < i2) {
                    this.f1625k = i2 - 1;
                }
                TabItem b0Var2 = this.f1609c.get(i);
                this.f1609c.remove(i);
                if (b0Var2 != null) {
                    b0Var2.mo829k0();
                }
                m2386f3();
                this.f1613e.setText(this.f1609c.size() <= 99 ? String.valueOf(this.f1609c.size()) : ":)");
                if (z) {
                    if (this.f1609c.size() > 0) {
                        moveTaskToBack(true);
                    } else {
                        finish();
                    }
                }
            }
        }
    }

    /* renamed from: V2 */
    private boolean m2351V2() {
        if (!this.f1635p.mo1197w0()) {
            return false;
        }
        BrowserUtils.m2077H(this.f1623j.mo818N(), 3);
        return true;
    }

    /* renamed from: W0 */
    private void m2353W0(String str) {
        HistoryItem t = this.f1633o.mo995t(str);
        String g = t.mo941g();
        TaoDialog g2 = TaoDialog.m1134g(this.f1607b);
        g2.mo620L(R.string.ii);
        g2.mo628c(0, t.mo940f(), R.string.e7, 1);
        g2.mo628c(1, t.mo941g(), R.string.e8, 1);
        g2.mo635m(false);
        g2.mo614F(17039370, new C0580z(this, g, t));
        g2.mo648z(17039360, null);
        g2.mo622N();
    }

    /* access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void mo1359X1(String str) {
        m2334Q2(true, "file://" + str);
    }

    /* renamed from: W2 */
    private boolean m2355W2() {
        if (!this.f1635p.mo1197w0()) {
            return false;
        }
        BrowserUtils.m2077H(this.f1623j.mo818N(), 2);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: X0 */
    private void m2357X0(String str) {
        TabItem b0Var = this.f1623j;
        if (b0Var != null && b0Var.mo818N() != null) {
            if (str == null) {
                str = "";
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.f1623j.mo818N().findAllAsync(str);
            } else {
                this.f1623j.mo818N().findAll(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: X2 */
    private void m2358X2() {
        if (this.f1639r == null) {
            ClickHandler aVar = new ClickHandler();
            aVar.mo963a(new C0532u());
            this.f1639r = aVar;
        }
        Message obtainMessage = this.f1639r.obtainMessage();
        if (obtainMessage != null) {
            obtainMessage.setTarget(this.f1639r);
        }
        if (this.f1623j.mo818N() != null) {
            this.f1623j.mo818N().requestFocusNodeHref(obtainMessage);
        }
    }

    /* renamed from: Y0 */
    private View m2360Y0() {
        if (this.f1652x0 == null) {
            List<FrogMenuBean> list = this.f1656z0;
            Context context = this.f1607b;
            list.add(FrogMenuBean.m1244m(context, R.string.a2, R.drawable.ai, this.f1635p.mo1129Z(context)));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.g, R.drawable.a7));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.u, R.drawable.ad));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.q, R.drawable.a9));
            this.f1656z0.add(FrogMenuBean.m1244m(this.f1607b, R.string.w, R.drawable.aj, this.f1635p.mo1095L()));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.ae, R.drawable.at));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.a, R.drawable.a5));
            this.f1656z0.add(FrogMenuBean.m1244m(this.f1607b, R.string.a6, R.drawable.al, this.f1635p.mo1138c0()));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.ag, R.drawable.av));
            this.f1656z0.add(FrogMenuBean.m1243l(this.f1607b, R.string.ha, R.drawable.as));
            FrogMenu f = FrogMenu.m1234f(this.f1607b);
            f.mo708g(this.f1656z0);
            f.mo709h(this.f1650w0);
            this.f1654y0 = f;
            View k = f.mo711k();
            this.f1652x0 = k;
            k.setBackgroundColor(CompatUtils.m1332b(this.f1607b, R.attr.c));
            CompatUtils.m1343m(this.f1652x0, 0, FrogUtils.m1354a(this.f1607b, 15.0f));
            m2421p3(this.f1652x0);
        } else {
            this.f1654y0.mo708g(this.f1656z0);
        }
        return this.f1652x0;
    }

    /* access modifiers changed from: private */
    /* renamed from: Y1 */
    public /* synthetic */ void mo1360Z1(String str) {
        String replace = str.substring(str.lastIndexOf(47) + 1).replace("%", "");
        if (replace.isEmpty()) {
            replace = UUID.randomUUID() + ".html";
        }
        String b = FileIntentUtils.m2141b(this.f1607b, Uri.parse(str), replace);
        if (b != null) {
            runOnUiThread(new RunnableC0579y(this, b));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: Y2 */
    private void m2362Y2() {
        if (this.f1583L0) {
            return;
        }
        if (this.f1600V != 3 || !this.f1619h.hasFocus()) {
            boolean z = false;
            this.f1585M0 = this.f1582L.getVisibility() == 0;
            if (this.f1576I.getVisibility() == 0) {
                z = true;
            }
            this.f1587N0 = z;
            if (this.f1585M0) {
                ViewUtils.m2234l(this.f1582L, null);
            }
            if (this.f1587N0) {
                ViewUtils.m2234l(this.f1576I, null);
            }
            this.f1583L0 = true;
            return;
        }
        this.f1583L0 = true;
    }

    /* renamed from: Z0 */
    private View m2364Z0() {
        if (this.f1590P == null) {
            View inflate = this.f1598T.inflate(R.layout.b, (ViewGroup) this.f1605a.findViewById(16908290), false);
            this.f1590P = inflate;
            m2421p3(inflate);
            ((EditText) this.f1590P.findViewById(R.id.u)).addTextChangedListener(new C0512b());
            this.f1590P.findViewById(R.id.t).setOnClickListener(new View$OnClickListenerC0543c0(this));
            this.f1590P.findViewById(R.id.s).setOnClickListener(new View$OnClickListenerC0552h(this));
        }
        return this.f1590P;
    }

    /* renamed from: Z2 */
    private void m2365Z2() {
        if (DataChecker.m1181c().mo661a(158)) {
            m2315K3();
        }
    }

    /* renamed from: a1 */
    private String m2367a1(String str) {
        if (!TextUtils.isEmpty(str) && !BrowserUtils.m2101v(this.f1607b, str)) {
            return str.startsWith(this.f1629m) ? WebViewUtil.m2044d(str) : str;
        }
        String h0 = this.f1635p.mo1152h0();
        if (!TextUtils.isEmpty(h0)) {
            return h0;
        }
        String e = WebViewUtil.m2045e(QuickUtils.m1373e(this.f1607b));
        if (TextUtils.isEmpty(e)) {
            return e;
        }
        if (e.equals(DataChecker.m1181c().mo663d(1))) {
            return "";
        }
        DataChecker.m1181c().mo666g(1, e);
        return e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a2 */
    public /* synthetic */ void mo1361b2(View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 2)) {
            AddonItem aVar = new AddonItem();
            aVar.mo931o(lVar.f1091c[0]);
            aVar.mo926j(InfoUtils.m2169h(lVar.f1091c[1]));
            m2326O0(aVar);
        }
    }

    /* renamed from: a3 */
    private void m2369a3(int i) {
        m2372b3(i, null);
    }

    /* renamed from: b1 */
    private String m2371b1(int i) {
        return m2374c1(i, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b3 */
    private void m2372b3(int i, String str) {
        BrowserApp.m1389c().execute(new RunnableC0539a0(this, i, str));
    }

    /* renamed from: c1 */
    private String m2374c1(int i, String str) {
        boolean z = false;
        List<LogItem> list = null;
        switch (i) {
            case 1:
                return PageManager.m1943g(this.f1607b);
            case 2:
                Timber.m971a("get bookmark page", new Object[0]);
                return PageManager.m1939c(this.f1607b, null);
            case 3:
                return PageManager.m1942f(this.f1607b);
            case 4:
                return PageManager.m1937a(this.f1607b);
            case 5:
                return PageManager.m1941e(this.f1607b);
            case 6:
            case 10:
                int e1 = m2381e1(this.f1594R);
                Context context = this.f1607b;
                if (e1 != -1) {
                    list = this.f1609c.get(e1).mo814I();
                }
                if (i == 10) {
                    z = true;
                }
                return PageManager.m1944h(context, list, z);
            case 7:
                return PageManager.m1945i(this.f1607b);
            case 8:
            case 9:
            default:
                return null;
            case 11:
                return PageManager.m1939c(this.f1607b, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c2 */
    public /* synthetic */ void mo1362d2(View view, boolean z) {
        TabItem b0Var;
        int i = 8;
        if (!z) {
            if (!this.f1604Z || (b0Var = this.f1623j) == null || !BrowserUtils.m2102w(this.f1607b, b0Var.mo817L(), 8)) {
                TabItem b0Var2 = this.f1623j;
                if (b0Var2 == null || b0Var2.mo815J() >= 100) {
                    m2439u3(0);
                } else {
                    m2439u3(1);
                }
            } else {
                m2439u3(3);
            }
            this.f1619h.setText("");
            m2406l1();
        } else {
            m2439u3(2);
            if (this.f1606a0 != -1) {
                ViewUtils.m2234l(this.f1617g, null);
            }
            TabItem b0Var3 = this.f1623j;
            if (b0Var3 != null) {
                this.f1619h.setText(m2367a1(b0Var3.mo817L()));
                this.f1619h.selectAll();
            }
            AppUtils.m2066n(this.f1607b);
            m2279B3();
        }
        if (this.f1600V != 1) {
            FrameLayout frameLayout = this.f1568E;
            if (!z) {
                i = 0;
            }
            frameLayout.setVisibility(i);
            this.f1619h.setBackgroundResource(z ? 17170445 : R.drawable.c);
            this.f1619h.setPadding(ViewUtils.m2225c(this.f1607b, 42), ViewUtils.m2225c(this.f1607b, 10), ViewUtils.m2225c(this.f1607b, 42), ViewUtils.m2225c(this.f1607b, 10));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: c3 */
    private void m2376c3(Message message) {
        TabItem S2 = m2341S2(true, "");
        S2.mo818N().post(new RunnableC0576v(message, S2));
    }

    /* renamed from: d1 */
    private View m2378d1() {
        if (this.f1563B0 == null) {
            Context context = this.f1607b;
            this.f1569E0 = CompatUtils.m1335e(context, R.drawable.ax, CompatUtils.m1332b(context, R.attr.f));
            ListView d = LayoutUtils.m1366d(this.f1607b);
            this.f1567D0 = d;
            d.setStackFromBottom(this.f1600V != 2);
            this.f1565C0 = new C0515e(this.f1607b, R.layout.x, this.f1609c);
            this.f1567D0.setOnItemClickListener(new C0516f());
            this.f1567D0.setOnItemLongClickListener(new C0569p0(this));
            this.f1567D0.setAdapter((ListAdapter) this.f1565C0);
            if (Build.VERSION.SDK_INT >= 11) {
                SwipeDismissListViewTouchListener aVar = new SwipeDismissListViewTouchListener(this.f1567D0, new C0517g());
                this.f1567D0.setOnTouchListener(aVar);
                this.f1567D0.setOnScrollListener(aVar.mo695i());
            }
            ImageView imageView = new ImageView(this.f1607b);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, CompatUtils.m1333c(this.f1607b, R.dimen.a)));
            imageView.setContentDescription(CompatUtils.m1336f(this.f1607b, R.string.a1));
            CompatUtils.m1342l(imageView, FrogUtils.m1354a(this.f1607b, 10.0f));
            imageView.setBackgroundResource(R.drawable.f);
            Context context2 = this.f1607b;
            imageView.setImageDrawable(CompatUtils.m1335e(context2, R.drawable.a4, CompatUtils.m1332b(context2, R.attr.f)));
            imageView.setId(R.id.b);
            imageView.setOnClickListener(this.f1589O0);
            View c = LayoutUtils.m1365c(this.f1567D0, imageView);
            this.f1563B0 = c;
            c.setBackgroundColor(CompatUtils.m1332b(this.f1607b, R.attr.c));
            m2386f3();
            m2421p3(this.f1563B0);
        }
        return this.f1563B0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: d3 */
    private void m2379d3(int i) {
        int i2 = 2;
        int i3 = 0;
        boolean z = false;
        switch (i) {
            case 1:
                TabItem b0Var = this.f1623j;
                if (b0Var != null) {
                    b0Var.mo833o0();
                    return;
                }
                return;
            case 2:
            case 3:
                FastView N = this.f1623j.mo818N();
                if (i != 2) {
                    i3 = 1;
                }
                BrowserUtils.m2077H(N, i3);
                return;
            case 4:
                m2274A3();
                this.f1619h.requestFocus();
                return;
            case 5:
                m2334Q2(true, null);
                return;
            case 6:
                m2329P0();
                return;
            case 7:
            case 8:
                if (i != 7) {
                    i2 = 3;
                }
                m2372b3(i2, null);
                return;
            case 9:
                m2350V0(this.f1625k);
                return;
            case 10:
                int i4 = this.f1625k;
                if (i4 >= 1) {
                    m2282C3(i4 - 1);
                    return;
                } else if (this.f1609c.size() > 1) {
                    m2282C3(this.f1609c.size() - 1);
                    return;
                } else {
                    return;
                }
            case 11:
                if (this.f1625k < this.f1609c.size() - 1) {
                    m2282C3(this.f1625k + 1);
                    return;
                } else if (this.f1609c.size() > 1) {
                    m2282C3(0);
                    return;
                } else {
                    return;
                }
            case 12:
            case 13:
                if (i == 12) {
                    m2385f1();
                    return;
                } else {
                    this.f1623j.mo820Q();
                    return;
                }
            case 14:
                if (this.f1606a0 != -1) {
                    m2399j1();
                    return;
                } else {
                    m2461z3(2);
                    return;
                }
            case 15:
                if (this.f1606a0 == -1) {
                    m2461z3(0);
                    return;
                } else {
                    m2399j1();
                    return;
                }
            case 16:
            case 17:
                TabItem b0Var2 = this.f1623j;
                if (b0Var2 != null && b0Var2.mo818N() != null) {
                    FastView N2 = this.f1623j.mo818N();
                    if (i == 17) {
                        z = true;
                    }
                    N2.findNext(z);
                    return;
                }
                return;
            case 18:
                TabItem b0Var3 = this.f1623j;
                if (b0Var3 == null || !WebViewUtil.m2047g(b0Var3.mo817L())) {
                    Context context = this.f1607b;
                    QuickUtils.m1384p(context, CompatUtils.m1336f(context, R.string.bi));
                    return;
                }
                FastView N3 = this.f1623j.mo818N();
                if (N3 != null) {
                    TaoDialog g = TaoDialog.m1134g(this.f1607b);
                    g.mo620L(R.string.ab);
                    g.mo628c(0, WebViewUtil.m2043c(N3), R.string.e7, 1);
                    g.mo614F(17039370, new C0559k0(this, N3));
                    g.mo648z(17039360, null);
                    g.mo622N();
                    return;
                }
                return;
            case 19:
                if (Build.VERSION.SDK_INT >= 21) {
                    m2334Q2(true, "view-source:" + this.f1623j.mo817L());
                    return;
                } else if (WebViewUtil.m2047g(this.f1623j.mo817L())) {
                    Context context2 = this.f1607b;
                    QuickUtils.m1384p(context2, CompatUtils.m1336f(context2, R.string.iv));
                    this.f1623j.mo828h0("javascript:s=document.documentElement.outerHTML;a=window.open('');a.document.write(\"<html><head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no, minimal-ui'><title>Source</title><style type='text/css'>* {padding: 0; margin: 0} body{padding: 5px 10px;word-break:break-all;color: #666;line-height: 1.4;}</style></head><body></body></html>\");a.document.body.innerText=s;");
                    return;
                } else {
                    Context context3 = this.f1607b;
                    QuickUtils.m1384p(context3, CompatUtils.m1336f(context3, R.string.bi));
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e1 */
    private int m2381e1(int i) {
        int size = this.f1609c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i == this.f1609c.get(i2).mo813H()) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ boolean mo1363f2(View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return i == 82;
        }
        AppUtils.m2057e(this.f1607b, this.f1615f);
        m2414n3(this.f1619h.getText().toString().trim());
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e3 */
    private void m2383e3() {
        TabItem b0Var = this.f1623j;
        if (b0Var != null && b0Var.mo808A()) {
            List<LogItem> I = this.f1623j.mo814I();
            if (!I.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (LogItem cVar : I) {
                    if (cVar != null && cVar.mo954e()) {
                        arrayList.add(cVar.mo952c());
                    }
                }
                if (arrayList.size() == 1) {
                    IntentUtils.m2176c(this.f1605a, (String) arrayList.get(0), this.f1623j.mo816K());
                    return;
                } else if (arrayList.size() > 1) {
                    TaoDialog g = TaoDialog.m1134g(this.f1607b);
                    g.mo621M(this.f1623j.mo816K());
                    g.mo643u((String[]) arrayList.toArray(new String[arrayList.size()]), new C0567o0(this, arrayList));
                    g.mo622N();
                    return;
                } else {
                    return;
                }
            }
        }
        mo864u(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f1 */
    private void m2385f1() {
        if (!m2406l1()) {
            TabItem b0Var = this.f1623j;
            if (b0Var == null || !b0Var.mo841v()) {
                TabItem b0Var2 = this.f1623j;
                if (b0Var2 != null && !BrowserUtils.m2102w(this.f1607b, b0Var2.mo817L(), 1) && !BrowserUtils.m2102w(this.f1607b, this.f1623j.mo817L(), 8)) {
                    m2350V0(this.f1625k);
                    return;
                }
                return;
            }
            if (this.f1623j.mo815J() < 100) {
                this.f1623j.mo838t0();
            }
            this.f1623j.mo819O();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f3 */
    public void m2386f3() {
        CommonAdapter aVar = this.f1565C0;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            m2311J3();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: g1 */
    private void m2388g1() {
        TabItem b0Var = this.f1623j;
        if (b0Var != null && b0Var.mo842w()) {
            if (this.f1623j.mo815J() < 100) {
                this.f1623j.mo838t0();
            }
            this.f1623j.mo820Q();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ void mo1364h2(AdapterView adapterView, View view, int i, long j) {
        try {
            m2414n3(((TextView) view.findViewById(R.id.bf)).getText().toString());
        } catch (Exception e) {
            Timber.m973c(e);
        }
    }

    /* renamed from: g3 */
    private void m2390g3() {
        for (int size = this.f1609c.size() - 1; size >= 0; size--) {
            m2393h3(size);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h1 */
    private void m2392h1() {
        TabItem b0Var = this.f1623j;
        if (b0Var != null && !BrowserUtils.m2102w(this.f1607b, b0Var.mo817L(), 8)) {
            String str = GlobalConf.f1416p;
            if (!URLUtil.isAboutUrl(str) || "about:blank".equals(str)) {
                this.f1623j.mo828h0(str);
            } else {
                BrowserApp.m1389c().execute(new RunnableC0556j(this, str.equals("about:bookmarks") ? 2 : 1));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h3 */
    private void m2393h3(int i) {
        int k;
        if (i >= 0 && i < this.f1609c.size() && this.f1609c.get(i) != null && (k = BrowserUtils.m2090k(this.f1607b, this.f1609c.get(i).mo817L())) != 0 && k != -1) {
            if (DataChecker.m1181c().mo661a(k == 11 ? 2 : k)) {
                BrowserApp.m1389c().execute(new RunnableC0554i(this, k, k == 11 ? this.f1609c.get(i).mo816K() : null, i));
            }
        }
    }

    /* renamed from: i1 */
    private void m2395i1(String str) {
        if (str != null && str.startsWith("content://")) {
            BrowserApp.m1389c().execute(new RunnableC0572r(this, str));
        } else if (str == null || !str.startsWith("v://")) {
            m2334Q2(true, str);
        } else {
            mo863t(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i2 */
    public /* synthetic */ void mo1365j2(View view, TaoDialog.C0384l lVar) {
        int e1 = m2381e1(this.f1594R);
        if (e1 != -1) {
            this.f1609c.get(e1).mo843y();
            m2393h3(this.f1625k);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i3 */
    private void m2397i3() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f1607b.getResources().getDimensionPixelSize(R.dimen.c), this.f1607b.getResources().getDimensionPixelSize(R.dimen.c));
        int dimensionPixelSize = this.f1607b.getResources().getDimensionPixelSize(R.dimen.b);
        int y = this.f1635p.mo1202y();
        if (y == 4 || y == 1 || y == 6) {
            layoutParams.addRule(10, -1);
        }
        if (y == 5 || y == 0 || y == 7) {
            layoutParams.addRule(12, -1);
        }
        if (y == 4 || y == 2 || y == 5) {
            layoutParams.addRule(9, -1);
        }
        if (y == 6 || y == 3 || y == 7) {
            layoutParams.addRule(11, -1);
        }
        if (y == 1 || y == 0) {
            layoutParams.addRule(14, -1);
        }
        if (y == 2 || y == 3) {
            layoutParams.addRule(15, -1);
        }
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        this.f1576I.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j1 */
    private void m2399j1() {
        TabItem b0Var;
        TabItem b0Var2;
        int i = this.f1606a0;
        if (i != -1) {
            if (i == 6 && (b0Var2 = this.f1623j) != null) {
                this.f1626k0.mo1269p(b0Var2.mo818N());
            }
            if (!(this.f1606a0 != 2 || (b0Var = this.f1623j) == null || b0Var.mo818N() == null)) {
                m2357X0("");
            }
            this.f1606a0 = -1;
            if (!(this.f1586N.getVisibility() == 0 || this.f1582L.getVisibility() == 0 || this.f1635p.mo1205z() != 2)) {
                ViewUtils.m2219F(this.f1576I, AnimationHelper.m1120b(1));
            }
            ViewUtils.m2234l(this.f1617g, AnimationHelper.m1121c(((Boolean) this.f1617g.getTag()).booleanValue() ? 3 : 5));
            m2406l1();
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1578J.setElevation((float) ViewUtils.m2225c(this.f1607b, 12));
            }
            m2407l3();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j3 */
    private void m2400j3() {
        if (!BrowserUtils.m2101v(this.f1607b, this.f1623j.mo817L())) {
            this.f1594R = this.f1623j.mo813H();
        }
        int e1 = m2381e1(this.f1594R);
        if (e1 == -1 || !this.f1609c.get(e1).mo808A()) {
            Context context = this.f1607b;
            QuickUtils.m1384p(context, getResources().getString(R.string.ft) + getResources().getString(R.string.gv));
            return;
        }
        m2372b3(10, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: k1 */
    private void m2402k1() {
        if (this.f1586N.getVisibility() != 8 && this.f1601W != 0 && !this.f1583L0) {
            if (this.f1600V != 3) {
                if (Build.VERSION.SDK_INT >= 11) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f1615f, "translationY", (float) this.f1570F, 0.0f);
                    ofFloat.setDuration((long) this.f1607b.getResources().getInteger(R.integer.a));
                    ofFloat.start();
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f1621i, "translationY", (float) this.f1570F, 0.0f);
                    ofFloat2.setDuration((long) this.f1607b.getResources().getInteger(R.integer.a));
                    ofFloat2.start();
                } else {
                    this.f1615f.setPadding(0, 0, 0, 0);
                }
            }
            ViewUtils.m2234l(this.f1586N, AnimationHelper.m1121c(3));
            ViewUtils.m2234l(this.f1582L, AnimationHelper.m1121c(5));
            if (this.f1635p.mo1205z() == 2) {
                ViewUtils.m2219F(this.f1576I, AnimationHelper.m1120b(5));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k2 */
    public /* synthetic */ void mo1366l2(String str, String str2, int i, String str3, AdapterView adapterView, View view, int i2, long j) {
        String str4;
        String str5 = str;
        int i3 = (int) j;
        boolean z = false;
        switch (i3) {
            case 0:
            case 1:
                if (i3 >= 1) {
                    z = true;
                }
                m2341S2(z, str);
                return;
            case 2:
                m2341S2(true, str2);
                return;
            case 3:
                Context context = this.f1607b;
                if (i == 6) {
                    str5 = str.substring(str.indexOf("://") + 3);
                }
                SupportUtils.m2195a(context, str5, R.string.ir);
                return;
            case 4:
            case 5:
            case 28:
            case 30:
            default:
                return;
            case 6:
                m2277B1(str2, null, "attachment", "image/*", -1);
                return;
            case 7:
                StringBuilder sb = new StringBuilder();
                sb.append(AppUtils.m2060h() ? "https://pic.sogou.com/ris?flag=1&drag=0&query=" : "https://images.google.com/searchbyimage?image_url=");
                sb.append(str2);
                m2334Q2(true, sb.toString());
                return;
            case 8:
                TabItem b0Var = this.f1623j;
                if (b0Var != null && b0Var.mo818N() != null) {
                    this.f1623j.mo828h0("javascript: var pic=function(){var c=document.getElementsByTagName(\"img\"),f=c.length,e=Array(f),d=[];d.push(\"<html><head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=1, minimal-ui'><title>Source</title><style type='text/css'>* {padding: 0; margin: 0} img{display: block; margin: auto; text-align: center; max-width: 100%;}</style><script type=\\\"text/javascript\\\"> function download(obj) {console.log(obj.src); } \\x3c/script></head><body>\");for(var b=0;b<f;b++)e[b]=c[b].src,e[b]&&99<c[b].height&&99<c[b].width&&d.push('<img onclick=\"download(this)\" src=\"'+e[b]+'\"/>');d.push(\"</body></html>\");a=window.open(\"\");a.document.write(d.join(\"\"));a.focus()};pic();");
                    return;
                }
                return;
            case 9:
                BookmarkHelper.m1711e(this.f1607b, str, this.f1629m, new C0536y());
                return;
            case 10:
                m2332Q0(str);
                return;
            case 11:
                BookmarkHelper.m1709c(this.f1607b, str);
                m2393h3(this.f1625k);
                return;
            case 12:
            case 13:
                String substring = str.substring(9);
                try {
                    substring = URLDecoder.decode(str.substring(9), "utf-8");
                } catch (UnsupportedEncodingException unused) {
                }
                C0537z zVar = new C0537z();
                if (i3 == 12) {
                    BookmarkHelper.m1722p(this.f1607b, substring, zVar);
                    return;
                } else {
                    BookmarkHelper.m1710d(this.f1607b, substring, zVar);
                    return;
                }
            case 14:
                m2353W0(str);
                return;
            case 15:
                this.f1633o.mo982i(str);
                DataChecker.m1181c().mo667h(1);
                m2393h3(this.f1625k);
                return;
            case 16:
                HistoryHelper.m1737d(this.f1607b, str);
                m2393h3(this.f1625k);
                return;
            case 17:
                HistoryHelper.m1735b(this.f1607b, new C0511a0());
                return;
            case 18:
                String str6 = str.substring(7, str.lastIndexOf(47) + 1) + Uri.decode(str.substring(str.lastIndexOf("/") + 1));
                if (FileUtil.m2142a(str6)) {
                    m2393h3(this.f1625k);
                    return;
                }
                QuickUtils.m1384p(this.f1607b, this.f1607b.getResources().getString(R.string.cf) + str6);
                return;
            case 19:
                int e1 = m2381e1(this.f1594R);
                if (e1 == -1) {
                    str4 = null;
                } else {
                    str4 = this.f1609c.get(e1).mo816K();
                }
                IntentUtils.m2176c(this.f1605a, str, str4);
                return;
            case 20:
                m2277B1(str, null, "attachment", null, -1);
                return;
            case 21:
                QuickUtils.m1374f(this.f1607b, R.string.n, R.string.ct, new C0561l0(this));
                return;
            case 22:
                QuickUtils.m1379k(this.f1607b, R.string.a5, CompatUtils.m1336f(this.f1607b, R.string.gk) + "\n" + this.f1623j.mo816K() + "\n\n" + CompatUtils.m1336f(this.f1607b, R.string.gl) + "\n" + this.f1623j.mo817L() + "\n\n" + CompatUtils.m1336f(this.f1607b, R.string.gj) + "\n" + str);
                return;
            case 23:
                this.f1623j.mo828h0(JS.m1588b(this.f1607b, str));
                return;
            case 24:
            case 25:
                String n = BrowserUtils.m2093n(str, true);
                String x = FilterUtils.m119x(str, true);
                if (i3 == 24) {
                    this.f1632n0.mo5a(x);
                    Context context2 = this.f1607b;
                    QuickUtils.m1384p(context2, CompatUtils.m1337g(context2, R.string.ba, n));
                    return;
                }
                this.f1632n0.mo12l(x);
                Context context3 = this.f1607b;
                QuickUtils.m1384p(context3, CompatUtils.m1337g(context3, R.string.j3, n));
                return;
            case 26:
            case 27:
                String substring2 = str.substring(str.indexOf("://") + 3);
                String x2 = FilterUtils.m119x(str, false);
                if (i3 == 26) {
                    this.f1632n0.mo5a(x2);
                    Context context4 = this.f1607b;
                    QuickUtils.m1384p(context4, CompatUtils.m1337g(context4, R.string.ba, substring2));
                    return;
                }
                this.f1632n0.mo12l(x2);
                Context context5 = this.f1607b;
                QuickUtils.m1384p(context5, CompatUtils.m1337g(context5, R.string.j3, substring2));
                return;
            case 29:
                QuickUtils.m1370b(this.f1607b, str3, R.string.iq);
                return;
            case 31:
                IntentUtils.m2179f(this.f1607b, str);
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: k3 */
    private boolean m2404k3(String[] strArr) {
        int i;
        if (strArr == null || strArr.length <= 0) {
            i = 0;
        } else {
            i = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    m2334Q2(true, str);
                    i++;
                }
            }
        }
        if (i != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: l1 */
    private boolean m2406l1() {
        View view;
        if (this.f1606a0 == -1 && ((view = this.f1611d) == null || view.getVisibility() == 8)) {
            return false;
        }
        if (this.f1606a0 != -1) {
            m2399j1();
            return true;
        }
        if (this.f1619h.hasFocus()) {
            TabItem b0Var = this.f1623j;
            if (b0Var != null && BrowserUtils.m2101v(this.f1607b, b0Var.mo817L())) {
                String trim = this.f1619h.getText().toString().trim();
                if (!trim.equals(DataChecker.m1181c().mo663d(1)) && !trim.equals(this.f1635p.mo1152h0())) {
                    this.f1635p.mo1070C1(trim);
                }
            }
            AppUtils.m2057e(this.f1607b, this.f1615f);
        }
        TabItem b0Var2 = this.f1623j;
        if (b0Var2 != null) {
            b0Var2.mo834p0();
        }
        ViewUtils.m2234l(this.f1611d, AnimationHelper.m1121c(1));
        return true;
    }

    /* renamed from: l3 */
    private void m2407l3() {
        int i = this.f1638q0;
        if (i != -1) {
            if (i == 0 || i == 1) {
                View[] viewArr = {this.f1580K.findViewById(R.id.au), this.f1580K.findViewById(R.id.av), this.f1580K.findViewById(R.id.aw), this.f1580K.findViewById(R.id.ay)};
                for (int i2 = 0; i2 < 4; i2++) {
                    ViewUtils.m2221H(viewArr[i2], AnimationHelper.m1120b(5));
                }
                if (this.f1600V != 1) {
                    View[] viewArr2 = {this.f1584M.findViewById(R.id.o), this.f1584M.findViewById(R.id.aq), this.f1584M.findViewById(R.id.ar)};
                    for (int i3 = 0; i3 < 3; i3++) {
                        ViewUtils.m2221H(viewArr2[i3], AnimationHelper.m1120b(5));
                    }
                }
                ImageView imageView = (ImageView) this.f1580K.findViewById(R.id.ax);
                imageView.setImageResource(R.drawable.ah);
                imageView.startAnimation(AnimationHelper.m1120b(5));
            }
            ImageView imageView2 = (ImageView) this.f1580K.findViewById(R.id.az);
            int i4 = this.f1638q0;
            if (i4 == 0 || i4 == 1) {
                imageView2.setImageResource(R.drawable.ay);
                imageView2.startAnimation(AnimationHelper.m1120b(5));
            }
            if (this.f1638q0 == 1) {
                ViewUtils.m2221H(this.f1580K.findViewById(R.id.az), AnimationHelper.m1120b(5));
            }
            this.f1638q0 = -1;
        }
    }

    /* renamed from: m1 */
    private void m2409m1() {
        mo844a(0);
        int o = this.f1635p.mo1172o();
        if ((o & 1) != 0) {
            BrowserUtils.m2084e(this.f1607b);
        } else if (System.currentTimeMillis() - this.f1635p.mo1117T() >= 432000000) {
            BrowserUtils.m2084e(this.f1607b);
            this.f1635p.mo1114R1();
        }
        if ((o & 2) != 0) {
            BrowserUtils.m2086g(this.f1607b);
        }
        if ((o & 4) != 0) {
            BrowserUtils.m2087h(this.f1607b);
        }
        if ((o & 8) != 0) {
            BrowserUtils.m2083d();
        }
        if ((o & 16) != 0) {
            BrowserUtils.m2085f(this.f1607b);
        }
        int m = this.f1635p.mo1166m();
        FlurryHelper.m1681a().mo1037e(m);
        if (20201023 > m) {
            DataChecker.m1181c().mo668i(1, 2, 3, 5);
            this.f1610c0 = true;
            if (this.f1635p.mo1166m() != 0 && this.f1635p.mo1062A(18) && this.f1635p.mo1125X().isEmpty()) {
                this.f1635p.mo1130Z0(18);
                new FrogToast(this.f1605a, (int) R.string.h6, 17039370, new C0526o()).mo773m();
            }
            this.f1635p.mo1090J0(20201023);
        }
        m2336R0();
    }

    /* access modifiers changed from: private */
    /* renamed from: m2 */
    public /* synthetic */ void mo1367n2(String str, View view, TaoDialog.C0384l lVar) {
        m2414n3(str);
    }

    /* renamed from: m3 */
    private void m2411m3() {
        if (!(this.f1609c.size() <= 0 || this.f1635p.mo1095L() || this.f1635p.mo1140d0() == 0)) {
            StringBuilder sb = new StringBuilder();
            int size = this.f1609c.size();
            for (int i = 0; i < size; i++) {
                TabItem b0Var = this.f1609c.get(i);
                if (b0Var != null && !TextUtils.isEmpty(b0Var.mo817L()) && !BrowserUtils.m2101v(this.f1607b, b0Var.mo817L())) {
                    sb.append(b0Var.mo817L());
                    sb.append("|$|SEPARATOR|$|");
                }
            }
            this.f1635p.mo1189t1(sb.toString());
        }
    }

    /* renamed from: n1 */
    private void m2413n1() {
        this.f1564C = new BrowserBroadcastReceiver(new C0522k());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f1564C, intentFilter, "mark.via.permission.BROADCAST", null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: n3 */
    private void m2414n3(String str) {
        if (str == null || str.isEmpty() || this.f1623j == null) {
            m2406l1();
            return;
        }
        String trim = str.trim();
        this.f1623j.mo838t0();
        if (WebAdressUtils.m2253e(trim)) {
            this.f1623j.mo828h0(WebAdressUtils.m2255g(trim, this.f1629m));
        } else {
            try {
                trim = URLEncoder.encode(trim, "utf-8");
            } catch (Exception unused) {
            }
            TabItem b0Var = this.f1623j;
            b0Var.mo828h0(this.f1629m + trim);
            FlurryHelper.m1681a().mo1038f(this.f1631n);
        }
        this.f1635p.mo1070C1("");
        AppUtils.m2057e(this.f1607b, this.f1615f);
        TabItem b0Var2 = this.f1623j;
        if (b0Var2 != null) {
            b0Var2.mo834p0();
        }
        m2399j1();
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    /* renamed from: o1 */
    private void m2416o1() {
        TabItem b0Var;
        int g0 = this.f1635p.mo1149g0();
        int i = 0;
        if (g0 == 2) {
            setRequestedOrientation(10);
        } else if (g0 == 3) {
            setRequestedOrientation(1);
        } else if (g0 != 4) {
            setRequestedOrientation(2);
        } else {
            setRequestedOrientation(0);
        }
        String[] s = BrowserUtils.m2098s(this.f1607b);
        this.f1629m = s[0];
        this.f1631n = s[1];
        this.f1604Z = AppUtils.m2053a(this.f1607b, "mark.qrcode");
        this.f1616f0.mo392n(this.f1635p.mo1193v());
        this.f1616f0.mo393o(this.f1635p.mo1196w());
        boolean g = this.f1635p.mo1148g();
        this.f1612d0 = g;
        ImageView imageView = this.f1578J;
        if (!g || (b0Var = this.f1623j) == null || !b0Var.mo808A()) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.f1575H0 = this.f1635p.mo1151h();
        m2303H3();
        m2418o3();
        m2425q3();
    }

    /* access modifiers changed from: private */
    /* renamed from: o2 */
    public /* synthetic */ void mo1382p2(String str, View view) {
        QuickUtils.m1371c(this.f1607b, str, getResources().getString(R.string.iq));
    }

    /* renamed from: o3 */
    private void m2418o3() {
        int i;
        int i2;
        int i3;
        int p0 = this.f1635p.mo1176p0();
        boolean z = false;
        if (p0 == 0) {
            p0 = this.f1603Y || this.f1605a.getResources().getConfiguration().orientation == 2 ? 2 : 1;
        }
        int i4 = this.f1600V;
        if (i4 != p0) {
            boolean z2 = i4 == -1 || p0 == 1 || i4 == 1;
            this.f1600V = p0;
            this.f1586N.removeAllViews();
            this.f1582L.removeAllViews();
            if (z2) {
                int i5 = ViewUtils.m2229g(this.f1607b) >= 5.9d ? 1 : 0;
                boolean z3 = this.f1603Y;
                int i6 = (5 - (i5 ^ 1)) - (!z3 ? 1 : 0);
                if (p0 == 1) {
                    this.f1568E.removeAllViews();
                } else {
                    this.f1568E.addView(this.f1580K);
                }
                int i7 = 8;
                this.f1580K.findViewById(R.id.au).setVisibility((p0 == 1 || z3) ? 0 : 8);
                View findViewById = this.f1580K.findViewById(R.id.av);
                if (p0 == 1 || i5 != 0) {
                    i7 = 0;
                }
                findViewById.setVisibility(i7);
                ViewGroup.LayoutParams layoutParams = this.f1568E.getLayoutParams();
                layoutParams.width = ViewUtils.m2225c(this.f1607b, p0 == 1 ? 0 : i6 * 48);
                this.f1568E.setLayoutParams(layoutParams);
            }
            if (p0 == 1) {
                this.f1582L.addView(this.f1580K);
                this.f1586N.addView(this.f1584M);
            } else if (p0 == 2) {
                this.f1586N.addView(this.f1584M);
            } else if (p0 == 3) {
                this.f1582L.addView(this.f1584M);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f1586N.getLayoutParams();
            if (p0 == 3) {
                i = 0;
            } else {
                i = this.f1570F;
            }
            layoutParams2.height = i;
            this.f1586N.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.f1582L.getLayoutParams();
            if (p0 == 2) {
                i2 = 0;
            } else {
                i2 = this.f1607b.getResources().getDimensionPixelSize(R.dimen.a);
            }
            layoutParams3.height = i2;
            this.f1582L.setLayoutParams(layoutParams3);
            this.f1619h.setBackgroundResource(p0 == 1 ? 17170445 : R.drawable.c);
            this.f1619h.setPadding(ViewUtils.m2225c(this.f1607b, 42), ViewUtils.m2225c(this.f1607b, 10), ViewUtils.m2225c(this.f1607b, 42), ViewUtils.m2225c(this.f1607b, 10));
            m2399j1();
            if (!this.f1603Y || this.f1600V == 1) {
                i3 = ViewUtils.m2228f(this.f1607b);
            } else {
                i3 = Math.min(ViewUtils.m2228f(this.f1607b) - ViewUtils.m2225c(this.f1607b, 100), ViewUtils.m2225c(this.f1607b, 400));
            }
            Slice.C0483a b = Slice.C0483a.m2001b();
            b.mo1274c(i3);
            b.mo1273a();
            ListView listView = this.f1567D0;
            if (listView != null) {
                if (this.f1600V != 2) {
                    z = true;
                }
                listView.setStackFromBottom(z);
                this.f1567D0.post(new RunnableC0570q(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p1 */
    public void m2420p1() {
        String o = getIntent() != null ? BrowserUtils.m2094o(getIntent(), this.f1629m) : null;
        boolean z = false;
        int d0 = this.f1635p.mo1095L() ? 0 : this.f1635p.mo1140d0();
        String X = this.f1635p.mo1125X();
        String[] split = X.split("\\|\\$\\|SEPARATOR\\|\\$\\|");
        boolean z2 = d0 == 0 || d0 == 2 || !m2404k3(split);
        if (d0 == 2 && !X.isEmpty() && !X.equals("|$|SEPARATOR|$|") && split.length > 0) {
            QuickUtils.m1383o(this.f1607b, R.string.gx, 17039370, new C0524m(split));
        }
        if ((!ChannelUtils.m2107b("vmos")) && m2440v()) {
            z = true;
        }
        if (o != null || (z2 && !z)) {
            m2395i1(o);
        }
        if (!TextUtils.isEmpty(o)) {
            this.f1596S.set(BrowserUtils.m2070A(getIntent()));
        }
    }

    /* renamed from: p3 */
    private void m2421p3(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (!this.f1603Y || this.f1600V == 1) {
                layoutParams.width = ViewUtils.m2228f(this.f1607b);
            } else {
                layoutParams.width = Math.min(ViewUtils.m2228f(this.f1607b) - ViewUtils.m2225c(this.f1607b, 100), ViewUtils.m2225c(this.f1607b, 400));
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: q1 */
    private void m2423q1() {
        if (this.f1580K == null) {
            View findViewById = findViewById(R.id.as);
            this.f1580K = findViewById;
            this.f1613e = (TextView) findViewById.findViewById(R.id.ay);
            ViewUtils.m2217D(this.f1589O0, this.f1580K.findViewById(R.id.au), this.f1580K.findViewById(R.id.av), this.f1580K.findViewById(R.id.aw), this.f1580K.findViewById(R.id.ax), this.f1580K.findViewById(R.id.az));
            ViewUtils.m2218E(this.f1597S0, this.f1580K.findViewById(R.id.au), this.f1580K.findViewById(R.id.av), this.f1580K.findViewById(R.id.aw), this.f1580K.findViewById(R.id.ax), this.f1580K.findViewById(R.id.az));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q2 */
    public /* synthetic */ void mo1383r2(int i) {
        if (i > 0) {
            Context context = this.f1607b;
            QuickUtils.m1384p(context, i + " " + R.string.fd);
            DataChecker.m1181c().mo667h(2);
            return;
        }
        QuickUtils.m1382n(this.f1607b, R.string.ej);
    }

    /* renamed from: q3 */
    private void m2425q3() {
        if (!this.f1602X && this.f1635p.mo1205z() == 2) {
            this.f1602X = true;
            m2397i3();
            FabDragListener aVar = new FabDragListener(this.f1607b);
            aVar.mo1278m(this.f1576I);
            aVar.mo1276k(ViewUtils.m2225c(this.f1607b, 4));
            aVar.mo1277l(true);
            aVar.mo1275j(new C0525n());
        }
    }

    /* renamed from: r1 */
    private void m2427r1() {
        if (this.f1584M == null) {
            View findViewById = findViewById(R.id.bj);
            this.f1584M = findViewById;
            this.f1647v = (ImageView) findViewById.findViewById(R.id.aq);
            this.f1566D = -1;
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f1584M.findViewById(R.id.o);
            this.f1619h = autoCompleteTextView;
            autoCompleteTextView.addTextChangedListener(new C0523l(this));
            this.f1560A = (ImageView) this.f1584M.findViewById(R.id.ar);
            this.f1619h.setOnFocusChangeListener(new View$OnFocusChangeListenerC0542c(this));
            this.f1619h.setOnKeyListener(new View$OnKeyListenerC0555i0(this));
            this.f1619h.setOnItemClickListener(new C0549f0(this));
            this.f1619h.setAdapter(new SearchAdapter(this.f1607b));
            this.f1568E = (FrameLayout) this.f1584M.findViewById(R.id.ac);
            ViewUtils.m2217D(this.f1589O0, this.f1647v, this.f1560A);
        }
    }

    /* renamed from: r3 */
    private void m2428r3(boolean z, boolean z2) {
        int i = Build.VERSION.SDK_INT;
        Window window = getWindow();
        View decorView = window.getDecorView();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = 0;
        if (z) {
            attributes.flags |= 1024;
            if (i >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            if (i >= 30) {
                window.setDecorFitsSystemWindows(false);
                WindowInsetsController insetsController = getWindow().getInsetsController();
                if (insetsController != null) {
                    int statusBars = WindowInsets.Type.statusBars();
                    if (z2) {
                        i2 = WindowInsets.Type.navigationBars();
                    }
                    insetsController.hide(statusBars | i2);
                }
            } else if (i >= 19) {
                if (z2) {
                    i2 = 512;
                }
                decorView.setSystemUiVisibility(i2 | 2 | 1024 | 4 | 4096);
            } else if (i >= 14) {
                decorView.setSystemUiVisibility(0);
            }
        } else {
            attributes.flags &= -1025;
            if (i >= 30) {
                window.setDecorFitsSystemWindows(true);
                WindowInsetsController insetsController2 = getWindow().getInsetsController();
                if (insetsController2 != null) {
                    insetsController2.show(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                }
            } else if (i >= 14) {
                decorView.setSystemUiVisibility(0);
            }
        }
        window.setAttributes(attributes);
    }

    /* renamed from: s1 */
    private void m2430s1() {
        this.f1608b0 = (ViewGroup) findViewById(R.id.ai);
        this.f1586N = (FrameLayout) findViewById(R.id.bk);
        this.f1582L = (FrameLayout) findViewById(R.id.at);
        this.f1615f = (FrameLayout) findViewById(R.id.x);
        this.f1621i = (ProgressBar) findViewById(R.id.ae);
        this.f1576I = (ImageView) findViewById(R.id.d);
        this.f1578J = (ImageView) findViewById(R.id.f);
        this.f1588O = (ImageView) findViewById(R.id.e);
        this.f1592Q = new SmoothProgressBar(this.f1621i);
        int i = Build.VERSION.SDK_INT;
        if (i >= 11) {
            this.f1576I.setAlpha(0.6f);
            this.f1578J.setAlpha(0.6f);
            if (i >= 21) {
                this.f1576I.setElevation((float) ViewUtils.m2225c(this.f1607b, 12));
                this.f1588O.setElevation((float) ViewUtils.m2225c(this.f1607b, 12));
                this.f1578J.setElevation((float) ViewUtils.m2225c(this.f1607b, 12));
            }
        }
        this.f1578J.setOnClickListener(this.f1589O0);
        this.f1578J.setOnLongClickListener(this.f1597S0);
        this.f1588O.setVisibility(i >= 11 ? 4 : 8);
        m2423q1();
        m2427r1();
    }

    /* access modifiers changed from: private */
    /* renamed from: s2 */
    public /* synthetic */ void mo1384t2(InputStream inputStream) {
        runOnUiThread(new RunnableC0564n(this, new BookmarkManager(this.f1607b).mo1060d(inputStream)));
    }

    /* renamed from: s3 */
    private void m2432s3() {
        TabItem b0Var;
        if (this.f1619h.hasFocus()) {
            return;
        }
        if (!this.f1604Z || (b0Var = this.f1623j) == null || !BrowserUtils.m2102w(this.f1607b, b0Var.mo817L(), 8)) {
            m2439u3(0);
        } else {
            m2439u3(3);
        }
    }

    /* renamed from: t1 */
    private void m2434t1() {
        Downloader e = Downloader.m919e(this.f1607b);
        e.mo391m(new C0518h());
        this.f1616f0 = e;
        e.mo390l(this.f1607b);
        this.f1628l0 = new DownloaderSlice(this.f1605a);
        this.f1626k0 = new SiteConfSlice(this.f1605a, this.f1636p0);
        this.f1633o = DatabaseHandler.m1595v(this.f1607b);
        this.f1598T = (LayoutInflater) this.f1607b.getSystemService("layout_inflater");
        this.f1609c = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) {
            WebIconDatabase.getInstance().open(getDir("icons", 0).getPath());
        }
        this.f1603Y = ViewUtils.m2240r(this.f1607b);
        this.f1614e0 = new GestureDetector(this.f1605a, new C0520i());
    }

    /* renamed from: t3 */
    private void m2435t3() {
        if (!this.f1619h.hasFocus()) {
            m2439u3(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u2 */
    public /* synthetic */ void mo1385v2(String str, boolean z) {
        if (m2456y3(str)) {
            m2337R2(true, str, z);
        } else {
            this.f1623j.mo828h0(str);
        }
    }

    /* renamed from: u3 */
    private void m2439u3(int i) {
        if (this.f1562B != i) {
            if (i == 1) {
                this.f1560A.setImageResource(R.drawable.p);
            } else if (i == 2) {
                this.f1560A.setImageResource(R.drawable.r);
            } else if (i != 3) {
                this.f1560A.setImageResource(R.drawable.an);
            } else {
                this.f1560A.setImageResource(R.drawable.aq);
            }
            this.f1562B = i;
        }
    }

    /* renamed from: v */
    private boolean m2440v() {
        if ((20201023 <= this.f1635p.mo1166m() && !this.f1610c0) || !AppUtils.m2060h()) {
            return false;
        }
        DataChecker.m1181c().mo667h(4);
        m2334Q2(true, PageManager.m1937a(this.f1607b));
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: v3 */
    private void m2443v3(ViewHolder cVar, TabItem b0Var, int i) {
        if (cVar != null && b0Var != null) {
            TextView textView = (TextView) cVar.mo684b(R.id.b_);
            textView.setText(b0Var.mo816K());
            if (b0Var.mo821S()) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextColor(CompatUtils.m1331a(this.f1607b, R.color.q));
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
                textView.setTextColor(CompatUtils.m1332b(this.f1607b, R.attr.h));
            }
            Bitmap G = b0Var.mo812G();
            if (G != null) {
                cVar.mo686d(R.id.a4, G);
            } else {
                cVar.mo687e(R.id.a4, this.f1569E0);
            }
            cVar.mo688f(R.id.a3, new View$OnClickListenerC0514d(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w1 */
    public /* synthetic */ void mo1386x1(AddonItem aVar) {
        this.f1633o.mo970F(aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: w2 */
    public /* synthetic */ void mo1387x2(int i, String str) {
        String c1 = m2374c1(i, str);
        boolean z = (i == 10 || i == 6) ? false : true;
        if (c1 != null) {
            this.f1605a.runOnUiThread(new RunnableC0560l(this, c1, z));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: w3 */
    private void m2448w3(FrogMenuBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1607b);
        g.mo618J(R.array.o, this.f1635p.mo1185s0() - 1, new C0577w(this));
        g.mo624P(this.f1654y0.mo707e(i));
    }

    /* renamed from: x3 */
    private boolean m2451x3(WebResourceRequest webResourceRequest, String str, String str2) {
        if ("https://www.google.com/images/cleardot.gif".equals(str)) {
            return true;
        }
        if (str == null || URLUtil.isFileUrl(str) || URLUtil.isFileUrl(str2) || !ConfUtil.m2116c(BrowserUtils.m2093n(str2, false))) {
            return false;
        }
        boolean o = webResourceRequest != null ? this.f1632n0.mo15o(webResourceRequest, str2) : this.f1632n0.mo16p(str, str2);
        if (o) {
            this.f1620h0++;
            this.f1622i0 += BrowserUtils.m2096q(str);
        }
        return o;
    }

    /* renamed from: y1 */
    static /* synthetic */ void m2454y1(String str, TaoDialog cVar, EditText editText, String str2) {
        if (!TextUtils.isEmpty(str)) {
            cVar.mo641s(str);
        }
        editText.setText(str2);
    }

    /* renamed from: y2 */
    static /* synthetic */ void m2455y2(Message message, TabItem b0Var) {
        b0Var.mo818N().setTag("NewWindow");
        ((WebView.WebViewTransport) message.obj).setWebView(b0Var.mo818N());
        message.sendToTarget();
    }

    /* renamed from: y3 */
    private boolean m2456y3(String str) {
        TabItem b0Var = this.f1623j;
        return b0Var == null || !BrowserUtils.m2101v(this.f1607b, b0Var.mo817L());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* renamed from: z1 */
    public /* synthetic */ void mo1340A1(String str, String[] strArr, TaoDialog cVar, EditText editText) {
        Throwable th;
        long j;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setRequestProperty("Cookie", CookieManager.getInstance().getCookie(str));
                httpURLConnection2.setDoInput(false);
                httpURLConnection2.setDoOutput(false);
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() == 200) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        j = httpURLConnection2.getContentLengthLong();
                    } else {
                        j = (long) httpURLConnection2.getContentLength();
                    }
                    String l = BrowserUtils.m2091l(j);
                    strArr[1] = httpURLConnection2.getContentType();
                    strArr[0] = httpURLConnection2.getHeaderField("Content-Disposition");
                    String a = DownloaderUtils.m938a(str, strArr[0], strArr[1]);
                    if (ChannelUtils.m2107b("vmos") && a.endsWith(".apk")) {
                        strArr[1] = "application/vnd.android.package-archive";
                    }
                    this.f1605a.runOnUiThread(new RunnableC0553h0(CompatUtils.m1336f(this.f1605a, R.string.dj) + ": " + l, cVar, editText, a));
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Exception unused2) {
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            th = th3;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z2 */
    public /* synthetic */ void mo1341A2(WebView webView, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 1) && WebViewUtil.m2051k(webView, FileUtil.m2143b(FileUtils.m2159o(this.f1607b), lVar.f1091c[0], ".mht"))) {
            QuickUtils.m1382n(this.f1607b, R.string.gz);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"RtlHardcoded"})
    /* renamed from: z3 */
    private void m2461z3(int i) {
        if (i != this.f1606a0) {
            RelativeLayout relativeLayout = this.f1617g;
            int i2 = 3;
            if (relativeLayout == null) {
                RelativeLayout relativeLayout2 = new RelativeLayout(this.f1607b);
                this.f1617g = relativeLayout2;
                relativeLayout2.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(2, R.id.at);
                layoutParams.addRule(3, R.id.bk);
                layoutParams.alignWithParent = true;
                ViewGroup viewGroup = this.f1608b0;
                viewGroup.addView(this.f1617g, viewGroup.getChildCount() - 3, layoutParams);
            } else {
                relativeLayout.removeAllViews();
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21) {
                this.f1578J.setElevation(0.0f);
            }
            int i4 = this.f1600V;
            boolean z = false;
            boolean z2 = i4 == 2;
            this.f1606a0 = i;
            if (i == 0) {
                m2279B3();
                this.f1617g.addView(m2378d1());
                if (this.f1623j != null) {
                    this.f1567D0.post(new RunnableC0575u(this));
                }
            } else if (i == 2) {
                TabItem b0Var = this.f1623j;
                if (!(b0Var == null || b0Var.mo818N() == null)) {
                    this.f1617g.addView(m2364Z0());
                    m2357X0(((EditText) m2364Z0().findViewById(R.id.u)).getText().toString());
                }
            } else if (i == 3) {
                m2279B3();
                this.f1617g.addView(m2360Y0());
                m2343T0(0);
            } else if (i == 5) {
                m2279B3();
                this.f1617g.addView(this.f1628l0.mo1271b());
                m2343T0(1);
            } else if (i != 6) {
                this.f1606a0 = -1;
                return;
            } else {
                if (i4 != 3) {
                    z = true;
                }
                m2279B3();
                String L = this.f1623j.mo817L();
                RelativeLayout relativeLayout3 = this.f1617g;
                SiteConfSlice iVar = this.f1626k0;
                iVar.mo1270q(L);
                relativeLayout3.addView(iVar.mo1271b());
                z2 = z;
            }
            if (i3 >= 17) {
                this.f1617g.setGravity(z2 ? 8388661 : 8388693);
            } else {
                this.f1617g.setGravity(z2 ? 53 : 85);
            }
            this.f1617g.setTag(Boolean.valueOf(z2));
            RelativeLayout relativeLayout4 = this.f1617g;
            if (!z2) {
                i2 = 5;
            }
            ViewUtils.m2243u(relativeLayout4, AnimationHelper.m1120b(i2));
            ViewUtils.m2234l(this.f1576I, AnimationHelper.m1121c(1));
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: a */
    public void mo844a(int i) {
        if (i == 0) {
            i = this.f1635p.mo1179q0();
        }
        if (this.f1566D != i && !this.f1635p.mo1129Z(this.f1607b) && this.f1635p.mo1184s()) {
            m2346U0(i);
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: b */
    public void mo845b(int i) {
        int e1 = m2381e1(i);
        ListView listView = this.f1567D0;
        if (listView != null && e1 >= 0) {
            m2443v3(ListUtils.m1228a(listView, e1), this.f1609c.get(e1), e1);
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: c */
    public void mo846c(ValueCallback<Uri> valueCallback) {
        this.f1637q = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        startActivityForResult(Intent.createChooser(intent, getString(R.string.ik)), 111);
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: d */
    public boolean mo847d() {
        return this.f1574H;
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: e */
    public void mo848e(WebView webView, boolean z, Message message) {
        if (message != null) {
            if (!this.f1635p.mo1160k() || z) {
                m2376c3(message);
            } else if (webView != null && webView.isShown()) {
                new FrogToast(this.f1605a, (int) R.string.bc, (int) R.string.b0, new C0533v(message)).mo773m();
            }
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: f */
    public void mo849f(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        Timber.m971a("onShowCustomView", new Object[0]);
        if (view != null) {
            if (this.f1641s == null || this.f1645u == null) {
                this.f1642s0 = getRequestedOrientation();
                this.f1644t0 = getResources().getConfiguration().orientation;
                view.setKeepScreenOn(true);
                this.f1641s = view;
                this.f1645u = customViewCallback;
                setRequestedOrientation(0);
                FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
                FrameLayout frameLayout2 = new FrameLayout(this);
                this.f1643t = frameLayout2;
                frameLayout2.setBackgroundColor(CompatUtils.m1331a(this.f1607b, 17170444));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.f1643t.addView(this.f1641s, layoutParams);
                frameLayout.addView(this.f1643t, layoutParams);
                frameLayout.requestLayout();
                this.f1615f.setVisibility(4);
                m2428r3(true, true);
                ViewUtils.m2234l(this.f1576I, null);
                return;
            }
            Timber.m971a("Call hidden event", new Object[0]);
            try {
                customViewCallback.onCustomViewHidden();
            } catch (Exception unused) {
            }
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    @TargetApi(21)
    /* renamed from: g */
    public void mo850g(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (Constants.f1301f >= 21) {
            this.f1655z = valueCallback;
            try {
                Intent createIntent = fileChooserParams.createIntent();
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                int a = MimeTypeUtils.m946a(acceptTypes);
                if (acceptTypes.length > 1) {
                    createIntent.setType("*/*");
                    createIntent.putExtra("android.intent.extra.MIME_TYPES", acceptTypes);
                } else if (a > 0) {
                    createIntent.setType(acceptTypes[0]);
                }
                String str = (String) fileChooserParams.getTitle();
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.ik);
                }
                startActivityForResult(Intent.createChooser(createIntent, str), 111);
            } catch (Exception unused) {
            }
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: h */
    public void m2277B1(String str, String str2, String str3, String str4, long j) {
        String str5;
        String str6;
        boolean c = WebAdressUtils.m2251c(str);
        if (!c && this.f1616f0.mo395q(this.f1605a, str)) {
            return;
        }
        if (!AppUtils.m2065m(this.f1605a, 2)) {
            this.f1648v0 = new RunnableC0571q0(this, str, str2, str3, str4, j);
            return;
        }
        if (c) {
            str5 = UUID.randomUUID() + "." + str.substring(11, str.indexOf(";base64,"));
            str6 = str4;
        } else {
            str6 = str4;
            str5 = DownloaderUtils.m938a(str, str3, str6);
        }
        if (ChannelUtils.m2107b("vmos") && str5.endsWith(".apk")) {
            str6 = "application/vnd.android.package-archive";
        }
        String[] strArr = {str3, str6};
        TaoDialog g = TaoDialog.m1134g(this.f1605a);
        g.mo620L(R.string.cq);
        g.mo636n(false);
        g.mo629d(0, str5, "", 1);
        g.mo614F(17039370, new C0578x(this, c, str, str2, strArr));
        g.mo648z(17039360, null);
        g.mo610B(R.string.i, new View$OnClickListenerC0574t(this, str));
        EditText j2 = g.mo633j(0);
        j2.setOnFocusChangeListener(new View$OnFocusChangeListenerC0557j0(j2));
        if (j >= 0 || c) {
            g.mo641s(CompatUtils.m1336f(this.f1605a, R.string.dj) + ": " + BrowserUtils.m2091l(j));
        } else {
            BrowserApp.m1389c().execute(new RunnableC0538a(this, str, strArr, g, j2));
        }
        g.mo622N();
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: i */
    public boolean mo852i(View view, MotionEvent motionEvent) {
        this.f1614e0.onTouchEvent(motionEvent);
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (this.f1575H0 && ((FastView) view).mo785a()) {
            z = true;
        }
        this.f1573G0 = z;
        if (this.f1571F0 == null) {
            GestureTouchEvent bVar = new GestureTouchEvent();
            bVar.mo1294e(this.f1588O);
            bVar.mo1293d(new C0521j());
            this.f1571F0 = bVar;
        }
        return this.f1571F0.mo1291b(view, motionEvent);
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: j */
    public void mo853j(int i) {
        int i2 = i + 20;
        this.f1592Q.mo1300f(i2);
        if (i2 >= 100) {
            m2432s3();
        } else {
            m2435t3();
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: k */
    public void mo854k() {
        TabItem b0Var = this.f1623j;
        if (b0Var != null) {
            String L = b0Var.mo817L();
            String K = this.f1623j.mo816K();
            if (TextUtils.isEmpty(L)) {
                L = K;
            }
            int r0 = this.f1635p.mo1182r0();
            if (r0 == 0 || BrowserUtils.m2101v(this.f1607b, L) || (BrowserUtils.m2105z(L) && r0 == 2)) {
                if (!TextUtils.isEmpty(K)) {
                    this.f1619h.setHint(K);
                }
            } else if (r0 == 1 || r0 == 2) {
                this.f1619h.setHint(r0 == 1 ? L : BrowserUtils.m2093n(L, true));
            }
            boolean startsWith = L.startsWith("https://");
            if (this.f1640r0.compareAndSet(!startsWith, startsWith)) {
                this.f1647v.setImageResource(startsWith ? R.drawable.af : R.drawable.ar);
            }
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: l */
    public void mo855l(WebView webView) {
        this.f1636p0.mo1216a(webView);
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: m */
    public void mo856m(WebView webView) {
        this.f1636p0.mo1217b(webView);
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: n */
    public void mo857n() {
        if (this.f1641s == null || this.f1645u == null || this.f1623j == null) {
            WebChromeClient.CustomViewCallback customViewCallback = this.f1645u;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                } catch (Exception unused) {
                }
                this.f1645u = null;
                return;
            }
            return;
        }
        Timber.m971a("onHideCustomView", new Object[0]);
        setRequestedOrientation(this.f1642s0);
        this.f1615f.setVisibility(0);
        this.f1641s.setKeepScreenOn(false);
        FrameLayout frameLayout = this.f1643t;
        if (frameLayout != null) {
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f1643t);
            }
            this.f1643t.removeAllViews();
        }
        m2428r3(this.f1635p.mo1068C(), false);
        this.f1643t = null;
        this.f1641s = null;
        try {
            this.f1645u.onCustomViewHidden();
        } catch (Exception unused2) {
        }
        this.f1645u = null;
        if (this.f1582L.getVisibility() == 8 && this.f1586N.getVisibility() == 8 && this.f1635p.mo1205z() == 2) {
            ViewUtils.m2219F(this.f1576I, null);
        }
        if (getResources().getConfiguration().orientation != this.f1644t0) {
            m2418o3();
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: o */
    public Object mo858o() {
        if (this.f1599U == null) {
            this.f1599U = new BrowserJsCallback(this, null);
        }
        return this.f1599U;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 911) {
            if (intent != null && intent.hasExtra("data")) {
                String stringExtra = intent.getStringExtra("data");
                TaoDialog g = TaoDialog.m1134g(this.f1607b);
                g.mo620L(R.string.cr);
                g.mo645w(stringExtra);
                g.mo636n(false);
                g.mo614F(17039370, new C0545d0(this, stringExtra));
                g.mo648z(17039360, null);
                g.mo610B(R.string.l, new View$OnClickListenerC0563m0(this, stringExtra));
                g.mo622N();
            }
        } else if (i == 101) {
            if (intent != null && intent.getData() != null) {
                BrowserApp.m1388b().execute(new RunnableC0558k(this, FileCompat.m1350d(this.f1607b, intent.getData())));
            }
        } else if (i != 111) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                ValueCallback<Uri[]> valueCallback = this.f1655z;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
                }
            } else if (this.f1637q != null) {
                this.f1637q.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.f1637q = null;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i == 2 || i == 1) {
            GestureTouchEvent bVar = this.f1571F0;
            if (bVar != null) {
                bVar.mo1292c();
            }
            if (this.f1641s == null) {
                m2418o3();
            }
        }
        m2298G3();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        DaggerBrowserComponent.C0449b b = DaggerBrowserComponent.m1674b();
        b.mo1031a(BrowserApp.m1387a(this).f1192a);
        b.mo1032b(new BrowserModule());
        b.mo1033c().mo1023a(this);
        super.onCreate(bundle);
        this.f1605a = this;
        this.f1607b = this;
        this.f1635p = PreferenceManager.m1743M(this);
        DataChecker c = DataChecker.m1181c();
        this.f1624j0 = c;
        c.mo665f(this.f1635p.mo1187t());
        this.f1624j0.mo666g(1, this.f1635p.mo1175p());
        Activity activity = this.f1605a;
        boolean Z = this.f1635p.mo1129Z(this.f1607b);
        this.f1630m0 = Z;
        ViewUtils.m2238p(activity, Z);
        setContentView(R.layout.c);
        GlobalConf.m1915a(this.f1607b);
        m2413n1();
        m2434t1();
        m2430s1();
        m2416o1();
        getWindow().getDecorView().post(new RunnableC0568p(this));
        m2409m1();
        Timber.m971a("BrowserActivity open, time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f1635p.mo1098M0(DataChecker.m1181c().mo663d(1));
        this.f1615f.removeAllViews();
        for (TabItem b0Var : this.f1609c) {
            if (b0Var != null) {
                b0Var.mo829k0();
            }
        }
        this.f1623j = null;
        this.f1609c.clear();
        BrowserUtils.m2088i(this.f1646u0);
        this.f1633o.close();
        unregisterReceiver(this.f1564C);
        this.f1616f0.mo394p(this.f1607b);
        if (this.f1579J0) {
            ViewUtils.m2244v(this.f1608b0, this.f1577I0);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Timber.m971a("onKeyDown, keyCode: %s", Integer.valueOf(i));
        if (i == 4) {
            m2348U2();
            return true;
        } else if (i == 62) {
            BrowserUtils.m2077H(this.f1623j.mo818N(), keyEvent.isShiftPressed() ? 2 : 3);
            return true;
        } else if (i != 24) {
            if (i != 25) {
                return super.onKeyDown(i, keyEvent);
            }
            if (this.f1643t == null && this.f1641s == null && m2351V2()) {
                return true;
            }
            return false;
        } else if (this.f1643t == null && this.f1641s == null && m2355W2()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        int i2 = Build.VERSION.SDK_INT;
        Timber.m971a("onKeyShortcut, keyCode: %s", Integer.valueOf(i));
        int i3 = 11;
        if (i != 3) {
            if (i != 32) {
                if (i != 40) {
                    if (i != 51) {
                        if (i != 61) {
                            if (i == 84) {
                                m2379d3(4);
                                return true;
                            } else if (i == 135) {
                                m2379d3(1);
                                return true;
                            } else if (i == 21 || i == 22) {
                                if (i2 >= 11 && keyEvent.isAltPressed()) {
                                    m2379d3(i == 21 ? 12 : 13);
                                    return true;
                                }
                            } else if (i != 34) {
                                int i4 = 16;
                                if (i != 35) {
                                    switch (i) {
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                            if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                m2282C3(i == 16 ? this.f1609c.size() - 1 : i - 8);
                                                return true;
                                            }
                                        default:
                                            switch (i) {
                                                case 46:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(1);
                                                        return true;
                                                    }
                                                case 47:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(18);
                                                        return true;
                                                    }
                                                case 48:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(5);
                                                        return true;
                                                    }
                                                case 49:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(19);
                                                        return true;
                                                    }
                                            }
                                            break;
                                    }
                                } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                    if (!keyEvent.isShiftPressed()) {
                                        i4 = 17;
                                    }
                                    m2379d3(i4);
                                    return true;
                                }
                            } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                m2379d3(14);
                                return true;
                            }
                        } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                            if (keyEvent.isShiftPressed()) {
                                i3 = 10;
                            }
                            m2379d3(i3);
                            return true;
                        }
                    } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                        m2379d3(9);
                        return true;
                    }
                } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                    m2379d3(4);
                    return true;
                }
            } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                m2379d3(6);
                return true;
            }
        } else if (i2 >= 11 && keyEvent.isAltPressed()) {
            m2392h1();
            return true;
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2 = Build.VERSION.SDK_INT;
        Timber.m971a("onKeyUp, keyCode: %s", Integer.valueOf(i));
        int i3 = 11;
        if (i != 3) {
            if (i != 32) {
                if (i != 40) {
                    if (i != 51) {
                        if (i != 61) {
                            if (i == 84) {
                                m2379d3(4);
                                return true;
                            } else if (i == 135) {
                                m2379d3(1);
                                return true;
                            } else if (i == 21 || i == 22) {
                                if (i2 >= 11 && keyEvent.isAltPressed()) {
                                    m2379d3(i == 21 ? 12 : 13);
                                    return true;
                                }
                            } else if (i == 24 || i == 25) {
                                if (this.f1643t == null && this.f1641s == null) {
                                    return true;
                                }
                                return false;
                            } else if (i != 34) {
                                int i4 = 16;
                                if (i != 35) {
                                    switch (i) {
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                            if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                m2282C3(i == 16 ? this.f1609c.size() - 1 : i - 8);
                                                return true;
                                            }
                                        default:
                                            switch (i) {
                                                case 46:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(1);
                                                        return true;
                                                    }
                                                case 47:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(18);
                                                        return true;
                                                    }
                                                case 48:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(5);
                                                        return true;
                                                    }
                                                case 49:
                                                    if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                                        m2379d3(19);
                                                        return true;
                                                    }
                                            }
                                            break;
                                    }
                                } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                    if (!keyEvent.isShiftPressed()) {
                                        i4 = 17;
                                    }
                                    m2379d3(i4);
                                    return true;
                                }
                            } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                                m2379d3(14);
                                return true;
                            }
                        } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                            if (keyEvent.isShiftPressed()) {
                                i3 = 10;
                            }
                            m2379d3(i3);
                            return true;
                        }
                    } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                        m2379d3(9);
                        return true;
                    }
                } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                    m2379d3(4);
                    return true;
                }
            } else if (i2 >= 11 && keyEvent.isCtrlPressed()) {
                m2379d3(6);
                return true;
            }
        } else if (i2 >= 11 && keyEvent.isAltPressed()) {
            m2392h1();
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        if (this.f1601W == 1) {
            m2274A3();
        }
        m2461z3(3);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            String o = BrowserUtils.m2094o(intent, this.f1629m);
            if (!TextUtils.isEmpty(o)) {
                m2395i1(o);
                this.f1596S.set(BrowserUtils.m2070A(intent));
            }
            super.onNewIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f1583L0) {
            AppUtils.m2057e(this.f1607b, this.f1615f);
        }
        m2411m3();
        this.f1628l0.mo1258l();
        int i = this.f1620h0;
        if (i > 0) {
            this.f1635p.mo1111Q1(i);
            this.f1635p.mo1134b(this.f1622i0);
            this.f1620h0 = 0;
            this.f1622i0 = 0;
        }
        this.f1596S.set(false);
        TabItem b0Var = this.f1623j;
        if (b0Var != null) {
            b0Var.mo830l0();
            this.f1623j.mo832n0();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (!AppUtils.m2062j(this.f1607b, i, iArr) && this.f1648v0 != null && strArr.length > 0 && "android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[0])) {
            this.f1648v0.run();
            this.f1648v0 = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        TabItem b0Var = this.f1623j;
        if (b0Var != null) {
            b0Var.mo835q0();
            this.f1623j.mo831m0();
            if (this.f1641s == null) {
                m2416o1();
                mo854k();
                mo853j(this.f1623j.mo815J());
                m2365Z2();
                m2390g3();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f1618g0 = true;
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f1618g0 = false;
        this.f1635p.mo1107P0(DataChecker.m1181c().mo662b());
        super.onStop();
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: p */
    public void mo859p(WebView webView, String str) {
        this.f1636p0.mo1218c(webView, str);
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: q */
    public WebResourceResponse mo860q(WebView webView, WebResourceRequest webResourceRequest, String str, String str2) {
        if (str != null && str.endsWith("via_inject_blocker.css")) {
            String c = this.f1632n0.mo7c(str);
            if (c == null) {
                return Blocker.f7b;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse("text/css", "UTF-8", new ByteArrayInputStream(c.getBytes(Charset.forName("UTF-8"))));
            if (Build.VERSION.SDK_INT >= 21) {
                HashMap hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-cache");
                hashMap.put("Access-Control-Allow-Origin", "*");
                webResourceResponse.setResponseHeaders(hashMap);
            }
            return webResourceResponse;
        } else if (!m2451x3(webResourceRequest, str, str2)) {
            return null;
        } else {
            String t = BrowserUtils.m2099t(str);
            if (!t.isEmpty() && !"html|htm|css|js".contains(t)) {
                try {
                    return new WebResourceResponse("image/gif", "UTF-8", this.f1607b.getAssets().open("ph.gif"));
                } catch (IOException unused) {
                }
            }
            return Blocker.f7b;
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: r */
    public boolean mo861r(WebView webView) {
        int i;
        if (webView == null || !webView.getSettings().getJavaScriptEnabled()) {
            return false;
        }
        String url = webView.getUrl();
        if (BrowserUtils.m2105z(url)) {
            return false;
        }
        String n = BrowserUtils.m2093n(url, false);
        if (TextUtils.isEmpty(n)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        if (ConfUtil.m2116c(n) && URLUtil.isNetworkUrl(url)) {
            sb.append(JSUtils.m2183a(n));
        }
        if (ConfUtil.m2114a(n) && !"music.163.com".equals(n) && !"taobao.com".equals(n)) {
            sb.append("if(document&&!document.getElementById('via_inject_custom_meta')){var meta=document.createElement('meta');meta.id='via_inject_custom_meta';meta.setAttribute('name','viewport');meta.setAttribute('content','minimum-scale=0.1, initial-scale=0.1, maximum-scale=10, user-scalable=yes');var o=document.getElementsByTagName('head');if(o.length>0&&o[0].appendChild(meta)){document.body.style.zoom=1}}");
        }
        if (this.f1635p.mo1127Y() && this.f1635p.mo1129Z(this.f1607b)) {
            sb.append("if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);var o=document.getElementsByTagName(\"head\");if(o.length>0&&o[0].appendChild(css)){}};");
        }
        if (sb.length() > 0) {
            WebViewUtil.m2048h(webView, "javascript:" + sb.toString().trim());
            i = 0;
        } else {
            i = -1;
        }
        String x = this.f1633o.mo998x(n);
        if (!TextUtils.isEmpty(x)) {
            WebViewUtil.m2048h(webView, "javascript:" + x);
            i++;
        }
        if (i > -1) {
            return true;
        }
        return false;
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: s */
    public void mo862s(String str, String str2) {
        if (!this.f1635p.mo1095L()) {
            HistoryHelper.m1734a(this.f1607b, str2, str);
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: t */
    public boolean mo863t(String str) {
        if (str.contains("mailto:")) {
            if (MailTo.isMailTo(str)) {
                MailTo parse = MailTo.parse(str);
                try {
                    this.f1605a.startActivity(IntentUtils.m2174a(parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
                } catch (Exception e) {
                    Timber.m973c(e);
                }
            }
            return true;
        } else if (str.startsWith("tel:")) {
            try {
                this.f1605a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
            return true;
        } else if (str.startsWith("magnet:") || str.startsWith("intent://")) {
            IntentUtils.m2178e(this.f1605a, str);
            return true;
        } else if (str.startsWith("folder://")) {
            String substring = str.substring(9);
            Timber.m971a("open bookmark page", new Object[0]);
            m2372b3(substring.isEmpty() ? 2 : 11, substring);
            return true;
        } else if (str.startsWith("history://")) {
            m2369a3(3);
            return true;
        } else if (str.startsWith("v://")) {
            int a = PageUtil.m2188a(str);
            if (a != 1) {
                m2369a3(a);
            } else {
                m2392h1();
            }
            return true;
        } else if (str.startsWith("thunder://") || str.startsWith("qqdl://") || str.startsWith("flashget://")) {
            String r = BrowserUtils.m2097r(str);
            if (!TextUtils.isEmpty(r)) {
                m2277B1(r, GlobalConf.f1417q, "attachment", null, -1);
            }
            return true;
        } else if (WebAdressUtils.m2251c(str)) {
            m2277B1(str, GlobalConf.f1417q, "attachment", null, -1);
            return true;
        } else if (str.startsWith("tg:")) {
            if (!str.startsWith("tg://")) {
                str = "tg://" + str.substring(str.indexOf("tg:") + 3);
            }
            IntentUtils.m2178e(this.f1605a, str);
            return true;
        } else if (str.startsWith("baidubox://")) {
            return true;
        } else {
            if (str.startsWith("https://greasyfork.org/scripts/") && str.endsWith("user.js")) {
                TaoDialog g = TaoDialog.m1134g(this.f1607b);
                g.mo620L(R.string.aq);
                g.mo628c(0, "", R.string.h1, 1);
                g.mo628c(1, JS.m1589c(str), R.string.h0, 1);
                g.mo636n(false);
                g.mo614F(17039370, new C0566o(this));
                g.mo622N();
                return false;
            } else if (str.startsWith("file://") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://") || str.startsWith("javascript:") || str.startsWith("about:") || str.startsWith("folder://") || str.startsWith("data:") || str.startsWith("tg:") || str.startsWith("view-source:") || !str.contains("://")) {
                return false;
            } else {
                IntentUtils.m2178e(this.f1605a, str);
                return true;
            }
        }
    }

    @Override // mark.via.browser.TabItem.AbstractC0409b
    /* renamed from: u */
    public void mo864u(boolean z) {
        if (this.f1612d0 && z != this.f1595R0) {
            this.f1578J.post(new RunnableC0530s(z));
        }
    }
}
