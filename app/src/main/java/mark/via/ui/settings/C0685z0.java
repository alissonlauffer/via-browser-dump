package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.via.ui.settings.ScriptSettings;

/* renamed from: mark.via.ui.settings.z0 */
/* compiled from: lambda */
public final /* synthetic */ class C0685z0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ ScriptSettings.C0595e f2015a;

    /* renamed from: b */
    public final /* synthetic */ int f2016b;

    public /* synthetic */ C0685z0(ScriptSettings.C0595e eVar, int i) {
        this.f2015a = eVar;
        this.f2016b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2015a.mo1517f(this.f2016b, adapterView, view, i, j);
    }
}
