package mark.lib.frogsupport.navigator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import mark.lib.frogsupport.C0361a;
import mark.lib.frogsupport.C0364c;
import mark.lib.frogsupport.C0365d;
import mark.lib.frogsupport.C0368g;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FrogUtils;

/* renamed from: mark.lib.frogsupport.m.a */
/* compiled from: FrogNavigator */
public class FrogNavigator {

    /* renamed from: f */
    public static int f1148f = 153;

    /* renamed from: g */
    public static int f1149g = 256;

    /* renamed from: h */
    public static int f1150h = 257;

    /* renamed from: i */
    private static int f1151i = 300;

    /* renamed from: a */
    private Context f1152a;

    /* renamed from: b */
    private TextView f1153b;

    /* renamed from: c */
    private ImageView f1154c;

    /* renamed from: d */
    private RelativeLayout f1155d;

    /* renamed from: e */
    private int f1156e = 0;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.m.a$a */
    /* compiled from: FrogNavigator */
    public class View$OnClickListenerC0396a implements View.OnClickListener {
        View$OnClickListenerC0396a(FrogNavigator aVar) {
        }

        public void onClick(View view) {
            ((Activity) view.getContext()).onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.m.a$b */
    /* compiled from: FrogNavigator */
    public class View$OnClickListenerC0397b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View.OnClickListener f1157a;

        View$OnClickListenerC0397b(FrogNavigator aVar, View.OnClickListener onClickListener) {
            this.f1157a = onClickListener;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f1157a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.m.a$c */
    /* compiled from: FrogNavigator */
    public class View$OnClickListenerC0398c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View.OnClickListener f1158a;

        View$OnClickListenerC0398c(FrogNavigator aVar, View.OnClickListener onClickListener) {
            this.f1158a = onClickListener;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f1158a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    private FrogNavigator(Context context) {
        this.f1152a = context;
        m1259e();
        m1260f();
    }

    /* renamed from: e */
    private void m1259e() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1152a);
        this.f1155d = relativeLayout;
        relativeLayout.setId(f1148f);
        this.f1155d.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        CompatUtils.m1340j(this.f1155d, C0365d.c);
    }

    /* renamed from: f */
    private void m1260f() {
        TextView textView = new TextView(this.f1152a);
        this.f1153b = textView;
        CompatUtils.m1345o(textView, C0368g.f);
        this.f1153b.setId(f1149g);
        this.f1153b.setSingleLine();
        this.f1153b.setMaxLines(1);
        this.f1153b.setHeight(FrogUtils.m1354a(this.f1152a, 54.0f));
        this.f1153b.setGravity(16);
        this.f1153b.setEllipsize(TextUtils.TruncateAt.END);
        int a = FrogUtils.m1354a(this.f1152a, 0.0f);
        CompatUtils.m1343m(this.f1153b, CompatUtils.m1333c(this.f1152a, C0364c.d), a);
        this.f1153b.setTypeface(Typeface.defaultFromStyle(1));
        m1264o();
        this.f1155d.addView(this.f1153b);
    }

    /* renamed from: g */
    public static FrogNavigator m1261g(Context context) {
        return new FrogNavigator(context);
    }

    /* renamed from: h */
    private ImageView m1262h(Drawable drawable) {
        ImageView imageView = new ImageView(this.f1152a);
        imageView.setImageDrawable(drawable);
        imageView.setColorFilter(CompatUtils.m1332b(this.f1152a, C0361a.a));
        CompatUtils.m1343m(imageView, CompatUtils.m1333c(this.f1152a, C0364c.e), CompatUtils.m1333c(this.f1152a, C0364c.f));
        CompatUtils.m1340j(imageView, C0365d.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, f1149g);
        layoutParams.addRule(8, f1149g);
        int a = FrogUtils.m1354a(this.f1152a, 4.0f);
        layoutParams.leftMargin = a;
        layoutParams.rightMargin = a;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = a;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* renamed from: i */
    private TextView m1263i(String str) {
        TextView textView = new TextView(this.f1152a);
        textView.setText(str);
        textView.setSingleLine();
        textView.setMaxLines(1);
        textView.setLines(1);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            textView.setAllCaps(true);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (i >= 23) {
            textView.setTextAppearance(C0368g.e);
        } else {
            textView.setTextAppearance(this.f1152a, C0368g.e);
        }
        textView.setGravity(17);
        CompatUtils.m1343m(textView, CompatUtils.m1333c(this.f1152a, C0364c.f), 0);
        CompatUtils.m1340j(textView, C0365d.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, f1149g);
        layoutParams.addRule(8, f1149g);
        int a = FrogUtils.m1354a(this.f1152a, 4.0f);
        layoutParams.leftMargin = a;
        layoutParams.rightMargin = a;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = a;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* renamed from: o */
    private void m1264o() {
        if (this.f1153b != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = Build.VERSION.SDK_INT;
            layoutParams.addRule(i >= 17 ? 17 : 1, f1150h);
            int i2 = this.f1156e;
            if (i2 > 0) {
                layoutParams.addRule(i >= 17 ? 16 : 0, (f1151i + i2) - 1);
            }
            this.f1153b.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    public FrogNavigator mo729a(int i, View.OnClickListener onClickListener) {
        mo730b(CompatUtils.m1334d(this.f1152a, i), onClickListener);
        return this;
    }

    /* renamed from: b */
    public FrogNavigator mo730b(Drawable drawable, View.OnClickListener onClickListener) {
        if (drawable == null) {
            return this;
        }
        mo731c(m1262h(drawable), onClickListener);
        return this;
    }

    /* renamed from: c */
    public FrogNavigator mo731c(View view, View.OnClickListener onClickListener) {
        int i = Build.VERSION.SDK_INT;
        if (view == null) {
            return this;
        }
        view.setId(f1151i + this.f1156e);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        int i2 = this.f1156e;
        if (i2 == 0) {
            layoutParams.addRule(i >= 17 ? 21 : 11, -1);
        } else {
            layoutParams.addRule(i >= 17 ? 16 : 0, (f1151i + i2) - 1);
        }
        view.setLayoutParams(layoutParams);
        view.setOnClickListener(new View$OnClickListenerC0398c(this, onClickListener));
        this.f1155d.addView(view);
        this.f1156e++;
        m1264o();
        return this;
    }

    /* renamed from: d */
    public FrogNavigator mo732d(String str, View.OnClickListener onClickListener) {
        mo731c(m1263i(str), onClickListener);
        return this;
    }

    /* renamed from: j */
    public FrogNavigator mo733j(String str, View.OnClickListener onClickListener) {
        if (this.f1154c == null) {
            ImageView h = m1262h(CompatUtils.m1334d(this.f1152a, C0365d.e));
            this.f1154c = h;
            h.setId(f1150h);
            this.f1154c.setContentDescription(str);
            this.f1155d.addView(this.f1154c);
        }
        this.f1154c.setOnClickListener(new View$OnClickListenerC0397b(this, onClickListener));
        return this;
    }

    /* renamed from: k */
    public FrogNavigator mo734k(int i) {
        mo735l(this.f1152a.getString(i));
        return this;
    }

    /* renamed from: l */
    public FrogNavigator mo735l(String str) {
        mo733j(str, new View$OnClickListenerC0396a(this));
        return this;
    }

    /* renamed from: m */
    public FrogNavigator mo736m(int i) {
        mo737n(CompatUtils.m1336f(this.f1152a, i));
        return this;
    }

    /* renamed from: n */
    public FrogNavigator mo737n(String str) {
        this.f1153b.setText(str);
        return this;
    }

    /* renamed from: p */
    public View mo738p() {
        return this.f1155d;
    }
}
