package mark.via.ui.activity;

import android.os.Message;
import mark.via.browser.TabItem;

/* renamed from: mark.via.ui.activity.v */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0576v implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Message f1779a;

    /* renamed from: b */
    public final /* synthetic */ TabItem f1780b;

    public /* synthetic */ RunnableC0576v(Message message, TabItem b0Var) {
        this.f1779a = message;
        this.f1780b = b0Var;
    }

    public final void run() {
        BrowserActivity.m2455y2(this.f1779a, this.f1780b);
    }
}
