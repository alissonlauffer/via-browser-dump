package mark.via.a;

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
import mark.via.gp.R;

/* compiled from: SearchAdapter */
public class e extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<b> f242a = new ArrayList();
    /* access modifiers changed from: private */
    public List<b> b = new ArrayList();
    /* access modifiers changed from: private */
    public List<b> c = new ArrayList();
    /* access modifiers changed from: private */
    public mark.via.c.b d;
    private final Context e;

    /* compiled from: SearchAdapter */
    private class b extends Filter {
        private b() {
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null) {
                return filterResults;
            }
            String trim = charSequence.toString().trim();
            ArrayList arrayList = new ArrayList();
            e eVar = e.this;
            List unused = eVar.b = eVar.d.g(trim);
            e eVar2 = e.this;
            List unused2 = eVar2.f242a = eVar2.d.h(trim);
            arrayList.addAll(e.this.b);
            arrayList.addAll(e.this.f242a);
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            synchronized (e.this.c) {
                List unused = e.this.c = e.this.a();
                e.this.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: SearchAdapter */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        ImageView f244a;
        TextView b;
        TextView c;

        private c() {
        }
    }

    public e(Context context) {
        this.d = mark.via.c.b.a(context);
        this.e = context;
    }

    public int getCount() {
        List<b> list = this.c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Filter getFilter() {
        return new b();
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = ((Activity) this.e).getLayoutInflater().inflate(R.layout.v, viewGroup, false);
            cVar = new c();
            cVar.b = (TextView) view.findViewById(R.id.bi);
            cVar.c = (TextView) view.findViewById(R.id.bj);
            cVar.f244a = (ImageView) view.findViewById(R.id.a9);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        b bVar = this.c.get(i);
        cVar.b.setText(bVar.e());
        cVar.c.setText(bVar.f());
        int c2 = bVar.c();
        int i2 = R.drawable.ae;
        if (c2 == R.drawable.a8) {
            i2 = R.drawable.a8;
        } else if (c2 != R.drawable.ae) {
            i2 = R.drawable.as;
        }
        cVar.f244a.setImageDrawable(a.a.b.p.a.d(this.e, i2));
        return view;
    }

    /* access modifiers changed from: private */
    public List<b> a() {
        int i;
        ArrayList arrayList = new ArrayList();
        List<b> list = this.f242a;
        int i2 = 0;
        int size = list != null ? list.size() : 0;
        List<b> list2 = this.b;
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
                arrayList.add(this.b.get(i4));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i4++;
        }
        while (i2 < size && i2 < i) {
            try {
                arrayList.add(this.f242a.get(i2));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            i2++;
        }
        return arrayList;
    }
}
