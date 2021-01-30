package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.u1 */
/* compiled from: lambda */
public final /* synthetic */ class C0671u1 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1989a;

    /* renamed from: b */
    public final /* synthetic */ int f1990b;

    public /* synthetic */ C0671u1(SubscribedFiltersUI subscribedFiltersUI, int i) {
        this.f1989a = subscribedFiltersUI;
        this.f1990b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1989a.mo1552w(this.f1990b, adapterView, view, i, j);
    }
}
