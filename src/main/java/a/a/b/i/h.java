package a.a.b.i;

import a.a.b.d;
import a.a.b.g;
import a.a.b.p.b;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/* compiled from: FrogSingleChoiceDialog */
public class h extends a<h> {
    private RadioGroup o;
    private int p = 0;
    /* access modifiers changed from: private */
    public i q;

    /* compiled from: FrogSingleChoiceDialog */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (h.this.q != null) {
                if (h.this.b()) {
                    h.this.q.a(((a) h.this).h.isChecked());
                }
                h.this.q.a(i);
                h.this.q.a();
            }
            h.this.c();
        }
    }

    public h(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean b() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int d() {
        return (super.d() / 3) * 2;
    }

    public h b(int i, int i2) {
        a(((a) this).f11a.getResources().getStringArray(i), i2);
        return this;
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
     arg types: [android.widget.RadioButton, int]
     candidates:
      a.a.b.p.a.a(android.content.Context, int):int
      a.a.b.p.a.a(android.view.View, int):void
      a.a.b.p.a.a(android.view.View, android.graphics.drawable.Drawable):void
      a.a.b.p.a.a(android.view.View, boolean):void
      a.a.b.p.a.a(java.lang.String[], int):boolean
      a.a.b.p.a.a(android.widget.TextView, int):void */
    private void b(String[] strArr, int i) {
        int childCount = this.o.getChildCount();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a2 = b.a(((a) this).f11a, 8.0f);
        int a3 = b.a(((a) this).f11a, Build.VERSION.SDK_INT >= 17 ? 12.0f : 24.0f);
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            RadioButton radioButton = (RadioButton) this.o.findViewById(i2);
            if (radioButton == null) {
                radioButton = new RadioButton(((a) this).f11a);
                radioButton.setButtonDrawable(i == i2 ? d.j : d.i);
                radioButton.setPadding(a3, a2, a3, a2);
                a.a.b.p.a.a((TextView) radioButton, g.k);
                radioButton.setMaxLines(1);
                radioButton.setSingleLine();
                radioButton.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                radioButton.setId(i2);
                this.o.addView(radioButton, layoutParams);
            }
            radioButton.setText(strArr[i2]);
            radioButton.setChecked(false);
            if (this.p == 0) {
                this.p = b.a(radioButton, ((a) this).l);
            }
            i2++;
        }
        if (childCount > length) {
            while (length <= childCount) {
                this.o.removeView((RadioButton) ((a) this).e.findViewById(length));
                length++;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    public h a(String[] strArr, int i) {
        if (this.o == null) {
            this.o = new RadioGroup(((a) this).f11a);
            int a2 = b.a(((a) this).f11a, 20.0f);
            this.o.setPadding(a2, 0, a2, 0);
            this.o.setOnCheckedChangeListener(new a());
            ((a) this).e.addView(this.o, new LinearLayout.LayoutParams(-1, -2));
        }
        if (strArr == null || strArr.length == 0) {
            this.o.setVisibility(8);
        } else {
            b(strArr, i);
            this.o.setVisibility(0);
        }
        return this;
    }

    public h a(i iVar) {
        this.q = iVar;
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int a(boolean z) {
        RadioGroup radioGroup = this.o;
        if (radioGroup == null || radioGroup.getVisibility() == 8) {
            return 0;
        }
        return this.p * this.o.getChildCount();
    }
}
