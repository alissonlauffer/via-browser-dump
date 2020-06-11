package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.p0 */
/* compiled from: lambda */
public final /* synthetic */ class C0655p0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1957a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1958b;

    /* renamed from: c */
    public final /* synthetic */ int f1959c;

    public /* synthetic */ C0655p0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1957a = generalSettings;
        this.f1958b = bVar;
        this.f1959c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1957a.mo1479X(this.f1958b, this.f1959c, adapterView, view, i, j);
    }
}
