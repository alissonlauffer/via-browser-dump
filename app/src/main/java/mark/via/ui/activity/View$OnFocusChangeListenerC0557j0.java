package mark.via.ui.activity;

import android.view.View;
import android.widget.EditText;

/* renamed from: mark.via.ui.activity.j0 */
/* compiled from: lambda */
public final /* synthetic */ class View$OnFocusChangeListenerC0557j0 implements View.OnFocusChangeListener {

    /* renamed from: a */
    public final /* synthetic */ EditText f1743a;

    public /* synthetic */ View$OnFocusChangeListenerC0557j0(EditText editText) {
        this.f1743a = editText;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        BrowserActivity.m2309J1(this.f1743a, view, z);
    }
}
