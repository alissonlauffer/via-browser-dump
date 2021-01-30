package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.settings.n */
/* compiled from: lambda */
public final /* synthetic */ class C0648n implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ CustomFiltersUI f1943a;

    /* renamed from: b */
    public final /* synthetic */ boolean f1944b;

    /* renamed from: c */
    public final /* synthetic */ String f1945c;

    /* renamed from: d */
    public final /* synthetic */ int f1946d;

    public /* synthetic */ C0648n(CustomFiltersUI customFiltersUI, boolean z, String str, int i) {
        this.f1943a = customFiltersUI;
        this.f1944b = z;
        this.f1945c = str;
        this.f1946d = i;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1943a.mo1473x(this.f1944b, this.f1945c, this.f1946d, view, lVar);
    }
}
