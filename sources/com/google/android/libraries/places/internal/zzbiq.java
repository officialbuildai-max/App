package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
class zzbiq extends zzbbr {
    private final zzbbr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbiq(zzbbr zzbbrVar) {
        this.zza = zzbbrVar;
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", this.zza);
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final zzayo zza(zzbcl zzbclVar, zzayj zzayjVar) {
        return this.zza.zza(zzbclVar, zzayjVar);
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final String zzb() {
        return this.zza.zzb();
    }
}
