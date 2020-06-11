package mark.via.i.c;

import a.a.a.e;
import a.a.a.f;
import a.a.a.g;
import a.a.b.i.i;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import mark.via.gp.R;
import mark.via.provider.FileProvider;
import mark.via.util.j;
import mark.via.util.p;

/* compiled from: DownloaderSlice */
public class a extends c {
    /* access modifiers changed from: private */
    public a.a.a.a e = a.a.a.a.c(((c) this).b);
    /* access modifiers changed from: private */
    public g f;

    /* renamed from: mark.via.i.c.a$a  reason: collision with other inner class name */
    /* compiled from: DownloaderSlice */
    class C0035a extends g {
        C0035a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        @Override // a.a.a.g
        public void a(f fVar, e eVar) {
            String b = eVar.b();
            if (b.isEmpty()) {
                b = eVar.g();
            }
            fVar.a(R.id.b_, b);
            fVar.a(R.id.ag).setVisibility(eVar.i() ? 0 : 8);
            int e = eVar.e();
            if (e == 2 || e == 4) {
                fVar.a(R.id.bh, String.format("%s/%s", mark.via.util.b.a(eVar.a()), mark.via.util.b.a(eVar.f())));
            } else if (e == 8) {
                fVar.a(R.id.bh, mark.via.util.b.a(eVar.f()));
            } else if (e != 16) {
                fVar.a(R.id.bh, a.a.b.p.a.e(((c) a.this).b, R.string.cx));
            } else {
                fVar.a(R.id.bh, a.a.b.p.a.e(((c) a.this).b, R.string.cu));
            }
        }
    }

    /* compiled from: DownloaderSlice */
    class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f265a;
        final /* synthetic */ ListView b;

        b(a aVar, TextView textView, ListView listView) {
            this.f265a = textView;
            this.b = listView;
        }

