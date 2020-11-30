package mark.via.helpers;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.adapter.HistoryItem;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;
import mark.via.utils.ArrayUtils;
import mark.via.utils.BrowserUtils;
import mark.via.utils.WebAdressUtils;
import timber.log.Timber;

/* renamed from: mark.via.h.l */
/* compiled from: BookmarkHelper */
public class BookmarkHelper {
    /* renamed from: a */
    public static void m1707a(Context context, String str, String str2, String str3, Callback mVar) {
        if (str == null || BrowserUtils.m2103x(context, str, null)) {
            str = "http://";
            str2 = "";
        }
        DatabaseHandler v = DatabaseHandler.m1595v(context);
        String[] u = v.mo996u();
        TaoDialog g = TaoDialog.m1134g(context);
        g.mo620L(R.string.RES_2131558400);
        g.mo636n(false);
        g.mo628c(0, str2, R.string.RES_2131558581, 1);
        g.mo628c(1, str, R.string.RES_2131558582, 1);
        g.mo628c(2, "", R.string.RES_2131558578, 1);
        g.mo637o(R.string.RES_2131558401, false);
        g.mo614F(17039370, new C0451b(str3, v, context, mVar));
        g.mo648z(17039360, null);
        g.mo622N();
        if (u.length > 0) {
            m1708b(context, g, g.mo633j(2), u);
        }
    }

    /* renamed from: b */
    private static void m1708b(Context context, TaoDialog cVar, EditText editText, String[] strArr) {
        String[] strArr2 = {"/", context.getString(R.string.RES_2131558426)};
        editText.setFocusable(false);
        editText.setInputType(0);
        editText.setOnClickListener(new View$OnClickListenerC0455f(cVar, context, (String[]) ArrayUtils.m2069a(strArr2, strArr), editText));
    }

    /* renamed from: c */
    public static void m1709c(Context context, String str) {
        DatabaseHandler.m1595v(context).mo980g(str);
        DataChecker.m1181c().mo667h(2);
    }

    /* renamed from: d */
    public static void m1710d(Context context, String str, Callback mVar) {
        QuickUtils.m1381m(context, context.getResources().getString(R.string.RES_2131558631), CompatUtils.m1337g(context, R.string.RES_2131558515, str), new C0456g(context, str, mVar));
    }

    /* renamed from: e */
    public static void m1711e(Context context, String str, String str2, Callback mVar) {
        DatabaseHandler v = DatabaseHandler.m1595v(context);
        HistoryItem q = v.mo992q(str);
        String g = q.mo941g();
        String[] u = v.mo996u();
        TaoDialog g2 = TaoDialog.m1134g(context);
        g2.mo620L(R.string.RES_2131558740);
        g2.mo636n(false);
        g2.mo628c(0, q.mo940f(), R.string.RES_2131558581, 1);
        g2.mo628c(1, q.mo941g(), R.string.RES_2131558582, 1);
        g2.mo626a(2, q.mo934b(), R.string.RES_2131558578, u);
        g2.mo614F(17039370, new C0453d(q, str2, v, g, mVar));
        g2.mo648z(17039360, null);
        g2.mo622N();
        if (u.length > 0) {
            m1708b(context, g2, g2.mo633j(2), u);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m1712f(String str, DatabaseHandler bVar, Context context, Callback mVar, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 2)) {
            String g = WebAdressUtils.m2255g(lVar.f1091c[1], str);
            String[] strArr = lVar.f1091c;
            bVar.mo971G(new HistoryItem(g, strArr[0], strArr[2]), true);
            if (lVar.f1090b) {
                bVar.mo972H(bVar.mo992q(g), true);
                DataChecker.m1181c().mo667h(1);
            }
            QuickUtils.m1382n(context, R.string.RES_2131558616);
            DataChecker.m1181c().mo667h(2);
            if (mVar != null) {
                mVar.mo1052a();
            }
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m1714h(EditText editText, View view, TaoDialog.C0384l lVar) {
        String str;
        if (lVar != null) {
            String[] strArr = lVar.f1091c;
            if (strArr.length >= 1) {
                str = strArr[0];
                editText.setText(str);
            }
        }
        str = "";
        editText.setText(str);
    }

    /* renamed from: i */
    static /* synthetic */ void m1715i(EditText editText, TaoDialog cVar, Context context, String[] strArr, AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            editText.setText("");
            cVar.mo622N();
        } else if (i == 1) {
            TaoDialog g = TaoDialog.m1134g(context);
            g.mo620L(R.string.RES_2131558426);
            g.mo630e("", R.string.RES_2131558578, 1);
            g.mo613E(new DialogInterface$OnDismissListenerC0457h(cVar));
            g.mo614F(17039370, new C0458i(editText));
            g.mo648z(17039360, null);
            g.mo636n(false);
            g.mo622N();
        } else {
            editText.setText(strArr[i]);
            cVar.mo622N();
        }
    }

    /* renamed from: l */
    static /* synthetic */ void m1718l(TaoDialog cVar, Context context, String[] strArr, EditText editText, View view) {
        Timber.m971a("Click edittext", new Object[0]);
        cVar.mo632i();
        TaoDialog g = TaoDialog.m1134g(context);
        g.mo620L(R.string.RES_2131558578);
        g.mo643u(strArr, new C0452c(editText, cVar, context, strArr));
        g.mo614F(17039360, new C0454e(cVar));
        g.mo612D(new DialogInterface$OnCancelListenerC0459j(cVar));
        g.mo636n(false);
        g.mo622N();
    }

    /* renamed from: m */
    static /* synthetic */ void m1719m(Context context, String str, Callback mVar, View view, TaoDialog.C0384l lVar) {
        DatabaseHandler.m1595v(context).mo981h(str);
        DataChecker.m1181c().mo667h(2);
        if (mVar != null) {
            mVar.mo1052a();
        }
    }

    /* renamed from: n */
    static /* synthetic */ void m1720n(HistoryItem bVar, String str, DatabaseHandler bVar2, String str2, Callback mVar, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 2)) {
            bVar.mo947l(lVar.f1091c[0]);
            bVar.mo948m(WebAdressUtils.m2255g(lVar.f1091c[1], str));
            bVar.mo942h(lVar.f1091c[2]);
            bVar2.mo980g(str2);
            bVar2.mo971G(bVar, false);
            DataChecker.m1181c().mo667h(2);
            if (mVar != null) {
                mVar.mo1052a();
            }
        }
    }

    /* renamed from: o */
    static /* synthetic */ void m1721o(DatabaseHandler bVar, String str, Callback mVar, View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 1)) {
            bVar.mo969D(str, lVar.f1091c[0]);
            DataChecker.m1181c().mo667h(2);
            if (mVar != null) {
                mVar.mo1052a();
            }
        }
    }

    /* renamed from: p */
    public static void m1722p(Context context, String str, Callback mVar) {
        DatabaseHandler v = DatabaseHandler.m1595v(context);
        String[] u = v.mo996u();
        TaoDialog g = TaoDialog.m1134g(context);
        g.mo620L(R.string.RES_2131558742);
        g.mo626a(0, str, R.string.RES_2131558578, u);
        g.mo614F(17039370, new C0450a(v, str, mVar));
        g.mo622N();
    }
}
