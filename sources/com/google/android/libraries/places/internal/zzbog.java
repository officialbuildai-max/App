package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbog implements Runnable {
    final /* synthetic */ zzboh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbog(zzboh zzbohVar) {
        this.zza = zzbohVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        zzbpb zzbpbVar;
        zzbdo zzbdoVar;
        zzbpb zzbpbVar2;
        zzbfs zzbfsVar;
        zzbpb zzbpbVar3;
        zzbcf zzbcfVar;
        this.zza.zzf.zzD = true;
        zzbpo zzbpoVar = this.zza.zzf;
        zzbftVar = zzbpoVar.zzy;
        zzbpbVar = zzbpoVar.zzw;
        zzbdoVar = zzbpbVar.zza;
        zzbpbVar2 = this.zza.zzf.zzw;
        zzbfsVar = zzbpbVar2.zzb;
        zzbpbVar3 = this.zza.zzf.zzw;
        zzbcfVar = zzbpbVar3.zzc;
        zzbftVar.zzd(zzbdoVar, zzbfsVar, zzbcfVar);
    }
}
