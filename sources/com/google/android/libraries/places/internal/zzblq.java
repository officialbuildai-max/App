package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblq extends zzbgz {
    final zzazj zza;
    final zzbcl zzb;
    final zzayj zzc;
    final /* synthetic */ zzbls zzd;
    private final long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzblq(com.google.android.libraries.places.internal.zzbls r3, com.google.android.libraries.places.internal.zzazj r4, com.google.android.libraries.places.internal.zzbcl r5, com.google.android.libraries.places.internal.zzayj r6) {
        /*
            r2 = this;
            r2.zzd = r3
            com.google.android.libraries.places.internal.zzbma r0 = r3.zza
            java.util.concurrent.Executor r0 = com.google.android.libraries.places.internal.zzbma.zzJ(r0, r6)
            com.google.android.libraries.places.internal.zzbma r3 = r3.zza
            com.google.android.libraries.places.internal.zzblu r3 = com.google.android.libraries.places.internal.zzbma.zzy(r3)
            com.google.android.libraries.places.internal.zzazn r1 = r6.zzi()
            r2.<init>(r0, r3, r1)
            r2.zza = r4
            r2.zzb = r5
            r2.zzc = r6
            long r3 = java.lang.System.nanoTime()
            r2.zze = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzblq.<init>(com.google.android.libraries.places.internal.zzbls, com.google.android.libraries.places.internal.zzazj, com.google.android.libraries.places.internal.zzbcl, com.google.android.libraries.places.internal.zzayj):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbgz
    protected final void zzk() {
        zzblp zzblpVar = new zzblp(this);
        zzbdw zzbdwVar = this.zzd.zza.zzf;
        zzbdwVar.zzc(zzblpVar);
        zzbdwVar.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzl() {
        zzayo zzh;
        zzazj zza = this.zza.zza();
        try {
            zzh = this.zzd.zzh(this.zzb, this.zzc.zze(zzayx.zza, Long.valueOf(System.nanoTime() - this.zze)));
            this.zza.zze(zza);
            Runnable zzh2 = zzh(zzh);
            if (zzh2 != null) {
                zzbls zzblsVar = this.zzd;
                zzbma.zzJ(zzblsVar.zza, this.zzc).execute(new zzblo(this, zzh2));
            } else {
                zzbls zzblsVar2 = this.zzd;
                zzblp zzblpVar = new zzblp(this);
                zzbdw zzbdwVar = zzblsVar2.zza.zzf;
                zzbdwVar.zzc(zzblpVar);
                zzbdwVar.zzb();
            }
        } catch (Throwable th2) {
            this.zza.zze(zza);
            throw th2;
        }
    }
}
