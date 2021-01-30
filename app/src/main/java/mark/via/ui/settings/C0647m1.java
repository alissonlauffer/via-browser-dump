package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.settings.m1 */
/* compiled from: lambda */
public final /* synthetic */ class C0647m1 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1941a;

    /* renamed from: b */
    public final /* synthetic */ int f1942b;

    public /* synthetic */ C0647m1(SubscribedFiltersUI subscribedFiltersUI, int i) {
        this.f1941a = subscribedFiltersUI;
        this.f1942b = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1941a.mo1551u(this.f1942b, view, lVar);
    }
}
