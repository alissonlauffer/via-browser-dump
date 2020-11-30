package mark.via.constants;

import android.content.Context;
import java.util.List;
import mark.via.gp.R;
import mark.via.utils.AppUtils;
import mark.via.utils.ChannelUtils;
import mark.via.utils.LocaleUtils;

/* renamed from: mark.via.d.b */
/* compiled from: JS */
public class JS {

    /* renamed from: a */
    private static String f1304a;

    /* renamed from: a */
    public static String m1587a() {
        StringBuilder sb = new StringBuilder();
        if (f1304a == null) {
            for (int i = 0; i < 8; i++) {
                sb.append(Integer.toHexString((int) ((Math.random() + 1.0d) * 65536.0d)).substring(1));
            }
            f1304a = sb.toString();
            sb.delete(0, sb.length());
        }
        List<String> a = LocaleUtils.m2184a();
        int indexOf = a.indexOf("zh");
        if (indexOf >= 0) {
            a.remove(indexOf);
            a.add(indexOf, "zh-TW");
            a.add(indexOf, "zh-CN");
        } else if (!ChannelUtils.m2108c()) {
            a.add("zh-CN");
            a.add("zh-TW");
        }
        String[] strArr = {"en", "ar", "az", "be", "bn", "cs", "de", "es", "fr", "hi", "hr", "hu", "in", "it", "ja", "ko", "it", "pl", "pt", "ru", "sl", "tr", "uk", "vi", "zh"};
        for (int i2 = 0; i2 < 25; i2++) {
            String str = strArr[i2];
            if (!a.contains(str)) {
                a.add(str);
            }
        }
        int size = a.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb.append(a.get(i3));
            if (i3 < size - 1) {
                sb.append(',');
            }
        }
        String sb2 = sb.toString();
        String str2 = !AppUtils.m2060h() ? "translate.google.com" : "translate.google.cn";
        String str3 = f1304a;
        return String.format("javascript:var s=document.createElement('script');s.type='text/javascript';s.text=\"%s\";var o=document.getElementsByTagName('head');if(o.length>0&&o[0]){o[0].appendChild(s)}", String.format("!function(){!function(){function e(){window.setTimeout(function(){window[t].showBanner(!0)},10)}function n(){return new google.translate.TranslateElement({autoDisplay:!1,floatPosition:0,multilanguagePage:!0,includedLanguages:'%s',pageLanguage:'auto'})}var t=(document.documentElement.lang,'TE_%s'),o='TECB_%s';if(window[t])e();else if(!window.google||!google.translate||!google.translate.TranslateElement){window[o]||(window[o]=function(){window[t]=n(),e()});var a=document.createElement('script');a.src='https://%s/translate_a/element.js?cb='+encodeURIComponent(o)+'&client=tee',document.getElementsByTagName('head')[0].appendChild(a)}}()}();", sb2, str3, str3, str2));
    }

    /* renamed from: b */
    public static String m1588b(Context context, String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return "javascript:url=unescape('" + str + "');var ls=document.getElementsByTagName('a');var el=null;for(var i=0,l=ls.length;i<l;i++){el=ls[i];if(unescape(el.href)==url||unescape(el.href)==(url+'/')){break}else{el=null}};if(!el){ls=document.getElementsByTagName('img');el=null;for(var i=0,l=ls.length;i<l;i++){el=ls[i];if(unescape(el.src)==url||unescape(el.src)==(url+'/')){break}else{el=null}}};if(el){var el2=el;var pl=0;while(true){if(el2.id||el2.className){break}else{el2=el2.parentNode;pl++}};if(el2){el=el2;while(true){el2=el2.parentNode;if(!el2||el2.childElementCount>1){break};if(el2.id||el2.className){el=el2}};el2=el;var elk=(el2.id?'#'+el2.id:'.'+el2.className);if(confirm('" + context.getResources().getString(R.string.RES_2131558526) + "('+el2.tagName+elk+')')){el2.style.display='none';var ht=location.host;window.via.record(ht,elk)}}};";
    }

    /* renamed from: c */
    public static String m1589c(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return "var d=document;var s=d.createElement('script');s.setAttribute('src', '" + str + "');d.head.appendChild(s);";
    }
}
