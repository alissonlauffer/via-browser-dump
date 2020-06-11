package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.adapter.AddonItem;
import mark.via.ui.settings.ScriptSettings;

/* renamed from: mark.via.ui.settings.y0 */
/* compiled from: lambda */
public final /* synthetic */ class C0682y0 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ ScriptSettings.C0595e f2008a;

    /* renamed from: b */
    public final /* synthetic */ AddonItem f2009b;

    public /* synthetic */ C0682y0(ScriptSettings.C0595e eVar, AddonItem aVar) {
        this.f2008a = eVar;
        this.f2009b = aVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f2008a.mo1516d(this.f2009b, view, lVar);
    }
}
