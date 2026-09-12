package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbot implements Runnable {
    final /* synthetic */ zzbpo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbot(zzbpo zzbpoVar) {
        this.zza = zzbpoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        zzbft zzbftVar;
        zzbpo zzbpoVar = this.zza;
        z10 = zzbpoVar.zzD;
        if (z10) {
            return;
        }
        zzbftVar = zzbpoVar.zzy;
        zzbftVar.zzg();
    }
}
