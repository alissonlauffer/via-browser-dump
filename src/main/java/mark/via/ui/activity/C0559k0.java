package mark.via.ui.activity;

import android.view.View;
import android.webkit.WebView;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.activity.k0 */
/* compiled from: lambda */
public final /* synthetic */ class C0559k0 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1746a;

    /* renamed from: b */
    public final /* synthetic */ WebView f1747b;

    public /* synthetic */ C0559k0(BrowserActivity browserActivity, WebView webView) {
        this.f1746a = browserActivity;
        this.f1747b = webView;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1746a.mo1341A2(this.f1747b, view, lVar);
    }
}
