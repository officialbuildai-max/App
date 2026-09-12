package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzoi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] zzb(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            zza(objArr[i12], i12);
        }
        return objArr;
    }
}
