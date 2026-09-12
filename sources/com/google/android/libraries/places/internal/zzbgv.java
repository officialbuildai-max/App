package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbgv implements Runnable {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbgy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgv(zzbgy zzbgyVar, Object obj) {
        this.zza = obj;
        this.zzb = zzbgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayn zzaynVar;
        zzaynVar = this.zzb.zza;
        zzaynVar.zzc(this.zza);
    }
}
