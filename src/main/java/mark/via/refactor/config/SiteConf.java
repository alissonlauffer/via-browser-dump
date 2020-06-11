package mark.via.refactor.config;

import android.os.Parcel;
import android.os.Parcelable;

public class SiteConf implements Parcelable {
    public static final Parcelable.Creator<SiteConf> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private long f287a = -1;
    private boolean b = false;
    private byte c = 0;
    private int d = 0;
    private String e;
    private byte f = 0;
    private byte g = 0;
    private byte h = 0;
    private byte i = 0;

    class a implements Parcelable.Creator<SiteConf> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public SiteConf createFromParcel(Parcel parcel) {
            return new SiteConf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SiteConf[] newArray(int i) {
            return new SiteConf[i];
        }
    }

    public SiteConf() {
    }

    public void a(long j) {
        this.f287a = j;
    }

    public void b(byte b2) {
        this.c = b2;
    }

    public long c() {
        return this.f287a;
    }

    public byte d() {
        return this.h;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.d;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        String str;
        return !this.b && this.c == 0 && this.d == 0 && ((str = this.e) == null || str.isEmpty()) && this.f == 0 && this.g == 0 && this.h == 0 && this.i == 0;
    }

    public String toString() {
        return "Site Conf: ua: " + this.e + "; js: " + ((int) this.h) + ";";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(mark.via.h.c.a.a(this.b));
        parcel.writeByte(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeByte(this.f);
        parcel.writeByte(this.g);
        parcel.writeByte(this.h);
        parcel.writeByte(this.i);
    }

    public void a(boolean z) {
        this.b = z;
    }

    public byte b() {
        return this.c;
    }

    public void c(byte b2) {
        this.h = b2;
    }

    public void a(int i2) {
        this.d = i2;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(byte b2) {
        this.g = b2;
    }

    public byte a() {
        return this.g;
    }

    public SiteConf(Parcel parcel) {
        this.b = mark.via.h.c.a.a(parcel.readByte(), this.b);
        this.c = parcel.readByte();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readByte();
        this.g = parcel.readByte();
        this.h = parcel.readByte();
        this.i = parcel.readByte();
    }
}
