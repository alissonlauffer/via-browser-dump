package a.a.b.h;

import android.util.SparseArray;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* compiled from: AnimationHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f10a = 150;
    private static SparseArray<Animation> b = new SparseArray<>();

    public static Animation a(int i) {
        return a(i, true);
    }

    public static Animation b(int i) {
        return a(i, false);
    }

    private static Animation c(int i, boolean z) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = -120.0f;
        float f6 = 0.0f;
        if (i != 3) {
            f2 = 120.0f;
            if (i != 5) {
                if (i != 7) {
                    if (i != 9) {
                        f = 0.0f;
                        f3 = 0.0f;
                    } else {
                        float f7 = z ? 120.0f : 0.0f;
                        if (z) {
                            f2 = 0.0f;
                        }
                        f6 = f7;
                        f3 = f2;
                        f = 0.0f;
                    }
                    f2 = 0.0f;
                } else {
                    float f8 = z ? -120.0f : 0.0f;
                    if (z) {
                        f5 = 0.0f;
                    }
                    f2 = 0.0f;
                    f6 = f8;
                    f = 0.0f;
                }
                if (f6 == f3 || f != f2) {
                    return new TranslateAnimation(f6, f3, f, f2);
                }
                return null;
            }
            f4 = z ? 120.0f : 0.0f;
            if (z) {
                f2 = 0.0f;
            }
        } else {
            f4 = z ? -120.0f : 0.0f;
            if (z) {
                f5 = 0.0f;
            }
            f2 = f5;
        }
        f3 = 0.0f;
        if (f6 == f3) {
        }
        return new TranslateAnimation(f6, f3, f, f2);
    }

    public static Animation a(int i, boolean z) {
        int i2 = z ? i : i + 1;
        Animation animation = b.get(i2);
        if (animation == null) {
            if (i == 1) {
                animation = a(z);
            } else if (i == 3 || i == 5 || i == 7 || i == 9) {
                animation = b(i, z);
            }
            if (animation != null) {
                animation.setDuration(f10a);
                b.put(i2, animation);
            }
        }
        return animation;
    }

    private static Animation b(int i, boolean z) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a(z));
        animationSet.addAnimation(c(i, z));
        return animationSet;
    }

    private static Animation a(boolean z) {
        float f = z ? 0.0f : 1.0f;
        return new AlphaAnimation(f, 1.0f - f);
    }
}
