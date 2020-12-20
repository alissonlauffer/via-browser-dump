package mark.via.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.n.a */
/* compiled from: lambda */
public final /* synthetic */ class C0491a implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ Context f1509a;

    /* renamed from: b */
    public final /* synthetic */ Intent f1510b;

    public /* synthetic */ C0491a(Context context, Intent intent) {
        this.f1509a = context;
        this.f1510b = intent;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        BrowserUtils.m2074E(this.f1509a, this.f1510b, view, lVar);
    }
}
