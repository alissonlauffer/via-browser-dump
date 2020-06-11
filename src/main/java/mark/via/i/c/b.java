package mark.via.i.c;

import a.a.b.i.h;
import a.a.b.i.i;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import mark.via.gp.R;
import mark.via.refactor.config.SiteConf;
import mark.via.util.r;

/* compiled from: SiteConfSlice */
public class b extends c {
    /* access modifiers changed from: private */
    public mark.via.refactor.config.c e;
    private CheckBox f;
    private CheckBox g;
    private CheckBox h;
    private CheckBox i;
    /* access modifiers changed from: private */
    public TextView j;
    /* access modifiers changed from: private */
    public EditText k;
    /* access modifiers changed from: private */
    public View l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public String n;

    /* compiled from: SiteConfSlice */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SiteConf f270a;

        a(SiteConf siteConf) {
            this.f270a = siteConf;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            switch (compoundButton.getId()) {
                case R.id.g /*{ENCODED_INT: 2131230726}*/:
                    this.f270a.a(mark.via.h.c.a.a(z));
                    break;
                case R.id.h /*{ENCODED_INT: 2131230727}*/:
                    this.f270a.b(mark.via.h.c.a.a(z));
                    break;
                case R.id.k /*{ENCODED_INT: 2131230730}*/:
                    this.f270a.c(mark.via.h.c.a.a(z));
                    break;
                case R.id.l /*{ENCODED_INT: 2131230731}*/:
                    r.a((ViewGroup) ((c) b.this).c, z, R.id.l);
                    this.f270a.a(z);
                    break;
            }
            b.this.e.a(b.this.n, this.f270a);
            boolean unused = b.this.m = true;
        }
    }

    /* renamed from: mark.via.i.c.b$b  reason: collision with other inner class name */
    /* compiled from: SiteConfSlice */
    class C0038b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SiteConf f271a;

        /* renamed from: mark.via.i.c.b$b$a */
        /* compiled from: SiteConfSlice */
        class a extends i {
            a() {
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                int i2 = i + 1;
                if (i2 != C0038b.this.f271a.f()) {
                    C0038b.this.f271a.a(i2);
                    int i3 = 0;
                    b.this.k.setVisibility(i == 5 ? 0 : 8);
                    View e = b.this.l;
                    if (i != 5) {
                        i3 = 8;
                    }
                    e.setVisibility(i3);
                    b.this.j.setText(a.a.b.p.a.b(((c) b.this).f274a, R.array.o, i));
                    mark.via.refactor.config.c.a(((c) b.this).f274a).a(b.this.n, C0038b.this.f271a);
                    boolean unused = b.this.m = true;
                }
            }
        }

        C0038b(SiteConf siteConf) {
            this.f271a = siteConf;
        }

        public void onClick(View view) {
            h hVar = (h) new h(((c) b.this).f274a).b(R.string.as);
            hVar.b(R.array.o, this.f271a.f() - 1);
            hVar.a(new a());
            hVar.a(b.this.j);
        }
    }

    /* compiled from: SiteConfSlice */
    class c implements View.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SiteConf f273a;

        c(SiteConf siteConf) {
            this.f273a = siteConf;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66) {
                return i == 82;
            }
            b bVar = b.this;
            mark.via.util.a.a(((c) bVar).f274a, bVar.k);
            b.this.k.clearFocus();
            this.f273a.a(b.this.k.getText().toString().trim());
            mark.via.refactor.config.c.a(((c) b.this).f274a).a(b.this.n, this.f273a);
            boolean unused = b.this.m = true;
            return true;
        }
    }

    public b(Activity activity) {
        super(activity);
        mark.via.refactor.config.c a2 = mark.via.refactor.config.c.a(activity);
        this.e = a2;
        a2.a().a(((c) this).b);
    }

    public boolean f() {
        return this.m;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    @Override // mark.via.i.c.c
    public View c() {
        View inflate = ((c) this).f274a.getLayoutInflater().inflate(R.layout.e, (ViewGroup) ((c) this).f274a.findViewById(16908290), false);
        this.f = (CheckBox) inflate.findViewById(R.id.l);
        this.j = (TextView) inflate.findViewById(R.id.b7);
        this.k = (EditText) inflate.findViewById(R.id.s);
        this.l = inflate.findViewById(R.id.t);
        this.g = (CheckBox) inflate.findViewById(R.id.h);
        this.h = (CheckBox) inflate.findViewById(R.id.k);
        this.i = (CheckBox) inflate.findViewById(R.id.g);
        return inflate;
    }

    @Override // mark.via.i.c.c
    public void d() {
        SiteConf b = this.e.b(this.n);
        a aVar = new a(b);
        this.f.setText(((c) this).f274a.getString(R.string.d4, new Object[]{this.n}));
        this.f.setOnCheckedChangeListener(null);
        this.f.setChecked(b.g());
        this.f.setOnCheckedChangeListener(aVar);
        this.j.setText(a.a.b.p.a.b(((c) this).f274a, R.array.o, b.f() - 1));
        int i2 = 8;
        this.k.setVisibility(b.f() == 6 ? 0 : 8);
        View view = this.l;
        if (b.f() == 6) {
            i2 = 0;
        }
        view.setVisibility(i2);
        this.k.setText(b.e());
        C0038b bVar = new C0038b(b);
        this.j.setOnClickListener(bVar);
        ((c) this).c.findViewById(R.id.b8).setOnClickListener(bVar);
        this.k.setOnKeyListener(new c(b));
        this.g.setOnCheckedChangeListener(null);
        this.h.setOnCheckedChangeListener(null);
        this.i.setOnCheckedChangeListener(null);
        this.g.setChecked(mark.via.h.c.a.a(b.b()));
        this.h.setChecked(mark.via.h.c.a.a(b.d()));
        this.i.setChecked(mark.via.h.c.a.a(b.a()));
        this.g.setOnCheckedChangeListener(aVar);
        this.h.setOnCheckedChangeListener(aVar);
        this.i.setOnCheckedChangeListener(aVar);
        r.a((ViewGroup) ((c) this).c, b.g(), R.id.l);
        this.m = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.b.a(android.content.Context, java.lang.String):int
      mark.via.util.b.a(int, java.lang.String):java.lang.String
      mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
      mark.via.util.b.a(android.webkit.WebView, int):void
      mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
    public b a(String str) {
        this.n = mark.via.util.b.a(str, false);
        return this;
    }

    public boolean a(WebView webView) {
        if (this.m && webView != null) {
            this.e.d(this.n);
            webView.setTag(null);
            this.e.a(webView, this.n);
            if (this.m) {
                webView.reload();
                this.m = false;
                return true;
            }
        }
        return false;
    }
}
