package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzbsd implements Runnable {
    final /* synthetic */ zzbsf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsd(zzbsf zzbsfVar) {
        this.zza = zzbsfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        zzbse zzbseVar;
        Object obj;
        zzbsf zzbsfVar = this.zza;
        executor = zzbsfVar.zzs;
        zzbseVar = zzbsfVar.zzx;
        executor.execute(zzbseVar);
        obj = this.zza.zzo;
        synchronized (obj) {
            this.zza.zzH = Integer.MAX_VALUE;
            this.zza.zzad();
        }
    }
}
