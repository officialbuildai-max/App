package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjl implements Runnable {
    final /* synthetic */ zzbkd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjl(zzbkd zzbkdVar) {
        this.zza = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaym zzaymVar;
        this.zza.zzo = null;
        zzaymVar = this.zza.zzi;
        zzaymVar.zza(2, "CONNECTING after backoff");
        zzbkd.zzA(this.zza, zzaze.CONNECTING);
        zzbkd.zzE(this.zza);
    }
}
