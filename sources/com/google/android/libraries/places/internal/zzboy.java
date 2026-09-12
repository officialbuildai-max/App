package com.google.android.libraries.places.internal;

import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzboy {
    final Object zza;
    Future zzb;
    boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboy(Object obj) {
        this.zza = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future zza() {
        this.zzc = true;
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(Future future) {
        boolean z10;
        synchronized (this.zza) {
            try {
                z10 = this.zzc;
                if (!z10) {
                    this.zzb = future;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            future.cancel(false);
        }
    }
}
