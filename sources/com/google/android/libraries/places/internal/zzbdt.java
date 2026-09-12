package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbdt implements Runnable {
    final Runnable zza;
    boolean zzb;
    boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdt(Runnable runnable) {
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zzc = true;
        this.zza.run();
    }
}
