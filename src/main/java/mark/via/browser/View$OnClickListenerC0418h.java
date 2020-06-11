package mark.via.browser;

import android.view.View;
import android.webkit.JsResult;

/* renamed from: mark.via.browser.h */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0418h implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ JsResult f1241a;

    public /* synthetic */ View$OnClickListenerC0418h(JsResult jsResult) {
        this.f1241a = jsResult;
    }

    public final void onClick(View view) {
        this.f1241a.cancel();
    }
}
