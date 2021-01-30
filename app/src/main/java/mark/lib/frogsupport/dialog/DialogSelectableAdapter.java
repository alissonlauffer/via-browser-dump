package mark.lib.frogsupport.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;

/* renamed from: mark.lib.frogsupport.i.b */
/* compiled from: DialogSelectableAdapter */
public class DialogSelectableAdapter extends BaseAdapter {

    /* renamed from: a */
    private List<String> f1047a;

    /* renamed from: b */
    private int f1048b = -1;

    /* renamed from: c */
    private HashSet<Integer> f1049c;

    /* renamed from: d */
    private boolean f1050d;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.i.b$a */
    /* compiled from: DialogSelectableAdapter */
    public class C0371a implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        final /* synthetic */ AbsListView f1051a;

        /* renamed from: b */
        final /* synthetic */ AdapterView.OnItemClickListener f1052b;

        C0371a(AbsListView absListView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f1051a = absListView;
            this.f1052b = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            DialogSelectableAdapter.this.m1127h(this.f1051a, i);
            AdapterView.OnItemClickListener onItemClickListener = this.f1052b;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mark.lib.frogsupport.i.b$b */
    /* compiled from: DialogSelectableAdapter */
    public static class C0372b {

        /* renamed from: a */
        public CheckBox f1054a;

        public C0372b(View view) {
            this.f1054a = (CheckBox) view.findViewById(C0366e.k);
        }
    }

    public DialogSelectableAdapter(List<String> list, int[] iArr, boolean z) {
        this.f1047a = list;
        this.f1050d = z;
        if (z) {
            this.f1049c = new HashSet<>();
            for (int i : iArr) {
                this.f1049c.add(Integer.valueOf(i));
            }
        } else if (iArr != null && iArr.length > 0) {
            this.f1048b = iArr[0];
        }
    }

    /* renamed from: e */
    public static C0372b m1126e(AbsListView absListView, int i) {
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            return null;
        }
        return (C0372b) absListView.getChildAt(i - firstVisiblePosition).getTag();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h */
    private void m1127h(AbsListView absListView, int i) {
        if (this.f1050d) {
            if (this.f1049c.contains(Integer.valueOf(i))) {
                this.f1049c.remove(Integer.valueOf(i));
            } else {
                this.f1049c.add(Integer.valueOf(i));
            }
            mo603g(absListView, i);
            return;
        }
        int i2 = this.f1048b;
        if (i != i2) {
            this.f1048b = i;
            mo603g(absListView, i2);
            mo603g(absListView, i);
        }
    }

    /* renamed from: i */
    private void m1128i(C0372b bVar, int i) {
        if (bVar != null) {
            bVar.f1054a.setEnabled(false);
            bVar.f1054a.setText(this.f1047a.get(i));
            if (this.f1050d) {
                bVar.f1054a.setChecked(this.f1049c.contains(Integer.valueOf(i)));
            } else {
                bVar.f1054a.setChecked(i == this.f1048b);
            }
            bVar.f1054a.setFocusable(false);
            bVar.f1054a.setClickable(false);
        }
    }

    /* renamed from: b */
    public void mo599b(AbsListView absListView, AdapterView.OnItemClickListener onItemClickListener) {
        absListView.setAdapter((ListAdapter) this);
        absListView.setOnItemClickListener(new C0371a(absListView, onItemClickListener));
    }

    /* renamed from: c */
    public String getItem(int i) {
        return this.f1047a.get(i);
    }

    /* renamed from: d */
    public int[] mo601d() {
        int i = 0;
        if (!this.f1050d) {
            return new int[]{this.f1048b};
        }
        int[] iArr = new int[this.f1049c.size()];
        Iterator<Integer> it = this.f1049c.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        Arrays.sort(iArr);
        return iArr;
    }

    /* renamed from: f */
    public boolean mo602f() {
        return this.f1050d;
    }

    /* renamed from: g */
    public void mo603g(AbsListView absListView, int i) {
        C0372b e = m1126e(absListView, i);
        if (e != null) {
            m1128i(e, i);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1047a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0372b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C0367f.k, viewGroup, false);
            bVar = new C0372b(view);
            view.setTag(bVar);
        } else {
            bVar = (C0372b) view.getTag();
        }
        m1128i(bVar, i);
        return view;
    }
}
