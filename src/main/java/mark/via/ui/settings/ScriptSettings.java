package mark.via.ui.settings;

import a.a.b.k.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.BrowserApp;
import mark.via.gp.R;
import mark.via.ui.activity.BrowserActivity;
import mark.via.util.i;
import mark.via.util.j;
import mark.via.util.r;

public class ScriptSettings extends BaseSettings {
    /* access modifiers changed from: private */
    public mark.via.c.b d;
    /* access modifiers changed from: private */
    public List<mark.via.a.a> e;
    /* access modifiers changed from: private */
    public String f;
    /* access modifiers changed from: private */
    public a.a.b.k.a g;

    class a implements View.OnClickListener {

        /* renamed from: mark.via.ui.settings.ScriptSettings$a$a  reason: collision with other inner class name */
        class C0045a implements View.OnClickListener {
            C0045a() {
            }

            public void onClick(View view) {
                int id = view.getId();
                if (id == 0) {
                    ScriptSettings.this.a();
                } else if (id == 1) {
                    mark.via.d.a.a().g("online");
                    mark.via.util.b.a(((BaseActivity) ScriptSettings.this).b, ScriptSettings.this.f, BrowserActivity.class);
                    ScriptSettings.this.finish();
                }
            }
        }

        a() {
        }

        public void onClick(View view) {
            a.a.b.i.e eVar = new a.a.b.i.e(((BaseActivity) ScriptSettings.this).b);
            eVar.b(0, R.string.a0);
            eVar.b(1, R.string.dh);
            eVar.a(new C0045a());
            eVar.a(view);
        }
    }

    class b extends a.a.b.k.a<mark.via.a.a> {
        b(ScriptSettings scriptSettings, Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(a.a.b.k.c cVar, mark.via.a.a aVar, int i) {
            cVar.a(R.id.a3, aVar.g());
            cVar.a(R.id.a0, i.c(aVar.b()));
        }
    }

    class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ListView f416a;
        final /* synthetic */ TextView b;

        c(ScriptSettings scriptSettings, ListView listView, TextView textView) {
            this.f416a = listView;
            this.b = textView;
        }

        @Override // a.a.b.k.a.b
        public void a(boolean z) {
            int i = 8;
            this.f416a.setVisibility(z ? 8 : 0);
            TextView textView = this.b;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScriptSettings.this.a((mark.via.a.a) ScriptSettings.this.e.get(i));
        }
    }

    class e implements AdapterView.OnItemLongClickListener {

        class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f419a;

            /* renamed from: mark.via.ui.settings.ScriptSettings$e$a$a  reason: collision with other inner class name */
            class C0046a implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ mark.via.a.a f420a;

                C0046a(mark.via.a.a aVar) {
                    this.f420a = aVar;
                }

                public void onClick(View view) {
                    a.a.b.p.e.a(((BaseActivity) ScriptSettings.this).b, i.c(this.f420a.b()), a.a.b.p.a.e(((BaseActivity) ScriptSettings.this).b, R.string.i5));
                }
            }

            class b extends a.a.b.i.i {
                b(a aVar) {
                }
            }

            class c implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ mark.via.a.a f421a;

                c(mark.via.a.a aVar) {
                    this.f421a = aVar;
                }

