package mark.lib.frogsupport.adapter.delegate;

import android.util.SparseArray;

/* renamed from: mark.lib.frogsupport.k.d.b */
/* compiled from: ItemViewDelegateManager */
public class ItemViewDelegateManager<T> {

    /* renamed from: a */
    SparseArray<ItemViewDelegate<T>> f1104a = new SparseArray<>();

    /* renamed from: a */
    public ItemViewDelegateManager<T> mo691a(ItemViewDelegate<T> aVar) {
        int size = this.f1104a.size();
        if (aVar != null) {
            this.f1104a.put(size, aVar);
        }
        return this;
    }

    /* renamed from: b */
    public ItemViewDelegate mo692b(T t, int i) {
        for (int size = this.f1104a.size() - 1; size >= 0; size--) {
            ItemViewDelegate<T> valueAt = this.f1104a.valueAt(size);
            if (valueAt.mo673b(t, i)) {
                return valueAt;
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }

    /* renamed from: c */
    public int mo693c() {
        return this.f1104a.size();
    }

    /* renamed from: d */
    public int mo694d(T t, int i) {
        for (int size = this.f1104a.size() - 1; size >= 0; size--) {
            if (this.f1104a.valueAt(size).mo673b(t, i)) {
                return this.f1104a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }
}
