package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzku<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int zza(zzkt<K, V> zzktVar, K k11, V v11) {
        return zzjm.zza(zzktVar.zza, 1, k11) + zzjm.zza(zzktVar.zzc, 2, v11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void zza(zzjc zzjcVar, zzkt<K, V> zzktVar, K k11, V v11) throws IOException {
        zzjm.zza(zzjcVar, zzktVar.zza, 1, k11);
        zzjm.zza(zzjcVar, zzktVar.zzc, 2, v11);
    }
}
