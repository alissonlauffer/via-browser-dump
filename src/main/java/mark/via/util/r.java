package mark.via.util;

import a.a.b.p.d;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mark.via.gp.R;

/* compiled from: ViewUtils */
public class r {

    /* compiled from: ViewUtils */
    class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f494a;

        a(View view) {
            this.f494a = view;
        }

        public void onAnimationEnd(Animation animation) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, -0.3f, 1, 0.0f);
            translateAnimation.setDuration(120);
            this.f494a.clearAnimation();
            this.f494a.startAnimation(translateAnimation);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return (((int) ((((float) (i & 255)) * f) + (((float) (i2 & 255)) * f2))) & 255) | ((((int) ((((float) ((i >> 16) & 255)) * f) + (((float) ((i2 >> 16) & 255)) * f2))) & 255) << 16) | -16777216 | ((((int) ((((float) ((i >> 8) & 255)) * f) + (((float) ((i2 >> 8) & 255)) * f2))) & 255) << 8);
    }

    public static void a(View view, Animation animation, Animation.AnimationListener animationListener) {
        if (view == null) {
            return;
        }
        if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            if (animation != null) {
                if (animationListener != null) {
                    animation.setAnimationListener(animationListener);
                }
                view.startAnimation(animation);
            }
            view.setVisibility(0);
        }
    }

    public static void b(View view, Animation animation) {
        if (view != null && view.getVisibility() == 0) {
            if (animation != null) {
                view.startAnimation(animation);
            }
            view.setVisibility(4);
        }
    }

    public static void c(View view, Animation animation) {
        if (view != null) {
            if (view.getVisibility() != 0) {
                d(view, animation);
            } else if (animation != null) {
                view.startAnimation(animation);
            }
        }
    }

    public static void d(View view, Animation animation) {
        if (view == null) {
            return;
        }
        if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            if (animation != null) {
                view.startAnimation(animation);
            }
            view.setVisibility(0);
        }
    }

    public static void e(View view, Animation animation) {
        if (view != null && view.getVisibility() == 4) {
            if (animation != null) {
                view.startAnimation(animation);
            }
            view.setVisibility(0);
        }
    }

    public static int f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean g(Context context) {
        int i = context.getResources().getConfiguration().screenLayout & 15;
        if ((i == 3 || i == 4) && c(context) >= 7.0d) {
            return true;
        }
        return false;
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static double c(Context context) {
        Double d;
        Double d2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            Point point = new Point();
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealSize(point);
            d = Double.valueOf(Math.pow((double) (((float) point.x) / displayMetrics.xdpi), 2.0d));
            d2 = Double.valueOf(Math.pow((double) (((float) point.y) / displayMetrics.ydpi), 2.0d));
        } else if (i >= 13) {
            Point point2 = new Point();
            ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point2);
            d = Double.valueOf(Math.pow((double) (((float) point2.x) / displayMetrics.xdpi), 2.0d));
            d2 = Double.valueOf(Math.pow((double) (((float) point2.y) / displayMetrics.ydpi), 2.0d));
        } else {
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            double d3 = (double) i2;
            double d4 = (double) displayMetrics.xdpi;
            Double.isNaN(d3);
            Double.isNaN(d4);
            double d5 = d3 / d4;
            double d6 = (double) i3;
            double d7 = (double) displayMetrics.ydpi;
            Double.isNaN(d6);
            Double.isNaN(d7);
            d = Double.valueOf(Math.pow(d5, 2.0d));
            d2 = Double.valueOf(Math.pow(d6 / d7, 2.0d));
        }
        return Math.sqrt(d.doubleValue() + d2.doubleValue());
    }

    public static int d(Context context) {
        if ((((Activity) context).getWindow().getAttributes().flags & 1024) == 1024) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int e(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels - d(context);
    }

    public static void a(View view, Animation animation) {
        if (view != null && view.getVisibility() == 0) {
            if (animation != null) {
                view.startAnimation(animation);
            }
            view.setVisibility(8);
        }
    }

    public static void b(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 21 && view != null) {
            Activity activity = (Activity) view.getContext();
            a(activity, view, a.a.b.p.a.a(activity, mark.via.f.a.b(activity).a(activity) ? R.color.i : R.color.h));
        }
    }

    public static boolean e(Activity activity, boolean z) {
        boolean z2;
        boolean z3 = c(activity, z) || b(activity, z);
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(z ? 8192 : 0);
            z2 = true;
        } else {
            z2 = false;
        }
        if (z3 || z2) {
            return true;
        }
        return false;
    }

    public static void a(Activity activity, boolean z) {
        if (z) {
            activity.setTheme(R.style.f506a);
        }
    }

    public static boolean d(Activity activity, boolean z) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 27) {
            return false;
        }
        View decorView = activity.getWindow().getDecorView();
        if (z) {
            i = 8208;
        }
        decorView.setSystemUiVisibility(i);
        return true;
    }

    public static int a(Context context, int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static void a(int i, ImageView... imageViewArr) {
        for (ImageView imageView : imageViewArr) {
            if (imageView != null) {
                imageView.setColorFilter(i);
            }
        }
    }

    private static boolean b(Activity activity, boolean z) {
        if (activity != null) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (i ^ -1) & i2);
                activity.getWindow().setAttributes(attributes);
                return true;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r1 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r1 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        r1.recycle();
     */
    public static int a(View view) {
        int i = 0;
        if (view != null) {
            Bitmap bitmap = null;
            try {
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmap));
                i = bitmap.getPixel(0, 0);
            } catch (Exception e) {
                d.a(e);
            } catch (Throwable th) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        }
        return i;
    }

    public static boolean a(int i) {
        double red = (double) Color.red(i);
        Double.isNaN(red);
        double green = (double) Color.green(i);
        Double.isNaN(green);
        double d = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i);
        Double.isNaN(blue);
        return d + (blue * 0.114d) >= 192.0d;
    }

    public static String a(String str) {
        String h = b.h(str);
        String substring = h.substring(0, 3);
        String substring2 = h.substring((h.length() / 2) - 3, h.length() / 2);
        int parseInt = ((Integer.parseInt(h.substring(h.length() - 3), 16) % 128) + 100) | (((Integer.parseInt(substring, 16) % 128) + 100) << 16) | (((Integer.parseInt(substring2, 16) % 128) + 100) << 8);
        return "#" + Integer.toHexString(parseInt);
    }

    private static boolean c(Activity activity, boolean z) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String b(int i) {
        StringBuilder sb = new StringBuilder();
        String hexString = Integer.toHexString(Color.red(i));
        String hexString2 = Integer.toHexString(Color.green(i));
        String hexString3 = Integer.toHexString(Color.blue(i));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        sb.append("#");
        sb.append(hexString);
        sb.append(hexString2);
        sb.append(hexString3);
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void c(View r10) {
        if (r10 != 0 && r10.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 0.0f, 1, -0.3f);
            translateAnimation.setDuration(210);
            translateAnimation.setAnimationListener(new a(r10));
            r10.clearAnimation();
            r10.startAnimation(translateAnimation);
        }
    }

    public static void a(Activity activity, View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                boolean e = e(activity, a(i));
                Window window = activity.getWindow();
                if (a(i) && !e) {
                    i = a(i, a.a.b.p.a.a(activity, 17170444), 0.2f);
                }
                window.setStatusBarColor(i);
            }
        } else if (view != null) {
            activity.getWindow().addFlags(67108864);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + d(activity), view.getPaddingRight(), view.getPaddingBottom());
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            viewGroup.setFitsSystemWindows(false);
            viewGroup.setClipToPadding(true);
            View view2 = new View(activity);
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, d(activity)));
            if (e(activity, a(i))) {
                view2.setBackgroundColor(i);
            } else if (a(i)) {
                view2.setBackgroundColor(a.a.b.p.a.a(activity, (int) R.color.c));
            }
            viewGroup.addView(view2);
        }
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT > 11 && view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, (float) (a(view.getContext(), 10) * (z ? 1 : -1)), 0.0f);
            ofFloat.setDuration(280L);
            ofFloat.start();
        }
    }

    public static void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT < 16) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                Field declaredField = View.class.getDeclaredField("mScrollCache");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(view);
                Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj2, drawable);
                Method declaredMethod2 = obj2.getClass().getDeclaredMethod("setHorizontalThumbDrawable", Drawable.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(obj2, drawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setClickable(true);
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public static void a(View.OnLongClickListener onLongClickListener, View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setClickable(true);
                view.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, int... iArr) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && !a(iArr, childAt.getId())) {
                    childAt.setEnabled(z);
                    if (Build.VERSION.SDK_INT >= 11) {
                        childAt.setAlpha(z ? 1.0f : 0.3f);
                    }
                }
            }
        }
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
