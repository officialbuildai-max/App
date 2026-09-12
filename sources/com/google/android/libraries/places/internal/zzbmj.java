package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbmj {
    private final zzbmg zza;
    private final Map zzb;
    private final Map zzc;
    private final zzbpn zzd;
    private final Object zze;
    private final Map zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmj(zzbmg zzbmgVar, Map map, Map map2, zzbpn zzbpnVar, Object obj, Map map3) {
        this.zza = zzbmgVar;
        this.zzb = Collections.unmodifiableMap(new HashMap(map));
        this.zzc = Collections.unmodifiableMap(new HashMap(map2));
        this.zzd = zzbpnVar;
        this.zze = obj;
        this.zzf = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbmj.class == obj.getClass()) {
            zzbmj zzbmjVar = (zzbmj) obj;
            if (zzmo.zza(this.zza, zzbmjVar.zza) && zzmo.zza(this.zzb, zzbmjVar.zzb) && zzmo.zza(this.zzc, zzbmjVar.zzc) && zzmo.zza(this.zzd, zzbmjVar.zzd) && zzmo.zza(this.zze, zzbmjVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("defaultMethodConfig", this.zza);
        zzb.zzd("serviceMethodMap", this.zzb);
        zzb.zzd("serviceMap", this.zzc);
        zzb.zzd("retryThrottling", this.zzd);
        zzb.zzd("loadBalancingConfig", this.zze);
        return zzb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbam zza() {
        if (this.zzc.isEmpty() && this.zzb.isEmpty() && this.zza == null) {
            return null;
        }
        return new zzbmi(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbmg zzb(zzbcl zzbclVar) {
        zzbmg zzbmgVar = (zzbmg) this.zzb.get(zzbclVar.zzf());
        if (zzbmgVar == null) {
            zzbmgVar = (zzbmg) this.zzc.get(zzbclVar.zzg());
        }
        return zzbmgVar == null ? this.zza : zzbmgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbpn zzc() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzd() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map zze() {
        return this.zzf;
    }
}
