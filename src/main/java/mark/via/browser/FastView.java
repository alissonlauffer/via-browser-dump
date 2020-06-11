package mark.via.browser;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import android.webkit.WebView;
import java.util.HashMap;

public class FastView extends WebView {

    /* renamed from: a */
    private boolean f1197a = false;

    /* renamed from: b */
    private int f1198b = 0;

    /* renamed from: c */
    private boolean f1199c = true;

    /* renamed from: d */
    private String f1200d = null;

    /* renamed from: e */
    private boolean f1201e = false;

    public FastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public boolean mo785a() {
        return this.f1201e;
    }

    public boolean canGoForward() {
        return this.f1199c && super.canGoForward();
    }

    public int getWebColor() {
        return this.f1198b;
    }

    public void loadUrl(String str) {
        HashMap hashMap = new HashMap();
        if (this.f1197a) {
            hashMap.put("dnt", "1");
        }
        String str2 = this.f1200d;
        if (str2 != null) {
            hashMap.put("referer", str2);
            this.f1200d = null;
        }
        super.loadUrl(str, hashMap);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (z && getParent() != null) {
            this.f1201e = true;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null && motionEvent.getAction() == 0) {
            this.f1201e = getUrl() == null;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDoNotTrack(boolean z) {
        this.f1197a = z;
    }

    public void setForwardEnable(boolean z) {
        this.f1199c = z;
    }

    public void setReferer(String str) {
        if (TextUtils.isEmpty(str) || (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str))) {
            this.f1200d = null;
        } else {
            this.f1200d = str;
        }
    }

    public void setWebColor(int i) {
        this.f1198b = i;
    }

    public FastView(Context context) {
        super(context);
    }
}
