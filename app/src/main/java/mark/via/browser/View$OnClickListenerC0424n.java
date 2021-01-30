package mark.via.browser;

import android.view.View;
import android.webkit.JsPromptResult;

/* renamed from: mark.via.browser.n */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0424n implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ JsPromptResult f1247a;

    public /* synthetic */ View$OnClickListenerC0424n(JsPromptResult jsPromptResult) {
        this.f1247a = jsPromptResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1247a.cancel();
    }
}
