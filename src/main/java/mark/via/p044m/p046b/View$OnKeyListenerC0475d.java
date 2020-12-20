package mark.via.p044m.p046b;

import android.view.KeyEvent;
import android.view.View;
import mark.via.p042l.p043d.SiteConf;

/* renamed from: mark.via.m.b.d */
/* compiled from: lambda */
public final /* synthetic */ class View$OnKeyListenerC0475d implements View.OnKeyListener {

    /* renamed from: a */
    public final /* synthetic */ SiteConfSlice f1432a;

    /* renamed from: b */
    public final /* synthetic */ SiteConf f1433b;

    public /* synthetic */ View$OnKeyListenerC0475d(SiteConfSlice iVar, SiteConf dVar) {
        this.f1432a = iVar;
        this.f1433b = dVar;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return this.f1432a.mo1268o(this.f1433b, view, i, keyEvent);
    }
}
