package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
final class zzkl implements zzkm {
    private static <E> zzkc<E> zzc(Object obj, long j11) {
        return (zzkc) zzml.zze(obj, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final <L> List<L> zza(Object obj, long j11) {
        zzkc zzc = zzc(obj, j11);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzkc zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzml.zza(obj, j11, zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final <E> void zza(Object obj, Object obj2, long j11) {
        zzkc zzc = zzc(obj, j11);
        zzkc zzc2 = zzc(obj2, j11);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzml.zza(obj, j11, zzc2);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final void zzb(Object obj, long j11) {
        zzc(obj, j11).zzb();
    }
}
