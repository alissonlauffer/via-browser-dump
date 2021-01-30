package mark.via.p044m.p047c;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: mark.via.m.c.b */
/* compiled from: GestureTouchEvent */
public class GestureTouchEvent {

    /* renamed from: a */
    private View f1484a;

    /* renamed from: b */
    private AbstractC0488a f1485b;

    /* renamed from: c */
    private boolean f1486c = false;

    /* renamed from: d */
    private int f1487d;

    /* renamed from: e */
    private int f1488e;

    /* renamed from: f */
    private int f1489f;

    /* renamed from: g */
    private int f1490g;

    /* renamed from: h */
    private int f1491h;

    /* renamed from: i */
    private int f1492i = -1;

    /* renamed from: j */
    private int f1493j = 0;

    /* renamed from: k */
    private int f1494k = 0;

    /* renamed from: l */
    private int f1495l = 0;

    /* renamed from: m */
    private int f1496m;

    /* renamed from: n */
    private int f1497n = 0;

    /* renamed from: o */
    private int f1498o = 0;

    /* renamed from: p */
    private int f1499p = 0;

    /* renamed from: mark.via.m.c.b$a */
    /* compiled from: GestureTouchEvent */
    public interface AbstractC0488a {
        /* renamed from: a */
        boolean mo1295a();

        /* renamed from: b */
        void mo1296b(View view, int i);

        /* renamed from: c */
        int mo1297c();

        /* renamed from: d */
        void mo1298d(int i, int i2);

        /* renamed from: e */
        void mo1299e(int i);
    }

    /* renamed from: a */
    private boolean m2022a(int i) {
        return (this.f1499p & i) == i;
    }

    /* renamed from: b */
    public boolean mo1291b(View view, MotionEvent motionEvent) {
        ObjectAnimator objectAnimator;
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (!(this.f1485b == null || view == null || motionEvent == null)) {
            if (this.f1495l == 0 && this.f1494k == 0) {
                this.f1495l = view.getHeight();
                this.f1494k = view.getWidth();
            }
            int action = motionEvent.getAction() & 255;
            float f = 1.0f;
            if (action != 0) {
                int i3 = 2;
                if (action == 1) {
                    this.f1486c = false;
                    if (i2 < 11 || this.f1492i != 1) {
                        int rawY = ((int) motionEvent.getRawY()) - this.f1489f;
                        if (Math.abs(rawY) > 50) {
                            int i4 = 4;
                            if (m2022a(rawY > 0 ? 8 : 4)) {
                                AbstractC0488a aVar = this.f1485b;
                                if (rawY > 0) {
                                    i4 = 8;
                                }
                                aVar.mo1299e(i4);
                            }
                        }
                    } else {
                        if (Math.abs(this.f1490g) < this.f1496m) {
                            f = ((float) Math.abs(this.f1490g)) / ((float) this.f1496m);
                            objectAnimator = ObjectAnimator.ofFloat(this.f1484a, "translationX", (float) this.f1497n, (float) this.f1498o);
                        } else {
                            objectAnimator = ObjectAnimator.ofFloat(this.f1484a, "alpha", 1.0f, 0.0f);
                            int i5 = this.f1490g;
                            int i6 = this.f1496m;
                            if (i5 >= i6) {
                                this.f1485b.mo1299e(1);
                            } else if (i5 <= (-i6)) {
                                this.f1485b.mo1299e(2);
                            }
                        }
                        objectAnimator.setDuration((long) ((int) (f * 300.0f))).start();
                    }
                } else if (action != 2) {
                    if (action == 5 && this.f1492i == 1) {
                        this.f1492i = 0;
                        if (i2 >= 11) {
                            this.f1484a.setTranslationX(0.0f);
                        }
                    }
                } else if (this.f1486c) {
                    int rawX = (int) (motionEvent.getRawX() - ((float) this.f1487d));
                    int rawY2 = (int) (motionEvent.getRawY() - ((float) this.f1488e));
                    this.f1487d = (int) motionEvent.getRawX();
                    this.f1488e = (int) motionEvent.getRawY();
                    if (this.f1492i == -1) {
                        if (i2 >= 11 && Math.abs(rawX) > 100 && Math.abs(rawX) > Math.abs(rawY2)) {
                            if (m2022a(rawX > 0 ? 1 : 2)) {
                                this.f1492i = 1;
                                if (rawX > 0) {
                                    i = 0;
                                } else {
                                    i = this.f1494k + this.f1493j;
                                }
                                this.f1498o = i;
                                AbstractC0488a aVar2 = this.f1485b;
                                View view2 = this.f1484a;
                                if (rawX > 0) {
                                    i3 = 1;
                                }
                                aVar2.mo1296b(view2, i3);
                                View view3 = this.f1484a;
                                int i7 = this.f1498o;
                                this.f1497n = i7;
                                view3.setTranslationX((float) i7);
                            }
                        }
                        this.f1492i = 0;
                    }
                    int i8 = this.f1492i;
                    if (i8 == 1) {
                        rawX = (rawX * 8) / 10;
                    }
                    int i9 = this.f1490g;
                    int i10 = i9 + rawX;
                    int i11 = this.f1496m;
                    if (i10 > i11 && rawX > 0) {
                        rawX = i11 - i9;
                    } else if (i9 + rawX < (-i11) && rawX < 0) {
                        rawX = (-i11) - i9;
                    }
                    if ((i9 > 0 && rawX + i9 <= 0) || (i9 < 0 && i9 + rawX >= 0)) {
                        rawX = 0;
                    }
                    if (i8 == 1) {
                        rawY2 = 0;
                    }
                    if (!(i2 < 11 || i8 == 0 || i8 == -1)) {
                        int i12 = this.f1497n + rawX;
                        this.f1497n = i12;
                        this.f1484a.setTranslationX((float) i12);
                    }
                    this.f1490g += rawX;
                    this.f1491h += rawY2;
                } else {
                    this.f1486c = this.f1485b.mo1295a();
                    this.f1490g = 0;
                    this.f1491h = 0;
                }
            } else {
                this.f1499p = this.f1485b.mo1297c();
                this.f1486c = false;
                this.f1487d = (int) motionEvent.getRawX();
                int rawY3 = (int) motionEvent.getRawY();
                this.f1488e = rawY3;
                this.f1489f = rawY3;
                this.f1485b.mo1298d((int) motionEvent.getX(), (int) motionEvent.getY());
                this.f1490g = 0;
                this.f1491h = 0;
                this.f1492i = -1;
                if (i2 >= 11) {
                    this.f1484a.setAlpha(1.0f);
                    this.f1484a.setTranslationX(0.0f);
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void mo1292c() {
        this.f1495l = 0;
        this.f1494k = 0;
        View view = this.f1484a;
        if (view != null && Build.VERSION.SDK_INT >= 11) {
            view.setTranslationX(0.0f);
        }
    }

    /* renamed from: d */
    public GestureTouchEvent mo1293d(AbstractC0488a aVar) {
        this.f1485b = aVar;
        return this;
    }

    /* renamed from: e */
    public GestureTouchEvent mo1294e(View view) {
        this.f1484a = view;
        view.getHeight();
        int width = view.getWidth();
        this.f1493j = width;
        this.f1496m = (width * 2) / 3;
        this.f1484a.setVisibility(0);
        return this;
    }
}
