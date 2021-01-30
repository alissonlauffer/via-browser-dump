package mark.via.ui.activity;

import android.view.View;
import android.widget.AdapterView;
import mark.via.ui.activity.BrowserActivity;

/* renamed from: mark.via.ui.activity.d */
/* compiled from: lambda */
public final /* synthetic */ class C0544d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity.View$OnClickListenerC0529r f1712a;

    /* renamed from: b */
    public final /* synthetic */ View f1713b;

    public /* synthetic */ C0544d(BrowserActivity.View$OnClickListenerC0529r rVar, View view) {
        this.f1712a = rVar;
        this.f1713b = view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1712a.mo1412d(this.f1713b, adapterView, view, i, j);
    }
}
