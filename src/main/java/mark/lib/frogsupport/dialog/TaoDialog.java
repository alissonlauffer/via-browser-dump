package mark.lib.frogsupport.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mark.lib.frogsupport.C0364c;
import mark.lib.frogsupport.C0365d;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;
import mark.lib.frogsupport.C0368g;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FrogUtils;

/* renamed from: mark.lib.frogsupport.i.c */
/* compiled from: TaoDialog */
public class TaoDialog {

    /* renamed from: a */
    private Dialog f1055a;

    /* renamed from: b */
    C0383k f1056b;

    /* renamed from: c */
    private int f1057c;

    /* renamed from: d */
    private int f1058d;

    /* renamed from: e */
    private int f1059e;

    /* renamed from: f */
    private View f1060f;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$a */
    /* compiled from: TaoDialog */
    public class View$OnFocusChangeListenerC0373a implements View.OnFocusChangeListener {
        View$OnFocusChangeListenerC0373a(TaoDialog cVar) {
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                ((AutoCompleteTextView) view).showDropDown();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$b */
    /* compiled from: TaoDialog */
    public class C0374b implements AdapterView.OnItemClickListener {
        C0374b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener = TaoDialog.this.f1056b.f1076g;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            TaoDialog.this.mo632i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$c */
    /* compiled from: TaoDialog */
    public class C0375c implements AdapterView.OnItemClickListener {
        C0375c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener = TaoDialog.this.f1056b.f1076g;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            TaoDialog.this.mo632i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$d */
    /* compiled from: TaoDialog */
    public class C0376d implements CompoundButton.OnCheckedChangeListener {
        C0376d() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            TaoDialog.this.f1056b.f1074e = Boolean.valueOf(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$e */
    /* compiled from: TaoDialog */
    public class View$OnClickListenerC0377e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckBox f1064a;

        View$OnClickListenerC0377e(TaoDialog cVar, CheckBox checkBox) {
            this.f1064a = checkBox;
        }

        public void onClick(View view) {
            CheckBox checkBox = this.f1064a;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$f */
    /* compiled from: TaoDialog */
    public class View$OnClickListenerC0378f implements View.OnClickListener {
        View$OnClickListenerC0378f() {
        }

        public void onClick(View view) {
            if (TaoDialog.this.f1056b.f1080k != null) {
                C0384l a = C0384l.m1180a();
                ListAdapter listAdapter = TaoDialog.this.f1056b.f1075f;
                if (listAdapter instanceof DialogSelectableAdapter) {
                    a.f1089a = ((DialogSelectableAdapter) listAdapter).mo601d();
                }
                C0383k kVar = TaoDialog.this.f1056b;
                boolean z = false;
                if (kVar.f1078i) {
                    View view2 = kVar.f1077h;
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        int childCount = viewGroup.getChildCount();
                        String[] strArr = new String[childCount];
                        int i = 0;
                        for (int i2 = 0; i2 < childCount; i2++) {
                            if (viewGroup.getChildAt(i2) instanceof EditText) {
                                strArr[i] = ((EditText) viewGroup.getChildAt(i2)).getText().toString();
                                i++;
                            }
                        }
                        a.f1091c = (String[]) Arrays.copyOf(strArr, i);
                    }
                }
                C0383k kVar2 = TaoDialog.this.f1056b;
                if (kVar2.f1074e == Boolean.TRUE) {
                    z = true;
                }
                a.f1090b = z;
                kVar2.f1080k.mo659a(view, a);
            }
            TaoDialog.this.mo632i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$g */
    /* compiled from: TaoDialog */
    public class View$OnClickListenerC0379g implements View.OnClickListener {
        View$OnClickListenerC0379g() {
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = TaoDialog.this.f1056b.f1082m;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TaoDialog.this.mo632i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.c$h */
    /* compiled from: TaoDialog */
    public class View$OnClickListenerC0380h implements View.OnClickListener {
        View$OnClickListenerC0380h() {
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = TaoDialog.this.f1056b.f1084o;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TaoDialog.this.mo632i();
        }
    }

    /* renamed from: mark.lib.frogsupport.i.c$i */
    /* compiled from: TaoDialog */
    public static class C0381i {

        /* renamed from: a */
        private int f1068a;

        /* renamed from: b */
        private String f1069b;

        public C0381i(int i, String str) {
            this.f1068a = i;
            this.f1069b = str;
        }

        /* renamed from: a */
        public int mo657a() {
            return this.f1068a;
        }

        /* renamed from: b */
        public String mo658b() {
            return this.f1069b;
        }
    }

    /* renamed from: mark.lib.frogsupport.i.c$j */
    /* compiled from: TaoDialog */
    public interface AbstractC0382j {
        /* renamed from: a */
        void mo659a(View view, C0384l lVar);
    }

    /* renamed from: mark.lib.frogsupport.i.c$l */
    /* compiled from: TaoDialog */
    public static class C0384l {

        /* renamed from: a */
        public int[] f1089a;

        /* renamed from: b */
        public boolean f1090b;

        /* renamed from: c */
        public String[] f1091c;

        private C0384l() {
        }

        /* renamed from: a */
        public static C0384l m1180a() {
            return new C0384l();
        }

        public String toString() {
            return "Result{selected=" + Arrays.toString(this.f1089a) + ", checked=" + this.f1090b + ", edit=" + Arrays.toString(this.f1091c) + '}';
        }
    }

    private TaoDialog(Context context) {
        C0383k kVar = new C0383k(null);
        this.f1056b = kVar;
        kVar.f1070a = context;
        View findViewById = ((Activity) context).findViewById(16908290);
        if (findViewById != null) {
            this.f1057c = findViewById.getHeight();
            this.f1058d = findViewById.getWidth();
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            this.f1059e = iArr[1];
            return;
        }
        this.f1057c = FrogUtils.m1359f(context);
        this.f1058d = FrogUtils.m1360g(context);
        this.f1059e = FrogUtils.m1358e(context);
    }

    /* renamed from: g */
    public static TaoDialog m1134g(Context context) {
        return new TaoDialog(context);
    }

    /* renamed from: h */
    private Dialog m1135h(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        Dialog dialog = new Dialog(this.f1056b.f1070a, C0368g.h);
        View inflate = LayoutInflater.from(this.f1056b.f1070a).inflate(C0367f.j, (ViewGroup) ((Activity) this.f1056b.f1070a).findViewById(16908290), false);
        this.f1060f = inflate;
        if (this.f1056b.f1071b != null) {
            TextView textView = (TextView) inflate.findViewById(C0366e.bg);
            textView.setVisibility(0);
            textView.setText(this.f1056b.f1071b);
        }
        if (this.f1056b.f1072c != null) {
            TextView textView2 = (TextView) this.f1060f.findViewById(C0366e.bb);
            textView2.setVisibility(0);
            textView2.setText(this.f1056b.f1072c);
            int b = FrogUtils.m1355b(textView2, i);
            if (i2 <= 0 || b <= i2) {
                C0383k kVar = this.f1056b;
                if (kVar.f1075f == null && kVar.f1077h == null) {
                    textView2.setMinHeight(FrogUtils.m1354a(kVar.f1070a, 76.0f));
                }
            } else {
                this.f1060f.findViewById(C0366e.ao).getLayoutParams().height = i2;
            }
        }
        ListAdapter listAdapter = this.f1056b.f1075f;
        if (listAdapter != null && listAdapter.getCount() > 0) {
            ListView listView = (ListView) this.f1060f.findViewById(C0366e.a9);
            listView.setVisibility(0);
            ListAdapter listAdapter2 = this.f1056b.f1075f;
            if (listAdapter2 instanceof DialogSelectableAdapter) {
                DialogSelectableAdapter bVar = (DialogSelectableAdapter) listAdapter2;
                bVar.mo599b(listView, bVar.mo602f() ? null : new C0374b());
            } else {
                listView.setAdapter(listAdapter2);
                listView.setOnItemClickListener(new C0375c());
            }
            View view = this.f1056b.f1075f.getView(0, null, listView);
            int count = this.f1056b.f1075f.getCount();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredHeight == 0) {
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = view.getMeasuredHeight();
            }
            if (measuredHeight * count > i2) {
                listView.getLayoutParams().height = i2;
            }
        }
        if (this.f1056b.f1077h != null) {
            FrameLayout frameLayout = (FrameLayout) this.f1060f.findViewById(C0366e.w);
            frameLayout.setVisibility(0);
            frameLayout.addView(this.f1056b.f1077h);
        }
        if (this.f1056b.f1073d != null) {
            TextView textView3 = (TextView) this.f1060f.findViewById(C0366e.b7);
            textView3.setVisibility(0);
            textView3.setText(this.f1056b.f1073d);
            if (this.f1056b.f1074e != null) {
                CheckBox checkBox = (CheckBox) this.f1060f.findViewById(C0366e.j);
                checkBox.setVisibility(0);
                checkBox.setChecked(this.f1056b.f1074e == Boolean.TRUE);
                checkBox.setOnCheckedChangeListener(new C0376d());
                View findViewById = this.f1060f.findViewById(C0366e.a7);
                findViewById.setClickable(true);
                findViewById.setFocusable(true);
                findViewById.setOnClickListener(new View$OnClickListenerC0377e(this, checkBox));
            }
        }
        if (this.f1056b.f1079j != null) {
            TextView textView4 = (TextView) this.f1060f.findViewById(C0366e.b2);
            if (i3 >= 14) {
                textView4.setAllCaps(true);
            }
            textView4.setVisibility(0);
            textView4.setText(this.f1056b.f1079j);
            textView4.setOnClickListener(new View$OnClickListenerC0378f());
        }
        if (this.f1056b.f1081l != null) {
            TextView textView5 = (TextView) this.f1060f.findViewById(C0366e.b0);
            if (i3 >= 14) {
                textView5.setAllCaps(true);
            }
            textView5.setVisibility(0);
            textView5.setText(this.f1056b.f1081l);
            textView5.setOnClickListener(new View$OnClickListenerC0379g());
        }
        if (this.f1056b.f1083n != null) {
            TextView textView6 = (TextView) this.f1060f.findViewById(C0366e.b1);
            if (i3 >= 14) {
                textView6.setAllCaps(true);
            }
            textView6.setVisibility(0);
            textView6.setText(this.f1056b.f1083n);
            textView6.setOnClickListener(new View$OnClickListenerC0380h());
        }
        dialog.setContentView(this.f1060f);
        return dialog;
    }

    /* renamed from: k */
    private void m1136k(EditText editText, int i, String str, String str2, int i2) {
        editText.setId(i);
        editText.setText(str);
        editText.setHint(str2);
        CompatUtils.m1343m(editText, 0, CompatUtils.m1333c(this.f1056b.f1070a, C0364c.f) / 2);
        CompatUtils.m1345o(editText, C0368g.i);
        CompatUtils.m1341k(editText, CompatUtils.m1334d(this.f1056b.f1070a, C0365d.m));
        editText.setGravity(48);
        editText.setSelectAllOnFocus(true);
        if (i2 > 1) {
            editText.setInputType(671745);
            editText.setImeOptions(1);
        } else {
            editText.setInputType(524289);
            editText.setImeOptions(5);
        }
        editText.setMaxLines(i2);
        editText.setMinLines(i2);
        editText.setLines(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int c = CompatUtils.m1333c(this.f1056b.f1070a, C0364c.h);
        layoutParams.topMargin = c;
        layoutParams.bottomMargin = c;
        int c2 = CompatUtils.m1333c(this.f1056b.f1070a, C0364c.g);
        layoutParams.leftMargin = c2;
        layoutParams.rightMargin = c2;
        editText.setLayoutParams(layoutParams);
    }

    /* renamed from: A */
    public TaoDialog mo609A(String str, View.OnClickListener onClickListener) {
        C0383k kVar = this.f1056b;
        kVar.f1081l = str;
        kVar.f1082m = onClickListener;
        return this;
    }

    /* renamed from: B */
    public TaoDialog mo610B(int i, View.OnClickListener onClickListener) {
        mo611C(this.f1056b.f1070a.getString(i), onClickListener);
        return this;
    }

    /* renamed from: C */
    public TaoDialog mo611C(String str, View.OnClickListener onClickListener) {
        C0383k kVar = this.f1056b;
        kVar.f1083n = str;
        kVar.f1084o = onClickListener;
        return this;
    }

    /* renamed from: D */
    public TaoDialog mo612D(DialogInterface.OnCancelListener onCancelListener) {
        this.f1056b.f1088s = onCancelListener;
        return this;
    }

    /* renamed from: E */
    public TaoDialog mo613E(DialogInterface.OnDismissListener onDismissListener) {
        this.f1056b.f1087r = onDismissListener;
        return this;
    }

    /* renamed from: F */
    public TaoDialog mo614F(int i, AbstractC0382j jVar) {
        mo615G(this.f1056b.f1070a.getString(i), jVar);
        return this;
    }

    /* renamed from: G */
    public TaoDialog mo615G(String str, AbstractC0382j jVar) {
        C0383k kVar = this.f1056b;
        kVar.f1079j = str;
        kVar.f1080k = jVar;
        return this;
    }

    /* renamed from: H */
    public TaoDialog mo616H(int i) {
        mo617I(this.f1056b.f1070a.getString(i));
        return this;
    }

    /* renamed from: I */
    public TaoDialog mo617I(String str) {
        if (str != null && !str.isEmpty()) {
            LinearLayout linearLayout = new LinearLayout(this.f1056b.f1070a);
            linearLayout.setOrientation(0);
            ProgressBar progressBar = new ProgressBar(this.f1056b.f1070a);
            progressBar.setIndeterminate(false);
            progressBar.setIndeterminateDrawable(CompatUtils.m1334d(this.f1056b.f1070a, C0365d.n));
            TextView textView = new TextView(this.f1056b.f1070a);
            int a = FrogUtils.m1354a(this.f1056b.f1070a, 4.0f);
            int a2 = FrogUtils.m1354a(this.f1056b.f1070a, 16.0f);
            CompatUtils.m1343m(linearLayout, a2, a);
            CompatUtils.m1343m(progressBar, 0, 0);
            CompatUtils.m1344n(textView, a2, 0, 0, 0);
            CompatUtils.m1345o(textView, C0368g.l);
            linearLayout.addView(progressBar);
            linearLayout.addView(textView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.gravity = 16;
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            this.f1056b.f1077h = linearLayout;
        }
        return this;
    }

    /* renamed from: J */
    public TaoDialog mo618J(int i, int i2, AdapterView.OnItemClickListener onItemClickListener) {
        mo619K(this.f1056b.f1070a.getResources().getStringArray(i), i2, onItemClickListener);
        return this;
    }

    /* renamed from: K */
    public TaoDialog mo619K(String[] strArr, int i, AdapterView.OnItemClickListener onItemClickListener) {
        this.f1056b.f1075f = new DialogSelectableAdapter(Arrays.asList(strArr), new int[]{i}, false);
        this.f1056b.f1076g = onItemClickListener;
        return this;
    }

    /* renamed from: L */
    public TaoDialog mo620L(int i) {
        C0383k kVar = this.f1056b;
        kVar.f1071b = kVar.f1070a.getString(i);
        return this;
    }

    /* renamed from: M */
    public TaoDialog mo621M(String str) {
        this.f1056b.f1071b = str;
        return this;
    }

    /* renamed from: N */
    public void mo622N() {
        C0383k kVar;
        if (this.f1055a == null && (kVar = this.f1056b) != null) {
            boolean z = false;
            boolean z2 = FrogUtils.m1357d(kVar.f1070a) >= 6.6d;
            int i = this.f1057c;
            int i2 = this.f1058d;
            boolean z3 = ((double) (((float) i) / ((float) i2))) >= 1.94d;
            int min = Math.min(i2, i);
            C0383k kVar2 = this.f1056b;
            int i3 = kVar2.f1078i ? 8 : 6;
            if ((z2 || this.f1058d > this.f1057c) && min > FrogUtils.m1354a(kVar2.f1070a, (float) (i3 * 60))) {
                min = FrogUtils.m1354a(this.f1056b.f1070a, (float) ((i3 - 1) * 60));
            }
            Dialog h = m1135h(min, (Math.min(this.f1057c, this.f1058d) / 7) * 5);
            this.f1055a = h;
            h.setCancelable(this.f1056b.f1085p);
            Dialog dialog = this.f1055a;
            C0383k kVar3 = this.f1056b;
            if (kVar3.f1085p && kVar3.f1086q) {
                z = true;
            }
            dialog.setCanceledOnTouchOutside(z);
            this.f1055a.setOnDismissListener(this.f1056b.f1087r);
            this.f1055a.setOnCancelListener(this.f1056b.f1088s);
            if (this.f1055a.getWindow() != null) {
                WindowManager.LayoutParams attributes = this.f1055a.getWindow().getAttributes();
                attributes.width = min;
                if (z3 || z2 || this.f1057c <= this.f1058d) {
                    attributes.gravity = 17;
                } else {
                    attributes.gravity = 80;
                }
                attributes.windowAnimations = C0368g.d;
                this.f1055a.getWindow().setAttributes(attributes);
            }
        }
        Dialog dialog2 = this.f1055a;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    /* renamed from: O */
    public void mo623O(int i, int i2) {
        C0383k kVar;
        if (this.f1055a == null && (kVar = this.f1056b) != null) {
            int min = Math.min(FrogUtils.m1354a(kVar.f1070a, 360.0f), (Math.min(this.f1057c, this.f1058d) / 7) * (kVar.f1078i ? 5 : 4));
            Dialog h = m1135h(min, -1);
            this.f1055a = h;
            Window window = h.getWindow();
            if (window != null) {
                window.getDecorView().measure(View.MeasureSpec.makeMeasureSpec(min, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                window.setSoftInputMode(16);
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (i > (this.f1058d >> 1)) {
                    i -= min;
                }
                int i3 = 48;
                int i4 = this.f1057c;
                if (i2 > (i4 >> 1)) {
                    i2 = i4 - i2;
                    i3 = 80;
                }
                attributes.gravity = i3 | 3;
                attributes.x = i;
                attributes.y = i2;
                attributes.width = min;
                attributes.flags &= -3;
                window.setAttributes(attributes);
            }
            this.f1055a.setCancelable(true);
            this.f1055a.setCanceledOnTouchOutside(true);
        }
        Dialog dialog = this.f1055a;
        if (dialog != null) {
            dialog.show();
        }
    }

    /* renamed from: P */
    public void mo624P(View view) {
        mo625Q(view, view.getWidth(), (view.getHeight() / 2) - this.f1059e);
    }

    /* renamed from: Q */
    public void mo625Q(View view, int i, int i2) {
        if (view == null) {
            mo622N();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + i;
        iArr[1] = iArr[1] + i2;
        mo623O(iArr[0], iArr[1]);
    }

    /* renamed from: a */
    public TaoDialog mo626a(int i, String str, int i2, String[] strArr) {
        mo627b(i, str, this.f1056b.f1070a.getString(i2), strArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [mark.lib.frogsupport.i.c] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    public TaoDialog mo627b(int i, String str, String str2, String[] strArr) {
        LinearLayout linearLayout;
        C0383k kVar = this.f1056b;
        kVar.f1078i = true;
        View view = kVar.f1077h;
        if (view instanceof ViewGroup) {
            linearLayout = (ViewGroup) view;
        } else {
            LinearLayout linearLayout2 = new LinearLayout(this.f1056b.f1070a);
            linearLayout2.setOrientation(1);
            this.f1056b.f1077h = linearLayout2;
            linearLayout = linearLayout2;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f1056b.f1070a, C0367f.m, strArr);
        AutoCompleteTextView autoCompleteTextView = new AutoCompleteTextView(this.f1056b.f1070a);
        m1136k(autoCompleteTextView, i, str, str2, 1);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnFocusChangeListener(new View$OnFocusChangeListenerC0373a(this));
        linearLayout.addView(autoCompleteTextView);
        return this;
    }

    /* renamed from: c */
    public TaoDialog mo628c(int i, String str, int i2, int i3) {
        mo629d(i, str, this.f1056b.f1070a.getString(i2), i3);
        return this;
    }

    /* renamed from: d */
    public TaoDialog mo629d(int i, String str, String str2, int i2) {
        LinearLayout linearLayout;
        C0383k kVar = this.f1056b;
        kVar.f1078i = true;
        View view = kVar.f1077h;
        if (view instanceof ViewGroup) {
            linearLayout = (ViewGroup) view;
        } else {
            LinearLayout linearLayout2 = new LinearLayout(this.f1056b.f1070a);
            linearLayout2.setOrientation(1);
            this.f1056b.f1077h = linearLayout2;
            linearLayout = linearLayout2;
        }
        EditText editText = new EditText(this.f1056b.f1070a);
        m1136k(editText, i, str, str2, i2);
        linearLayout.addView(editText);
        return this;
    }

    /* renamed from: e */
    public TaoDialog mo630e(String str, int i, int i2) {
        mo629d(-1, str, this.f1056b.f1070a.getString(i), i2);
        return this;
    }

    /* renamed from: f */
    public TaoDialog mo631f(String str, String str2, int i) {
        mo629d(-1, str, str2, i);
        return this;
    }

    /* renamed from: i */
    public void mo632i() {
        Dialog dialog = this.f1055a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* renamed from: j */
    public EditText mo633j(int i) {
        View view = this.f1056b.f1077h;
        if (view == null) {
            return null;
        }
        return (EditText) view.findViewById(i);
    }

    /* renamed from: l */
    public boolean mo634l() {
        Dialog dialog = this.f1055a;
        return dialog != null && dialog.isShowing();
    }

    /* renamed from: m */
    public TaoDialog mo635m(boolean z) {
        this.f1056b.f1085p = z;
        return this;
    }

    /* renamed from: n */
    public TaoDialog mo636n(boolean z) {
        this.f1056b.f1086q = z;
        return this;
    }

    /* renamed from: o */
    public TaoDialog mo637o(int i, boolean z) {
        C0383k kVar = this.f1056b;
        kVar.f1073d = kVar.f1070a.getString(i);
        this.f1056b.f1074e = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: p */
    public TaoDialog mo638p(String str, boolean z) {
        C0383k kVar = this.f1056b;
        kVar.f1073d = str;
        kVar.f1074e = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: q */
    public TaoDialog mo639q(View view) {
        this.f1056b.f1077h = view;
        return this;
    }

    /* renamed from: r */
    public TaoDialog mo640r(int i) {
        C0383k kVar = this.f1056b;
        kVar.f1073d = kVar.f1070a.getString(i);
        return this;
    }

    /* renamed from: s */
    public TaoDialog mo641s(String str) {
        this.f1056b.f1073d = str;
        View view = this.f1060f;
        if (view != null) {
            ((TextView) view.findViewById(C0366e.b7)).setText(this.f1056b.f1073d);
        }
        return this;
    }

    /* renamed from: t */
    public TaoDialog mo642t(List<C0381i> list, AdapterView.OnItemClickListener onItemClickListener) {
        this.f1056b.f1075f = new DialogMenuAdapter(this.f1056b.f1070a, list);
        this.f1056b.f1076g = onItemClickListener;
        return this;
    }

    /* renamed from: u */
    public TaoDialog mo643u(String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(new C0381i(i, strArr[i]));
        }
        mo642t(arrayList, onItemClickListener);
        return this;
    }

    /* renamed from: v */
    public TaoDialog mo644v(int i) {
        C0383k kVar = this.f1056b;
        kVar.f1072c = kVar.f1070a.getString(i);
        return this;
    }

    /* renamed from: w */
    public TaoDialog mo645w(String str) {
        this.f1056b.f1072c = str;
        return this;
    }

    /* renamed from: x */
    public TaoDialog mo646x(int i, int[] iArr) {
        mo647y(this.f1056b.f1070a.getResources().getStringArray(i), iArr);
        return this;
    }

    /* renamed from: y */
    public TaoDialog mo647y(String[] strArr, int[] iArr) {
        this.f1056b.f1075f = new DialogSelectableAdapter(Arrays.asList(strArr), iArr, true);
        return this;
    }

    /* renamed from: z */
    public TaoDialog mo648z(int i, View.OnClickListener onClickListener) {
        mo609A(this.f1056b.f1070a.getString(i), onClickListener);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: mark.lib.frogsupport.i.c$k */
    /* compiled from: TaoDialog */
    public static class C0383k {

        /* renamed from: a */
        public Context f1070a;

        /* renamed from: b */
        public String f1071b;

        /* renamed from: c */
        public String f1072c;

        /* renamed from: d */
        public String f1073d;

        /* renamed from: e */
        public Boolean f1074e;

        /* renamed from: f */
        public ListAdapter f1075f;

        /* renamed from: g */
        public AdapterView.OnItemClickListener f1076g;

        /* renamed from: h */
        public View f1077h;

        /* renamed from: i */
        public boolean f1078i;

        /* renamed from: j */
        public String f1079j;

        /* renamed from: k */
        public AbstractC0382j f1080k;

        /* renamed from: l */
        public String f1081l;

        /* renamed from: m */
        public View.OnClickListener f1082m;

        /* renamed from: n */
        public String f1083n;

        /* renamed from: o */
        public View.OnClickListener f1084o;

        /* renamed from: p */
        public boolean f1085p;

        /* renamed from: q */
        public boolean f1086q;

        /* renamed from: r */
        public DialogInterface.OnDismissListener f1087r;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f1088s;

        private C0383k() {
            this.f1085p = true;
            this.f1086q = true;
        }

        /* synthetic */ C0383k(View$OnFocusChangeListenerC0373a aVar) {
            this();
        }
    }
}
