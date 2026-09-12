package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
abstract class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] a(Object[] objArr, int i11) {
        if (objArr.length < i11) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i11);
        }
        if (objArr.length > i11) {
            objArr[i11] = null;
        }
        return objArr;
    }
}
