package mark.via.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import mark.lib.frogsupport.util.CompatUtils;

/* renamed from: mark.via.n.r */
/* compiled from: MenuUtils */
public class MenuUtils {
    /* renamed from: a */
    public static void m2185a(View view, int i, int i2, int i3) {
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            Context context = textView.getContext();
            Drawable d = CompatUtils.m1334d(context, i2);
            int c = ViewUtils.m2225c(context, 20);
            d.setBounds(0, 0, c, c);
            d.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            textView.setCompoundDrawables(null, d, null, null);
        }
    }
}
