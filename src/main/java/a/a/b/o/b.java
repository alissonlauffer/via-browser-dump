package a.a.b.o;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/* compiled from: FrogToastManager */
public class b extends Handler {
    private static volatile b d;

    /* renamed from: a  reason: collision with root package name */
    private a f42a;
    private AnimationSet b = null;
    private AnimationSet c = null;

    private void a() {
        a aVar = this.f42a;
        if (aVar != null && !aVar.f() && !this.f42a.g()) {
            ViewGroup e = this.f42a.e();
            View d2 = this.f42a.d();
            try {
                e.addView(d2);
                d2.startAnimation(d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            sendMessageDelayed(obtainMessage(16), (long) this.f42a.c());
        }
    }

    private Animation b() {
        AnimationSet animationSet = this.c;
        if (animationSet != null) {
            return animationSet;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.1f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        AnimationSet animationSet2 = new AnimationSet(true);
        this.c = animationSet2;
        animationSet2.addAnimation(translateAnimation);
        this.c.addAnimation(alphaAnimation);
        this.c.setInterpolator(new DecelerateInterpolator());
        this.c.setDuration(180);
        return this.c;
    }

    public static b c() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    private Animation d() {
        AnimationSet animationSet = this.b;
        if (animationSet != null) {
            return animationSet;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.1f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet2 = new AnimationSet(true);
        this.b = animationSet2;
        animationSet2.addAnimation(translateAnimation);
        this.b.addAnimation(alphaAnimation);
        this.b.setInterpolator(new DecelerateInterpolator());
        this.b.setDuration(180);
        return this.b;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            a();
        } else if (i != 16) {
            super.handleMessage(message);
        } else {
            a(true);
        }
    }

    public void a(boolean z) {
        ViewGroup e;
        View d2;
        a aVar = this.f42a;
        if (aVar != null && (e = aVar.e()) != null && (d2 = this.f42a.d()) != null) {
            if (!this.f42a.g()) {
                e.removeView(d2);
            } else {
                d2.clearAnimation();
                if (z) {
                    d2.startAnimation(b());
                }
                e.removeView(d2);
            }
            this.f42a.a();
            this.f42a = null;
        }
    }

    public void a(a aVar) {
        removeMessages(1);
        removeMessages(16);
        a(false);
        if (aVar != null && aVar.b() != null && !aVar.f() && !aVar.g()) {
            this.f42a = aVar;
            sendMessage(obtainMessage(1));
        }
    }
}
