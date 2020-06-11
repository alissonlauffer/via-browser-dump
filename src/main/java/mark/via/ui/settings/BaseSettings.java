package mark.via.ui.settings;

import android.os.Bundle;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.preference.PreferenceManager;
import mark.via.utils.ViewUtils;

public class BaseSettings extends BaseActivity {

    /* renamed from: c */
    protected PreferenceManager f1803c;

    /* access modifiers changed from: protected */
    @Override // mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManager M = PreferenceManager.m1743M(this.f1039b);
        this.f1803c = M;
        ViewUtils.m2238p(this.f1038a, M.mo1129Z(this.f1039b));
    }
}
