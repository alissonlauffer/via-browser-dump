package mark.via.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import android.webkit.WebView;
import java.util.HashMap;

public class FastView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f439a = false;
    private boolean b = false;
    private int c = -1;
    private boolean d = true;
    private String e = null;
    private boolean f = false;

    public FastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean a() {
        return this.f;
    }

    public boolean canGoForward() {
        return this.d && super.canGoForward();
    }

    public int getWebColor() {
        return this.c;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [mark.via.ui.view.FastView, android.webkit.WebView] */
    public void loadUrl(String str) {
        HashMap hashMap = new HashMap();
        if (((FastView) this).f439a) {
            hashMap.put("dnt", "1");
        }
        if (((FastView) this).b) {
            hashMap.put("x-requested-with", "");
            hashMap.put("x-wap-profile", "");
        }
        String str2 = ((FastView) this).e;
        if (str2 != null) {
            hashMap.put("referer", str2);
            ((FastView) this).e = null;
        }
        super.loadUrl(str, hashMap);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (z && getParent() != null) {
            this.f = true;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null && motionEvent.getAction() == 0) {
            this.f = getUrl() == null;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCanForward(boolean z) {
        this.d = z;
    }

    public void setDoNotTrack(boolean z) {
        this.f439a = z;
    }

    public void setReferer(String str) {
        if (TextUtils.isEmpty(str) || (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str))) {
            this.e = null;
        } else {
            this.e = str;
        }
    }

    public void setRemoveIdentifyingHeaders(boolean z) {
        this.b = z;
    }

    public void setWebColor(int i) {
        this.c = i;
    }

    public FastView(Context context) {
        super(context);
    }
}
