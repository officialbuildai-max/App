package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzabe extends zzatu implements zzavg {
    private static final zzabe zzb;
    private static volatile zzavn zze;
    private int zzf = 0;
    private Object zzg;

    static {
        zzabe zzabeVar = new zzabe();
        zzb = zzabeVar;
        zzatu.zzaE(zzabe.class, zzabeVar);
    }

    private zzabe() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"zzg", "zzf", zzvw.class});
        }
        if (i12 == 3) {
            return new zzabe();
        }
        if (i12 == 4) {
            return new zzabd(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzabe.class) {
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
