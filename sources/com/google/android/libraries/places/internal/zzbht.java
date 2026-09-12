package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbht implements Runnable {
    final /* synthetic */ zzbqq zza;
    final /* synthetic */ zzbhx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbht(zzbhx zzbhxVar, zzbqq zzbqqVar) {
        this.zza = zzbqqVar;
        this.zzb = zzbhxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        zzbftVar = this.zzb.zza;
        zzbftVar.zzf(this.zza);
    }
}
