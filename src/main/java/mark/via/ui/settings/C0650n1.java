package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.n1 */
/* compiled from: lambda */
public final /* synthetic */ class C0650n1 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1950a;

    public /* synthetic */ C0650n1(SubscribedFiltersUI subscribedFiltersUI) {
        this.f1950a = subscribedFiltersUI;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1950a.mo1550s(adapterView, view, i, j);
    }
}
