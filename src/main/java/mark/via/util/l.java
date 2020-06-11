package mark.via.util;

import a.a.b.p.a;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

/* compiled from: MenuUtils */
public class l {
    public static void a(View view, int i, int i2, int i3) {
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            Context context = textView.getContext();
            Drawable d = a.d(context, i2);
            int a2 = r.a(context, 20);
            d.setBounds(0, 0, a2, a2);
            d.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            textView.setCompoundDrawables(null, d, null, null);
        }
    }
}
