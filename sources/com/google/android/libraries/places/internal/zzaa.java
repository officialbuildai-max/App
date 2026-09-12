package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaa extends zzatu implements zzavg {
    private static final zzaa zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzcd zzg;

    static {
        zzaa zzaaVar = new zzaa();
        zzb = zzaaVar;
        zzatu.zzaE(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzaa();
        }
        if (i12 == 4) {
            return new zzz(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaa.class) {
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
