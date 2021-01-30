package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.via.ui.settings.GeneralSettings;

/* renamed from: mark.via.ui.settings.w */
/* compiled from: lambda */
public final /* synthetic */ class C0675w implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings.C0586a f1996a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1997b;

    /* renamed from: c */
    public final /* synthetic */ int f1998c;

    public /* synthetic */ C0675w(GeneralSettings.C0586a aVar, FrogSettingsBean bVar, int i) {
        this.f1996a = aVar;
        this.f1997b = bVar;
        this.f1998c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1996a.mo1497c(this.f1997b, this.f1998c, adapterView, view, i, j);
    }
}
