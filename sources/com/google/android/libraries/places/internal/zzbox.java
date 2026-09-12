package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbox {
    private final AtomicLong zza = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(long j11) {
        return this.zza.addAndGet(j11);
    }
}
