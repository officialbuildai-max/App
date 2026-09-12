package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjr implements Runnable {
    final /* synthetic */ zzbgf zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbkd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjr(zzbkd zzbkdVar, zzbgf zzbgfVar, boolean z10) {
        this.zza = zzbgfVar;
        this.zzb = z10;
        this.zzc = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbji zzbjiVar;
        zzbjiVar = this.zzc.zzs;
        zzbjiVar.zzc(this.zza, this.zzb);
    }
}
