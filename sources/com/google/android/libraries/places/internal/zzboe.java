package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzboe {
    private final ScheduledExecutorService zza;
    private final Executor zzb;
    private final Runnable zzc;
    private final zzna zzd;
    private long zze;
    private boolean zzf;
    private ScheduledFuture zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboe(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, zzna zznaVar) {
        this.zzc = runnable;
        this.zzb = executor;
        this.zza = scheduledExecutorService;
        this.zzd = zznaVar;
        zznaVar.zzd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzk() {
        return this.zzd.zza(TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(boolean z10) {
        ScheduledFuture scheduledFuture;
        this.zzf = false;
        if (!z10 || (scheduledFuture = this.zzg) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.zzg = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(long j11, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j11);
        long zzk = zzk() + nanos;
        this.zzf = true;
        if (zzk - this.zze < 0 || this.zzg == null) {
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzg = this.zza.schedule(new zzbod(this, null), nanos, TimeUnit.NANOSECONDS);
        }
        this.zze = zzk;
    }
}