        @Override // a.a.a.g.a
        public void a(boolean z) {
            int i = 0;
            this.f265a.setVisibility(z ? 0 : 8);
            ListView listView = this.b;
            if (z) {
                i = 8;
            }
            listView.setVisibility(i);
        }
    }

    /* compiled from: DownloaderSlice */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e item = a.this.f.getItem(i);
            if (item.h()) {
                String c = item.c();
                if (!TextUtils.isEmpty(c)) {
                    File file = new File(c);
                    if (!file.exists()) {
                        a.a.b.p.e.a(((c) a.this).b, (int) R.string.d8);
                        return;
                    }
                    boolean z = true;
                    a.a.b.p.d.a(file.getAbsolutePath());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension((!c.contains(".") || c.endsWith(".")) ? null : c.substring(c.lastIndexOf(".") + 1));
                    if (mimeTypeFromExtension == null || mimeTypeFromExtension.isEmpty()) {
                        mimeTypeFromExtension = "file/*";
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.setDataAndType(FileProvider.a(view.getContext(), "mark.via.gp.provider", file), mimeTypeFromExtension);
                        intent.addFlags(3);
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), mimeTypeFromExtension);
                    }
                    try {
                        ((c) a.this).b.startActivity(intent);
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (!z) {
                        a.a.b.p.e.a(((c) a.this).b, (int) R.string.fd);
                    }
                }
            }
        }
    }

    /* compiled from: DownloaderSlice */
    class d implements AdapterView.OnItemLongClickListener {

        /* renamed from: mark.via.i.c.a$d$a  reason: collision with other inner class name */
        /* compiled from: DownloaderSlice */
        class C0036a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f268a;

            /* renamed from: mark.via.i.c.a$d$a$a  reason: collision with other inner class name */
            /* compiled from: DownloaderSlice */
            class C0037a extends i {

                /* renamed from: a  reason: collision with root package name */
                boolean f269a = false;
                final /* synthetic */ boolean b;

                C0037a(boolean z) {
                    this.b = z;
                }

                @Override // a.a.b.i.i
                public void a(boolean z) {
                    this.f269a = z;
                }

                @Override // a.a.b.i.i
                public void a() {
                    long a2 = a.this.f.a(C0036a.this.f268a);
                    if (!this.b || this.f269a) {
                        a.this.e.a(a2);
                    }
                }
            }

            C0036a(int i) {
                this.f268a = i;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: MutableMD:(java.lang.String, boolean):a.a.b.i.a
             arg types: [java.lang.String, int]
             candidates:
              MutableMD:(int, a.a.b.i.i):a.a.b.i.a
              MutableMD:(int, android.view.View$OnClickListener):a.a.b.i.a
              MutableMD:(int, boolean):a.a.b.i.a
              MutableMD:(java.lang.String, a.a.b.i.i):a.a.b.i.a
              MutableMD:(java.lang.String, android.view.View$OnClickListener):a.a.b.i.a
              a.a.b.i.a.a(int, int):void
              a.a.b.i.a.a(android.widget.TextView, java.lang.String):boolean
              MutableMD:(java.lang.String, boolean):a.a.b.i.a */
            public void onClick(View view) {
                e item = a.this.f.getItem(this.f268a);
                int id = view.getId();
                if (id == 0) {
                    boolean h = item.h();
                    a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(((c) a.this).b).b(R.string.o);
                    cVar.c(h ? R.string.eo : R.string.ep);
                    cVar.a(h ? a.a.b.p.a.e(((c) a.this).b, R.string.en) : null, false);
                    ((a.a.b.i.c) ((a.a.b.i.c) cVar.a(17039370, new C0037a(h))).a(17039360, (View.OnClickListener) null)).g();
                } else if (id == 1) {
                    long a2 = a.this.e.a(item);
                    if (a2 == -1) {
                        a.a.b.p.e.a(((c) a.this).b, (int) R.string.cu);
                    } else {
                        a.this.f.a(this.f268a, a.this.e.b(a2));
                    }
                } else if (id == 2) {
                    p.a(((c) a.this).b, item.g(), ((c) a.this).f274a.getResources().getString(R.string.i6));
                } else if (id == 3 && !j.b(((c) a.this).b, item.c())) {
                    j.a(((c) a.this).b, item.g());
                }
            }
        }

        d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.a.b.i.e eVar = new a.a.b.i.e(((c) a.this).b);
            eVar.b(0, R.string.o);
            eVar.b(1, R.string.a_);
            eVar.b(2, R.string.j);
            eVar.b(3, R.string.ae);
            eVar.a(new C0036a(i));
            eVar.a(view);
            return true;
        }
    }

    public a(Activity activity) {
        super(activity);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    @Override // mark.via.i.c.c
    public View c() {
        View inflate = ((c) this).f274a.getLayoutInflater().inflate(R.layout.b, (ViewGroup) ((c) this).f274a.findViewById(16908290), false);
        ListView listView = (ListView) inflate.findViewById(R.id.ac);
        C0035a aVar = new C0035a(R.layout.t);
        this.f = aVar;
        aVar.a(new b(this, (TextView) inflate.findViewById(R.id.b9), listView));
        listView.setAdapter((ListAdapter) this.f);
        listView.setOnItemClickListener(new c());
        listView.setOnItemLongClickListener(new d());
        this.f.a(this.e.a(mark.via.f.a.b(((c) this).b).q()));
        return inflate;
    }

    @Override // mark.via.i.c.c
    public void e() {
        f();
        ((c) this).c = null;
        this.f = null;
    }

    public void f() {
        if (this.f != null) {
            mark.via.f.a.b(((c) this).b).j(this.f.a());
        }
    }

    public void a(long j) {
        g gVar = this.f;
        if (gVar != null) {
            gVar.a(this.e.b(j));
        } else {
            mark.via.f.a.b(((c) this).b).a(j);
        }
    }

    public void b(long j) {
        g gVar = this.f;
        if (gVar != null && gVar.a(j)) {
            this.f.a(this.e.b(j));
        }
    }
}
