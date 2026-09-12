package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzboh implements Runnable {
    final /* synthetic */ Collection zza;
    final /* synthetic */ zzbpm zzb;
    final /* synthetic */ Future zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ Future zze;
    final /* synthetic */ zzbpo zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboh(zzbpo zzbpoVar, Collection collection, zzbpm zzbpmVar, Future future, boolean z10, Future future2) {
        this.zza = collection;
        this.zzb = zzbpmVar;
        this.zzc = future;
        this.zzd = z10;
        this.zze = future2;
        this.zzf = zzbpoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger;
        Executor executor;
        zzbdo zzbdoVar;
        for (zzbpm zzbpmVar : this.zza) {
            if (zzbpmVar != this.zzb) {
                zzbfr zzbfrVar = zzbpmVar.zza;
                zzbdoVar = zzbpo.zza;
                zzbfrVar.zzh(zzbdoVar);
            }
        }
        Future future = this.zzc;
        if (future != null) {
            future.cancel(false);
            if (!this.zzd) {
                atomicInteger = this.zzf.zzv;
                if (atomicInteger.decrementAndGet() == Integer.MIN_VALUE) {
                    executor = this.zzf.zze;
                    zzbdw zzbdwVar = (zzbdw) executor;
                    zzbdwVar.zzc(new zzbog(this));
                    zzbdwVar.zzb();
                }
            }
        }
        Future future2 = this.zze;
        if (future2 != null) {
            future2.cancel(false);
        }
        this.zzf.zzc();
    }
}
