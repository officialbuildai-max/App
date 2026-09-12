package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjm implements Runnable {
    final /* synthetic */ zzbkd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjm(zzbkd zzbkdVar) {
        this.zza = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzazf zzazfVar;
        zzaym zzaymVar;
        zzazfVar = this.zza.zzv;
        if (zzazfVar.zza() == zzaze.IDLE) {
            zzaymVar = this.zza.zzi;
            zzaymVar.zza(2, "CONNECTING as requested");
            zzbkd.zzA(this.zza, zzaze.CONNECTING);
            zzbkd.zzE(this.zza);
        }
    }
}
