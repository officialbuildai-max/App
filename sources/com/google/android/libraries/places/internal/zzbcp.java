package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import com.cloud.config.utils.XLogUtil;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzbcp {
    private final zzbdo zza;
    private final Object zzb;

    private zzbcp(zzbdo zzbdoVar) {
        this.zzb = null;
        zzmt.zzc(zzbdoVar, NotificationCompat.CATEGORY_STATUS);
        this.zza = zzbdoVar;
        zzmt.zzj(!zzbdoVar.zzl(), "cannot use OK status: %s", zzbdoVar);
    }

    private zzbcp(Object obj) {
        this.zzb = obj;
        this.zza = null;
    }

    public static zzbcp zza(Object obj) {
        return new zzbcp(obj);
    }

    public static zzbcp zzb(zzbdo zzbdoVar) {
        return new zzbcp(zzbdoVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbcp.class == obj.getClass()) {
            zzbcp zzbcpVar = (zzbcp) obj;
            if (zzmo.zza(this.zza, zzbcpVar.zza) && zzmo.zza(this.zzb, zzbcpVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        if (this.zzb != null) {
            zzmm zzb = zzmn.zzb(this);
            zzb.zzd(XLogUtil.TAG, this.zzb);
            return zzb.toString();
        }
        zzmm zzb2 = zzmn.zzb(this);
        zzb2.zzd("error", this.zza);
        return zzb2.toString();
    }

    public final zzbdo zzc() {
        return this.zza;
    }

    public final Object zzd() {
        return this.zzb;
    }
}
