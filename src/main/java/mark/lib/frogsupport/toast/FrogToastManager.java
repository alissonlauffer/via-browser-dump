package mark.lib.frogsupport.toast;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/* renamed from: mark.lib.frogsupport.o.b */
/* compiled from: FrogToastManager */
public class FrogToastManager extends Handler {

    /* renamed from: d */
    private static volatile FrogToastManager f1181d;

    /* renamed from: a */
    private FrogToast f1182a;

    /* renamed from: b */
    private AnimationSet f1183b = null;

    /* renamed from: c */
    private AnimationSet f1184c = null;

    /* renamed from: b */
    private void m1323b() {
        FrogToast aVar = this.f1182a;
        if (aVar != null && !aVar.mo771k() && !this.f1182a.mo772l()) {
            ViewGroup j = this.f1182a.mo770j();
            View i = this.f1182a.mo769i();
            try {
                j.addView(i);
                i.startAnimation(m1326e());
            } catch (Exception e) {
                e.printStackTrace();
            }
            sendMessageDelayed(obtainMessage(16), (long) this.f1182a.mo768h());
        }
    }

    /* renamed from: c */
    private Animation m1324c() {
        AnimationSet animationSet = this.f1184c;
        if (animationSet != null) {
            return animationSet;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.1f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        AnimationSet animationSet2 = new AnimationSet(true);
        this.f1184c = animationSet2;
        animationSet2.addAnimation(translateAnimation);
        this.f1184c.addAnimation(alphaAnimation);
        this.f1184c.setInterpolator(new DecelerateInterpolator());
        this.f1184c.setDuration(180);
        return this.f1184c;
    }

    /* renamed from: d */
    public static FrogToastManager m1325d() {
        if (f1181d == null) {
            synchronized (FrogToast.class) {
                if (f1181d == null) {
                    f1181d = new FrogToastManager();
                }
            }
        }
        return f1181d;
    }

    /* renamed from: e */
    private Animation m1326e() {
        AnimationSet animationSet = this.f1183b;
        if (animationSet != null) {
            return animationSet;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.1f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet2 = new AnimationSet(true);
        this.f1183b = animationSet2;
        animationSet2.addAnimation(translateAnimation);
        this.f1183b.addAnimation(alphaAnimation);
        this.f1183b.setInterpolator(new DecelerateInterpolator());
        this.f1183b.setDuration(180);
        return this.f1183b;
    }

    /* renamed from: a */
    public void mo775a(FrogToast aVar) {
        removeMessages(1);
        removeMessages(16);
        mo776f(false);
        if (aVar != null && aVar.mo767g() != null && !aVar.mo771k() && !aVar.mo772l()) {
            this.f1182a = aVar;
            sendMessage(obtainMessage(1));
        }
    }

    /* renamed from: f */
    public void mo776f(boolean z) {
        ViewGroup j;
        View i;
        FrogToast aVar = this.f1182a;
        if (aVar != null && (j = aVar.mo770j()) != null && (i = this.f1182a.mo769i()) != null) {
            if (!this.f1182a.mo772l()) {
                j.removeView(i);
            } else {
                i.clearAnimation();
                if (z) {
                    i.startAnimation(m1324c());
                }
                j.removeView(i);
            }
            this.f1182a.mo766f();
            this.f1182a = null;
        }
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            m1323b();
        } else if (i != 16) {
            super.handleMessage(message);
        } else {
            mo776f(true);
        }
    }
}
