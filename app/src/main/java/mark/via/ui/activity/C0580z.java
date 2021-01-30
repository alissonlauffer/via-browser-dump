package mark.via.ui.activity;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.adapter.HistoryItem;

/* renamed from: mark.via.ui.activity.z */
/* compiled from: lambda */
public final /* synthetic */ class C0580z implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1789a;

    /* renamed from: b */
    public final /* synthetic */ String f1790b;

    /* renamed from: c */
    public final /* synthetic */ HistoryItem f1791c;

    public /* synthetic */ C0580z(BrowserActivity browserActivity, String str, HistoryItem bVar) {
        this.f1789a = browserActivity;
        this.f1790b = str;
        this.f1791c = bVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1789a.mo1351L1(this.f1790b, this.f1791c, view, lVar);
    }
}
