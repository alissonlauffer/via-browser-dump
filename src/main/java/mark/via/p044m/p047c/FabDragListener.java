package mark.via.p044m.p047c;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import mark.via.utils.ViewUtils;

/* renamed from: mark.via.m.c.a */
/* compiled from: FabDragListener */
public class FabDragListener implements View.OnTouchListener {

    /* renamed from: a */
    private final Handler f1463a = new Handler();

    /* renamed from: b */
    private final Runnable f1464b = new RunnableC0484a();

    /* renamed from: c */
    private AbstractC0487d f1465c;

    /* renamed from: d */
    private boolean f1466d = false;

    /* renamed from: e */
    private boolean f1467e = false;

    /* renamed from: f */
    private Context f1468f;

    /* renamed from: g */
    private int f1469g = 100;

    /* renamed from: h */
    private int f1470h = -1;

    /* renamed from: i */
    private View f1471i;

    /* renamed from: j */
    private int f1472j;

    /* renamed from: k */
    private int f1473k;

    /* renamed from: l */
    private int f1474l;

    /* renamed from: m */
    private int f1475m;

    /* renamed from: n */
    private int f1476n;

    /* renamed from: o */
    private int f1477o;

    /* renamed from: p */
    private long f1478p;

    /* renamed from: q */
    private float f1479q;

    /* renamed from: r */
    private int f1480r = -1;

    /* renamed from: mark.via.m.c.a$a */
    /* compiled from: FabDragListener */
    class RunnableC0484a implements Runnable {
        RunnableC0484a() {
        }

