package mark.via.helpers;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.adapter.HistoryItem;
import mark.via.handler.DatabaseHandler;

/* renamed from: mark.via.h.d */
/* compiled from: lambda */
public final /* synthetic */ class C0453d implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ HistoryItem f1354a;

    /* renamed from: b */
    public final /* synthetic */ String f1355b;

    /* renamed from: c */
    public final /* synthetic */ DatabaseHandler f1356c;

    /* renamed from: d */
    public final /* synthetic */ String f1357d;

    /* renamed from: e */
    public final /* synthetic */ Callback f1358e;

    public /* synthetic */ C0453d(HistoryItem bVar, String str, DatabaseHandler bVar2, String str2, Callback mVar) {
        this.f1354a = bVar;
        this.f1355b = str;
        this.f1356c = bVar2;
        this.f1357d = str2;
        this.f1358e = mVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        BookmarkHelper.m1720n(this.f1354a, this.f1355b, this.f1356c, this.f1357d, this.f1358e, view, lVar);
    }
}
