package mark.via.p044m.p047c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/* renamed from: mark.via.m.c.c */
/* compiled from: SmoothProgressBar */
public class SmoothProgressBar {

    /* renamed from: a */
    private ProgressBar f1500a;

    /* renamed from: b */
    private SeekBar f1501b;

    /* renamed from: c */
    private int f1502c = 100;

    /* renamed from: d */
    private ObjectAnimator f1503d;

    /* renamed from: e */
    private int f1504e;

    /* renamed from: f */
    private final boolean f1505f;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.c.c$a */
    /* compiled from: SmoothProgressBar */
    public class C0489a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int f1506a;

        C0489a(int i) {
            this.f1506a = i;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Build.VERSION.SDK_INT >= 12) {
                (SmoothProgressBar.this.f1505f ? SmoothProgressBar.this.f1501b : SmoothProgressBar.this.f1500a).setProgress((int) (((float) this.f1506a) + (((float) (SmoothProgressBar.this.f1502c - this.f1506a)) * valueAnimator.getAnimatedFraction())));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.c.c$b */
    /* compiled from: SmoothProgressBar */
    public class C0490b extends AnimatorListenerAdapter {
        C0490b() {
        }

        public void onAnimationEnd(Animator animator) {
            (SmoothProgressBar.this.f1505f ? SmoothProgressBar.this.f1501b : SmoothProgressBar.this.f1500a).setVisibility(8);
            (SmoothProgressBar.this.f1505f ? SmoothProgressBar.this.f1501b : SmoothProgressBar.this.f1500a).setProgress(0);
            (SmoothProgressBar.this.f1505f ? SmoothProgressBar.this.f1501b : SmoothProgressBar.this.f1500a).setAlpha(1.0f);
        }
    }

    public SmoothProgressBar(ProgressBar progressBar) {
        this.f1500a = progressBar;
        this.f1504e = 0;
        this.f1502c = progressBar.getMax();
        this.f1505f = false;
    }

    /* renamed from: e */
    private ProgressBar m2036e() {
        return this.f1505f ? this.f1501b : this.f1500a;
    }

    @TargetApi(11)
    /* renamed from: g */
    private void m2037g(int i) {
        int max = Math.max(160, (Math.abs(i - this.f1502c) * 300) / this.f1502c);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f1505f ? this.f1501b : this.f1500a, "alpha", 1.0f, 0.0f);
        this.f1503d = ofFloat;
        ofFloat.setDuration((long) max);
        this.f1503d.setInterpolator(new DecelerateInterpolator());
        this.f1503d.addUpdateListener(new C0489a(i));
        this.f1503d.addListener(new C0490b());
        this.f1503d.start();
    }

    @TargetApi(11)
    /* renamed from: h */
    private void m2038h(int i, int i2) {
        int max = Math.max(160, (Math.abs(i2 - i) * 300) / this.f1502c);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f1505f ? this.f1501b : this.f1500a, "progress", i2, i);
        this.f1503d = ofInt;
        ofInt.setDuration((long) max);
        this.f1503d.setInterpolator(new DecelerateInterpolator());
        this.f1503d.start();
    }

    /* renamed from: f */
    public void mo1300f(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (this.f1504e == 0 && i < this.f1502c) {
            m2036e().setVisibility(0);
            this.f1504e = 1;
        }
        if (this.f1504e == 1) {
            ObjectAnimator objectAnimator = this.f1503d;
            if (objectAnimator != null && i2 >= 11) {
                objectAnimator.removeAllListeners();
                this.f1503d.cancel();
                m2036e().setAlpha(1.0f);
            }
            int progress = m2036e().getProgress();
            if (i >= this.f1502c) {
                this.f1504e = 0;
                if (i2 >= 11) {
                    m2037g(m2036e().getProgress());
                    return;
                }
                m2036e().setVisibility(8);
                m2036e().setProgress(0);
            } else if (i2 >= 11) {
                m2038h(i, progress);
            } else {
                m2036e().setProgress(i);
            }
        }
    }
}
