package com.google.android.libraries.places.internal;

import java.util.IdentityHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbqj implements Runnable {
    final /* synthetic */ zzbqk zza;
    final /* synthetic */ zzbql zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ zzbqm zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqj(zzbqm zzbqmVar, zzbqk zzbqkVar, zzbql zzbqlVar, Object obj) {
        this.zza = zzbqkVar;
        this.zzb = zzbqlVar;
        this.zzc = obj;
        this.zzd = zzbqmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IdentityHashMap identityHashMap;
        IdentityHashMap identityHashMap2;
        ScheduledExecutorService scheduledExecutorService;
        IdentityHashMap identityHashMap3;
        IdentityHashMap identityHashMap4;
        ScheduledExecutorService scheduledExecutorService2;
        synchronized (this.zzd) {
            try {
                if (this.zza.zzb == 0) {
                    try {
                        this.zzb.zzb(this.zzc);
                        identityHashMap3 = this.zzd.zzb;
                        identityHashMap3.remove(this.zzb);
                        identityHashMap4 = this.zzd.zzb;
                        if (identityHashMap4.isEmpty()) {
                            scheduledExecutorService2 = this.zzd.zzc;
                            scheduledExecutorService2.shutdown();
                            this.zzd.zzc = null;
                        }
                    } catch (Throwable th2) {
                        identityHashMap = this.zzd.zzb;
                        identityHashMap.remove(this.zzb);
                        identityHashMap2 = this.zzd.zzb;
                        if (identityHashMap2.isEmpty()) {
                            scheduledExecutorService = this.zzd.zzc;
                            scheduledExecutorService.shutdown();
                            this.zzd.zzc = null;
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
