package a.a.b.p;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: FrogUtils */
public class b {
    public static int a(View view, int i) {
        if (view == null) {
            return 0;
        }
        return b(view, i)[1];
    }

    public static int[] b(View view, int i) {
        if (view == null) {
            return new int[]{0, 0};
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void a(View... viewArr) {
        if (viewArr != null && viewArr.length != 0) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }

    public static int a(Context context, int i) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.min((Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 7) * 6, a(context, (float) i));
    }

    public static int b(Context context) {
        return a(context, 400);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    public static int a(Context context) {
        int c = c(context);
        return c - Math.min(c / 5, a(context, 60.0f));
    }

    public static int a(Context context, float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
