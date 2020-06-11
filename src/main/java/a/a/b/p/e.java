package a.a.b.p;

import a.a.b.o.c;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.View;

/* compiled from: QuickUtils */
public class e {

    /* compiled from: QuickUtils */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f44a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ c d;

        a(Context context, String str, String str2, c cVar) {
            this.f44a = context;
            this.b = str;
            this.c = str2;
            this.d = cVar;
        }

        public void run() {
            e.b(this.f44a, this.b, this.c, this.d);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, c cVar) {
        new a.a.b.o.a((Activity) context, str, str2, cVar).h();
    }

    public static void c(Context context, String str, String str2, c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(context, str, str2, cVar);
        } else {
            ((Activity) context).runOnUiThread(new a(context, str, str2, cVar));
        }
    }

    public static void a(Context context, int i) {
        c(context, context.getResources().getString(i), null, null);
    }

    public static void b(Context context, String str, String str2) {
        b(context, str, str2, (View.OnClickListener) null);
    }

    public static void a(Context context, String str) {
        c(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, View.OnClickListener onClickListener) {
        a.a.b.i.c cVar = new a.a.b.i.c(context);
        cVar.b(str);
        a.a.b.i.c cVar2 = cVar;
        cVar2.c(str2);
        ((a.a.b.i.c) cVar2.c(17039370, onClickListener)).g();
    }

    public static void a(Context context, int i, int i2, c cVar) {
        c(context, a.e(context, i), a.e(context, i2), cVar);
    }

    public static void a(Context context, int i, String str) {
        b(context, a.e(context, i), str);
    }

    public static void a(Context context, int i, int i2, View.OnClickListener onClickListener) {
        a(context, a.e(context, i), a.e(context, i2), onClickListener, null);
    }

    public static void a(Context context, String str, String str2, View.OnClickListener onClickListener) {
        a(context, str, str2, onClickListener, null);
    }

    public static void a(Context context, String str, String str2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        a.a.b.i.c cVar = new a.a.b.i.c(context);
        cVar.b(str);
        a.a.b.i.c cVar2 = cVar;
        cVar2.c(str2);
        ((a.a.b.i.c) ((a.a.b.i.c) cVar2.c(17039370, onClickListener)).a(17039360, onClickListener2)).g();
    }

    public static void a(Context context, String str, int i) {
        a(context, str, a.e(context, i));
    }

    public static void a(Context context, String str, String str2) {
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
                a(context, str2);
            }
        }
    }

    public static String a(Context context) {
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
}
