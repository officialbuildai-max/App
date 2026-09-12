package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbna implements Runnable {
    final /* synthetic */ zzbnj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbna(zzbnj zzbnjVar) {
        this.zza = zzbnjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbnd zzbndVar;
        this.zza.zzl = null;
        zzbndVar = this.zza.zzi;
        if (zzbndVar.zzf()) {
            this.zza.zzd();
        }
    }
}
