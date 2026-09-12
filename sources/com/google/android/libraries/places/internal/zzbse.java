package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbse implements Runnable, zzbtq {
    final zzbtr zza;
    final /* synthetic */ zzbsf zzc;
    private final zzbsi zzd = new zzbsi(Level.FINE, zzbsf.class);
    boolean zzb = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbse(zzbsf zzbsfVar, zzbtr zzbtrVar) {
        this.zzc = zzbsfVar;
        this.zza = zzbtrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger;
        zzbmk zzbmkVar;
        Logger logger2;
        zzbmk zzbmkVar2;
        Object obj;
        zzbdo zzbdoVar;
        zzbkh zzbkhVar;
        zzbkh zzbkhVar2;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpClientTransport");
        while (this.zza.zza(this)) {
            try {
                zzbsf zzbsfVar = this.zzc;
                zzbkhVar = zzbsfVar.zzK;
                if (zzbkhVar != null) {
                    zzbkhVar2 = zzbsfVar.zzK;
                    zzbkhVar2.zza();
                }
            } catch (Throwable th2) {
                try {
                    this.zzc.zzaa(0, zzbtp.PROTOCOL_ERROR, zzbdo.zzo.zzg("error in frame handler").zzf(th2));
                } catch (Throwable th3) {
                    try {
                        this.zza.close();
                    } catch (IOException e11) {
                        logger = zzbsf.zzd;
                        logger.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e11);
                    } catch (RuntimeException e12) {
                        if (!"bio == null".equals(e12.getMessage())) {
                            throw e12;
                        }
                    }
                    zzbmkVar = this.zzc.zzl;
                    zzbmkVar.zze();
                    Thread.currentThread().setName(name);
                    throw th3;
                }
            }
        }
        obj = this.zzc.zzo;
        synchronized (obj) {
            zzbdoVar = this.zzc.zzz;
        }
        if (zzbdoVar == null) {
            zzbdoVar = zzbdo.zzp.zzg("End of stream or IOException");
        }
        this.zzc.zzaa(0, zzbtp.INTERNAL_ERROR, zzbdoVar);
        try {
            this.zza.close();
        } catch (IOException e13) {
            logger2 = zzbsf.zzd;
            logger2.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e13);
        } catch (RuntimeException e14) {
            if (!"bio == null".equals(e14.getMessage())) {
                throw e14;
            }
        }
        zzbmkVar2 = this.zzc.zzl;
        zzbmkVar2.zze();
        Thread.currentThread().setName(name);
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zza(boolean z10, int i11, zzbwd zzbwdVar, int i12, int i13) throws IOException {
        Object obj;
        int i14;
        int i15;
        int i16;
        Object obj2;
        zzbrk zzbrkVar;
        int i17;
        Object obj3;
        zzbrk zzbrkVar2;
        this.zzd.zza(1, i11, ((zzbwl) zzbwdVar).zzb, i12, z10);
        zzbry zzr = this.zzc.zzr(i11);
        if (zzr != null) {
            long j11 = i12;
            zzbwdVar.zzD(j11);
            zzbwb zzbwbVar = new zzbwb();
            zzbwbVar.zzn(((zzbwl) zzbwdVar).zzb, j11);
            zzr.zzD().zzI();
            int i18 = zzbvr.zza;
            obj = this.zzc.zzo;
            synchronized (obj) {
                zzr.zzD().zzO(zzbwbVar, z10, i13 - i12);
            }
        } else {
            if (!this.zzc.zzU(i11)) {
                this.zzc.zzaa(0, r10, zzbsf.zzm(zzbtp.PROTOCOL_ERROR).zzc("Received data for unknown stream: " + i11));
                return;
            }
            obj3 = this.zzc.zzo;
            synchronized (obj3) {
                zzbrkVar2 = this.zzc.zzm;
                zzbrkVar2.zzc(i11, zzbtp.STREAM_CLOSED);
            }
            zzbwdVar.zzF(i12);
        }
        zzbsf zzbsfVar = this.zzc;
        i14 = zzbsfVar.zzw;
        zzbsfVar.zzw = i14 + i13;
        zzbsf zzbsfVar2 = this.zzc;
        i15 = zzbsfVar2.zzw;
        float f11 = i15;
        i16 = zzbsfVar2.zzj;
        if (f11 >= i16 * 0.5f) {
            obj2 = zzbsfVar2.zzo;
            synchronized (obj2) {
                zzbsf zzbsfVar3 = this.zzc;
                zzbrkVar = zzbsfVar3.zzm;
                i17 = zzbsfVar3.zzw;
                zzbrkVar.zzk(0, i17);
            }
            this.zzc.zzw = 0;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzb(int i11, zzbtp zzbtpVar, zzbwf zzbwfVar) {
        Logger logger;
        Runnable runnable;
        this.zzd.zzb(1, i11, zzbtpVar, zzbwfVar);
        if (zzbtpVar == zzbtp.ENHANCE_YOUR_CALM) {
            String zzf = zzbwfVar.zzf();
            logger = zzbsf.zzd;
            logger.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "goAway", String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, zzf));
            if ("too_many_pings".equals(zzf)) {
                runnable = this.zzc.zzL;
                ((zzbrs) runnable).zza.zza();
            }
        }
        zzbdo zzc = zzbjb.zza(zzbtpVar.zzs).zzc("Received Goaway");
        if (zzbwfVar.zzc() > 0) {
            zzc = zzc.zzc(zzbwfVar.zzf());
        }
        this.zzc.zzaa(i11, null, zzc);
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzc(boolean z10, int i11, int i12) {
        Object obj;
        zzbjh zzbjhVar;
        zzbjh zzbjhVar2;
        Logger logger;
        zzbjh zzbjhVar3;
        Logger logger2;
        zzbjh zzbjhVar4;
        zzbjh zzbjhVar5;
        Object obj2;
        zzbrk zzbrkVar;
        long j11 = (i11 << 32) | (i12 & 4294967295L);
        this.zzd.zzd(1, j11);
        if (!z10) {
            obj2 = this.zzc.zzo;
            synchronized (obj2) {
                zzbrkVar = this.zzc.zzm;
                zzbrkVar.zzb(true, i11, i12);
            }
            return;
        }
        obj = this.zzc.zzo;
        synchronized (obj) {
            try {
                zzbsf zzbsfVar = this.zzc;
                zzbjhVar = zzbsfVar.zzB;
                zzbjhVar2 = null;
                if (zzbjhVar != null) {
                    zzbjhVar3 = zzbsfVar.zzB;
                    if (zzbjhVar3.zza() == j11) {
                        zzbsf zzbsfVar2 = this.zzc;
                        zzbjhVar5 = zzbsfVar2.zzB;
                        zzbsfVar2.zzB = null;
                        zzbjhVar2 = zzbjhVar5;
                    } else {
                        logger2 = zzbsf.zzd;
                        Level level = Level.WARNING;
                        Locale locale = Locale.US;
                        zzbjhVar4 = this.zzc.zzB;
                        logger2.logp(level, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", String.format(locale, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(zzbjhVar4.zza()), Long.valueOf(j11)));
                    }
                } else {
                    logger = zzbsf.zzd;
                    logger.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", "Received unexpected ping ack. No ping outstanding");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zzbjhVar2 != null) {
            zzbjhVar2.zzc();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzd(int i11, int i12, List list) throws IOException {
        Object obj;
        zzbrk zzbrkVar;
        this.zzd.zzf(1, i11, i12, list);
        obj = this.zzc.zzo;
        synchronized (obj) {
            zzbrkVar = this.zzc.zzm;
            zzbrkVar.zzc(i11, zzbtp.PROTOCOL_ERROR);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zze(int i11, zzbtp zzbtpVar) {
        Object obj;
        Map map;
        boolean z10 = true;
        this.zzd.zzg(1, i11, zzbtpVar);
        zzbdo zzc = zzbsf.zzm(zzbtpVar).zzc("Rst Stream");
        if (zzc.zza() != zzbdj.CANCELLED && zzc.zza() != zzbdj.DEADLINE_EXCEEDED) {
            z10 = false;
        }
        boolean z11 = z10;
        obj = this.zzc.zzo;
        synchronized (obj) {
            try {
                map = this.zzc.zzr;
                zzbry zzbryVar = (zzbry) map.get(Integer.valueOf(i11));
                if (zzbryVar != null) {
                    zzbryVar.zzD().zzI();
                    int i12 = zzbvr.zza;
                    this.zzc.zzP(i11, zzc, zzbtpVar == zzbtp.REFUSED_STREAM ? zzbfs.REFUSED : zzbfs.PROCESSED, z11, null, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzf(boolean z10, zzbue zzbueVar) {
        Object obj;
        boolean z11;
        zzbrk zzbrkVar;
        zzbsu zzbsuVar;
        zzbmk zzbmkVar;
        zzaye zzayeVar;
        zzbmk zzbmkVar2;
        zzbsu zzbsuVar2;
        this.zzd.zzh(1, zzbueVar);
        obj = this.zzc.zzo;
        synchronized (obj) {
            try {
                if (zzbueVar.zzf(4)) {
                    this.zzc.zzH = zzbueVar.zza(4);
                }
                if (zzbueVar.zzf(7)) {
                    int zza = zzbueVar.zza(7);
                    zzbsuVar2 = this.zzc.zzn;
                    z11 = zzbsuVar2.zzh(zza);
                } else {
                    z11 = false;
                }
                if (this.zzb) {
                    zzbsf zzbsfVar = this.zzc;
                    zzbmkVar = zzbsfVar.zzl;
                    zzayeVar = zzbsfVar.zzy;
                    zzbmkVar.zza(zzayeVar);
                    zzbsfVar.zzy = zzayeVar;
                    zzbmkVar2 = this.zzc.zzl;
                    zzbmkVar2.zzc();
                    this.zzb = false;
                }
                zzbrkVar = this.zzc.zzm;
                zzbrkVar.zza(zzbueVar);
                if (z11) {
                    zzbsuVar = this.zzc.zzn;
                    zzbsuVar.zzg();
                }
                this.zzc.zzad();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r4.zzc.zzU(r5) == false) goto L16;
     */
    @Override // com.google.android.libraries.places.internal.zzbtq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(int r5, long r6) {
        /*
            r4 = this;
            com.google.android.libraries.places.internal.zzbsi r0 = r4.zzd
            r1 = 1
            r0.zzj(r1, r5, r6)
            com.google.android.libraries.places.internal.zzbsf r0 = r4.zzc
            java.lang.Object r0 = com.google.android.libraries.places.internal.zzbsf.zzw(r0)
            monitor-enter(r0)
            if (r5 != 0) goto L1e
            com.google.android.libraries.places.internal.zzbsf r5 = r4.zzc     // Catch: java.lang.Throwable -> L1c
            com.google.android.libraries.places.internal.zzbsu r5 = com.google.android.libraries.places.internal.zzbsf.zzt(r5)     // Catch: java.lang.Throwable -> L1c
            r1 = 0
            int r6 = (int) r6     // Catch: java.lang.Throwable -> L1c
            r5.zza(r1, r6)     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            return
        L1c:
            r5 = move-exception
            goto L69
        L1e:
            com.google.android.libraries.places.internal.zzbsf r2 = r4.zzc     // Catch: java.lang.Throwable -> L1c
            java.util.Map r2 = com.google.android.libraries.places.internal.zzbsf.zzB(r2)     // Catch: java.lang.Throwable -> L1c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L1c
            com.google.android.libraries.places.internal.zzbry r2 = (com.google.android.libraries.places.internal.zzbry) r2     // Catch: java.lang.Throwable -> L1c
            r3 = 0
            if (r2 == 0) goto L45
            com.google.android.libraries.places.internal.zzbsf r1 = r4.zzc     // Catch: java.lang.Throwable -> L1c
            com.google.android.libraries.places.internal.zzbsu r1 = com.google.android.libraries.places.internal.zzbsf.zzt(r1)     // Catch: java.lang.Throwable -> L1c
            com.google.android.libraries.places.internal.zzbrx r2 = r2.zzD()     // Catch: java.lang.Throwable -> L1c
            com.google.android.libraries.places.internal.zzbsq r2 = r2.zzH()     // Catch: java.lang.Throwable -> L1c
            int r6 = (int) r6     // Catch: java.lang.Throwable -> L1c
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L1c
        L43:
            r1 = r3
            goto L4d
        L45:
            com.google.android.libraries.places.internal.zzbsf r6 = r4.zzc     // Catch: java.lang.Throwable -> L1c
            boolean r6 = r6.zzU(r5)     // Catch: java.lang.Throwable -> L1c
            if (r6 != 0) goto L43
        L4d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L68
            com.google.android.libraries.places.internal.zzbsf r6 = r4.zzc
            com.google.android.libraries.places.internal.zzbtp r7 = com.google.android.libraries.places.internal.zzbtp.PROTOCOL_ERROR
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Received window_update for unknown stream: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.google.android.libraries.places.internal.zzbsf.zzN(r6, r7, r5)
        L68:
            return
        L69:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbse.zzg(int, long):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzh(boolean z10, boolean z11, int i11, int i12, List list, int i13) {
        int i14;
        Object obj;
        Map map;
        zzbrk zzbrkVar;
        zzbrk zzbrkVar2;
        int i15;
        int i16;
        boolean z12 = true;
        this.zzd.zzc(1, i11, list, z11);
        i14 = this.zzc.zzM;
        zzbdo zzbdoVar = null;
        if (i14 != Integer.MAX_VALUE) {
            long j11 = 0;
            for (int i17 = 0; i17 < list.size(); i17++) {
                zzbtt zzbttVar = (zzbtt) list.get(i17);
                j11 += zzbttVar.zzh.zzc() + 32 + zzbttVar.zzi.zzc();
            }
            int min = (int) Math.min(j11, 2147483647L);
            i15 = this.zzc.zzM;
            if (min > i15) {
                zzbdo zzbdoVar2 = zzbdo.zzj;
                Locale locale = Locale.US;
                String str = true != z11 ? "header" : "trailer";
                i16 = this.zzc.zzM;
                zzbdoVar = zzbdoVar2.zzg(String.format(locale, "Response %s metadata larger than %d: %d", str, Integer.valueOf(i16), Integer.valueOf(min)));
            }
        }
        obj = this.zzc.zzo;
        synchronized (obj) {
            try {
                map = this.zzc.zzr;
                zzbry zzbryVar = (zzbry) map.get(Integer.valueOf(i11));
                if (zzbryVar == null) {
                    if (this.zzc.zzU(i11)) {
                        zzbrkVar2 = this.zzc.zzm;
                        zzbrkVar2.zzc(i11, zzbtp.STREAM_CLOSED);
                    }
                } else if (zzbdoVar == null) {
                    zzbryVar.zzD().zzI();
                    int i18 = zzbvr.zza;
                    zzbryVar.zzD().zzP(list, z11);
                } else {
                    if (!z11) {
                        zzbrkVar = this.zzc.zzm;
                        zzbrkVar.zzc(i11, zzbtp.CANCEL);
                    }
                    zzbryVar.zzD().zzj(zzbdoVar, zzbfs.PROCESSED, false, new zzbcf());
                }
                z12 = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z12) {
            this.zzc.zzaa(0, r8, zzbsf.zzm(zzbtp.PROTOCOL_ERROR).zzc("Received header for unknown stream: " + i11));
        }
    }
}
