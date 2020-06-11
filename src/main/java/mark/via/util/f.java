package mark.via.util;

import java.security.MessageDigest;

/* compiled from: EncodeUtils */
public class f {
    public static String a(String str) {
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
            byte b2 = b & 255;
            if (b2 < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b2));
        }
        return sb.toString();
    }
}
