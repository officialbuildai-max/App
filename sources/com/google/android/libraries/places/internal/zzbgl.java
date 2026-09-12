package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbgl implements Runnable {
    final /* synthetic */ StringBuilder zza;
    final /* synthetic */ zzbgz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgl(zzbgz zzbgzVar, StringBuilder sb2) {
        this.zza = sb2;
        this.zzb = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzl(zzbdo.zze.zzg(this.zza.toString()), true);
    }
}
