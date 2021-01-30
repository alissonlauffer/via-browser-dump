package mark.via.ui.settings;

import android.widget.TextView;
import mark.lib.frogsupport.adapter.CommonAdapter;

/* renamed from: mark.via.ui.settings.r1 */
/* compiled from: lambda */
public final /* synthetic */ class C0662r1 implements CommonAdapter.AbstractC0386b {

    /* renamed from: a */
    public final /* synthetic */ SubscribedFiltersUI f1971a;

    /* renamed from: b */
    public final /* synthetic */ TextView f1972b;

    public /* synthetic */ C0662r1(SubscribedFiltersUI subscribedFiltersUI, TextView textView) {
        this.f1971a = subscribedFiltersUI;
        this.f1972b = textView;
    }

    @Override // mark.lib.frogsupport.adapter.CommonAdapter.AbstractC0386b
    /* renamed from: a */
    public final void mo596a(boolean z) {
        this.f1971a.mo1549q(this.f1972b, z);
    }
}
