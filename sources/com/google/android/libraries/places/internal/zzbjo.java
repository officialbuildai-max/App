package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbjo implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ zzbkd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjo(zzbkd zzbkdVar, List list) {
        this.zza = list;
        this.zzb = zzbkdVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0037, code lost:
    
        if (r1.zza() == com.google.android.libraries.places.internal.zzaze.CONNECTING) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0095  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbjx r0 = com.google.android.libraries.places.internal.zzbkd.zzl(r0)
            java.net.SocketAddress r0 = r0.zzb()
            com.google.android.libraries.places.internal.zzbkd r1 = r7.zzb
            com.google.android.libraries.places.internal.zzbjx r1 = com.google.android.libraries.places.internal.zzbkd.zzl(r1)
            java.util.List r2 = r7.zza
            r1.zze(r2)
            com.google.android.libraries.places.internal.zzbkd r1 = r7.zzb
            java.util.List r2 = r7.zza
            com.google.android.libraries.places.internal.zzbkd.zzt(r1, r2)
            com.google.android.libraries.places.internal.zzbkd r1 = r7.zzb
            com.google.android.libraries.places.internal.zzazf r1 = com.google.android.libraries.places.internal.zzbkd.zzb(r1)
            com.google.android.libraries.places.internal.zzaze r1 = r1.zza()
            com.google.android.libraries.places.internal.zzaze r2 = com.google.android.libraries.places.internal.zzaze.READY
            r3 = 0
            if (r1 == r2) goto L3c
            com.google.android.libraries.places.internal.zzbkd r1 = r7.zzb
            com.google.android.libraries.places.internal.zzazf r1 = com.google.android.libraries.places.internal.zzbkd.zzb(r1)
            com.google.android.libraries.places.internal.zzaze r1 = r1.zza()
            com.google.android.libraries.places.internal.zzaze r4 = com.google.android.libraries.places.internal.zzaze.CONNECTING
            if (r1 != r4) goto L3a
            goto L3c
        L3a:
            r1 = r3
            goto L93
        L3c:
            com.google.android.libraries.places.internal.zzbkd r1 = r7.zzb
            com.google.android.libraries.places.internal.zzbjx r1 = com.google.android.libraries.places.internal.zzbkd.zzl(r1)
            boolean r0 = r1.zzh(r0)
            if (r0 != 0) goto L3a
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzazf r0 = com.google.android.libraries.places.internal.zzbkd.zzb(r0)
            com.google.android.libraries.places.internal.zzaze r0 = r0.zza()
            if (r0 != r2) goto L6e
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbml r1 = com.google.android.libraries.places.internal.zzbkd.zzm(r0)
            com.google.android.libraries.places.internal.zzbkd.zzs(r0, r3)
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbjx r0 = com.google.android.libraries.places.internal.zzbkd.zzl(r0)
            r0.zzd()
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzaze r2 = com.google.android.libraries.places.internal.zzaze.IDLE
            com.google.android.libraries.places.internal.zzbkd.zzA(r0, r2)
            goto L93
        L6e:
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbgf r0 = com.google.android.libraries.places.internal.zzbkd.zzi(r0)
            com.google.android.libraries.places.internal.zzbdo r1 = com.google.android.libraries.places.internal.zzbdo.zzp
            java.lang.String r2 = "InternalSubchannel closed pending transport due to address change"
            com.google.android.libraries.places.internal.zzbdo r1 = r1.zzg(r2)
            r0.zzd(r1)
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbkd.zzu(r0, r3)
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbjx r0 = com.google.android.libraries.places.internal.zzbkd.zzl(r0)
            r0.zzd()
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbkd.zzE(r0)
            goto L3a
        L93:
            if (r1 == 0) goto Lde
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbdv r2 = com.google.android.libraries.places.internal.zzbkd.zzf(r0)
            if (r2 == 0) goto Lbf
            com.google.android.libraries.places.internal.zzbml r0 = com.google.android.libraries.places.internal.zzbkd.zzn(r0)
            com.google.android.libraries.places.internal.zzbdo r2 = com.google.android.libraries.places.internal.zzbdo.zzp
            java.lang.String r4 = "InternalSubchannel closed transport early due to address change"
            com.google.android.libraries.places.internal.zzbdo r2 = r2.zzg(r4)
            r0.zzd(r2)
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbdv r0 = com.google.android.libraries.places.internal.zzbkd.zzf(r0)
            r0.zza()
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbkd.zzw(r0, r3)
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbkd.zzx(r0, r3)
        Lbf:
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbkd.zzx(r0, r1)
            com.google.android.libraries.places.internal.zzbkd r0 = r7.zzb
            com.google.android.libraries.places.internal.zzbdw r1 = com.google.android.libraries.places.internal.zzbkd.zzg(r0)
            com.google.android.libraries.places.internal.zzbjn r2 = new com.google.android.libraries.places.internal.zzbjn
            r2.<init>(r7)
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.ScheduledExecutorService r6 = com.google.android.libraries.places.internal.zzbkd.zzr(r0)
            r3 = 5
            com.google.android.libraries.places.internal.zzbdv r1 = r1.zza(r2, r3, r5, r6)
            com.google.android.libraries.places.internal.zzbkd.zzw(r0, r1)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbjo.run():void");
    }
}
