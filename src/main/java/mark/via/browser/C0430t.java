package mark.via.browser;

import android.os.Message;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.browser.t */
/* compiled from: lambda */
public final /* synthetic */ class C0430t implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ Message f1254a;

    public /* synthetic */ C0430t(Message message) {
        this.f1254a = message;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1254a.sendToTarget();
    }
}
