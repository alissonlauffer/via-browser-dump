package mark.via.p044m.p046b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import mark.lib.frogsupport.FileProvider;
import mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.gp.R;
import mark.via.preference.PreferenceManager;
import mark.via.utils.AppUtils;
import mark.via.utils.BrowserUtils;
import mark.via.utils.IntentUtils;
import mark.via.utils.SupportUtils;
import p016e.p017a.p018a.Downloader;
import p016e.p017a.p018a.Task;
import p016e.p017a.p018a.TaskViewHolder;
import p016e.p017a.p018a.TasksAdapter;
import timber.log.Timber;

/* renamed from: mark.via.m.b.h */
/* compiled from: DownloaderSlice */
public class DownloaderSlice extends Slice {

    /* renamed from: e */
    private Downloader f1440e = Downloader.m919e(this.f1460b);

    /* renamed from: f */
    private TasksAdapter f1441f;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.b.h$a */
    /* compiled from: DownloaderSlice */
    public class C0479a extends TasksAdapter {
        C0479a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        @Override // p016e.p017a.p018a.TasksAdapter
        /* renamed from: a */
        public void mo418a(TaskViewHolder fVar, Task eVar) {
            String b = eVar.mo407b();
            if (b.isEmpty()) {
                b = eVar.mo413g();
            }
            fVar.mo417b(R.id.RES_2131230789, b);
            fVar.mo416a(R.id.RES_2131230760).setVisibility(eVar.mo415i() ? 0 : 8);
            int e = eVar.mo410e();
            if (e == 2 || e == 4) {
                fVar.mo417b(R.id.RES_2131230797, String.format("%s/%s", BrowserUtils.m2091l(eVar.mo406a()), BrowserUtils.m2091l(eVar.mo412f())));
            } else if (e == 8) {
                fVar.mo417b(R.id.RES_2131230797, BrowserUtils.m2091l(eVar.mo412f()));
            } else if (e != 16) {
                fVar.mo417b(R.id.RES_2131230797, CompatUtils.m1336f(DownloaderSlice.this.f1460b, R.string.RES_2131558542));
            } else {
                fVar.mo417b(R.id.RES_2131230797, CompatUtils.m1336f(DownloaderSlice.this.f1460b, R.string.RES_2131558538));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.b.h$b */
    /* compiled from: DownloaderSlice */
    public class C0480b implements TasksAdapter.AbstractC0338a {

        /* renamed from: a */
        final /* synthetic */ TextView f1443a;

        /* renamed from: b */
        final /* synthetic */ ListView f1444b;

        C0480b(DownloaderSlice hVar, TextView textView, ListView listView) {
            this.f1443a = textView;
            this.f1444b = listView;
        }

        @Override // p016e.p017a.p018a.TasksAdapter.AbstractC0338a
        /* renamed from: a */
        public void mo432a(boolean z) {
            int i = 0;
            this.f1443a.setVisibility(z ? 0 : 8);
            ListView listView = this.f1444b;
            if (z) {
                i = 8;
            }
            listView.setVisibility(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.m.b.h$c */
    /* compiled from: DownloaderSlice */
    public class C0481c implements SwipeDismissListViewTouchListener.AbstractC0391e {
        C0481c() {
        }

        @Override // mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener.AbstractC0391e
        /* renamed from: a */
        public boolean mo703a(int i) {
            return DownloaderSlice.this.f1441f.getItem(i).mo414h();
        }

        @Override // mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener.AbstractC0391e
        /* renamed from: b */
        public void mo704b(ListView listView, int[] iArr) {
            for (int i : iArr) {
                DownloaderSlice.this.f1441f.mo427h(i);
            }
            DownloaderSlice.this.f1441f.notifyDataSetChanged();
        }
    }

    /* renamed from: mark.via.m.b.h$d */
    /* compiled from: DownloaderSlice */
    class C0482d implements AdapterView.OnItemLongClickListener {
        C0482d() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void mo1260b(int i, boolean z, View view, TaoDialog.C0384l lVar) {
            long h = DownloaderSlice.this.f1441f.mo427h(i);
            if (!z || lVar.f1090b) {
                DownloaderSlice.this.f1440e.mo382b(h);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void mo1261d(int i, AdapterView adapterView, View view, int i2, long j) {
            Task d = DownloaderSlice.this.f1441f.getItem(i);
            if (i2 == 0) {
                boolean h = d.mo414h();
                TaoDialog g = TaoDialog.m1134g(DownloaderSlice.this.f1460b);
                g.mo620L(R.string.RES_2131558414);
                g.mo644v(h ? R.string.RES_2131558619 : R.string.RES_2131558620);
                g.mo638p(h ? CompatUtils.m1336f(DownloaderSlice.this.f1460b, R.string.RES_2131558618) : null, false);
                g.mo614F(17039370, new C0473b(this, i, h));
                g.mo648z(17039360, null);
                g.mo622N();
            } else if (i2 == 1) {
                long k = DownloaderSlice.this.f1440e.mo389k(d);
                if (k == -1) {
                    QuickUtils.m1382n(DownloaderSlice.this.f1460b, R.string.RES_2131558538);
                } else {
                    DownloaderSlice.this.f1441f.mo431k(i, DownloaderSlice.this.f1440e.mo388j(k));
                }
            } else if (i2 == 2) {
                SupportUtils.m2196b(DownloaderSlice.this.f1460b, d.mo413g(), DownloaderSlice.this.f1459a.getResources().getString(R.string.RES_2131558750));
            } else if (i2 == 3 && AppUtils.m2065m(DownloaderSlice.this.f1460b, 2) && !IntentUtils.m2181h(DownloaderSlice.this.f1460b, d.mo408c())) {
                IntentUtils.m2179f(DownloaderSlice.this.f1460b, d.mo413g());
            }
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            TaoDialog g = TaoDialog.m1134g(DownloaderSlice.this.f1460b);
            g.mo643u(new String[]{DownloaderSlice.this.f1460b.getString(R.string.RES_2131558414), DownloaderSlice.this.f1460b.getString(R.string.RES_2131558436), DownloaderSlice.this.f1460b.getString(R.string.RES_2131558409), DownloaderSlice.this.f1460b.getString(R.string.RES_2131558441)}, new C0472a(this, i));
            g.mo624P(view);
            return true;
        }
    }

    public DownloaderSlice(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void mo1257k(AdapterView adapterView, View view, int i, long j) {
        int i2 = Build.VERSION.SDK_INT;
        if (AppUtils.m2065m(this.f1460b, 2)) {
            Task d = this.f1441f.getItem(i);
            if (d.mo414h()) {
                String c = d.mo408c();
                if (!TextUtils.isEmpty(c)) {
                    File file = new File(c);
                    if (!file.exists()) {
                        QuickUtils.m1382n(this.f1460b, R.string.RES_2131558556);
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    boolean z = true;
                    String substring = (!c.contains(".") || c.endsWith(".")) ? null : c.substring(c.lastIndexOf(".") + 1);
                    if (!"apk".equalsIgnoreCase(substring) || i2 < 26 || this.f1460b.getPackageManager().canRequestPackageInstalls()) {
                        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring);
                        if (mimeTypeFromExtension == null || mimeTypeFromExtension.isEmpty()) {
                            mimeTypeFromExtension = "file/*";
                        }
                        intent.setType(mimeTypeFromExtension);
                        if (i2 >= 24) {
                            Uri g = FileProvider.m1109g(view.getContext(), "mark.via.gp.provider", file);
                            Timber.m971a("uri: %s", g.toString());
                            intent.setData(g);
                            intent.addFlags(1);
                        } else {
                            intent.setData(Uri.fromFile(file));
                        }
                        try {
                            this.f1460b.startActivity(intent);
                        } catch (Exception unused) {
                            z = false;
                        }
                        if (!z) {
                            QuickUtils.m1382n(this.f1460b, R.string.RES_2131558645);
                            return;
                        }
                        return;
                    }
                    ((Activity) this.f1460b).startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:mark.via.gp")), 1);
                }
            }
        }
    }

    @Override // mark.via.p044m.p046b.Slice
    /* renamed from: d */
    public View mo1254d() {
        View inflate = this.f1459a.getLayoutInflater().inflate(R.layout.RES_2131361792, (ViewGroup) this.f1459a.findViewById(16908290), false);
        ListView listView = (ListView) inflate.findViewById(R.id.RES_2131230756);
        C0479a aVar = new C0479a(R.layout.RES_2131361812);
        this.f1441f = aVar;
        aVar.mo430j(new C0480b(this, (TextView) inflate.findViewById(R.id.RES_2131230788), listView));
        if (Build.VERSION.SDK_INT >= 12) {
            SwipeDismissListViewTouchListener aVar2 = new SwipeDismissListViewTouchListener(listView, new C0481c());
            listView.setOnTouchListener(aVar2);
            listView.setOnScrollListener(aVar2.mo695i());
        }
        listView.setAdapter((ListAdapter) this.f1441f);
        listView.setOnItemClickListener(new C0474c(this));
        listView.setOnItemLongClickListener(new C0482d());
        this.f1441f.mo428i(this.f1440e.mo386h(PreferenceManager.m1743M(this.f1460b).mo1199x()));
        return inflate;
    }

    @Override // mark.via.p044m.p046b.Slice
    /* renamed from: f */
    public void mo1255f() {
        mo1258l();
        this.f1461c = null;
        this.f1441f = null;
    }

    /* renamed from: i */
    public void mo1256i(long j) {
        TasksAdapter gVar = this.f1441f;
        if (gVar != null) {
            gVar.mo422g(this.f1440e.mo388j(j));
        } else {
            PreferenceManager.m1743M(this.f1460b).mo1131a(j);
        }
    }

    /* renamed from: l */
    public void mo1258l() {
        if (this.f1441f != null) {
            PreferenceManager.m1743M(this.f1460b).mo1118T0(this.f1441f.mo421e());
        }
    }

    /* renamed from: m */
    public void mo1259m(long j) {
        TasksAdapter gVar = this.f1441f;
        if (gVar != null && gVar.mo419c(j)) {
            this.f1441f.mo422g(this.f1440e.mo388j(j));
        }
    }
}
