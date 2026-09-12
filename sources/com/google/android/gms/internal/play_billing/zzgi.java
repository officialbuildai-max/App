package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzgi {
    private static final zzgh zza;
    private static final zzgh zzb;

    static {
        zzgh zzghVar = null;
        try {
            zzghVar = (zzgh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzghVar;
        zzb = new zzgh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgh zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgh zzb() {
        return zzb;
    }
}
