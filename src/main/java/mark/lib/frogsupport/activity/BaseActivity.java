package mark.lib.frogsupport.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class BaseActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f233a;
    protected Context b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f233a = this;
        this.b = this;
    }
}
