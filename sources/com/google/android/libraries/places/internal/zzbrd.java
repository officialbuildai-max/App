package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
final class zzbrd extends zzbrh {
    final zzbvq zza;
    final /* synthetic */ zzbri zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbrd(zzbri zzbriVar) {
        super(zzbriVar, null);
        this.zzb = zzbriVar;
        this.zza = zzbvr.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbrh
    public final void zza() throws IOException {
        Object obj;
        zzbwb zzbwbVar;
        zzbwb zzbwbVar2;
        zzbwq zzbwqVar;
        zzbwq zzbwqVar2;
        zzbwb zzbwbVar3 = new zzbwb();
        int i11 = zzbvr.zza;
        obj = this.zzb.zza;
        synchronized (obj) {
            zzbri zzbriVar = this.zzb;
            zzbwbVar = zzbriVar.zzb;
            zzbwbVar2 = zzbriVar.zzb;
            zzbwbVar3.zzn(zzbwbVar, zzbwbVar2.zzg());
            this.zzb.zzf = false;
        }
        zzbwqVar = this.zzb.zzh;
        zzbwqVar.zzn(zzbwbVar3, zzbwbVar3.zzg());
        zzbwqVar2 = this.zzb.zzh;
        zzbwqVar2.flush();
    }
}
