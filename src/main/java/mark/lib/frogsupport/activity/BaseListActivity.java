package mark.lib.frogsupport.activity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import mark.lib.frogsupport.C0365d;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;
import mark.lib.frogsupport.adapter.CommonAdapter;

public abstract class BaseListActivity extends BaseActivity {

    /* renamed from: c */
    protected ListView f1040c;

    /* renamed from: d */
    protected TextView f1041d;

    /* renamed from: e */
    protected CommonAdapter f1042e;

    /* renamed from: mark.lib.frogsupport.activity.BaseListActivity$a */
    class C0362a implements CommonAdapter.AbstractC0386b {
        C0362a() {
        }

        @Override // mark.lib.frogsupport.adapter.CommonAdapter.AbstractC0386b
        /* renamed from: a */
        public void mo596a(boolean z) {
            int i = 8;
            BaseListActivity.this.f1040c.setVisibility(z ? 8 : 0);
            TextView textView = BaseListActivity.this.f1041d;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract CommonAdapter mo595a();

    /* access modifiers changed from: protected */
    @Override // mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0367f.i);
        this.f1040c = (ListView) findViewById(C0366e.aa);
        this.f1041d = (TextView) findViewById(C0366e.bc);
        CommonAdapter a = mo595a();
        this.f1042e = a;
        this.f1040c.setAdapter((ListAdapter) a);
        this.f1040c.setSelector(C0365d.f);
        this.f1040c.setDividerHeight(0);
        this.f1042e.mo670g(new C0362a());
    }
}
