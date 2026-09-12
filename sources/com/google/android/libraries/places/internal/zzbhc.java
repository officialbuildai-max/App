package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbhc implements Runnable {
    final /* synthetic */ zzbmk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhc(zzbhg zzbhgVar, zzbmk zzbmkVar) {
        this.zza = zzbmkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        zzbkx zzbkxVar = (zzbkx) this.zza;
        atomicBoolean = zzbkxVar.zza.zzP;
        zzmt.zzp(atomicBoolean.get(), "Channel must have been shut down");
        zzbkxVar.zza.zzQ = true;
        zzbkxVar.zza.zzah(false);
        zzbma.zzQ(zzbkxVar.zza);
    }
}
