package mark.via.helpers;

import android.content.Context;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.h.k */
/* compiled from: lambda */
public final /* synthetic */ class C0460k implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ Context f1370a;

    /* renamed from: b */
    public final /* synthetic */ Callback f1371b;

    public /* synthetic */ C0460k(Context context, Callback mVar) {
        this.f1370a = context;
        this.f1371b = mVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        HistoryHelper.m1736c(this.f1370a, this.f1371b, view, lVar);
    }
}
