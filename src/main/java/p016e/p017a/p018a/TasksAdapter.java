package p016e.p017a.p018a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: e.a.a.g */
/* compiled from: TasksAdapter */
public abstract class TasksAdapter extends BaseAdapter {

    /* renamed from: a */
    private List<Task> f936a = new ArrayList();

    /* renamed from: b */
    private List<Long> f937b = new ArrayList();

    /* renamed from: c */
    private int f938c;

    /* renamed from: d */
    private int f939d;

    /* renamed from: e */
    private AbstractC0338a f940e;

    /* renamed from: f */
    private int f941f = -1;

    /* renamed from: e.a.a.g$a */
    /* compiled from: TasksAdapter */
    public interface AbstractC0338a {
        /* renamed from: a */
        void mo432a(boolean z);
    }

    public TasksAdapter(int i) {
        this.f939d = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m959b() {
        if (this.f940e != null) {
            int i = getCount() <= 0 ? 0 : 1;
            if (this.f941f != i) {
                this.f940e.mo432a(i ^ 1);
                this.f941f = i;
            }
        }
    }

    /* renamed from: f */
    private int m960f(long j) {
        int i = this.f938c;
        if (i >= 0 && i < this.f937b.size() && this.f937b.get(this.f938c).longValue() == j) {
            return this.f938c;
        }
        int size = this.f937b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (j == this.f937b.get(i2).longValue()) {
                this.f938c = i2;
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo418a(TaskViewHolder fVar, Task eVar);

    /* renamed from: c */
    public boolean mo419c(long j) {
        return m960f(j) >= 0;
    }

    /* renamed from: d */
    public Task getItem(int i) {
        return this.f936a.get(i);
    }

    /* renamed from: e */
    public String mo421e() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Long l : this.f937b) {
            long longValue = l.longValue();
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(longValue);
        }
        return sb.toString();
    }

    /* renamed from: g */
    public void mo422g(Task eVar) {
        if (eVar != null) {
            int f = m960f(eVar.mo409d());
            if (f > -1) {
                this.f936a.set(f, eVar);
            } else {
                this.f936a.add(0, eVar);
                this.f937b.add(0, Long.valueOf(eVar.mo409d()));
            }
            notifyDataSetChanged();
            m959b();
        }
    }

    public int getCount() {
        return this.f936a.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TaskViewHolder fVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(this.f939d, viewGroup, false);
            fVar = new TaskViewHolder(view);
        } else {
            fVar = (TaskViewHolder) view.getTag();
        }
        mo418a(fVar, this.f936a.get(i));
        return view;
    }

    /* renamed from: h */
    public long mo427h(int i) {
        if (i < 0 || i > this.f937b.size()) {
            return -1;
        }
        long longValue = this.f937b.get(i).longValue();
        this.f937b.remove(i);
        this.f936a.remove(i);
        notifyDataSetChanged();
        m959b();
        return longValue;
    }

    /* renamed from: i */
    public void mo428i(List<Task> list) {
        if (list != null && !list.isEmpty()) {
            this.f936a = list;
            this.f937b = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.f937b.add(Long.valueOf(list.get(i).mo409d()));
            }
            notifyDataSetChanged();
        }
        m959b();
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    /* renamed from: j */
    public void mo430j(AbstractC0338a aVar) {
        this.f940e = aVar;
    }

    /* renamed from: k */
    public void mo431k(int i, Task eVar) {
        if (i >= 0 && i < this.f937b.size() && eVar != null && this.f937b.get(i).longValue() != eVar.mo409d()) {
            this.f937b.set(i, Long.valueOf(eVar.mo409d()));
            this.f936a.set(i, eVar);
            notifyDataSetChanged();
        }
    }
}
