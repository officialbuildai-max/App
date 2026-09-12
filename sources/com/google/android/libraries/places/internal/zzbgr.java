package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbgr implements Runnable {
    final /* synthetic */ zzbgz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgr(zzbgz zzbgzVar) {
        this.zza = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayo zzayoVar;
        zzayoVar = this.zza.zzh;
        zzayoVar.zzb();
    }
}
