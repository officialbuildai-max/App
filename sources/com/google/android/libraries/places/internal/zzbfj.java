package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbfj implements Runnable, zzazg {
    final /* synthetic */ zzbfq zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private volatile ScheduledFuture zze;
    private volatile boolean zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfj(zzbfq zzbfqVar, zzazn zzaznVar, boolean z10) {
        long zzb;
        this.zza = zzbfqVar;
        this.zzb = z10;
        if (zzaznVar == null) {
            this.zzc = false;
            zzb = 0;
        } else {
            this.zzc = true;
            zzb = zzaznVar.zzb(TimeUnit.NANOSECONDS);
        }
        this.zzd = zzb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfq.zzo(this.zza).zzh(zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbdo zzb() {
        long abs = Math.abs(this.zzd);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = abs / timeUnit.toNanos(1L);
        long abs2 = Math.abs(this.zzd) % timeUnit.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(true != this.zzb ? "CallOptions" : "Context");
        sb2.append(" deadline exceeded after ");
        if (this.zzd < 0) {
            sb2.append('-');
        }
        sb2.append(nanos);
        Locale locale = Locale.US;
        sb2.append(String.format(locale, ".%09d", Long.valueOf(abs2)));
        sb2.append("s. ");
        sb2.append(String.format(locale, "Name resolution delay %.9f seconds.", Double.valueOf(((Long) zzbfq.zzg(this.zza).zzl(zzayx.zza)) == null ? 0.0d : r2.longValue() / zzbfq.zzf())));
        if (zzbfq.zzo(this.zza) != null) {
            zzbjj zzbjjVar = new zzbjj();
            zzbfq.zzo(this.zza).zzg(zzbjjVar);
            sb2.append(" ");
            sb2.append(zzbjjVar);
        }
        return zzbdo.zze.zzg(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zzf) {
            return;
        }
        if (this.zzc && !this.zzb) {
            zzbfq zzbfqVar = this.zza;
            if (zzbfq.zzq(zzbfqVar) != null) {
                this.zze = zzbfq.zzq(zzbfqVar).schedule(new zzbki(this), this.zzd, TimeUnit.NANOSECONDS);
            }
        }
        zzbfq.zzh(this.zza).zzd(this, zzakb.zza());
        if (this.zzf) {
            zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd() {
        this.zzf = true;
        ScheduledFuture scheduledFuture = this.zze;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}
