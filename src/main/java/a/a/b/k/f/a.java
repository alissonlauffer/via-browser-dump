package a.a.b.k.f;

import a.a.b.k.c;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/* compiled from: ListUtils */
public class a {
    public static c a(AbsListView absListView, int i) {
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            return null;
        }
        return (c) absListView.getChildAt(i - firstVisiblePosition).getTag();
    }

    public static void a(ListView listView) {
        ListAdapter adapter;
        if (listView != null && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }
}
