package mark.via.p044m.p046b;

import android.widget.CompoundButton;
import mark.via.p042l.p043d.SiteConf;

/* renamed from: mark.via.m.b.e */
/* compiled from: lambda */
public final /* synthetic */ class C0476e implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    public final /* synthetic */ SiteConfSlice f1434a;

    /* renamed from: b */
    public final /* synthetic */ SiteConf f1435b;

    public /* synthetic */ C0476e(SiteConfSlice iVar, SiteConf dVar) {
        this.f1434a = iVar;
        this.f1435b = dVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1434a.mo1265i(this.f1435b, compoundButton, z);
    }
}
