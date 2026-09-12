package com.google.android.libraries.places.internal;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjp implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbkd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjp(zzbkd zzbkdVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzazf zzazfVar;
        zzbml zzbmlVar;
        zzbgf zzbgfVar;
        zzbjx zzbjxVar;
        Collection collection;
        zzbdv zzbdvVar;
        zzbdv zzbdvVar2;
        zzbml zzbmlVar2;
        zzazfVar = this.zzb.zzv;
        zzaze zza = zzazfVar.zza();
        zzaze zzazeVar = zzaze.SHUTDOWN;
        if (zza == zzazeVar) {
            return;
        }
        this.zzb.zzw = this.zza;
        zzbkd zzbkdVar = this.zzb;
        zzbmlVar = zzbkdVar.zzu;
        zzbgfVar = zzbkdVar.zzt;
        zzbkdVar.zzu = null;
        this.zzb.zzt = null;
        zzbkd.zzA(this.zzb, zzazeVar);
        zzbjxVar = this.zzb.zzl;
        zzbjxVar.zzd();
        collection = this.zzb.zzr;
        if (collection.isEmpty()) {
            zzbkd.zzB(this.zzb);
        }
        zzbkd.zzz(this.zzb);
        zzbkd zzbkdVar2 = this.zzb;
        zzbdvVar = zzbkdVar2.zzp;
        if (zzbdvVar != null) {
            zzbdvVar2 = zzbkdVar2.zzp;
            zzbdvVar2.zza();
            zzbkd zzbkdVar3 = this.zzb;
            zzbdo zzbdoVar = this.zza;
            zzbmlVar2 = zzbkdVar3.zzq;
            zzbmlVar2.zzd(zzbdoVar);
            this.zzb.zzp = null;
            this.zzb.zzq = null;
        }
        if (zzbmlVar != null) {
            zzbmlVar.zzd(this.zza);
        }
        if (zzbgfVar != null) {
            zzbgfVar.zzd(this.zza);
        }
    }
}
