package com.google.android.gms.internal.play_billing;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes4.dex */
public final class zzcz {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzdd zzb;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.play_billing.zzdd] */
    static {
        zzde zzdeVar;
        int i11 = 0;
        while (true) {
            if (i11 >= 2) {
                zzdeVar = new zzde();
                break;
            }
            zzdeVar = null;
            try {
                zzdeVar = (zzdd) Class.forName(zza[i11]).asSubclass(zzdd.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzdeVar != null) {
                break;
            } else {
                i11++;
            }
        }
        zzb = zzdeVar;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i11) {
        zzda.zza(cls, "target");
        return zzb.zza(cls, 2);
    }
}
