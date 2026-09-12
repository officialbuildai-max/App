package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zznc implements zznd {
    private static final zzhj<Boolean> zza;

    static {
        zzhr zza2 = new zzhr(zzhk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.service.ad_impression.convert_value_to_double", true);
        zza2.zza("measurement.client.ad_impression", true);
        zza2.zza("measurement.service.separate_public_internal_event_blacklisting", true);
        zza2.zza("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznd
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
