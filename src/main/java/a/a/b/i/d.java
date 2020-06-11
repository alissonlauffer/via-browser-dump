package a.a.b.i;

import a.a.b.f;
import a.a.b.g;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FrogEditDialog */
public class d extends a<d> {
    private List<Integer> o = new ArrayList();

    /* compiled from: FrogEditDialog */
    class a implements View.OnFocusChangeListener {
        a(d dVar) {
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                ((AutoCompleteTextView) view).showDropDown();
            }
        }
    }

    /* compiled from: FrogEditDialog */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f15a;

        b(i iVar) {
            this.f15a = iVar;
        }

        public void onClick(View view) {
            if (this.f15a != null) {
                if (d.this.b()) {
                    this.f15a.a(((a) d.this).h.isChecked());
                }
                this.f15a.a(d.this.h());
                this.f15a.a();
            }
            d.this.c();
        }
    }

    public d(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    @Override // a.a.b.i.a
    public String[] h() {
        int size = this.o.size();
        if (size <= 0) {
            return new String[0];
        }
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((EditText) ((a) this).e.findViewById(this.o.get(i).intValue())).getText().toString().trim();
        }
        return strArr;
    }

    public EditText c(int i) {
        return (EditText) ((a) this).e.findViewById(i);
    }

    private void c(int i, int i2) {
        EditText editText = (EditText) ((a) this).e.findViewById(i);
        if (editText != null) {
            if (i2 > 1) {
                editText.setInputType(147457);
                editText.setImeOptions(1);
            } else {
                editText.setInputType(1);
                editText.setImeOptions(5);
            }
            editText.setMaxLines(i2);
            editText.setMinLines(i2);
            editText.setLines(i2);
        }
    }

    public d b(int i, int i2) {
        c(i, i2);
        return this;
    }

    public d a(int i, String str, String str2) {
        a(i, str, str2, 1);
        return this;
    }

    public d a(int i, String str, int i2) {
        a(i, str, a.a.b.p.a.e(((a) this).f11a, i2), 1);
        return this;
    }

    public d a(int i, String str, int i2, String[] strArr) {
        a(i, str, a.a.b.p.a.e(((a) this).f11a, i2), strArr);
        return this;
    }

    public d a(int i, String str) {
        EditText editText = (EditText) ((a) this).e.findViewById(i);
        if (!(editText == null || str == null)) {
            editText.setText(str);
        }
        return this;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [a.a.b.i.d, a.a.b.i.a] */
    private void a(int i, String str, String str2, String[] strArr) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(((a) this).f11a, f.l, strArr);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ((a) this).e.findViewById(i);
        if (autoCompleteTextView == null) {
            autoCompleteTextView = new AutoCompleteTextView(((a) this).f11a);
            a(autoCompleteTextView, i, 1);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnFocusChangeListener(new a(this));
            ((a) this).e.addView(autoCompleteTextView);
        }
        autoCompleteTextView.setText(str);
        autoCompleteTextView.setHint(str2);
    }

    private void a(int i, String str, String str2, int i2) {
        EditText editText = (EditText) ((a) this).e.findViewById(i);
        if (editText == null) {
            editText = new EditText(((a) this).f11a);
            a(editText, i, i2);
            ((a) this).e.addView(editText);
        }
        editText.setText(str);
        editText.setHint(str2);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.widget.TextView, android.view.View, android.widget.EditText] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void a(EditText r3, int i, int i2) {
        if (r3 != 0) {
            r3.setId(i);
            this.o.add(Integer.valueOf(i));
            a.a.b.p.a.a((View) r3, a.a.b.p.b.a(((a) this).f11a, 1.0f), a.a.b.p.b.a(((a) this).f11a, 8.0f));
            a.a.b.p.a.a((TextView) r3, g.k);
            r3.setHintTextColor(((a) this).g.getCurrentTextColor());
            a.a.b.p.a.a((View) r3, a.a.b.p.a.d(((a) this).f11a, a.a.b.d.o));
            r3.setGravity(48);
            r3.setSelectAllOnFocus(true);
            if (i2 > 1) {
                r3.setInputType(147457);
                r3.setImeOptions(1);
            } else {
                r3.setInputType(1);
                r3.setImeOptions(5);
            }
            r3.setMaxLines(i2);
            r3.setMinLines(i2);
            r3.setLines(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int a2 = a.a.b.p.b.a(((a) this).f11a, 2.0f);
            layoutParams.topMargin = a2;
            layoutParams.bottomMargin = a2;
            int a3 = a.a.b.p.b.a(((a) this).f11a, 20.0f);
            layoutParams.leftMargin = a3;
            layoutParams.rightMargin = a3;
            r3.setLayoutParams(layoutParams);
        }
    }

    @Override // a.a.b.i.a
    public d a(String str, i iVar) {
        if (a(((a) this).i, str)) {
            ((a) this).i.setOnClickListener(new b(iVar));
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int a(boolean z) {
        int size = this.o.size();
        if (size <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += a.a.b.p.b.a((EditText) ((a) this).e.findViewById(this.o.get(i2).intValue()), ((a) this).l);
        }
        return i;
    }
}
