package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzxv extends zzatu implements zzavg {
    private static final zzxv zzb;
    private static volatile zzavn zze;
    private int zzf;
    private long zzg;
    private zzxd zzh;
    private long zzi;
    private int zzj;
    private boolean zzk;

    static {
        zzxv zzxvVar = new zzxv();
        zzb = zzxvVar;
        zzatu.zzaE(zzxv.class, zzxvVar);
    }

    private zzxv() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001စ\u0000\u0002ဉ\u0001\u0003ဂ\u0002\u0004င\u0003\u0005ဇ\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i12 == 3) {
            return new zzxv();
        }
        if (i12 == 4) {
            return new zzxu(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzxv.class) {
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
