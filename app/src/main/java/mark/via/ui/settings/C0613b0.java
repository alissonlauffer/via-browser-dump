package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.via.ui.settings.GeneralSettings;

/* renamed from: mark.via.ui.settings.b0 */
/* compiled from: lambda */
public final /* synthetic */ class C0613b0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings.C0586a f1876a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1877b;

    /* renamed from: c */
    public final /* synthetic */ int f1878c;

    public /* synthetic */ C0613b0(GeneralSettings.C0586a aVar, FrogSettingsBean bVar, int i) {
        this.f1876a = aVar;
        this.f1877b = bVar;
        this.f1878c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1876a.mo1500i(this.f1877b, this.f1878c, adapterView, view, i, j);
    }
}
