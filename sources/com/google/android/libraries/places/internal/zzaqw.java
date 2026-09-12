package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaqw extends zzatu implements zzavg {
    private static final zzaqw zzb;
    private static volatile zzavn zze;
    private zzaub zzf = zzatu.zzaw();

    static {
        zzaqw zzaqwVar = new zzaqw();
        zzb = zzaqwVar;
        zzatu.zzaE(zzaqw.class, zzaqwVar);
    }

    private zzaqw() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001&", new Object[]{"zzf"});
        }
        if (i12 == 3) {
            return new zzaqw();
        }
        if (i12 == 4) {
            return new zzaqv(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaqw.class) {
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
