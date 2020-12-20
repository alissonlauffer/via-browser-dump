package mark.via.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.n.b */
/* compiled from: lambda */
public final /* synthetic */ class C0492b implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ Context f1511a;

    /* renamed from: b */
    public final /* synthetic */ Intent f1512b;

    public /* synthetic */ C0492b(Context context, Intent intent) {
        this.f1511a = context;
        this.f1512b = intent;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        BrowserUtils.m2073D(this.f1511a, this.f1512b, view, lVar);
    }
}
