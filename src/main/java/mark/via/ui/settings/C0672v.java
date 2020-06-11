package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.v */
/* compiled from: lambda */
public final /* synthetic */ class C0672v implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1991a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1992b;

    /* renamed from: c */
    public final /* synthetic */ int f1993c;

    public /* synthetic */ C0672v(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1991a = generalSettings;
        this.f1992b = bVar;
        this.f1993c = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1991a.mo1487n0(this.f1992b, this.f1993c, view, lVar);
    }
}
