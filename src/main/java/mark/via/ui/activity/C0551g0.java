package mark.via.ui.activity;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: mark.via.ui.activity.g0 */
/* compiled from: lambda */
public final /* synthetic */ class C0551g0 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ BrowserActivity f1726a;

    /* renamed from: b */
    public final /* synthetic */ String f1727b;

    /* renamed from: c */
    public final /* synthetic */ String f1728c;

    /* renamed from: d */
    public final /* synthetic */ int f1729d;

    /* renamed from: e */
    public final /* synthetic */ String f1730e;

    public /* synthetic */ C0551g0(BrowserActivity browserActivity, String str, String str2, int i, String str3) {
        this.f1726a = browserActivity;
        this.f1727b = str;
        this.f1728c = str2;
        this.f1729d = i;
        this.f1730e = str3;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1726a.mo1366l2(this.f1727b, this.f1728c, this.f1729d, this.f1730e, adapterView, view, i, j);
    }
}
