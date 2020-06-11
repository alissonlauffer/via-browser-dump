package a.a.b.k;

import android.content.Context;
import java.util.List;

/* compiled from: CommonAdapter */
public abstract class a<T> extends b<T> {
    private boolean d = false;
    private b e;

    /* renamed from: a.a.b.k.a$a  reason: collision with other inner class name */
    /* compiled from: CommonAdapter */
    class C0002a implements a.a.b.k.d.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20a;

        C0002a(a aVar, int i) {
            this.f20a = i;
        }

        @Override // a.a.b.k.d.a
        public int a() {
            return this.f20a;
        }

        @Override // a.a.b.k.d.a
        public boolean a(T t, int i) {
            return true;
        }
    }

    /* compiled from: CommonAdapter */
    public interface b {
        void a(boolean z);
    }

    public a(Context context, int i, List<T> list) {
        super(context, list);
        a(new C0002a(this, i));
    }

    public void a(List<T> list) {
        ((b) this).b = list;
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        boolean z = getCount() == 0;
        if (this.d != z) {
            a(z);
        }
    }

    public void a(b bVar) {
        this.e = bVar;
        if (bVar != null) {
            a(isEmpty());
        }
    }

    private void a(boolean z) {
        this.d = z;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(z);
        }
    }
}
