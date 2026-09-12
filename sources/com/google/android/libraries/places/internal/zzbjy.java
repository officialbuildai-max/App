package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbjy implements Runnable {
    final /* synthetic */ zzbkb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjy(zzbkb zzbkbVar) {
        this.zza = zzbkbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdo zzbdoVar;
        zzbgf zzbgfVar;
        zzbml zzbmlVar;
        zzbdo zzbdoVar2;
        this.zza.zzc.zzy = null;
        zzbkb zzbkbVar = this.zza;
        zzbkd zzbkdVar = zzbkbVar.zzc;
        zzbdoVar = zzbkdVar.zzw;
        if (zzbdoVar != null) {
            zzbmlVar = zzbkdVar.zzu;
            zzmt.zzp(zzbmlVar == null, "Unexpected non-null activeTransport");
            zzbkb zzbkbVar2 = this.zza;
            zzbkd zzbkdVar2 = zzbkbVar2.zzc;
            zzbgf zzbgfVar2 = zzbkbVar2.zza;
            zzbdoVar2 = zzbkdVar2.zzw;
            zzbgfVar2.zzd(zzbdoVar2);
            return;
        }
        zzbgf zzbgfVar3 = zzbkbVar.zza;
        zzbgfVar = zzbkdVar.zzt;
        if (zzbgfVar == zzbgfVar3) {
            zzbkdVar.zzu = zzbgfVar3;
            this.zza.zzc.zzt = null;
            zzbkd.zzA(this.zza.zzc, zzaze.READY);
        }
    }
}
