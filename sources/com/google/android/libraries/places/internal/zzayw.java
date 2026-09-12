package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzayw {
    private final zzayj zza;
    private final int zzb;
    private final boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayw(zzayj zzayjVar, int i11, boolean z10) {
        zzmt.zzc(zzayjVar, "callOptions");
        this.zza = zzayjVar;
        this.zzb = i11;
        this.zzc = z10;
    }

    public static zzayv zza() {
        return new zzayv();
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("callOptions", this.zza);
        zzb.zzb("previousAttempts", this.zzb);
        zzb.zze("isTransparentRetry", this.zzc);
        return zzb.toString();
    }
}
