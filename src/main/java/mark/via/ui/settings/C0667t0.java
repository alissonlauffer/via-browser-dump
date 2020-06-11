package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.t0 */
/* compiled from: lambda */
public final /* synthetic */ class C0667t0 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1982a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1983b;

    /* renamed from: c */
    public final /* synthetic */ int f1984c;

    public /* synthetic */ C0667t0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1982a = generalSettings;
        this.f1983b = bVar;
        this.f1984c = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1982a.mo1476B0(this.f1983b, this.f1984c, view, lVar);
    }
}
