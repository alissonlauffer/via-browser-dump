package mark.via.i.d;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import mark.via.util.r;

/* compiled from: FabDragListener */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f276a = new Handler();
    private final Runnable b = new C0039a();
    /* access modifiers changed from: private */
    public d c;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public boolean e = false;
    private Context f;
    private int g = 100;
    private int h = -1;
    /* access modifiers changed from: private */
    public View i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private long p;
    private float q;
    private int r = -1;

    /* renamed from: mark.via.i.d.a$a  reason: collision with other inner class name */
    /* compiled from: FabDragListener */
    class C0039a implements Runnable {
        C0039a() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: mark.via.i.d.a.a(mark.via.i.d.a, boolean):boolean
         arg types: [mark.via.i.d.a, int]
         candidates:
          mark.via.i.d.a.a(android.view.View, android.view.MotionEvent):void
          mark.via.i.d.a.a(mark.via.i.d.a, boolean):boolean */
        public void run() {
            boolean unused = a.this.d = true;
            if (a.this.e) {
                if (Build.VERSION.SDK_INT >= 11) {
                    a.this.i.setAlpha(1.0f);
                }
                if (a.this.c != null) {
                    a.this.c.a();
                }
            }
        }
    }

    /* compiled from: FabDragListener */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f278a;

        b(a aVar, View view) {
            this.f278a = view;
        }

        @TargetApi(11)
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue("tX")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("tY")).intValue();
            this.f278a.layout(intValue, intValue2, this.f278a.getWidth() + intValue, this.f278a.getHeight() + intValue2);
        }
    }

    /* compiled from: FabDragListener */
    class c implements Animator.AnimatorListener {
        c() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            a.this.a();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: FabDragListener */
    public interface d {
        void a();

        void a(int i);

        int[] a(View view, int i, int i2);

        void b();

        void b(int i);
    }

    public a(Context context) {
        this.f = context;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            a(view, motionEvent);
        } else if (action == 1) {
            view.performClick();
            c(view, motionEvent);
        } else if (action == 2) {
            b(view, motionEvent);
        }
        return true;
    }

    private void b(View view, MotionEvent motionEvent) {
        int i2;
        int i3;
        int rawX = (int) (motionEvent.getRawX() - ((float) this.j));
        int rawY = (int) (motionEvent.getRawY() - ((float) this.k));
        if (!this.d && (Math.abs(rawX) > this.g || Math.abs(rawY) > this.g)) {
            if (this.h == -1) {
                this.h = Math.abs(rawX) > Math.abs(rawY) ? 4 : 5;
            }
            this.f276a.removeCallbacks(this.b);
        }
        double d2 = 1.1d;
        int i4 = 0;
        if (this.d || this.h != 5) {
            double d3 = (double) rawX;
            double d4 = this.d ? 1.1d : 0.6d;
            Double.isNaN(d3);
            i2 = (int) (d3 * d4);
        } else {
            i2 = 0;
        }
        if (this.d || this.h != 4) {
            double d5 = (double) rawY;
            if (!this.d) {
                d2 = 0.6d;
            }
            Double.isNaN(d5);
            i3 = (int) (d5 * d2);
        } else {
            i3 = 0;
        }
        int f2 = r.f(this.f);
        int e2 = r.e(this.f);
        int min = view.getLeft() < (-i2) ? 0 : Math.min(view.getLeft() + i2, f2 - view.getWidth());
        int min2 = view.getTop() < (-i3) ? 0 : Math.min(view.getTop() + i3, e2 - view.getHeight());
        view.layout(min, min2, view.getWidth() + min, view.getHeight() + min2);
        this.j = (int) motionEvent.getRawX();
        this.k = (int) motionEvent.getRawY();
        if (!this.d) {
            if (this.h == 4 && Math.abs(this.j - this.l) > 120) {
                if (this.j - this.l > 0) {
                    i4 = 1;
                }
                this.r = i4;
            } else if (this.h == 5 && Math.abs(this.k - this.m) > 120) {
                this.r = this.k - this.m > 0 ? 3 : 2;
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.b(this.r);
            }
        }
    }

    private void c(View view, MotionEvent motionEvent) {
        this.f276a.removeCallbacks(this.b);
        if (this.d) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.i.setAlpha(this.q);
            }
            d dVar = this.c;
            int[] a2 = dVar == null ? new int[]{this.j, this.k} : dVar.a(view, this.j, this.k);
            this.n = a2[0];
            this.o = a2[1];
        }
        if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("tX", view.getLeft(), this.n), PropertyValuesHolder.ofInt("tY", view.getTop(), this.o));
            ofPropertyValuesHolder.addUpdateListener(new b(this, view));
            ofPropertyValuesHolder.addListener(new c());
            ofPropertyValuesHolder.setDuration(180L);
            ofPropertyValuesHolder.start();
            return;
        }
        a();
    }

    public a a(View view) {
        if (view != null) {
            this.i = view;
            view.setOnTouchListener(this);
        }
        return this;
    }

    public a a(int i2) {
        this.g = i2;
        return this;
    }

    public a a(d dVar) {
        this.c = dVar;
        return this;
    }

    public a a(boolean z) {
        this.e = z;
        return this;
    }

    private void a(View view, MotionEvent motionEvent) {
        this.d = false;
        this.f276a.postDelayed(this.b, 300);
        if (Build.VERSION.SDK_INT >= 11) {
            this.q = view.getAlpha();
        }
        this.l = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        this.m = rawY;
        this.j = this.l;
        this.k = rawY;
        this.n = view.getLeft();
        this.o = view.getTop();
        this.p = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void a() {
        d dVar = this.c;
        if (dVar == null) {
            this.r = -1;
            this.h = -1;
            return;
        }
        dVar.a();
        int i2 = this.r;
        if (i2 != -1) {
            this.c.a(i2);
            this.r = -1;
            this.c.b(-1);
        } else if ((Math.abs(this.j - this.l) < 5 || Math.abs(this.k - this.m) < 5) && System.currentTimeMillis() - this.p < 300) {
            this.c.b();
        }
        this.h = -1;
    }
}
