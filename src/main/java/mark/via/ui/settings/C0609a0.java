package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.via.ui.settings.GeneralSettings;

/* renamed from: mark.via.ui.settings.a0 */
/* compiled from: lambda */
public final /* synthetic */ class C0609a0 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings.C0586a f1870a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1871b;

    /* renamed from: c */
    public final /* synthetic */ int f1872c;

    public /* synthetic */ C0609a0(GeneralSettings.C0586a aVar, FrogSettingsBean bVar, int i) {
        this.f1870a = aVar;
        this.f1871b = bVar;
        this.f1872c = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1870a.mo1499g(this.f1871b, this.f1872c, view, lVar);
    }
}
