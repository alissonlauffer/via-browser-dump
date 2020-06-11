package mark.via.i.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/* compiled from: SmoothProgressBar */
public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f281a;
    /* access modifiers changed from: private */
    public SeekBar b;
    /* access modifiers changed from: private */
    public int c = 100;
    private ObjectAnimator d;
    private int e;
    /* access modifiers changed from: private */
    public final boolean f;

    /* compiled from: SmoothProgressBar */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f282a;

        a(int i) {
            this.f282a = i;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Build.VERSION.SDK_INT >= 12) {
                (c.this.f ? c.this.b : c.this.f281a).setProgress((int) (((float) this.f282a) + (((float) (c.this.c - this.f282a)) * valueAnimator.getAnimatedFraction())));
            }
        }
    }

    /* compiled from: SmoothProgressBar */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            (c.this.f ? c.this.b : c.this.f281a).setVisibility(8);
            (c.this.f ? c.this.b : c.this.f281a).setProgress(0);
            (c.this.f ? c.this.b : c.this.f281a).setAlpha(1.0f);
        }
    }

    public c(ProgressBar progressBar) {
        this.f281a = progressBar;
        this.e = 0;
        this.c = progressBar.getMax();
        this.f = false;
    }

    private ProgressBar a() {
        return this.f ? this.b : this.f281a;
    }

    @TargetApi(11)
    private void b(int i) {
        int max = Math.max(160, (Math.abs(i - this.c) * 300) / this.c);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f ? this.b : this.f281a, "alpha", 1.0f, 0.0f);
        this.d = ofFloat;
        ofFloat.setDuration((long) max);
        this.d.setInterpolator(new DecelerateInterpolator());
        this.d.addUpdateListener(new a(i));
        this.d.addListener(new b());
        this.d.start();
    }

    public void a(int i) {
        if (this.e == 0 && i < this.c) {
            a().setVisibility(0);
            this.e = 1;
        }
        if (this.e == 1) {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null && Build.VERSION.SDK_INT >= 11) {
                objectAnimator.removeAllListeners();
                this.d.cancel();
                a().setAlpha(1.0f);
            }
            int progress = a().getProgress();
            if (i >= this.c) {
                this.e = 0;
                if (Build.VERSION.SDK_INT >= 11) {
                    b(a().getProgress());
                    return;
                }
                a().setVisibility(8);
                a().setProgress(0);
            } else if (Build.VERSION.SDK_INT >= 11) {
                a(i, progress);
            } else {
                a().setProgress(i);
            }
        }
    }

    @TargetApi(11)
    private void a(int i, int i2) {
        int max = Math.max(160, (Math.abs(i2 - i) * 300) / this.c);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f ? this.b : this.f281a, "progress", i2, i);
        this.d = ofInt;
        ofInt.setDuration((long) max);
        this.d.setInterpolator(new DecelerateInterpolator());
        this.d.start();
    }
}
