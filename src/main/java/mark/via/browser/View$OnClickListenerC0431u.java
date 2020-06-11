package mark.via.browser;

import android.view.View;
import android.webkit.SslErrorHandler;

/* renamed from: mark.via.browser.u */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0431u implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ SslErrorHandler f1255a;

    public /* synthetic */ View$OnClickListenerC0431u(SslErrorHandler sslErrorHandler) {
        this.f1255a = sslErrorHandler;
    }

    public final void onClick(View view) {
        this.f1255a.cancel();
    }
}
