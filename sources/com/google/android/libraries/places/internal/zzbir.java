package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
class zzbir extends zzbcv {
    private final zzbcv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbir(zzbcv zzbcvVar) {
        this.zza = zzbcvVar;
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", this.zza);
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final String zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzb() {
        this.zza.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public void zzc() {
        this.zza.zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public void zzd(zzbcr zzbcrVar) {
        this.zza.zzd(zzbcrVar);
    }
}
