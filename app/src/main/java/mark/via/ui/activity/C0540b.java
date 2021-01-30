package mark.via.ui.activity;

import android.view.View;
import android.widget.AdapterView;
import mark.via.ui.activity.BrowserActivity;

/* renamed from: mark.via.ui.activity.b */
/* compiled from: lambda */
public final /* synthetic */ class C0540b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity.C0513c f1707a;

    /* renamed from: b */
    public final /* synthetic */ String[][] f1708b;

    public /* synthetic */ C0540b(BrowserActivity.C0513c cVar, String[][] strArr) {
        this.f1707a = cVar;
        this.f1708b = strArr;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1707a.mo1401d(this.f1708b, adapterView, view, i, j);
    }
}
