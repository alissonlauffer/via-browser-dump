package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.via.ui.settings.GeneralSettings;

/* renamed from: mark.via.ui.settings.z */
/* compiled from: lambda */
public final /* synthetic */ class C0684z implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings.C0586a f2012a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f2013b;

    /* renamed from: c */
    public final /* synthetic */ int f2014c;

    public /* synthetic */ C0684z(GeneralSettings.C0586a aVar, FrogSettingsBean bVar, int i) {
        this.f2012a = aVar;
        this.f2013b = bVar;
        this.f2014c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2012a.mo1503o(this.f2013b, this.f2014c, adapterView, view, i, j);
    }
}
