package mark.via.b;

import android.content.Context;
import mark.via.gp.R;

/* compiled from: JS */
public class b {
    public static String a(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return "var d=document;var s=d.createElement('script');s.setAttribute('src', '" + str + "');d.head.appendChild(s);";
    }

    public static String a(Context context, String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return "javascript:url=unescape('" + str + "');var ls=document.getElementsByTagName('a');var el=null;for(var i=0,l=ls.length;i<l;i++){el=ls[i];if(unescape(el.href)==url||unescape(el.href)==(url+'/')){break}else{el=null}};if(!el){ls=document.getElementsByTagName('img');el=null;for(var i=0,l=ls.length;i<l;i++){el=ls[i];if(unescape(el.src)==url||unescape(el.src)==(url+'/')){break}else{el=null}}};if(el){var el2=el;var pl=0;while(true){if(el2.id||el2.className){break}else{el2=el2.parentNode;pl++}};if(el2){el=el2;while(true){el2=el2.parentNode;if(!el2||el2.childElementCount>1){break};if(el2.id||el2.className){el=el2}};el2=el;var elk=(el2.id?'#'+el2.id:'.'+el2.className);if(confirm('" + context.getResources().getString(R.string.cj) + "('+el2.tagName+elk+')')){el2.style.display='none';var ht=location.host;window.via.record(ht,elk)}}};";
    }
}
