package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzalf extends zzatu implements zzavg {
    private static final zzalf zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private int zzh = 1;
    private int zzi;
    private int zzj;

    static {
        zzalf zzalfVar = new zzalf();
        zzb = zzalfVar;
        zzatu.zzaE(zzalf.class, zzalfVar);
    }

    private zzalf() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzf", "zzg", zzald.zza, "zzh", zzale.zza, "zzi", "zzj"});
        }
        if (i12 == 3) {
            return new zzalf();
        }
        if (i12 == 4) {
            return new zzalc(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzalf.class) {
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
