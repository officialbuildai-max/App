package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzati {
    private static final zzatg zza = new zzath();
    private static final zzatg zzb;

    static {
        zzatg zzatgVar = null;
        try {
            zzatgVar = (zzatg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzatgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzatg zza() {
        zzatg zzatgVar = zzb;
        if (zzatgVar != null) {
            return zzatgVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzatg zzb() {
        return zza;
    }
}
