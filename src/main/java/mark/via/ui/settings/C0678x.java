package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.via.ui.settings.GeneralSettings;

/* renamed from: mark.via.ui.settings.x */
/* compiled from: lambda */
public final /* synthetic */ class C0678x implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings.C0586a f2001a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f2002b;

    /* renamed from: c */
    public final /* synthetic */ int f2003c;

    public /* synthetic */ C0678x(GeneralSettings.C0586a aVar, FrogSettingsBean bVar, int i) {
        this.f2001a = aVar;
        this.f2002b = bVar;
        this.f2003c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2001a.mo1498e(this.f2002b, this.f2003c, adapterView, view, i, j);
    }
}
