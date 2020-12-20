package mark.via.browser;

import android.view.View;
import android.webkit.GeolocationPermissions;

/* renamed from: mark.via.browser.g */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0417g implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeolocationPermissions.Callback f1239a;

    /* renamed from: b */
    public final /* synthetic */ String f1240b;

    public /* synthetic */ View$OnClickListenerC0417g(GeolocationPermissions.Callback callback, String str) {
        this.f1239a = callback;
        this.f1240b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1239a.invoke(this.f1240b, false, true);
    }
}
