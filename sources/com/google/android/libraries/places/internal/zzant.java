package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzant extends zzatu implements zzavg {
    private static final zzant zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private zzaxv zzh;
    private zzawl zzi;

    static {
        zzant zzantVar = new zzant();
        zzb = zzantVar;
        zzatu.zzaE(zzant.class, zzantVar);
    }

    private zzant() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i12 == 3) {
            return new zzant();
        }
        if (i12 == 4) {
            return new zzans(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzant.class) {
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
