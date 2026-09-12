package com.google.android.libraries.places.internal;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbnc implements zzbbl {
    final /* synthetic */ zzbnj zza;
    private zzazf zzb = zzazf.zzb(zzaze.IDLE);
    private zzbni zzc;

    public /* synthetic */ zzbnc(zzbnj zzbnjVar, zzbnb zzbnbVar) {
        this.zza = zzbnjVar;
    }

    public static /* bridge */ /* synthetic */ zzazf zzb(zzbnc zzbncVar) {
        return zzbncVar.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbbl
    public final void zza(zzazf zzazfVar) {
        Logger logger;
        zzbbj zzbbjVar;
        Logger logger2;
        Map map;
        zzbnd zzbndVar;
        zzbnc zzbncVar;
        logger = zzbnj.zzf;
        Level level = Level.FINE;
        zzbbjVar = this.zzc.zza;
        logger.logp(level, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Received health status {0} for subchannel {1}", new Object[]{zzazfVar, zzbbjVar});
        this.zzb = zzazfVar;
        try {
            zzbnj zzbnjVar = this.zza;
            map = zzbnjVar.zzh;
            zzbndVar = zzbnjVar.zzi;
            zzbni zzbniVar = (zzbni) map.get(zzbndVar.zzc());
            if (zzbniVar != null) {
                zzbncVar = zzbniVar.zzc;
                if (zzbncVar == this) {
                    this.zza.zzq(this.zzc);
                }
            }
        } catch (IllegalStateException unused) {
            logger2 = zzbnj.zzf;
            logger2.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Health listener received state change after subchannel was removed");
        }
    }
}
