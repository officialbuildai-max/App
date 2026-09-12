package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzbmg {
    static final zzayh zza = zzayh.zza("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
    final Long zzb;
    final Boolean zzc;
    final Integer zzd;
    final Integer zze;
    final zzbpp zzf;
    final zzbje zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmg(Map map, boolean z10, int i11, int i12) {
        zzbpp zzbppVar;
        zzbje zzbjeVar;
        this.zzb = zzbkg.zzd(map, "timeout");
        this.zzc = zzbkg.zza(map, "waitForReady");
        Integer zzc = zzbkg.zzc(map, "maxResponseMessageBytes");
        this.zzd = zzc;
        if (zzc != null) {
            zzmt.zzj(zzc.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", zzc);
        }
        Integer zzc2 = zzbkg.zzc(map, "maxRequestMessageBytes");
        this.zze = zzc2;
        if (zzc2 != null) {
            zzmt.zzj(zzc2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", zzc2);
        }
        Map zzj = z10 ? zzbkg.zzj(map, "retryPolicy") : null;
        if (zzj == null) {
            zzbppVar = null;
        } else {
            Integer zzc3 = zzbkg.zzc(zzj, "maxAttempts");
            zzmt.zzc(zzc3, "maxAttempts cannot be empty");
            int intValue = zzc3.intValue();
            zzmt.zzh(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, 5);
            Long zzd = zzbkg.zzd(zzj, "initialBackoff");
            zzmt.zzc(zzd, "initialBackoff cannot be empty");
            long longValue = zzd.longValue();
            zzmt.zzi(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            Long zzd2 = zzbkg.zzd(zzj, "maxBackoff");
            zzmt.zzc(zzd2, "maxBackoff cannot be empty");
            long longValue2 = zzd2.longValue();
            zzmt.zzi(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            Double zzb = zzbkg.zzb(zzj, "backoffMultiplier");
            zzmt.zzc(zzb, "backoffMultiplier cannot be empty");
            double doubleValue = zzb.doubleValue();
            zzmt.zzj(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", zzb);
            Long zzd3 = zzbkg.zzd(zzj, "perAttemptRecvTimeout");
            zzmt.zzj(zzd3 == null || zzd3.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", zzd3);
            Set zzb2 = zzbqh.zzb(zzj);
            zzmt.zzf((zzd3 == null && zzb2.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            zzbppVar = new zzbpp(min, longValue, longValue2, doubleValue, zzd3, zzb2);
        }
        this.zzf = zzbppVar;
        Map zzj2 = z10 ? zzbkg.zzj(map, "hedgingPolicy") : null;
        if (zzj2 == null) {
            zzbjeVar = null;
        } else {
            Integer zzc4 = zzbkg.zzc(zzj2, "maxAttempts");
            zzmt.zzc(zzc4, "maxAttempts cannot be empty");
            int intValue2 = zzc4.intValue();
            zzmt.zzh(intValue2 >= 2, "maxAttempts must be greater than 1: %s", intValue2);
            int min2 = Math.min(intValue2, 5);
            Long zzd4 = zzbkg.zzd(zzj2, "hedgingDelay");
            zzmt.zzc(zzd4, "hedgingDelay cannot be empty");
            long longValue3 = zzd4.longValue();
            zzmt.zzi(longValue3 >= 0, "hedgingDelay must not be negative: %s", longValue3);
            zzbjeVar = new zzbje(min2, longValue3, zzbqh.zza(zzj2));
        }
        this.zzg = zzbjeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbmg)) {
            return false;
        }
        zzbmg zzbmgVar = (zzbmg) obj;
        return zzmo.zza(this.zzb, zzbmgVar.zzb) && zzmo.zza(this.zzc, zzbmgVar.zzc) && zzmo.zza(this.zzd, zzbmgVar.zzd) && zzmo.zza(this.zze, zzbmgVar.zze) && zzmo.zza(this.zzf, zzbmgVar.zzf) && zzmo.zza(this.zzg, zzbmgVar.zzg);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg});
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("timeoutNanos", this.zzb);
        zzb.zzd("waitForReady", this.zzc);
        zzb.zzd("maxInboundMessageSize", this.zzd);
        zzb.zzd("maxOutboundMessageSize", this.zze);
        zzb.zzd("retryPolicy", this.zzf);
        zzb.zzd("hedgingPolicy", this.zzg);
        return zzb.toString();
    }
}
