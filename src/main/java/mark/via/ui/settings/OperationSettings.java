package mark.via.ui.settings;

import a.a.b.i.h;
import a.a.b.i.i;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.gp.R;
import mark.via.util.r;

public class OperationSettings extends BaseSettings {

    class a implements a.a.b.n.c {
        a() {
        }

        @Override // a.a.b.n.c
        public void a(a.a.b.n.b bVar, int i) {
            OperationSettings.this.a(bVar, i);
        }
    }

    class b extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f409a;

        b(int i) {
            this.f409a = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            switch (this.f409a) {
                case 0:
                    ((BaseSettings) OperationSettings.this).c.n(i);
                    return;
                case 1:
                    ((BaseSettings) OperationSettings.this).c.o(i);
                    return;
                case 2:
                    ((BaseSettings) OperationSettings.this).c.p(i);
                    return;
                case 3:
                    ((BaseSettings) OperationSettings.this).c.r(i);
                    return;
                case 4:
                    ((BaseSettings) OperationSettings.this).c.q(i);
                    return;
                case 5:
                    ((BaseSettings) OperationSettings.this).c.i(i);
                    return;
                case 6:
                    ((BaseSettings) OperationSettings.this).c.j(i);
                    return;
                default:
                    return;
            }
        }
    }

    class c extends a.a.b.o.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f410a;
        final /* synthetic */ int b;

        c(int i, int i2) {
            this.f410a = i;
            this.b = i2;
        }

        @Override // a.a.b.o.c
        public void a() {
            OperationSettings.this.a(this.f410a, this.b);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ay /*{ENCODED_INT: 2131230781}*/:
                    OperationSettings operationSettings = OperationSettings.this;
                    operationSettings.a(0, ((BaseSettings) operationSettings).c.G());
                    return;
                case R.id.az /*{ENCODED_INT: 2131230782}*/:
                    OperationSettings operationSettings2 = OperationSettings.this;
                    operationSettings2.a(1, ((BaseSettings) operationSettings2).c.H());
                    return;
                case R.id.b0 /*{ENCODED_INT: 2131230783}*/:
                    OperationSettings operationSettings3 = OperationSettings.this;
                    operationSettings3.a(2, ((BaseSettings) operationSettings3).c.I());
                    return;
                case R.id.b1 /*{ENCODED_INT: 2131230784}*/:
                    OperationSettings operationSettings4 = OperationSettings.this;
                    operationSettings4.a(4, ((BaseSettings) operationSettings4).c.J());
                    return;
                case R.id.b2 /*{ENCODED_INT: 2131230785}*/:
                default:
                    return;
                case R.id.b3 /*{ENCODED_INT: 2131230786}*/:
                    OperationSettings operationSettings5 = OperationSettings.this;
                    operationSettings5.a(3, ((BaseSettings) operationSettings5).c.K());
                    return;
            }
        }
    }

    class e implements View.OnLongClickListener {
        e() {
        }

        public boolean onLongClick(View view) {
            switch (view.getId()) {
                case R.id.ay /*{ENCODED_INT: 2131230781}*/:
                    OperationSettings.this.a(0);
                    break;
                case R.id.az /*{ENCODED_INT: 2131230782}*/:
                    OperationSettings.this.a(1);
                    break;
                case R.id.b0 /*{ENCODED_INT: 2131230783}*/:
                    OperationSettings.this.a(2);
                    break;
                case R.id.b1 /*{ENCODED_INT: 2131230784}*/:
                    OperationSettings.this.a(4);
                    break;
                case R.id.b3 /*{ENCODED_INT: 2131230786}*/:
                    OperationSettings.this.a(3);
                    break;
            }
            return true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gw);
        a2.a(R.string.ca);
        View a3 = a2.a();
        a.a.b.n.a a4 = a.a.b.n.a.a(((BaseActivity) this).b);
        a4.a(a());
        a4.a(new a());
        View b2 = a4.b();
        TextView textView = new TextView(new ContextThemeWrapper(((BaseActivity) this).b, (int) R.style.j));
        a.a.b.p.a.a(textView, a.a.b.p.a.c(((BaseActivity) this).b, R.dimen.e), a.a.b.p.b.a(((BaseActivity) this).b, 10.0f));
        textView.setText(R.string.ia);
        textView.setId(56);
        return a.a.b.p.c.a(a3, b2, textView, ((LayoutInflater) ((BaseActivity) this).b.getSystemService("layout_inflater")).inflate(R.layout.f, (ViewGroup) ((BaseActivity) this).f233a.findViewById(16908290), false));
    }

    private void c() {
        d dVar = new d();
        e eVar = new e();
        View[] viewArr = {(ImageView) findViewById(R.id.ay), (ImageView) findViewById(R.id.az), (ImageView) findViewById(R.id.b0), (ImageView) findViewById(R.id.b3), (ImageView) findViewById(R.id.b1)};
        for (int i = 0; i < 5; i++) {
            View view = viewArr[i];
            if (view != null) {
                view.setClickable(true);
                view.setOnClickListener(dVar);
                view.setOnLongClickListener(eVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b());
        r.b(findViewById(a.a.b.m.a.f));
        c();
    }

    private List<a.a.b.n.b> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.b4, ((BaseSettings) this).c.d()));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.iw, ((BaseSettings) this).c.j0()));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(a.a.b.n.b bVar, int i) {
        int b2 = bVar.b();
        if (b2 == R.string.b4) {
            ((BaseSettings) this).c.c(bVar.e());
        } else if (b2 == R.string.iw) {
            ((BaseSettings) this).c.w(bVar.e());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i == 1) {
            findViewById(R.id.az);
        } else if (i == 2) {
            findViewById(R.id.b0);
        } else if (i == 3) {
            findViewById(R.id.b3);
        } else if (i != 4) {
            findViewById(R.id.ay);
        } else {
            findViewById(R.id.b1);
        }
        h hVar = new h(((BaseActivity) this).b);
        hVar.b(R.array.h, i2);
        hVar.a(new b(i));
        hVar.g();
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        int i2;
        if (i == 0) {
            i2 = ((BaseSettings) this).c.G();
        } else if (i == 1) {
            i2 = ((BaseSettings) this).c.H();
        } else if (i == 2) {
            i2 = ((BaseSettings) this).c.I();
        } else if (i != 3) {
            i2 = i != 4 ? 0 : ((BaseSettings) this).c.J();
        } else {
            i2 = ((BaseSettings) this).c.K();
        }
        new a.a.b.o.a(((BaseActivity) this).f233a, a.a.b.p.a.b(((BaseActivity) this).b, R.array.h, i2), (int) R.string.z, new c(i, i2)).h();
    }
}
