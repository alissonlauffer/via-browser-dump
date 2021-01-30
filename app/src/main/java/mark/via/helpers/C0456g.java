package mark.via.helpers;

import android.content.Context;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.h.g */
/* compiled from: lambda */
public final /* synthetic */ class C0456g implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ Context f1364a;

    /* renamed from: b */
    public final /* synthetic */ String f1365b;

    /* renamed from: c */
    public final /* synthetic */ Callback f1366c;

    public /* synthetic */ C0456g(Context context, String str, Callback mVar) {
        this.f1364a = context;
        this.f1365b = str;
        this.f1366c = mVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        BookmarkHelper.m1719m(this.f1364a, this.f1365b, this.f1366c, view, lVar);
    }
}
