package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbje {
    final int zza;
    final long zzb;
    final Set zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbje(int i11, long j11, Set set) {
        this.zza = i11;
        this.zzb = j11;
        this.zzc = zzob.zzj(set);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbje.class == obj.getClass()) {
            zzbje zzbjeVar = (zzbje) obj;
            if (this.zza == zzbjeVar.zza && this.zzb == zzbjeVar.zzb && zzmo.zza(this.zzc, zzbjeVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzb("maxAttempts", this.zza);
        zzb.zzc("hedgingDelayNanos", this.zzb);
        zzb.zzd("nonFatalStatusCodes", this.zzc);
        return zzb.toString();
    }
}
