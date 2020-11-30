package mark.via.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.util.CompatUtils;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;

/* renamed from: mark.via.c.d */
/* compiled from: SearchAdapter */
public class SearchAdapter extends BaseAdapter implements Filterable {

    /* renamed from: a */
    private List<HistoryItem> f1287a = new ArrayList();

    /* renamed from: b */
    private List<HistoryItem> f1288b = new ArrayList();

    /* renamed from: c */
    private List<HistoryItem> f1289c = new ArrayList();

    /* renamed from: d */
    private DatabaseHandler f1290d;

    /* renamed from: e */
    private final Context f1291e;

    /* renamed from: mark.via.c.d$b */
    /* compiled from: SearchAdapter */
    private class C0439b extends Filter {
        private C0439b() {
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null) {
                return filterResults;
            }
            String trim = charSequence.toString().trim();
            ArrayList arrayList = new ArrayList();
            SearchAdapter dVar = SearchAdapter.this;
            dVar.f1288b = dVar.f1290d.mo984k(trim);
            SearchAdapter dVar2 = SearchAdapter.this;
            dVar2.f1287a = dVar2.f1290d.mo985l(trim);
            arrayList.addAll(SearchAdapter.this.f1288b);
            arrayList.addAll(SearchAdapter.this.f1287a);
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            synchronized (SearchAdapter.this.f1289c) {
                SearchAdapter dVar = SearchAdapter.this;
                dVar.f1289c = dVar.m1586i();
                SearchAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: mark.via.c.d$c */
    /* compiled from: SearchAdapter */
    private static class C0440c {

        /* renamed from: a */
        ImageView f1293a;

        /* renamed from: b */
        TextView f1294b;

        /* renamed from: c */
        TextView f1295c;

        private C0440c() {
        }
    }

    public SearchAdapter(Context context) {
        this.f1290d = DatabaseHandler.m1595v(context);
        this.f1291e = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i */
    private List<HistoryItem> m1586i() {
        int i;
        ArrayList arrayList = new ArrayList();
        List<HistoryItem> list = this.f1287a;
        int i2 = 0;
        int size = list != null ? list.size() : 0;
        List<HistoryItem> list2 = this.f1288b;
        int size2 = list2 != null ? list2.size() : 0;
        int i3 = 5;
        if (size2 < 5) {
            i = 10 - size2;
        } else {
            if (size < 5) {
                i3 = 10 - size;
            }
            i = 5;
        }
        int i4 = 0;
        while (i4 < size2 && i4 < i3) {
            try {
                arrayList.add(this.f1288b.get(i4));
            } catch (Exception e) {
                e.printStackTrace();
            }
            i4++;
        }
        while (i2 < size && i2 < i) {
            try {
                arrayList.add(this.f1287a.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i2++;
        }
        return arrayList;
    }

    public int getCount() {
        List<HistoryItem> list = this.f1289c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Filter getFilter() {
        return new C0439b();
    }

    public Object getItem(int i) {
        return this.f1289c.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0440c cVar;
        if (view == null) {
            view = ((Activity) this.f1291e).getLayoutInflater().inflate(R.layout.RES_2131361814, viewGroup, false);
            cVar = new C0440c();
            cVar.f1294b = (TextView) view.findViewById(R.id.RES_2131230798);
            cVar.f1295c = (TextView) view.findViewById(R.id.RES_2131230799);
            cVar.f1293a = (ImageView) view.findViewById(R.id.RES_2131230751);
            view.setTag(cVar);
        } else {
            cVar = (C0440c) view.getTag();
        }
        HistoryItem bVar = this.f1289c.get(i);
        cVar.f1294b.setText(bVar.mo940f());
        cVar.f1295c.setText(bVar.mo941g());
        int d = bVar.mo937d();
        int i2 = R.drawable.RES_2131165213;
        if (d == R.drawable.RES_2131165203) {
            i2 = R.drawable.RES_2131165203;
        } else if (d != R.drawable.RES_2131165213) {
            i2 = R.drawable.RES_2131165232;
        }
        cVar.f1293a.setImageDrawable(CompatUtils.m1334d(this.f1291e, i2));
        return view;
    }
}
