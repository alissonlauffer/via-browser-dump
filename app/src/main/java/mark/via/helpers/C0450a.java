package mark.via.helpers;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.handler.DatabaseHandler;

/* renamed from: mark.via.h.a */
/* compiled from: lambda */
public final /* synthetic */ class C0450a implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ DatabaseHandler f1343a;

    /* renamed from: b */
    public final /* synthetic */ String f1344b;

    /* renamed from: c */
    public final /* synthetic */ Callback f1345c;

    public /* synthetic */ C0450a(DatabaseHandler bVar, String str, Callback mVar) {
        this.f1343a = bVar;
        this.f1344b = str;
        this.f1345c = mVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        BookmarkHelper.m1721o(this.f1343a, this.f1344b, this.f1345c, view, lVar);
    }
}
