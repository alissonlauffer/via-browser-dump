package mark.via.ui.settings;

import p000a.p001a.p002a.filter.FilterSubscription;

/* renamed from: mark.via.ui.settings.s1 */
/* compiled from: lambda */
public final /* synthetic */ class RunnableC0665s1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1978a;

    /* renamed from: b */
    public final /* synthetic */ FilterSubscription f1979b;

    /* renamed from: c */
    public final /* synthetic */ int f1980c;

    public /* synthetic */ RunnableC0665s1(SubscribedFiltersUI subscribedFiltersUI, FilterSubscription cVar, int i) {
        this.f1978a = subscribedFiltersUI;
        this.f1979b = cVar;
        this.f1980c = i;
    }

    public final void run() {
        this.f1978a.mo1542A(this.f1979b, this.f1980c);
    }
}
