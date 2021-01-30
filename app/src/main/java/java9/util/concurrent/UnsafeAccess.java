package java9.util.concurrent;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* renamed from: java9.util.concurrent.e */
/* compiled from: UnsafeAccess */
class UnsafeAccess {

    /* renamed from: a */
    static final Unsafe f1031a;

    static {
        Field field;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException unused) {
            try {
                field = Unsafe.class.getDeclaredField("THE_ONE");
            } catch (Exception e) {
                throw new Error(e);
            }
        }
        field.setAccessible(true);
        f1031a = (Unsafe) field.get(null);
    }
}
