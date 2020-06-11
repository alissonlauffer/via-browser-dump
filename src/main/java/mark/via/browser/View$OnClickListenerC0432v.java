package mark.via.browser;

import android.os.Message;
import android.view.View;

/* renamed from: mark.via.browser.v */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0432v implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ Message f1256a;

    public /* synthetic */ View$OnClickListenerC0432v(Message message) {
        this.f1256a = message;
    }

    public final void onClick(View view) {
        this.f1256a.sendToTarget();
    }
}
