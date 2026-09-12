package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzhq implements com.google.android.gms.internal.measurement.zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhq(zzhl zzhlVar, String str) {
        this.zza = str;
        this.zzb = zzhlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map;
        map = this.zzb.zzc;
        Map map2 = (Map) map.get(this.zza);
        if (map2 == null || !map2.containsKey(str)) {
            return null;
        }
        return (String) map2.get(str);
    }
}
