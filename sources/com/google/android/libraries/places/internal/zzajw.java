package com.google.android.libraries.places.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
final class zzajw implements Runnable {
    final Future zza;
    final zzajv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajw(Future future, zzajv zzajvVar) {
        this.zza = future;
        this.zzb = zzajvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza = zzakf.zza((zzake) this.zza);
        if (zza != null) {
            this.zzb.zza(zza);
            return;
        }
        try {
            Future future = this.zza;
            zzmt.zzr(future.isDone(), "Future was expected to be done: %s", future);
            boolean z10 = false;
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                } catch (Throwable th2) {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th2;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e11) {
            this.zzb.zza(e11.getCause());
        } catch (Throwable th3) {
            this.zzb.zza(th3);
        }
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzf(this.zzb);
        return zzb.toString();
    }
}
