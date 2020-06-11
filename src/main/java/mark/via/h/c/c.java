package mark.via.h.c;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelableUtil */
public class c {
    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static Parcel a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }
}
