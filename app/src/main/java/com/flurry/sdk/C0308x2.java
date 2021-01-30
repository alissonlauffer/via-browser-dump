package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

/* renamed from: com.flurry.sdk.x2 */
public final class C0308x2 {
    /* renamed from: a */
    public static int m837a() {
        Point b = m838b();
        int i = b.x;
        int i2 = b.y;
        if (i == i2) {
            return 3;
        }
        return i < i2 ? 1 : 2;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static Point m838b() {
        Display defaultDisplay = ((WindowManager) C0118e1.m386a().f361a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Throwable unused) {
                defaultDisplay.getSize(point);
            }
        }
        return point;
    }
}
