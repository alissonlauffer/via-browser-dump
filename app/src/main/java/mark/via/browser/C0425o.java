package mark.via.browser;

import android.view.View;
import android.webkit.GeolocationPermissions;
import mark.lib.frogsupport.dialog.TaoDialog;

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
        this.f1248a.invoke(this.f1249b, true, true);
    }
}
