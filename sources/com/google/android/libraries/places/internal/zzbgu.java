package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbgu implements Runnable {
    final /* synthetic */ zzbcf zza;
    final /* synthetic */ zzbgy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgu(zzbgy zzbgyVar, zzbcf zzbcfVar) {
        this.zza = zzbcfVar;
        this.zzb = zzbgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayn zzaynVar;
        zzaynVar = this.zzb.zza;
        zzaynVar.zzb(this.zza);
    }
}
