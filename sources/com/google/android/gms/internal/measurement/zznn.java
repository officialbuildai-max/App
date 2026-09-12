package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zznn implements zznk {
    private static final zzhj<Long> zza;

    static {
        zzhr zza2 = new zzhr(zzhk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.client.consent_state_v1", true);
        zza2.zza("measurement.client.3p_consent_state_v1", true);
        zza2.zza("measurement.service.consent_state_v1_W36", true);
        zza = zza2.zza("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final long zza() {
        return zza.zza().longValue();
    }
}
