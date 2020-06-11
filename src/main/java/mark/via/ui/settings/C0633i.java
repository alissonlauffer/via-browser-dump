package mark.via.ui.settings;

import android.view.View;
import android.widget.AdapterView;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.i */
/* compiled from: lambda */
public final /* synthetic */ class C0633i implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ AccountSettings f1912a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1913b;

    /* renamed from: c */
    public final /* synthetic */ int f1914c;

    public /* synthetic */ C0633i(AccountSettings accountSettings, FrogSettingsBean bVar, int i) {
        this.f1912a = accountSettings;
        this.f1913b = bVar;
        this.f1914c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1912a.mo1454h(this.f1913b, this.f1914c, adapterView, view, i, j);
    }
}
