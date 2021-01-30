package mark.via.ui.activity;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.helpers.FileLoggingHelper;

/* renamed from: mark.via.ui.activity.g */
/* compiled from: lambda */
public final /* synthetic */ class C0550g implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1724a;

    /* renamed from: b */
    public final /* synthetic */ FileLoggingHelper f1725b;

    public /* synthetic */ C0550g(BrowserActivity browserActivity, FileLoggingHelper nVar) {
        this.f1724a = browserActivity;
        this.f1725b = nVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1724a.mo1354O2(this.f1725b, view, lVar);
    }
}
