package com.google.android.libraries.places.internal;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjq implements Runnable {
    final /* synthetic */ zzbkd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjq(zzbkd zzbkdVar) {
        this.zza = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaym zzaymVar;
        zzbjw zzbjwVar;
        Set set;
        zzbah zzbahVar;
        zzaymVar = this.zza.zzi;
        zzaymVar.zza(2, "Terminated");
        zzbkd zzbkdVar = this.zza;
        zzbjwVar = zzbkdVar.zzc;
        zzblv zzblvVar = (zzblv) zzbjwVar;
        set = zzblvVar.zzb.zzj.zzJ;
        set.remove(zzbkdVar);
        zzbahVar = zzblvVar.zzb.zzj.zzX;
        zzbahVar.zzh(zzbkdVar);
        zzbma.zzQ(zzblvVar.zzb.zzj);
    }
}
