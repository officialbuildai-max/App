package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class zzbvi {
    final /* synthetic */ zzbvk zza;
    private final Object zzb;
    private zzbbi zzc;
    private final zzbvg zzd;
    private final zzbbo zze;
    private zzaze zzf;
    private zzbbk zzg;
    private boolean zzh = false;

    public zzbvi(zzbvk zzbvkVar, Object obj, zzbbo zzbboVar, Object obj2, zzbbk zzbbkVar, zzbbi zzbbiVar, boolean z10) {
        this.zza = zzbvkVar;
        this.zzb = obj;
        this.zze = zzbboVar;
        this.zzg = zzbbkVar;
        zzbvg zzbvgVar = new zzbvg(new zzbvh(this));
        this.zzd = zzbvgVar;
        this.zzf = zzaze.CONNECTING;
        this.zzc = null;
        zzbvgVar.zzp(zzbboVar);
    }

    public final String toString() {
        return "Address = " + Arrays.toString(((zzbvj) this.zzb).zza) + ", state = " + String.valueOf(this.zzf) + ", picker type: " + String.valueOf(this.zzg.getClass()) + ", lb: " + String.valueOf(this.zzd.zzg().getClass()) + (true != this.zzh ? "" : ", deactivated");
    }

    public final zzaze zza() {
        return this.zzf;
    }

    public final zzbbk zzb() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbbo zzc() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzh() {
        if (this.zzh) {
            return;
        }
        zzbvk zzbvkVar = this.zza;
        zzbvk.zzj(zzbvkVar).remove(this.zzb);
        this.zzh = true;
        zzbvk.zzk().logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "deactivate", "Child balancer {0} deactivated", this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi(zzbbo zzbboVar) {
        this.zzh = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(zzbbi zzbbiVar) {
        this.zzc = zzbbiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzk() {
        this.zzd.zze();
        this.zzf = zzaze.SHUTDOWN;
        zzbvk.zzk().logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "shutdown", "Child balancer {0} deleted", this.zzb);
    }

    public final boolean zzm() {
        return this.zzh;
    }
}
