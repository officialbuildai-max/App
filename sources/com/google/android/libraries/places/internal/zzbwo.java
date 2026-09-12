package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zzbwo {
    public static final zzbwo zza = new zzbwo();
    private static final zzbwn zzb = new zzbwn(new byte[0], 0, 0, false, false);
    private static final int zzc;
    private static final AtomicReference[] zzd;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int highestOneBit = Integer.highestOneBit((availableProcessors + availableProcessors) - 1);
        zzc = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i11 = 0; i11 < highestOneBit; i11++) {
            atomicReferenceArr[i11] = new AtomicReference();
        }
        zzd = atomicReferenceArr;
    }

    private zzbwo() {
    }

    @JvmStatic
    public static final zzbwn zza() {
        AtomicReference zzc2 = zzc();
        zzbwn zzbwnVar = zzb;
        zzbwn zzbwnVar2 = (zzbwn) zzc2.getAndSet(zzbwnVar);
        if (zzbwnVar2 == zzbwnVar) {
            return new zzbwn();
        }
        if (zzbwnVar2 == null) {
            zzc2.set(null);
            return new zzbwn();
        }
        zzc2.set(zzbwnVar2.zzg);
        zzbwnVar2.zzg = null;
        zzbwnVar2.zzd = 0;
        return zzbwnVar2;
    }

    @JvmStatic
    public static final void zzb(zzbwn segment) {
        Intrinsics.h(segment, "segment");
        if (segment.zzg != null || segment.zzh != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.zze) {
            return;
        }
        AtomicReference zzc2 = zzc();
        zzbwn zzbwnVar = zzb;
        zzbwn zzbwnVar2 = (zzbwn) zzc2.getAndSet(zzbwnVar);
        if (zzbwnVar2 != zzbwnVar) {
            int i11 = zzbwnVar2 != null ? zzbwnVar2.zzd : 0;
            if (i11 >= 65536) {
                zzc2.set(zzbwnVar2);
                return;
            }
            segment.zzg = zzbwnVar2;
            segment.zzc = 0;
            segment.zzd = i11 + 8192;
            zzc2.set(segment);
        }
    }

    private static final AtomicReference zzc() {
        return zzd[(int) (Thread.currentThread().getId() & (zzc - 1))];
    }
}
