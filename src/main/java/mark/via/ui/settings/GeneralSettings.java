package mark.via.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.settings.OnFrogSettingsClickListener;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FileCompat;
import mark.lib.frogsupport.util.IOUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.LogUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.constants.Constants;
import mark.via.flurry.FlurryHelper;
import mark.via.gp.R;
import mark.via.manager.BookmarkManager;
import mark.via.utils.AppUtils;
import mark.via.utils.BrowserUtils;
import mark.via.utils.FileUtils;
import mark.via.utils.InfoUtils;
import mark.via.utils.ViewUtils;
import mark.via.utils.WebAdressUtils;
import org.json.JSONObject;
import p016e.p017a.p018a.Downloader;

public class GeneralSettings extends BaseSettings {

    /* renamed from: d */
    private BookmarkManager f1811d;

    /* renamed from: e */
    private FrogSettings f1812e;

    /* renamed from: f */
    private String[][] f1813f = ((String[][]) Array.newInstance(String.class, 0, 0));

    /* renamed from: g */
    private int f1814g = 0;

    /* renamed from: h */
    private OnFrogSettingsClickListener f1815h = new C0586a();

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.GeneralSettings$a */
    public class C0586a implements OnFrogSettingsClickListener {
        C0586a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void mo1497c(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
            GeneralSettings.this.f1803c.mo1079F1(i2 + 1);
            DataChecker.m1181c().mo667h(158);
            bVar.mo761i(CompatUtils.m1338h(((BaseActivity) GeneralSettings.this).f1039b, R.array.l, i2));
            GeneralSettings.this.f1812e.mo749m(i, bVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void mo1498e(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
            GeneralSettings.this.f1803c.mo1067B1(i2 + 1);
            bVar.mo761i(CompatUtils.m1338h(((BaseActivity) GeneralSettings.this).f1039b, R.array.j, i2));
            GeneralSettings.this.f1812e.mo749m(i, bVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void mo1499g(FrogSettingsBean bVar, int i, View view, TaoDialog.C0384l lVar) {
            if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
                GeneralSettings.this.f1803c.mo1113R0(lVar.f1091c[0].replace("/", "").trim());
                bVar.mo761i(FileUtils.m2149e(lVar.f1091c[0]));
                GeneralSettings.this.f1812e.mo749m(i, bVar);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void mo1500i(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
            GeneralSettings.this.f1803c.mo1091J1(i2);
            bVar.mo761i(CompatUtils.m1338h(((BaseActivity) GeneralSettings.this).f1039b, R.array.n, i2));
            GeneralSettings.this.f1812e.mo749m(i, bVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void mo1501k(AdapterView adapterView, View view, int i, long j) {
            if (i == 0) {
                GeneralSettings.this.m2664M();
            } else if (i == 1) {
                FileCompat.m1353g(((BaseActivity) GeneralSettings.this).f1038a, "text/html", 186);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void mo1502m(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
            GeneralSettings.this.f1803c.mo1207z1(i2);
            bVar.mo761i(CompatUtils.m1338h(((BaseActivity) GeneralSettings.this).f1039b, R.array.i, i2));
            GeneralSettings.this.f1812e.mo749m(i, bVar);
            if (i2 != 0) {
                QuickUtils.m1382n(((BaseActivity) GeneralSettings.this).f1039b, R.string.gy);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void mo1503o(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
            GeneralSettings generalSettings = GeneralSettings.this;
            generalSettings.f1803c.mo1116S0(generalSettings.f1813f[0][i2]);
            bVar.mo761i(GeneralSettings.this.f1813f[1][i2]);
            GeneralSettings.this.f1812e.mo749m(i, bVar);
        }

        @Override // mark.lib.frogsupport.settings.OnFrogSettingsClickListener
        /* renamed from: a */
        public void mo764a(FrogSettingsBean bVar, int i) {
            switch (bVar.mo754b()) {
                case R.string.as /* 2131558455 */:
                    TaoDialog g = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g.mo620L(R.string.as);
                    g.mo619K(GeneralSettings.this.f1813f[1], GeneralSettings.this.f1814g, new C0684z(this, bVar, i));
                    g.mo622N();
                    return;
                case R.string.at /* 2131558456 */:
                    FlurryHelper.m1681a().mo1041j("ua");
                    GeneralSettings.this.m2657H(bVar, i);
                    return;
                case R.string.b_ /* 2131558473 */:
                    GeneralSettings.this.startActivity(new Intent(((BaseActivity) GeneralSettings.this).f1039b, AdBlockUI.class));
                    return;
                case R.string.bm /* 2131558486 */:
                    FlurryHelper.m1681a().mo1041j("clear_data");
                    GeneralSettings.this.m2662K();
                    return;
                case R.string.bn /* 2131558487 */:
                    FlurryHelper.m1681a().mo1041j("clear_data_exit");
                    GeneralSettings.this.m2663L();
                    return;
                case R.string.bq /* 2131558490 */:
                    FlurryHelper.m1681a().mo1041j("color_mode");
                    GeneralSettings.this.f1803c.mo1104O0(bVar.mo757e());
                    return;
                case R.string.cz /* 2131558536 */:
                    FlurryHelper.m1681a().mo1041j("download_dir");
                    String v = GeneralSettings.this.f1803c.mo1193v();
                    if (Build.VERSION.SDK_INT >= 21) {
                        QuickUtils.m1379k(((BaseActivity) GeneralSettings.this).f1039b, R.string.cz, FileUtils.m2149e(v));
                        return;
                    }
                    TaoDialog g2 = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g2.mo621M(FileUtils.m2148d());
                    g2.mo631f(v, "", 1);
                    g2.mo614F(17039370, new C0609a0(this, bVar, i));
                    g2.mo622N();
                    return;
                case R.string.dg /* 2131558554 */:
                    GeneralSettings.this.m2666O();
                    return;
                case R.string.ds /* 2131558566 */:
                    FlurryHelper.m1681a().mo1041j("bar_hide");
                    GeneralSettings.this.m2668Q(bVar, i);
                    return;
                case R.string.ea /* 2131558585 */:
                    FlurryHelper.m1681a().mo1041j("homepage");
                    GeneralSettings.this.m2670S(bVar, i);
                    return;
                case R.string.ek /* 2131558595 */:
                    FlurryHelper.m1681a().mo1041j("data_import");
                    FileCompat.m1353g(((BaseActivity) GeneralSettings.this).f1038a, "text/plain", 188);
                    return;
                case R.string.en /* 2131558598 */:
                    FlurryHelper.m1681a().mo1041j("bookmark_backup");
                    TaoDialog g3 = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g3.mo620L(R.string.en);
                    g3.mo643u(new String[]{((BaseActivity) GeneralSettings.this).f1039b.getString(R.string.df), ((BaseActivity) GeneralSettings.this).f1039b.getString(R.string.eh)}, new C0681y(this));
                    g3.mo622N();
                    return;
                case R.string.ge /* 2131558663 */:
                    FlurryHelper.m1681a().mo1041j("orientation");
                    TaoDialog g4 = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g4.mo620L(R.string.ge);
                    g4.mo618J(R.array.j, GeneralSettings.this.f1803c.mo1149g0() - 1, new C0678x(this, bVar, i));
                    g4.mo622N();
                    return;
                case R.string.gw /* 2131558681 */:
                    FlurryHelper.m1681a().mo1041j("restore_tabs");
                    TaoDialog g5 = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g5.mo620L(R.string.gw);
                    g5.mo618J(R.array.i, GeneralSettings.this.f1803c.mo1140d0(), new C0616c0(this, bVar, i));
                    g5.mo622N();
                    return;
                case R.string.h2 /* 2131558687 */:
                    FlurryHelper.m1681a().mo1041j("search");
                    GeneralSettings.this.m2656G0(bVar, i);
                    return;
                case R.string.he /* 2131558700 */:
                    FlurryHelper.m1681a().mo1041j("cloud");
                    GeneralSettings.this.startActivity(new Intent(((BaseActivity) GeneralSettings.this).f1039b, AccountSettings.class));
                    return;
                case R.string.hg /* 2131558702 */:
                    FlurryHelper.m1681a().mo1041j("operation");
                    GeneralSettings.this.startActivity(new Intent(((BaseActivity) GeneralSettings.this).f1039b, OperationSettings.class));
                    return;
                case R.string.ht /* 2131558715 */:
                    FlurryHelper.m1681a().mo1041j("font_size");
                    TaoDialog g6 = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g6.mo620L(R.string.ht);
                    g6.mo618J(R.array.l, GeneralSettings.this.f1803c.mo1170n0() - 1, new C0675w(this, bVar, i));
                    g6.mo622N();
                    return;
                case R.string.iy /* 2131558757 */:
                    FlurryHelper.m1681a().mo1041j("layout");
                    GeneralSettings.this.m2660I0(bVar, i);
                    return;
                case R.string.je /* 2131558774 */:
                    FlurryHelper.m1681a().mo1041j("urlbar_content");
                    TaoDialog g7 = TaoDialog.m1134g(((BaseActivity) GeneralSettings.this).f1039b);
                    g7.mo620L(R.string.je);
                    g7.mo618J(R.array.n, GeneralSettings.this.f1803c.mo1182r0(), new C0613b0(this, bVar, i));
                    g7.mo622N();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void mo1476B0(FrogSettingsBean bVar, int i, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
            String f = WebAdressUtils.m2254f(lVar.f1091c[0]);
            if (f.contains("://")) {
                this.f1803c.mo1073D1(0);
                this.f1803c.mo1076E1(f);
                bVar.mo761i(CompatUtils.m1336f(this.f1039b, R.string.c5));
                this.f1812e.mo749m(i, bVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void mo1477D0(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
        this.f1803c.mo1085H1(i2);
        bVar.mo761i(CompatUtils.m1338h(this.f1039b, R.array.m, i2));
        this.f1812e.mo749m(i, bVar);
    }

    /* renamed from: E0 */
    private void m2652E0() {
        String[][] d = Downloader.m919e(this.f1039b).mo384d(this.f1038a);
        this.f1813f = d;
        d[1][0] = CompatUtils.m1336f(this.f1039b, R.string.id);
        String w = this.f1803c.mo1196w();
        int length = this.f1813f[0].length;
        for (int i = 0; i < length; i++) {
            if (w.equals(this.f1813f[0][i])) {
                this.f1814g = i;
            }
        }
    }

    /* renamed from: F0 */
    private void m2654F0() {
        DataChecker.m1181c().mo667h(2);
    }

    /* renamed from: G */
    private void m2655G(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.av);
        g.mo636n(false);
        g.mo631f(this.f1803c.mo1188t0(""), getString(R.string.in), 3);
        g.mo614F(17039370, new C0646m0(this, bVar, i));
        g.mo648z(17039360, null);
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: G0 */
    private void m2656G0(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.h2);
        g.mo618J(R.array.k, this.f1803c.mo1155i0(), new C0652o0(this, bVar, i));
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: H */
    private void m2657H(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.at);
        g.mo618J(R.array.o, this.f1803c.mo1185s0() - 1, new C0655p0(this, bVar, i));
        g.mo622N();
    }

    /* renamed from: H0 */
    private void m2658H0(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.c5);
        g.mo630e(this.f1803c.mo1158j0(), R.string.c5, 3);
        g.mo614F(17039370, new C0667t0(this, bVar, i));
        g.mo622N();
    }

    /* renamed from: I */
    private List<FrogSettingsBean> m2659I() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.he));
        Context context = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context, R.string.at, CompatUtils.m1338h(context, R.array.o, this.f1803c.mo1185s0() - 1)));
        arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.bm));
        if (Build.VERSION.SDK_INT >= 11) {
            arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.b_));
        }
        Context context2 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context2, R.string.ds, CompatUtils.m1338h(context2, R.array.d, this.f1803c.mo1205z())));
        Context context3 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context3, R.string.iy, CompatUtils.m1338h(context3, R.array.m, this.f1803c.mo1176p0())));
        int F = this.f1803c.mo1077F();
        arrayList.add(FrogSettingsBean.m1295n(this.f1039b, R.string.ea, F == 3 ? this.f1803c.mo1071D() : CompatUtils.m1338h(this.f1039b, R.array.e, F)));
        Context context4 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context4, R.string.h2, CompatUtils.m1338h(context4, R.array.k, this.f1803c.mo1155i0())));
        Context context5 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context5, R.string.ht, CompatUtils.m1338h(context5, R.array.l, this.f1803c.mo1170n0() - 1)));
        Context context6 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context6, R.string.ge, CompatUtils.m1338h(context6, R.array.j, this.f1803c.mo1149g0() - 1)));
        arrayList.add(FrogSettingsBean.m1295n(this.f1039b, R.string.cz, FileUtils.m2149e(this.f1803c.mo1193v())));
        m2652E0();
        arrayList.add(FrogSettingsBean.m1295n(this.f1039b, R.string.as, this.f1813f[1][this.f1814g]));
        Context context7 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context7, R.string.je, CompatUtils.m1338h(context7, R.array.n, this.f1803c.mo1182r0())));
        arrayList.add(FrogSettingsBean.m1294m(this.f1039b, R.string.bq, R.string.br, this.f1803c.mo1184s()));
        arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.bn));
        arrayList.add(FrogSettingsBean.m1293l(this.f1039b, R.string.hg, R.string.g5));
        arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.en));
        arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.ek));
        arrayList.add(FrogSettingsBean.m1292k(this.f1039b, R.string.dg));
        Context context8 = this.f1039b;
        arrayList.add(FrogSettingsBean.m1295n(context8, R.string.gw, CompatUtils.m1338h(context8, R.array.i, this.f1803c.mo1140d0())));
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: I0 */
    private void m2660I0(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.iy);
        g.mo618J(R.array.m, this.f1803c.mo1176p0(), new C0664s0(this, bVar, i));
        g.mo622N();
    }

    /* renamed from: J */
    private View m2661J() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.hf);
        g.mo734k(R.string.cg);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo742d(m2659I());
        j.mo748l(this.f1815h);
        j.mo744g();
        this.f1812e = j;
        return LayoutUtils.m1365c(p, j.mo750o());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: K */
    private void m2662K() {
        int n = this.f1803c.mo1169n();
        int[] iArr = new int[10];
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            if (((1 << i2) & n) != 0) {
                iArr[i] = i2;
                i++;
            }
        }
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.bm);
        g.mo646x(R.array.c, Arrays.copyOf(iArr, i));
        g.mo614F(17039370, new C0619d0(this));
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: L */
    private void m2663L() {
        int o = this.f1803c.mo1172o();
        int[] iArr = new int[10];
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            if (((1 << i2) & o) != 0) {
                iArr[i] = i2;
                i++;
            }
        }
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.bn);
        g.mo646x(R.array.c, Arrays.copyOf(iArr, i));
        g.mo614F(17039370, new C0622e0(this));
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: M */
    private void m2664M() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Constants.f1296a);
        Date date = new Date(System.currentTimeMillis());
        String str = this.f1039b.getResources().getString(R.string.b3) + "_" + this.f1039b.getResources().getString(R.string.bg) + "_" + simpleDateFormat.format(date);
        if (Build.VERSION.SDK_INT < 19) {
            String h = FileUtils.m2152h(str, FileUtils.m2146b(this.f1039b), ".html");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(new File(h));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            m2665N(fileOutputStream, h);
            return;
        }
        FileCompat.m1347a(this.f1038a, str + ".html", "text/html", 185);
    }

    /* renamed from: N */
    private void m2665N(OutputStream outputStream, String str) {
        BrowserApp.m1388b().execute(new RunnableC0643l0(this, outputStream, str));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: O */
    private void m2666O() {
        FlurryHelper.m1681a().mo1041j("data_export");
        if (Build.VERSION.SDK_INT < 19) {
            String h = FileUtils.m2152h(CompatUtils.m1336f(this.f1039b, R.string.b3) + "_" + CompatUtils.m1336f(this.f1039b, R.string.c_), FileUtils.m2146b(this.f1039b), ".txt");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(new File(h));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            m2667P(fileOutputStream, h);
            return;
        }
        FileCompat.m1347a(this.f1038a, CompatUtils.m1336f(this.f1039b, R.string.b3) + "_" + CompatUtils.m1336f(this.f1039b, R.string.c_) + ".txt", "text/plain", 187);
    }

    /* renamed from: P */
    private void m2667P(OutputStream outputStream, String str) {
        BrowserApp.m1388b().execute(new RunnableC0631h0(this, outputStream, str));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: Q */
    private void m2668Q(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.ds);
        g.mo618J(R.array.d, this.f1803c.mo1205z(), new C0634i0(this, bVar, i));
        g.mo622N();
    }

    /* renamed from: R */
    private void m2669R(FrogSettingsBean bVar, int i) {
        String D = this.f1803c.mo1077F() == 3 ? this.f1803c.mo1071D() : Constants.f1302g;
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.ig);
        g.mo631f(D, CompatUtils.m1336f(this.f1039b, R.string.ig), 3);
        g.mo614F(17039370, new C0672v(this, bVar, i));
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: S */
    private void m2670S(FrogSettingsBean bVar, int i) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.ea);
        g.mo618J(R.array.e, this.f1803c.mo1077F(), new C0625f0(this, bVar, i));
        g.mo622N();
    }

    /* renamed from: T */
    private boolean m2671T(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return InfoUtils.m2173l(this.f1039b, sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public /* synthetic */ void mo1478V(FrogSettingsBean bVar, int i, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
            this.f1803c.mo1094K1(6);
            bVar.mo761i(CompatUtils.m1336f(this.f1039b, R.string.av));
            this.f1812e.mo749m(i, bVar);
            this.f1803c.mo1097L1(lVar.f1091c[0]);
            DataChecker.m1181c().mo667h(158);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void mo1479X(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
        if (i2 == 5) {
            m2655G(bVar, i);
            return;
        }
        this.f1803c.mo1094K1(i2 + 1);
        DataChecker.m1181c().mo667h(158);
        bVar.mo761i(CompatUtils.m1338h(this.f1039b, R.array.o, i2));
        this.f1812e.mo749m(i, bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void mo1480Z(View view, TaoDialog.C0384l lVar) {
        int i;
        int[] iArr = lVar.f1089a;
        if (iArr == null || iArr.length <= 0) {
            i = 0;
        } else {
            i = 0;
            for (int i2 : iArr) {
                i += 1 << i2;
            }
            if ((i & 1) != 0) {
                BrowserUtils.m2084e(this.f1039b);
                BrowserUtils.m2082c(this.f1039b);
                this.f1803c.mo1114R1();
            }
            if ((i & 2) != 0) {
                BrowserUtils.m2086g(this.f1039b);
            }
            if ((i & 4) != 0) {
                BrowserUtils.m2087h(this.f1039b);
                DataChecker.m1181c().mo667h(3);
            }
            if ((i & 8) != 0) {
                BrowserUtils.m2083d();
            }
            if ((i & 16) != 0) {
                BrowserUtils.m2085f(this.f1039b);
            }
            if ((i & 31) != 0) {
                QuickUtils.m1384p(this.f1039b, getResources().getString(R.string.c7));
            }
        }
        LogUtils.m1368a("Value: " + i);
        this.f1803c.mo1093K0(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void mo1481b0(View view, TaoDialog.C0384l lVar) {
        int i;
        int[] iArr = lVar.f1089a;
        if (iArr == null || iArr.length <= 0) {
            i = 0;
        } else {
            i = 0;
            for (int i2 : iArr) {
                i += 1 << i2;
            }
        }
        LogUtils.m1368a("Value: " + i);
        this.f1803c.mo1096L0(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void mo1482d0(int i, String str) {
        if (i != -1) {
            if (i == 0) {
                QuickUtils.m1382n(this.f1039b, R.string.fp);
            } else if (str == null) {
                QuickUtils.m1382n(this.f1039b, R.string.bf);
            } else {
                Context context = this.f1039b;
                String f = CompatUtils.m1336f(context, R.string.cr);
                QuickUtils.m1380l(context, f, this.f1039b.getString(R.string.bd) + " " + str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void mo1483f0(OutputStream outputStream, String str) {
        runOnUiThread(new RunnableC0649n0(this, this.f1811d.mo1061e(outputStream), str));
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void mo1484h0(String str) {
        if (str != null) {
            Context context = this.f1039b;
            QuickUtils.m1379k(context, R.string.cr, context.getString(R.string.dh, str));
            return;
        }
        QuickUtils.m1382n(this.f1039b, R.string.c9);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: i0 */
    public /* synthetic */ void mo1485j0(OutputStream outputStream, String str) {
        boolean z;
        Throwable th;
        Exception e;
        boolean z2 = false;
        BufferedWriter bufferedWriter = null;
        if (outputStream != null) {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, Constants.f1299d));
                try {
                    bufferedWriter2.write(new JSONObject(InfoUtils.m2163b(this.f1039b, false)).toString());
                    bufferedWriter = bufferedWriter2;
                    z = true;
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e.printStackTrace();
                        IOUtils.m1362a(bufferedWriter);
                        if (z2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.m1362a(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.m1362a(bufferedWriter);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                IOUtils.m1362a(bufferedWriter);
                if (z2) {
                }
            }
        } else {
            z = false;
        }
        IOUtils.m1362a(bufferedWriter);
        z2 = z;
        if (z2) {
            runOnUiThread(new RunnableC0637j0(this, str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void mo1486l0(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
        this.f1803c.mo1124W0(i2);
        DataChecker.m1181c().mo667h(158);
        bVar.mo761i(CompatUtils.m1338h(this.f1039b, R.array.d, i2));
        this.f1812e.mo749m(i, bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void mo1487n0(FrogSettingsBean bVar, int i, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
            String f = WebAdressUtils.m2254f(lVar.f1091c[0]);
            if (f.contains("://")) {
                this.f1803c.mo1139c1(f);
                bVar.mo761i(f);
                DataChecker.m1181c().mo667h(158);
                this.f1812e.mo749m(i, bVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void mo1491p0(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
        if (i2 == 3) {
            m2669R(bVar, i);
            return;
        }
        this.f1803c.mo1139c1(new String[]{"about:home", "about:blank", "about:bookmarks"}[i2]);
        bVar.mo761i(CompatUtils.m1338h(this.f1039b, R.array.e, i2));
        this.f1812e.mo749m(i, bVar);
        DataChecker.m1181c().mo667h(158);
    }

    /* access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void mo1492r0() {
        QuickUtils.m1382n(this.f1039b, R.string.em);
    }

    /* access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void mo1493t0(InputStream inputStream) {
        if (m2671T(inputStream)) {
            runOnUiThread(new RunnableC0628g0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void mo1494v0(int i) {
        if (i > 0) {
            Context context = this.f1039b;
            QuickUtils.m1384p(context, i + " " + this.f1039b.getString(R.string.fd));
            m2654F0();
            return;
        }
        QuickUtils.m1382n(this.f1039b, R.string.ej);
    }

    /* access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void mo1495x0(InputStream inputStream) {
        runOnUiThread(new RunnableC0658q0(this, this.f1811d.mo1060d(inputStream)));
    }

    /* access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void mo1496z0(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
        if (i2 == 0) {
            m2658H0(bVar, i);
            return;
        }
        this.f1803c.mo1073D1(i2);
        bVar.mo761i(CompatUtils.m1338h(this.f1039b, R.array.k, i2));
        this.f1812e.mo749m(i, bVar);
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && (data = intent.getData()) != null) {
            switch (i) {
                case 185:
                case 187:
                    OutputStream e = FileCompat.m1351e(this.f1039b, data);
                    if (i == 187) {
                        m2667P(e, null);
                        return;
                    } else {
                        m2665N(e, null);
                        return;
                    }
                case 186:
                    BrowserApp.m1388b().execute(new RunnableC0640k0(this, FileCompat.m1350d(this.f1039b, data)));
                    return;
                case 188:
                    BrowserApp.m1388b().execute(new RunnableC0661r0(this, FileCompat.m1350d(this.f1039b, data)));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1811d = new BookmarkManager(this.f1039b);
        setContentView(m2661J());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
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
        m2652E0();
    }
}
