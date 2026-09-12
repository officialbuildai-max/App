package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzbco {
    private final int zza;
    private final zzbde zzb;
    private final zzbdw zzc;
    private final zzbcu zzd;
    private final ScheduledExecutorService zze;
    private final zzaym zzf;
    private final Executor zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbco(Integer num, zzbde zzbdeVar, zzbdw zzbdwVar, zzbcu zzbcuVar, ScheduledExecutorService scheduledExecutorService, zzaym zzaymVar, Executor executor, String str, zzbcn zzbcnVar) {
        zzmt.zzc(num, "defaultPort not set");
        num.intValue();
        this.zza = 443;
        zzmt.zzc(zzbdeVar, "proxyDetector not set");
        this.zzb = zzbdeVar;
        zzmt.zzc(zzbdwVar, "syncContext not set");
        this.zzc = zzbdwVar;
        zzmt.zzc(zzbcuVar, "serviceConfigParser not set");
        this.zzd = zzbcuVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzaymVar;
        this.zzg = executor;
    }

    public static zzbcm zzb() {
        return new zzbcm();
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzb("defaultPort", this.zza);
        zzb.zzd("proxyDetector", this.zzb);
        zzb.zzd("syncContext", this.zzc);
        zzb.zzd("serviceConfigParser", this.zzd);
        zzb.zzd("scheduledExecutorService", this.zze);
        zzb.zzd("channelLogger", this.zzf);
        zzb.zzd("executor", this.zzg);
        zzb.zzd("overrideAuthority", null);
        return zzb.toString();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzbcu zzc() {
        return this.zzd;
    }

    public final zzbde zzd() {
        return this.zzb;
    }

    public final zzbdw zze() {
        return this.zzc;
    }

    public final Executor zzf() {
        return this.zzg;
    }

    public final ScheduledExecutorService zzg() {
        ScheduledExecutorService scheduledExecutorService = this.zze;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        throw new IllegalStateException("ScheduledExecutorService not set in Builder");
    }
}
