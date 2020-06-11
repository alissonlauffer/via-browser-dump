package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.i0 */
/* compiled from: lambda */
public final /* synthetic */ class C0634i0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1915a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1916b;

    /* renamed from: c */
    public final /* synthetic */ int f1917c;

    public /* synthetic */ C0634i0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1915a = generalSettings;
        this.f1916b = bVar;
        this.f1917c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1915a.mo1486l0(this.f1916b, this.f1917c, adapterView, view, i, j);
    }
}
