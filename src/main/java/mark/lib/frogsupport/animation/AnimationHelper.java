package mark.lib.frogsupport.animation;

import android.util.SparseArray;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* renamed from: mark.lib.frogsupport.h.a */
/* compiled from: AnimationHelper */
public class AnimationHelper {

    /* renamed from: a */
    private static long f1044a = 150;

    /* renamed from: b */
    private static SparseArray<Animation> f1045b = new SparseArray<>();

    /* renamed from: a */
    public static Animation m1119a(int i, boolean z) {
        int i2 = z ? i : i + 1;
        Animation animation = f1045b.get(i2);
        if (animation == null) {
            if (i == 1) {
                animation = m1123e(z);
            } else if (i == 3 || i == 5 || i == 7 || i == 9) {
                animation = m1122d(i, z);
            }
            if (animation != null) {
                animation.setDuration(f1044a);
                f1045b.put(i2, animation);
            }
        }
        return animation;
    }

    /* renamed from: b */
    public static Animation m1120b(int i) {
        return m1119a(i, true);
    }

    /* renamed from: c */
    public static Animation m1121c(int i) {
        return m1119a(i, false);
    }

    /* renamed from: d */
    private static Animation m1122d(int i, boolean z) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(m1123e(z));
        animationSet.addAnimation(m1124f(i, z));
        return animationSet;
    }

    /* renamed from: e */
    private static Animation m1123e(boolean z) {
        float f = z ? 0.0f : 1.0f;
        return new AlphaAnimation(f, 1.0f - f);
    }

    /* renamed from: f */
    private static Animation m1124f(int i, boolean z) {
        float f;
        float f2;
        float f3 = -120.0f;
        float f4 = 0.0f;
        if (i != 3) {
            f2 = 120.0f;
            if (i != 5) {
                if (i != 7) {
                    if (i != 9) {
                        f = 0.0f;
                        f3 = 0.0f;
                    } else {
                        float f5 = z ? 120.0f : 0.0f;
                        if (z) {
                            f2 = 0.0f;
                        }
                        f4 = f5;
                        f3 = f2;
                        f = 0.0f;
                    }
                    f2 = 0.0f;
                } else {
                    float f6 = z ? -120.0f : 0.0f;
                    if (z) {
                        f3 = 0.0f;
                    }
                    f2 = 0.0f;
                    f4 = f6;
                    f = 0.0f;
                }
                if (f4 == f3 || f != f2) {
                    return new TranslateAnimation(f4, f3, f, f2);
                }
                return null;
            }
            f = z ? 120.0f : 0.0f;
            if (z) {
                f2 = 0.0f;
            }
        } else {
            f = z ? -120.0f : 0.0f;
            if (z) {
                f3 = 0.0f;
            }
            f2 = f3;
        }
        f3 = 0.0f;
        if (f4 == f3) {
        }
        return new TranslateAnimation(f4, f3, f, f2);
    }
}
