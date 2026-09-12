package gf;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class e {
    public static int a(Object... objArr) {
        int hashCode;
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        int i11 = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                if (obj instanceof Number) {
                    hashCode = obj.hashCode();
                } else if (obj instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) obj);
                } else if (obj instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) obj);
                } else if (obj instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) obj);
                } else if (obj instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) obj);
                } else if (obj instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) obj);
                } else if (obj instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) obj);
                } else if (obj instanceof Object[]) {
                    hashCode = Arrays.hashCode((Object[]) obj);
                } else if (obj.getClass().isArray()) {
                    for (int i12 = 0; i12 < Array.getLength(obj); i12++) {
                        i11 += a(Array.get(obj, i12));
                    }
                } else {
                    hashCode = obj.hashCode();
                }
                i11 += hashCode;
            }
        }
        return i11;
    }
}
