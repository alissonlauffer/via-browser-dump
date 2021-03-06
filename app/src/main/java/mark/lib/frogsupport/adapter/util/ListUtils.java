package mark.lib.frogsupport.adapter.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import mark.lib.frogsupport.adapter.ViewHolder;

/* renamed from: mark.lib.frogsupport.k.f.a */
/* compiled from: ListUtils */
public class ListUtils {
    /* renamed from: a */
    public static ViewHolder m1228a(AbsListView absListView, int i) {
        if (i < 0) {
            return null;
        }
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            return null;
        }
        return (ViewHolder) absListView.getChildAt(i - firstVisiblePosition).getTag();
    }

    /* renamed from: b */
    public static void m1229b(ListView listView) {
        ListAdapter adapter;
        if (!(listView == null || (adapter = listView.getAdapter()) == null)) {
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
