package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbpf implements Runnable {
    final /* synthetic */ zzbpg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpf(zzbpg zzbpgVar) {
        this.zza = zzbpgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbpg zzbpgVar = this.zza;
        zzbpgVar.zzc.zzb.zzai(zzbpgVar.zzb);
    }
}
