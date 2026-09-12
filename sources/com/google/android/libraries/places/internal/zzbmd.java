package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbmd extends zzbbs {
    private static final Method zzp;
    final zzbdb zzc;
    final List zzd;
    final String zze;
    final String zzf;
    final zzazq zzg;
    final zzazd zzh;
    final long zzi;
    final zzbah zzj;
    final zzbqn zzk;
    final zzbqn zzl;
    private final List zzq;
    private final zzbmc zzr;
    private final zzbmb zzs;
    private static final Logger zzm = Logger.getLogger(zzbmd.class.getName());
    static final long zza = TimeUnit.MINUTES.toMillis(30);
    static final long zzb = TimeUnit.SECONDS.toMillis(1);
    private static final zzbqn zzt = zzbqn.zza(zzbjd.zzp);
    private static final zzazq zzn = zzazq.zzb();
    private static final zzazd zzo = zzazd.zza();

    static {
        Method method = null;
        try {
            int i11 = zzbea.f28221a;
            Class cls = Boolean.TYPE;
            method = zzbea.class.getDeclaredMethod("getClientInterceptor", cls, cls, cls, cls);
        } catch (ClassNotFoundException e11) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e11);
        } catch (NoSuchMethodException e12) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e12);
        }
        zzp = method;
    }

    public zzbmd(String str, zzayl zzaylVar, zzayf zzayfVar, zzbmc zzbmcVar, zzbmb zzbmbVar) {
        zzbqn zzbqnVar = zzt;
        this.zzk = zzbqnVar;
        this.zzl = zzbqnVar;
        this.zzq = new ArrayList();
        this.zzc = zzbdb.zzb();
        this.zzd = new ArrayList();
        this.zzf = "pick_first";
        this.zzg = zzn;
        this.zzh = zzo;
        this.zzi = zza;
        this.zzj = zzbah.zza();
        zzmt.zzc(str, "target");
        this.zze = str;
        this.zzr = zzbmcVar;
        this.zzs = zzbmbVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(10:3|4|5|(1:7)|8|9|10|(1:12)|13|14)|36|(0)|8|9|10|(0)|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b3, code lost:
    
        com.google.android.libraries.places.internal.zzbmd.zzm.logp(java.util.logging.Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
    
        com.google.android.libraries.places.internal.zzbmd.zzm.logp(java.util.logging.Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a5, code lost:
    
        com.google.android.libraries.places.internal.zzbmd.zzm.logp(java.util.logging.Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
    
        com.google.android.libraries.places.internal.zzbmd.zzm.logp(java.util.logging.Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0066  */
    @Override // com.google.android.libraries.places.internal.zzbbs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.libraries.places.internal.zzbbr zza() {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbmd.zza():com.google.android.libraries.places.internal.zzbbr");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb() {
        this.zzs.zza();
        return 443;
    }
}
