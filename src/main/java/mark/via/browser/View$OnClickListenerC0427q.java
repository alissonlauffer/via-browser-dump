package mark.via.browser;

import android.view.View;
import android.webkit.HttpAuthHandler;

/* renamed from: mark.via.browser.q */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0427q implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ HttpAuthHandler f1251a;

    public /* synthetic */ View$OnClickListenerC0427q(HttpAuthHandler httpAuthHandler) {
        this.f1251a = httpAuthHandler;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1251a.cancel();
    }
}
