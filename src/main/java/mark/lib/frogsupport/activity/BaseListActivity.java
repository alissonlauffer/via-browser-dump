package mark.lib.frogsupport.activity;

import a.a.b.d;
import a.a.b.e;
import a.a.b.f;
import a.a.b.k.a;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public abstract class BaseListActivity extends BaseActivity {
    protected ListView c;
    protected TextView d;
    protected a.a.b.k.a e;

    class a implements a.b {
        a() {
        }

        @Override // a.a.b.k.a.b
        public void a(boolean z) {
            int i = 8;
            BaseListActivity.this.c.setVisibility(z ? 8 : 0);
            TextView textView = BaseListActivity.this.d;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    /* access modifiers changed from: protected */
    public abstract a.a.b.k.a a();

    /* access modifiers changed from: protected */
    @Override // mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.j);
        this.c = (ListView) findViewById(e.ad);
        this.d = (TextView) findViewById(e.bg);
        a.a.b.k.a a2 = a();
        this.e = a2;
        this.c.setAdapter((ListAdapter) a2);
        this.c.setSelector(d.f);
        this.c.setDividerHeight(0);
        this.e.a(new a());
    }
}
