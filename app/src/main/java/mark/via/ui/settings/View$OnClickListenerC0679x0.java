package mark.via.ui.settings;

import android.view.View;
import mark.via.adapter.AddonItem;
import mark.via.ui.settings.ScriptSettings;

/* renamed from: mark.via.ui.settings.x0 */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0679x0 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ScriptSettings.C0595e f2004a;

    /* renamed from: b */
    public final /* synthetic */ AddonItem f2005b;

    public /* synthetic */ View$OnClickListenerC0679x0(ScriptSettings.C0595e eVar, AddonItem aVar) {
        this.f2004a = eVar;
        this.f2005b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2004a.mo1515b(this.f2005b, view);
    }
}
