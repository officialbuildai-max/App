package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbve extends zzbvc {
    zzbbm zza;
    final /* synthetic */ zzbvg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbve(zzbvg zzbvgVar) {
        this.zzb = zzbvgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbvc, com.google.android.libraries.places.internal.zzbbd
    public final void zze(zzaze zzazeVar, zzbbk zzbbkVar) {
        zzbbm zzbbmVar;
        zzbbm zzbbmVar2;
        boolean z10;
        zzbbd zzbbdVar;
        zzbbm zzbbmVar3;
        zzbbm zzbbmVar4;
        boolean z11;
        zzbvg zzbvgVar = this.zzb;
        zzbbm zzbbmVar5 = this.zza;
        zzbbmVar = zzbvgVar.zzl;
        if (zzbbmVar5 == zzbbmVar) {
            z11 = zzbvgVar.zzo;
            zzmt.zzp(z11, "there's pending lb while current lb has been out of READY");
            this.zzb.zzm = zzazeVar;
            this.zzb.zzn = zzbbkVar;
            if (zzazeVar == zzaze.READY) {
                this.zzb.zzr();
                return;
            }
            return;
        }
        zzbbmVar2 = zzbvgVar.zzj;
        if (zzbbmVar5 == zzbbmVar2) {
            zzbvgVar.zzo = zzazeVar == zzaze.READY;
            zzbvg zzbvgVar2 = this.zzb;
            z10 = zzbvgVar2.zzo;
            if (!z10) {
                zzbbmVar3 = zzbvgVar2.zzl;
                zzbbmVar4 = zzbvgVar2.zzg;
                if (zzbbmVar3 != zzbbmVar4) {
                    zzbvgVar2.zzr();
                    return;
                }
            }
            zzbbdVar = zzbvgVar2.zzh;
            zzbbdVar.zze(zzazeVar, zzbbkVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbvc
    protected final zzbbd zzf() {
        zzbbd zzbbdVar;
        zzbbdVar = this.zzb.zzh;
        return zzbbdVar;
    }
}
