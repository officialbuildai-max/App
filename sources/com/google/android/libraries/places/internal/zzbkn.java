package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbkn extends zzbbk {
    final /* synthetic */ Throwable zza;
    private final zzbbe zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkn(zzbma zzbmaVar, Throwable th2) {
        this.zza = th2;
        this.zzb = zzbbe.zza(zzbdo.zzo.zzg("Panic! This is a bug!").zzf(th2));
    }

    public final String toString() {
        zzmm zza = zzmn.zza(zzbkn.class);
        zza.zzd("panicPickResult", this.zzb);
        return zza.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbbk
    public final zzbbe zza(zzbbf zzbbfVar) {
        return this.zzb;
    }
}
