package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.o1 */
/* compiled from: lambda */
public final /* synthetic */ class C0653o1 implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1955a;

    public /* synthetic */ C0653o1(SubscribedFiltersUI subscribedFiltersUI) {
        this.f1955a = subscribedFiltersUI;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        return this.f1955a.mo1553y(adapterView, view, i, j);
    }
}
