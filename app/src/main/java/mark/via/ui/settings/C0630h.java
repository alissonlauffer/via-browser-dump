package mark.via.ui.settings;

import android.view.View;
import java.util.Map;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.settings.h */
/* compiled from: lambda */
public final /* synthetic */ class C0630h implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ AccountSettings f1902a;

    /* renamed from: b */
    public final /* synthetic */ Map f1903b;

    public /* synthetic */ C0630h(AccountSettings accountSettings, Map map) {
        this.f1902a = accountSettings;
        this.f1903b = map;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1902a.mo1458r(this.f1903b, view, lVar);
    }
}
