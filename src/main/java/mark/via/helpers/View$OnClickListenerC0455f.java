package mark.via.helpers;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.via.h.f */
/* compiled from: lambda */
public final /* synthetic */ class View$OnClickListenerC0455f implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ TaoDialog f1360a;

    /* renamed from: b */
    public final /* synthetic */ Context f1361b;

    /* renamed from: c */
    public final /* synthetic */ String[] f1362c;

    /* renamed from: d */
    public final /* synthetic */ EditText f1363d;

    public /* synthetic */ View$OnClickListenerC0455f(TaoDialog cVar, Context context, String[] strArr, EditText editText) {
        this.f1360a = cVar;
        this.f1361b = context;
        this.f1362c = strArr;
        this.f1363d = editText;
    }

    public final void onClick(View view) {
        BookmarkHelper.m1718l(this.f1360a, this.f1361b, this.f1362c, this.f1363d, view);
    }
}
