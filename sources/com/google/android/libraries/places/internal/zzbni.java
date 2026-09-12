package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbni {
    private final zzbbj zza;
    private zzaze zzb;
    private final zzbnc zzc;
    private boolean zzd = false;

    public zzbni(zzbbj zzbbjVar, zzaze zzazeVar, zzbnc zzbncVar) {
        this.zza = zzbbjVar;
        this.zzb = zzazeVar;
        this.zzc = zzbncVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzg(zzbni zzbniVar, zzaze zzazeVar) {
        boolean z10;
        zzbniVar.zzb = zzazeVar;
        if (zzazeVar == zzaze.READY || zzazeVar == zzaze.TRANSIENT_FAILURE) {
            z10 = true;
        } else if (zzazeVar != zzaze.IDLE) {
            return;
        } else {
            z10 = false;
        }
        zzbniVar.zzd = z10;
    }

    public final zzaze zzc() {
        return this.zzb;
    }

    public final zzbbj zze() {
        return this.zza;
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
