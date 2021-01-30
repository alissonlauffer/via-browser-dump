package mark.lib.frogsupport.adapter.listener;

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
/* renamed from: mark.lib.frogsupport.k.e.a */
/* compiled from: SwipeDismissListViewTouchListener */
public class SwipeDismissListViewTouchListener implements View.OnTouchListener {

    /* renamed from: a */
    private int f1105a;

    /* renamed from: b */
    private int f1106b;

    /* renamed from: c */
    private int f1107c;

    /* renamed from: d */
    private long f1108d;

    /* renamed from: e */
    private ListView f1109e;

    /* renamed from: f */
    private AbstractC0391e f1110f;

    /* renamed from: g */
    private int f1111g = 1;

    /* renamed from: h */
    private List<C0392f> f1112h = new ArrayList();

    /* renamed from: i */
    private int f1113i = 0;

    /* renamed from: j */
    private float f1114j;

    /* renamed from: k */
    private float f1115k;

    /* renamed from: l */
    private boolean f1116l;

    /* renamed from: m */
    private int f1117m;

    /* renamed from: n */
    private VelocityTracker f1118n;

    /* renamed from: o */
    private int f1119o;

    /* renamed from: p */
    private View f1120p;

    /* renamed from: q */
    private boolean f1121q;

    /* renamed from: r */
    private boolean f1122r = false;

