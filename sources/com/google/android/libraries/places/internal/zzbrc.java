package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
final class zzbrc extends zzbrh {
    final zzbvq zza;
    final /* synthetic */ zzbri zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbrc(zzbri zzbriVar) {
        super(zzbriVar, null);
        this.zzb = zzbriVar;
        this.zza = zzbvr.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbrh
    public final void zza() throws IOException {
        Object obj;
        zzbwb zzbwbVar;
        zzbwb zzbwbVar2;
        int i11;
        zzbwq zzbwqVar;
        Object obj2;
        int i12;
        zzbwb zzbwbVar3 = new zzbwb();
        int i13 = zzbvr.zza;
        obj = this.zzb.zza;
        synchronized (obj) {
            zzbri zzbriVar = this.zzb;
            zzbwbVar = zzbriVar.zzb;
            zzbwbVar2 = zzbriVar.zzb;
            zzbwbVar3.zzn(zzbwbVar, zzbwbVar2.zzf());
            this.zzb.zze = false;
            i11 = this.zzb.zzl;
        }
        zzbwqVar = this.zzb.zzh;
        zzbwqVar.zzn(zzbwbVar3, zzbwbVar3.zzg());
        obj2 = this.zzb.zza;
        synchronized (obj2) {
            zzbri zzbriVar2 = this.zzb;
            i12 = zzbriVar2.zzl;
            zzbriVar2.zzl = i12 - i11;
        }
    }
}
