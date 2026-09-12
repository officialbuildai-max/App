package com.google.android.libraries.places.internal;

import java.lang.Thread;

/* loaded from: classes4.dex */
final class zzbof implements Thread.UncaughtExceptionHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbof(zzbpo zzbpoVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        throw new zzbdq(zzbdo.zze(th2).zzg("Uncaught exception in the SynchronizationContext. Re-thrown."), null);
    }
}
