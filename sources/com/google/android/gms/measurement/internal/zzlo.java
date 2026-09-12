package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzlo implements Runnable {
    private final /* synthetic */ zzlj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlo(zzlj zzljVar) {
        this.zza = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlk zzlkVar;
        zzlj zzljVar = this.zza;
        zzlkVar = zzljVar.zzh;
        zzljVar.zza = zzlkVar;
    }
}
