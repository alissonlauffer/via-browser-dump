package mark.lib.frogsupport.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* renamed from: mark.lib.frogsupport.p.c */
/* compiled from: FrogUtils */
public class FrogUtils {
    /* renamed from: a */
    public static int m1354a(Context context, float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static int m1355b(View view, int i) {
        if (view == null) {
            return 0;
        }
        return m1356c(view, i)[1];
    }

    /* renamed from: c */
    public static int[] m1356c(View view, int i) {
        if (view == null) {
            return new int[]{0, 0};
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    /* renamed from: d */
    public static double m1357d(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double d = (double) (displayMetrics.density * 160.0f);
        double d2 = (double) displayMetrics.widthPixels;
        Double.isNaN(d2);
        Double.isNaN(d);
        double pow = Math.pow(d2 / d, 2.0d);
        double d3 = (double) displayMetrics.heightPixels;
        Double.isNaN(d3);
        Double.isNaN(d);
        return Math.sqrt(pow + Math.pow(d3 / d, 2.0d));
    }

    /* renamed from: e */
    public static int m1358e(Context context) {
        if ((((Activity) context).getWindow().getAttributes().flags & 1024) == 1024) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* renamed from: f */
    public static int m1359f(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: g */
    public static int m1360g(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: h */
    public static void m1361h(View... viewArr) {
        if (!(viewArr == null || viewArr.length == 0)) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }
}
