package mark.via.browser;

import android.view.View;
import android.webkit.GeolocationPermissions;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.browser.TabItem;

/* renamed from: mark.via.browser.o */
/* compiled from: lambda */
public final /* synthetic */ class C0425o implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ GeolocationPermissions.Callback f1248a;

    /* renamed from: b */
    public final /* synthetic */ String f1249b;

    public /* synthetic */ C0425o(GeolocationPermissions.Callback callback, String str) {
        this.f1248a = callback;
        this.f1249b = str;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        TabItem.C0410c.m1502a(this.f1248a, this.f1249b, view, lVar);
    }
}
