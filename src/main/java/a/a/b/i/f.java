package a.a.b.i;

import a.a.b.d;
import a.a.b.g;
import a.a.b.p.b;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FrogMultiChoiceDialog */
public class f extends a<f> {
    private int o = 0;

    /* compiled from: FrogMultiChoiceDialog */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f17a;

        a(i iVar) {
            this.f17a = iVar;
        }

        public void onClick(View view) {
            if (this.f17a != null) {
                if (f.this.b()) {
                    this.f17a.a(((a) f.this).h.isChecked());
                }
                this.f17a.a(f.this.h());
                this.f17a.a();
            }
            f.this.c();
        }
    }

    public f(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    @Override // a.a.b.i.a
    public boolean[] h() {
        int childCount = ((a) this).e.getChildCount();
        if (childCount <= 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[childCount];
        for (int i = 0; i < childCount; i++) {
            zArr[i] = ((CheckBox) ((a) this).e.findViewById(i + 1000)).isChecked();
        }
        return zArr;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean b() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int d() {
        return (super.d() / 4) * 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.a.a(android.widget.TextView, int):void
     arg types: [android.widget.CheckBox, int]
     candidates:
      a.a.b.p.a.a(android.content.Context, int):int
      a.a.b.p.a.a(android.view.View, int):void
      a.a.b.p.a.a(android.view.View, android.graphics.drawable.Drawable):void
      a.a.b.p.a.a(android.view.View, boolean):void
      a.a.b.p.a.a(java.lang.String[], int):boolean
      a.a.b.p.a.a(android.widget.TextView, int):void */
    private void b(String[] strArr, boolean[] zArr) {
        int childCount = ((a) this).e.getChildCount();
        int a2 = b.a(((a) this).f11a, 8.0f);
        int a3 = b.a(((a) this).f11a, Build.VERSION.SDK_INT >= 17 ? 12.0f : 36.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a4 = b.a(((a) this).f11a, 20.0f);
        layoutParams.leftMargin = a4;
        layoutParams.rightMargin = a4;
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 1000;
            CheckBox checkBox = (CheckBox) ((a) this).e.findViewById(i2);
            if (checkBox == null) {
                checkBox = new CheckBox(((a) this).f11a);
                checkBox.setPadding(a3, a2, a3, a2);
                checkBox.setMaxLines(1);
                checkBox.setSingleLine();
                checkBox.setId(i2);
                checkBox.setEllipsize(TextUtils.TruncateAt.END);
                checkBox.setButtonDrawable(d.h);
                a.a.b.p.a.a((TextView) checkBox, g.k);
                ((a) this).e.addView(checkBox, layoutParams);
            }
            checkBox.setText(strArr[i]);
            checkBox.setChecked(zArr[i]);
            if (this.o == 0) {
                this.o = b.a(checkBox, ((a) this).l);
            }
        }
        if (childCount > length) {
            while (length <= childCount) {
                ((a) this).e.removeView((CheckBox) ((a) this).e.findViewById(length + 1000));
                length++;
            }
        }
    }

    public f a(int i, boolean[] zArr) {
        a(((a) this).f11a.getResources().getStringArray(i), zArr);
        return this;
    }

    public f a(String[] strArr, boolean[] zArr) {
        if (strArr == null || strArr.length == 0 || strArr.length != zArr.length) {
            ((a) this).e.setVisibility(8);
        } else {
            b(strArr, zArr);
            ((a) this).e.setVisibility(0);
        }
        return this;
    }

    @Override // a.a.b.i.a
    public f a(String str, i iVar) {
        if (a(((a) this).i, str)) {
            ((a) this).i.setOnClickListener(new a(iVar));
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int a(boolean z) {
        LinearLayout linearLayout = ((a) this).e;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return 0;
        }
        return this.o * ((a) this).e.getChildCount();
    }
}
