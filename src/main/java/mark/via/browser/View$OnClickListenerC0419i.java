package mark.via.browser;

import android.view.View;
import android.webkit.JsResult;

/* renamed from: mark.via.browser.i */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0419i implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ JsResult f1242a;

    public /* synthetic */ View$OnClickListenerC0419i(JsResult jsResult) {
        this.f1242a = jsResult;
    }

    public final void onClick(View view) {
        this.f1242a.cancel();
    }
}
