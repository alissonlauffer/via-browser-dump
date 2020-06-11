package mark.via.utils;

import java.util.Arrays;

/* renamed from: mark.via.n.g */
/* compiled from: CharUtils */
public class CharUtils {
    /* renamed from: a */
    public static boolean m2109a(int i) {
        return (i >= 97 && i <= 122) || (i >= 65 && i <= 90);
    }

    /* renamed from: b */
    public static boolean m2110b(int i) {
        return i >= 48 && i <= 57;
    }

    /* renamed from: c */
    public static boolean m2111c(int i) {
        return m2110b(i) || (i >= 97 && i <= 102) || (i >= 65 && i <= 70);
    }

    /* renamed from: d */
    public static boolean m2112d(String str, int i) {
        return m2113e(str, i, null);
    }

    /* renamed from: e */
    public static boolean m2113e(String str, int i, int[] iArr) {
        int length;
        if (str == null || (length = str.length()) <= 0 || i == 0) {
            return false;
        }
        if (iArr != null && iArr.length > 1) {
            Arrays.sort(iArr);
        }
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = Character.codePointAt(str, i2);
            if (((i & 1) == 0 || !m2109a(codePointAt)) && (((i & 2) == 0 || !m2110b(codePointAt)) && (((i & 4) == 0 || !m2111c(codePointAt)) && (iArr == null || Arrays.binarySearch(iArr, codePointAt) < 0)))) {
                return false;
            }
            i2 += Character.charCount(codePointAt);
        }
        return true;
    }
}
