package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class zzbvz extends zzbwv {
    public static final zzbvw zza = new zzbvw(null);
    private static final ReentrantLock zzd;
    private static final Condition zze;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        zzd = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        Intrinsics.g(newCondition, "newCondition(...)");
        zze = newCondition;
        TimeUnit.MILLISECONDS.toNanos(TimeUnit.SECONDS.toMillis(60L));
    }
}
