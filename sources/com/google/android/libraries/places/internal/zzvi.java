package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzvi extends zzatu implements zzavg {
    private static final zzvi zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzauc zzg = zzatu.zzax();
    private zzco zzh;

    static {
        zzvi zzviVar = new zzvi();
        zzb = zzviVar;
        zzatu.zzaE(zzvi.class, zzviVar);
    }

    private zzvi() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzf", "zzg", zzvg.class, "zzh"});
        }
        if (i12 == 3) {
            return new zzvi();
        }
        if (i12 == 4) {
            return new zzvh(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzvi.class) {
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
