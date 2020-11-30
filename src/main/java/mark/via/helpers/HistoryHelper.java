package mark.via.helpers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;
import mark.via.utils.BrowserUtils;

/* renamed from: mark.via.h.o */
/* compiled from: HistoryHelper */
public class HistoryHelper {

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.h.o$a */
    /* compiled from: HistoryHelper */
    public class RunnableC0463a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1379a;

        /* renamed from: b */
        final /* synthetic */ String f1380b;

        /* renamed from: c */
        final /* synthetic */ String f1381c;

        RunnableC0463a(Context context, String str, String str2) {
            this.f1379a = context;
            this.f1380b = str;
            this.f1381c = str2;
        }

        public void run() {
            try {
                DatabaseHandler.m1595v(this.f1379a).mo973I(this.f1380b, this.f1381c);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.h.o$b */
    /* compiled from: HistoryHelper */
    public class RunnableC0464b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1382a;

        /* renamed from: b */
        final /* synthetic */ String f1383b;

        RunnableC0464b(Context context, String str) {
            this.f1382a = context;
            this.f1383b = str;
        }

        public void run() {
            try {
                DatabaseHandler.m1595v(this.f1382a).mo983j(this.f1383b);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m1734a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.startsWith("file://") && !str.startsWith("view-source:") && !str.startsWith("about:")) {
            BrowserApp.m1389c().execute(new RunnableC0463a(context, str, str2));
            DataChecker.m1181c().mo667h(3);
        }
    }

    /* renamed from: b */
    public static void m1735b(Context context, Callback mVar) {
        QuickUtils.m1374f(context, R.string.RES_2131558413, R.string.RES_2131558530, new C0460k(context, mVar));
    }

    /* renamed from: c */
    static /* synthetic */ void m1736c(Context context, Callback mVar, View view, TaoDialog.C0384l lVar) {
        BrowserUtils.m2087h(context);
        DataChecker.m1181c().mo667h(3);
        if (mVar != null) {
            mVar.mo1052a();
        }
    }

    /* renamed from: d */
    public static void m1737d(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            BrowserApp.m1389c().execute(new RunnableC0464b(context, str));
            DataChecker.m1181c().mo667h(3);
        }
    }
}
