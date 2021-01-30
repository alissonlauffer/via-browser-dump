package mark.via.ui.activity;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.activity.x */
/* compiled from: lambda */
public final /* synthetic */ class C0578x implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1782a;

    /* renamed from: b */
    public final /* synthetic */ boolean f1783b;

    /* renamed from: c */
    public final /* synthetic */ String f1784c;

    /* renamed from: d */
    public final /* synthetic */ String f1785d;

    /* renamed from: e */
    public final /* synthetic */ String[] f1786e;

    public /* synthetic */ C0578x(BrowserActivity browserActivity, boolean z, String str, String str2, String[] strArr) {
        this.f1782a = browserActivity;
        this.f1783b = z;
        this.f1784c = str;
        this.f1785d = str2;
        this.f1786e = strArr;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1782a.mo1346G1(this.f1783b, this.f1784c, this.f1785d, this.f1786e, view, lVar);
    }
}
