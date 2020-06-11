package mark.via.p044m.p046b;

import android.view.View;
import android.widget.AdapterView;
import mark.via.p042l.p043d.SiteConf;

/* renamed from: mark.via.m.b.g */
/* compiled from: lambda */
public final /* synthetic */ class C0478g implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ SiteConfSlice f1438a;

    /* renamed from: b */
    public final /* synthetic */ SiteConf f1439b;

    public /* synthetic */ C0478g(SiteConfSlice iVar, SiteConf dVar) {
        this.f1438a = iVar;
        this.f1439b = dVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1438a.mo1266k(this.f1439b, adapterView, view, i, j);
    }
}
