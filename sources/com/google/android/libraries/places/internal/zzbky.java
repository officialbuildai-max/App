package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbky implements Executor {
    private Executor zza;
    private final zzbqn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbky(zzbqn zzbqnVar) {
        this.zzb = zzbqnVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zza().execute(runnable);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.concurrent.Executor, java.lang.Object] */
    final synchronized Executor zza() {
        try {
            if (this.zza == null) {
                ?? zzb = this.zzb.zzb();
                zzmt.zzd(zzb, "%s.getObject()", this.zza);
                this.zza = zzb;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzb() {
        Executor executor = this.zza;
        if (executor != null) {
            this.zzb.zzc(executor);
            this.zza = null;
        }
    }
}
