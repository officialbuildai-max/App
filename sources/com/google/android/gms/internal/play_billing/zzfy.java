package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzfy {
    private static final zzfx zza;
    private static final zzfx zzb;

    static {
        zzfx zzfxVar = null;
        try {
            zzfxVar = (zzfx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzfxVar;
        zzb = new zzfx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfx zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfx zzb() {
        return zzb;
    }
}
