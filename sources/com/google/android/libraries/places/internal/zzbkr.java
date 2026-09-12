package com.google.android.libraries.places.internal;

import java.util.HashSet;

/* loaded from: classes4.dex */
final class zzbkr extends zzbpo {
    final /* synthetic */ zzbcl zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzayj zzc;
    final /* synthetic */ zzbpp zzd;
    final /* synthetic */ zzbje zze;
    final /* synthetic */ zzazj zzf;
    final /* synthetic */ zzbkt zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbkr(com.google.android.libraries.places.internal.zzbkt r17, com.google.android.libraries.places.internal.zzbcl r18, com.google.android.libraries.places.internal.zzbcf r19, com.google.android.libraries.places.internal.zzayj r20, com.google.android.libraries.places.internal.zzbpp r21, com.google.android.libraries.places.internal.zzbje r22, com.google.android.libraries.places.internal.zzazj r23) {
        /*
            r16 = this;
            r13 = r16
            r0 = r17
            r1 = r20
            r2 = r18
            r13.zza = r2
            r3 = r19
            r13.zzb = r3
            r13.zzc = r1
            r10 = r21
            r13.zzd = r10
            r11 = r22
            r13.zze = r11
            r4 = r23
            r13.zzf = r4
            r13.zzg = r0
            com.google.android.libraries.places.internal.zzbma r4 = r0.zzb
            com.google.android.libraries.places.internal.zzbox r5 = com.google.android.libraries.places.internal.zzbma.zzC(r4)
            long r6 = com.google.android.libraries.places.internal.zzbma.zze(r4)
            long r8 = com.google.android.libraries.places.internal.zzbma.zzd(r4)
            java.util.concurrent.Executor r12 = com.google.android.libraries.places.internal.zzbma.zzJ(r4, r1)
            com.google.android.libraries.places.internal.zzbma r1 = r0.zzb
            com.google.android.libraries.places.internal.zzbfw r1 = com.google.android.libraries.places.internal.zzbma.zzs(r1)
            java.util.concurrent.ScheduledExecutorService r14 = r1.zzb()
            com.google.android.libraries.places.internal.zzbpn r15 = r0.zza
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r5
            r4 = r6
            r6 = r8
            r8 = r12
            r9 = r14
            r12 = r15
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbkr.<init>(com.google.android.libraries.places.internal.zzbkt, com.google.android.libraries.places.internal.zzbcl, com.google.android.libraries.places.internal.zzbcf, com.google.android.libraries.places.internal.zzayj, com.google.android.libraries.places.internal.zzbpp, com.google.android.libraries.places.internal.zzbje, com.google.android.libraries.places.internal.zzazj):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbpo
    final zzbdo zza() {
        zzblz zzblzVar;
        zzblzVar = this.zzg.zzb.zzO;
        synchronized (zzblzVar.zza) {
            try {
                zzbdo zzbdoVar = zzblzVar.zzc;
                if (zzbdoVar != null) {
                    return zzbdoVar;
                }
                zzblzVar.zzb.add(this);
                return null;
            } finally {
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpo
    final zzbfr zzb(zzbcf zzbcfVar, zzayu zzayuVar, int i11, boolean z10) {
        zzbfu zzc;
        zzayj zzf = this.zzc.zzf(zzayuVar);
        zzayx[] zzk = zzbjd.zzk(zzf, zzbcfVar, i11, z10);
        zzc = this.zzg.zzc(new zzbnr(this.zza, zzbcfVar, zzf));
        zzazj zza = this.zzf.zza();
        try {
            return zzc.zza(this.zza, zzbcfVar, zzf, zzk);
        } finally {
            this.zzf.zze(zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzbpo
    public final void zzc() {
        zzblz zzblzVar;
        zzbdo zzbdoVar;
        zzbhg zzbhgVar;
        zzblzVar = this.zzg.zzb.zzO;
        synchronized (zzblzVar.zza) {
            try {
                zzblzVar.zzb.remove(this);
                if (zzblzVar.zzb.isEmpty()) {
                    zzbdoVar = zzblzVar.zzc;
                    zzblzVar.zzb = new HashSet();
                } else {
                    zzbdoVar = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zzbdoVar != null) {
            zzbhgVar = zzblzVar.zzd.zzN;
            zzbhgVar.zzd(zzbdoVar);
        }
    }
}
