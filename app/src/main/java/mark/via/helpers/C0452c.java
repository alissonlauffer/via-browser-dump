package mark.via.helpers;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.h.c */
/* compiled from: lambda */
public final /* synthetic */ class C0452c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ EditText f1350a;

    /* renamed from: b */
    public final /* synthetic */ TaoDialog f1351b;

    /* renamed from: c */
    public final /* synthetic */ Context f1352c;

    /* renamed from: d */
    public final /* synthetic */ String[] f1353d;

    public /* synthetic */ C0452c(EditText editText, TaoDialog cVar, Context context, String[] strArr) {
        this.f1350a = editText;
        this.f1351b = cVar;
        this.f1352c = context;
        this.f1353d = strArr;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        BookmarkHelper.m1715i(this.f1350a, this.f1351b, this.f1352c, this.f1353d, adapterView, view, i, j);
    }
}
