package mark.via.ui.settings;

import p000a.p001a.p002a.filter.FilterSubscription;

/* renamed from: mark.via.ui.settings.p1 */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0656p1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1960a;

    /* renamed from: b */
    public final /* synthetic */ FilterSubscription f1961b;

    /* renamed from: c */
    public final /* synthetic */ int f1962c;

    public /* synthetic */ RunnableC0656p1(SubscribedFiltersUI subscribedFiltersUI, FilterSubscription cVar, int i) {
        this.f1960a = subscribedFiltersUI;
        this.f1961b = cVar;
        this.f1962c = i;
    }

    public final void run() {
        this.f1960a.mo1543C(this.f1961b, this.f1962c);
    }
}
