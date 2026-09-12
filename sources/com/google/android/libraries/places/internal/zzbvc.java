package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public abstract class zzbvc extends zzbbd {
    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("delegate", zzf());
        return zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final zzbbj zza(zzbba zzbbaVar) {
        return zzf().zza(zzbbaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final zzbdw zzb() {
        return zzf().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final ScheduledExecutorService zzc() {
        return zzf().zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final void zzd() {
        zzf().zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public void zze(zzaze zzazeVar, zzbbk zzbbkVar) {
        throw null;
    }

    protected abstract zzbbd zzf();
}
