package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.via.ui.settings.GeneralSettings;

/* renamed from: mark.via.ui.settings.c0 */
/* compiled from: lambda */
public final /* synthetic */ class C0616c0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings.C0586a f1882a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1883b;

    /* renamed from: c */
    public final /* synthetic */ int f1884c;

    public /* synthetic */ C0616c0(GeneralSettings.C0586a aVar, FrogSettingsBean bVar, int i) {
        this.f1882a = aVar;
        this.f1883b = bVar;
        this.f1884c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1882a.mo1502m(this.f1883b, this.f1884c, adapterView, view, i, j);
    }
}
