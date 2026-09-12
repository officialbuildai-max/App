package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbjn implements Runnable {
    final /* synthetic */ zzbjo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjn(zzbjo zzbjoVar) {
        this.zza = zzbjoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbml zzbmlVar;
        zzbkd zzbkdVar = this.zza.zzb;
        zzbmlVar = zzbkdVar.zzq;
        zzbkdVar.zzp = null;
        this.zza.zzb.zzq = null;
        zzbmlVar.zzd(zzbdo.zzp.zzg("InternalSubchannel closed transport due to address change"));
    }
}
