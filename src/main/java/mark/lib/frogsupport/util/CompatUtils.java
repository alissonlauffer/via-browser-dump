package mark.lib.frogsupport.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/* renamed from: mark.lib.frogsupport.p.a */
/* compiled from: CompatUtils */
public class CompatUtils {
    /* renamed from: a */
    public static int m1331a(Context context, int i) {
        if (context == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColor(i, null);
        }
        return context.getResources().getColor(i);
    }

    /* renamed from: b */
    public static int m1332b(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return 0;
    }

    /* renamed from: c */
    public static int m1333c(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    /* renamed from: d */
    public static Drawable m1334d(Context context, int i) {
        Drawable drawable;
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable = context.getResources().getDrawable(i, null);
            } else {
                drawable = context.getResources().getDrawable(i);
            }
            return drawable;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    public static Drawable m1335e(Context context, int i, int i2) {
        Drawable d = m1334d(context, i);
        if (d != null) {
            d.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        return d;
    }

    /* renamed from: f */
    public static String m1336f(Context context, int i) {
        return context == null ? "" : context.getString(i);
    }

    /* renamed from: g */
    public static String m1337g(Context context, int i, Object... objArr) {
        return context == null ? "" : context.getString(i, objArr);
    }

    /* renamed from: h */
    public static String m1338h(Context context, int i, int i2) {
        String[] strArr;
        try {
            strArr = context.getResources().getStringArray(i);
        } catch (Exception e) {
            e.printStackTrace();
            strArr = null;
        }
        return (strArr == null || i2 < 0 || i2 >= strArr.length) ? "" : strArr[i2];
    }

    /* renamed from: i */
    public static boolean m1339i(String[] strArr, int i) {
        if (strArr == null || strArr.length < i) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    public static void m1340j(View view, int i) {
        if (view != null && view.getContext() != null) {
            m1341k(view, m1334d(view.getContext(), i));
        }
    }

    /* renamed from: k */
    public static void m1341k(View view, Drawable drawable) {
        if (view != null && view.getContext() != null && drawable != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        }
    }

    /* renamed from: l */
    public static void m1342l(View view, int i) {
        m1343m(view, i, i);
    }

    /* renamed from: m */
    public static void m1343m(View view, int i, int i2) {
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view.setPaddingRelative(i, i2, i, i2);
            } else {
                view.setPadding(i, i2, i, i2);
            }
        }
    }

    /* renamed from: n */
    public static void m1344n(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view.setPaddingRelative(i, i2, i3, i4);
            } else {
                view.setPadding(i, i2, i3, i4);
            }
        }
    }

    /* renamed from: o */
    public static void m1345o(TextView textView, int i) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i);
            } else {
                textView.setTextAppearance(textView.getContext(), i);
            }
        }
    }

    /* renamed from: p */
    public static void m1346p(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
