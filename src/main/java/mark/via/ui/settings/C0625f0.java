package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.f0 */
/* compiled from: lambda */
public final /* synthetic */ class C0625f0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1895a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1896b;

    /* renamed from: c */
    public final /* synthetic */ int f1897c;

    public /* synthetic */ C0625f0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1895a = generalSettings;
        this.f1896b = bVar;
        this.f1897c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1895a.mo1491p0(this.f1896b, this.f1897c, adapterView, view, i, j);
    }
}
