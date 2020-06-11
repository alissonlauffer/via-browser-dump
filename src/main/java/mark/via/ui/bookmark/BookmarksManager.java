package mark.via.ui.bookmark;

import a.a.b.k.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.BrowserApp;
import mark.via.gp.R;
import mark.via.ui.settings.BaseSettings;

public class BookmarksManager extends BaseSettings {
    /* access modifiers changed from: private */
    public List<mark.via.a.b> d;
    /* access modifiers changed from: private */
    public mark.via.c.b e;
    /* access modifiers changed from: private */
    public boolean f = false;
    private a.a.b.i.e g;
    /* access modifiers changed from: private */
    public int h = -1;
    /* access modifiers changed from: private */
    public String[] i;
    /* access modifiers changed from: private */
    public ListView j;
    /* access modifiers changed from: private */
    public a.a.b.k.a k;
    /* access modifiers changed from: private */
    public int l = -1;

    class a extends a.a.b.k.a<mark.via.a.b> {

        /* renamed from: mark.via.ui.bookmark.BookmarksManager$a$a  reason: collision with other inner class name */
        class C0042a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f356a;

            C0042a(int i) {
                this.f356a = i;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: mark.via.ui.bookmark.BookmarksManager.a(mark.via.ui.bookmark.BookmarksManager, boolean):boolean
             arg types: [mark.via.ui.bookmark.BookmarksManager, int]
             candidates:
              mark.via.ui.bookmark.BookmarksManager.a(mark.via.ui.bookmark.BookmarksManager, int):int
              mark.via.ui.bookmark.BookmarksManager.a(int, android.view.View):void
              mark.via.ui.bookmark.BookmarksManager.a(mark.via.ui.bookmark.BookmarksManager, java.lang.String):void
              mark.via.ui.bookmark.BookmarksManager.a(boolean, int):void
              mark.via.ui.bookmark.BookmarksManager.a(mark.via.ui.bookmark.BookmarksManager, boolean):boolean */
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.a6 || id == R.id.a8) {
                    boolean z = true;
                    boolean unused = BookmarksManager.this.f = true;
                    BookmarksManager bookmarksManager = BookmarksManager.this;
                    if (id != R.id.a8) {
                        z = false;
                    }
                    bookmarksManager.a(z, this.f356a);
                }
            }
        }

        a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(a.a.b.k.c cVar, mark.via.a.b bVar, int i) {
            boolean startsWith = bVar.f().startsWith("folder://");
            cVar.a(R.id.be, bVar.e());
            cVar.a(R.id.a7, a.a.b.p.a.d(((a.a.b.k.b) this).f21a, startsWith ? R.drawable.ab : R.drawable.ay));
            boolean z = true;
            cVar.b(R.id.a8, i == BookmarksManager.this.l && !startsWith);
            if (i != BookmarksManager.this.l || startsWith) {
                z = false;
            }
            cVar.b(R.id.a6, z);
            cVar.a(R.id.bf, bVar.f());
            C0042a aVar = new C0042a(i);
            cVar.a(R.id.a6, aVar);
            cVar.a(R.id.a8, aVar);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f357a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                BookmarksManager.this.k.notifyDataSetChanged();
            }
        }

        b(String str) {
            this.f357a = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
         arg types: [java.lang.String, int]
         candidates:
          mark.via.c.b.a(int, int):void
          mark.via.c.b.a(java.lang.String, java.lang.String):void
          mark.via.c.b.a(mark.via.a.b, boolean):void
          mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b> */
        public void run() {
            BookmarksManager.this.c();
            BookmarksManager.this.d.clear();
            if (TextUtils.isEmpty(this.f357a)) {
                BookmarksManager.this.d.addAll(BookmarksManager.this.e.g());
            } else {
                BookmarksManager.this.d.addAll(BookmarksManager.this.e.a(this.f357a, true));
            }
            if (BookmarksManager.this.k != null) {
                ((BaseActivity) BookmarksManager.this).f233a.runOnUiThread(new a());
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f359a;

        c(List list) {
            this.f359a = list;
        }

        public void run() {
            BookmarksManager.this.e.b(this.f359a);
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            mark.via.a.b bVar = (mark.via.a.b) BookmarksManager.this.d.get(i);
            String f = bVar.f();
            if (f.startsWith("folder://")) {
                BookmarksManager.this.a("folder://".equals(f) ? "" : bVar.e());
                return;
            }
            BookmarksManager bookmarksManager = BookmarksManager.this;
            if (bookmarksManager.l == i) {
                i = -1;
            }
            int unused = bookmarksManager.l = i;
            BookmarksManager.this.k.notifyDataSetChanged();
        }
    }

    class e implements AdapterView.OnItemLongClickListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            int unused = BookmarksManager.this.h = i;
            BookmarksManager bookmarksManager = BookmarksManager.this;
            bookmarksManager.a(bookmarksManager.h, view);
            return true;
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.b(mark.via.a.b, boolean):void
         arg types: [mark.via.a.b, int]
         candidates:
          mark.via.c.b.b(java.lang.String, java.lang.String):void
          mark.via.c.b.b(mark.via.a.b, boolean):void */
        public void onClick(View view) {
            int id = view.getId();
            if (id == 0) {
                BookmarksManager bookmarksManager = BookmarksManager.this;
                bookmarksManager.b(bookmarksManager.h);
            } else if (id == 1) {
                BookmarksManager.this.e.b((mark.via.a.b) BookmarksManager.this.d.get(BookmarksManager.this.h), true);
                a.a.b.j.a.b().d(1);
                a.a.b.p.e.a(((BaseActivity) BookmarksManager.this).b, a.a.b.p.a.e(((BaseActivity) BookmarksManager.this).b, R.string.aq));
            } else if (id == 2) {
                BookmarksManager bookmarksManager2 = BookmarksManager.this;
                bookmarksManager2.a(bookmarksManager2.h);
            } else if (id == 3) {
                String f = ((mark.via.a.b) BookmarksManager.this.d.get(BookmarksManager.this.h)).f();
                if (!TextUtils.isEmpty(f)) {
                    a.a.b.p.e.a(((BaseActivity) BookmarksManager.this).b, f, (int) R.string.i6);
                }
            }
        }
    }

    class g implements a.b {
        g() {
        }

        @Override // a.a.b.k.a.b
        public void a(boolean z) {
            int i = 8;
            BookmarksManager.this.j.setVisibility(z ? 8 : 0);
            View findViewById = BookmarksManager.this.findViewById(R.id.bg);
            if (z) {
                i = 0;
            }
            findViewById.setVisibility(i);
        }
    }

    class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f364a;
        final /* synthetic */ int b;

        h(String str, int i) {
            this.f364a = str;
            this.b = i;
        }

        public void onClick(View view) {
            BookmarksManager.this.e.d(this.f364a);
            BookmarksManager.this.b();
            BookmarksManager.this.d.remove(this.b);
            BookmarksManager.this.k.notifyDataSetChanged();
        }
    }

    class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f365a;
        final /* synthetic */ int b;

        i(String str, int i) {
            this.f365a = str;
            this.b = i;
        }

        public void onClick(View view) {
            BookmarksManager.this.e.c(this.f365a);
            BookmarksManager.this.b();
            BookmarksManager.this.d.remove(this.b);
            BookmarksManager.this.k.notifyDataSetChanged();
        }
    }

    class j extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f366a;
        final /* synthetic */ mark.via.a.b b;

        j(String str, mark.via.a.b bVar) {
            this.f366a = str;
            this.b = bVar;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 1)) {
                int i = 0;
                String str = strArr[0];
                int length = BookmarksManager.this.i.length;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (this.f366a.equals(BookmarksManager.this.i[i])) {
                        BookmarksManager.this.i[i] = str;
                        break;
                    } else {
                        i++;
                    }
                }
                BookmarksManager.this.e.a(this.f366a, str);
                this.b.b(str);
                mark.via.a.b bVar = this.b;
                bVar.c("folder://" + str);
                try {
                    mark.via.a.b bVar2 = this.b;
                    bVar2.c("folder://" + URLEncoder.encode(str, "utf-8"));
                } catch (Exception unused) {
                }
                BookmarksManager.this.k.notifyDataSetChanged();
                BookmarksManager.this.b();
            }
        }
    }

    class k extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ mark.via.a.b f367a;

        k(mark.via.a.b bVar) {
            this.f367a = bVar;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.c.b.a(mark.via.a.b, boolean):void
         arg types: [mark.via.a.b, int]
         candidates:
          mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
          mark.via.c.b.a(int, int):void
          mark.via.c.b.a(java.lang.String, java.lang.String):void
          mark.via.c.b.a(mark.via.a.b, boolean):void */
        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                String f = this.f367a.f();
                this.f367a.b(strArr[0]);
                this.f367a.c(mark.via.util.b.b(strArr[1]));
                String a2 = this.f367a.a();
                boolean equals = true ^ a2.equals(strArr[2]);
                this.f367a.a(strArr[2]);
                BookmarksManager.this.e.c(f);
                BookmarksManager.this.e.a(this.f367a, false);
                if (equals) {
                    BookmarksManager.this.a(a2);
                } else {
                    BookmarksManager.this.k.notifyDataSetChanged();
                }
                BookmarksManager.this.b();
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f504a);
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.g);
        a2.a(R.string.ca);
        ((ViewGroup) findViewById(R.id.aa)).addView(a2.a(), 0);
        a();
    }

    public void onPause() {
        c();
        super.onPause();
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        mark.via.a.b bVar = this.d.get(i2);
        String f2 = bVar.f();
        if (f2.startsWith("folder://")) {
            String substring = f2.substring(9);
            if (!substring.isEmpty()) {
                try {
                    substring = URLDecoder.decode(substring, "utf-8");
                } catch (UnsupportedEncodingException unused) {
                }
                a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.hy);
                dVar.a(0, substring, R.string.dn, this.i);
                ((a.a.b.i.d) dVar.a(17039370, new j(substring, bVar))).g();
                return;
            }
            return;
        }
        a.a.b.i.d dVar2 = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.hw);
        dVar2.c(false);
        a.a.b.i.d dVar3 = dVar2;
        dVar3.a(0, bVar.e(), R.string.dq);
        dVar3.a(1, bVar.f(), R.string.dr);
        dVar3.a(2, bVar.a(), R.string.dn, this.i);
        ((a.a.b.i.d) ((a.a.b.i.d) dVar3.a(17039370, new k(bVar))).a(17039360, (View.OnClickListener) null)).g();
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.d.size() != 0 && this.f) {
            ArrayList arrayList = new ArrayList();
            int size = this.d.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                mark.via.a.b bVar = this.d.get(i3);
                if (bVar.f().startsWith("folder://")) {
                    i2 = i3;
                } else {
                    bVar.c(i3 - i2);
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() > 0) {
                BrowserApp.b().execute(new c(arrayList));
                b();
            }
            this.f = false;
        }
    }

    private void a() {
        this.j = (ListView) findViewById(R.id.ad);
        this.e = mark.via.c.b.a(((BaseActivity) this).b);
        this.d = new ArrayList();
        this.k = new a(((BaseActivity) this).b, R.layout.r, this.d);
        this.j.setOnItemClickListener(new d());
        this.j.setOnItemLongClickListener(new e());
        a("");
        a.a.b.i.e eVar = new a.a.b.i.e(((BaseActivity) this).b);
        this.g = eVar;
        eVar.b(0, R.string.r);
        this.g.b(1, R.string.b);
        this.g.b(2, R.string.m);
        this.g.b(3, R.string.i);
        this.g.a(new f());
        this.i = this.e.h();
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setSelector(R.drawable.f);
        this.j.setDividerHeight(0);
        this.k.a(new g());
    }

    /* access modifiers changed from: private */
    public void b() {
        a.a.b.j.a.b().d(2);
    }

    /* access modifiers changed from: private */
    public void a(int i2, View view) {
        String f2 = this.d.get(i2).f();
        boolean startsWith = f2.startsWith("folder://");
        if (!(startsWith && f2.equals("folder://")) && !TextUtils.isEmpty(f2)) {
            this.g.b(1, !startsWith);
            this.g.b(3, !startsWith);
            this.g.a(view);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        String f2 = this.d.get(i2).f();
        if (f2.startsWith("folder://")) {
            String substring = f2.substring(9);
            if (!substring.isEmpty()) {
                try {
                    substring = URLDecoder.decode(substring, "utf-8");
                } catch (UnsupportedEncodingException unused) {
                }
                a.a.b.p.e.b(((BaseActivity) this).b, getResources().getString(R.string.f0), a.a.b.p.a.a(((BaseActivity) this).b, (int) R.string.c9, substring), new h(substring, i2));
                return;
            }
            return;
        }
        a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.m, (int) R.string.cm, new i(f2, i2));
    }

    /* access modifiers changed from: private */
    public void a(boolean z, int i2) {
        if (i2 >= 0 && i2 < this.d.size()) {
            if (!z || i2 > 0) {
                int i3 = 1;
                if (!z && i2 == this.d.size() - 1) {
                    return;
                }
                if (!z || !this.d.get(i2 - 1).f().startsWith("folder://")) {
                    this.l += z ? -1 : 1;
                    List<mark.via.a.b> list = this.d;
                    if (z) {
                        i3 = -1;
                    }
                    Collections.swap(list, i2, i3 + i2);
                    a.a.b.k.a aVar = this.k;
                    if (aVar != null) {
                        aVar.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.l = -1;
        this.h = -1;
        BrowserApp.b().execute(new b(str));
    }
}