    /* renamed from: mark.lib.frogsupport.k.e.a$a */
    /* compiled from: SwipeDismissListViewTouchListener */
    class C0387a implements AbsListView.OnScrollListener {
        C0387a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            SwipeDismissListViewTouchListener aVar = SwipeDismissListViewTouchListener.this;
            boolean z = true;
            if (i == 1) {
                z = false;
            }
            aVar.mo696k(z);
        }
    }

    /* renamed from: mark.lib.frogsupport.k.e.a$b */
    /* compiled from: SwipeDismissListViewTouchListener */
    class C0388b extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ View f1124a;

        /* renamed from: b */
        final /* synthetic */ int f1125b;

        C0388b(View view, int i) {
            this.f1124a = view;
            this.f1125b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeDismissListViewTouchListener.this.m1222j(this.f1124a, this.f1125b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.k.e.a$c */
    /* compiled from: SwipeDismissListViewTouchListener */
    public class C0389c extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f1127a;

        C0389c(int i) {
            this.f1127a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeDismissListViewTouchListener.this.f1122r = false;
            SwipeDismissListViewTouchListener.m1217d(SwipeDismissListViewTouchListener.this);
            if (SwipeDismissListViewTouchListener.this.f1113i == 0) {
                Collections.sort(SwipeDismissListViewTouchListener.this.f1112h);
                int[] iArr = new int[SwipeDismissListViewTouchListener.this.f1112h.size()];
                for (int size = SwipeDismissListViewTouchListener.this.f1112h.size() - 1; size >= 0; size--) {
                    iArr[size] = ((C0392f) SwipeDismissListViewTouchListener.this.f1112h.get(size)).f1131a;
                }
                SwipeDismissListViewTouchListener.this.f1110f.mo704b(SwipeDismissListViewTouchListener.this.f1109e, iArr);
                SwipeDismissListViewTouchListener.this.f1119o = -1;
                for (C0392f fVar : SwipeDismissListViewTouchListener.this.f1112h) {
                    fVar.f1132b.setAlpha(1.0f);
                    fVar.f1132b.setTranslationX(0.0f);
                    ViewGroup.LayoutParams layoutParams = fVar.f1132b.getLayoutParams();
                    layoutParams.height = this.f1127a;
                    fVar.f1132b.setLayoutParams(layoutParams);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                SwipeDismissListViewTouchListener.this.f1109e.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                SwipeDismissListViewTouchListener.this.f1112h.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.k.e.a$d */
    /* compiled from: SwipeDismissListViewTouchListener */
    public class C0390d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup.LayoutParams f1129a;

        /* renamed from: b */
        final /* synthetic */ View f1130b;

        C0390d(SwipeDismissListViewTouchListener aVar, ViewGroup.LayoutParams layoutParams, View view) {
            this.f1129a = layoutParams;
            this.f1130b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1129a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f1130b.setLayoutParams(this.f1129a);
        }
    }

    /* renamed from: mark.lib.frogsupport.k.e.a$e */
    /* compiled from: SwipeDismissListViewTouchListener */
    public interface AbstractC0391e {
        /* renamed from: a */
        boolean mo703a(int i);

        /* renamed from: b */
        void mo704b(ListView listView, int[] iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.k.e.a$f */
    /* compiled from: SwipeDismissListViewTouchListener */
    public class C0392f implements Comparable<C0392f> {

        /* renamed from: a */
        public int f1131a;

        /* renamed from: b */
        public View f1132b;

        public C0392f(SwipeDismissListViewTouchListener aVar, int i, View view) {
            this.f1131a = i;
            this.f1132b = view;
        }

        /* renamed from: a */
        public int compareTo(C0392f fVar) {
            return fVar.f1131a - this.f1131a;
        }
    }

    public SwipeDismissListViewTouchListener(ListView listView, AbstractC0391e eVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(listView.getContext());
        this.f1105a = viewConfiguration.getScaledTouchSlop();
        this.f1106b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f1107c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1108d = (long) listView.getContext().getResources().getInteger(17694720);
        this.f1109e = listView;
        this.f1110f = eVar;
    }

    /* renamed from: d */
    static /* synthetic */ int m1217d(SwipeDismissListViewTouchListener aVar) {
        int i = aVar.f1113i - 1;
        aVar.f1113i = i;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private void m1222j(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int height = view.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f1108d / 2);
        duration.addListener(new C0389c(height));
        duration.addUpdateListener(new C0390d(this, layoutParams, view));
        this.f1112h.add(new C0392f(this, i, view));
        duration.start();
    }

    /* renamed from: i */
    public AbsListView.OnScrollListener mo695i() {
        return new C0387a();
    }

    /* renamed from: k */
    public void mo696k(boolean z) {
        this.f1121q = !z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int i;
        if (this.f1111g < 2) {
            this.f1111g = this.f1109e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    VelocityTracker velocityTracker = this.f1118n;
                    if (velocityTracker != null && !this.f1121q) {
                        velocityTracker.addMovement(motionEvent);
                        float rawX = motionEvent.getRawX() - this.f1114j;
                        float rawY = motionEvent.getRawY() - this.f1115k;
                        if (Math.abs(rawX) > ((float) this.f1105a) && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                            this.f1116l = true;
                            this.f1117m = rawX > 0.0f ? this.f1105a : -this.f1105a;
                            this.f1109e.requestDisallowInterceptTouchEvent(true);
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.f1109e.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (this.f1116l) {
                            this.f1120p.setTranslationX(rawX - ((float) this.f1117m));
                            this.f1120p.setAlpha(Math.max(0.2f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / ((float) this.f1111g)))));
                            return true;
                        }
                    }
                } else if (actionMasked == 3 && this.f1118n != null) {
                    View view2 = this.f1120p;
                    if (view2 != null && this.f1116l) {
                        view2.animate().translationX(0.0f).alpha(1.0f).setDuration(this.f1108d).setListener(null);
                    }
                    this.f1118n.recycle();
                    this.f1118n = null;
                    this.f1114j = 0.0f;
                    this.f1115k = 0.0f;
                    this.f1120p = null;
                    this.f1119o = -1;
                    this.f1116l = false;
                }
            } else if (this.f1118n != null) {
                this.f1122r = true;
                float rawX2 = motionEvent.getRawX() - this.f1114j;
                this.f1118n.addMovement(motionEvent);
                this.f1118n.computeCurrentVelocity(1000);
                float xVelocity = this.f1118n.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.f1118n.getYVelocity());
                if (Math.abs(rawX2) <= ((float) (this.f1111g / 2)) || !this.f1116l) {
                    if (((float) this.f1106b) > abs || abs > ((float) this.f1107c) || abs2 >= abs || !this.f1116l) {
                        z2 = false;
                    } else {
                        z2 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                        if (this.f1118n.getXVelocity() > 0.0f) {
                            z = true;
                        }
                    }
                    z = false;
                } else {
                    z = rawX2 > 0.0f;
                    z2 = true;
                }
                if (!z2 || (i = this.f1119o) == -1) {
                    this.f1120p.animate().translationX(0.0f).alpha(1.0f).setDuration(this.f1108d).setListener(null);
                    this.f1122r = false;
                } else {
                    View view3 = this.f1120p;
                    this.f1113i++;
                    view3.animate().translationX((float) (z ? this.f1111g : -this.f1111g)).alpha(0.0f).setDuration(this.f1108d).setListener(new C0388b(view3, i));
                }
                this.f1118n.recycle();
                this.f1118n = null;
                this.f1114j = 0.0f;
                this.f1115k = 0.0f;
                this.f1120p = null;
                this.f1119o = -1;
                this.f1116l = false;
            }
            return false;
        }
        if (!this.f1121q && !this.f1122r) {
            Rect rect = new Rect();
            int childCount = this.f1109e.getChildCount();
            int[] iArr = new int[2];
            this.f1109e.getLocationOnScreen(iArr);
            int rawX3 = ((int) motionEvent.getRawX()) - iArr[0];
            int rawY2 = ((int) motionEvent.getRawY()) - iArr[1];
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = this.f1109e.getChildAt(i2);
                childAt.getHitRect(rect);
                if (rect.contains(rawX3, rawY2)) {
                    this.f1120p = childAt;
                    break;
                }
                i2++;
            }
            if (this.f1120p != null) {
                this.f1114j = motionEvent.getRawX();
                this.f1115k = motionEvent.getRawY();
                int positionForView = this.f1109e.getPositionForView(this.f1120p);
                this.f1119o = positionForView;
                if (this.f1110f.mo703a(positionForView)) {
                    VelocityTracker obtain2 = VelocityTracker.obtain();
                    this.f1118n = obtain2;
                    obtain2.addMovement(motionEvent);
                } else {
                    this.f1120p = null;
                }
            }
        }
        return false;
    }
}
