package mark.via.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import mark.lib.frogsupport.FileProvider;
import mark.lib.frogsupport.toast.FrogToast;
import mark.lib.frogsupport.toast.OnFrogToastListener;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.gp.R;
import timber.log.Timber;

/* renamed from: mark.via.n.o */
/* compiled from: IntentUtils */
public class IntentUtils {

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.n.o$a */
    /* compiled from: IntentUtils */
    public class C0500a extends OnFrogToastListener {

        /* renamed from: a */
        final /* synthetic */ Activity f1532a;

        /* renamed from: b */
        final /* synthetic */ Intent f1533b;

        C0500a(Activity activity, Intent intent) {
            this.f1532a = activity;
            this.f1533b = intent;
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            try {
                this.f1532a.startActivity(this.f1533b);
            } catch (Exception unused) {
                QuickUtils.m1382n(this.f1532a, R.string.iu);
            }
        }
    }

    static {
        Pattern.compile("(?i)((?:http|https|file):\\\\/\\\\/|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
    }

    /* renamed from: a */
    public static Intent m2174a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        intent.setType("message/rfc822");
        return intent;
    }

    /* renamed from: b */
    public static void m2175b(Activity activity, String str) {
        String str2;
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            if (Build.VERSION.SDK_INT >= 15) {
                parseUri.setSelector(null);
            }
            ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(parseUri, 0);
            if (resolveActivity != null && (str2 = resolveActivity.activityInfo.packageName) != null && !str2.equals(activity.getPackageName())) {
                try {
                    activity.startActivity(Intent.createChooser(parseUri, activity.getResources().getString(R.string.fy)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (URISyntaxException unused) {
        }
    }

    /* renamed from: c */
    public static void m2176c(Activity activity, String str, String str2) {
        m2177d(activity, str, str2, null);
    }

    /* renamed from: d */
    public static void m2177d(Activity activity, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "video/*");
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra("android.intent.extra.TITLE", str2);
                    intent.putExtra("title", str2);
                }
                if (TextUtils.isEmpty(str3)) {
                    activity.startActivity(intent);
                } else {
                    activity.startActivity(Intent.createChooser(intent, str3));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    public static void m2178e(Activity activity, String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            if (Build.VERSION.SDK_INT >= 15) {
                parseUri.setSelector(null);
            }
            if (parseUri.resolveActivity(activity.getPackageManager()) != null) {
                new FrogToast(activity, (int) R.string.fk, 17039370, new C0500a(activity, parseUri)).mo773m();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public static void m2179f(Context context, String str) {
        m2180g(context, null, str);
    }

    /* renamed from: g */
    public static void m2180g(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.TITLE", str);
            intent.putExtra("title", str);
        }
        intent.putExtra("android.intent.extra.TEXT", str2);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.ae)));
    }

    /* renamed from: h */
    public static boolean m2181h(Context context, String str) {
        Uri uri;
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (file.exists()) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.m1109g(context, "mark.via.gp.provider", file);
                    intent.addFlags(3);
                } else {
                    uri = Uri.fromFile(file);
                }
                Timber.m971a("Share %s", uri);
                intent.setType(MimeTypeUtils.m2186a(str));
                intent.putExtra("android.intent.extra.STREAM", uri);
                Intent createChooser = Intent.createChooser(intent, context.getString(R.string.ae));
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(createChooser, 65536)) {
                    context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 1);
                }
                try {
                    context.startActivity(createChooser);
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }
}
