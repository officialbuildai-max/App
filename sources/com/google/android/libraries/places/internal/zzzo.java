package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzzo extends zzatu implements zzavg {
    private static final zzzo zzb;
    private static volatile zzavn zze;
    private int zzf;
    private String zzg = "";
    private int zzh;
    private int zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private long zzm;
    private boolean zzn;

    static {
        zzzo zzzoVar = new zzzo();
        zzb = zzzoVar;
        zzatu.zzaE(zzzo.class, zzzoVar);
    }

    private zzzo() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003င\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ဂ\u0006\bဇ\u0007", new Object[]{"zzf", "zzg", "zzh", zzaaf.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i12 == 3) {
            return new zzzo();
        }
        if (i12 == 4) {
            return new zzzn(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzzo.class) {
                try {
                    zzavnVar = zze;
                    if (zzavnVar == null) {
                        zzavnVar = new zzatp(zzb);
                        zze = zzavnVar;
                    }
                } finally {
                }
            }
        }
        return zzavnVar;
    }
}
