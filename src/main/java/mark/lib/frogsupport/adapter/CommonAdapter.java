package mark.lib.frogsupport.adapter;

import android.content.Context;
import java.util.List;
import mark.lib.frogsupport.adapter.delegate.ItemViewDelegate;

/* renamed from: mark.lib.frogsupport.k.a */
/* compiled from: CommonAdapter */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {

    /* renamed from: d */
    private boolean f1095d = false;

    /* renamed from: e */
    private AbstractC0386b f1096e;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.k.a$a */
    /* compiled from: CommonAdapter */
    public class C0385a implements ItemViewDelegate<T> {

        /* renamed from: a */
        final /* synthetic */ int f1097a;

        C0385a(CommonAdapter aVar, int i) {
            this.f1097a = i;
        }

        @Override // mark.lib.frogsupport.adapter.delegate.ItemViewDelegate
        /* renamed from: a */
        public int mo672a() {
            return this.f1097a;
        }

        @Override // mark.lib.frogsupport.adapter.delegate.ItemViewDelegate
        /* renamed from: b */
        public boolean mo673b(T t, int i) {
            return true;
        }
    }

    /* renamed from: mark.lib.frogsupport.k.a$b */
    /* compiled from: CommonAdapter */
    public interface AbstractC0386b {
        /* renamed from: a */
        void mo596a(boolean z);
    }

    public CommonAdapter(Context context, int i, List<T> list) {
        super(context, list);
        mo674a(new C0385a(this, i));
    }

    /* renamed from: e */
    private void m1190e(boolean z) {
        this.f1095d = z;
        AbstractC0386b bVar = this.f1096e;
        if (bVar != null) {
            bVar.mo596a(z);
        }
    }

    /* renamed from: f */
    public void mo669f(List<T> list) {
        this.f1099b = list;
        notifyDataSetChanged();
    }

    /* renamed from: g */
    public void mo670g(AbstractC0386b bVar) {
        this.f1096e = bVar;
        if (bVar != null) {
            m1190e(isEmpty());
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        boolean z = getCount() == 0;
        if (this.f1095d != z) {
            m1190e(z);
        }
    }
}
