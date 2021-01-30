package mark.via.browser;

/* renamed from: mark.via.browser.d */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0414d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ FastView f1235a;

    /* renamed from: b */
    public final /* synthetic */ String f1236b;

    public /* synthetic */ RunnableC0414d(FastView fastView, String str) {
        this.f1235a = fastView;
        this.f1236b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1235a.loadUrl(this.f1236b);
    }
}
