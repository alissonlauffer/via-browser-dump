package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.settings.FrogSettingsBean;

/* renamed from: mark.via.ui.settings.m0 */
/* compiled from: lambda */
public final /* synthetic */ class C0646m0 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ GeneralSettings f1938a;

    /* renamed from: b */
    public final /* synthetic */ FrogSettingsBean f1939b;

    /* renamed from: c */
    public final /* synthetic */ int f1940c;

    public /* synthetic */ C0646m0(GeneralSettings generalSettings, FrogSettingsBean bVar, int i) {
        this.f1938a = generalSettings;
        this.f1939b = bVar;
        this.f1940c = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1938a.mo1478V(this.f1939b, this.f1940c, view, lVar);
    }
}
