package mark.via.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.gp.R;
import mark.via.util.r;

public class FileFinder extends BaseActivity {
    private static final Comparator<File> f = new d();
    /* access modifiers changed from: private */
    public List<File> c = new ArrayList();
    private a.a.b.k.a d;
    private TextView e;

    class a extends a.a.b.k.a<File> {
        a(FileFinder fileFinder, Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(a.a.b.k.c cVar, File file, int i) {
            cVar.a(R.id.a2, i == 0 ? ".." : file.getName());
            cVar.a(R.id.a1, file.isFile() ? R.drawable.ac : R.drawable.ab);
        }
    }

    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            File file = (File) FileFinder.this.c.get(i);
            if (file.isDirectory()) {
                FileFinder.this.a(file);
            } else {
                FileFinder.this.a(file.getAbsolutePath());
            }
        }
    }

    class c implements FileFilter {
        c(FileFinder fileFinder) {
        }

        public boolean accept(File file) {
            return !file.isHidden();
        }
    }

    class d implements Comparator<File> {
        d() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().toLowerCase(mark.via.b.a.f245a).compareTo(file2.getName().toLowerCase(mark.via.b.a.f245a));
        }
    }

    /* access modifiers changed from: protected */
    @Override // mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r.a(((BaseActivity) this).f233a, mark.via.f.a.b(((BaseActivity) this).b).a(((BaseActivity) this).b));
        setContentView(a());
        r.b(findViewById(a.a.b.m.a.f));
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Bundle extras = ((BaseActivity) this).f233a.getIntent().getExtras();
        if (extras != null && extras.containsKey("Path")) {
            absolutePath = extras.getString("Path", absolutePath);
        }
        a(new File(absolutePath));
    }

    private View a() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b("");
        a2.a(R.string.ca);
        View a3 = a2.a();
        this.e = (TextView) a3.findViewById(a.a.b.m.a.g);
        ListView listView = new ListView(new ContextThemeWrapper(((BaseActivity) this).b, (int) R.style.i));
        listView.setDividerHeight(0);
        listView.setId(989);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        a aVar = new a(this, ((BaseActivity) this).b, R.layout.u, this.c);
        this.d = aVar;
        listView.setAdapter((ListAdapter) aVar);
        listView.setOnItemClickListener(new b());
        return a.a.b.p.c.a(a3, listView);
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        if (file != null && !file.isFile()) {
            this.e.setText(file.getAbsolutePath());
            File[] listFiles = file.listFiles(new c(this));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        arrayList.add(file2);
                    }
                    if (file2.isFile()) {
                        arrayList2.add(file2);
                    }
                }
            }
            Collections.sort(arrayList, f);
            Collections.sort(arrayList2, f);
            if (file.getParentFile() != null) {
                file = file.getParentFile();
            }
            this.c.clear();
            this.c.add(file);
            this.c.addAll(arrayList);
            this.c.addAll(arrayList2);
            this.d.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.setDataAndType(Uri.fromFile(new File(str)), "vnd.android.cursor.dir/lysesoft.andexplorer.mFile");
        setResult(-1, intent);
        finish();
    }
}
