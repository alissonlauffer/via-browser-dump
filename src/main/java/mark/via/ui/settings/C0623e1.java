package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.settings.e1 */
/* compiled from: lambda */
public final /* synthetic */ class C0623e1 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ SkinSettings f1893a;

    public /* synthetic */ C0623e1(SkinSettings skinSettings) {
        this.f1893a = skinSettings;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1893a.mo1530p(adapterView, view, i, j);
    }
}
