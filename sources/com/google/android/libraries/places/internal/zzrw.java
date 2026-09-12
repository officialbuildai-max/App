package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzrw {
    private static final zzpd zza;

    static {
        zzph zza2 = zzpi.zza();
        zza2.zzb('\"', "&quot;");
        zza2.zzb('\'', "&#39;");
        zza2.zzb('&', "&amp;");
        zza2.zzb('<', "&lt;");
        zza2.zzb('>', "&gt;");
        zza = zza2.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(String str) {
        return zza.zza(str);
    }
}
