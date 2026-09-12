package com.google.android.libraries.places.internal;

import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbvh extends zzbvc {
    final /* synthetic */ zzbvi zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbvh(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbvc, com.google.android.libraries.places.internal.zzbbd
    public final void zze(zzaze zzazeVar, zzbbk zzbbkVar) {
        Map map;
        Object obj;
        boolean z10;
        zzbvg zzbvgVar;
        zzbvi zzbviVar = this.zza;
        map = zzbviVar.zza.zzj;
        obj = zzbviVar.zzb;
        if (map.containsKey(obj)) {
            this.zza.zzf = zzazeVar;
            this.zza.zzg = zzbbkVar;
            z10 = this.zza.zzh;
            if (z10) {
                return;
            }
            zzbvi zzbviVar2 = this.zza;
            if (zzbviVar2.zza.zzf) {
                return;
            }
            if (zzazeVar == zzaze.IDLE) {
                zzbvgVar = zzbviVar2.zzd;
                zzbvgVar.zzg().zzd();
            }
            this.zza.zza.zzl();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbvc
    protected final zzbbd zzf() {
        zzbbd zzbbdVar;
        zzbbdVar = this.zza.zza.zzk;
        return zzbbdVar;
    }
}
