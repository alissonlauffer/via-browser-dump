package mark.via.ui.settings;

import android.view.View;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.ui.settings.j1 */
/* compiled from: lambda */
public final /* synthetic */ class C0638j1 implements TaoDialog.AbstractC0382j {

    /* renamed from: a */
    public final /* synthetic */ SkinSettings f1922a;

    /* renamed from: b */
    public final /* synthetic */ boolean f1923b;

    public /* synthetic */ C0638j1(SkinSettings skinSettings, boolean z) {
        this.f1922a = skinSettings;
        this.f1923b = z;
    }

    @Override // mark.lib.frogsupport.dialog.TaoDialog.AbstractC0382j
    /* renamed from: a */
    public final void mo659a(View view, TaoDialog.C0384l lVar) {
        this.f1922a.mo1523n(this.f1923b, view, lVar);
    }
}