                public void onClick(View view) {
                    ScriptSettings.this.a(this.f421a, "", "");
                }
            }

            a(int i) {
                this.f419a = i;
            }

            public void onClick(View view) {
                String str;
                mark.via.a.a aVar = (mark.via.a.a) ScriptSettings.this.e.get(this.f419a);
                int id = view.getId();
                if (id == 0) {
                    ScriptSettings.this.a(aVar);
                } else if (id == 1) {
                    a.a.b.i.c cVar = new a.a.b.i.c(((BaseActivity) ScriptSettings.this).b);
                    cVar.b(aVar.g());
                    a.a.b.i.c cVar2 = cVar;
                    cVar2.c(i.c(aVar.b()));
                    ((a.a.b.i.c) ((a.a.b.i.c) cVar2.a(17039370, new b(this))).b(R.string.l, new C0046a(aVar))).g();
                } else if (id == 2) {
                    a.a.b.i.c cVar3 = (a.a.b.i.c) new a.a.b.i.c(((BaseActivity) ScriptSettings.this).b).b(R.string.m);
                    cVar3.c(aVar.g() + "\n\n" + i.c(aVar.b()));
                    ((a.a.b.i.c) ((a.a.b.i.c) cVar3.c(17039370, new c(aVar))).a(17039360, (View.OnClickListener) null)).g();
                } else if (id == 3) {
                    if (aVar.f() == 0) {
                        str = i.b(((BaseActivity) ScriptSettings.this).b, aVar.g(), aVar.b());
                    } else {
                        String g = aVar.g();
                        if ("*".equals(g)) {
                            g = a.a.b.p.a.e(((BaseActivity) ScriptSettings.this).b, R.string.ay);
                        }
                        str = ((BaseActivity) ScriptSettings.this).b.getResources().getString(R.string.h0, g + " (" + aVar.e() + ") ", ScriptSettings.this.f);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        j.a(((BaseActivity) ScriptSettings.this).b, str);
                    }
                }
            }
        }

        e() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.a.b.i.e eVar = new a.a.b.i.e(((BaseActivity) ScriptSettings.this).b);
            eVar.b(0, R.string.r);
            eVar.b(1, R.string.a9);
            eVar.b(2, R.string.m);
            eVar.b(3, R.string.ae);
            eVar.a(new a(i));
            eVar.a(view);
            return true;
        }
    }

    class f extends a.a.b.i.i {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ mark.via.a.a f423a;

            a(mark.via.a.a aVar) {
                this.f423a = aVar;
            }

            public void run() {
                ScriptSettings.this.d.a(this.f423a);
            }
        }

        f() {
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                mark.via.d.a.a().g("add");
                mark.via.a.a aVar = new mark.via.a.a();
                aVar.e(str);
                aVar.b(i.b(str2));
                ScriptSettings.this.e.add(0, aVar);
                BrowserApp.a().execute(new a(aVar));
                ScriptSettings.this.g.notifyDataSetChanged();
            }
        }
    }

    class g extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ mark.via.a.a f424a;

        g(mark.via.a.a aVar) {
            this.f424a = aVar;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                ScriptSettings.this.a(this.f424a, strArr[0], strArr[1]);
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f425a;
        final /* synthetic */ String b;
        final /* synthetic */ mark.via.a.a c;

        h(String str, String str2, mark.via.a.a aVar) {
            this.f425a = str;
            this.b = str2;
            this.c = aVar;
        }

        public void run() {
            if (this.f425a.equalsIgnoreCase("") || this.b.equalsIgnoreCase("")) {
                ScriptSettings.this.d.a(this.c.b());
            } else {
                ScriptSettings.this.d.a(this.c);
            }
        }
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mark.via.c.b a2 = mark.via.c.b.a(((BaseActivity) this).b);
        this.d = a2;
        this.e = a2.b();
        setContentView(b());
        r.b(findViewById(a.a.b.m.a.f));
        this.f = mark.via.f.a.b(((BaseActivity) this).b).j() == 1 ? "https://app.viayoo.com/addons/" : "http://via.oktutu.com/addons/";
    }

    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gy);
        a2.a(R.string.ca);
        a2.a(R.drawable.a5, new a());
        View a3 = a2.a();
        TextView a4 = a.a.b.p.c.a(((BaseActivity) this).b, (int) R.string.d1);
        ListView listView = new ListView(new ContextThemeWrapper(((BaseActivity) this).b, (int) R.style.i));
        listView.setDividerHeight(0);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        b bVar = new b(this, ((BaseActivity) this).b, R.layout.s, this.e);
        this.g = bVar;
        bVar.a(new c(this, listView, a4));
        listView.setAdapter((ListAdapter) this.g);
        listView.setOnItemClickListener(new d());
        listView.setOnItemLongClickListener(new e());
        return a.a.b.p.c.a(a3, a4, listView);
    }

    /* access modifiers changed from: private */
    public void a() {
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.ap);
        dVar.a(0, "", R.string.gg);
        dVar.a(1, "", R.string.gf);
        dVar.b(1, 8);
        ((a.a.b.i.d) dVar.a(17039370, new f())).g();
    }

    /* access modifiers changed from: private */
    public void a(mark.via.a.a aVar) {
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.r);
        dVar.c(false);
        a.a.b.i.d dVar2 = dVar;
        dVar2.a(0, aVar.g(), R.string.gg);
        dVar2.a(1, i.c(aVar.b()), R.string.gf);
        dVar2.b(1, 8);
        ((a.a.b.i.d) ((a.a.b.i.d) dVar2.a(17039370, new g(aVar))).a(17039360, (View.OnClickListener) null)).g();
    }

    /* access modifiers changed from: private */
    public void a(mark.via.a.a aVar, String str, String str2) {
        if (aVar != null) {
            if ("".equalsIgnoreCase(str) || "".equalsIgnoreCase(str2)) {
                this.e.remove(aVar);
            } else {
                aVar.e(str);
                aVar.b(i.b(str2));
            }
            BrowserApp.a().execute(new h(str, str2, aVar));
            this.g.notifyDataSetChanged();
        }
    }
}
