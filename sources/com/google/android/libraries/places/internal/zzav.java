package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzav extends zzatu implements zzavg {
    private static final zzav zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzco zzg;
    private zzai zzh;

    static {
        zzav zzavVar = new zzav();
        zzb = zzavVar;
        zzatu.zzaE(zzav.class, zzavVar);
    }

    private zzav() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0001\u0002ဉ\u0000", new Object[]{"zzf", "zzh", "zzg"});
        }
        if (i12 == 3) {
            return new zzav();
        }
        if (i12 == 4) {
            return new zzau(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzav.class) {
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
