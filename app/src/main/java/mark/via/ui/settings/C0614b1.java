package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.via.adapter.AddonItem;

/* renamed from: mark.via.ui.settings.b1 */
/* compiled from: lambda */
public final /* synthetic */ class C0614b1 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ ScriptSettings f1879a;

    /* renamed from: b */
    public final /* synthetic */ AddonItem f1880b;

    public /* synthetic */ C0614b1(ScriptSettings scriptSettings, AddonItem aVar) {
        this.f1879a = scriptSettings;
        this.f1880b = aVar;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1879a.mo1510D(this.f1880b, view, lVar);
    }
}
