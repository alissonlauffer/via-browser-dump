package mark.via.ui.activity;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* renamed from: mark.via.ui.activity.o0 */
/* compiled from: lambda */
public final /* synthetic */ class C0567o0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1761a;

    /* renamed from: b */
    public final /* synthetic */ List f1762b;

    public /* synthetic */ C0567o0(BrowserActivity browserActivity, List list) {
        this.f1761a = browserActivity;
        this.f1762b = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1761a.mo1343C2(this.f1762b, adapterView, view, i, j);
    }
}
