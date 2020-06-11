package mark.via.ui.settings;

import android.os.Bundle;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.f.a;
import mark.via.util.i;
import mark.via.util.r;

public class BaseSettings extends BaseActivity {
    protected a c;

    /* access modifiers changed from: protected */
    @Override // mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a b = a.b(((BaseActivity) this).b);
        this.c = b;
        r.a(((BaseActivity) this).f233a, b.a(((BaseActivity) this).b));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        i.a(((BaseActivity) this).b);
    }
}
