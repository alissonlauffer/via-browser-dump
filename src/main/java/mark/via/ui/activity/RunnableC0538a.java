package mark.via.ui.activity;

import android.widget.EditText;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.activity.a */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0538a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1699a;

    /* renamed from: b */
    public final /* synthetic */ String f1700b;

    /* renamed from: c */
    public final /* synthetic */ String[] f1701c;

    /* renamed from: d */
    public final /* synthetic */ TaoDialog f1702d;

    /* renamed from: e */
    public final /* synthetic */ EditText f1703e;

    public /* synthetic */ RunnableC0538a(BrowserActivity browserActivity, String str, String[] strArr, TaoDialog cVar, EditText editText) {
        this.f1699a = browserActivity;
        this.f1700b = str;
        this.f1701c = strArr;
        this.f1702d = cVar;
        this.f1703e = editText;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1699a.mo1340A1(this.f1700b, this.f1701c, this.f1702d, this.f1703e);
    }
}
