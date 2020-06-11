package mark.via.ui.settings;

import a.a.b.i.i;
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
import mark.via.util.j;
import mark.via.util.r;

public class BlockSettings extends BaseSettings {
    /* access modifiers changed from: private */
    public mark.via.c.b d;
    /* access modifiers changed from: private */
    public List<mark.via.a.d> e;
    /* access modifiers changed from: private */
    public a.a.b.k.a f;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            BlockSettings.this.a();
        }
    }

    class b extends a.a.b.k.a<mark.via.a.d> {
        b(BlockSettings blockSettings, Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(a.a.b.k.c cVar, mark.via.a.d dVar, int i) {
            cVar.a(R.id.a3, dVar.b());
            cVar.a(R.id.a0, dVar.a());
        }
    }

    class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ListView f381a;
        final /* synthetic */ TextView b;

        c(BlockSettings blockSettings, ListView listView, TextView textView) {
            this.f381a = listView;
            this.b = textView;
        }

        @Override // a.a.b.k.a.b
        public void a(boolean z) {
            int i = 8;
            this.f381a.setVisibility(z ? 8 : 0);
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
            BlockSettings.this.a((mark.via.a.d) BlockSettings.this.e.get(i));
        }
    }

    class e implements AdapterView.OnItemLongClickListener {

        class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f384a;

            /* renamed from: mark.via.ui.settings.BlockSettings$e$a$a  reason: collision with other inner class name */
            class C0043a extends i {
                C0043a(a aVar) {
                }
            }

            class b implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ mark.via.a.d f385a;

                b(mark.via.a.d dVar) {
                    this.f385a = dVar;
                }

                public void onClick(View view) {
                    BlockSettings.this.a(this.f385a, "", "");
                }
            }

            a(int i) {
                this.f384a = i;
            }

            public void onClick(View view) {
                mark.via.a.d dVar = (mark.via.a.d) BlockSettings.this.e.get(this.f384a);
                int id = view.getId();
                if (id == 0) {
                    BlockSettings.this.a(dVar);
                } else if (id == 1) {
                    a.a.b.i.c cVar = new a.a.b.i.c(((BaseActivity) BlockSettings.this).b);
                    cVar.b(dVar.b());
                    a.a.b.i.c cVar2 = cVar;
                    cVar2.c(dVar.a());
                    ((a.a.b.i.c) cVar2.a(17039370, new C0043a(this))).g();
                } else if (id == 2) {
                    a.a.b.i.c cVar3 = (a.a.b.i.c) new a.a.b.i.c(((BaseActivity) BlockSettings.this).b).b(R.string.m);
                    cVar3.c(dVar.b() + "\n\n" + dVar.a());
                    ((a.a.b.i.c) ((a.a.b.i.c) cVar3.c(17039370, new b(dVar))).a(17039360, (View.OnClickListener) null)).g();
                } else if (id == 3) {
                    String a2 = mark.via.util.i.a(((BaseActivity) BlockSettings.this).b, dVar.b(), dVar.a());
                    if (!a2.isEmpty()) {
                        j.a(((BaseActivity) BlockSettings.this).b, a2);
                    }
                }
            }
        }

        e() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.a.b.i.e eVar = new a.a.b.i.e(((BaseActivity) BlockSettings.this).b);
            eVar.b(0, R.string.r);
            eVar.b(1, R.string.a9);
            eVar.b(2, R.string.m);
            eVar.b(3, R.string.ae);
            eVar.a(new a(i));
            eVar.a(view);
            return true;
        }
    }

    class f extends i {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f387a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.f387a = str;
                this.b = str2;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void
             arg types: [java.lang.String, java.lang.String, int]
             candidates:
              mark.via.c.b.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String
              mark.via.c.b.a(java.lang.String, int, int):void
              mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void */
            public void run() {
                BlockSettings.this.d.a(this.f387a, this.b, false);
            }
        }

        f() {
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                mark.via.d.a.a().c("add");
                mark.via.a.d dVar = new mark.via.a.d();
                dVar.b(str);
                dVar.a(str2);
                BlockSettings.this.e.add(0, dVar);
                BrowserApp.a().execute(new a(str, str2));
                BlockSettings.this.f.notifyDataSetChanged();
            }
        }
    }

    class g extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ mark.via.a.d f388a;

        g(mark.via.a.d dVar) {
            this.f388a = dVar;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                BlockSettings.this.a(this.f388a, strArr[0], strArr[1]);
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f389a;
        final /* synthetic */ String b;
        final /* synthetic */ mark.via.a.d c;
        final /* synthetic */ String d;

        h(String str, String str2, mark.via.a.d dVar, String str3) {
            this.f389a = str;
            this.b = str2;
            this.c = dVar;
            this.d = str3;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void
         arg types: [java.lang.String, java.lang.String, int]
         candidates:
          mark.via.c.b.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String
          mark.via.c.b.a(java.lang.String, int, int):void
          mark.via.c.b.a(java.lang.String, java.lang.String, boolean):void */
        public void run() {
            if (this.f389a.equalsIgnoreCase("") || this.b.equalsIgnoreCase("")) {
                BlockSettings.this.d.b(this.c.b());
                return;
            }
            if (this.d != null) {
                BlockSettings.this.d.b(this.d);
            }
            BlockSettings.this.d.a(this.f389a, this.b, true);
        }
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mark.via.c.b a2 = mark.via.c.b.a(((BaseActivity) this).b);
        this.d = a2;
        this.e = a2.d();
        setContentView(b());
        r.b(findViewById(a.a.b.m.a.f));
    }

    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gs);
        a2.a(R.string.ca);
        a2.a(R.drawable.a5, new a());
        View a3 = a2.a();
        TextView a4 = a.a.b.p.c.a(((BaseActivity) this).b, (int) R.string.d1);
        ListView listView = new ListView(new ContextThemeWrapper(((BaseActivity) this).b, (int) R.style.i));
        listView.setDividerHeight(0);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        b bVar = new b(this, ((BaseActivity) this).b, R.layout.s, this.e);
        this.f = bVar;
        bVar.a(new c(this, listView, a4));
        listView.setAdapter((ListAdapter) this.f);
        listView.setOnItemClickListener(new d());
        listView.setOnItemLongClickListener(new e());
        return a.a.b.p.c.a(a3, a4, listView);
    }

    /* access modifiers changed from: private */
    public void a() {
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.ao);
        dVar.a(0, "", R.string.dr);
        dVar.a(1, "", R.string.dp);
        dVar.b(1, 2);
        ((a.a.b.i.d) dVar.a(17039370, new f())).g();
    }

    /* access modifiers changed from: private */
    public void a(mark.via.a.d dVar) {
        a.a.b.i.d dVar2 = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.r);
        dVar2.c(false);
        a.a.b.i.d dVar3 = dVar2;
        dVar3.a(0, dVar.b(), R.string.dr);
        dVar3.a(1, dVar.a(), R.string.dp);
        dVar3.b(1, 2);
        ((a.a.b.i.d) ((a.a.b.i.d) dVar3.a(17039370, new g(dVar))).a(17039360, (View.OnClickListener) null)).g();
    }

    /* access modifiers changed from: private */
    public void a(mark.via.a.d dVar, String str, String str2) {
        if (dVar != null) {
            String str3 = null;
            if (str.equalsIgnoreCase("") || str2.equalsIgnoreCase("")) {
                this.e.remove(dVar);
            } else {
                str3 = dVar.b();
                dVar.b(str);
                dVar.a(str2);
            }
            BrowserApp.a().execute(new h(str, str2, dVar, str3));
            this.f.notifyDataSetChanged();
        }
    }
}
