package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.y1 */
/* compiled from: lambda */
public final /* synthetic */ class C0683y1 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ ViewFiltersUI f2010a;

    /* renamed from: b */
    public final /* synthetic */ int f2011b;

    public /* synthetic */ C0683y1(ViewFiltersUI viewFiltersUI, int i) {
        this.f2010a = viewFiltersUI;
        this.f2011b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2010a.mo1557i(this.f2011b, adapterView, view, i, j);
    }
}
