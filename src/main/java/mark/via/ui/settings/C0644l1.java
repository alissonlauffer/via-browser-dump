package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import p000a.p001a.p002a.filter.FilterSubscription;

/* renamed from: mark.via.ui.settings.l1 */
/* compiled from: lambda */
public final /* synthetic */ class C0644l1 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1933a;

    /* renamed from: b */
    public final /* synthetic */ FilterSubscription f1934b;

    /* renamed from: c */
    public final /* synthetic */ boolean f1935c;

    /* renamed from: d */
    public final /* synthetic */ int f1936d;

    public /* synthetic */ C0644l1(SubscribedFiltersUI subscribedFiltersUI, FilterSubscription cVar, boolean z, int i) {
        this.f1933a = subscribedFiltersUI;
        this.f1934b = cVar;
        this.f1935c = z;
        this.f1936d = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1933a.mo1544E(this.f1934b, this.f1935c, this.f1936d, view, lVar);
    }
}
