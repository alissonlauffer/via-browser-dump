package a.a.b.k.d;

import android.util.SparseArray;

/* compiled from: ItemViewDelegateManager */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    SparseArray<a<T>> f23a = new SparseArray<>();

    public int a() {
        return this.f23a.size();
    }

    public int b(T t, int i) {
        for (int size = this.f23a.size() - 1; size >= 0; size--) {
            if (this.f23a.valueAt(size).a(t, i)) {
                return this.f23a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }

    public b<T> a(a<T> aVar) {
        int size = this.f23a.size();
        if (aVar != null) {
            this.f23a.put(size, aVar);
        }
        return this;
    }

    public a a(T t, int i) {
        for (int size = this.f23a.size() - 1; size >= 0; size--) {
            a<T> valueAt = this.f23a.valueAt(size);
            if (valueAt.a(t, i)) {
                return valueAt;
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }
}
