package mark.via.helpers;

import android.content.Context;
import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.handler.DatabaseHandler;

/* renamed from: mark.via.h.b */
/* compiled from: lambda */
public final /* synthetic */ class C0451b implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ String f1346a;

    /* renamed from: b */
    public final /* synthetic */ DatabaseHandler f1347b;

    /* renamed from: c */
    public final /* synthetic */ Context f1348c;

    /* renamed from: d */
    public final /* synthetic */ Callback f1349d;

    public /* synthetic */ C0451b(String str, DatabaseHandler bVar, Context context, Callback mVar) {
        this.f1346a = str;
        this.f1347b = bVar;
        this.f1348c = context;
        this.f1349d = mVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        BookmarkHelper.m1712f(this.f1346a, this.f1347b, this.f1348c, this.f1349d, view, lVar);
    }
}
