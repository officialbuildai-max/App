package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbhl implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbhy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhl(zzbhy zzbhyVar, int i11) {
        this.zza = i11;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar;
        zzbfrVar = this.zzb.zzc;
        zzbfrVar.zzm(this.zza);
    }
}
