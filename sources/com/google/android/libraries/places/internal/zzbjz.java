package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbjz implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbkb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjz(zzbkb zzbkbVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbkbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzazf zzazfVar;
        zzbml zzbmlVar;
        zzbgf zzbgfVar;
        zzazf zzazfVar2;
        zzazf zzazfVar3;
        zzbjx zzbjxVar;
        zzbjx zzbjxVar2;
        zzbjx zzbjxVar3;
        zzbjx zzbjxVar4;
        zzazfVar = this.zzb.zzc.zzv;
        if (zzazfVar.zza() == zzaze.SHUTDOWN) {
            return;
        }
        zzbkb zzbkbVar = this.zzb;
        zzbmlVar = zzbkbVar.zzc.zzu;
        if (zzbmlVar == zzbkbVar.zza) {
            this.zzb.zzc.zzu = null;
            zzbjxVar4 = this.zzb.zzc.zzl;
            zzbjxVar4.zzd();
            zzbkd.zzA(this.zzb.zzc, zzaze.IDLE);
            return;
        }
        zzbkb zzbkbVar2 = this.zzb;
        zzbkd zzbkdVar = zzbkbVar2.zzc;
        zzbgfVar = zzbkdVar.zzt;
        if (zzbgfVar == zzbkbVar2.zza) {
            zzazfVar2 = zzbkdVar.zzv;
            boolean z10 = zzazfVar2.zza() == zzaze.CONNECTING;
            zzazfVar3 = this.zzb.zzc.zzv;
            zzmt.zzr(z10, "Expected state is CONNECTING, actual state is %s", zzazfVar3.zza());
            zzbjxVar = this.zzb.zzc.zzl;
            zzbjxVar.zzc();
            zzbjxVar2 = this.zzb.zzc.zzl;
            if (zzbjxVar2.zzg()) {
                zzbkd.zzE(this.zzb.zzc);
                return;
            }
            this.zzb.zzc.zzt = null;
            zzbjxVar3 = this.zzb.zzc.zzl;
            zzbjxVar3.zzd();
            zzbkd.zzD(this.zzb.zzc, this.zza);
        }
    }
}
