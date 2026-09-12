package com.google.android.libraries.places.internal;

import com.cloud.tmc.miniapp.bridge.BluetoothBridge;
import com.hisavana.common.tracking.TrackingKey;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class zzbbo extends zzbbb {
    private static final zzbcp zza = zzbcp.zza(new zzbbn());

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("policy", zzd());
        zzb.zzb(TrackingKey.PRIORITY, 5);
        zzb.zze(BluetoothBridge.EXTEA_AVALIABLE, true);
        return zzb.toString();
    }

    public abstract int zzb();

    public zzbcp zzc(Map map) {
        throw null;
    }

    public abstract String zzd();

    public abstract boolean zze();
}
