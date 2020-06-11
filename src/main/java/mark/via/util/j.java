package mark.via.util;

import a.a.b.o.c;
import a.a.b.p.e;
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
import mark.via.gp.R;
import mark.via.provider.FileProvider;

/* compiled from: IntentUtils */
public class j {

    /* compiled from: IntentUtils */
    class a extends c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f488a;
        final /* synthetic */ Intent b;

        a(Activity activity, Intent intent) {
            this.f488a = activity;
            this.b = intent;
        }

        @Override // a.a.b.o.c
        public void a() {
            try {
                this.f488a.startActivity(this.b);
            } catch (Exception unused) {
                e.a(this.f488a, (int) R.string.i9);
            }
        }
    }

    static {
        Pattern.compile("(?i)((?:http|https|file):\\\\/\\\\/|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
    }

    public static void a(Activity activity, String str) {
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
                    activity.startActivity(Intent.createChooser(parseUri, activity.getResources().getString(R.string.fe)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (URISyntaxException unused) {
        }
    }

    public static void b(Activity activity, String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            if (Build.VERSION.SDK_INT >= 15) {
                parseUri.setSelector(null);
            }
            if (parseUri.resolveActivity(activity.getPackageManager()) != null) {
                new a.a.b.o.a(activity, (int) R.string.f1, 17039370, new a(activity, parseUri)).h();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(Context context, String str) {
        Uri uri;
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (file.exists()) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.a(context, "mark.via.gp.provider", file);
                    intent.addFlags(3);
                } else {
                    uri = Uri.fromFile(file);
                }
                intent.setType(m.a(str));
                intent.putExtra("android.intent.extra.STREAM", uri);
                try {
                    context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.ae)));
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.TITLE", str);
            intent.putExtra("title", str);
        }
        intent.putExtra("android.intent.extra.TEXT", str2);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.ae)));
    }

    public static void a(Context context, String str) {
        a(context, (String) null, str);
    }

    public static Intent a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        intent.setType("message/rfc822");
        return intent;
    }

    public static void a(Activity activity, String str, String str2) {
        a(activity, str, str2, (String) null);
    }

    public static void a(Activity activity, String str, String str2, String str3) {
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
}
