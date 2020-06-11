package mark.lib.frogsupport.util;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import mark.lib.frogsupport.C0361a;
import mark.lib.frogsupport.C0364c;
import mark.lib.frogsupport.C0365d;
import mark.lib.frogsupport.C0368g;

/* renamed from: mark.lib.frogsupport.p.e */
/* compiled from: LayoutUtils */
public class LayoutUtils {

    /* renamed from: a */
    public static int f1185a = 333;

    /* renamed from: a */
    public static TextView m1363a(Context context, int i) {
        return m1364b(context, CompatUtils.m1336f(context, i));
    }

    /* renamed from: b */
    public static TextView m1364b(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setTextColor(CompatUtils.m1332b(context, C0361a.i));
        textView.setTextSize(0, (float) CompatUtils.m1333c(context, C0364c.p));
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setGravity(17);
        textView.setText(str);
        CompatUtils.m1343m(textView, 0, FrogUtils.m1354a(context, 20.0f));
        textView.setId(3);
        return textView;
    }

    /* renamed from: c */
    public static View m1365c(View... viewArr) {
        if (viewArr == null || viewArr.length <= 0) {
            return null;
        }
        if (viewArr[0] == null) {
            return null;
        }
        if (viewArr.length == 1) {
            return viewArr[0];
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewArr[0].getContext());
        relativeLayout.setId(f1185a);
        int i = -2;
        for (View view : viewArr) {
            relativeLayout.addView(view);
            if (i != -2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.addRule(3, i);
                view.setLayoutParams(layoutParams);
            }
            i = view.getId();
        }
        return relativeLayout;
    }

    /* renamed from: d */
    public static ListView m1366d(Context context) {
        return m1367e(context, false);
    }

    /* renamed from: e */
    public static ListView m1367e(Context context, boolean z) {
        ListView listView = new ListView(new ContextThemeWrapper(context, C0368g.j));
        listView.setId(77);
        listView.setDividerHeight(0);
        listView.setSelector(C0365d.f);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, z ? -1 : -2));
        listView.setOverScrollMode(2);
        return listView;
    }
}
