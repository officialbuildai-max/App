package com.google.android.libraries.places.internal;

import com.cloud.config.utils.XLogUtil;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzbqg {
    final zzbbo zza;
    final Object zzb;

    public zzbqg(zzbbo zzbboVar, Object obj) {
        this.zza = zzbboVar;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbqg.class == obj.getClass()) {
            zzbqg zzbqgVar = (zzbqg) obj;
            if (zzmo.zza(this.zza, zzbqgVar.zza) && zzmo.zza(this.zzb, zzbqgVar.zzb)) {
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
        zzb.zzd("provider", this.zza);
        zzb.zzd(XLogUtil.TAG, this.zzb);
        return zzb.toString();
    }
}
