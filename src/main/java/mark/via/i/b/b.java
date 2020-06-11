package mark.via.i.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import mark.via.f.a;
import mark.via.gp.R;
import mark.via.util.c;
import mark.via.util.r;

/* compiled from: WebPage */
public class b {
    public static String a() {
        return "function showButton(){document.getElementById(\"search_submit\").style.display=\"block\"}function hideButton(){var a=document.getElementById(\"search_input\").value;\"\"==a&&(document.getElementById(\"search_submit\").style.display=\"none\")}function search(){var a=document.getElementById(\"search_input\").value;return\"\"!=a&&(window.via.searchText(a),document.getElementById(\"search_input\").value=\"\"),!1}";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public static String a(Context context, int i) {
        String str;
        String str2;
        String str3;
        a b = a.b(context);
        boolean z = !r.a(b.e0());
        boolean a2 = b.a(context);
        boolean z2 = !b.w().isEmpty();
        String str4 = (a2 || z) ? "#fafafa" : "#1b1b1b";
        String str5 = (a2 || z) ? "#d5d5d5" : "#2b2b2b";
        String str6 = (a2 || z) ? "#e9e9e9" : "#313131";
        if (a2) {
            str = "#000000";
        } else {
            str = r.b(b.e0());
        }
        String str7 = "color: " + str4 + ";";
        String str8 = "color: " + str5 + ";";
        String str9 = "color: " + str6 + ";";
        StringBuilder sb = new StringBuilder();
        sb.append("background-color: ");
        sb.append(str);
        sb.append(";");
        if (z2) {
            str2 = "background: " + str + " url(\"" + b.w() + "\") no-repeat fixed center; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size:cover;";
        } else {
            str2 = "";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("background-color: rgba(0, 0, 0, ");
        sb3.append(z2 ? String.valueOf(Math.min(((float) b.y()) / 100.0f, 0.8f)) : "0");
        sb3.append(");");
        String sb4 = sb3.toString();
        String str10 = (a2 || z) ? "rgba(255, 255, 255, 0.1)" : "rgba(0, 0, 0, 0.1)";
        String str11 = (z || a2) ? "rgba(0, 0, 0, 0.6)" : "rgba(255, 255, 255, 0.6)";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("* {padding:0;margin:0;box-sizing:border-box;}");
        sb5.append("html{height:100%; max-height:100%;-webkit-tap-highlight-color:");
        sb5.append(str10);
        sb5.append(";-webkit-focus-ring-color: rgba(0, 0, 0, 0); -webkit-touch-callout: none; -webkit-user-select: none; -khtml-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;}");
        sb5.append("body{min-height:100%;");
        sb5.append(sb2);
        sb5.append("max-width:100%; width: 600px;margin: auto;text-align: center;}");
        sb5.append(".frosted-glass{");
        sb5.append(sb4);
        sb5.append("position:fixed; left:0; top:0; width: 100%; height: 100%;z-index:-999;}");
        if (mark.via.util.a.b()) {
            sb5.append("html{direction:rtl;}");
        }
        if (i != 1) {
            int i2 = 4;
            if (i == 4) {
                sb5.append("#search_input{height:42px;width:95%;outline:none;border:none; ");
                sb5.append("font-size: 15px;");
                sb5.append("background-color:transparent;");
                sb5.append("}");
                sb5.append(".search_part{margin-bottom:20px;}");
                sb5.append("span {display: block;overflow: hidden;padding-left:5px;vertical-align:middle;}");
                sb5.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
                sb5.append(".hint {");
                sb5.append(str8);
                sb5.append("font-size: 15px;");
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append(" padding: 50px 5px; text-align: center; margin: auto;}");
                sb5.append(".logo{");
                sb5.append("font-size: 28px;");
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append(" text-decoration:none; ");
                sb5.append(str7);
                sb5.append("}");
                sb5.append(".search.icon {color: ");
                sb5.append((b.z() != 2 || !z) ? "#666666" : "white");
                sb5.append("; width: 12px; height: 12px; border: solid 2px currentColor; border-radius: 100%; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); text-align: center; margin: auto; } .search.icon:before {content: ''; position: absolute; top: 10px; left: 3px; height: 5px; width: 2px; background-color: currentColor; }");
                sb5.append("img.smaller{");
                if (b.O() != 0) {
                    str3 = "width: 80px; max-width:80px; border-radius: 50%; min-width:80px;";
                } else {
                    str3 = "";
                }
                sb5.append(str3);
                sb5.append("height: 80px;min-height:80px; object-fit: cover; max-height:80px;}");
                sb5.append("#content{position: absolute; top: ");
                sb5.append(b.t() ? "15px" : "28%");
                sb5.append("; max-width: 600px;width: 100%;}");
                sb5.append(".box {border: 0; position:relative; display: inline-block;text-align: center;}");
                sb5.append(".url {line-height: 24px;}");
                sb5.append(".search_bar{display:table; vertical-align:middle;width:90%;height:42px;max-width:600px;margin:0 auto; margin-top: 15px;}");
                sb5.append("#search_submit{display: none;outline:none;height:42px; width: 42px; float:right;");
                sb5.append("font-size: 15px;");
                sb5.append(" font-weight:bold; border:none; background-color:transparent; padding: 0 10px 0 10px;}");
                sb5.append("#bookmark_part {text-align: center; width:90%; max-width:600px; background-color: transparent; margin: 0 auto; padding: 0; border-radius: 0px;}");
                sb5.append(".title {margin:2px auto;");
                sb5.append("white-space: nowrap; overflow: hidden;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append("}");
                sb5.append(".url {height: 20px;line-height: 20px; margin: 0 auto; ");
                sb5.append("white-space: nowrap; overflow: hidden;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append(str8);
                sb5.append("font-size: 10px;");
                sb5.append("}");
                sb5.append("#box_container{text-align:left;margin:0 auto;font-size: 0;}");
                int i3 = 72;
                int z3 = b.z();
                int i4 = 1;
                if (z3 != 1) {
                    if (z3 != 2) {
                        sb5.append(".search_bar{border:1px solid ");
                        sb5.append(str10);
                        sb5.append("; border-radius: 100px; background: white; box-shadow: 0 0 2px ");
                        sb5.append(str11);
                        sb5.append(";}");
                        sb5.append("#search_input{color: #6c6c6c;}");
                        sb5.append("#search_submit{color: #666666;}");
                        sb5.append(".box {margin: 0;width: 72px;}");
                        sb5.append(".title {border-radius: 100%; color: #ffffff; width: 3.4em; line-height: 3.4em; height: 3.4em; ");
                        sb5.append("font-size: 15px;");
                        sb5.append("}");
                        sb5.append(".url {width: 56px;}");
                    } else {
                        sb5.append(".search_bar{border-bottom:1px solid ");
                        sb5.append(str10);
                        sb5.append("; background: transparent;}");
                        sb5.append("#search_input{ ");
                        sb5.append(str7);
                        sb5.append("}");
                        sb5.append("#search_submit{ ");
                        sb5.append(str7);
                        sb5.append("}");
                        sb5.append(".box {margin: 0;width: 72px;}");
                        sb5.append(".title {");
                        sb5.append(str7);
                        sb5.append("width: 3.4em; line-height: 3.4em; height: 3.4em; ");
                        sb5.append("font-size: 15px;");
                        sb5.append("}");
                        sb5.append(".url {width: 56px;}");
                    }
                    i2 = 6;
                } else {
                    sb5.append(".search_bar{border: 1px solid ");
                    sb5.append(str10);
                    sb5.append("; background-color: rgba(255, 255, 255, 0.8); border-radius: 2px}");
                    sb5.append("#search_input{color:#666666;}");
                    sb5.append("#search_submit{color: #666666;}");
                    sb5.append(".box {margin: 3px 6px;width: 78px;}");
                    sb5.append(".title {color: #ffffff; width:78px; line-height: 3.8em; height: 3.8em; padding: 0 4px;");
                    sb5.append("font-size: 14px;");
                    sb5.append(" border-radius: 5px;}");
                    sb5.append(".url {width: 80px;display: none}");
                    i3 = 90;
                }
                while (i4 <= i2) {
                    sb5.append("@media only screen and (min-width:");
                    int i5 = i4 + 1;
                    sb5.append(i3 * i5);
                    sb5.append("px){#box_container{width:");
                    sb5.append(i4 * i3);
                    sb5.append("px}}");
                    i4 = i5;
                }
                if (mark.via.util.a.b()) {
                    sb5.append("#box_container{text-align:right;}#search_submit{float:left;}");
                }
            } else if (i == 5) {
                sb5.append("div{");
                sb5.append(str7);
                sb5.append("max-width:800px; padding-left:5%; padding-right:5%; text-align:left;}");
                sb5.append("div>h1{");
                sb5.append("font-size: 20px;");
                sb5.append(" padding-top:55px; padding-bottom:45px; text-align: left; }");
                sb5.append("div>p{ text-align: left; line-height: 1.8em; text-indent:2em;");
                sb5.append("font-size: 15px;");
                sb5.append("}");
                sb5.append("a{color: #6f8de1; ");
                sb5.append("font-size: 15px;");
                sb5.append(" line-height: 1.8em; text-decoration:none; }");
                if (mark.via.util.a.b()) {
                    sb5.append("div,h1,p,div>h1,div>p{text-align:right;}");
                }
            } else if (i == 6) {
                sb5.append(".box {margin: 12px 0; text-align: left; vertical-align:middle;position:relative;display: block;padding-top:10px; padding-bottom:10px; padding-left:10px; padding-right:10px;}");
                sb5.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
                sb5.append("span, .url, .box {word-break: break-all;}");
                sb5.append(".block{opacity:0.5;}.tag{background:#cd8282;padding:0 8px;margin:0 4px;color:white;font-size:12px;}.res{background:#5c91cb;}");
                sb5.append(".title {");
                sb5.append(str8);
                sb5.append("font-size: 15px;");
                sb5.append(" padding: 4px 0px;}");
                sb5.append(".url {line-height: 1.2em; max-height: 4.8em;");
                sb5.append("font-size: 15px;");
                sb5.append(str7);
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append("}");
                sb5.append(".hint {line-height: 1.8em; ");
                sb5.append(str8);
                sb5.append("font-size: 15px;");
                sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
                sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
                sb5.append(" padding: 50px 5px; text-align: center; margin: auto;}");
                sb5.append("#filter-box{padding:10px}#filter{border: 1px solid ");
                sb5.append(str10);
                sb5.append(";border-radius:2px;-webkit-appearance:none;-moz-appearance:none;appearance:none;background:transparent;padding:5px;width:100%;");
                sb5.append("font-size: 15px;");
                sb5.append(str7);
                sb5.append("}");
                if (mark.via.util.a.b()) {
                    sb5.append(".box{text-align:right;}");
                }
            }
        } else {
            sb5.append("#content {text-align:left;}");
            sb5.append(".box {vertical-align:middle;position:relative;display: block;padding: 20px 14px;border-bottom: 0px solid ");
            sb5.append(str10);
            sb5.append("}");
            sb5.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
            sb5.append(".title {padding-left: 28px;");
            sb5.append(str7);
            sb5.append("font-size: 15px;");
            sb5.append("white-space: nowrap; overflow: hidden;");
            sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
            sb5.append("margin:auto;}");
            sb5.append(".url {display: none;}");
            sb5.append(".hint {");
            sb5.append(str8);
            sb5.append("font-size: 15px;");
            sb5.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
            sb5.append("text-overflow: ellipsis;-o-text-overflow: ellipsis;-ms-text-overflow: ellipsis;");
            sb5.append("padding: 50px 5px;text-align: center;margin: auto; line-height: 1.8em;}");
            sb5.append(".tag.icon {");
            sb5.append(str9);
            sb5.append(" position: absolute; margin-left: 3px; margin-top: 5px; width: 7px; height: 7px; border-radius: 1px 1px 1px 0; border-left: solid 1px currentColor; border-top: solid 1px currentColor; } .tag.icon:before {content: ''; position: absolute; left: 1px; top: 1px; width: 9px; height: 10px; border-radius: 1px; border-left: solid 1px currentColor; border-right: solid 1px currentColor; border-bottom: solid 1px currentColor; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); } .tag.icon:after {content: ''; position: absolute; left: 3px; top: 3px; width: 2px; height: 2px; border-radius: 50%; background-color: currentColor; }");
            sb5.append(".icon_handle {width:50px;height:100%; /*position:absolute;top:0;left:0;*/ z-index: 999; }");
            sb5.append(".bookmark.icon {");
            sb5.append(str9);
            sb5.append(" position: absolute; margin-left: 5px; margin-top: 5px; width: 10px; height: 15px; border-radius: 1px 1px 0 0; border-top: solid 1px currentColor; border-left: solid 1px currentColor; border-right: solid 1px currentColor; } .bookmark.icon:before {content: ''; position: absolute; top: 10px; left: 0px; width: 6px; height: 6px; border-top: solid 1px currentColor; border-left: solid 1px currentColor; -webkit-transform: rotate(45deg); transform: rotate(45deg); }");
            sb5.append(".clock.icon {");
            sb5.append(str9);
            sb5.append(" position: absolute; margin-left: 1px; margin-top: 5px; width: 15px; height: 15px; border: solid 1px currentColor; border-radius: 8px; } .clock.icon:before {content: ''; position: absolute; top: 7px; left: 7px; width: 5px; height: 1px; background-color: currentColor; -webkit-transform-origin: 0% 0%; transform-origin: 0% 0%; } .clock.icon:after {content: ''; position: absolute; top: 2px; left: 7px; width: 1px; height: 6px; background-color: currentColor; -webkit-transform-origin: 0% 0%; transform-origin: 0% 0%; }");
            sb5.append(".btn {padding: 12px 20px; color: #ffffff; border-radius: 2px; border: 0; outline: none;");
            sb5.append("font-size: 15px;");
            sb5.append("; margin: 10px;}");
            if (mark.via.util.a.b()) {
                sb5.append("#content {text-align: right;}.title{padding-left:0px;padding-right: 28px;}");
            }
        }
        return sb5.toString();
    }

    public static String b(String str) {
        return "<script type=\"text/javascript\">" + str + "</script>";
    }

    public static String c(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head><meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no, minimal-ui\">");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "<title>" + str + "</title>";
        }
        sb.append(str2);
        sb.append("</head>");
        return sb.toString();
    }

    private static String d(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return "try{" + str + "}catch(err){console.log(err)}";
    }

    public static String b(Context context) {
        a b = a.b(context);
        if (b.A().isEmpty()) {
            return "<img class=\"smaller\" src=\"file:///android_asset/logo.png\"></img>";
        }
        return b.A();
    }

    public static String c(Context context) {
        return "<div class=\"search_part\"><a class=\"logo\" href=\"folder://\" title=\"" + context.getString(R.string.g) + "\">" + b(context) + "</a><form onsubmit=\"return search()\" class=\"search_bar\" title=\"" + context.getString(R.string.gj) + "\"><button onclick=\"search()\" id=\"search_submit\" value=\"\" aria-label=\"" + context.getString(R.string.cc) + "\"><div class=\"search icon\"></div></button><span><input class=\"search\" onfocus=\"showButton()\" onblur=\"hideButton()\" type=\"text\" value=\"\" autocomplete=\"off\" id=\"search_input\" title=\"" + context.getString(R.string.gj) + "\"></span></form></div>";
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("<style>");
        for (String str : strArr) {
            sb.append(str);
        }
        sb.append("</style>");
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) {
        String str4 = "";
        String replaceAll = str2.replaceAll("<.*?>", str4);
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"box\">");
        if (!TextUtils.isEmpty(str3)) {
            str4 = "<div class=\"icon_handle\"><div class=\"" + str3 + " icon\"></div></div>";
        }
        sb.append(str4);
        sb.append("<a href=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(replaceAll);
        sb.append("\"></a><p class=\"title\">");
        sb.append(replaceAll);
        sb.append("</p></div>");
        return sb.toString();
    }

    public static String a(String str, String str2, boolean z, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"box");
        String str4 = "";
        sb.append(z ? " block" : str4);
        sb.append("\"><a href=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(str);
        sb.append("\"></a><p class=\"title\">");
        sb.append(str3);
        sb.append("<font class=\"tag\">");
        sb.append(z ? "block" : "load");
        sb.append("</font>");
        if (!str2.isEmpty()) {
            str4 = "<font class=\"res tag\">" + str2 + "</font>";
        }
        sb.append(str4);
        sb.append("</p><p class=\"url\">");
        sb.append(str);
        sb.append("</p></div>");
        return sb.toString();
    }

    public static String a(String str, String str2, boolean z) {
        String str3;
        String str4 = "";
        String replaceAll = str2.replaceAll("<.*?>", str4);
        String a2 = r.a(str);
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"box\"><a href=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(replaceAll);
        sb.append("\"></a><p class=\"title\"");
        if (z) {
            str3 = " style=\"background:" + a2 + "\"";
        } else {
            str3 = str4;
        }
        sb.append(str3);
        sb.append(">");
        if (replaceAll.trim().length() >= 1) {
            str4 = replaceAll.trim().substring(0, 1);
        }
        sb.append(str4);
        sb.append("</p><p class=\"url\">");
        sb.append(replaceAll);
        sb.append("</p></div>");
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.b.a(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      mark.via.util.b.a(android.content.Context, java.lang.String):int
      mark.via.util.b.a(int, java.lang.String):java.lang.String
      mark.via.util.b.a(android.content.Intent, java.lang.String):java.lang.String
      mark.via.util.b.a(android.webkit.WebView, int):void
      mark.via.util.b.a(java.lang.String, boolean):java.lang.String */
    public static String a(String str, String str2) {
        String replaceAll = str2.replaceAll("<.*?>", "");
        return "<div class=\"box\"><a href=\"" + str + "\" title=\"" + replaceAll + "\"></a><p class=\"title\" style=\"background:" + r.a(str) + ";\">" + replaceAll + "</p><p class=\"url\">" + mark.via.util.b.a(str, true) + "</p></div>";
    }

    public static String a(int i, int i2) {
        int i3;
        String str;
        int i4;
        String str2;
        if (i2 >= 55) {
            i3 = (ViewConfiguration.getLongPressTimeout() / 9) * 2;
            i4 = 150;
            str = "s2.js";
        } else {
            i3 = (ViewConfiguration.getLongPressTimeout() / 9) * 5;
            i4 = 0;
            str = "s1.js";
        }
        String str3 = "<script src=\"file:///android_asset/" + str + "\"></script>";
        if (i == 2) {
            str2 = ("var sortable1 = Sortable.create(bookmark_tags, {disabled: false, delay: 0, animation: " + i4 + ", handle: '.icon_handle', onStart: function (evt) {var itemEl = evt.item; itemEl.style.opacity = '0.3';}, onEnd: function (evt) {var itemEl = evt.item; itemEl.style.opacity = '1.0'; evt.to; evt.from; evt.oldIndex; evt.newIndex; window.via.changeBookmarkOrder(evt.oldIndex, evt.newIndex); }, });") + "var sortable = Sortable.create(bookmark_tags, {disabled: false, delay: " + i3 + ", animation: " + i4 + ", handle: '.box', onStart: function (evt) {var itemEl = evt.item; itemEl.style.opacity = '0.3';}, onEnd: function (evt) {var itemEl = evt.item; itemEl.style.opacity = '1.0'; evt.to; evt.from; evt.oldIndex; evt.newIndex; window.via.changeBookmarkOrder(evt.oldIndex, evt.newIndex); }, });";
        } else if (i == 1) {
            str2 = "var sortable = Sortable.create(box_container, {disabled: false, delay: " + i3 + ", animation: " + i4 + ", handle: '.box', onStart: function (evt) {var itemEl = evt.item; itemEl.style.opacity = '0.3';}, onEnd: function (evt) {var itemEl = evt.item; itemEl.style.opacity = '1.0'; evt.to; evt.from; evt.oldIndex; evt.newIndex; window.via.changeFavoriteOrder(evt.oldIndex, evt.newIndex); }, });";
        } else {
            str2 = "";
        }
        return str3 + b(d(str2));
    }

    public static String a(Context context) {
        String e = a.a.b.p.a.e(context, R.string.cr);
        String str = "";
        if (mark.via.util.a.c()) {
            e = "我们利用有限的业余时间设计了 Via，虽然它并不那么美好，但正努力前行。\n如果你喜欢我们的作品，可以捐赠来支持我们" + str + "。\n\n所有的捐赠都将用来：提升我们的环境配置以及积极性。\n\n支付宝: 2376688759@qq.com\nPayPal: wiar1824@gmail.com";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>");
        sb.append(a.a.b.p.a.e(context, R.string.di));
        sb.append("</h1><p>");
        sb.append(mark.via.util.a.a().replace("\n", "</p><p>"));
        sb.append("</p><h1>");
        sb.append(a.a.b.p.a.e(context, R.string.bs));
        sb.append("</h1><p><a href=\"");
        sb.append("http://viayoo.com/");
        sb.append("\">");
        sb.append(a.a.b.p.a.e(context, R.string.fb));
        sb.append("</a></p>");
        sb.append(mark.via.util.a.c() ? "<p><a href=\"http://viayoo.com/contact/qqgroup/\">官方鹅群</a></p>" : str);
        sb.append("<p><a href=\"https://t.me/viatg\">Telegram</a></p><p><a href=\"https://github.com/tuyafeng/Via\">");
        sb.append(a.a.b.p.a.e(context, R.string.dm));
        sb.append("</a></p>");
        if (!c.b()) {
            str = "<h1>" + a.a.b.p.a.e(context, R.string.cq) + "</h1><p>" + e.replace("\n", "</p><p>") + "</p>";
        }
        sb.append(str);
        sb.append("<br><br><br>");
        return sb.toString();
    }

    public static String a(String str) {
        return "<div class='hint'>" + str.replace("\n", "<br>") + "</div>";
    }
}
