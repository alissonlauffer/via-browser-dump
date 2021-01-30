package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.u0 */
/* compiled from: lambda */
public final /* synthetic */ class C0670u0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ OperationSettings f1987a;

    /* renamed from: b */
    public final /* synthetic */ int f1988b;

    public /* synthetic */ C0670u0(OperationSettings operationSettings, int i) {
        this.f1987a = operationSettings;
        this.f1988b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1987a.mo1504i(this.f1988b, adapterView, view, i, j);
    }
}
