package a.a.b.k.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TargetApi(12)
/* compiled from: SwipeDismissListViewTouchListener */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f24a;
    private int b;
    private int c;
    private long d;
    /* access modifiers changed from: private */
    public ListView e;
    /* access modifiers changed from: private */
    public e f;
    private int g = 1;
    /* access modifiers changed from: private */
    public List<f> h = new ArrayList();
    /* access modifiers changed from: private */
    public int i = 0;
    private float j;
    private float k;
    private boolean l;
    private int m;
    private VelocityTracker n;
    /* access modifiers changed from: private */
    public int o;
    private View p;
    private boolean q;
    /* access modifiers changed from: private */
    public boolean r = false;

    /* renamed from: a.a.b.k.e.a$a  reason: collision with other inner class name */
    /* compiled from: SwipeDismissListViewTouchListener */
    class C0003a implements AbsListView.OnScrollListener {
        C0003a() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            a aVar = a.this;
            boolean z = true;
            if (i == 1) {
                z = false;
            }
            aVar.a(z);
        }
    }

    /* compiled from: SwipeDismissListViewTouchListener */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f26a;
        final /* synthetic */ int b;

        b(View view, int i) {
            this.f26a = view;
            this.b = i;
        }

        public void onAnimationEnd(Animator animator) {
            a.this.a(this.f26a, this.b);
        }
    }

    /* compiled from: SwipeDismissListViewTouchListener */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f27a;

        c(int i) {
            this.f27a = i;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: a.a.b.k.e.a.a(a.a.b.k.e.a, boolean):boolean
         arg types: [a.a.b.k.e.a, int]
         candidates:
          a.a.b.k.e.a.a(a.a.b.k.e.a, int):int
          a.a.b.k.e.a.a(android.view.View, int):void
          a.a.b.k.e.a.a(a.a.b.k.e.a, boolean):boolean */
        public void onAnimationEnd(Animator animator) {
            boolean unused = a.this.r = false;
            a.b(a.this);
            if (a.this.i == 0) {
                Collections.sort(a.this.h);
                int[] iArr = new int[a.this.h.size()];
                for (int size = a.this.h.size() - 1; size >= 0; size--) {
                    iArr[size] = ((f) a.this.h.get(size)).f29a;
                }
                a.this.f.a(a.this.e, iArr);
                int unused2 = a.this.o = -1;
                for (f fVar : a.this.h) {
                    fVar.b.setAlpha(1.0f);
                    fVar.b.setTranslationX(0.0f);
                    ViewGroup.LayoutParams layoutParams = fVar.b.getLayoutParams();
                    layoutParams.height = this.f27a;
                    fVar.b.setLayoutParams(layoutParams);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                a.this.e.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                a.this.h.clear();
            }
        }
    }

    /* compiled from: SwipeDismissListViewTouchListener */
    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f28a;
        final /* synthetic */ View b;

        d(a aVar, ViewGroup.LayoutParams layoutParams, View view) {
            this.f28a = layoutParams;
            this.b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f28a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.b.setLayoutParams(this.f28a);
        }
    }

    /* compiled from: SwipeDismissListViewTouchListener */
    public interface e {
        void a(ListView listView, int[] iArr);

        boolean a(int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SwipeDismissListViewTouchListener */
    public class f implements Comparable<f> {

        /* renamed from: a  reason: collision with root package name */
        public int f29a;
        public View b;

        public f(a aVar, int i, View view) {
            this.f29a = i;
            this.b = view;
        }

        /* renamed from: a */
        public int compareTo(f fVar) {
            return fVar.f29a - this.f29a;
        }
    }

    public a(ListView listView, e eVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(listView.getContext());
        this.f24a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = (long) listView.getContext().getResources().getInteger(17694720);
        this.e = listView;
        this.f = eVar;
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.i - 1;
        aVar.i = i2;
        return i2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int i2;
        if (this.g < 2) {
            this.g = this.e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    VelocityTracker velocityTracker = this.n;
                    if (velocityTracker != null && !this.q) {
                        velocityTracker.addMovement(motionEvent);
                        float rawX = motionEvent.getRawX() - this.j;
                        float rawY = motionEvent.getRawY() - this.k;
                        if (Math.abs(rawX) > ((float) this.f24a) && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                            this.l = true;
                            this.m = rawX > 0.0f ? this.f24a : -this.f24a;
                            this.e.requestDisallowInterceptTouchEvent(true);
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.e.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (this.l) {
                            this.p.setTranslationX(rawX - ((float) this.m));
                            this.p.setAlpha(Math.max(0.2f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / ((float) this.g)))));
                            return true;
                        }
                    }
                } else if (actionMasked == 3 && this.n != null) {
                    View view2 = this.p;
                    if (view2 != null && this.l) {
                        view2.animate().translationX(0.0f).alpha(1.0f).setDuration(this.d).setListener(null);
                    }
                    this.n.recycle();
                    this.n = null;
                    this.j = 0.0f;
                    this.k = 0.0f;
                    this.p = null;
                    this.o = -1;
                    this.l = false;
                }
            } else if (this.n != null) {
                this.r = true;
                float rawX2 = motionEvent.getRawX() - this.j;
                this.n.addMovement(motionEvent);
                this.n.computeCurrentVelocity(1000);
                float xVelocity = this.n.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.n.getYVelocity());
                if (Math.abs(rawX2) <= ((float) (this.g / 2)) || !this.l) {
                    if (((float) this.b) > abs || abs > ((float) this.c) || abs2 >= abs || !this.l) {
                        z2 = false;
                    } else {
                        z2 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                        if (this.n.getXVelocity() > 0.0f) {
                            z = true;
                        }
                    }
                    z = false;
                } else {
                    z = rawX2 > 0.0f;
                    z2 = true;
                }
                if (!z2 || (i2 = this.o) == -1) {
                    this.p.animate().translationX(0.0f).alpha(1.0f).setDuration(this.d).setListener(null);
                    this.r = false;
                } else {
                    View view3 = this.p;
                    this.i++;
                    view3.animate().translationX((float) (z ? this.g : -this.g)).alpha(0.0f).setDuration(this.d).setListener(new b(view3, i2));
                }
                this.n.recycle();
                this.n = null;
                this.j = 0.0f;
                this.k = 0.0f;
                this.p = null;
                this.o = -1;
                this.l = false;
            }
            return false;
        }
        if (!this.q && !this.r) {
            Rect rect = new Rect();
            int childCount = this.e.getChildCount();
            int[] iArr = new int[2];
            this.e.getLocationOnScreen(iArr);
            int rawX3 = ((int) motionEvent.getRawX()) - iArr[0];
            int rawY2 = ((int) motionEvent.getRawY()) - iArr[1];
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = this.e.getChildAt(i3);
                childAt.getHitRect(rect);
                if (rect.contains(rawX3, rawY2)) {
                    this.p = childAt;
                    break;
                }
                i3++;
            }
            if (this.p != null) {
                this.j = motionEvent.getRawX();
                this.k = motionEvent.getRawY();
                int positionForView = this.e.getPositionForView(this.p);
                this.o = positionForView;
                if (this.f.a(positionForView)) {
                    VelocityTracker obtain2 = VelocityTracker.obtain();
                    this.n = obtain2;
                    obtain2.addMovement(motionEvent);
                } else {
                    this.p = null;
                }
            }
        }
        return false;
    }

    public void a(boolean z) {
        this.q = !z;
    }

    public AbsListView.OnScrollListener a() {
        return new C0003a();
    }

    /* access modifiers changed from: private */
    public void a(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int height = view.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.d / 2);
        duration.addListener(new c(height));
        duration.addUpdateListener(new d(this, layoutParams, view));
        this.h.add(new f(this, i2, view));
        duration.start();
    }
}
