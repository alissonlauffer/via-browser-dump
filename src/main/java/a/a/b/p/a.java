package a.a.b.p;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/* compiled from: CompatUtils */
public class a {
    public static String a(Context context, int i, Object... objArr) {
        return context == null ? "" : context.getString(i, objArr);
    }

    public static String b(Context context, int i, int i2) {
        String[] strArr;
        try {
            strArr = context.getResources().getStringArray(i);
        } catch (Exception e) {
            e.printStackTrace();
            strArr = null;
        }
        return (strArr == null || i2 < 0 || i2 >= strArr.length) ? "" : strArr[i2];
    }

    public static int c(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static Drawable d(Context context, int i) {
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

    public static String e(Context context, int i) {
        return context == null ? "" : context.getString(i);
    }

    public static int a(Context context, int i) {
        if (context == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColor(i, null);
        }
        return context.getResources().getColor(i);
    }

    public static Drawable a(Context context, int i, int i2) {
        Drawable d = d(context, i);
        if (d != null) {
            d.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        return d;
    }

    public static int b(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return 0;
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view.setPaddingRelative(i, i2, i3, i4);
            } else {
                view.setPadding(i, i2, i3, i4);
            }
        }
    }

    public static void b(View view, int i) {
        a(view, i, i);
    }

    public static void a(View view, int i) {
        if (view != null && view.getContext() != null) {
            a(view, d(view.getContext(), i));
        }
    }

    public static void a(View view, Drawable drawable) {
        if (view != null && view.getContext() != null && drawable != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        }
    }

    public static void a(View view, int i, int i2) {
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                view.setPaddingRelative(i, i2, i, i2);
            } else {
                view.setPadding(i, i2, i, i2);
            }
        }
    }

    public static void a(TextView textView, int i) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i);
            } else {
                textView.setTextAppearance(textView.getContext(), i);
            }
        }
    }

    public static void a(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public static boolean a(String[] strArr, int i) {
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
}
