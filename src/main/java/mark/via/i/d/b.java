package mark.via.i.d;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: GestureTouchEvent */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private View f280a;
    private a b;
    private boolean c = false;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i = -1;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;

    /* compiled from: GestureTouchEvent */
    public interface a {
        int a();

        void a(int i);

        void a(int i, int i2);

        void a(View view, int i);

        boolean b();
    }

    public b a(View view) {
        this.f280a = view;
        view.getHeight();
        int width = view.getWidth();
        this.j = width;
        this.m = (width * 2) / 3;
        this.f280a.setVisibility(0);
        this.q = 0;
        return this;
    }

    public b a(a aVar) {
        this.b = aVar;
        return this;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        ObjectAnimator objectAnimator;
        int i2;
        int i3;
        int i4;
        if (!(this.b == null || view == null || motionEvent == null)) {
            if (this.l == 0 && this.k == 0) {
                this.l = view.getHeight();
                this.k = view.getWidth();
            }
            int action = motionEvent.getAction() & 255;
            float f2 = 1.0f;
            if (action != 0) {
                int i5 = 4;
                int i6 = 2;
                if (action == 1) {
                    this.c = false;
                    if (Build.VERSION.SDK_INT < 11 || this.i != 1) {
                        int rawY = ((int) motionEvent.getRawY()) - this.f;
                        if (Math.abs(rawY) > 50) {
                            if (a(rawY > 0 ? 8 : 4)) {
                                a aVar = this.b;
                                if (rawY > 0) {
                                    i5 = 8;
                                }
                                aVar.a(i5);
                            }
                        }
                    } else {
                        if (Math.abs(this.g) < this.m) {
                            f2 = ((float) Math.abs(this.g)) / ((float) this.m);
                            objectAnimator = ObjectAnimator.ofFloat(this.f280a, "translationX", (float) this.n, (float) this.o);
                        } else {
                            objectAnimator = ObjectAnimator.ofFloat(this.f280a, "alpha", 1.0f, 0.0f);
                            int i7 = this.g;
                            int i8 = this.m;
                            if (i7 >= i8) {
                                this.b.a(1);
                            } else if (i7 <= (-i8)) {
                                this.b.a(2);
                            }
                        }
                        objectAnimator.setDuration((long) ((int) (f2 * 300.0f))).start();
                    }
                } else if (action != 2) {
                    if (action == 5 && this.i == 1) {
                        this.i = 0;
                        if (Build.VERSION.SDK_INT >= 11) {
                            this.f280a.setTranslationX((float) this.q);
                        }
                    }
                } else if (this.c) {
                    int rawX = (int) (motionEvent.getRawX() - ((float) this.d));
                    int rawY2 = (int) (motionEvent.getRawY() - ((float) this.e));
                    this.d = (int) motionEvent.getRawX();
                    this.e = (int) motionEvent.getRawY();
                    if (this.i == -1) {
                        if (Build.VERSION.SDK_INT >= 11 && Math.abs(rawX) > 4 && Math.abs(rawX) > Math.abs(rawY2)) {
                            if (a(rawX > 0 ? 1 : 2)) {
                                this.i = 1;
                                if (rawX > 0) {
                                    i4 = -10;
                                } else {
                                    i4 = this.k + this.j + 10;
                                }
                                this.o = i4;
                                a aVar2 = this.b;
                                View view2 = this.f280a;
                                if (rawX > 0) {
                                    i6 = 1;
                                }
                                aVar2.a(view2, i6);
                                View view3 = this.f280a;
                                int i9 = this.o;
                                this.n = i9;
                                view3.setTranslationX((float) i9);
                            }
                        }
                        this.i = 0;
                    }
                    if (this.i == 1) {
                        rawX = (rawX * 8) / 10;
                    }
                    int i10 = this.g;
                    int i11 = i10 + rawX;
                    int i12 = this.m;
                    if (i11 <= i12 || rawX <= 0) {
                        int i13 = this.g;
                        int i14 = i13 + rawX;
                        int i15 = this.m;
                        if (i14 < (-i15) && rawX < 0) {
                            rawX = (-i15) - i13;
                        }
                    } else {
                        rawX = i12 - i10;
                    }
                    int i16 = this.g;
                    if ((i16 > 0 && i16 + rawX <= 0) || ((i3 = this.g) < 0 && i3 + rawX >= 0)) {
                        rawX = 0;
                    }
                    if (this.i == 1) {
                        rawY2 = 0;
                    }
                    if (!(Build.VERSION.SDK_INT < 11 || (i2 = this.i) == 0 || i2 == -1)) {
                        int i17 = this.n + rawX;
                        this.n = i17;
                        this.f280a.setTranslationX((float) i17);
                    }
                    this.g += rawX;
                    this.h += rawY2;
                } else {
                    this.c = this.b.b();
                    this.g = 0;
                    this.h = 0;
                }
            } else {
                this.p = this.b.a();
                this.c = false;
                this.d = (int) motionEvent.getRawX();
                int rawY3 = (int) motionEvent.getRawY();
                this.e = rawY3;
                this.f = rawY3;
                this.b.a((int) motionEvent.getX(), (int) motionEvent.getY());
                this.g = 0;
                this.h = 0;
                this.i = -1;
                if (Build.VERSION.SDK_INT >= 11) {
                    this.f280a.setAlpha(1.0f);
                    this.f280a.setTranslationX((float) this.q);
                }
            }
        }
        return false;
    }

    private boolean a(int i2) {
        return (this.p & i2) == i2;
    }

    public void a() {
        this.l = 0;
        this.k = 0;
        View view = this.f280a;
        if (view != null && Build.VERSION.SDK_INT >= 11) {
            view.setTranslationX((float) this.q);
        }
    }
}
