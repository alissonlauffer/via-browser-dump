package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public final class x2 {
    public static int a() {
        Point b = b();
        int i = b.x;
        int i2 = b.y;
        if (i == i2) {
            return 3;
        }
        return i < i2 ? 1 : 2;
    }

    @SuppressLint({"NewApi"})
    private static Point b() {
        Display defaultDisplay = ((WindowManager) e1.a().f110a.getSystemService("window")).getDefaultDisplay();
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
