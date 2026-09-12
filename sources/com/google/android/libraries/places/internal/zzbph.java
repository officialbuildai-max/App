package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbph implements Runnable {
    final /* synthetic */ zzbpl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbph(zzbpl zzbplVar) {
        this.zza = zzbplVar;
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
        this.zza.zzb.zzD = true;
        zzbpo zzbpoVar = this.zza.zzb;
        zzbftVar = zzbpoVar.zzy;
        zzbpbVar = zzbpoVar.zzw;
        zzbdoVar = zzbpbVar.zza;
        zzbpbVar2 = this.zza.zzb.zzw;
        zzbfsVar = zzbpbVar2.zzb;
        zzbpbVar3 = this.zza.zzb.zzw;
        zzbcfVar = zzbpbVar3.zzc;
        zzbftVar.zzd(zzbdoVar, zzbfsVar, zzbcfVar);
    }
}
