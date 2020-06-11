package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.s0 */
/* compiled from: lambda */
public final /* synthetic */ class C0664s0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1975a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1976b;

    /* renamed from: c */
    public final /* synthetic */ int f1977c;

    public /* synthetic */ C0664s0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1975a = generalSettings;
        this.f1976b = bVar;
        this.f1977c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1975a.mo1477D0(this.f1976b, this.f1977c, adapterView, view, i, j);
    }
}
