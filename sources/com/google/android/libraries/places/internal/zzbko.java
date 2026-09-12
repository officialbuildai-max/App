package com.google.android.libraries.places.internal;

import java.lang.Thread;
import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbko implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzbma zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbko(zzbma zzbmaVar) {
        this.zza = zzbmaVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        zzbma zzbmaVar = this.zza;
        zzbma.zza.logp(Level.SEVERE, "io.grpc.internal.ManagedChannelImpl$2", "uncaughtException", "[" + String.valueOf(zzbmaVar.zzc()) + "] Uncaught exception in the SynchronizationContext. Panic!", th2);
        this.zza.zzW(th2);
    }
}
