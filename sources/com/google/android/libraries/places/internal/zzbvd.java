package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbvd extends zzbbm {
    final /* synthetic */ zzbvg zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvd(zzbvg zzbvgVar) {
        this.zzf = zzbvgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzb(zzbdo zzbdoVar) {
        zzbbd zzbbdVar;
        zzbbdVar = this.zzf.zzh;
        zzbbdVar.zze(zzaze.TRANSIENT_FAILURE, new zzbbc(zzbbe.zzb(zzbdoVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zzc(zzbbi zzbbiVar) {
        throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
    }

    @Override // com.google.android.libraries.places.internal.zzbbm
    public final void zze() {
    }
}
