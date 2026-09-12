package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbhd implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbhg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhd(zzbhg zzbhgVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbhgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbmk zzbmkVar;
        AtomicBoolean atomicBoolean;
        zzbmkVar = this.zzb.zzh;
        atomicBoolean = ((zzbkx) zzbmkVar).zza.zzP;
        zzmt.zzp(atomicBoolean.get(), "Channel must have been shut down");
    }
}
