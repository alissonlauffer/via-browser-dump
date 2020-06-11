package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.o0 */
/* compiled from: lambda */
public final /* synthetic */ class C0652o0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1952a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1953b;

    /* renamed from: c */
    public final /* synthetic */ int f1954c;

    public /* synthetic */ C0652o0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1952a = generalSettings;
        this.f1953b = bVar;
        this.f1954c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1952a.mo1496z0(this.f1953b, this.f1954c, adapterView, view, i, j);
    }
}