        public void run() {
            FabDragListener.this.f1466d = true;
            if (FabDragListener.this.f1467e) {
                if (Build.VERSION.SDK_INT >= 11) {
                    FabDragListener.this.f1471i.setAlpha(1.0f);
                }
                if (FabDragListener.this.f1465c != null) {
                    FabDragListener.this.f1465c.mo1288c();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.c.a$b */
    /* compiled from: FabDragListener */
    public class C0485b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f1482a;

        C0485b(FabDragListener aVar, View view) {
            this.f1482a = view;
        }

        @TargetApi(11)
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue("tX")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("tY")).intValue();
            this.f1482a.layout(intValue, intValue2, this.f1482a.getWidth() + intValue, this.f1482a.getHeight() + intValue2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.c.a$c */
    /* compiled from: FabDragListener */
    public class C0486c implements Animator.AnimatorListener {
        C0486c() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            FabDragListener.this.m2012i();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: mark.via.m.c.a$d */
    /* compiled from: FabDragListener */
    public interface AbstractC0487d {
        /* renamed from: a */
        void mo1286a(int i);

        /* renamed from: b */
        int[] mo1287b(View view, int i, int i2);

        /* renamed from: c */
        void mo1288c();

        /* renamed from: d */
        void mo1289d(int i);

        /* renamed from: e */
        void mo1290e();
    }

    public FabDragListener(Context context) {
        this.f1468f = context;
    }

    /* renamed from: f */
    private void m2009f(View view, MotionEvent motionEvent) {
        this.f1466d = false;
        this.f1463a.postDelayed(this.f1464b, 300);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f1479q = view.getAlpha();
        }
        this.f1474l = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        this.f1475m = rawY;
        this.f1472j = this.f1474l;
        this.f1473k = rawY;
        this.f1476n = view.getLeft();
        this.f1477o = view.getTop();
        this.f1478p = System.currentTimeMillis();
    }

    /* renamed from: g */
    private void m2010g(View view, MotionEvent motionEvent) {
        int i;
        int i2;
        int rawX = (int) (motionEvent.getRawX() - ((float) this.f1472j));
        int rawY = (int) (motionEvent.getRawY() - ((float) this.f1473k));
        if (!this.f1466d && (Math.abs(rawX) > this.f1469g || Math.abs(rawY) > this.f1469g)) {
            if (this.f1470h == -1) {
                this.f1470h = Math.abs(rawX) > Math.abs(rawY) ? 4 : 5;
            }
            this.f1463a.removeCallbacks(this.f1464b);
        }
        boolean z = this.f1466d;
        double d = 1.1d;
        int i3 = 0;
        if (z || this.f1470h != 5) {
            double d2 = (double) rawX;
            double d3 = z ? 1.1d : 0.6d;
            Double.isNaN(d2);
            i = (int) (d2 * d3);
        } else {
            i = 0;
        }
        if (z || this.f1470h != 4) {
            double d4 = (double) rawY;
            if (!z) {
                d = 0.6d;
            }
            Double.isNaN(d4);
            i2 = (int) (d4 * d);
        } else {
            i2 = 0;
        }
        int k = ViewUtils.m2233k(this.f1468f);
        int j = ViewUtils.m2232j(this.f1468f);
        int min = view.getLeft() < (-i) ? 0 : Math.min(view.getLeft() + i, k - view.getWidth());
        int min2 = view.getTop() < (-i2) ? 0 : Math.min(view.getTop() + i2, j - view.getHeight());
        view.layout(min, min2, view.getWidth() + min, view.getHeight() + min2);
        this.f1472j = (int) motionEvent.getRawX();
        this.f1473k = (int) motionEvent.getRawY();
        if (!this.f1466d) {
            if (this.f1470h == 4 && Math.abs(this.f1472j - this.f1474l) > 120) {
                if (this.f1472j - this.f1474l > 0) {
                    i3 = 1;
                }
                this.f1480r = i3;
            } else if (this.f1470h == 5 && Math.abs(this.f1473k - this.f1475m) > 120) {
                this.f1480r = this.f1473k - this.f1475m > 0 ? 3 : 2;
            }
            AbstractC0487d dVar = this.f1465c;
            if (dVar != null) {
                dVar.mo1286a(this.f1480r);
            }
        }
    }

    /* renamed from: h */
    private void m2011h(View view, MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        this.f1463a.removeCallbacks(this.f1464b);
        if (this.f1466d) {
            if (i >= 11) {
                this.f1471i.setAlpha(this.f1479q);
            }
            AbstractC0487d dVar = this.f1465c;
            int[] b = dVar == null ? new int[]{this.f1472j, this.f1473k} : dVar.mo1287b(view, this.f1472j, this.f1473k);
            this.f1476n = b[0];
            this.f1477o = b[1];
        }
        if (i >= 11) {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("tX", view.getLeft(), this.f1476n), PropertyValuesHolder.ofInt("tY", view.getTop(), this.f1477o));
            ofPropertyValuesHolder.addUpdateListener(new C0485b(this, view));
            ofPropertyValuesHolder.addListener(new C0486c());
            ofPropertyValuesHolder.setDuration(180L);
            ofPropertyValuesHolder.start();
            return;
        }
        m2012i();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i */
    private void m2012i() {
        AbstractC0487d dVar = this.f1465c;
        if (dVar == null) {
            this.f1480r = -1;
            this.f1470h = -1;
            return;
        }
        dVar.mo1288c();
        int i = this.f1480r;
        if (i != -1) {
            this.f1465c.mo1289d(i);
            this.f1480r = -1;
            this.f1465c.mo1286a(-1);
        } else if ((Math.abs(this.f1472j - this.f1474l) < 5 || Math.abs(this.f1473k - this.f1475m) < 5) && System.currentTimeMillis() - this.f1478p < 300) {
            this.f1465c.mo1290e();
        }
        this.f1470h = -1;
    }

    /* renamed from: j */
    public FabDragListener mo1275j(AbstractC0487d dVar) {
        this.f1465c = dVar;
        return this;
    }

    /* renamed from: k */
    public FabDragListener mo1276k(int i) {
        this.f1469g = i;
        return this;
    }

    /* renamed from: l */
    public FabDragListener mo1277l(boolean z) {
        this.f1467e = z;
        return this;
    }

    /* renamed from: m */
    public FabDragListener mo1278m(View view) {
        if (view != null) {
            this.f1471i = view;
            view.setOnTouchListener(this);
        }
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            m2009f(view, motionEvent);
        } else if (action == 1) {
            view.performClick();
            m2011h(view, motionEvent);
        } else if (action == 2) {
            m2010g(view, motionEvent);
        }
        return true;
    }
}
