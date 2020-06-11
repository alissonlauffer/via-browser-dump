package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.k */
/* compiled from: lambda */
public final /* synthetic */ class C0639k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ CustomFiltersUI f1924a;

    /* renamed from: b */
    public final /* synthetic */ int f1925b;

    public /* synthetic */ C0639k(CustomFiltersUI customFiltersUI, int i) {
        this.f1924a = customFiltersUI;
        this.f1925b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1924a.mo1471t(this.f1925b, adapterView, view, i, j);
    }
}
