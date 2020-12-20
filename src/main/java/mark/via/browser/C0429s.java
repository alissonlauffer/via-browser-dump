package mark.via.browser;

import android.view.View;
import android.webkit.SslErrorHandler;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.browser.TabItem;

/* renamed from: mark.via.browser.s */
/* compiled from: lambda */
public final /* synthetic */ class C0429s implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ SslErrorHandler f1253a;

    public /* synthetic */ C0429s(SslErrorHandler sslErrorHandler) {
        this.f1253a = sslErrorHandler;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        TabItem.C0412e.m1516e(this.f1253a, view, lVar);
    }
}
