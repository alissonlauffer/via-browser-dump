package a.a.b.m;

import a.a.b.d;
import a.a.b.g;
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

/* compiled from: FrogNavigator */
public class a {
    public static int f = 153;
    public static int g = 256;
    public static int h = 257;
    private static int i = 300;

    /* renamed from: a  reason: collision with root package name */
    private Context f34a;
    private TextView b;
    private ImageView c;
    private RelativeLayout d;
    private int e = 0;

    /* renamed from: a.a.b.m.a$a  reason: collision with other inner class name */
    /* compiled from: FrogNavigator */
    class C0005a implements View.OnClickListener {
        C0005a(a aVar) {
        }

        public void onClick(View view) {
            ((Activity) view.getContext()).finish();
        }
    }

    /* compiled from: FrogNavigator */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f35a;

        b(a aVar, View.OnClickListener onClickListener) {
            this.f35a = onClickListener;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f35a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: FrogNavigator */
    class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f36a;

        c(a aVar, View.OnClickListener onClickListener) {
            this.f36a = onClickListener;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f36a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    private a(Context context) {
        this.f34a = context;
        b();
        c();
    }

    public static a a(Context context) {
        return new a(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    private void c() {
        TextView textView = new TextView(this.f34a);
        this.b = textView;
        a.a.b.p.a.a(textView, g.l);
        this.b.setId(g);
        this.b.setSingleLine();
        this.b.setMaxLines(1);
        this.b.setHeight(a.a.b.p.b.a(this.f34a, 54.0f));
        this.b.setGravity(16);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        int a2 = a.a.b.p.b.a(this.f34a, 0.0f);
        a.a.b.p.a.a(this.b, a.a.b.p.a.c(this.f34a, a.a.b.c.e), a2);
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        d();
        this.d.addView(this.b);
    }

    private void d() {
        if (this.b != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(Build.VERSION.SDK_INT >= 17 ? 17 : 1, h);
            if (this.e > 0) {
                layoutParams.addRule(Build.VERSION.SDK_INT >= 17 ? 16 : 0, (i + this.e) - 1);
            }
            this.b.setLayoutParams(layoutParams);
        }
    }

    public a b(int i2) {
        b(a.a.b.p.a.e(this.f34a, i2));
        return this;
    }

    public a a(int i2) {
        a(this.f34a.getString(i2));
        return this;
    }

    public a b(String str) {
        this.b.setText(str);
        return this;
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f34a);
        this.d = relativeLayout;
        relativeLayout.setId(f);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.a.b.p.a.a(this.d, d.n);
    }

    public a a(String str) {
        a(str, new C0005a(this));
        return this;
    }

    public a a(String str, View.OnClickListener onClickListener) {
        if (this.c == null) {
            ImageView a2 = a(h, a.a.b.p.a.d(this.f34a, d.a4));
            this.c = a2;
            a2.setContentDescription(str);
            this.d.addView(this.c);
        }
        this.c.setOnClickListener(new b(this, onClickListener));
        return this;
    }

    public a a(int i2, View.OnClickListener onClickListener) {
        a(a.a.b.p.a.d(this.f34a, i2), onClickListener);
        return this;
    }

    public a a(Drawable drawable, View.OnClickListener onClickListener) {
        if (drawable == null) {
            return this;
        }
        ImageView a2 = a(i + this.e, drawable);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
        if (this.e == 0) {
            layoutParams.addRule(Build.VERSION.SDK_INT >= 17 ? 21 : 11, -1);
        } else {
            layoutParams.addRule(Build.VERSION.SDK_INT >= 17 ? 16 : 0, (i + this.e) - 1);
        }
        a2.setLayoutParams(layoutParams);
        a2.setOnClickListener(new c(this, onClickListener));
        this.d.addView(a2);
        this.e++;
        d();
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    private ImageView a(int i2, Drawable drawable) {
        ImageView imageView = new ImageView(this.f34a);
        imageView.setId(i2);
        imageView.setImageDrawable(drawable);
        imageView.setColorFilter(a.a.b.p.a.b(this.f34a, a.a.b.a.f));
        a.a.b.p.a.a(imageView, a.a.b.p.a.c(this.f34a, a.a.b.c.f), a.a.b.p.a.c(this.f34a, a.a.b.c.g));
        a.a.b.p.a.a(imageView, d.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, g);
        layoutParams.addRule(8, g);
        int a2 = a.a.b.p.b.a(this.f34a, 4.0f);
        layoutParams.leftMargin = a2;
        layoutParams.rightMargin = a2;
        layoutParams.topMargin = a2;
        layoutParams.bottomMargin = a2;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public View a() {
        return this.d;
    }
}
