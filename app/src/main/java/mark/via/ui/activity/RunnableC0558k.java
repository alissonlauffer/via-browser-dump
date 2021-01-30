package mark.via.ui.activity;

import java.io.InputStream;

/* renamed from: mark.via.ui.activity.k */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0558k implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1744a;

    /* renamed from: b */
    public final /* synthetic */ InputStream f1745b;

    public /* synthetic */ RunnableC0558k(BrowserActivity browserActivity, InputStream inputStream) {
        this.f1744a = browserActivity;
        this.f1745b = inputStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1744a.mo1384t2(this.f1745b);
    }
}
