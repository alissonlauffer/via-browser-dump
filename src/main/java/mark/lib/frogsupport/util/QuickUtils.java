package mark.lib.frogsupport.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.toast.FrogToast;
import mark.lib.frogsupport.toast.OnFrogToastListener;

/* renamed from: mark.lib.frogsupport.p.g */
/* compiled from: QuickUtils */
public class QuickUtils {

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.p.g$a */
    /* compiled from: QuickUtils */
    public class RunnableC0402a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1186a;

        /* renamed from: b */
        final /* synthetic */ String f1187b;

        /* renamed from: c */
        final /* synthetic */ String f1188c;

        /* renamed from: d */
        final /* synthetic */ OnFrogToastListener f1189d;

        RunnableC0402a(Context context, String str, String str2, OnFrogToastListener cVar) {
            this.f1186a = context;
            this.f1187b = str;
            this.f1188c = str2;
            this.f1189d = cVar;
        }

        public void run() {
            QuickUtils.m1372d(this.f1186a, this.f1187b, this.f1188c, this.f1189d);
        }
    }

    /* renamed from: b */
    public static void m1370b(Context context, String str, int i) {
        m1371c(context, str, CompatUtils.m1336f(context, i));
    }

    /* renamed from: c */
    public static void m1371c(Context context, String str, String str2) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                ClipData newPlainText = ClipData.newPlainText(null, str.trim());
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(newPlainText);
                }
            } else {
                android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) context.getSystemService("clipboard");
                if (clipboardManager2 != null) {
                    clipboardManager2.setText(str.trim());
                }
            }
            if (str2 != null && !str2.isEmpty()) {
                m1384p(context, str2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m1372d(Context context, String str, String str2, OnFrogToastListener cVar) {
        new FrogToast((Activity) context, str, str2, cVar).mo773m();
    }

    /* renamed from: e */
    public static String m1373e(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                if (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip().getItemAt(0).getText() == null) {
                    return "";
                }
                return clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
            }
            android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager2 == null || !clipboardManager2.hasText() || clipboardManager2.getText() == null) {
                return "";
            }
            return clipboardManager2.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    public static void m1374f(Context context, int i, int i2, TaoDialog.AbstractC0382j jVar) {
        m1377i(context, CompatUtils.m1336f(context, i), CompatUtils.m1336f(context, i2), jVar, null);
    }

    /* renamed from: g */
    public static void m1375g(Context context, int i, String str, TaoDialog.AbstractC0382j jVar) {
        m1377i(context, CompatUtils.m1336f(context, i), str, jVar, null);
    }

    /* renamed from: h */
    public static void m1376h(Context context, String str, String str2, TaoDialog.AbstractC0382j jVar) {
        m1377i(context, str, str2, jVar, null);
    }

    /* renamed from: i */
    public static void m1377i(Context context, String str, String str2, TaoDialog.AbstractC0382j jVar, View.OnClickListener onClickListener) {
        TaoDialog g = TaoDialog.m1134g(context);
        g.mo621M(str);
        g.mo645w(str2);
        g.mo614F(17039370, jVar);
        g.mo648z(17039360, onClickListener);
        g.mo622N();
    }

    /* renamed from: j */
    public static void m1378j(Context context, int i, int i2) {
        m1380l(context, CompatUtils.m1336f(context, i), CompatUtils.m1336f(context, i2));
    }

    /* renamed from: k */
    public static void m1379k(Context context, int i, String str) {
        m1380l(context, CompatUtils.m1336f(context, i), str);
    }

    /* renamed from: l */
    public static void m1380l(Context context, String str, String str2) {
        m1381m(context, str, str2, null);
    }

    /* renamed from: m */
    public static void m1381m(Context context, String str, String str2, TaoDialog.AbstractC0382j jVar) {
        TaoDialog g = TaoDialog.m1134g(context);
        g.mo621M(str);
        g.mo645w(str2);
        g.mo614F(17039370, jVar);
        g.mo622N();
    }

    /* renamed from: n */
    public static void m1382n(Context context, int i) {
        m1385q(context, context.getResources().getString(i), null, null);
    }

    /* renamed from: o */
    public static void m1383o(Context context, int i, int i2, OnFrogToastListener cVar) {
        m1385q(context, CompatUtils.m1336f(context, i), CompatUtils.m1336f(context, i2), cVar);
    }

    /* renamed from: p */
    public static void m1384p(Context context, String str) {
        m1385q(context, str, null, null);
    }

    /* renamed from: q */
    public static void m1385q(Context context, String str, String str2, OnFrogToastListener cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m1372d(context, str, str2, cVar);
        } else {
            ((Activity) context).runOnUiThread(new RunnableC0402a(context, str, str2, cVar));
        }
    }
}
