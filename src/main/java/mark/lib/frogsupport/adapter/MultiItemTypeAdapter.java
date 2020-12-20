package mark.lib.frogsupport.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import mark.lib.frogsupport.adapter.delegate.ItemViewDelegate;
import mark.lib.frogsupport.adapter.delegate.ItemViewDelegateManager;

/* renamed from: mark.lib.frogsupport.k.b */
/* compiled from: MultiItemTypeAdapter */
public class MultiItemTypeAdapter<T> extends BaseAdapter {

    /* renamed from: a */
    protected Context f1098a;

    /* renamed from: b */
    protected List<T> f1099b;

    /* renamed from: c */
    private ItemViewDelegateManager f1100c = new ItemViewDelegateManager();

    public MultiItemTypeAdapter(Context context, List<T> list) {
        this.f1098a = context;
        this.f1099b = list;
    }

    /* renamed from: d */
    private boolean m1196d() {
        return this.f1100c.mo693c() > 0;
    }

    /* renamed from: a */
    public MultiItemTypeAdapter mo674a(ItemViewDelegate<T> aVar) {
        this.f1100c.mo691a(aVar);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo675b(ViewHolder cVar, T t, int i) {
        throw null;
    }

    /* renamed from: c */
    public void mo676c(ViewHolder cVar, View view) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1099b.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.f1099b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (m1196d()) {
            return this.f1100c.mo694d(this.f1099b.get(i), i);
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder cVar;
        int a = this.f1100c.mo692b(this.f1099b.get(i), i).mo672a();
        if (view == null) {
            cVar = new ViewHolder(this.f1098a, LayoutInflater.from(this.f1098a).inflate(a, viewGroup, false), viewGroup, i);
            mo676c(cVar, cVar.mo683a());
        } else {
            cVar = (ViewHolder) view.getTag();
            cVar.f1102b = i;
        }
        mo675b(cVar, getItem(i), i);
        return cVar.mo683a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (m1196d()) {
            return this.f1100c.mo693c();
        }
        return super.getViewTypeCount();
    }
}
