package mark.via.p044m.p046b;

import android.view.View;
import android.widget.AdapterView;
import mark.via.p044m.p046b.DownloaderSlice;

/* renamed from: mark.via.m.b.a */
/* compiled from: lambda */
public final /* synthetic */ class C0472a implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ DownloaderSlice.C0482d f1426a;

    /* renamed from: b */
    public final /* synthetic */ int f1427b;

    public /* synthetic */ C0472a(DownloaderSlice.C0482d dVar, int i) {
        this.f1426a = dVar;
        this.f1427b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1426a.mo1261d(this.f1427b, adapterView, view, i, j);
    }
}
