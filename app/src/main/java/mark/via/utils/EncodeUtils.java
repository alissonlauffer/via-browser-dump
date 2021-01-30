package mark.via.utils;

import java.security.MessageDigest;

/* renamed from: mark.via.n.j */
/* compiled from: EncodeUtils */
public class EncodeUtils {
    /* renamed from: a */
    public static String m2139a(String str) {
        boolean z;
        byte[] bArr;
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
            z = false;
        }
        if (!z || bArr == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }
}
