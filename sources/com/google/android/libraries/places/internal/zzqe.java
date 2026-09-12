package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzqe extends zzqh {
    private final Map zza;
    private final Map zzb;
    private final zzqg zzc;
    private final zzqf zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqe(zzqc zzqcVar, zzqd zzqdVar) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        HashMap hashMap2 = new HashMap();
        this.zzb = hashMap2;
        hashMap.putAll(zzqc.zzf(zzqcVar));
        hashMap2.putAll(zzqc.zze(zzqcVar));
        this.zzc = zzqc.zzc(zzqcVar);
        this.zzd = zzqc.zzb(zzqcVar);
    }
}
