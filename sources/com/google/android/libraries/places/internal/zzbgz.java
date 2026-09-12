package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class zzbgz extends zzayo {
    private static final Logger zza = Logger.getLogger(zzbgz.class.getName());
    private static final zzayo zzb = new zzbgs();
    private final ScheduledFuture zzc;
    private final Executor zzd;
    private final zzazj zze;
    private volatile boolean zzf;
    private zzayn zzg;
    private zzayo zzh;
    private zzbdo zzi;
    private List zzj = new ArrayList();
    private zzbgy zzk;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbgz(Executor executor, ScheduledExecutorService scheduledExecutorService, zzazn zzaznVar) {
        ScheduledFuture<?> schedule;
        zzmt.zzc(executor, "callExecutor");
        this.zzd = executor;
        zzmt.zzc(scheduledExecutorService, "scheduler");
        this.zze = zzazj.zzb();
        if (zzaznVar == null) {
            schedule = null;
        } else {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long zzb2 = zzaznVar.zzb(timeUnit);
            long abs = Math.abs(zzb2);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            long nanos = abs / timeUnit2.toNanos(1L);
            long abs2 = Math.abs(zzb2) % timeUnit2.toNanos(1L);
            StringBuilder sb2 = new StringBuilder();
            if (zzb2 < 0) {
                sb2.append("ClientCall started after CallOptions deadline was exceeded. Deadline has been exceeded for ");
            } else {
                sb2.append("Deadline CallOptions will be exceeded in ");
            }
            sb2.append(nanos);
            sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
            sb2.append("s. ");
            schedule = scheduledExecutorService.schedule(new zzbgl(this, sb2), zzb2, timeUnit);
        }
        this.zzc = schedule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(zzbdo zzbdoVar, boolean z10) {
        zzayn zzaynVar;
        boolean z11;
        synchronized (this) {
            try {
                if (this.zzh == null) {
                    zzo(zzb);
                    zzaynVar = this.zzg;
                    this.zzi = zzbdoVar;
                    z11 = false;
                } else {
                    if (z10) {
                        return;
                    }
                    zzaynVar = null;
                    z11 = true;
                }
                if (z11) {
                    zzm(new zzbgo(this, zzbdoVar));
                } else {
                    if (zzaynVar != null) {
                        this.zzd.execute(new zzbgt(this, zzaynVar, zzbdoVar));
                    }
                    zzn();
                }
                zzk();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void zzm(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.zzf) {
                    runnable.run();
                } else {
                    this.zzj.add(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzn() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.zzj     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.zzj = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.zzf = r0     // Catch: java.lang.Throwable -> L24
            com.google.android.libraries.places.internal.zzbgy r0 = r3.zzk     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.zzd
            com.google.android.libraries.places.internal.zzbgm r2 = new com.google.android.libraries.places.internal.zzbgm
            r2.<init>(r3, r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.zzj     // Catch: java.lang.Throwable -> L24
            r3.zzj = r0     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r0 = r1.iterator()
        L2f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2f
        L3f:
            r1.clear()
            r0 = r1
            goto L5
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbgz.zzn():void");
    }

    private final void zzo(zzayo zzayoVar) {
        zzayo zzayoVar2 = this.zzh;
        zzmt.zzr(zzayoVar2 == null, "realCall already set to %s", zzayoVar2);
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzh = zzayoVar;
    }

    public final String toString() {
        zzmm zzb2 = zzmn.zzb(this);
        zzb2.zzd("realCall", this.zzh);
        return zzb2.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zza(String str, Throwable th2) {
        zzbdo zzbdoVar = zzbdo.zzb;
        zzbdo zzg = str != null ? zzbdoVar.zzg(str) : zzbdoVar.zzg("Call cancelled without message");
        if (th2 != null) {
            zzg = zzg.zzf(th2);
        }
        zzl(zzg, false);
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzb() {
        zzm(new zzbgr(this));
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzc(int i11) {
        if (this.zzf) {
            this.zzh.zzc(2);
        } else {
            zzm(new zzbgq(this, 2));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzd(Object obj) {
        if (this.zzf) {
            this.zzh.zzd(obj);
        } else {
            zzm(new zzbgp(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zze(zzayn zzaynVar, zzbcf zzbcfVar) {
        zzbdo zzbdoVar;
        boolean z10;
        zzmt.zzp(this.zzg == null, "already started");
        synchronized (this) {
            try {
                this.zzg = zzaynVar;
                zzbdoVar = this.zzi;
                z10 = this.zzf;
                if (!z10) {
                    zzbgy zzbgyVar = new zzbgy(zzaynVar);
                    this.zzk = zzbgyVar;
                    zzaynVar = zzbgyVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zzbdoVar != null) {
            this.zzd.execute(new zzbgt(this, zzaynVar, zzbdoVar));
        } else if (z10) {
            this.zzh.zze(zzaynVar, zzbcfVar);
        } else {
            zzm(new zzbgn(this, zzaynVar, zzbcfVar));
        }
    }

    public final Runnable zzh(zzayo zzayoVar) {
        synchronized (this) {
            try {
                if (this.zzh != null) {
                    return null;
                }
                zzo(zzayoVar);
                return new zzbgk(this, this.zze);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    protected void zzk() {
    }
}
