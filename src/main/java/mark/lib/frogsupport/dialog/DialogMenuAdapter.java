package mark.lib.frogsupport.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;
import mark.lib.frogsupport.dialog.TaoDialog;

/* renamed from: mark.lib.frogsupport.i.a */
/* compiled from: DialogMenuAdapter */
public class DialogMenuAdapter extends ArrayAdapter<TaoDialog.C0381i> {

    /* renamed from: mark.lib.frogsupport.i.a$b */
    /* compiled from: DialogMenuAdapter */
    private static class C0370b {

        /* renamed from: a */
        public TextView f1046a;

        private C0370b() {
        }
    }

    public DialogMenuAdapter(Context context, List<TaoDialog.C0381i> list) {
        super(context, C0367f.l, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        TaoDialog.C0381i iVar = (TaoDialog.C0381i) getItem(i);
        if (iVar != null) {
            return (long) iVar.mo657a();
        }
        return -1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0370b bVar;
        TaoDialog.C0381i iVar = (TaoDialog.C0381i) getItem(i);
        if (view == null) {
            bVar = new C0370b();
            view2 = LayoutInflater.from(getContext()).inflate(C0367f.l, viewGroup, false);
            bVar.f1046a = (TextView) view2.findViewById(C0366e.ba);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (C0370b) view.getTag();
        }
        bVar.f1046a.setText(iVar.mo658b());
        return view2;
    }
}
