package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbhi implements Runnable {
    final /* synthetic */ zzbhy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhi(zzbhy zzbhyVar) {
        this.zza = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar;
        zzbfrVar = this.zza.zzc;
        zzbfrVar.zzt();
    }
}
