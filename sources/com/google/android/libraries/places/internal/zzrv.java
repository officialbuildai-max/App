package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzrv implements zzru {
    @Override // com.google.android.libraries.places.internal.zzru
    public final StackTraceElement zza(Class cls, int i11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = cls.getName();
        int i12 = 3;
        boolean z10 = false;
        while (true) {
            if (i12 >= stackTrace.length) {
                i12 = -1;
                break;
            }
            if (stackTrace[i12].getClassName().equals(name)) {
                z10 = true;
            } else {
                if (z10) {
                    break;
                }
                z10 = false;
            }
            i12++;
        }
        if (i12 != -1) {
            return stackTrace[i12];
        }
        return null;
    }
}
