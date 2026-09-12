package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzdi implements zzdd {
    @Override // com.google.android.gms.internal.measurement.zzdd
    public final Runnable zza(Runnable runnable) {
        return runnable;
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public final <V> Callable<V> zza(Callable<V> callable) {
        return callable;
    }
}
