package mark.via.ui.settings;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.settings.OnFrogSettingsClickListener;
import mark.lib.frogsupport.toast.FrogToast;
import mark.lib.frogsupport.toast.OnFrogToastListener;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FrogUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.via.gp.R;
import mark.via.utils.ViewUtils;

public class OperationSettings extends BaseSettings {

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.OperationSettings$a */
    public class C0587a implements OnFrogSettingsClickListener {
        C0587a() {
        }

        @Override // mark.lib.frogsupport.settings.OnFrogSettingsClickListener
        /* renamed from: a */
        public void mo764a(FrogSettingsBean bVar, int i) {
            OperationSettings.this.m2752f(bVar, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.OperationSettings$b */
    public class C0588b extends OnFrogToastListener {

        /* renamed from: a */
        final /* synthetic */ int f1818a;

        /* renamed from: b */
        final /* synthetic */ int f1819b;

        C0588b(int i, int i2) {
            this.f1818a = i;
            this.f1819b = i2;
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            OperationSettings.this.m2756k(this.f1818a, this.f1819b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.OperationSettings$c */
    public class View$OnClickListenerC0589c implements View.OnClickListener {
        View$OnClickListenerC0589c() {
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.au /* 2131230777 */:
                    OperationSettings operationSettings = OperationSettings.this;
                    operationSettings.m2756k(0, operationSettings.f1803c.mo1103O());
                    return;
                case R.id.av /* 2131230778 */:
                    OperationSettings operationSettings2 = OperationSettings.this;
                    operationSettings2.m2756k(1, operationSettings2.f1803c.mo1106P());
                    return;
                case R.id.aw /* 2131230779 */:
                    OperationSettings operationSettings3 = OperationSettings.this;
                    operationSettings3.m2756k(2, operationSettings3.f1803c.mo1109Q());
                    return;
                case R.id.ax /* 2131230780 */:
                    OperationSettings operationSettings4 = OperationSettings.this;
                    operationSettings4.m2756k(4, operationSettings4.f1803c.mo1112R());
                    return;
                case R.id.ay /* 2131230781 */:
                default:
                    return;
                case R.id.az /* 2131230782 */:
                    OperationSettings operationSettings5 = OperationSettings.this;
                    operationSettings5.m2756k(3, operationSettings5.f1803c.mo1115S());
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.OperationSettings$d */
    public class View$OnLongClickListenerC0590d implements View.OnLongClickListener {
        View$OnLongClickListenerC0590d() {
        }

        public boolean onLongClick(View view) {
            switch (view.getId()) {
                case R.id.au /* 2131230777 */:
                    OperationSettings.this.m2755j(0);
                    break;
                case R.id.av /* 2131230778 */:
                    OperationSettings.this.m2755j(1);
                    break;
                case R.id.aw /* 2131230779 */:
                    OperationSettings.this.m2755j(2);
                    break;
                case R.id.ax /* 2131230780 */:
                    OperationSettings.this.m2755j(4);
                    break;
                case R.id.az /* 2131230782 */:
                    OperationSettings.this.m2755j(3);
                    break;
            }
            return true;
        }
    }

    /* renamed from: d */
    private List<FrogSettingsBean> m2750d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.b5, this.f1803c.mo1151h()));
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.jn, this.f1803c.mo1197w0()));
        return arrayList;
    }

    /* renamed from: e */
    private View m2751e() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.hg);
        g.mo734k(R.string.cg);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo742d(m2750d());
        j.mo748l(new C0587a());
        View o = j.mo750o();
        TextView textView = new TextView(new ContextThemeWrapper(this.f1039b, (int) R.style.k));
        CompatUtils.m1343m(textView, CompatUtils.m1333c(this.f1039b, R.dimen.j), FrogUtils.m1354a(this.f1039b, 10.0f));
        textView.setText(R.string.iw);
        textView.setId(56);
        return LayoutUtils.m1365c(p, o, textView, ((LayoutInflater) this.f1039b.getSystemService("layout_inflater")).inflate(R.layout.e, (ViewGroup) this.f1038a.findViewById(16908290), false));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private void m2752f(FrogSettingsBean bVar, int i) {
        int b = bVar.mo754b();
        if (b == R.string.b5) {
            this.f1803c.mo1075E0(bVar.mo757e());
        } else if (b == R.string.jn) {
            this.f1803c.mo1105O1(bVar.mo757e());
        }
    }

    /* renamed from: g */
    private void m2753g() {
        View$OnClickListenerC0589c cVar = new View$OnClickListenerC0589c();
        View$OnLongClickListenerC0590d dVar = new View$OnLongClickListenerC0590d();
        View[] viewArr = {(ImageView) findViewById(R.id.au), (ImageView) findViewById(R.id.av), (ImageView) findViewById(R.id.aw), (ImageView) findViewById(R.id.az), (ImageView) findViewById(R.id.ax)};
        for (int i = 0; i < 5; i++) {
            View view = viewArr[i];
            if (view != null) {
                view.setClickable(true);
                view.setOnClickListener(cVar);
                view.setOnLongClickListener(dVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void mo1504i(int i, AdapterView adapterView, View view, int i2, long j) {
        switch (i) {
            case 0:
                this.f1803c.mo1165l1(i2);
                return;
            case 1:
                this.f1803c.mo1168m1(i2);
                return;
            case 2:
                this.f1803c.mo1171n1(i2);
                return;
            case 3:
                this.f1803c.mo1177p1(i2);
                return;
            case 4:
                this.f1803c.mo1174o1(i2);
                return;
            case 5:
                this.f1803c.mo1126X0(i2);
                return;
            case 6:
                this.f1803c.mo1128Y0(i2);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private void m2755j(int i) {
        int i2;
        if (i == 0) {
            i2 = this.f1803c.mo1103O();
        } else if (i == 1) {
            i2 = this.f1803c.mo1106P();
        } else if (i == 2) {
            i2 = this.f1803c.mo1109Q();
        } else if (i != 3) {
            i2 = i != 4 ? 0 : this.f1803c.mo1112R();
        } else {
            i2 = this.f1803c.mo1115S();
        }
        new FrogToast(this.f1038a, CompatUtils.m1338h(this.f1039b, R.array.h, i2), (int) R.string.z, new C0588b(i, i2)).mo773m();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: k */
    private void m2756k(int i, int i2) {
        if (i == 1) {
            findViewById(R.id.av);
        } else if (i == 2) {
            findViewById(R.id.aw);
        } else if (i == 3) {
            findViewById(R.id.az);
        } else if (i != 4) {
            findViewById(R.id.au);
        } else {
            findViewById(R.id.ax);
        }
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo618J(R.array.h, i2, new C0670u0(this, i));
        g.mo622N();
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m2751e());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
        m2753g();
    }
}
