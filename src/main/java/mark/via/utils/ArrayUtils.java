package mark.via.utils;

import java.util.Arrays;

/* renamed from: mark.via.n.d */
/* compiled from: ArrayUtils */
public class ArrayUtils {
    /* renamed from: a */
    public static <T> T[] m2069a(T[] tArr, T[] tArr2) {
        if (tArr == null) {
            return tArr2;
        }
        if (tArr2 == null) {
            return tArr;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }
}
