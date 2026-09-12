package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbnn implements Runnable {
    final /* synthetic */ zzbno zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnn(zzbno zzbnoVar) {
        this.zza = zzbnoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbj zzbbjVar;
        zzbbjVar = this.zza.zzb;
        zzbbjVar.zza();
    }
}
