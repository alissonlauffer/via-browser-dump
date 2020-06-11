package mark.via.browser;

import android.view.View;
import android.webkit.JsResult;

/* renamed from: mark.via.browser.l */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0422l implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ JsResult f1245a;

    public /* synthetic */ View$OnClickListenerC0422l(JsResult jsResult) {
        this.f1245a = jsResult;
    }

    public final void onClick(View view) {
        this.f1245a.cancel();
    }
}
