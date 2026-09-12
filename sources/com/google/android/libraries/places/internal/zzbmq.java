package com.google.android.libraries.places.internal;

import java.io.Closeable;

/* loaded from: classes4.dex */
public final class zzbmq implements Closeable, zzbgj {
    private zzbmm zza;
    private int zzb;
    private final zzbqo zzc;
    private final zzbqz zzd;
    private zzazo zze;
    private boolean zzg;
    private zzbge zzh;
    private long zzj;
    private int zzm;
    private int zzp = 1;
    private int zzf = 5;
    private zzbge zzi = new zzbge();
    private boolean zzk = false;
    private int zzl = -1;
    private boolean zzn = false;
    private volatile boolean zzo = false;

    public zzbmq(zzbmm zzbmmVar, zzazo zzazoVar, int i11, zzbqo zzbqoVar, zzbqz zzbqzVar) {
        this.zza = zzbmmVar;
        this.zze = zzazoVar;
        this.zzb = i11;
        this.zzc = zzbqoVar;
        this.zzd = zzbqzVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x01b3, code lost:
    
        if (r12.zzn == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01b9, code lost:
    
        if (zzi() == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x01bb, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01c0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        if (r3 <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        r12.zza.zzE(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        if (r12.zzp != 2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
    
        r12.zzc.zzh(r3);
        r12.zzm += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        r3 = r12.zzp;
        r4 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
    
        if (r3 == 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        if (r4 == 0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0118, code lost:
    
        r3 = r12.zzh.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0120, code lost:
    
        if ((r3 & 254) != 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0123, code lost:
    
        if (1 == (r3 & 1)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0125, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0128, code lost:
    
        r12.zzg = r3;
        r3 = r12.zzh;
        r3.zza(4);
        r3 = r3.zze() | (((r3.zze() << 24) | (r3.zze() << 16)) | (r3.zze() << 8));
        r12.zzf = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x014b, code lost:
    
        if (r3 < 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014f, code lost:
    
        if (r3 > r12.zzb) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0151, code lost:
    
        r3 = r12.zzl + 1;
        r12.zzl = r3;
        r12.zzc.zze(r3);
        r12.zzd.zzc();
        r12.zzp = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0189, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbdq(com.google.android.libraries.places.internal.zzbdo.zzj.zzg(java.lang.String.format(java.util.Locale.US, "gRPC message exceeds maximum size %d: %d", java.lang.Integer.valueOf(r12.zzb), java.lang.Integer.valueOf(r12.zzf))), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0127, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0197, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbdq(com.google.android.libraries.places.internal.zzbdo.zzo.zzg("gRPC frame header malformed: reserved bits not zero"), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0089, code lost:
    
        if (r4 == 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a9, code lost:
    
        r12.zzc.zzf(r12.zzl, r12.zzm, -1);
        r12.zzm = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        if (r12.zzg == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00bb, code lost:
    
        r3 = r12.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bf, code lost:
    
        if (r3 == com.google.android.libraries.places.internal.zzaza.zza) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c1, code lost:
    
        r4 = new com.google.android.libraries.places.internal.zzbmp(r3.zza(new com.google.android.libraries.places.internal.zzbnw(r12.zzh)), r12.zzb, r12.zzc);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fe, code lost:
    
        r12.zzh = null;
        r12.zza.zzr(new com.google.android.libraries.places.internal.zzbmo(r4, null));
        r12.zzp = 1;
        r12.zzf = 5;
        r12.zzj--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00dc, code lost:
    
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ea, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbdq(com.google.android.libraries.places.internal.zzbdo.zzo.zzg("Can't decode compressed gRPC message as compression not configured"), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00eb, code lost:
    
        r12.zzc.zzg(r12.zzh.zzf());
        r4 = new com.google.android.libraries.places.internal.zzbnw(r12.zzh);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x008d, code lost:
    
        if (r3 == 1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x008f, code lost:
    
        r2 = "BODY";
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00a8, code lost:
    
        throw new java.lang.AssertionError("Invalid state: " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0092, code lost:
    
        r2 = "HEADER";
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0198, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzh() {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbmq.zzh():void");
    }

    private final boolean zzi() {
        return this.zzi.zzf() == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbgj
    public final void close() {
        if (zzg()) {
            return;
        }
        zzbge zzbgeVar = this.zzh;
        boolean z10 = false;
        if (zzbgeVar != null && zzbgeVar.zzf() > 0) {
            z10 = true;
        }
        try {
            zzbge zzbgeVar2 = this.zzi;
            if (zzbgeVar2 != null) {
                zzbgeVar2.close();
            }
            zzbge zzbgeVar3 = this.zzh;
            if (zzbgeVar3 != null) {
                zzbgeVar3.close();
            }
            this.zzi = null;
            this.zzh = null;
            this.zza.zze(z10);
        } catch (Throwable th2) {
            this.zzi = null;
            this.zzh = null;
            throw th2;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zza() {
        if (zzg()) {
            return;
        }
        if (zzi()) {
            close();
        } else {
            this.zzn = true;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zzb(zzbnv zzbnvVar) {
        boolean z10 = true;
        try {
            if (!zzg() && !this.zzn) {
                this.zzi.zzh(zzbnvVar);
                try {
                    zzh();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    z10 = false;
                    if (z10) {
                        zzbnvVar.close();
                    }
                    throw th;
                }
            }
            zzbnvVar.close();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zzc(int i11) {
        if (zzg()) {
            return;
        }
        this.zzj += 2;
        zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zzd(zzazo zzazoVar) {
        this.zze = zzazoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zze(int i11) {
        this.zzb = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(zzbmm zzbmmVar) {
        this.zza = zzbmmVar;
    }

    public final boolean zzg() {
        return this.zzi == null;
    }
}
