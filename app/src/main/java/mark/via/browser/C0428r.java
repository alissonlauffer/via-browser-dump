package mark.via.browser;

import android.view.View;
import android.webkit.HttpAuthHandler;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.browser.TabItem;

/* renamed from: mark.via.browser.r */
/* compiled from: lambda */
public final /* synthetic */ class C0428r implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ HttpAuthHandler f1252a;

    public /* synthetic */ C0428r(HttpAuthHandler httpAuthHandler) {
        this.f1252a = httpAuthHandler;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        TabItem.C0412e.m1514c(this.f1252a, view, lVar);
    }
}
