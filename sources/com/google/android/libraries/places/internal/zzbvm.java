package com.google.android.libraries.places.internal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzbvm extends zzbbk {
    private final List zza;
    private final AtomicInteger zzb;
    private final int zzc;

    public zzbvm(List list, AtomicInteger atomicInteger) {
        zzmt.zzf(!list.isEmpty(), "empty list");
        this.zza = list;
        this.zzb = atomicInteger;
        Iterator it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((zzbbk) it.next()).hashCode();
        }
        this.zzc = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbvm)) {
            return false;
        }
        zzbvm zzbvmVar = (zzbvm) obj;
        if (zzbvmVar == this) {
            return true;
        }
        return this.zzc == zzbvmVar.zzc && this.zzb == zzbvmVar.zzb && this.zza.size() == zzbvmVar.zza.size() && new HashSet(this.zza).containsAll(zzbvmVar.zza);
    }

    public final int hashCode() {
        return this.zzc;
    }

    public final String toString() {
        zzmm zza = zzmn.zza(zzbvm.class);
        zza.zzd("subchannelPickers", this.zza);
        return zza.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbbk
    public final zzbbe zza(zzbbf zzbbfVar) {
        return ((zzbbk) this.zza.get((this.zzb.getAndIncrement() & Integer.MAX_VALUE) % this.zza.size())).zza(zzbbfVar);
    }
}
