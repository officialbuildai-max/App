package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbqf {
    private final String zza;
    private final Map zzb;

    public zzbqf(String str, Map map) {
        zzmt.zzc(str, "policyName");
        this.zza = str;
        zzmt.zzc(map, "rawConfigValue");
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbqf) {
            zzbqf zzbqfVar = (zzbqf) obj;
            if (this.zza.equals(zzbqfVar.zza) && this.zzb.equals(zzbqfVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("policyName", this.zza);
        zzb.zzd("rawConfigValue", this.zzb);
        return zzb.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        return this.zzb;
    }
}
