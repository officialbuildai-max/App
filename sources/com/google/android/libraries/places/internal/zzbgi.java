package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
abstract class zzbgi implements Runnable {
    private final zzazj zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbgi(zzazj zzazjVar) {
        this.zza = zzazjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzazj zza = this.zza.zza();
        try {
            zza();
        } finally {
            this.zza.zze(zza);
        }
    }

    public abstract void zza();
}
