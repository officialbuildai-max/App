package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzfs {
    private static final zzfr zza;
    private static final zzfr zzb;

    static {
        zzfr zzfrVar = null;
        try {
            zzfrVar = (zzfr) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzfrVar;
        zzb = new zzfr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfr zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfr zzb() {
        return zzb;
    }
}
