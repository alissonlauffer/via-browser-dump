package a.a.b.p;

import a.a.b.a;
import a.a.b.d;
import a.a.b.g;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: LayoutUtils */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f43a = 333;

    public static View a(View... viewArr) {
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
        relativeLayout.setId(f43a);
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

    public static TextView a(Context context, int i) {
        return a(context, a.e(context, i));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    public static TextView a(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setTextColor(a.b(context, a.i));
        textView.setTextSize(0, (float) a.c(context, a.a.b.c.k));
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setGravity(17);
        textView.setText(str);
        a.a(textView, 0, b.a(context, 20.0f));
        textView.setId(3);
        return textView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.c.a(android.content.Context, boolean):android.widget.ListView
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.c.a(android.content.Context, int):android.widget.TextView
      a.a.b.p.c.a(android.content.Context, java.lang.String):android.widget.TextView
      a.a.b.p.c.a(android.content.Context, boolean):android.widget.ListView */
    public static ListView a(Context context) {
        return a(context, false);
    }

    public static ListView a(Context context, boolean z) {
        ListView listView = new ListView(new ContextThemeWrapper(context, g.i));
        listView.setId(77);
        listView.setDividerHeight(0);
        listView.setSelector(d.f);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, z ? -1 : -2));
        listView.setOverScrollMode(2);
        return listView;
    }
}
