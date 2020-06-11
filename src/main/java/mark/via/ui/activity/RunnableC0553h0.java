package mark.via.ui.activity;

import android.widget.EditText;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.activity.h0 */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0553h0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ String f1732a;

    /* renamed from: b */
    public final /* synthetic */ TaoDialog f1733b;

    /* renamed from: c */
    public final /* synthetic */ EditText f1734c;

    /* renamed from: d */
    public final /* synthetic */ String f1735d;

    public /* synthetic */ RunnableC0553h0(String str, TaoDialog cVar, EditText editText, String str2) {
        this.f1732a = str;
        this.f1733b = cVar;
        this.f1734c = editText;
        this.f1735d = str2;
    }

    public final void run() {
        BrowserActivity.m2454y1(this.f1732a, this.f1733b, this.f1734c, this.f1735d);
    }
}
