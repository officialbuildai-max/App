package com.google.android.libraries.places.internal;

import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class zzben {
    final /* synthetic */ zzbeo zza;
    private final long zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzben(zzbeo zzbeoVar, long j11, zzbem zzbemVar) {
        this.zza = zzbeoVar;
        this.zzb = j11;
    }

    public final void zza() {
        zzbeo zzbeoVar = this.zza;
        long j11 = this.zzb;
        long max = Math.max(j11 + j11, j11);
        if (zzbeo.zzc(zzbeoVar).compareAndSet(j11, max)) {
            zzbeo.zzd().logp(Level.WARNING, "io.grpc.internal.AtomicBackoff$State", "backoff", "Increased {0} to {1}", new Object[]{zzbeo.zzb(this.zza), Long.valueOf(max)});
        }
    }
}
