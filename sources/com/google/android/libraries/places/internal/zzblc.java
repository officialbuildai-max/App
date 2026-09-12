package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblc implements Runnable {
    final /* synthetic */ zzbma zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzblc(zzbma zzbmaVar, zzblb zzblbVar) {
        this.zza = zzbmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzblg zzblgVar;
        zzbma zzbmaVar = this.zza;
        zzblgVar = zzbmaVar.zzG;
        if (zzblgVar == null) {
            return;
        }
        zzbma.zzP(zzbmaVar);
    }
}
